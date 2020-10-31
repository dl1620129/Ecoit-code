package com.ecoit.mr.api;

import java.text.SimpleDateFormat;
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

import com.ecoit.mr.model.MemberReport;
import com.ecoit.mr.model.MemberReportHistory;
import com.ecoit.mr.object.MemberReportObject;
import com.ecoit.mr.object.SearchObject;
import com.ecoit.mr.service.MemberReportHistoryLocalServiceUtil;
import com.ecoit.mr.service.MemberReportLocalServiceUtil;
import com.ecoit.mr.utils.DataResponse;
import com.ecoit.mr.utils.DataResponse.DataType;
import com.ecoit.mr.utils.PermissionUtil;
import com.ecoit.mr.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

@Path("/report")
public class MemberReportResource {
	private static MemberReportResource instance = null;
	
	public static MemberReportResource getInstance() {
		if (instance == null) {
			instance = new MemberReportResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	
	@POST
	@Path("/getall/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse searchReport(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("companyId") long companyId,
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit, SearchObject searchObject) {
		try {
			locale = HtmlUtil.escape(locale);
			String modifiedDate = HtmlUtil.escape(searchObject.getModifiedDate());
			Date modDate = null;
			if (!modifiedDate.isEmpty()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				try {
					modDate = dateFormat.parse(modifiedDate);
				} catch (Exception e) {
					modDate = null;
				}
			}
				 
			List<MemberReport> memberReportsList = MemberReportLocalServiceUtil.searchMemberReport(searchObject.getUnitId(),
					modDate, groupId, companyId, locale, 0, 0);
			
			if (searchObject.getUnitId() > 0) {
				List<Organization> childOrgsList = OrganizationLocalServiceUtil.getOrganizations(companyId, searchObject.getUnitId());	
				for (Organization childOrg : childOrgsList) {
					List<MemberReport> childMemberReportsList = MemberReportLocalServiceUtil.searchMemberReport(childOrg.getOrganizationId(),
							modDate, groupId, companyId, locale, 0, 0);
					memberReportsList.addAll(childMemberReportsList);
				}
			}

			
			ObjectNode objectNode = mapper.createObjectNode();
			List<MemberReportObject> objectsList = new ArrayList<>();
			for (MemberReport memberReport: memberReportsList) {
				MemberReportObject memberReportObject = new MemberReportObject();
				memberReportObject.setMemberReportId(memberReport.getMemberReportId());
				memberReportObject.setTong(memberReport.getTong());
				memberReportObject.setCongTac(memberReport.getCongTac());
				memberReportObject.setHocTap(memberReport.getHocTap());
				memberReportObject.setNghiPhep(memberReport.getNghiPhep());
				memberReportObject.setNghiOm(memberReport.getNghiOm());
				memberReportObject.setNghiBu(memberReport.getNghiBu());
				memberReportObject.setLiDoKhac(memberReport.getLiDoKhac());
				memberReportObject.setNote(HtmlUtil.extractText(memberReport.getNote()));
				memberReportObject.setUnitId(memberReport.getUnitId());
				memberReportObject.setLanguage(memberReport.getLanguage());
				memberReportObject.setModifiedDate(memberReport.getModifiedDate());
				String userName = "";
				try {
					User user = UserLocalServiceUtil.getUser(memberReport.getModifiedByUser());
					userName = user.getScreenName();
				} catch (Exception e) {
					userName = "";
				}
				memberReportObject.setUserName(userName);
				if (memberReport.getUnitId() > 0) {
					String organName = "";
					try {
						Organization organ = OrganizationLocalServiceUtil.getOrganization(memberReport.getUnitId());
						organName = organ.getName();
					} catch (Exception e) {
						organName = "";
					}
					memberReportObject.setUnitName(organName);
				}
				objectsList.add(memberReportObject);
			}
			
			/*int total = MemberReportLocalServiceUtil.countMemberReport(searchObject.getUnitId(),
					modDate, groupId, companyId, locale);*/
			int end = start + limit;
			if (end > objectsList.size()) {
				end = objectsList.size() ;
			}
			
			List<MemberReportObject> cutList = objectsList;
			if (end > start) {
				cutList = objectsList.subList(start, end);
			}

			objectNode.putPOJO("list", cutList);
			objectNode.putPOJO("total", objectsList.size());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{reportId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getReportDetail(@PathParam("reportId") long reportId) {
		try {
			MemberReport memberReport = MemberReportLocalServiceUtil.getMemberReport(reportId);
			MemberReportObject memberReportObject = new MemberReportObject();
			memberReportObject.setMemberReportId(memberReport.getMemberReportId());
			memberReportObject.setTong(memberReport.getTong());
			memberReportObject.setCongTac(memberReport.getCongTac());
			memberReportObject.setHocTap(memberReport.getHocTap());
			memberReportObject.setNghiPhep(memberReport.getNghiPhep());
			memberReportObject.setNghiOm(memberReport.getNghiOm());
			memberReportObject.setNghiBu(memberReport.getNghiBu());
			memberReportObject.setLiDoKhac(memberReport.getLiDoKhac());
			memberReportObject.setNote(HtmlUtil.extractText(memberReport.getNote()));
			memberReportObject.setUnitId(memberReport.getUnitId());
			memberReportObject.setLanguage(memberReport.getLanguage());
			memberReportObject.setModifiedDate(memberReport.getModifiedDate());
			memberReportObject.setListCongTac(memberReport.getListCongTac());
			memberReportObject.setListLiDoKhac(memberReport.getListLiDoKhac());
			memberReportObject.setListHocTap(memberReport.getListHocTap());
			memberReportObject.setListNghiBu(memberReport.getListNghiBu());
			memberReportObject.setListNghiOm(memberReport.getListNghiOm());
			memberReportObject.setListNghiPhep(memberReport.getListNghiPhep());
			String userName = "";
			try {
				User user = UserLocalServiceUtil.getUser(memberReport.getModifiedByUser());
				userName = user.getScreenName();
			} catch (Exception e) {
				userName = "";
			}
			memberReportObject.setUserName(userName);
			if (memberReport.getUnitId() > 0) {
				String organName = "";
				try {
					Organization organ = OrganizationLocalServiceUtil.getOrganization(memberReport.getUnitId());
					organName = organ.getName();
				} catch (Exception e) {
					organName = "";
				}
				memberReportObject.setUnitName(organName);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, memberReportObject, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse createMemberReport(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, MemberReportObject memberReportObject) {
		try {
			if(MemberReportLocalServiceUtil.getCountMemberreportByDate(new Date(), groupId,userId)>0) {
				return new DataResponse(ResponseCode.PARAM_ERROR, ResponseCode.PARAM_ERROR, "khong them duoc", DataType.JSON_STR);
			}
			String note = HtmlUtil.escape(memberReportObject.getNote());
			MemberReport MemberReport = MemberReportLocalServiceUtil.updateCreateMemberReport(0, groupId, companyId, userId, locale, 
					memberReportObject.getTong(), memberReportObject.getCongTac(), memberReportObject.getHocTap(), 
					memberReportObject.getNghiPhep(), memberReportObject.getNghiOm(), memberReportObject.getNghiBu(),
					memberReportObject.getLiDoKhac(), note, memberReportObject.getUnitId(),memberReportObject.getListCongTac(),memberReportObject.getListHocTap(),memberReportObject.getListNghiPhep(),
					memberReportObject.getListNghiOm(),memberReportObject.getListNghiBu(),memberReportObject.getListLiDoKhac());
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL,MemberReport.getMemberReportId(), DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateMemberReport(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, MemberReportObject memberReportObject) {
		try {
			String note = HtmlUtil.escape(memberReportObject.getNote());
			MemberReportLocalServiceUtil.updateCreateMemberReport(memberReportObject.getMemberReportId(), groupId, companyId, userId, locale, 
					memberReportObject.getTong(), memberReportObject.getCongTac(), memberReportObject.getHocTap(), 
					memberReportObject.getNghiPhep(), memberReportObject.getNghiOm(), memberReportObject.getNghiBu(),
					memberReportObject.getLiDoKhac(), note, memberReportObject.getUnitId(),memberReportObject.getListCongTac(),memberReportObject.getListHocTap(),memberReportObject.getListNghiPhep(),
					memberReportObject.getListNghiOm(),memberReportObject.getListNghiBu(),memberReportObject.getListLiDoKhac());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/{userId}/{reportId}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteMemberReport(@PathParam("userId") long userId,@PathParam("groupId") long groupId, @PathParam("reportId") long reportId) {
		try {
			MemberReportLocalServiceUtil.deleteMemberReport(reportId);
			List<MemberReportHistory> mList= MemberReportHistoryLocalServiceUtil.getList(groupId, reportId, 0, -1);
			for (MemberReportHistory memberReportHistory : mList) {
				MemberReportHistoryLocalServiceUtil.deleteMemberReportHistory(memberReportHistory.getMemberReportHistoryId());
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	@GET
	@Path("/get/permission/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse checkPermission(@PathParam("userId") long userId) {
		try {
			ObjectNode objectNode = mapper.createObjectNode();
			objectNode.putPOJO("permissions", PermissionUtil.getPermissionNode(userId));
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
