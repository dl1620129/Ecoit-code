package organizationalStructure.api.Resource;

import java.io.File;
import java.text.SimpleDateFormat;
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


import organizationalStructure.api.Object.MemberObject;
import organizationalStructure.api.Upload.AttachmentUtil;
import organizationalStructure.service.model.member;
import organizationalStructure.service.model.members;
import organizationalStructure.service.service.memberLocalServiceUtil;
import organizationalStructure.service.service.utils.DataRespone;
import organizationalStructure.service.service.utils.ResponeCode;
import organizationalStructure.service.service.utils.DataRespone.DataType;

@Path("/leader")
public class MemberResource {
	private static MemberResource instance = null;

	public static MemberResource getInstance() {
		if (instance == null) {
			instance = new MemberResource();
		}
		return instance;
	}
	@GET
	@Path("/getall/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getAll(@PathParam("groupId") long groupId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);

			if (groupId < 0 || limit<0 || start<0 ) {
				return DataRespone.PARAM_ERROR;
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayNode arrayNode= objectMapper.createArrayNode();
			ObjectNode objectNode= objectMapper.createObjectNode();
			List<member> listMember= memberLocalServiceUtil.getListMember(groupId, q, start, limit);
			List<MemberObject> lisMemberObjects= new ArrayList<MemberObject>();
			for (member member : listMember) {
				MemberObject memberObject= new MemberObject();
				memberObject.setFullName(HtmlUtil.extractText(member.getFullName()));
				memberObject.setAddress(HtmlUtil.extractText(member.getAddress()));
				memberObject.setBirthday(member.getBirthday());
				memberObject.setGroupId(member.getGroupId());
				memberObject.setIsLeader(member.getIsLeader());
				memberObject.setPosition(HtmlUtil.extractText(member.getPosition()));
				memberObject.setSex(member.getSex());
				memberObject.setMemberId(member.getMemberId());
				memberObject.setCreateDate(member.getCreateDate());
				memberObject.setOrganizationId(member.getOrganizationId());
				memberObject.setUrlImage(AttachmentUtil.viewDocument(member.getImageFileId()));
				lisMemberObjects.add(memberObject);
				
				}
			int total;
			total= memberLocalServiceUtil.getCount(groupId, q);
			objectNode.putPOJO("data", lisMemberObjects);
			objectNode.put("total", total);
			arrayNode.add(objectNode);
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		}catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
			
			
	}
	@GET
	@Path("/get-by-organization/{groupId}/{organizationId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getByOrgan(@PathParam("groupId") long groupId,@PathParam("organizationId") long organizationId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start) {
		try {
		

			if (groupId < 0 || limit<0 || start<0 || organizationId <0) {
				return DataRespone.PARAM_ERROR;
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayNode arrayNode= objectMapper.createArrayNode();
			ObjectNode objectNode= objectMapper.createObjectNode();
			List<member> listMember= memberLocalServiceUtil.getListMemberByOrganId(groupId, organizationId, start, limit);
			List<MemberObject> lisMemberObjects= new ArrayList<MemberObject>();
			for (member member : listMember) {
				MemberObject memberObject= new MemberObject();
				memberObject.setFullName(HtmlUtil.extractText(member.getFullName()));
				memberObject.setAddress(HtmlUtil.extractText(member.getAddress()));
				memberObject.setBirthday(member.getBirthday());
				memberObject.setGroupId(member.getGroupId());
				memberObject.setPosition(HtmlUtil.extractText(member.getPosition()));
				memberObject.setSex(member.getSex());
				memberObject.setIsLeader(member.getIsLeader());
				memberObject.setMemberId(member.getMemberId());
				memberObject.setCreateDate(member.getCreateDate());
				memberObject.setOrganizationId(member.getOrganizationId());
				memberObject.setUrlImage(AttachmentUtil.viewDocument(member.getImageFileId()));
				lisMemberObjects.add(memberObject);
				}
	
			int total;
			total= memberLocalServiceUtil.getCountByOrgan(groupId, organizationId);
			objectNode.putPOJO("data", lisMemberObjects);
			objectNode.put("total", total);
	
			arrayNode.add(objectNode);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		}catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
			
			
	}
	@POST
	@Path("/create/{groupId}/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone createMember(@PathParam("groupId") long groupId,@PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		MemberObject memberObject= new MemberObject();
		try {
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			
			File imageFile = upload.getFile("images");
			
			member member = memberLocalServiceUtil.createmember(0);
			if(upload.getFile("images") != null && upload.getFile("images").isFile()) {
				if (imageFile != null && imageFile.getName().length() > 0) {
					String titleimages = upload.getFileName("images");
					long imageId = AttachmentUtil.uploadFile(upload, member, imageFile, titleimages, groupId,userId);
					member.setImageFileId(imageId);
				
//					DLAppLocalServiceUtil.deleteFileEntry(videoId);
				}
			}else {
				
			}
			
			String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
			String address= HtmlUtil.escape(ParamUtil.getString(request, "address",""));
			String position= HtmlUtil.escape(ParamUtil.getString(request, "position",""));
			SimpleDateFormat a= new SimpleDateFormat("yyyy/MM/dd");
			Date birthday= ParamUtil.getDate(request, "birthday",a );
			long organizationId= ParamUtil.getLong(request, "organizationId",0);
			boolean sex = ParamUtil.getBoolean(request, "sex", false);
			boolean isLeader = ParamUtil.getBoolean(request, "isLeader", false);

			if(fullName != null && !fullName.equals("")) {
				member.setFullName(fullName);
				member.setAddress(address);
				member.setBirthday(birthday);
				member.setCreateDate(new Date());
				member.setGroupId(groupId);
				member.setPosition(position);
				member.setSex(sex);
				member.setIsLeader(isLeader);
				member.setSex(sex);
				member.setOrganizationId(organizationId);
				
				member= memberLocalServiceUtil.addmember(member);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, memberObject, DataType.JSON_STR);
			}
	
			memberObject.setFullName(member.getFullName());
			memberObject.setAddress(member.getAddress());
			memberObject.setBirthday(member.getBirthday());
			memberObject.setGroupId(member.getGroupId());
			memberObject.setPosition(member.getPosition());
			memberObject.setSex(member.getSex());
			memberObject.setMemberId(member.getMemberId());
			memberObject.setCreateDate(member.getCreateDate());
			memberObject.setOrganizationId(member.getOrganizationId());
			memberObject.setIsLeader(member.getIsLeader());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, memberObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
	
	}
	@GET
	@Path("/getmember/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getMemberById(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node= mapper.createObjectNode();
			ArrayNode arrNode= mapper.createArrayNode();
			member member = memberLocalServiceUtil.getmember(id);
			MemberObject memberObject = new MemberObject(HtmlUtil.extractText(member.getFullName()),HtmlUtil.extractText(member.getAddress()), HtmlUtil.extractText(member.getPosition()), member.getMemberId(), member.getGroupId(), member.getOrganizationId(), member.getCreateUser(), member.getModifiedUser(), member.getBirthday(), member.getCreateDate(), member.getModifiedDate(), member.getSex(), member.getIsLeader(), AttachmentUtil.viewDocument(member.getImageFileId()), member.getFolderId(), member.getImageFileId());
		
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, memberObject,DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
	@PUT
	@Path("/update/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone updateMember(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id,
			@Context HttpServletRequest request) {
		MemberObject memberObject= new MemberObject();
		try {
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			
			File imageFile = upload.getFile("images");
			
			member member = memberLocalServiceUtil.getmember(id);
			if(upload.getFile("images") != null && upload.getFile("images").isFile()) {
				if (imageFile != null && imageFile.getName().length() > 0) {
					String titleimages = upload.getFileName("images");
					long memberId = AttachmentUtil.uploadFile(upload, member, imageFile, titleimages, groupId,userId);
					member.setImageFileId(memberId);
//					DLAppLocalServiceUtil.deleteFileEntry(videoId);
				}
			}else {
				
			}
			
			String fullName = HtmlUtil.escape(ParamUtil.getString(request, "fullName", ""));
			String address= HtmlUtil.escape(ParamUtil.getString(request, "address",""));
			String position= HtmlUtil.escape(ParamUtil.getString(request, "position",""));
			SimpleDateFormat a= new SimpleDateFormat("yyyy/MM/dd");
			Date birthday= ParamUtil.getDate(request, "birthday",a );
			long organizationId= ParamUtil.getLong(request, "organizationId",0);
			boolean sex = ParamUtil.getBoolean(request, "sex", false);
			boolean isLeader = ParamUtil.getBoolean(request, "isLeader", false);
		
			if(fullName != null && !fullName.equals("")) {
				member.setFullName(fullName);
				member.setAddress(address);
				member.setBirthday(birthday);
				member.setModifiedDate(new Date());
				member.setGroupId(groupId);
				member.setPosition(position);
				member.setSex(sex);
				member.setIsLeader(isLeader);
				member.setSex(sex);
				member.setOrganizationId(organizationId);
				
				member= memberLocalServiceUtil.updatemember(member);
			}else {
				return new DataRespone(ResponeCode.PARAM_ERROR,ResponeCode.PARAM_ERROR, memberObject, DataType.JSON_STR);
			}
			
			memberObject.setFullName(member.getFullName());
			memberObject.setAddress(member.getAddress());
			memberObject.setBirthday(member.getBirthday());
			memberObject.setGroupId(member.getGroupId());
			memberObject.setPosition(member.getPosition());
			memberObject.setSex(member.getSex());
			memberObject.setMemberId(member.getMemberId());
			memberObject.setCreateDate(member.getCreateDate());
			memberObject.setModifiedDate(member.getModifiedDate());
			memberObject.setOrganizationId(member.getOrganizationId());
			memberObject.setIsLeader(member.getIsLeader());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, memberObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@DELETE
	@Path("/delete/{groupId}/{userId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone deleteMember(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId < 0 || userId < 0 ) {
				return DataRespone.PARAM_ERROR;
			}
			member member= memberLocalServiceUtil.getmember(id);
			DLAppLocalServiceUtil.deleteFileEntry(member.getImageFileId());
			memberLocalServiceUtil.deletemember(id);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, "",DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(),DataType.JSON_STR);
		}
		
	}
}
