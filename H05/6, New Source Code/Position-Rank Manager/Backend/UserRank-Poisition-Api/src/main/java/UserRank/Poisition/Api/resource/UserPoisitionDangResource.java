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

import User.Rank.Poisition.Service.model.UserPoisition_Dang;
import User.Rank.Poisition.Service.service.UserPoisition_DangLocalServiceUtil;
import User.Rank.Poisition.Service.service.util.DataRespone;
import User.Rank.Poisition.Service.service.util.DataRespone.DataType;
import User.Rank.Poisition.Service.service.util.ResponeCode;
import UserRank.Poisition.Api.object.UserPoisitionDangObject;

@Path("/dang/poisition")
public class UserPoisitionDangResource {
	private static UserPoisitionDangResource instance = null;

	public static UserPoisitionDangResource getInstance() {
		if (instance == null) {
			instance = new UserPoisitionDangResource();
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
			System.out.println("getall"); 
			ObjectMapper mapper= new ObjectMapper();
			ArrayNode arrayNode= mapper.createArrayNode();
			ObjectNode node= mapper.createObjectNode();
			List<UserPoisitionDangObject> lPoisitionDangObjects= new ArrayList<UserPoisitionDangObject>();
			List<UserPoisition_Dang> userPoisition_Dangs= UserPoisition_DangLocalServiceUtil.getListUserPoisition_Dang(groupId, q, start, limit);
			for (UserPoisition_Dang userPoisition_Dang : userPoisition_Dangs) {
				UserPoisitionDangObject userPoisitionDangObject= new UserPoisitionDangObject();
				userPoisitionDangObject.setUserPoisitionDangName(HtmlUtil.extractText(userPoisition_Dang.getUserPoisitionDangName()));
				userPoisitionDangObject.setDescription(HtmlUtil.extractText(userPoisition_Dang.getDescription()));
				userPoisitionDangObject.setCreateDate(userPoisition_Dang.getCreateDate());
				userPoisitionDangObject.setModifiedDate(userPoisition_Dang.getModifiedDate());
				userPoisitionDangObject.setUserPoisitionDangId(userPoisition_Dang.getUserPoisitionDangId());
				lPoisitionDangObjects.add(userPoisitionDangObject);

			}
			int total=0;
			total= UserPoisition_DangLocalServiceUtil.getCountAll(q, groupId);
			if(total<0) {
				return DataRespone.FAILED;
			}
			node.putPOJO("userPoisition", lPoisitionDangObjects);
			node.put("total", total);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createUserRank(@PathParam("groupId") long groupId,
			UserPoisitionDangObject UserPoisitionDangObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(UserPoisitionDangObject.getUserPoisitionDangName());
			String description = HtmlUtil.escape(UserPoisitionDangObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserPoisition_Dang userPoisition_Dang =UserPoisition_DangLocalServiceUtil.createUserPoisition_Dang(0);
			userPoisition_Dang.setUserPoisitionDangName(name);
			userPoisition_Dang.setDescription(description);
			userPoisition_Dang.setGroupId(groupId);
			userPoisition_Dang.setCreateDate(dateNow);
			userPoisition_Dang = UserPoisition_DangLocalServiceUtil.addUserPoisition_Dang(userPoisition_Dang);
						
		
		
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
			UserPoisitionDangObject UserPoisitionDangObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(UserPoisitionDangObject.getUserPoisitionDangName());
			String description = HtmlUtil.escape(UserPoisitionDangObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserPoisition_Dang userPoisition_Dang =UserPoisition_DangLocalServiceUtil.getUserPoisition_Dang(id);
			userPoisition_Dang.setUserPoisitionDangName(name);
			userPoisition_Dang.setDescription(description);
			userPoisition_Dang.setGroupId(groupId);
			userPoisition_Dang.setModifiedDate(dateNow);
			userPoisition_Dang = UserPoisition_DangLocalServiceUtil.updateUserPoisition_Dang(userPoisition_Dang);
						
		
		
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
				System.out.println(long1);
				UserPoisition_DangLocalServiceUtil.deleteUserPoisition_Dang(long1);
			}	
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
			UserPoisition_Dang userPoisition_Dang= UserPoisition_DangLocalServiceUtil.deleteUserPoisition_Dang(id);			
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@GET
	@Path("/getrank/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone getUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			UserPoisition_Dang userPoisition_Dang= UserPoisition_DangLocalServiceUtil.getUserPoisition_Dang(id);
			UserPoisitionDangObject UserPoisitionDangObject= new UserPoisitionDangObject(userPoisition_Dang.getUserPoisitionDangId(), HtmlUtil.extractText(userPoisition_Dang.getUserPoisitionDangName()), userPoisition_Dang.getCreateDate(), userPoisition_Dang.getModifiedDate(),HtmlUtil.extractText(userPoisition_Dang.getDescription()), userPoisition_Dang.getTotalMember());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, UserPoisitionDangObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
}
