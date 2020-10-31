package organizationalStructure.api.Resource;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import organizationalStructure.api.Object.OrganizationObject;
import organizationalStructure.api.Utils.TreeNode;
import organizationalStructure.service.model.organization;
import organizationalStructure.service.service.organizationLocalService;
import organizationalStructure.service.service.organizationLocalServiceUtil;
import organizationalStructure.service.service.utils.DataRespone;
import organizationalStructure.service.service.utils.DataRespone.DataType;
import organizationalStructure.service.service.utils.ResponeCode;

public class OrganizationResource {
	private static OrganizationResource instance = null;

	public static OrganizationResource getInstance() {
		if (instance == null) {
			instance = new OrganizationResource();
		}
		return instance;
	}
	@GET
	@Path("/getall/{groupId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone GetAll(@PathParam("groupId") long groupId, @PathParam("parentId") long parentId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);

			if (groupId < 0 || parentId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			TreeNode treeCategory = new TreeNode();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();

			ArrayNode data = treeCategory.getNodes(parentId, groupId, treeCategory.NODE_PARENT, q, start, limit);

			int total = organizationLocalServiceUtil.getNodeCount(parentId, groupId, q);
			objectNode.put("total", total);
			objectNode.putPOJO("data", data);

			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, objectNode,DataType.JSON_STR);
			
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{groupId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataRespone createOrgan(@PathParam("groupId") long groupId, @PathParam("parentId") long parentId,@Context HttpServletRequest request) {
		OrganizationObject organizationObject= new OrganizationObject();
		try {
			if (groupId < 0 || parentId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			
			String name = HtmlUtil.escape(ParamUtil.getString(request, "name", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String organizationCode= HtmlUtil.escape(ParamUtil.getString(request, "organizationCode",""));
			String address= HtmlUtil.escape(ParamUtil.getString(request, "address",""));
			String phoneNumber= HtmlUtil.escape(ParamUtil.getString(request, "phoneNumber",""));
			int thuTu= ParamUtil.getInteger(request, "thuTu",0);
			long organCoreId= ParamUtil.getLong(request, "organCoreId",0);
		
			
			organization organization= organizationLocalServiceUtil.createorganization(0);
			organization.setName(name);
			organization.setDescription(description);
			organization.setAddress(address);
			organization.setCreateDate(new Date());
			organization.setOrganizationCode(organizationCode);
			organization.setGroupId(groupId);
			organization.setLeader(organization.getLeader());
			organization.setPosition(organizationObject.getPosition());
			organization.setPhoneNumber(phoneNumber);
			organization.setThuTu(thuTu);
			organization.setStatus(organizationObject.getStatus());
			organization.setParentId(parentId);
			organization.setOrganCoreId(organCoreId);
			organization= organizationLocalServiceUtil.addorganization(organization);
		
			organizationObject.setName(organization.getName());
			organizationObject.setDescription(organization.getDescription());
			organizationObject.setAddress(organization.getAddress());
			organizationObject.setCreateDate(organization.getCreateDate());
			organizationObject.setOrganizationCode(organization.getOrganizationCode());
			organizationObject.setGroupId(organization.getGroupId());
			organizationObject.setLeader(organization.getLeader());
			organizationObject.setPosition(organization.getPosition());
			organizationObject.setPhoneNumber(organization.getPhoneNumber());
			organizationObject.setThuTu(organization.getThuTu());
			organizationObject.setStatus(organization.getStatus());
			organizationObject.setOrgCoreId(organization.getOrganCoreId());
			organizationObject.setParentId(organization.getParentId());

			if (parentId != 0) {
				organization organ= organizationLocalServiceUtil.findByorganCoreId(parentId);
				organizationObject.setOrganizationId(organ.getOrganCoreId());
			}
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, organizationObject,DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getOrgan(@PathParam("groupId") long groupId, @PathParam("id") long id) {
		try {
			organization organization= organizationLocalServiceUtil.findByorganCoreId(id);
		
			OrganizationObject object= new OrganizationObject(HtmlUtil.extractText(organization.getName()), organization.getLeader(), HtmlUtil.extractText(organization.getAddress()), HtmlUtil.extractText(organization.getOrganizationCode()), HtmlUtil.extractText(organization.getDescription()), HtmlUtil.extractText(organization.getPosition()), HtmlUtil.extractText(organization.getPhoneNumber()), organization.getOrganizationId(), organization.getGroupId(), organization.getMember(), organization.getParentId(), organization.getCreateUser(), organization.getModifiedUser(), organization.getStatus(),organization.getOrganCoreId(), organization.getThuTu(), organization.getCreateDate(), organization.getModifiedDate());
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, object, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	
	@PUT
	@Path("/update/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataRespone updateOrgan(@PathParam("groupId") long groupId, @PathParam("id") long id,@Context HttpServletRequest request) {
		OrganizationObject organizationObject= new OrganizationObject();
		try {
			if (groupId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			String name = HtmlUtil.escape(ParamUtil.getString(request, "name", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String organizationCode= HtmlUtil.escape(ParamUtil.getString(request, "organizationCode",""));
			String address= HtmlUtil.escape(ParamUtil.getString(request, "address",""));
			String phoneNumber= HtmlUtil.escape(ParamUtil.getString(request, "phoneNumber",""));
			long parentId= ParamUtil.getLong(request, "parentId",0);
			int thuTu= ParamUtil.getInteger(request, "thuTu",0);
			if(id == parentId) {
				return DataRespone.PARAM_ERROR;
			}
			organization organization= organizationLocalServiceUtil.findByorganCoreId(id);
			organization.setName(name);
			organization.setDescription(description);
			organization.setAddress(address);
			organization.setCreateDate(new Date());
			organization.setOrganizationCode(organizationCode);
			organization.setGroupId(groupId);
			organization.setLeader(organization.getLeader());
			organization.setPosition(organizationObject.getPosition());
			organization.setPhoneNumber(phoneNumber);
			organization.setThuTu(thuTu);
			organization.setStatus(organizationObject.getStatus());
			organization.setParentId(parentId);
			organization= organizationLocalServiceUtil.updateorganization(organization);
			System.out.println(organization);
			organizationObject.setName(organization.getName());
			organizationObject.setDescription(organization.getDescription());
			organizationObject.setAddress(organization.getAddress());
			organizationObject.setCreateDate(organization.getCreateDate());
			organizationObject.setOrganizationCode(organization.getOrganizationCode());
			organizationObject.setGroupId(organization.getGroupId());
			organizationObject.setLeader(organization.getLeader());
			organizationObject.setPosition(organization.getPosition());
			organizationObject.setPhoneNumber(organization.getPhoneNumber());
			organizationObject.setThuTu(organization.getThuTu());
			organizationObject.setStatus(organization.getStatus());
			organizationObject.setParentId(organization.getParentId());
			
//			if (parentId != 0) {
//				organization organ= organizationLocalServiceUtil.getorganization(parentId);
//				organizationLocalServiceUtil.updateorganization(organ);
//				organizationObject.setOrganizationId(parentId);
//			}
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, organizationObject,DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@DELETE
	@Path("/delete/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone deleteOrgan(@PathParam("groupId") long groupId, @PathParam("id") long id) {
		try {
			int dem = organizationLocalServiceUtil.getNodeCount(id, groupId, "");
			if(dem == 0) {
				organization organization = organizationLocalServiceUtil.findByorganCoreId(id);
				organizationLocalServiceUtil.deleteorganization(organization);
			}
			else {
				return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, "can not delete", DataType.JSON_STR);
			}
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
