package UserRank.Poisition.Api.resource;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import User.Rank.Poisition.Service.model.UserRank;
import User.Rank.Poisition.Service.model.UserRankPosition;
import User.Rank.Poisition.Service.service.UserPoisitionLocalServiceUtil;
import User.Rank.Poisition.Service.service.UserRankLocalServiceUtil;
import User.Rank.Poisition.Service.service.UserRankPositionLocalServiceUtil;
import User.Rank.Poisition.Service.service.util.DataRespone;
import User.Rank.Poisition.Service.service.util.DataRespone.DataType;
import User.Rank.Poisition.Service.service.util.ResponeCode;
import UserRank.Poisition.Api.object.UserRankObject;
import UserRank.Poisition.Api.object.UserRankPositionObject;

@Path("/user-rank-position")
public class UserRankPositionResource {
	private static UserRankPositionResource instance = null;

	public static UserRankPositionResource getInstance() {
		if (instance == null) {
			instance = new UserRankPositionResource();
		}
		return instance;
	}
	@POST
	@Path("/create/{groupId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone createUserRank(@PathParam("groupId") long groupId,
			@Context HttpServletRequest request) {
	
		try {
			UserRankPositionObject userPoisitionObject= new UserRankPositionObject();
			if(groupId < 0){
				return DataRespone.PARAM_ERROR;
			}
		
			long positionDangId= ParamUtil.getLong(request, "positionDangId",0);
			long urankId= ParamUtil.getLong(request, "urankId",0);
			long positionId= ParamUtil.getLong(request, "positionId",0);
			long userId= ParamUtil.getLong(request, "userId",0);
			UserRankPosition userPoisition =UserRankPositionLocalServiceUtil.createUserRankPosition(userId);
			userPoisition.setUserId(userId);
			userPoisition.setUserPoisitionDangId(positionDangId);
			userPoisition.setUserRankId(urankId);
			userPoisition.setUserPoisitionId(positionId);
			UserRankPositionLocalServiceUtil.addUserRankPosition(userPoisition);
		
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@PUT
	@Path("/update/{groupId}/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataRespone updateUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id,
			@Context HttpServletRequest request) {
		UserRankPositionObject userPoisitionObject= new UserRankPositionObject();
		try {
			
			if(groupId < 0){
				return DataRespone.PARAM_ERROR;
			}
			long positionDangId= ParamUtil.getLong(request, "positionDangId",0);
			long urankId= ParamUtil.getLong(request, "urankId",0);
			long positionId= ParamUtil.getLong(request, "positionId",0);
			
			UserRankPosition userPoisition = null;
			try {
				userPoisition =UserRankPositionLocalServiceUtil.getUserRankPosition(id);
			} catch (Exception e) {
				userPoisition = null;
			}
			if(userPoisition==null) {
				userPoisition =UserRankPositionLocalServiceUtil.createUserRankPosition(id);
				userPoisition.setUserId(id);
				userPoisition.setUserPoisitionDangId(positionDangId);
				userPoisition.setUserRankId(urankId);
				userPoisition.setUserPoisitionId(positionId);
				UserRankPositionLocalServiceUtil.addUserRankPosition(userPoisition);
			
			}else {
				userPoisition.setUserPoisitionDangId(positionDangId);
				userPoisition.setUserRankId(urankId);
				userPoisition.setUserPoisitionId(positionId);
				UserRankPositionLocalServiceUtil.updateUserRankPosition(userPoisition);
			}
			
		
		
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}	
		
	}
	@DELETE
	@Path("/delete/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataRespone deleteUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			}
			UserRankPosition UserRank= UserRankPositionLocalServiceUtil.deleteUserRankPosition(id);			
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
				UserRankPositionLocalServiceUtil.deleteUserRankPosition(long1);
			}	
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
	@GET
	@Path("/getdetail/{groupId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataRespone getUserRank(@PathParam("groupId") long groupId,@PathParam("id") long id) {
		try {
			if(groupId<0 || id<0) {
				return DataRespone.PARAM_ERROR;
			} 
			UserRankPosition userRank= UserRankPositionLocalServiceUtil.getUserRankPosition(id);
			UserRankPositionObject userRankObject= new UserRankPositionObject(userRank.getUserId(), userRank.getUserRankId(), userRank.getUserPoisitionId(), userRank.getUserPoisitionDangId());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, userRankObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
}
