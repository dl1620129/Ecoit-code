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

import LinkManager.Service.model.Links;
import LinkManager.Service.service.GroupLinkLocalServiceUtil;
import LinkManager.Service.service.LinksLocalServiceUtil;
import LinkManager.Service.utils.DataRespone;
import LinkManager.Service.utils.DataRespone.DataType;
import LinkManager.Service.utils.ResponeCode;
import LinkManager.api.object.LinkObject;


public class LinkResource {

	private static LinkResource instance = null;

	public static LinkResource getInstance() {
		if (instance == null) {
			instance = new LinkResource();
		}
		return instance;
	}


	
	@GET
	@Path("/getlinkbyparams/{groupId}/{linksgroupid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getLinkByParams(@PathParam("groupId") long groupId, @PathParam("linksgroupid") long linkGroupId) {
		
		try {
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode objectNode= mapper.createObjectNode();
			ArrayNode node= mapper.createArrayNode();
			List<LinkObject> arrLink = new ArrayList<LinkObject>();
			List<Links> listLink = LinksLocalServiceUtil.getLinkByLinkGroupId(groupId, linkGroupId);
			for (Links links : listLink) {
				LinkObject linkObject = new LinkObject();
				linkObject.setLinksid(links.getLinksid());
				linkObject.setDecription(links.getDecription());
				linkObject.setCreateddate(links.getCreateddate());
				linkObject.setName(links.getName());
				linkObject.setUrl(links.getUrl());
				linkObject.setHasimage(links.getHasimage());
				linkObject.setModifieddate(links.getModifieddate());
				linkObject.setShow(links.getShow());
				linkObject.setPosition(links.getPosition());
				linkObject.setImageid(links.getImageid());
				linkObject.setParentId(links.getParentId());

				arrLink.add(linkObject);
			}
			objectNode.putPOJO("data", arrLink);
			node.add(objectNode);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
			
		} catch (Exception e) {
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, e.getMessage(), DataType.JSON_STR);
		}
		
	}
	
	@GET
	@Path("/getall/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getAll(@PathParam("groupId") long groupId,
			@DefaultValue("-1") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId < 0 || start < 0 || limit < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			q = HtmlUtil.escape(q);
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode objectNode= mapper.createObjectNode();
			ArrayNode node= mapper.createArrayNode();
			List<LinkObject> arrLink = new ArrayList<LinkObject>();
			List<Links> listLink = LinksLocalServiceUtil.getListLink(q, groupId, start, limit);

			for (Links links : listLink) {
				LinkObject linkObject = new LinkObject();
				linkObject.setLinksid(links.getLinksid());
				linkObject.setDecription(links.getDecription());
				linkObject.setCreateddate(links.getCreateddate());
				linkObject.setName(links.getName());
				linkObject.setUrl(links.getUrl());
				linkObject.setHasimage(links.getHasimage());
				linkObject.setModifieddate(links.getModifieddate());
				linkObject.setShow(links.getShow());
				linkObject.setPosition(links.getPosition());
				linkObject.setImageid(links.getImageid());
				linkObject.setParentId(links.getParentId());
				linkObject.setLinksgroupid(links.getLinksgroupid());
				arrLink.add(linkObject);
			}
			
			int total= LinksLocalServiceUtil.getCountByTag(q,groupId);
		
			if (total == -1) {
				return DataRespone.FAILED;
			}

			objectNode.put("total", total);
			objectNode.putPOJO("data", arrLink);
			node.add(objectNode);
	
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createLink(@PathParam("groupId") long groupId,
			LinkObject linkObject) {
		try {
			String name= HtmlUtil.escape(linkObject.getName());
			String url = HtmlUtil.escape(linkObject.getUrl());;
			String decription = HtmlUtil.escape(linkObject.getDecription());

			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Links links = LinksLocalServiceUtil.createLinks(0);
			links.setName(name);
			links.setUrl(url);
			links.setDecription(decription);
			links.setGroupid(groupId);
			links.setLinksgroupid(linkObject.getLinksgroupid());
			links.setCreateddate(new Date());
			links = LinksLocalServiceUtil.addLinks(links);
			
			Date date= new Date();
			linkObject.setLinksid(links.getLinksid());
			linkObject.setGroupid(links.getGroupid());
			linkObject.setCreateddate(date);
			linkObject.setModifieddate(date);
			linkObject.setCreateddate(links.getCreateddate());
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, linkObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	
	@GET
	@Path("/get/link/{groupId}/{linksId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getLink(@PathParam("groupId") long groupId,
			@PathParam("linksId") long linksid) {
		try {
			if (groupId < 0  || linksid < 0) {
				return DataRespone.PARAM_ERROR;
			}

			Links links = LinksLocalServiceUtil.getLinks(linksid);

//			LinkObject linkObject = new LinkObject(links.getLinksid(), links.getGroupid(),  links.getName(), links.getDecription(), links.getUrl());
			LinkObject linkObject = new LinkObject(links.getLinksid(), links.getGroupid(), links.getCreateddate(), links.getModifieddate(), links.getLinksgroupid(),  links.getName(), links.getDecription(),  links.getUrl(), links.getImageid(), links.getHasimage(), links.getPosition(), links.getShow(), links.getIcon(), links.getParentId());
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, linkObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

	
	@PUT
	@Path("/update/{linksId}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone updateLink(@PathParam("groupId") long groupId,@PathParam("linksId") long linksId,
			LinkObject linkObject) {
		try {
			String name= HtmlUtil.escape(linkObject.getName());
			String url = HtmlUtil.escape(linkObject.getUrl());;
			String decription = HtmlUtil.escape(linkObject.getDecription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Links links = LinksLocalServiceUtil.getLinks(linksId);
			links.setName(name);
			links.setUrl(url);
			links.setDecription(decription);
			links.setGroupid(groupId);
			links.setLinksgroupid(linkObject.getLinksgroupid());
			links.setModifieddate(new Date());
			links = LinksLocalServiceUtil.updateLinks(links);
			
			Date date= new Date();
			
			linkObject.setLinksid(links.getLinksid());
			linkObject.setGroupid(links.getGroupid());
			linkObject.setModifieddate(links.getModifieddate());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, linkObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
			
		}	
	}
	@DELETE
	@Path("/delete/{linksId}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone deleteLink(@PathParam("linksId") long linksId, @PathParam("groupId") long groupId) {
		try {
			if (linksId < 0 || groupId <0) {
				return DataRespone.PARAM_ERROR;
			}
			LinksLocalServiceUtil.deleteLinks(linksId);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
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
				LinksLocalServiceUtil.deleteLinks(id);
			}
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);
		
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

}
