package UserRank.Poisition.Api.resource;

import java.awt.TrayIcon.MessageType;
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

import User.Rank.Poisition.Service.model.UserRank;
import User.Rank.Poisition.Service.service.UserRankLocalServiceUtil;
import User.Rank.Poisition.Service.service.UserRankPositionLocalServiceUtil;
import User.Rank.Poisition.Service.service.util.DataRespone;
import User.Rank.Poisition.Service.service.util.DataRespone.DataType;
import User.Rank.Poisition.Service.service.util.ResponeCode;
import UserRank.Poisition.Api.object.UserRankObject;

@Path("/rank")
public class UserRankResource {
	private static UserRankResource instance = null;

	public static UserRankResource getInstance() {
		if (instance == null) {
			instance = new UserRankResource();
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
			List<UserRankObject> liRanks= new ArrayList<UserRankObject>();
		
			System.out.println("123");
			List<UserRank> userRanks= UserRankLocalServiceUtil.getListUserRank(groupId, q, start, limit);
			
			for (UserRank userRank : userRanks) {
				UserRankObject uRank= new UserRankObject();
				uRank.setUserRankName(HtmlUtil.extractText(userRank.getRankName()));
				uRank.setDescription(HtmlUtil.extractText(userRank.getDescription()));
				uRank.setCreateDate(userRank.getCreateDate());
				uRank.setModifiedDate(userRank.getModifiedDate());
				uRank.setUserRankId(userRank.getUserRankId());
				liRanks.add(uRank);

			}
			int total=0;
			total= UserRankLocalServiceUtil.getCountAll(q, groupId);
			if(total<0) {
				return DataRespone.FAILED;
			}
		
			node.putPOJO("userRank", liRanks);
			node.put("total", total);	
			arrayNode.add(node);
			return new DataRespone(ResponeCode.SUCCESSFUL, ResponeCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataRespone(ResponeCode.FAILED, ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataRespone createUserRank(@PathParam("groupId") long groupId,
			UserRankObject userRankObject) {
		Date dateNow = new Date();
		try {
			String name= HtmlUtil.escape(userRankObject.getUserRankName());
			String description = HtmlUtil.escape(userRankObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserRank UserRank =UserRankLocalServiceUtil.createUserRank(0);
			UserRank.setRankName(name);
			UserRank.setDescription(description);
			UserRank.setGroupId(groupId);
			UserRank.setCreateDate(dateNow);
			UserRank = UserRankLocalServiceUtil.addUserRank(UserRank);
						
		
		
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
			UserRankObject userRankObject) {

		try {
			String name= HtmlUtil.escape(userRankObject.getUserRankName());
			String description = HtmlUtil.escape(userRankObject.getDescription());
			if(groupId < 0  || name.isEmpty()){
				return DataRespone.PARAM_ERROR;
			}
			UserRank UserRank =UserRankLocalServiceUtil.getUserRank(id);
			UserRank.setRankName(name);
			UserRank.setDescription(description);
			UserRank.setGroupId(groupId);
			UserRank.setModifiedDate(new Date());
			UserRank = UserRankLocalServiceUtil.updateUserRank(UserRank);
						
		
		
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
			UserRank UserRank= UserRankLocalServiceUtil.deleteUserRank(id);			
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
				UserRankLocalServiceUtil.deleteUserRank(long1);
			}	
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
			UserRank userRank= UserRankLocalServiceUtil.getUserRank(id);
			UserRankObject userRankObject= new UserRankObject(userRank.getUserRankId(), HtmlUtil.extractText(userRank.getRankName()), userRank.getCreateDate(), userRank.getModifiedDate(),HtmlUtil.extractText(userRank.getDescription()), userRank.getTotalMember());
			return new DataRespone(ResponeCode.SUCCESSFUL,ResponeCode.SUCCESSFUL, userRankObject, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataRespone(ResponeCode.FAILED,ResponeCode.FAILED, e.getMessage(), DataType.JSON_STR);

		}
	}
}
