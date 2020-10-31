package com.ecoit.mr.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ecoit.mr.model.MemberReport;
import com.ecoit.mr.model.MemberReportHistory;
import com.ecoit.mr.object.MemberReportHistoryObject;
import com.ecoit.mr.object.MemberReportObject;
import com.ecoit.mr.service.MemberReportHistoryLocalServiceUtil;
import com.ecoit.mr.service.MemberReportLocalServiceUtil;
import com.ecoit.mr.utils.DataResponse;
import com.ecoit.mr.utils.DataResponse.DataType;
import com.ecoit.mr.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

@Path("/history")
public class MemberReportHistoryResource {
private static MemberReportHistoryResource instance = null;
	
	public static MemberReportHistoryResource getInstance() {
		if (instance == null) {
			instance = new MemberReportHistoryResource();
		}
		return instance;
	}
	@GET
	@Path("/getall/{groupId}/{userId}/{memberreportId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId,@PathParam("memberreportId") long memberreportId,
			@PathParam("userId") long userId, @DefaultValue("10") @QueryParam("limit") int limit, 
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("") @QueryParam("q") String q) {
	
		try {
			
            q = HtmlUtil.escape(q);
			
			if (groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = mapper.createObjectNode();
				ArrayNode arrayNode= mapper.createArrayNode();
				List<MemberReportHistoryObject> memberReportObjects= new ArrayList<MemberReportHistoryObject>();
				List<MemberReportHistory> memberReportHistories= MemberReportHistoryLocalServiceUtil.getList(groupId, memberreportId, start, limit);
	            for (MemberReportHistory memberReportHistory : memberReportHistories) {
	            	MemberReportHistoryObject memberReportObject= new MemberReportHistoryObject();
					memberReportObject.setMemberReportHistoryId(memberReportHistory.getMemberReportHistoryId());
					memberReportObject.setMemberReportId(memberReportHistory.getMemberReportId());
					memberReportObject.setUserId(memberReportHistory.getUserId());
					memberReportObject.setCreateDate(memberReportHistory.getCreateDate());
					memberReportObject.setModifieDate(memberReportHistory.getModifiedDate());
					memberReportObject.setCreateByUser(memberReportHistory.getCreatedByUser());
					memberReportObject.setModifedByUser(memberReportHistory.getModifiedByUser());
					memberReportObject.setContentUpdate(memberReportHistory.getContenUpdate());
					memberReportObjects.add(memberReportObject);
				}
				int total = MemberReportHistoryLocalServiceUtil.getCount(groupId, memberreportId, start, limit);
				if(total<0) {
					return DataResponse.PARAM_ERROR;
				}
				objectNode.put("total", total);
				objectNode.putPOJO("data", memberReportObjects);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL,  objectNode, DataType.JSON_STR);
			
	      }catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@POST
	@Path("/create/{groupId}/{userId}/{memberreportId}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId,@PathParam("type") long type,@PathParam("memberreportId") long memberreportId,
			@PathParam("userId") long userId,MemberReportObject memberReportObject) {
		try {
			MemberReportHistoryObject memberReportHistoryObject= new MemberReportHistoryObject();
//			String conTentUpdate= 
			long tong=memberReportObject.getTong();
			long hocTap=memberReportObject.getHocTap();
			long liDoKhac=memberReportObject.getLiDoKhac();
			long nghiBu=memberReportObject.getNghiBu();
			long nghiOm=memberReportObject.getNghiOm();
			long congTac=memberReportObject.getCongTac();
			long nghiPhep=memberReportObject.getNghiPhep();
			String note=memberReportObject.getNote();
			String conTent="";
			if(type!=1) {

				conTent+= "Tong so: "+tong+"<br/>";
				conTent+= "Hoc tap: "+hocTap+"<br/>";
				conTent+= "Nghi bu: "+nghiBu+"<br/>";
				conTent+= "Nghi om: "+nghiOm+"<br/>";
				conTent+= "Cong tac: "+congTac+"<br/>";
				conTent+= "Ly do khac: "+liDoKhac+"<br/>";
				conTent+= "Ghi chu: "+note+"<br/>";	
			}
			if(type==1) {
				MemberReport memberReport= MemberReportLocalServiceUtil.getMemberReport(memberreportId);
				
				
				if(memberReport.getTong()!=tong) {
					
					conTent+= "Tong so: "+memberReport.getTong()+" => "+tong+"<br/>";
				}
				if(memberReport.getHocTap()!=hocTap) {
					conTent+= "Hoc tap: "+memberReport.getHocTap()+ " => "+hocTap+"<br/>";
				}
				if(memberReport.getNghiBu()!=nghiBu) {
					conTent+= "Nghi bu: "+memberReport.getNghiBu()+" => "+nghiBu+"<br/>";
				}
				if(memberReport.getNghiOm()!=nghiOm) {
					conTent+= "Nghi om: "+memberReport.getNghiOm()+" => "+nghiOm+"<br/>";
				}
				if(memberReport.getCongTac()!=congTac) {
					conTent+= "Cong tac: "+memberReport.getCongTac()+" => "+congTac+"<br/>";
				}
				if(memberReport.getNghiPhep()!=nghiPhep) {
					conTent+= "Nghi phep: "+memberReport.getNghiPhep()+" => "+nghiPhep+"<br/>";
				}
				if(memberReport.getLiDoKhac()!=liDoKhac) {
					conTent+= "Ly do khac: "+memberReport.getLiDoKhac()+" => "+liDoKhac+"<br/>";
				}
				if(!memberReport.getNote().equals(note)) {
					conTent+= "Ghi chu: "+memberReport.getNote()+" => "+note+"<br/>";
				}
			}		
			MemberReportHistory memberReportHistory= MemberReportHistoryLocalServiceUtil.createMemberReportHistory(0);
			memberReportHistory.setCreatedByUser(UserLocalServiceUtil.getUser(userId).getUuid());
			memberReportHistory.setCreateDate(new Date());
			memberReportHistory.setModifiedDate(new Date());
			memberReportHistory.setGroupId(groupId);
			memberReportHistory.setMemberReportId(memberreportId);
			memberReportHistory.setUserId(userId);
			memberReportHistory.setContenUpdate(conTent);
			MemberReportHistoryLocalServiceUtil.addMemberReportHistory(memberReportHistory);
			memberReportHistoryObject.setMemberReportHistoryId(memberReportHistory.getMemberReportHistoryId());
			memberReportHistoryObject.setMemberReportId(memberReportHistory.getMemberReportId());
			memberReportHistoryObject.setUserId(memberReportHistory.getUserId());
			memberReportHistoryObject.setCreateDate(memberReportHistory.getCreateDate());
			memberReportHistoryObject.setModifieDate(memberReportHistory.getModifiedDate());
			memberReportHistoryObject.setCreateByUser(memberReportHistory.getCreatedByUser());
			memberReportHistoryObject.setModifedByUser(memberReportHistory.getModifiedByUser());
			memberReportHistoryObject.setContentUpdate(memberReportHistory.getContenUpdate());
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, memberReportHistoryObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-detail/{groupId}/{userId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getDetail(@PathParam("groupId") long groupId,@PathParam("id") long id,
			@PathParam("userId") long userId) {
		try {
			MemberReportHistory memberReportHistory= MemberReportHistoryLocalServiceUtil.getMemberReportHistory(id);
			MemberReportHistoryObject memberReportHistoryObject= new MemberReportHistoryObject(memberReportHistory.getMemberReportHistoryId(), memberReportHistory.getMemberReportId(), memberReportHistory.getUserId(), memberReportHistory.getGroupId(),memberReportHistory.getCreateDate(), memberReportHistory.getModifiedDate(), memberReportHistory.getCreatedByUser(), memberReportHistory.getModifiedByUser(), memberReportHistory.getContenUpdate());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, memberReportHistoryObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@DELETE
	@Path("/delete/{groupId}/{userId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse delete(@PathParam("groupId") long groupId,@PathParam("userId") long userId,@PathParam("id") long id) {
		try {
			if(groupId<0 || userId<0) {
				return DataResponse.PARAM_ERROR;
			}
			MemberReportHistoryLocalServiceUtil.deleteMemberReportHistory(id);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	
}
