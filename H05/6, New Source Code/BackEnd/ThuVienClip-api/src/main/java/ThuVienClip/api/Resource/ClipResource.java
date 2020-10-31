package ThuVienClip.api.Resource;

import java.awt.image.TileObserver;
import java.io.Console;
import java.io.File;
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
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import LinkManager.Service.model.Category;
import LinkManager.Service.model.Clip;
import LinkManager.Service.service.CategoryLocalServiceUtil;
import LinkManager.Service.service.ClipLocalServiceUtil;
import LinkManager.Service.utils.DataRespone;
import LinkManager.Service.utils.DataRespone.DataType;
import LinkManager.Service.utils.ResponeCode;
import ThuVienClip.api.Object.CategoryObject;
import ThuVienClip.api.Object.ClipObject;
import ThuVienClip.api.util.AttachmentUtil;


public class ClipResource {
	private static ClipResource instance = null;

	public static ClipResource getInstance() {
		if (instance == null) {
			instance = new ClipResource();
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
			List<ClipObject> listClipObjects = new ArrayList<ClipObject>();
			List<Clip> listClip= ClipLocalServiceUtil.getListClip(q, groupId, start, limit);
			for (Clip clip : listClip) {
				ClipObject clipObject = new ClipObject();
				clipObject.setCategoryId(clip.getCategoryId());
				clipObject.setClipAttachId(clip.getClipAttachId());
				clipObject.setCompanyId(clip.getCompanyId());
				clipObject.setCreateByUser(clip.getCreateByUser());
				clipObject.setCreateDate(clip.getCreateDate());
				clipObject.setDescription(HtmlUtil.extractText(clip.getDescription()));
				clipObject.setDisplay(clip.getDisplay());
	
				clipObject.setGroupId(clip.getGroupId());
				clipObject.setId(clip.getId());
				clipObject.setImageAttachId(clip.getImageAttachId());
				clipObject.setIsAudio(clip.getIsAudio());
				clipObject.setIsDaiDien(clip.getIsDaiDien());
				clipObject.setLikeCount(clip.getLikeCount());
				clipObject.setModifiedByUser(clip.getModifiedByUser());
				clipObject.setModifiedDate(clip.getModifiedDate());
				clipObject.setNguonVideo(HtmlUtil.extractText(clip.getNguonVideo()));
				clipObject.setTacGia(HtmlUtil.extractText(clip.getTacGia()));
				clipObject.setThoiLuongVideo(HtmlUtil.extractText(clip.getThoiLuongVideo()));
				clipObject.setTitle(HtmlUtil.extractText(clip.getTitle()));
				clipObject.setViewCount(clip.getViewCount());
				clipObject.setClipFileId(clip.getClipFileId());
				clipObject.setFolderId(clip.getFolderId());
				clipObject.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
				List<Category> caList= CategoryLocalServiceUtil.getTitleCate(groupId, clip.getCategoryId());
				List<CategoryObject> liObjects= new ArrayList<CategoryObject>();
				for (Category cate : caList) {
					CategoryObject categoryObject= new CategoryObject();
					categoryObject.setTitle(HtmlUtil.extractText(cate.getTitle()));
					liObjects.add(categoryObject);
				}
				clipObject.setCateTitle(liObjects);
				listClipObjects.add(clipObject);
			}
			int total = ClipLocalServiceUtil.getCount(q, groupId);
			if(total <0) {
				return DataRespone.FAILED;
			}
			
			node.put("total", total);
			node.putPOJO("data", listClipObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/getall-byid/{groupId}/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getallByid(@PathParam("groupId")long groupId,@PathParam("id")long id, @DefaultValue("-1") @QueryParam("limit")int limit,
			@DefaultValue("0") @QueryParam("start")int start,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId< 0|| start<0) {
				return DataRespone.PARAM_ERROR;
			}
			q= HtmlUtil.escape(q);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			List<ClipObject> listClipObjects = new ArrayList<ClipObject>();
			List<Clip> listClip= ClipLocalServiceUtil.getListDetail(q, id, groupId, start, limit);
			for (Clip clip : listClip) {
				ClipObject clipObject = new ClipObject();
				clipObject.setCategoryId(clip.getCategoryId());
				clipObject.setClipAttachId(clip.getClipAttachId());
				clipObject.setCompanyId(clip.getCompanyId());
				clipObject.setCreateByUser(clip.getCreateByUser());
				clipObject.setCreateDate(clip.getCreateDate());
				clipObject.setDescription(HtmlUtil.extractText(clip.getDescription()));
				clipObject.setDisplay(clip.getDisplay());
	
				clipObject.setGroupId(clip.getGroupId());
				clipObject.setId(clip.getId());
				clipObject.setImageAttachId(clip.getImageAttachId());
				clipObject.setIsAudio(clip.getIsAudio());
				clipObject.setIsDaiDien(clip.getIsDaiDien());
				clipObject.setLikeCount(clip.getLikeCount());
				clipObject.setModifiedByUser(clip.getModifiedByUser());
				clipObject.setModifiedDate(clip.getModifiedDate());
				clipObject.setNguonVideo(HtmlUtil.extractText(clip.getNguonVideo()));
				clipObject.setTacGia(HtmlUtil.extractText(clip.getTacGia()));
				clipObject.setThoiLuongVideo(HtmlUtil.extractText(clip.getThoiLuongVideo()));
				clipObject.setTitle(HtmlUtil.extractText(clip.getTitle()));
				clipObject.setViewCount(clip.getViewCount());
				clipObject.setClipFileId(clip.getClipFileId());
				clipObject.setFolderId(clip.getFolderId());
				clipObject.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
				List<Category> caList= CategoryLocalServiceUtil.getTitleCate(groupId, clip.getCategoryId());
				List<CategoryObject> liObjects= new ArrayList<CategoryObject>();
				for (Category cate : caList) {
					CategoryObject categoryObject= new CategoryObject();
					categoryObject.setTitle(HtmlUtil.extractText(cate.getTitle()));
					liObjects.add(categoryObject);
				}
				clipObject.setCateTitle(liObjects);
				listClipObjects.add(clipObject);
			}
			int total = ClipLocalServiceUtil.getCountDisplay(q, groupId)-1;
			if(total <0) {
				return DataRespone.FAILED;
			}
			
			node.put("total", total);
			node.putPOJO("data", listClipObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/getall-display/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getallDisplay(@PathParam("groupId")long groupId, @DefaultValue("-1") @QueryParam("limit")int limit,
			@DefaultValue("0") @QueryParam("start")int start,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId< 0|| start<0) {
				return DataRespone.PARAM_ERROR;
			}
			q= HtmlUtil.escape(q);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			List<ClipObject> listClipObjects = new ArrayList<ClipObject>();
			List<Clip> listClip= ClipLocalServiceUtil.getListClipDisplay(q, groupId, start, limit);
			for (Clip clip : listClip) {
				ClipObject clipObject = new ClipObject();
				clipObject.setCategoryId(clip.getCategoryId());
				clipObject.setClipAttachId(clip.getClipAttachId());
				clipObject.setCompanyId(clip.getCompanyId());
				clipObject.setCreateByUser(clip.getCreateByUser());
				clipObject.setCreateDate(clip.getCreateDate());
				clipObject.setDescription(clip.getDescription());
				clipObject.setDisplay(clip.getDisplay());
	
				clipObject.setGroupId(clip.getGroupId());
				clipObject.setId(clip.getId());
				clipObject.setImageAttachId(clip.getImageAttachId());
				clipObject.setIsAudio(clip.getIsAudio());
				clipObject.setIsDaiDien(clip.getIsDaiDien());
				clipObject.setLikeCount(clip.getLikeCount());
				clipObject.setModifiedByUser(clip.getModifiedByUser());
				clipObject.setModifiedDate(clip.getModifiedDate());
				clipObject.setNguonVideo(HtmlUtil.extractText(clip.getNguonVideo()));
				clipObject.setTacGia(HtmlUtil.extractText(clip.getTacGia()));
				clipObject.setThoiLuongVideo(HtmlUtil.extractText(clip.getThoiLuongVideo()));
				clipObject.setTitle(HtmlUtil.extractText(clip.getTitle()));
				clipObject.setViewCount(clip.getViewCount());
				clipObject.setClipFileId(clip.getClipFileId());
				clipObject.setFolderId(clip.getFolderId());
				clipObject.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
				listClipObjects.add(clipObject);
			}
			int total = ClipLocalServiceUtil.getCountDisplay(q, groupId);
			if(total <0) {
				return DataRespone.FAILED;
			}
			node.put("total", total);
			node.putPOJO("data", listClipObjects);
			arrNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, arrNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/getclipbycategory/{groupId}/{categoryId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getClipByParams(@PathParam("categoryId")long categoryId,@PathParam("groupId")long groupId, @DefaultValue("-1") @QueryParam("limit")int limit,
			@DefaultValue("0") @QueryParam("start")int start,@DefaultValue("") @QueryParam("q") String q) {
		try {
			if(groupId< 0|| start<0) {
				return DataRespone.PARAM_ERROR;
			}
			q= HtmlUtil.escape(q);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			List<ClipObject> listClipObjects = new ArrayList<ClipObject>();
			List<Clip> listClip= ClipLocalServiceUtil.getListByCategory(q, categoryId, groupId, start, limit);
			for (Clip clip : listClip) {
				ClipObject clipObject = new ClipObject();
				clipObject.setCategoryId(clip.getCategoryId());
				clipObject.setClipAttachId(clip.getClipAttachId());
				clipObject.setCompanyId(clip.getCompanyId());
				clipObject.setCreateByUser(clip.getCreateByUser());
				clipObject.setCreateDate(clip.getCreateDate());
				clipObject.setDescription(clip.getDescription());
				clipObject.setDisplay(clip.getDisplay());
				clipObject.setGroupId(clip.getGroupId());
				clipObject.setId(clip.getId());
				clipObject.setImageAttachId(clip.getImageAttachId());
				clipObject.setIsAudio(clip.getIsAudio());
				clipObject.setIsDaiDien(clip.getIsDaiDien());
				clipObject.setLikeCount(clip.getLikeCount());
				clipObject.setModifiedByUser(clip.getModifiedByUser());
				clipObject.setModifiedDate(clip.getModifiedDate());
				clipObject.setNguonVideo(clip.getNguonVideo());
				clipObject.setTacGia(clip.getTacGia());
				clipObject.setThoiLuongVideo(clip.getThoiLuongVideo());
				clipObject.setTitle(clip.getTitle());
				clipObject.setViewCount(clip.getViewCount());
				clipObject.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
			
				listClipObjects.add(clipObject);
			}
//			int total = ClipLocalServiceUtil.getCountByCategory(q, groupId, categoryId) 	;
//			
//			if(total <0) {
//				return DataRespone.FAILED;
//			}
//			System.out.println(total);
//			node.put("total", total);
			node.putPOJO("data", listClipObjects);
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone createClip(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		ClipObject clipObject= new ClipObject();
		try {
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			File videoFile = upload.getFile("videos");
			Clip clip = ClipLocalServiceUtil.createClip(0);
			if(upload.getFile("videos") != null && upload.getFile("videos").isFile()) {
				if (videoFile != null && videoFile.getName().length() > 0) {
					String titlevideos = upload.getFileName("videos");
				
					long videoId = AttachmentUtil.uploadFile(upload, clip, videoFile, titlevideos, groupId,userId);
					clip.setClipFileId(videoId);
					clip.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
				
				}
			}else {
				
			}
			
			String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String nguonVideo= HtmlUtil.escape(ParamUtil.getString(request, "nguonVideo",""));
			String tacGia= HtmlUtil.escape(ParamUtil.getString(request, "tacGia",""));
			String thoiLuongVideo= HtmlUtil.escape(ParamUtil.getString(request, "thoiLuongVideo",""));
			long categoryId= ParamUtil.getLong(request, "categoryId",0);
			boolean display = ParamUtil.getBoolean(request, "display", false);
			boolean isDaiDien = ParamUtil.getBoolean(request, "isDaiDien", false);
			Date date= new Date();
			if(title != null && !title.equals("")) {
				clip.setTitle(title);
				clip.setDescription(description); 
				clip.setCreateDate(new Date());
				clip.setGroupId(groupId);
				clip.setNguonVideo(nguonVideo);
				clip.setTacGia(tacGia);
				clip.setThoiLuongVideo(thoiLuongVideo);
				clip.setDisplay(display);
				clip.setIsDaiDien(isDaiDien);
				clip.setCategoryId(categoryId);
				clip= ClipLocalServiceUtil.addClip(clip);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, clipObject, DataType.JSON_STR);
			}
			
			clipObject.setId(clip.getId());
			clipObject.setTitle(clip.getTitle());
			clipObject.setClipFileId(clip.getClipFileId());
			clipObject.setFolderId(clip.getFolderId());
			clipObject.setDescription(clip.getDescription());
			clipObject.setTacGia(clip.getTacGia());
			clipObject.setGroupId(clip.getGroupId());
			clipObject.setCreateDate(clip.getCreateDate());
			clipObject.setClipFileId(clip.getClipFileId());
			clipObject.setFolderId(clip.getFolderId());
			clipObject.setDisplay(clip.getDisplay());
			clipObject.setIsDaiDien(clip.getIsDaiDien());
			clipObject.setCategoryId(clip.getCategoryId());
			clipObject.setThoiLuongVideo(clip.getThoiLuongVideo());
			clipObject.setNguonVideo(clip.getNguonVideo());
			clipObject.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
			
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, clipObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone updateClip(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id,
			@Context HttpServletRequest request) {
		ClipObject clipObject= new ClipObject();
		
		try {
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			File videoFile = upload.getFile("videos");
			
	
		
			Clip clip = ClipLocalServiceUtil.getClip(id);
			if(upload.getFile("videos") != null && upload.getFile("videos").isFile()) {
				if (videoFile != null && videoFile.getName().length() > 0) {
					if(clip.getClipUrl()!="") {
						DLAppLocalServiceUtil.deleteFileEntry(clip.getClipFileId());
					}
					String titlevideos = upload.getFileName("videos");			
					long videoId = AttachmentUtil.uploadFile(upload, clip, videoFile, titlevideos, groupId,userId);
					clip.setClipFileId(videoId);
					clip.setClipUrl(AttachmentUtil.viewDocument(clip.getClipFileId()));
				}
			}else {
				
			}
	
			String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
			String description= HtmlUtil.escape(ParamUtil.getString(request, "description",""));
			String nguonVideo= HtmlUtil.escape(ParamUtil.getString(request, "nguonVideo",""));
			String tacGia= HtmlUtil.escape(ParamUtil.getString(request, "tacGia",""));
			String thoiLuongVideo= HtmlUtil.escape(ParamUtil.getString(request, "thoiLuongVideo",""));
			long categoryId= ParamUtil.getLong(request, "categoryId",0);
			boolean display = ParamUtil.getBoolean(request, "display", false);
			boolean isDaiDien = ParamUtil.getBoolean(request, "isDaiDien", false);
			Date date= new Date();
			clip.setTitle(title); 
			clip.setDescription(description);
			clip.setCreateDate(new Date());
			clip.setGroupId(groupId);
			clip.setNguonVideo(nguonVideo);
			clip.setTacGia(tacGia);
			clip.setThoiLuongVideo(thoiLuongVideo);
			clip.setDisplay(display);
			clip.setIsDaiDien(isDaiDien);
			clip.setCategoryId(categoryId);
		
			clip= ClipLocalServiceUtil.updateClip(clip);
			
			clipObject.setId(clip.getId());
			clipObject.setTitle(clip.getTitle());
			clipObject.setClipFileId(clip.getClipFileId());
			clipObject.setFolderId(clip.getFolderId());
			clipObject.setDescription(clip.getDescription());
			clipObject.setTacGia(clip.getTacGia());
			clipObject.setGroupId(clip.getGroupId());
			clipObject.setCreateDate(clip.getCreateDate());
			clipObject.setClipFileId(clip.getClipFileId());
			clipObject.setFolderId(clip.getFolderId());
			clipObject.setDisplay(clip.getDisplay());
			clipObject.setIsDaiDien(clip.getIsDaiDien());
			clipObject.setCategoryId(clip.getCategoryId());
			clipObject.setThoiLuongVideo(clip.getThoiLuongVideo());
			clipObject.setNguonVideo(clip.getNguonVideo()); 
			clipObject.setClipUrl(clip.getClipUrl());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, clipObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	
	@GET
	@Path("/getclip/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getClipById(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			Clip clip= ClipLocalServiceUtil.getClip(id);
			clip.setViewCount(clip.getViewCount()+1);
			ClipLocalServiceUtil.updateClip(clip);
			ClipObject clipObject= new ClipObject(id, groupId, clip.getCompanyId(), clip.getCreateDate(), clip.getCreateByUser(), clip.getModifiedDate(), clip.getModifiedByUser(), HtmlUtil.extractText(clip.getTitle()), HtmlUtil.extractText(clip.getDescription()), clip.getClipAttachId(), clip.getImageAttachId(), clip.getViewCount(), clip.getLikeCount(), clip.getCategoryId(), clip.getIsAudio(), clip.getDisplay(), HtmlUtil.extractText(clip.getNguonVideo()), HtmlUtil.extractText(clip.getTacGia()), HtmlUtil.extractText(clip.getThoiLuongVideo()), clip.getIsDaiDien(), clip.getClipFileId(), clip.getFolderId(),AttachmentUtil.viewDocument(clip.getClipFileId()));
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, clipObject,DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	
	@DELETE
	@Path("/delete/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteClip(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			Clip clip= ClipLocalServiceUtil.getClip(id);
			System.out.println(clip);
			if(clip.getClipUrl()!="") {
				DLAppLocalServiceUtil.deleteFileEntry(clip.getClipFileId());
			}
			ClipLocalServiceUtil.deleteClip(clip);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	@POST
	@Path("/delete-mutiple/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteClips(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@Context HttpServletRequest request) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			long [] ids= ParamUtil.getLongValues(request, "ids",null);
			for (long id : ids) {
				Clip clip= ClipLocalServiceUtil.getClip(id);
				if(clip.getClipUrl()!="") {
					DLAppLocalServiceUtil.deleteFileEntry(clip.getClipFileId());
				}
				ClipLocalServiceUtil.deleteClip(clip);
			}
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}

	
}








