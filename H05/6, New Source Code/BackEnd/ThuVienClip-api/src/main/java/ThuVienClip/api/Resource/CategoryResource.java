package ThuVienClip.api.Resource;

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
import com.liferay.portal.kernel.dao.jdbc.ParamSetter;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import LinkManager.Service.model.Category;
import LinkManager.Service.model.Clip;
import LinkManager.Service.model.GroupLink;
import LinkManager.Service.service.CategoryLocalServiceUtil;
import LinkManager.Service.service.ClipLocalServiceUtil;
import LinkManager.Service.service.GroupLinkLocalServiceUtil;
import LinkManager.Service.utils.DataRespone;
import LinkManager.Service.utils.DataRespone.DataType;
import LinkManager.Service.utils.ResponeCode;
import ThuVienClip.api.Object.CategoryObject;
import ThuVienClip.api.Object.ClipObject;

@Path("/category")
public class CategoryResource {
	private static CategoryResource instance = null;
	public static CategoryResource getInstance() {
		if (instance == null) {
			instance = new CategoryResource();
		}
		return instance;
	}
	
	@GET
	@Path("/getall/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getallCategory(@PathParam("groupId") long groupId,
			@DefaultValue("-1") @QueryParam("limit") int limit,@DefaultValue("0") @QueryParam("start")  int start,@DefaultValue("")  @QueryParam("q")  String q) {
		try {
			q= HtmlUtil.escape(q);
			if(groupId<0||start<0) {
				return DataRespone.PARAM_ERROR;
			}
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			List<Category> listCategories= CategoryLocalServiceUtil.getListCategory(q, groupId, start, limit);
			List<CategoryObject> listCategoryObjects= new ArrayList<CategoryObject>();
			for (Category category : listCategories) {
				CategoryObject categoryObject= new CategoryObject();
				categoryObject.setGroupId(category.getGroupId());
				categoryObject.setCompanyId(category.getCompanyId());
				categoryObject.setCreateByUser(category.getCreateByUser());
				categoryObject.setCreateDate(category.getCreateDate());
				categoryObject.setDescription(HtmlUtil.extractText(category.getDescription()));
				categoryObject.setId(category.getId());
				categoryObject.setTitle(HtmlUtil.extractText(category.getTitle()));
				categoryObject.setView(category.getView());
				categoryObject.setModifiedByUser(category.getModifiedByUser());
				categoryObject.setModifiedDate(category.getModifiedDate());
				categoryObject.setIsAudio(category.getIsAudio());
				listCategoryObjects.add(categoryObject);
			}
			int total=CategoryLocalServiceUtil.getCountbyCategory(q, groupId);
			node.put("total", total);
			node.putPOJO("data", listCategoryObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
			
		} catch(Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
			}
	}
	@POST
	@Path("/create/{groupId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createClipCategory(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			CategoryObject categoryObject) {
		try {
			String title= HtmlUtil.escape(categoryObject.getTitle());
			String description = HtmlUtil.escape(categoryObject.getDescription());
			if(groupId < 0  || title.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Category category =CategoryLocalServiceUtil.createCategory(0);
			
			category.setTitle(title);
			category.setDescription(description);
			category.setGroupId(groupId);
			category.setCreateDate(new Date());
			category = CategoryLocalServiceUtil.addCategory(category);
			
			
			categoryObject.setTitle(category.getTitle());
			categoryObject.setDescription(category.getDescription());
			categoryObject.setGroupId(category.getGroupId());
			categoryObject.setId(category.getId());
			categoryObject.setCreateDate(category.getCreateDate());
			categoryObject.setModifiedDate(category.getModifiedDate());
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, categoryObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{userId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone updateClipCategory(@PathParam("groupId")long groupId,@PathParam("userId")long userId,@PathParam("id")long id, CategoryObject categoryObject) {
		try {
			String title= HtmlUtil.escape(categoryObject.getTitle());
			String description = HtmlUtil.escape(categoryObject.getDescription());
			if(groupId < 0  || title.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			
			Category category = CategoryLocalServiceUtil.getCategory(id);
			category.setTitle(title);
			category.setDescription(description);
			category.setModifiedDate(new Date());
			category= CategoryLocalServiceUtil.updateCategory(category);
			
			categoryObject.setId(category.getId());
			categoryObject.setTitle(category.getTitle());
			categoryObject.setDescription(category.getDescription());
			categoryObject.setGroupId(category.getGroupId());
			categoryObject.setModifiedDate(category.getModifiedDate());
			
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, categoryObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@DELETE
	@Path("/delete/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteClipCategory(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			CategoryLocalServiceUtil.deleteCategory(id);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	@POST
	@Path("/delete-mutiple/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteClipCategorys(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@Context HttpServletRequest request) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			long []ids= ParamUtil.getLongValues(request, "ids",null);
			for (long id : ids) {
				CategoryLocalServiceUtil.deleteCategory(id);	
			}
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	@GET
	@Path("/getcategory/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getCategoryById(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			Category category=CategoryLocalServiceUtil.getCategory(id);
			CategoryObject categoryObject= new CategoryObject(id, groupId, category.getCompanyId(), category.getCreateDate(), category.getCreateByUser(), category.getModifiedDate(), category.getModifiedByUser(), HtmlUtil.extractText(category.getTitle()), HtmlUtil.extractText(category.getDescription()), category.getIsAudio(), category.getView());
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, categoryObject,DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
}














