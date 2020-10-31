package UserRank.Poisition.Api.resource;

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

import User.Rank.Poisition.Service.model.UserChucDanh;
import User.Rank.Poisition.Service.model.UserChucDanh;
import User.Rank.Poisition.Service.service.UserChucDanhLocalServiceUtil;
import User.Rank.Poisition.Service.service.UserPoisition_DangLocalServiceUtil;
import User.Rank.Poisition.Service.service.util.DataRespone;
import User.Rank.Poisition.Service.service.util.ResponeCode;
import User.Rank.Poisition.Service.service.util.DataRespone.DataType;
import UserRank.Poisition.Api.object.UserChucDanhObject;
import UserRank.Poisition.Api.object.UserChucDanhObject;

@Path("/chucdanh")
public class UserChucDanhResource {
	private static UserChucDanhResource instance = null;

	public static UserChucDanhResource getInstance() {
		if (instance == null) {
			instance = new UserChucDanhResource();
		}
		return instance;
	}
	@GET
	@Path("/getall/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getAll(@PathParam("groupId")long groupId,@DefaultValue("0") @QueryParam("start")int start
			,@DefaultValue("-1") @QueryParam("limit")int limit,@DefaultValue("") @QueryParam("q")String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
		
			ObjectMapper mapper= new ObjectMapper();
			ArrayNode arrayNode= mapper.createArrayNode();
			ObjectNode node= mapper.createObjectNode();
			List<UserChucDanhObject> liChucDanhObjects= new ArrayList<UserChucDanhObject>();
			List<UserChucDanh> UserChucDanhs= UserChucDanhLocalServiceUtil.getListUserChucDanh(groupId, q, start, limit);
			for (UserChucDanh UserChucDanh : UserChucDanhs) {
				UserChucDanhObject UserChucDanhObject= new UserChucDanhObject();
				UserChucDanhObject.setUserChuDanhName(HtmlUtil.extractText(UserChucDanh.getUserChucDanhName()));
				UserChucDanhObject.setDescription(HtmlUtil.extractText(UserChucDanh.getDescription()));
				UserChucDanhObject.setCreateDate(UserChucDanh.getCreateDate());
				UserChucDanhObject.setModifiedDate(UserChucDanh.getModifiedDate());
				UserChucDanhObject.setUserChuDanhId(UserChucDanh.getUserChucDanhId());
				liChucDanhObjects.add(UserChucDanhObject);

			}
			int total=0;
			total= UserChucDanhLocalServiceUtil.getCountAll(q, groupId);
			if(total<0) {
				return DataRespone.FAILED;
			}
			node.putPOJO("userChucDanh", liChucDanhObjects);
			node.put("total", total);
			arrayNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/getall-chucdanh/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getAllChucDanh(@PathParam("groupId")long groupId,@DefaultValue("0") @QueryParam("start")int start
			,@DefaultValue("-1") @QueryParam("limit")int limit,@DefaultValue("") @QueryParam("q")String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
		
			ObjectMapper mapper= new ObjectMapper();
			ArrayNode arrayNode= mapper.createArrayNode();
			ObjectNode node= mapper.createObjectNode();
			List<UserChucDanhObject> liChucDanhObjects= new ArrayList<UserChucDanhObject>();
			List<UserChucDanh> UserChucDanhs= UserChucDanhLocalServiceUtil.getListUserChucDanh(groupId, q, start, limit);
			for (UserChucDanh UserChucDanh : UserChucDanhs) {
				UserChucDanhObject UserChucDanhObject= new UserChucDanhObject();
				UserChucDanhObject.setUserChuDanhName(HtmlUtil.extractText(UserChucDanh.getUserChucDanhName()));
				UserChucDanhObject.setDescription(HtmlUtil.extractText(UserChucDanh.getDescription()));
				UserChucDanhObject.setCreateDate(UserChucDanh.getCreateDate());
				UserChucDanhObject.setModifiedDate(UserChucDanh.getModifiedDate());
				UserChucDanhObject.setUserChuDanhId(UserChucDanh.getUserChucDanhId());
				liChucDanhObjects.add(UserChucDanhObject);

			}
			int total=0;
			total= UserChucDanhLocalServiceUtil.getCountAll(q, groupId);
			if(total<0) {
				return DataRespone.FAILED;
			}
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, liChucDanhObjects, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createUserRank(@PathParam("groupId") long groupId,
			UserChucDanhObject UserChucDanhObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(UserChucDanhObject.getUserChuDanhName());
			String description = HtmlUtil.escape(UserChucDanhObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserChucDanh UserChucDanh =UserChucDanhLocalServiceUtil.createUserChucDanh(0);
			UserChucDanh.setUserChucDanhName(name);
			UserChucDanh.setDescription(description);
			UserChucDanh.setGroupId(groupId);
			UserChucDanh.setCreateDate(dateNow);
			UserChucDanh = UserChucDanhLocalServiceUtil.addUserChucDanh(UserChucDanh);
						
		
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone updateUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id,
			UserChucDanhObject UserChucDanhObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(UserChucDanhObject.getUserChuDanhName());
			String description = HtmlUtil.escape(UserChucDanhObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserChucDanh UserChucDanh =UserChucDanhLocalServiceUtil.getUserChucDanh(id);
			UserChucDanh.setUserChucDanhName(name);
			UserChucDanh.setDescription(description);
			UserChucDanh.setGroupId(groupId);
			UserChucDanh.setModifiedDate(dateNow);
			UserChucDanh = UserChucDanhLocalServiceUtil.updateUserChucDanh(UserChucDanh);
						
		
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@DELETE
	@Path("/delete/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone deleteUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			UserChucDanh UserChucDanh= UserChucDanhLocalServiceUtil.deleteUserChucDanh(id);			
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@POST
	@Path("/delete-mutiple/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataRespone deleteMutiple(@PathParam("groupId") long groupId,@Context HttpServletRequest request) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
			long [] body = ParamUtil.getLongValues(request, "ids", null);
			for (long long1 : body) {
				UserChucDanhLocalServiceUtil.deleteUserChucDanh(long1);
			}	
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@GET
	@Path("/getdetail/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			UserChucDanh UserChucDanh= UserChucDanhLocalServiceUtil.getUserChucDanh(id);
			UserChucDanhObject UserChucDanhObject= new UserChucDanhObject(UserChucDanh.getUserChucDanhId(), UserChucDanh.getUserChucDanhName(), UserChucDanh.getCreateDate(), UserChucDanh.getModifiedDate(),UserChucDanh.getDescription(), UserChucDanh.getTotalMember());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, UserChucDanhObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
}
