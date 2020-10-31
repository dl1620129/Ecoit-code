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

import User.Rank.Poisition.Service.model.UserPoisition;
import User.Rank.Poisition.Service.service.UserChucDanhLocalServiceUtil;
import User.Rank.Poisition.Service.service.UserPoisitionLocalServiceUtil;
import User.Rank.Poisition.Service.service.util.DataRespone;
import User.Rank.Poisition.Service.service.util.ResponeCode;
import User.Rank.Poisition.Service.service.util.DataRespone.DataType;
import UserRank.Poisition.Api.object.UserPoisitionObject;

@Path("/position")
public class UserPoisitionResource {
	private static UserPoisitionResource instance = null;

	public static UserPoisitionResource getInstance() {
		if (instance == null) {
			instance = new UserPoisitionResource();
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
			List<UserPoisitionObject> lPoisitionObjects= new ArrayList<UserPoisitionObject>();
			List<UserPoisition> userPoisitions= UserPoisitionLocalServiceUtil.getListUserPoisition(groupId, q, start, limit);
			for (UserPoisition userPoisition : userPoisitions) {
				UserPoisitionObject userPoisitionObject= new UserPoisitionObject();
				userPoisitionObject.setUserPoisitionName(HtmlUtil.extractText(userPoisition.getUserPoisitionName()));
				userPoisitionObject.setDescription(HtmlUtil.extractText(userPoisition.getDescription()));
				userPoisitionObject.setCreateDate(userPoisition.getCreateDate());
				userPoisitionObject.setModifiedDate(userPoisition.getModifiedDate());
				userPoisitionObject.setUserPoisitionId(userPoisition.getUserPoisitionId());
				lPoisitionObjects.add(userPoisitionObject);

			}
			int total=0;
			total= UserPoisitionLocalServiceUtil.getCountAll(q, groupId);
			if(total<0) {
				return DataRespone.FAILED;
			}
			node.putPOJO("userChucDanh", lPoisitionObjects);
			node.put("total", total);
			arrayNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/getall-chucvu/{groupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone getAllChucVu(@PathParam("groupId")long groupId,@DefaultValue("0") @QueryParam("start")int start
			,@DefaultValue("-1") @QueryParam("limit")int limit,@DefaultValue("") @QueryParam("q")String q) {
		try {
			if(groupId<0) {
				return DataRespone.PARAM_ERROR;
			}
		
			ObjectMapper mapper= new ObjectMapper();
			ArrayNode arrayNode= mapper.createArrayNode();
			ObjectNode node= mapper.createObjectNode();
			List<UserPoisitionObject> lPoisitionObjects= new ArrayList<UserPoisitionObject>();
			List<UserPoisition> userPoisitions= UserPoisitionLocalServiceUtil.getListUserPoisition(groupId, q, start, limit);
			for (UserPoisition userPoisition : userPoisitions) {
				UserPoisitionObject userPoisitionObject= new UserPoisitionObject();
				userPoisitionObject.setUserPoisitionName(HtmlUtil.extractText(userPoisition.getUserPoisitionName()));
				userPoisitionObject.setDescription(HtmlUtil.extractText(userPoisition.getDescription()));
				userPoisitionObject.setCreateDate(userPoisition.getCreateDate());
				userPoisitionObject.setModifiedDate(userPoisition.getModifiedDate());
				userPoisitionObject.setUserPoisitionId(userPoisition.getUserPoisitionId());
				lPoisitionObjects.add(userPoisitionObject);

			}
			
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, lPoisitionObjects, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createUserRank(@PathParam("groupId") long groupId,
			UserPoisitionObject userPoisitionObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(userPoisitionObject.getUserPoisitionName());
			String description = HtmlUtil.escape(userPoisitionObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserPoisition userPoisition =UserPoisitionLocalServiceUtil.createUserPoisition(0);
			userPoisition.setUserPoisitionName(name);
			userPoisition.setDescription(description);
			userPoisition.setGroupId(groupId);
			userPoisition.setCreateDate(dateNow);
			userPoisition = UserPoisitionLocalServiceUtil.addUserPoisition(userPoisition);
						
		
		
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
			UserPoisitionObject userPoisitionObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(userPoisitionObject.getUserPoisitionName());
			String description = HtmlUtil.escape(userPoisitionObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserPoisition userPoisition =UserPoisitionLocalServiceUtil.getUserPoisition(id);
			userPoisition.setUserPoisitionName(name);
			userPoisition.setDescription(description);
			userPoisition.setGroupId(groupId);
			userPoisition.setModifiedDate(dateNow);
			userPoisition = UserPoisitionLocalServiceUtil.updateUserPoisition(userPoisition);
						
		
		
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
			UserPoisition userPoisition= UserPoisitionLocalServiceUtil.deleteUserPoisition(id);			
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
				UserPoisitionLocalServiceUtil.deleteUserPoisition(long1);
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
			UserPoisition userPoisition= UserPoisitionLocalServiceUtil.getUserPoisition(id);
			UserPoisitionObject UserPoisitionObject= new UserPoisitionObject(userPoisition.getUserPoisitionId(), HtmlUtil.extractText(userPoisition.getUserPoisitionName()), userPoisition.getCreateDate(), userPoisition.getModifiedDate(),HtmlUtil.extractText(userPoisition.getDescription()), userPoisition.getTotalMember());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, UserPoisitionObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
}
