package cms.tag.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Tag;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.TagLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.PermissionUtil;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;

import java.util.ArrayList;
import java.util.List;

import com.software.util.DataResponse.DataType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import cms.tag.object.TagObject;

public class TagResource {

	private static TagResource instance = null;

	public static TagResource getInstance() {
		if (instance == null) {
			instance = new TagResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			locale = HtmlUtil.escape(locale);
			q = HtmlUtil.escape(q);

			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			ObjectMapper mapper = new ObjectMapper();
			ArrayNode node = mapper.createArrayNode();
			ObjectNode objectNode = mapper.createObjectNode();
			List<Tag> listTag = TagLocalServiceUtil.getListTag(q, groupId, locale, start, limit);
			List<TagObject> arrTag = new ArrayList<TagObject>();
			for (Tag tag : listTag) {
				TagObject tagObject = new TagObject();
				tagObject.setId(tag.getTagId());
				tagObject.setName(tag.getTagName());
				tagObject.setDescription(tag.getDescription());
				tagObject.setGroupId(tag.getGroupId());
				tagObject.setLanguage(tag.getLanguage());
				arrTag.add(tagObject);
			}
			int total = TagLocalServiceUtil.getCountByTag(q, groupId, locale);
			if (total == -1) {
				return DataResponse.FAILED;
			}
			objectNode.put("total", total);
			objectNode.putPOJO("data", arrTag);
			node.addPOJO(objectNode);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/create/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Create(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			TagObject tagObject) {
		try {
			locale = HtmlUtil.escape(locale);
			String name = HtmlUtil.escape(tagObject.getName());
			String description = HtmlUtil.escape(tagObject.getDescription());

			if (groupId < 0 || locale.isEmpty() || name.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			Tag tag = TagLocalServiceUtil.createTag(0);
			tag.setTagName(name);
			tag.setDescription(description);
			tag.setLanguage(locale);
			tag.setGroupId(groupId);
			tag = TagLocalServiceUtil.addTag(tag);

			tagObject.setId(tag.getTagId());
			tagObject.setLanguage(locale);
			tagObject.setGroupId(groupId);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, tagObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

	@GET
	@Path("/get/item/{groupId}/{locale}/{tagId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Update(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("tagId") long tagId) {
		try {

			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || tagId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			Tag tag = TagLocalServiceUtil.getTag(tagId);

			TagObject tagObject = new TagObject(tag.getTagId(), tag.getTagName(), tag.getDescription(), groupId,
					locale);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, tagObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

	@PUT
	@Path("/update/{groupId}/{locale}/{tagId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Update(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("tagId") long tagId, TagObject tagObject) {
		try {

			locale = HtmlUtil.escape(locale);
			String name = HtmlUtil.escape(tagObject.getName());
			String description = HtmlUtil.escape(tagObject.getDescription());

			if (groupId < 0 || locale.isEmpty() || name.isEmpty() || tagId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			Tag tag = TagLocalServiceUtil.getTag(tagId);
			tag.setTagName(name);
			tag.setDescription(description);
			tag.setLanguage(locale);
			tag.setGroupId(groupId);
			tag = TagLocalServiceUtil.updateTag(tag);

			tagObject.setId(tag.getTagId());
			tagObject.setLanguage(locale);
			tagObject.setGroupId(groupId);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, tagObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

	@DELETE
	@Path("/delete/{tagId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Delete(@PathParam("tagId") long tagId) {
		try {

			if (tagId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			Tag tag = TagLocalServiceUtil.getTag(tagId);
			TagLocalServiceUtil.deleteTag(tag);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}

	}

}
