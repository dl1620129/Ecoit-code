package com.ecoit.ldap.api;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ldap.util.DataResponse;
import com.ldap.util.DataResponse.DataType;
import com.ldap.util.LdapUtil;
import com.ldap.util.ResponseCode;
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.CookieNotSupportedException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PasswordExpiredException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.software.cms.service.ArticleLocalServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
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

public class LdapResource {
	private static LdapResource instance = null;
	public static LdapResource getInstance() {
		if (instance == null) {
			instance = new LdapResource();
		}
		return instance;
	}
	
	@GET
	@Path("/get-list-user/{orgId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetListUser(@Context HttpServletRequest request,@PathParam("orgId") long orgId) {
		ObjectMapper mapper = new ObjectMapper();
		DirContext dctx = null;
		try {
			long companyId = PortalUtil.getCompanyId(request);
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchCtrls.setReturningAttributes(LdapUtil.returnAttributes);
			NamingEnumeration values = dctx.search(LdapUtil.OU_USER()+LdapUtil.DOMAIN(),LdapUtil.filter,searchCtrls);
			ObjectNode objectNode = mapper.createObjectNode();
			ArrayNode arrayNode = mapper.createArrayNode();
			List<Organization> lstOrganizations = OrganizationLocalServiceUtil.getOrganizations(companyId, orgId);
			List<Organization> lstOrganizationsNew = new ArrayList<Organization>();
			Organization organ = null;
			try{
				organ = OrganizationLocalServiceUtil.getOrganization(orgId);
				lstOrganizationsNew.add(organ);
				lstOrganizationsNew.addAll(lstOrganizations);
			}catch (Exception e) {
				organ = null;
			}
			int i = 0;
			while (values.hasMoreElements()){
				SearchResult result = (SearchResult) values.next();
				Attributes attribs = result.getAttributes();
				if(result.getAttributes().get("zimbraIsSystemResource") == null) {
					if (attribs != null){
						long userId = responseEntryUserId(companyId, result.getAttributes().get("uid").get().toString(), "");
						for(Organization organization : lstOrganizationsNew) {
							if(OrganizationLocalServiceUtil.hasUserOrganization(userId, organization.getOrganizationId())) {
								ObjectNode node = mapper.createObjectNode();
								for (NamingEnumeration ae = attribs.getAll(); ae.hasMore();){
									Attribute atr = (Attribute) ae.next();
									String attributeID = atr.getID();
									for (NamingEnumeration vals = atr.getAll(); vals.hasMore();) {
										String attValue = (String)vals.next();
											node.put(attributeID, attValue); 
											if(attributeID.equals("uid")) {
												node.putPOJO("OrganizationIds", getUserOrganizations(companyId, attValue,""));
												node.putPOJO("RoleIds", responseEntryUserRoles(companyId,attValue, ""));
												node.putPOJO("GroupIds", responseEntryUserGroups(companyId,attValue, ""));
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
								}
								arrayNode.addPOJO(node);
								i ++;
							}
						}
					}
				}
			}
			objectNode.put("total", i);
			objectNode.putPOJO("users", arrayNode);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                    dctx = null;
                } catch (final NamingException e) {
                    _log.error("Error in closing ldap " + e);
                }
            }
		}
		return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
	}
	@POST
	@Path("/get-user-login/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse getUserLogin(@DefaultValue("") @PathParam("uid") String uid,
			@Context HttpServletRequest request) {
		if(uid.equals("")) return DataResponse.PARAM_ERROR;
		uid = HtmlUtil.escape(uid);
		DirContext dctx = null;
		long companyId = PortalUtil.getCompanyId(request);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		ArrayNode arrayNode = mapper.createArrayNode();
		try {
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchCtrls.setReturningAttributes(LdapUtil.returnAttributesLogin);
			String finder = "uid="+uid+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
			System.out.println(finder);
			NamingEnumeration values = dctx.search(finder,LdapUtil.filter,searchCtrls);
			while (values.hasMoreElements()){
				SearchResult result = (SearchResult) values.next();
				Attributes attribs = result.getAttributes();
				if (attribs != null){
					node = mapper.createObjectNode();
					for (NamingEnumeration ae = attribs.getAll(); ae.hasMore();){
						Attribute atr = (Attribute) ae.next();
						String attributeID = atr.getID();
						for (NamingEnumeration vals = atr.getAll(); vals.hasMore();) {
							node.put(attributeID, vals.next()+""); 
						}
					}
					Attribute pwd = attribs.get("userPassword");
					String ps = new String((byte[])pwd.get());
					node.put("password", ps); 
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			_log.error(e);
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
		}
		
	}
	@POST
	@Path("/update-user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateUser(@DefaultValue("") @PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		if(userId <= 0) return DataResponse.PARAM_ERROR;
		String screenName = "";
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			screenName = user.getScreenName();
		} catch (PortalException e1) {
			return DataResponse.FAILED;
		}
		String password = HtmlUtil.escape(ParamUtil.getString(request, "password", ""));
		String rePassword = HtmlUtil.escape(ParamUtil.getString(request, "rePassword", ""));
		String phone = HtmlUtil.escape(ParamUtil.getString(request, "phone", ""));
		String errorMess = "";
		JsonNode jsonNode = null;
		boolean flag = false;
		if(!password.equals("")) {
			if(!password.equals(rePassword)) {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "Passwords do not match", DataType.JSON_STR);
			}
		}
		try {
			DirContext dctx = null;
			try {
				dctx = new InitialDirContext(LdapUtil.initLDAP());
				flag = updateUserEntryLdap(request,dctx,screenName);
				if(flag) {
					if(user.getPhones() !=null && user.getPhones().size() > 0) {
						for(Phone phone2 : user.getPhones()) {
							if(!phone.equals(""))PhoneLocalServiceUtil.updatePhone(phone2.getPhoneId(), phone,  "", 11008, true);
						}
					}
					
					jsonNode = responseEntry(request,dctx, screenName);
				}
			} catch (Exception e) {
			}finally {
				if (null != dctx) {
	                try {
	                    dctx.close();
	                    dctx = null;
	                } catch (final NamingException e) {
	                    _log.error("Error in closing ldap " + e.getMessage());
	                }
	            }
			}
			
		}catch (Exception e) {
			if (e instanceof CompanyMaxUsersException ||
					 e instanceof CookieNotSupportedException ||
					 e instanceof NoSuchUserException ||
					 e instanceof PasswordExpiredException ||
					 e instanceof UserIdException ||
					 e instanceof UserLockoutException ||
					 e instanceof UserPasswordException ||
					 e instanceof UserScreenNameException) {
				if(e.getClass().equals(UserPasswordException.class))
				{
					errorMess = "Mật khẩu mới trùng với mật khẩu cũ";
				}else {
					errorMess = e.getMessage();
				}
			}
		}
		if(flag) {
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, jsonNode, DataType.JSON_STR);
		}else {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, errorMess, DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create-user/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse createUser(@DefaultValue("1") @PathParam("type") int type,
			@Context HttpServletRequest request) {
		String screenName = HtmlUtil.escape(ParamUtil.getString(request, "screenName", ""));
		String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
		String email = HtmlUtil.escape(ParamUtil.getString(request, "email", ""));
		String bDay = HtmlUtil.escape(ParamUtil.getString(request, "birthDay", ""));
		if(screenName.equals(""))return DataResponse.PARAM_ERROR;
		if(email.equals(""))return DataResponse.PARAM_ERROR;
		if(fullName.equals(""))return DataResponse.PARAM_ERROR;
		if(bDay.equals(""))return DataResponse.PARAM_ERROR;
		boolean flag = false;
		String errorMess = "";
		if(type == 1) {
			try {
				flag = addEntryLdap(request);
				if(flag)addUserPortal(request);
			} catch (Exception e) {
				if (e instanceof CompanyMaxUsersException ||
						 e instanceof CookieNotSupportedException ||
						 e instanceof NoSuchUserException ||
						 e instanceof PasswordExpiredException ||
						 e instanceof UserEmailAddressException ||
						 e instanceof UserIdException ||
						 e instanceof UserLockoutException ||
						 e instanceof UserPasswordException ||
						 e instanceof UserScreenNameException) {
					if(e.getClass().equals(UserPasswordException.class))
					{
						errorMess = "Mật khẩu mới trùng với mật khẩu cũ";
					}else{
						errorMess = e.getClass().getName();
					}
					
				}else if( e instanceof UserScreenNameException) {
					errorMess = "Trùng tên đăng nhập";
				}
				else {
					errorMess = e.getMessage();
				}
				flag = false;
				DeleteUserOnFaill(screenName);
			}
			
		}else if(type == 2) {
			try {
				flag = EditEntryLdap(request);
				if(flag)addUserPortal(request);
			} catch (Exception e) {
				e.printStackTrace();
				if (e instanceof CompanyMaxUsersException ||
						 e instanceof CookieNotSupportedException ||
						 e instanceof NoSuchUserException ||
						 e instanceof PasswordExpiredException ||
						 e instanceof UserEmailAddressException ||
						 e instanceof UserIdException ||
						 e instanceof UserLockoutException ||
						 e instanceof UserPasswordException ||
						 e instanceof UserScreenNameException) {
					if(e.getClass().equals(UserPasswordException.class))
					{
						errorMess = "Mật khẩu mới trùng với mật khẩu cũ";
					}else{
						errorMess = e.getClass().getName();
					}
					
				}else if( e instanceof UserScreenNameException) {
					errorMess = "Trùng tên đăng nhập";
				}
				else {
					errorMess = e.getMessage();
				}
				flag = false;
			}
		}
		DirContext dctx = null;
		JsonNode jsonNode = null;
		try {
			if(flag) {
				dctx = new InitialDirContext(LdapUtil.initLDAP());
				jsonNode = responseEntry(request,dctx, screenName);
			}
		} catch (Exception e) {
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                    dctx = null;
                } catch (final NamingException e) {
                    _log.error("Error in closing ldap " + e.getMessage());
                }
            }
		}
		if(flag) 	
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, jsonNode, DataType.JSON_STR);
		else 
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, errorMess, DataType.JSON_STR);
	}
	
	
	@GET
	@Path("/get-user-by-cn/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetUserByCN(@Context HttpServletRequest request,@DefaultValue("1") @PathParam("type") int type,@DefaultValue("") @QueryParam("cn") String cn) {
		if(cn.equals(""))return DataResponse.PARAM_ERROR;
		DirContext dctx = null;
		JsonNode jsonNode = null;
		try {
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			if(type == 1) {
				jsonNode = responseEntry(request,dctx, cn);
			}else {
				jsonNode = responseEntryByMail(request,dctx, cn);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, jsonNode, DataType.JSON_STR);
		} catch (Exception e) {
			_log.error(e.toString());
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                    dctx = null;
                } catch (final NamingException e) {
                    _log.error("Error in closing ldap " + e);
                }
            }
		}
		return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
	}
	
	/**
	 * @param type 
	 * 			= 1 active user
	 * 			= 2 inactive user
	 *  @param userId
	 *  @param cn : uid user LDAP
	 */
	@GET
	@Path("/active-user/{groupId}/{type}/{cn}")
	@Produces(MediaType.APPLICATION_JSON)
	public DataResponse ActiveUser(@Context HttpServletRequest request,
									@DefaultValue("-1") @PathParam("groupId") long groupId,
									@DefaultValue("1") @PathParam("type") int type,
									@DefaultValue("") @PathParam("cn") String cn) {
		if(groupId <= 0)return DataResponse.PARAM_ERROR;
		if(cn.equals(""))return DataResponse.PARAM_ERROR;
		ServiceContext serviceContext = new ServiceContext();
		DirContext dctx = null;
		JsonNode jsonNode = null;
		long companyId = PortalUtil.getCompanyId(request);
		try {
			serviceContext.setScopeGroupId(groupId);
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			if(type == 1) {
				User user = UserLocalServiceUtil.getUserByScreenName(companyId, cn);
				if(Validator.isNotNull(user)) {
					user = UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED,serviceContext);
					Attribute zimbraAccountStatus = new BasicAttribute("zimbraAccountStatus","active");
					ModificationItem[] modificationItems = new ModificationItem[1];
					modificationItems[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, zimbraAccountStatus);
					String finderCn = "uid="+user.getScreenName()+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
		            dctx.modifyAttributes(finderCn, modificationItems);
				}else {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT USER: "+cn, DataType.JSON_STR);
				}
			}else if(type == 2){
				User user = UserLocalServiceUtil.getUserByScreenName(companyId, cn);
				if(Validator.isNotNull(user)) {
					user = UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE,serviceContext);
					Attribute zimbraAccountStatus = new BasicAttribute("zimbraAccountStatus","locked");
					ModificationItem[] modificationItems = new ModificationItem[1];
					modificationItems[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, zimbraAccountStatus);
					String finderCn = "uid="+user.getScreenName()+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
		            dctx.modifyAttributes(finderCn, modificationItems);
				}else {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT USER: "+cn, DataType.JSON_STR);
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, null, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e.toString());
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                    dctx = null;
                } catch (final NamingException e) {
                    _log.error("Error in closing ldap " + e);
                }
            }
		}
		return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
	}
	
	@GET
	@Path("/search-list-user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse SearchListUser(@DefaultValue("") @QueryParam("q") String q,@Context HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		DirContext dctx = null;
		try {
			long companyId = PortalUtil.getCompanyId(request);
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchCtrls.setReturningAttributes(LdapUtil.returnAttributes);
			String searchFilter = "";
			if(!q.equals("")) {
				searchFilter = "(&(objectClass=*)(|(uid=" + q + "*)(|(mail=" + q + "*)(|(displayName=" + q + "*)))))";
			}else {
				searchFilter = LdapUtil.filter;
			}
			NamingEnumeration values = dctx.search(LdapUtil.OU_USER()+LdapUtil.DOMAIN(),searchFilter,searchCtrls);
			ObjectNode objectNode = mapper.createObjectNode();
			ArrayNode arrayNode = mapper.createArrayNode();
			
			int i = 0;
			while (values.hasMoreElements()){
				SearchResult result = (SearchResult) values.next();
				Attributes attribs = result.getAttributes();
				if(result.getAttributes().get("zimbraIsSystemResource") == null) {
					if (attribs != null){
						ObjectNode node = mapper.createObjectNode();
						for (NamingEnumeration ae = attribs.getAll(); ae.hasMore();){
							Attribute atr = (Attribute) ae.next();
							String attributeID = atr.getID();
							for (NamingEnumeration vals = atr.getAll(); vals.hasMore();) {
								String attValue = (String)vals.next();
								node.put(attributeID, attValue); 
								if(attributeID.equals("uid")) {
									long userId = responseEntryUserId(companyId, attValue, "");
									node.putPOJO("OrganizationIds", getUserOrganizationIds(companyId, attValue,""));
									node.putPOJO("RoleIds", responseEntryUserRoles(companyId,attValue, ""));
									node.putPOJO("GroupIds", responseEntryUserGroups(companyId,attValue, ""));
									node.put("userId", userId);
									if(userId > 0) {
										String sql = "SELECT userrankid,userpoisitiondangid,userpoisitionid FROM portal_user_userrankposition WHERE userid ="+userId;
										List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sql);
										Iterator itr = lstObjects.iterator();
										while (itr.hasNext()) {
											Object [] obj= (Object[])itr.next();
											node.put("capBac", obj[0]+"");
											node.put("chucVuDang", obj[1]+"");
											node.put("chucVu", obj[2]+"");
										}
									}
								} 
							}
						}
						arrayNode.addPOJO(node);
						i ++;
					}
				}
			}
			objectNode.put("total", i);
			objectNode.putPOJO("users", arrayNode);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                    dctx = null;
                } catch (final NamingException e) {
                    _log.error("Error in closing ldap " + e);
                }
            }
		}
		return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
	}
	
	@DELETE
	@Path("/deleteUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteUser(@Context HttpServletRequest request,@DefaultValue("") @QueryParam("cn") String cn) {
		if(cn.equals(""))return  DataResponse.PARAM_ERROR;
		DirContext dctx = null;
		long companyId = PortalUtil.getCompanyId(request);
		try {
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			JsonNode jsonNode = null;
			try {
				jsonNode = responseEntry(request,dctx, cn);
			}catch (Exception e) {
				jsonNode = null;
			}
			if(jsonNode.isNull()) {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
			}else{
				String finder = "uid="+cn+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
				System.out.println("finder: "+finder);
				dctx.destroySubcontext(finder);
				User user = getUserByScreenName(companyId, cn);
				if(Validator.isNotNull(user)) {
					UserLocalServiceUtil.deleteUser(user);
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, null, DataType.JSON_STR);
			}
		}catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                    dctx = null;
                } catch (final NamingException e) {
                    _log.error("Error in closing ldap " + e);
                }
            }
		}
		return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, null, DataType.JSON_STR);
	}
	
	public static void DeleteUserOnFaill(String uid) {
		if(!uid.equals("")) {
			DirContext dctx = null;
			try {
				dctx = new InitialDirContext(LdapUtil.initLDAP());
				String finder = "uid="+uid+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
				System.out.println("finder: "+finder);
				dctx.destroySubcontext(finder);
			}catch (Exception e) {
				_log.error(e.getMessage());
			}finally {
				if (null != dctx) {
	                try {
	                    dctx.close();
	                    dctx = null;
	                } catch (final NamingException e) {
	                    _log.error("Error in closing ldap " + e);
	                }
	            }
			}
		}
	}
	
	public static boolean addEntryLdap(HttpServletRequest request) {
		boolean flag = true;
		String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
		String phone = HtmlUtil.escape(ParamUtil.getString(request, "phone", ""));
		String email = HtmlUtil.escape(ParamUtil.getString(request, "email", ""));
		String bDay = HtmlUtil.escape(ParamUtil.getString(request, "birthDay", ""));
		String sexPr = HtmlUtil.escape(ParamUtil.getString(request, "sex", ""));
		String screenName = HtmlUtil.escape(ParamUtil.getString(request, "screenName", ""));
		String chucVu = HtmlUtil.escape(ParamUtil.getString(request, "chucVu", ""));
		String password = HtmlUtil.escape(ParamUtil.getString(request, "password", ""));
		String rePassword = HtmlUtil.escape(ParamUtil.getString(request, "rePassword", ""));
		if(!password.equals(rePassword)) {
			flag = false;
		}else {
			screenName = StringUtil.toLowerCase(StringUtil.trim(screenName));
			String domain = (!email.equals(""))?email.substring(email.indexOf("@")+1, email.length()):"";
			String firstName = LdapUtil.getFirstName(fullName);
			String middleName = LdapUtil.getMiddleName(fullName);
			String lastName = LdapUtil.getLastName(fullName);
			System.out.println(firstName+"-"+middleName+"-"+lastName);
			DirContext dctx = null;
			UUID uuid = UUID.randomUUID();
			System.out.println(domain +" - "+ uuid);
			try {
				dctx = new InitialDirContext(LdapUtil.initLDAP());
				Attribute oc = new BasicAttribute("objectClass");
				oc.add("amavisAccount");
				oc.add("inetOrgPerson");
				oc.add("zimbraAccount");
				oc.add("top");
				Attribute uid = new BasicAttribute("uid", screenName);
				Attribute cn = new BasicAttribute("cn", screenName);
				Attribute sn = new BasicAttribute("sn", firstName);
				Attribute initials = new BasicAttribute("initials", middleName);
				Attribute givenName = new BasicAttribute("givenName", lastName);
				Attribute displayName = new BasicAttribute("displayName", fullName);
				Attribute mail = new BasicAttribute("mail", email);
				Attribute userPassword = new BasicAttribute("userPassword", password);
				Attribute mobile = new BasicAttribute("mobile", phone);
				Attribute sex = new BasicAttribute("sex", sexPr);
				Attribute birthDay = new BasicAttribute("birthDay", bDay);
				Attribute title = new BasicAttribute("title", chucVu);
				Attribute zimbraAccountStatus = new BasicAttribute("zimbraAccountStatus","active");
		        Attribute zimbraPrefSortOrder = new BasicAttribute("zimbraPrefSortOrder","BDLV:,CAL:,CLV:,CLV-main:dateDesc,CNS:,CNSRC:,CNTGT:,CV:,TKL:,TV:");
		        Attribute zimbraMailDeliveryAddress = new BasicAttribute("zimbraMailDeliveryAddress",email);
		        Attribute zimbraMailTransport = new BasicAttribute("zimbraMailTransport","lmtp:mail."+domain+":7025");
		        Attribute zimbraMailStatus = new BasicAttribute("zimbraMailStatus","enabled");
		        Attribute zimbraMailHost = new BasicAttribute("zimbraMailHost","mail."+domain);
		        Attribute zimbraPasswordMustChange = new BasicAttribute("zimbraPasswordMustChange","FALSE");
				Attribute zimbraId = new BasicAttribute("zimbraId",uuid.toString());
				Attributes entry = new BasicAttributes();
				entry.put(oc);
				entry.put(cn);
				entry.put(displayName);
				entry.put(mail);
				entry.put(uid);
			    entry.put(sn);
			    if(!phone.equals(""))entry.put(mobile);
			    entry.put(givenName);
			    if(!middleName.equals(""))entry.put(initials);
			    if(!chucVu.equals(""))entry.put(title);
				entry.put(userPassword);
				entry.put(zimbraAccountStatus);
				entry.put(zimbraId);
				entry.put(zimbraPrefSortOrder);
				entry.put(zimbraMailDeliveryAddress);
				entry.put(zimbraMailTransport);
			    entry.put(zimbraMailStatus);
			    entry.put(zimbraMailHost);
			    entry.put(zimbraPasswordMustChange);
				String finderCn = "uid="+screenName+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
				System.out.println(finderCn);
				dctx.createSubcontext(finderCn, entry);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}finally {
				if (null != dctx) {
	                try {
	                    dctx.close();
	                } catch (final NamingException e) {
	                    System.out.println("Error in closing ldap " + e);
	                }
	            }
			}
		}
		return flag;
	}
	
	public static boolean updateUserEntryLdap(HttpServletRequest request,DirContext dctx,String screenName) {
		boolean flag = true;
		String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
		String phone = HtmlUtil.escape(ParamUtil.getString(request, "phone", ""));
		String password = HtmlUtil.escape(ParamUtil.getString(request, "password", ""));
		try {
			String firstName = LdapUtil.getFirstName(fullName);
			String middleName = LdapUtil.getMiddleName(fullName);
			String lastName = LdapUtil.getLastName(fullName);
			Attribute oc = new BasicAttribute("objectClass");
			oc.add("amavisAccount");
			oc.add("inetOrgPerson");
			oc.add("zimbraAccount");;
			oc.add("top");
			HashMap<Integer, Attribute> hashMap = new HashMap<Integer, Attribute>();
			Attribute sn = new BasicAttribute("sn", firstName);
			hashMap.put(1, sn);
			if(!middleName.equals("")) {
				Attribute initials = new BasicAttribute("initials", middleName);
				hashMap.put(2, initials);
			}
			Attribute givenName = new BasicAttribute("givenName", lastName);
			hashMap.put(3, givenName);
			Attribute displayName = new BasicAttribute("displayName", fullName);
			hashMap.put(4, displayName);
			if(!password.equals("")) {
				Attribute userPassword = new BasicAttribute("userPassword", password);
				hashMap.put(5, userPassword);
			}
			if(!phone.equals("")) {
				Attribute mobile = new BasicAttribute("mobile", phone);
				hashMap.put(6, mobile);
			}
			int total = hashMap.size();
			ModificationItem[] modificationItems = new ModificationItem[total];
			int i = 0;
			for(Attribute attr : hashMap.values()) {
				modificationItems[i] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
				i++;
			}
            String finderCn = "uid="+screenName+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
            dctx.modifyAttributes(finderCn, modificationItems);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public static boolean EditEntryLdap(HttpServletRequest request) {
		boolean flag = true;
		DirContext dctx = null;
		String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
		String phone = HtmlUtil.escape(ParamUtil.getString(request, "phone", ""));
		String email = HtmlUtil.escape(ParamUtil.getString(request, "email", ""));
		String bDay = HtmlUtil.escape(ParamUtil.getString(request, "birthDay", ""));
		String sexPr = HtmlUtil.escape(ParamUtil.getString(request, "sex", ""));
		String screenName = HtmlUtil.escape(ParamUtil.getString(request, "screenName", ""));
		String password = HtmlUtil.escape(ParamUtil.getString(request, "password", ""));
		String rePassword = HtmlUtil.escape(ParamUtil.getString(request, "rePassword", ""));
		String chucVu = HtmlUtil.escape(ParamUtil.getString(request, "chucVu", ""));
		try {
			dctx = new InitialDirContext(LdapUtil.initLDAP());
			String domain = (!email.equals(""))?email.substring(email.indexOf("@")+1, email.length()):"";
			String firstName = LdapUtil.getFirstName(fullName);
			String middleName = LdapUtil.getMiddleName(fullName);
			String lastName = LdapUtil.getLastName(fullName);
			Attribute oc = new BasicAttribute("objectClass");
			oc.add("amavisAccount");
			oc.add("inetOrgPerson");
			oc.add("zimbraAccount");;
			oc.add("top");
			HashMap<Integer, Attribute> hashMap = new HashMap<Integer, Attribute>();
			//Attribute uid = new BasicAttribute("uid", screenName);
			//Attribute cn = new BasicAttribute("cn", screenName);
			//Attribute sn = new BasicAttribute("sn", screenName);
			Attribute sn = new BasicAttribute("sn", firstName);
			hashMap.put(1, sn);
			if(!middleName.equals("")) {
				Attribute initials = new BasicAttribute("initials", middleName);
				hashMap.put(2, initials);
			}
			Attribute givenName = new BasicAttribute("givenName", lastName);
			hashMap.put(3, givenName);
			Attribute displayName = new BasicAttribute("displayName", fullName);
			hashMap.put(4, displayName);
			Attribute mail = new BasicAttribute("mail", email);
			hashMap.put(5, mail);
			if(!password.equals("")) {
				Attribute userPassword = new BasicAttribute("userPassword", password);
				hashMap.put(6, userPassword);
			}
			if(!phone.equals("")) {
				Attribute mobile = new BasicAttribute("mobile", phone);
				hashMap.put(7, mobile);
			}
			//Attribute title = new BasicAttribute("title", chucVu);
			Attribute sex = new BasicAttribute("sex", sexPr);
			
			//Attribute birthDay = new BasicAttribute("birthDay", bDay);
			//Attribute zimbraAccountStatus = new BasicAttribute("zimbraAccountStatus","active");
	        //Attribute zimbraPrefSortOrder = new BasicAttribute("zimbraPrefSortOrder","BDLV:,CAL:,CLV:,CLV-main:dateDesc,CNS:,CNSRC:,CNTGT:,CV:,TKL:,TV:");
	        //Attribute zimbraMailDeliveryAddress = new BasicAttribute("zimbraMailDeliveryAddress",screenName+domain);
	        //Attribute zimbraMailTransport = new BasicAttribute("zimbraMailTransport","lmtp:mail."+domain);
	        //Attribute zimbraMailStatus = new BasicAttribute("zimbraMailStatus","enabled");
	        //Attribute zimbraMailHost = new BasicAttribute("zimbraMailHost","mail."+domain);
	        //Attribute zimbraPasswordMustChange = new BasicAttribute("zimbraPasswordMustChange","false");
			int total = hashMap.size();
			System.out.println("total: "+total);
			ModificationItem[] modificationItems = new ModificationItem[total];
			int i = 0;
			for(Attribute attr : hashMap.values()) {
				modificationItems[i] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
				i++;
			}
            String cnStr = "";
            String dc = "";
            String finderCn = "uid="+screenName+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
            dctx.modifyAttributes(finderCn, modificationItems);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally {
			if (null != dctx) {
                try {
                    dctx.close();
                } catch (final NamingException e) {
                    System.out.println("Error in closing ldap " + e);
                }
            }
		}
		return flag;
	}
	
	public static JsonNode responseEntry(HttpServletRequest request,DirContext dctx, String cn) {
		long companyId = PortalUtil.getCompanyId(request);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		ArrayNode arrayNode = mapper.createArrayNode();
		try {
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchCtrls.setReturningAttributes(LdapUtil.returnAttributes);
			String finder = "uid="+cn+","+LdapUtil.OU_USER()+LdapUtil.DOMAIN();
			System.out.println(finder);
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
					long userId = responseEntryUserId(companyId, cn, "");
					node.putPOJO("OrganizationIds", getUserOrganizationIds(companyId, cn,""));
					node.putPOJO("RoleIds", responseEntryUserRoles(companyId,cn, ""));
					node.putPOJO("GroupIds", responseEntryUserGroups(companyId,cn, ""));
					node.put("userId", userId);
					if(userId > 0) {
						String sql = "SELECT userrankid,userpoisitiondangid,userpoisitionid FROM portal_user_userrankposition WHERE userid ="+userId;
						List<Object> lstObjects = ArticleLocalServiceUtil.getDuLieuTheoSql(sql);
						Iterator itr = lstObjects.iterator();
						while (itr.hasNext()) {
							Object [] obj= (Object[])itr.next();
							node.put("capBac", obj[0]+"");
							node.put("chucVuDang", obj[1]+"");
							node.put("chucVu", obj[2]+"");
						}
					}
				}
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
			_log.error(e);
		}
		return node;
	}
	
	public static JsonNode responseEntryByMail(HttpServletRequest request,DirContext dctx, String mail) {
		long companyId = PortalUtil.getCompanyId(request);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		ArrayNode arrayNode = mapper.createArrayNode();
		try {
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			searchCtrls.setReturningAttributes(LdapUtil.returnAttributes);
			String finder = "(&(objectClass=*)(mail=" + mail + "))";
			System.out.println(finder);
			NamingEnumeration values = dctx.search(LdapUtil.OU_USER()+LdapUtil.DOMAIN(),finder,searchCtrls);
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
					node.putPOJO("OrganizationIds", getUserOrganizationIds(companyId,"", mail));
					node.putPOJO("RoleIds", responseEntryUserRoles(companyId,"", mail));
					node.putPOJO("GroupIds", responseEntryUserGroups(companyId,"", mail));
					node.put("userId", responseEntryUserId(companyId, "", mail));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return node;
	}
	public static long responseEntryUserId(long companyId, String cn,String mail) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = null;
		node = mapper.createObjectNode();
		User user = null;
		if(!cn.equals("")) {
			user = getUserByScreenName(companyId, cn);
		}
		if(!mail.equals("")) {
			user = getUserByEnmail(companyId, mail);
		}
		if(user != null) {
			return user.getUserId();
		}
		return 0;
	}
	public static ArrayNode responseEntryUserRoles(long companyId, String cn,String mail) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		User user = null;
		if(!cn.equals("")) {
			user = getUserByScreenName(companyId, cn);
		}
		if(!mail.equals("")) {
			user = getUserByEnmail(companyId, mail);
		}
		if(user != null) {
			for(Role role : user.getRoles()) {
				String name = "";
				try {
					name = role.getDescriptiveName();
				} catch (Exception e) {
					name = "";
				}
				ObjectNode node = mapper.createObjectNode();
				node.put("ID", role.getRoleId());
				node.put("name", name);
				arrayNode.add(node);
			}
		}
		return arrayNode;
	}
	public static ArrayNode getUserOrganizations(long companyId, String cn, String email) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		User user = null;
		try {
			if(!cn.equals("")) {
				user = getUserByScreenName(companyId, cn);
			}
			if(!email.equals("")) {
				user = getUserByEnmail(companyId, email);
			}
			if(user != null) {
				for(Organization organization : user.getOrganizations()) {
					ObjectNode node = mapper.createObjectNode();
					node.put("ID", organization.getOrganizationId());
					node.put("name", organization.getName());
					arrayNode.add(node);
				}
			}
		} catch (Exception e) {
			return arrayNode;
		}
		return arrayNode;
	}
	
	public static ArrayNode responseEntryUserGroups(long companyId, String cn,String mail) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		User user = null;
		if(!cn.equals("")) {
			user = getUserByScreenName(companyId, cn);
		}
		if(!mail.equals("")) {
			user = getUserByEnmail(companyId, mail);
		}
		if(user != null) {
			for(Group group : user.getGroups()) {
				ObjectNode node = mapper.createObjectNode();
				String name = "";
				try {
					name = group.getDescriptiveName();
				} catch (Exception e) {
					name = "";
				}
				node.put("ID", group.getGroupId());
				node.put("name", name);
				arrayNode.add(node);
			}
			
		}
		return arrayNode;
	}
	public static long[] getUserOrganizationIds(long companyId, String cn, String email) {
		try {
			if(!cn.equals(""))
				return getUserByScreenName(companyId, cn).getOrganizationIds();
			if(!email.equals(""))
				return getUserByEnmail(companyId, email).getOrganizationIds();
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	public static User getUserByScreenName(long companyId, String cn) {
		try {
			return UserLocalServiceUtil.getUserByScreenName(companyId, cn);
		} catch (Exception e) {
			return null;
		}
		
	}
	public static User getUserByEnmail(long companyId, String email) {
		try {
			return UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
		} catch (Exception e) {
			return null;
		}
		
	}
	public void addUserPortal(HttpServletRequest request) throws Exception {
		ServiceContext serviceContext = new ServiceContext();
		long userId = ParamUtil.getLong(request, "userId", -1);
		long groupId = ParamUtil.getLong(request, "groupId", -1);
		String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
		String phone = HtmlUtil.escape(ParamUtil.getString(request, "phone", ""));
		String email = HtmlUtil.escape(ParamUtil.getString(request, "email", ""));
		String bDay = HtmlUtil.escape(ParamUtil.getString(request, "birthDay", ""));
		String sexPr = HtmlUtil.escape(ParamUtil.getString(request, "sex", "1"));
		long organizationId = ParamUtil.getLong(request, "organizationId",-1);
		String screenName = HtmlUtil.escape(ParamUtil.getString(request, "screenName", ""));
		String password = HtmlUtil.escape(ParamUtil.getString(request, "password", ""));
		String rePassword = HtmlUtil.escape(ParamUtil.getString(request, "rePassword", ""));
		boolean isResetPassword = ParamUtil.getBoolean(request, "resetPassword", false);
		String chucVu = HtmlUtil.escape(ParamUtil.getString(request, "chucVu", ""));
		String [] roleUsers = ParamUtil.getParameterValues(request, "RoleIds",null);
		String [] groupSiteUser = ParamUtil.getParameterValues(request, "GroupIds",null);
		serviceContext.setScopeGroupId(groupId);
		Company company = PortalUtil.getCompany(request);
		long companyId = company.getCompanyId();
		String locale = company.getLocale().getLanguage();
		String firstName = LdapUtil.getFirstName(fullName);
		String middleName = LdapUtil.getMiddleName(fullName);
		String lastName = LdapUtil.getLastName(fullName);
		_log.info(fullName+" - "+firstName+" "+middleName+" "+lastName);
		screenName = StringUtil.toLowerCase(StringUtil.trim(screenName));
		boolean sex = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDay = new Date();
		if(!bDay.equals("")) {
			try {
				birthDay = sdf.parse(bDay);
			} catch (ParseException e) {
				birthDay = new Date();
			}
		}
		int birthdayMonth = Calendar.JANUARY;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		try {
			birthdayDay = Integer.valueOf(bDay.split("/")[0]);
			birthdayMonth = (Integer.valueOf(bDay.split("/")[1]) - 1);
			birthdayYear = Integer.valueOf(bDay.split("/")[2]);
		}catch (Exception e) {
		}
		long adminUserId = LdapUtil.getUserIdAdmin(companyId);
		if (sexPr.equals("1")) {
			sex = true;
		} else {
			sex = false;
		}
		long[] orgIds = {organizationId};
		User user = null;
		if(userId == -1) {
			user = UserLocalServiceUtil.addUser(adminUserId, companyId, false, password, rePassword, false, screenName, 
					email, 0, "", PortalUtil.getLocale(request), firstName, middleName, lastName, 0L, 0L, sex, birthdayMonth, birthdayDay, birthdayYear, 
					chucVu, null, orgIds, null, null, false, serviceContext);
			user = UserLocalServiceUtil.updatePasswordReset(user.getUserId(), isResetPassword);
			//PhoneLocalServiceUtil.addPhone(user.getUserId(), className, classPK, number, extension, typeId, primary, serviceContext)
			if(!phone.equals(""))PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), phone, "", 11008, true, serviceContext);
			if ((roleUsers != null && roleUsers.length > 0) && (groupSiteUser != null && groupSiteUser.length > 0)) {
				long[] roleIds = new long[roleUsers.length];
				for (int i = 0; i < roleUsers.length; i++) {
					roleIds[i] = Long.parseLong(roleUsers[i]);
				}
				for (String st : groupSiteUser) {
					UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), Long.parseLong(st), roleIds);
				}
				RoleLocalServiceUtil.addUserRoles(user.getUserId(), roleIds);
				if (groupSiteUser != null && groupSiteUser.length > 0) {
					for (String st : groupSiteUser) {
						UserLocalServiceUtil.addGroupUser(Long.parseLong(st), user.getUserId());
					}
				}else {
					UserGroupLocalServiceUtil.clearUserUserGroups(user.getUserId());
				}
			}
		}else {
			user = UserLocalServiceUtil.fetchUser(userId);
			if(Validator.isNotNull(user)) {
				try {
//					user.setFirstName(firstName);
//					user.setMiddleName(middleName);
//					user.setLastName(lastName);
//					user.setJobTitle(chucVu);
//					user.setModifiedDate(new Date());
//					user = UserLocalServiceUtil.updateUser(user);
					long contactId = user.getContactId();
					Contact contact = ContactLocalServiceUtil.getContact(contactId);
					contact.setBirthday(birthDay);
					contact.setMale(Boolean.valueOf(sex));
					ContactLocalServiceUtil.updateContact(contact);
					if(user.getPhones() != null && user.getPhones().size() > 0) {
						for(Phone phone2 : user.getPhones()) {
							PhoneLocalServiceUtil.updatePhone(phone2.getPhoneId(), phone,  "", 11008, true);
						}
					}else {
						if(!phone.equals(""))PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), phone, "", 11008, true, serviceContext);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(orgIds.length > 0)UserLocalServiceUtil.updateOrganizations(userId, orgIds, serviceContext);
				if (!password.equals("")) {
					user = UserLocalServiceUtil.updatePassword(userId, password, rePassword, isResetPassword);
				}
				user = UserLocalServiceUtil.updatePasswordReset(user.getUserId(), isResetPassword);
				if ((roleUsers != null && roleUsers.length > 0) && (groupSiteUser != null && groupSiteUser.length > 0)) {
					UserGroupRoleLocalServiceUtil.deleteUserGroupRolesByUserId(userId);
					long[] roleIds = new long[roleUsers.length];

					for (int i = 0; i < roleUsers.length; i++) {
						roleIds[i] = Long.parseLong(roleUsers[i]);
					}
					for (String st : groupSiteUser) {
						UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), Long.parseLong(st), roleIds);
					}
					RoleLocalServiceUtil.addUserRoles(user.getUserId(), roleIds);
				}else {
					UserGroupRoleLocalServiceUtil.deleteUserGroupRolesByUserId(userId);
				}
				if (groupSiteUser != null && groupSiteUser.length > 0) {
					UserGroupLocalServiceUtil.clearUserUserGroups(userId);
					for (String st : groupSiteUser) {
						UserLocalServiceUtil.addGroupUser(Long.parseLong(st), user.getUserId());
					}
				}
			}
		}
		
		try {
			Indexer indexer = IndexerRegistryUtil.getIndexer(User.class); 
			indexer.reindex(user);
		} catch (Exception e) {
			System.out.println("error reindex: "+e.getMessage());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(LdapResource.class);
	
}
