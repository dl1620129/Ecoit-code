package Album.api.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import Album.api.Object.ImageObject;
import Album.api.upload.AttachmentUtil;
import Album.service.model.Category;
import Album.service.model.Image;
import Album.service.service.CategoryLocalServiceUtil;
import Album.service.service.ImageLocalServiceUtil;
import Album.service.service.util.DataRespone;
import Album.service.service.util.DataRespone.DataType;
import Album.service.service.util.ResponeCode;



public class ImageResource {
	private static ImageResource instance = null;

	public static ImageResource getInstance() {
		if (instance == null) {
			instance = new ImageResource();
		}
		return instance;
	}
	
	@GET
	@Path("/getall/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getall(@PathParam("groupId")long groupId, @DefaultValue("-1") @QueryParam("limit")int limit,
			@DefaultValue("0") @QueryParam("start")int start,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId< 0|| start<0) {
				return DataRespone.PARAM_ERROR;
			}
			q= HtmlUtil.escape(q);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			List<ImageObject> listImageObjects = new ArrayList<ImageObject>();
			List<Image> listImage= ImageLocalServiceUtil.getListImage(q,start,limit,groupId);
			for (Image image : listImage) {
				ImageObject imageObject = new ImageObject();
				imageObject.setAddByUser(image.getAddByUser());
				imageObject.setAddDate(image.getAddDate());
				imageObject.setCategoryId(image.getCategoryId());
				imageObject.setCompanyId(image.getCompanyId());
				imageObject.setDescription(HtmlUtil.extractText(image.getDescription()));
				imageObject.setDisplay(image.getDisplay());
				imageObject.setFileAttachId(image.getFileAttachId());
				imageObject.setFolderId(image.getFolderId());
				imageObject.setGroupId(image.getGroupId());
				imageObject.setImageFileId(image.getImageFileId());
				imageObject.setImageId(image.getImageId());
				imageObject.setIsDaiDien(image.getIsDaiDien());
				imageObject.setFieldId(image.getFieldId());
				imageObject.setModifiedByUser(image.getModifiedByUser());
				imageObject.setModifiedDate(image.getModifiedDate());
				imageObject.setTacGia(HtmlUtil.extractText(image.getTacGia()));
				imageObject.setThuTu(image.getThuTu());
				imageObject.setTitle(HtmlUtil.extractText(image.getTitle()));
				imageObject.setView(image.getView());
				imageObject.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
				listImageObjects.add(imageObject);
			}
			int total = ImageLocalServiceUtil.getCountAll(q, groupId);;
			if(total <0) {
				return DataRespone.FAILED;
			}
			node.put("total", total);
			node.putPOJO("data", listImageObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/get-by-category/{groupId}/{categoryId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getByCategory(@PathParam("categoryId")long categoryId,@PathParam("groupId")long groupId, @DefaultValue("-1") @QueryParam("limit")int limit,
			@DefaultValue("0") @QueryParam("start")int start) {
		try {
			if(groupId< 0|| start<0 || categoryId<0 ){
				return DataRespone.PARAM_ERROR;
			}
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			List<ImageObject> listImageObjects = new ArrayList<ImageObject>();
			List<Image> listImage= ImageLocalServiceUtil.getImageByCategory(categoryId, groupId, start, limit);
			for (Image image : listImage) {
				ImageObject imageObject = new ImageObject();
				imageObject.setAddByUser(image.getAddByUser());
				imageObject.setAddDate(image.getAddDate());
				imageObject.setCategoryId(image.getCategoryId());
				imageObject.setCompanyId(image.getCompanyId());
				imageObject.setDescription(image.getDescription());
				imageObject.setDisplay(image.getDisplay());
				imageObject.setFileAttachId(image.getFileAttachId());
				imageObject.setFolderId(image.getFolderId());
				imageObject.setGroupId(image.getGroupId());
				imageObject.setImageFileId(image.getImageFileId());
				imageObject.setImageId(image.getImageId());
				imageObject.setIsDaiDien(image.getIsDaiDien());
				imageObject.setFieldId(image.getFieldId());
				imageObject.setModifiedByUser(image.getModifiedByUser());
				imageObject.setModifiedDate(image.getModifiedDate());
				imageObject.setTacGia(image.getTacGia());
				imageObject.setThuTu(image.getThuTu());
				imageObject.setTitle(image.getTitle());
				imageObject.setView(image.getView());
				imageObject.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
				listImageObjects.add(imageObject);
			}
			int total = ImageLocalServiceUtil.getCountByCategory(categoryId, groupId);
			if(total <0) {
				return DataRespone.FAILED;
			}
			Category category = CategoryLocalServiceUtil.getCategory(categoryId);
			node.put("name", category.getName());
			node.put("description", category.getDescription());
			node.put("total", total);
			node.putPOJO("data", listImageObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone createImage(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		ImageObject imageObject= new ImageObject();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			
			File imageFile = upload.getFile("images");
			
			Image image = ImageLocalServiceUtil.createImage(0);
			if(upload.getFile("images") != null && upload.getFile("images").isFile()) {
				if (imageFile != null && imageFile.getName().length() > 0) {
					String titleimages = upload.getFileName("images");
					long imageId = AttachmentUtil.uploadFile(upload, image, imageFile, titleimages, groupId,userId,companyId);
					image.setImageFileId(imageId);
					image.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
//					DLAppLocalServiceUtil.deleteFileEntry(videoId);
				}
			}else {
				
			}
			
			String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String tacGia= HtmlUtil.escape(ParamUtil.getString(request, "tacGia",""));
			long categoryId= ParamUtil.getLong(request, "categoryId",0);
			int thuTu= ParamUtil.getInteger(request, "thuTu",0);
			boolean display = ParamUtil.getBoolean(request, "display", false);
			boolean isDaiDien = ParamUtil.getBoolean(request, "isDaiDien", false);
			Date date= new Date();
			if(title != null && !title.equals("")) {
				image.setTitle(title);
				image.setDescription(description);
				image.setAddDate(new Date());
				image.setGroupId(groupId);
				image.setTacGia(tacGia);
				image.setDisplay(display);
				image.setIsDaiDien(isDaiDien);
				image.setThuTu(thuTu);
				image.setCategoryId(categoryId);
				
				image= ImageLocalServiceUtil.addImage(image);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, imageObject, DataType.JSON_STR);
			}
			if(image.getIsDaiDien()==true) {
				ImageLocalServiceUtil.setIsDAiDien(categoryId, groupId, image.getImageId());	
			}imageObject.setAddByUser(image.getAddByUser());
			imageObject.setAddDate(image.getAddDate());
			imageObject.setCategoryId(image.getCategoryId());
			imageObject.setCompanyId(image.getCompanyId());
			imageObject.setDescription(image.getDescription());
			imageObject.setDisplay(image.getDisplay());
			imageObject.setFileAttachId(image.getFileAttachId());
			imageObject.setFolderId(image.getFolderId());
			imageObject.setGroupId(image.getGroupId());
			imageObject.setImageFileId(image.getImageFileId());
			imageObject.setImageId(image.getImageId());
			imageObject.setIsDaiDien(image.getIsDaiDien());
			imageObject.setFieldId(image.getFieldId());
			imageObject.setModifiedByUser(image.getModifiedByUser());
			imageObject.setModifiedDate(image.getModifiedDate());
			imageObject.setTacGia(image.getTacGia());
			imageObject.setThuTu(image.getThuTu());
			imageObject.setTitle(image.getTitle());
			imageObject.setView(image.getView());
			imageObject.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, imageObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@POST
	@Path("/createMutiple/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone createMutiple(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		ImageObject imageObject= new ImageObject();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String tacGia= HtmlUtil.escape(ParamUtil.getString(request, "tacGia",""));
			long categoryId= ParamUtil.getLong(request, "categoryId",0);
			int thuTu= ParamUtil.getInteger(request, "thuTu",0);
			boolean display = ParamUtil.getBoolean(request, "display", false);
			boolean isDaiDien = ParamUtil.getBoolean(request, "isDaiDien", false);
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			Map<String, FileItem[]> files=upload.getMultipartParameterMap();
			for (Entry<String, FileItem[]> file2 : files.entrySet()) {
				FileItem item[] =file2.getValue();
				for (FileItem fileItem : item) {
					System.out.println("fileItem.getSize(): "+fileItem.getSize());
				if(fileItem.getSize() > 0){
					Image image = ImageLocalServiceUtil.createImage(0);
					String titleimages = fileItem.getFileName();
					System.out.println(fileItem.getFullFileName()+" - "+fileItem.getFileNameExtension());
					long imageId = AttachmentUtil.uploadFile(upload, image,  fileItem.getStoreLocation(), titleimages, groupId,userId,companyId);
					image.setImageFileId(imageId);
					if(title != null && !title.equals("")) {
						image.setTitle(title);
						image.setDescription(description);
						image.setAddDate(new Date());
						image.setGroupId(groupId);
						image.setTacGia(tacGia);
						image.setDisplay(display);
						image.setIsDaiDien(isDaiDien);
						image.setThuTu(thuTu);
						image.setCategoryId(categoryId);
						
						image= ImageLocalServiceUtil.addImage(image);
					}else {
						return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, imageObject, DataType.JSON_STR);
					}
				}
			}
			}
			
			
			
			
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone updateImage(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id,
			@Context HttpServletRequest request) {
		ImageObject imageObject= new ImageObject();
		long companyId = PortalUtil.getCompanyId(request);
		try {
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			
			File imageFile = upload.getFile("images");
			
			Image image = ImageLocalServiceUtil.getImage(id);
//			
			if(upload.getFile("images") != null && upload.getFile("images").isFile()) {
				if (imageFile != null && imageFile.getName().length() > 0) {
					if(image.getImageUrl()!=""){
						DLAppLocalServiceUtil.deleteFileEntry(image.getImageFileId());
					}
					String titleimages = upload.getFileName("images");
					long imageId = AttachmentUtil.uploadFile(upload, image, imageFile, titleimages, groupId,userId,companyId);
					image.setImageFileId(imageId);
					image.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
//					DLAppLocalServiceUtil.deleteFileEntry(videoId);
				}
			}else {
				
			}
			
			String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String tacGia= HtmlUtil.escape(ParamUtil.getString(request, "tacGia",""));
			long categoryId= ParamUtil.getLong(request, "categoryId",0);
			int thuTu= ParamUtil.getInteger(request, "thuTu",0);
			boolean display = ParamUtil.getBoolean(request, "display", false);
			boolean isDaiDien = ParamUtil.getBoolean(request, "isDaiDien", false);
			Date date= new Date();
			if(title != null && !title.equals("")) {
				image.setTitle(title);
				image.setDescription(description);
				image.setModifiedDate(new Date());
				image.setGroupId(groupId);
				image.setTacGia(tacGia);
				image.setDisplay(display);
				image.setIsDaiDien(isDaiDien);
				image.setThuTu(thuTu);
				image.setCategoryId(categoryId);
				image= ImageLocalServiceUtil.updateImage(image);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, imageObject, DataType.JSON_STR);
			}
			if(image.getIsDaiDien()==true) {
				ImageLocalServiceUtil.setIsDAiDien(categoryId, groupId, image.getImageId());	
			}
			imageObject.setAddByUser(image.getAddByUser());
			imageObject.setCategoryId(image.getCategoryId());
			imageObject.setCompanyId(image.getCompanyId());
			imageObject.setDescription(image.getDescription());
			imageObject.setDisplay(image.getDisplay());
			imageObject.setFileAttachId(image.getFileAttachId());
			imageObject.setFolderId(image.getFolderId());
			imageObject.setGroupId(image.getGroupId());
			imageObject.setImageFileId(image.getImageFileId());
			imageObject.setImageId(image.getImageId());
			imageObject.setIsDaiDien(image.getIsDaiDien());
			imageObject.setFieldId(image.getFieldId());
			imageObject.setModifiedByUser(image.getModifiedByUser());
			imageObject.setModifiedDate(image.getModifiedDate());
			imageObject.setTacGia(image.getTacGia());
			imageObject.setThuTu(image.getThuTu());
			imageObject.setTitle(image.getTitle());
			imageObject.setView(image.getView());
			imageObject.setImageUrl(AttachmentUtil.viewDocument(image.getImageFileId()));
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, imageObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@DELETE
	@Path("/delete/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteImage(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			Image image= ImageLocalServiceUtil.getImage(id);
			
			if(image.getImageUrl()!=""){
				
				DLAppLocalServiceUtil.deleteFileEntry(image.getImageFileId());
			}
			
			ImageLocalServiceUtil.deleteImage(id);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	@DELETE
	@Path("/deleteselect/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteListImage(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			long[] ids= ParamUtil.getLongValues(request, "ids");
			for (Long id : ids) {
				Image image =ImageLocalServiceUtil.getImage(id);
				
				DLAppLocalServiceUtil.deleteFileEntry(image.getImageFileId());
				ImageLocalServiceUtil.deleteImage(id);
			}
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "ok",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	@GET
	@Path("/getimage/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getClipById(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			Image image= ImageLocalServiceUtil.getImage(id); 
			ImageObject imageObject= new ImageObject(image.getImageId(), image.getGroupId(), image.getCompanyId(), image.getCategoryId(), image.getFileAttachId(), image.getView(), image.getFieldId(), image.getImageFileId(), image.getFolderId(), image.getThuTu(), image.getAddByUser(), image.getModifiedByUser(), HtmlUtil.extractText(image.getTitle()), HtmlUtil.extractText(image.getDescription()), HtmlUtil.extractText(image.getTacGia()), image.getAddDate(), image.getModifiedDate(), image.getDisplay(), image.getIsDaiDien(),AttachmentUtil.viewDocument(image.getImageFileId()));
			
		
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, imageObject,DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
}
