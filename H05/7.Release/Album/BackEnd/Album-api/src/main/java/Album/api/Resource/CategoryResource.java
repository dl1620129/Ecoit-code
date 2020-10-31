package Album.api.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties.Convert;
import com.liferay.portal.kernel.util.HtmlUtil;

import Album.api.Object.CategoryObject;
import Album.api.upload.AttachmentUtil;
import Album.service.model.Category;
import Album.service.model.Image;
import Album.service.service.CategoryLocalServiceUtil;
import Album.service.service.ImageLocalServiceUtil;
import Album.service.service.util.DataRespone;
import Album.service.service.util.DataRespone.DataType;
import Album.service.service.util.ResponeCode;



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
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone  getListCategory(@PathParam("groupId") long groupId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("-1") @QueryParam("limit") int limit,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
	
			q= HtmlUtil.escape(q);
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			
			List<CategoryObject> categoryObjects= new ArrayList<CategoryObject>();	
			List<Category> categories = CategoryLocalServiceUtil.getListCategory(q, start, limit, groupId);
			for(Category category : categories ) {
				CategoryObject categoryObject = new CategoryObject();
				
//				Image image = ImageLocalServiceUtil.findByIsDaiDienAndCateId(category.getCategoryId(),category.getIsDaiDien());
//				image.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
//				if(image!=null && image.getIsDaiDien()) {
//					category.setUrlImage(AttachmentUtil.viewDocument(image.getImageFileId()));
//					
//				}
				List<Image> images= ImageLocalServiceUtil.getImageByCategory(category.getCategoryId(), groupId, start, limit);
				for (Image image2 : images) {
					if(image2!=null && image2.getIsDaiDien()) {
						category.setUrlImage(AttachmentUtil.viewDocument(image2.getImageFileId()));
						break;
					}
				}
				categoryObject.setCategoryId(category.getCategoryId());
				categoryObject.setCompanyId(category.getCompanyId());
				categoryObject.setCreateByUser(category.getCreateByUser());
				categoryObject.setCreateDate(category.getCreateDate());
				categoryObject.setDescription(HtmlUtil.extractText(category.getDescription()));
				categoryObject.setGroupId(category.getGroupId());
//				categoryObject.setIsDaiDien(category.getIsDaiDien());
//				categoryObject.setFieldId(category.getFieldId());
				categoryObject.setModifiedByUser(category.getModifiedByUser());
				categoryObject.setModifiedDate(category.getModifiedDate());
				categoryObject.setName(HtmlUtil.extractText(category.getName()));
//				categoryObject.setParentId(category.getParentId());
//				categoryObject.setStatus(category.getStatus());
				categoryObject.setTacGiaAlbum(HtmlUtil.extractText(category.getTacGiaAlbum()));
				categoryObject.setThuTu(category.getThuTu());
				categoryObject.setView(category.getView());
				categoryObject.setUrlImage(category.getUrlImage());
				categoryObject.setCountImage(ImageLocalServiceUtil.getCountByCategory(category.getCategoryId(), groupId));
				
				categoryObjects.add(categoryObject);
			}
			int total= CategoryLocalServiceUtil.getCountAll(q, groupId);	
			if(total<0) {
				return DataRespone.FAILED;
			}
			node.put("total", total);
			node.putPOJO("data", categoryObjects);
			arrNode.add(node); 
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		} 
	}
	@GET
	@Path("/getall-byid/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone  getListDetail(@PathParam("groupId") long groupId,@PathParam("id") long id, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("-1") @QueryParam("limit") int limit,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
	
			q= HtmlUtil.escape(q);
			ObjectMapper mapper= new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			
			List<CategoryObject> categoryObjects= new ArrayList<CategoryObject>();	
			List<Category> categories = CategoryLocalServiceUtil.getListDetail(q,id, start, limit, groupId);
			for(Category category : categories ) {
				CategoryObject categoryObject = new CategoryObject();
				
				Image image = ImageLocalServiceUtil.findByIsDaiDienAndCateId(category.getCategoryId(),category.getIsDaiDien());
//				image.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
				if(image!=null && category.getIsDaiDien()==true) {
					category.setUrlImage(AttachmentUtil.viewDocument(image.getImageFileId()));
					
				}
				categoryObject.setCategoryId(category.getCategoryId());
				categoryObject.setCompanyId(category.getCompanyId());
				categoryObject.setCreateByUser(category.getCreateByUser());
				categoryObject.setCreateDate(category.getCreateDate());
				categoryObject.setDescription(HtmlUtil.extractText(category.getDescription()));
				categoryObject.setGroupId(category.getGroupId());
//				categoryObject.setIsDaiDien(category.getIsDaiDien());
//				categoryObject.setFieldId(category.getFieldId());
				categoryObject.setModifiedByUser(category.getModifiedByUser());
				categoryObject.setModifiedDate(category.getModifiedDate());
				categoryObject.setName(HtmlUtil.extractText(category.getName()));
//				categoryObject.setParentId(category.getParentId());
//				categoryObject.setStatus(category.getStatus());
				categoryObject.setTacGiaAlbum(HtmlUtil.extractText(category.getTacGiaAlbum()));
				categoryObject.setThuTu(category.getThuTu());
				categoryObject.setView(category.getView());
				categoryObject.setUrlImage(category.getUrlImage());
				categoryObject.setCountImage(ImageLocalServiceUtil.getCountByCategory(category.getCategoryId(), groupId));
				
				categoryObjects.add(categoryObject);
			}
			int total= CategoryLocalServiceUtil.getCountAll(q, groupId);	
			if(total<0) {
				return DataRespone.FAILED;
			}
			node.put("total", total);
			node.putPOJO("data", categoryObjects);
			arrNode.add(node); 
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		} 
	}
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createCategory(@PathParam("groupId") long groupId,
			CategoryObject categoryObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(categoryObject.getName());
			String description = HtmlUtil.escape(categoryObject.getDescription());
			String tacGia = HtmlUtil.escape(categoryObject.getTacGiaAlbum());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Category category =CategoryLocalServiceUtil.createCategory(0);
			category.setName(name);
			category.setDescription(description);
			category.setTacGiaAlbum(tacGia);
			category.setThuTu(categoryObject.getThuTu());
			category.setGroupId(groupId);
			category.setCreateDate(dateNow);
			category = CategoryLocalServiceUtil.addCategory(category);
						
			HtmlUtil.extractText(category.getName());
			HtmlUtil.extractText(category.getDescription());
			HtmlUtil.extractText(category.getTacGiaAlbum());
			categoryObject.setCategoryId(category.getCategoryId());
			categoryObject.setGroupId(category.getGroupId());
			categoryObject.setName(category.getName());
			categoryObject.setDescription(category.getDescription());
			categoryObject.setCreateDate(category.getCreateDate());
			categoryObject.setTacGiaAlbum(category.getTacGiaAlbum());
			categoryObject.setThuTu(category.getThuTu());
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, categoryObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone updateCategory(@PathParam("groupId") long groupId,@PathParam("id") long id,
			CategoryObject categoryObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(categoryObject.getName());
			String description = HtmlUtil.escape(categoryObject.getDescription());
			String tacGia = HtmlUtil.escape(categoryObject.getTacGiaAlbum());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			Category category =CategoryLocalServiceUtil.getCategory(id);
			
			category.setName(name);
			category.setDescription(description);
			category.setTacGiaAlbum(tacGia);
			category.setThuTu(categoryObject.getThuTu());
			category.setGroupId(groupId);
			category.setModifiedDate(dateNow);
			category = CategoryLocalServiceUtil.updateCategory(category);
			
			
			categoryObject.setCategoryId(category.getCategoryId());
			categoryObject.setGroupId(category.getGroupId());
			categoryObject.setName(category.getName());
			categoryObject.setDescription(category.getDescription());
			categoryObject.setModifiedDate(category.getModifiedDate());
			categoryObject.setTacGiaAlbum(category.getTacGiaAlbum());
			categoryObject.setThuTu(category.getThuTu());
		
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, categoryObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@DELETE
	@Path("/delete/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone deleteCategory(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			int totalImage=ImageLocalServiceUtil.getCountByCategory(id, groupId);
			if(totalImage>0) {
				return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, "image exsits", DataType.JSON_STR);
			}
			Category category= CategoryLocalServiceUtil.deleteCategory(id);			
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@GET
	@Path("/getcategory/{groupId}/{id}/{view}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getCategory(@PathParam("groupId") long groupId,@PathParam("view") long view,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			Category category= CategoryLocalServiceUtil.getCategory(id);
			if(view==1) {
				category.setView(category.getView()+1);
				CategoryLocalServiceUtil.updateCategory(category);
			}
			if(view==2) {
				category.setView(category.getView());
			}
			CategoryObject categoryObject= new CategoryObject(category.getCategoryId(), category.getGroupId(), category.getCompanyId(), category.getView(), category.getParentId(), category.getFieldId(), category.getStatus(), category.getThuTu(), category.getCreateByUser(), category.getModifiedByUser(), HtmlUtil.extractText(category.getName()), HtmlUtil.extractText(category.getDescription()), HtmlUtil.extractText(category.getTacGiaAlbum()), category.getCreateDate(), category.getModifiedDate(), category.getIsDaiDien(),category.getUrlImage());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, categoryObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	
}
