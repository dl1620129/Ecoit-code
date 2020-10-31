package com.ecoit.ldap.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ldap.util.DataResponse;
import com.ldap.util.DataResponse.DataType;
import com.ldap.util.LdapUtil;
import com.ldap.util.ResponseCode;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.DuplicateOrganizationException;
import com.liferay.portal.kernel.model.CountryConstants;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.RegionConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.software.cms.service.ArticleLocalServiceUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

public class OrganizationResource {
	private static OrganizationResource instance = null;
	public static OrganizationResource getInstance() {
		if (instance == null) {
			instance = new OrganizationResource();
		}
		return instance;
	}
	
	@POST
	@Path("/create-organization")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse createOrg(@Context HttpServletRequest request) {
		ServiceContext serviceContext = new ServiceContext();
		long groupId = ParamUtil.getLong(request, "groupId", -1);
		long parentId = ParamUtil.getLong(request, "parentId", -1);
		String organizationName = HtmlUtil.escape(ParamUtil.getString(request, "name"));
		if(groupId == -1)return DataResponse.PARAM_ERROR;
		if(parentId == -1)return DataResponse.PARAM_ERROR;
		if(organizationName.equals(""))return DataResponse.PARAM_ERROR;
		if(parentId == 0) {
			if(checkParentOrg(groupId))return DataResponse.IN_PARENT;
		}
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		try {
			node = mapper.createObjectNode();
			serviceContext.setScopeGroupId(groupId);
			long companyId = PortalUtil.getCompanyId(request);
			long adminUserId = LdapUtil.getUserIdAdmin(companyId);
			Organization organization = null;
			try {
				organization = OrganizationLocalServiceUtil.addOrganization(adminUserId,
						parentId, organizationName, OrganizationConstants.TYPE_ORGANIZATION,
						RegionConstants.DEFAULT_REGION_ID, CountryConstants.DEFAULT_COUNTRY_ID,
						ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, "", false, serviceContext);
			} catch (Exception e) {
				if(e instanceof DuplicateOrganizationException) {
					organization = OrganizationLocalServiceUtil.addOrganization(adminUserId,
							parentId, organizationName+"_DUPLICATE", OrganizationConstants.TYPE_ORGANIZATION,
							RegionConstants.DEFAULT_REGION_ID, CountryConstants.DEFAULT_COUNTRY_ID,
							ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, "", false, serviceContext);
				}
			}
			
			try {
				Indexer indexer = IndexerRegistryUtil.getIndexer(Organization.class); 
				indexer.reindex(organization);
			} catch (Exception e) {
				System.out.println("error reindex: "+e.getMessage());
			}
			node.put("orgId", organization.getOrganizationId());
			node.put("name", organization.getName());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/update-organization/{orgId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateOrg(@Context HttpServletRequest request,@DefaultValue("-1") @PathParam("orgId") long orgId) {
		ServiceContext serviceContext = new ServiceContext();
		if(orgId <= 0)return DataResponse.PARAM_ERROR;
		long groupId = ParamUtil.getLong(request, "groupId", -1);
		long parentId = ParamUtil.getLong(request, "parentId", -1);
		String organizationName = HtmlUtil.escape(ParamUtil.getString(request, "name"));
		if(groupId == -1)return DataResponse.PARAM_ERROR;
		if(parentId == -1)return DataResponse.PARAM_ERROR;
		if(organizationName.equals(""))return DataResponse.PARAM_ERROR;
		if(orgId == parentId)return DataResponse.IN_PARENT;
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		try {
			node = mapper.createObjectNode();
			serviceContext.setScopeGroupId(groupId);
			Organization organization = OrganizationLocalServiceUtil.getOrganization(orgId);
			organization.setModifiedDate(new Date());
			organization.setName(organizationName);
			organization.setParentOrganizationId(parentId);
			organization.setCountryId(CountryConstants.DEFAULT_COUNTRY_ID);
			organization.setRegionId(RegionConstants.DEFAULT_REGION_ID);
			try {
				organization = OrganizationLocalServiceUtil.updateOrganization(organization);
			} catch (Exception e) {
				if(e instanceof SecurityException) {
					System.out.println("SecurityException: "+e.getMessage());
				}
			}
			try {	
				Indexer indexer = IndexerRegistryUtil.getIndexer(Organization.class); 
				indexer.reindex(organization);
			} catch (Exception e) {
				System.out.println("error reindex: "+e.getMessage());
			}
			node.put("orgId", organization.getOrganizationId());
			node.put("name", organization.getName());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-organization-portal-all/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetOrganizationPortalAll(@Context HttpServletRequest request, @PathParam("groupId") long groupId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			String sql = "SELECT organcoreid,name,parentid FROM portal_organization WHERE groupid = "+groupId+" AND parentid = 0 ";
			List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sql);
			Iterator<Object> itr = lstObjects.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[])itr.next();
				ObjectNode node = mapper.createObjectNode();
				node.put("ID", Long.valueOf(obj[0]+""));
				node.put("name", obj[1]+"");
				node.put("parentId", Long.valueOf(obj[2]+""));
				node.put("parentName", "");
				node.putPOJO("children", jsonPortalOrgan(groupId, Long.valueOf(obj[0]+"")));
				arrayNode.add(node);
				
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-organization-parent-group/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetOrganizationParentGroup(@Context HttpServletRequest request, @PathParam("groupId") long groupId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			String sql = "SELECT organcoreid,name,parentid FROM portal_organization WHERE groupid = "+groupId+" AND parentid = 0 ";
			List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sql);
			Iterator<Object> itr = lstObjects.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[])itr.next();
				ObjectNode node = mapper.createObjectNode();
				node.put("ID", Long.valueOf(obj[0]+""));
				node.put("name", obj[1]+"");
				arrayNode.add(node);
				
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-organization-all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetOrganizationAll(@Context HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			List<Organization> lstOrganizations = OrganizationLocalServiceUtil.getOrganizations(companyId, 0);
			for(Organization organization : lstOrganizations) {
				ObjectNode node = mapper.createObjectNode();
				String sqlQuery = "SELECT organcoreid,name,groupid FROM portal_organization WHERE organcoreid = "+organization.getOrganizationId();
				List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sqlQuery);
				Iterator<Object> itr = lstObjects.iterator();
				while (itr.hasNext()) {
					Object[] obj = (Object[])itr.next();
					node.put("name", obj[1]+"");
					node.put("siteId", Long.valueOf(obj[2]+""));
				}
				
				node.put("ID", organization.getOrganizationId());
				node.put("code", organization.getName());
				node.put("parentId", organization.getParentOrganizationId());
				node.put("parentName", organization.getParentOrganizationName());
				node.putPOJO("children", jsonOrgan(companyId, organization.getOrganizationId()));
				arrayNode.add(node);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/get-organization-no-parent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetOrganizationAllNoParent(@Context HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			List<Organization> lstOrganizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for(Organization organization : lstOrganizations) {
				ObjectNode node = mapper.createObjectNode();
				node.put("ID", organization.getOrganizationId());
				node.put("name", organization.getName());
				node.put("parentId", organization.getParentOrganizationId());
				node.put("parentName", organization.getParentOrganizationName());
				arrayNode.add(node);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/get-role-all/{languageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetRoleAll(@DefaultValue("vi_VN") @PathParam("languageId") String languageId,
			@DefaultValue("") @QueryParam("q") String q,
			@Context HttpServletRequest request) {
		q = HtmlUtil.escape(q);
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			String sqlQuery = "SELECT roleid,name FROM role_ WHERE type_ in ("+RoleConstants.TYPE_REGULAR+","+RoleConstants.TYPE_SITE+") AND LOWER(name) LIKE LOWER('%"+q+"%') ";
			List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sqlQuery);
			Iterator<Object> itr = lstObjects.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[])itr.next();
				ObjectNode node = mapper.createObjectNode();
				Role role = RoleLocalServiceUtil.getRole(Long.valueOf(String.valueOf(obj[0])));
				String nameRole = (!role.getTitle(languageId).equals(""))?role.getTitle(languageId):role.getName();
				node.put("ID", role.getRoleId());
				node.put("name", nameRole);
				arrayNode.add(node);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/get-site-group-all/{languageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetSiteGroupAll(@DefaultValue("vi_VN") @PathParam("languageId") String languageId,
			@DefaultValue("") @QueryParam("q") String q,
			@Context HttpServletRequest request) {
		q = HtmlUtil.escape(q);
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			String sqlQuery = "SELECT groupid,name FROM group_ WHERE site = true AND active_ = true AND type_ = "+GroupConstants.TYPE_SITE_OPEN+" AND LOWER(groupkey) LIKE LOWER('%"+q+"%')";
			List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sqlQuery);
			Iterator<Object> itr = lstObjects.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[])itr.next();
				ObjectNode node = mapper.createObjectNode();
				Group group = GroupLocalServiceUtil.getGroup(Long.valueOf(String.valueOf(obj[0])));
				node.put("ID", group.getGroupId());
				node.put("name", group.getDescriptiveName());
				arrayNode.add(node);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	protected ArrayNode jsonPortalOrgan(long groupId,long id) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		String sql = "SELECT organcoreid,name,parentid FROM portal_organization WHERE groupid = "+groupId+" AND parentid = "+id;
		List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sql);
		Iterator<Object> itr = lstObjects.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[])itr.next();
			ObjectNode node = mapper.createObjectNode();
			node.put("ID", Long.valueOf(obj[0]+""));
			node.put("name", obj[1]+"");
			node.put("parentId", Long.valueOf(obj[2]+""));
			node.put("parentName", "");
			node.putPOJO("children", jsonPortalOrgan(groupId, Long.valueOf(obj[0]+"")));
			arrayNode.add(node);
		}
		return arrayNode;
	}
	protected ArrayNode jsonOrgan(long companyId,long id) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		List<Organization> lstOrganizations = OrganizationLocalServiceUtil.getOrganizations(companyId, id);
		for(Organization organization : lstOrganizations) {
			ObjectNode node = mapper.createObjectNode();
			node.put("ID", organization.getOrganizationId());
			String sqlQuery = "SELECT organcoreid,name FROM portal_organization WHERE organcoreid = "+organization.getOrganizationId();
			List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sqlQuery);
			Iterator<Object> itr = lstObjects.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[])itr.next();
				node.put("name", obj[1]+"");
				node.put("siteId", 0);
			}
			node.put("code", organization.getName());
			node.put("parentId", organization.getParentOrganizationId());
			node.put("parentName", organization.getParentOrganizationName());
			node.putPOJO("children", jsonOrgan(companyId, organization.getOrganizationId()));
			arrayNode.add(node);
		}
		return arrayNode;
	}
	
	
	/**
	 * @param orgId
	 * @param type 
	 * 			= 1 Get org use get child
	 * 			= 2 get org not child
	 */
	@GET
	@Path("/get-organization-by-id/{orgId}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetOrganizationById(@Context HttpServletRequest request, 
											@DefaultValue("-1") @PathParam("orgId") int orgId,
											@DefaultValue("1") @PathParam("type") int type) {
		if(orgId <= 0)return DataResponse.PARAM_ERROR;
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(orgId);
			if(Validator.isNotNull(organization)) {
				node.put("ID", organization.getOrganizationId());
				node.put("name", organization.getName());
				if(type == 2) {
					node.putPOJO("children", jsonOrgan(companyId, organization.getOrganizationId()));
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
		
	}
	
	@DELETE
	@Path("/delete-organization/{orgId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteOrganization(@Context HttpServletRequest request,@DefaultValue("-1") @PathParam("orgId") long orgId) {
		if(orgId <= 0)return DataResponse.PARAM_ERROR;
		long companyId = PortalUtil.getCompanyId(request);
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(orgId);
			
			if(Validator.isNotNull(organization)) {
				int totalOrg = OrganizationLocalServiceUtil.getOrganizationsCount(companyId, organization.getOrganizationId());
				if(totalOrg <= 0) {
					OrganizationLocalServiceUtil.deleteOrganization(organization);
					try {
						Indexer indexer = IndexerRegistryUtil.getIndexer(Organization.class); 
						indexer.reindex(organization);
					} catch (Exception e) {
						System.out.println("error reindex: "+e.getMessage());
					}
					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, null, DataType.JSON_STR);
				}else {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "ORG IN PARENT", DataType.JSON_STR);
				}
			}
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "ORG IS NULL", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-userId-inOrg/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetUserIdInOrg(@Context HttpServletRequest request, @DefaultValue("-1") @PathParam("userId") int userId) {
		if(userId <= 0)return DataResponse.PARAM_ERROR;
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			if(Validator.isNotNull(user)) {
				node.put("userId", user.getUserId());
				node.put("screenName", user.getScreenName());
				node.put("fullName", user.getFullName());
				node.putPOJO("OrganizationIds",user.getOrganizationIds());
				node.putPOJO("Organizations",jsonOrgan(user.getOrganizations()));
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-user-org/{orgId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetUserOrg(@Context HttpServletRequest request, @DefaultValue("-1") @PathParam("orgId") int orgId) {
		if(orgId <= 0)return DataResponse.PARAM_ERROR;
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		long companyId = PortalUtil.getCompanyId(request);
		DirContext dctx = null;
		try {
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			List<User> lstUser = UserLocalServiceUtil.getOrganizationUsers(orgId);
			if(Validator.isNotNull(lstUser)) {
				for(User user : lstUser) {
					JsonNode jsonNode = responseEntry(request, dctx, user.getScreenName(), user.getUserId());
					if(jsonNode != null) {
						arrayNode.add(jsonNode);
					}
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	public static JsonNode responseEntry(HttpServletRequest request,DirContext dctx, String cn, long userId) {
		long companyId = PortalUtil.getCompanyId(request);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		ArrayNode arrayNode = mapper.createArrayNode();
		try {
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchCtrls.setReturningAttributes(LdapUtil.returnAttributes);
			String finder = "uid="+cn+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
			NamingEnumeration values = dctx.search(finder,LdapUtil.filter,searchCtrls);
			ObjectNode objectNode = mapper.createObjectNode();
			while (values.hasMoreElements()){
				SearchResult result = (SearchResult) values.next();
				Attributes attribs = result.getAttributes();
				if (attribs != null){
					node = mapper.createObjectNode();
					for (NamingEnumeration ae = attribs.getAll(); ae.hasMore();){
						Attribute atr = (Attribute) ae.next();
						String attributeID = atr.getID();
						for (NamingEnumeration vals = atr.getAll(); vals.hasMore();) {
							node.put(attributeID, (String)vals.next()); 
						}
					}
					node.putPOJO("OrganizationIds",LdapResource.getUserOrganizations(companyId, cn, ""));
					node.putPOJO("RoleIds", LdapResource.responseEntryUserRoles(companyId,cn, ""));
					node.putPOJO("GroupIds", LdapResource.responseEntryUserGroups(companyId,cn, ""));
					node.put("userId", userId);
					node.put("userId", userId);
					if(userId > 0) {
						String sql = "SELECT B.userpoisitionid,B.userpoisitionname,C.userpoisitiondangid,C.userpoisitiondangname,D.userrankid,D.rankname FROM portal_user_userrankposition A " + 
								"INNER JOIN portal_user_userpoisition B ON A.userpoisitionid=B.userpoisitionid " + 
								"INNER JOIN portal_user_userpoisition_dang C ON A.userpoisitiondangid=C.userpoisitiondangid " + 
								"INNER JOIN portal_user_userrank D ON A.userrankid=D.userrankid " + 
								"WHERE A.userid = "+userId;
						List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sql);
						if(lstObjects !=null && lstObjects.size() > 0) {
							Iterator itr = lstObjects.iterator();
							while (itr.hasNext()) {
								Object [] obj= (Object[])itr.next();
								node.put("chucVuId", obj[0]+"");
								node.put("chucVu", obj[1]+"");
								node.put("chucVuDangId", obj[2]+"");
								node.put("chucVuDang", obj[3]+"");
								node.put("capBacId", obj[4]+"");
								node.put("capBac", obj[5]+"");
							}
						}else {
							node.put("chucVuId","null");
							node.put("chucVu", "null");
							node.put("chucVuDangId", "null");
							node.put("chucVuDang", "null");
							node.put("capBacId", "null");
							node.put("capBac", "null");
						}
						
					}else {
						node.put("chucVuId","null");
						node.put("chucVu", "null");
						node.put("chucVuDangId", "null");
						node.put("chucVuDang", "null");
						node.put("capBacId", "null");
						node.put("capBac", "null");
					}
				}
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return node;
	}
	protected ArrayNode jsonOrgan(List<Organization> lstOrganizations) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		for(Organization organization : lstOrganizations) {
			ObjectNode node = mapper.createObjectNode();
			node.put("ID", organization.getOrganizationId());
			node.put("name", organization.getName());
			node.put("parentId", organization.getParentOrganizationId());
			node.put("parentName", organization.getParentOrganizationName());
			node.putPOJO("children", jsonOrgan(organization.getCompanyId(), organization.getOrganizationId()));
			arrayNode.add(node);
		}
		return arrayNode;
	}
	public boolean checkParentOrg(long groupId) {
		boolean check = false;
		String sql = "SELECT count(*) FROM portal_organization WHERE groupid = "+groupId+" AND parentid = 0 ";
		int total = ArticleLocalServiceUtil.getCountArticleBySQL(sql);
		if(total > 0) {
			check = true;
		}
		return check;
	}
}
