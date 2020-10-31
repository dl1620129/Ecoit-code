package LinkManager.api.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import LinkManager.Service.model.GroupLink;
import LinkManager.Service.model.Links;
import LinkManager.Service.service.GroupLinkLocalServiceUtil;
import LinkManager.Service.service.LinksLocalServiceUtil;
import LinkManager.Service.utils.DataRespone;
import LinkManager.Service.utils.DataRespone.DataType;
import LinkManager.Service.utils.ResponeCode;
import LinkManager.api.object.GroupLinkObject;
import LinkManager.api.object.LinkObject;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/grouplink")
public class GroupLinkResource {
	
	private static GroupLinkResource instance = null;
	public static GroupLinkResource getInstance() {
		if(instance == null) {
			return instance = new GroupLinkResource();
		}
		return instance;
	}
	
	@GET
	@Path("/getall/{groupId}")
	public DataRespone getListGroup(@PathParam("groupId") long groupId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("-1") @QueryParam("limit") int limit,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
			q= HtmlUtil.escape(q);
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
	
			List<GroupLinkObject> groupLinkObjects= new ArrayList<GroupLinkObject>();
			List<GroupLink> groupLinks = GroupLinkLocalServiceUtil.getListGroupLink(q, start, limit, groupId);
		
			for(GroupLink groupLink :groupLinks ) {
				GroupLinkObject groupLinkObject = new GroupLinkObject();
				groupLinkObject.setLinksgroupid(groupLink.getLinksgroupid());
				groupLinkObject.setGroupName(groupLink.getGroupName());
				groupLinkObject.setDescription(groupLink.getDescription());
				groupLinkObject.setCreateddate(groupLink.getCreateddate());
				groupLinkObject.setModifieddate(groupLink.getModifieddate());
				groupLinkObject.setCreateUserId(groupLink.getCreateUserId());
				groupLinkObject.setGroupid(groupLink.getGroupid());
				List<Links> listLink = LinksLocalServiceUtil.getLinkByLinkGroupId(groupId, groupLink.getLinksgroupid());
				List<LinkObject> linkObjects= new ArrayList<LinkObject>();
				for (Links links : listLink) {
					LinkObject linkObject = new LinkObject();
					linkObject.setLinksid(links.getLinksid());
					linkObject.setDecription(links.getDecription());
					linkObject.setModifieddate(links.getModifieddate());
					linkObject.setName(links.getName());
					linkObject.setUrl(links.getUrl());
					linkObjects.add(linkObject);
				}
				groupLinkObject.setListLink(linkObjects);
				groupLinkObjects.add(groupLinkObject);
			}
		
			int total= GroupLinkLocalServiceUtil.getGroupLinksCount();
			if(total<0) {
				return DataRespone.FAILED;
			}

			node.put("total", total);
			node.putPOJO("data", groupLinkObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
			
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createGroupLink(@PathParam("groupId") long groupId,
			GroupLinkObject groupLinkObject) {
		Date dateNow = new Date();
		try {
			String groupName= HtmlUtil.escape(groupLinkObject.getGroupName());
			String decription = HtmlUtil.escape(groupLinkObject.getDescription());
			if(groupId < 0  || groupName.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			GroupLink groupLink =GroupLinkLocalServiceUtil.createGroupLink(0);
			
			groupLink.setGroupName(groupName);
			groupLink.setDescription(decription);
			groupLink.setGroupid(groupId);
			groupLink.setCreateddate(dateNow);
			groupLink = GroupLinkLocalServiceUtil.addGroupLink(groupLink);
			
			
			
			groupLinkObject.setGroupid(groupLink.getGroupid());
			groupLinkObject.setLinksgroupid(groupLink.getLinksgroupid());
			groupLinkObject.setCreateddate(dateNow);
			groupLinkObject.setModifieddate(dateNow);
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, groupLinkObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{linksgroupid}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone updateLink(@PathParam("groupId") long groupId,@PathParam("linksgroupid") long linksgroupid,
			GroupLinkObject groupLinkObject) {

		Date date= new Date();
		try {
			String groupName= HtmlUtil.escape(groupLinkObject.getGroupName());
			String decription = HtmlUtil.escape(groupLinkObject.getDescription());
			if(groupId < 0  || groupName.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			GroupLink groupLink =GroupLinkLocalServiceUtil.getGroupLink(linksgroupid);
			groupLink.setGroupName(groupName);
			
			groupLink.setDescription(decription);;
			groupLink.setGroupid(groupId);
			groupLink.setModifieddate(date);
			groupLink = GroupLinkLocalServiceUtil.updateGroupLink(groupLink);
			
			
			groupLinkObject.setGroupid(groupLink.getGroupid());
			groupLinkObject.setLinksgroupid(groupLink.getLinksgroupid());
			groupLinkObject.setModifieddate(groupLink.getModifieddate());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, groupLinkObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
			
		}	
	}
	@GET
	@Path("/get/{groupId}/{linksgroupid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getLink(@PathParam("groupId") long groupId,
			@PathParam("linksgroupid") long linksgroupid) {
		try {
			if (groupId < 0  || linksgroupid < 0) {
				return DataRespone.PARAM_ERROR;
			}

			GroupLink groupLink =GroupLinkLocalServiceUtil.getGroupLink(linksgroupid);

//			LinkObject linkObject = new LinkObject(links.getLinksid(), links.getGroupid(),  links.getName(), links.getDecription(), links.getUrl());
			GroupLinkObject groupLinkObject = new GroupLinkObject(groupLink.getLinksgroupid(), groupLink.getGroupid(), groupLink.getCreateUserId(), groupLink.getCreateddate(), groupLink.getModifieddate(), groupLink.getGroupName(), groupLink.getDescription());
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, groupLinkObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}
	
	@DELETE
	@Path("/delete/{groupId}/{linksgroupid}")
	public DataRespone deleteGroupLink(@PathParam("linksgroupid") long linksgroupid, @PathParam("groupId") long groupId) {
		try {
			if(linksgroupid< 0) {
				return DataRespone.PARAM_ERROR;
			}
			GroupLink groupLink = GroupLinkLocalServiceUtil.getGroupLink(linksgroupid);
			GroupLinkLocalServiceUtil.deleteGroupLink(groupLink);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);
		
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/delete-mutiple/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataRespone deleteGroupLinks( @PathParam("groupId") long groupId,@Context HttpServletRequest request) {
		try {
			if(groupId< 0) {
				return DataRespone.PARAM_ERROR;
			}
			long []ids= ParamUtil.getLongValues(request, "ids",null);
			for (long id : ids) {
				GroupLinkLocalServiceUtil.deleteGroupLink(id);
			}
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);
		
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	
}
