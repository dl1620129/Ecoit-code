package com.ecoit.lichcongtac.api;

import java.util.ArrayList;
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

import com.ecoit.lichcongtac.object.LichChiTietObject;
import com.ecoit.lichcongtac.object.SearchObject;
import com.ecoit.lichcongtac.services.model.LichChiTiet;
import com.ecoit.lichcongtac.services.service.LichChiTietLocalServiceUtil;
import com.ecoit.lichcongtac.util.ConfigUtil;
import com.ecoit.lichcongtac.util.DataResponse;
import com.ecoit.lichcongtac.util.LichCongTacRoleConstants;
import com.ecoit.lichcongtac.util.LichCongTacUtil;
import com.ecoit.lichcongtac.util.LichWorkflowConstants;
import com.ecoit.lichcongtac.util.PermissionUtil;
import com.ecoit.lichcongtac.util.ResponseCode;
import com.ecoit.lichcongtac.util.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Path("/lichchitiet")
public class LichChiTietResource {
	private static LichChiTietResource instance = null;
	
	public static LichChiTietResource getInstance() {
		if (instance == null) {
			instance = new LichChiTietResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	@POST
	@Path("/getall/{groupId}/{locale}/{userId}/{configName}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("companyId") long companyId,
			@DefaultValue("0") @QueryParam("start") int start, @PathParam("userId") long userId, @DefaultValue("-1") @QueryParam("orgId") long orgId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @PathParam("configName") String configName,
			SearchObject searchObject) {
		try {
			locale = HtmlUtil.escape(locale);
			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			
			int statusDoc = LichWorkflowConstants.STATUS_DRAFT;
			switch(configName) {
			case ConfigUtil.LICH_NHAP:
				statusDoc = LichWorkflowConstants.STATUS_DRAFT;
				break;
			case ConfigUtil.LICH_CHO_DUYET:
				statusDoc = LichWorkflowConstants.STATUS_PENDING;
				break;
			case ConfigUtil.LICH_DA_DUYET:
				statusDoc = LichWorkflowConstants.STATUS_APPROVED;
				break;
			case ConfigUtil.LICH_DA_XUAT_BAN:
				statusDoc = LichWorkflowConstants.STATUS_PUBLISH;
				break;
			case ConfigUtil.LICH_HUY_DUYET:
				statusDoc = LichWorkflowConstants.STATUS_APPROVE_DENIED;
				break;
			case ConfigUtil.LICH_HUY_XUAT_BAN:
				statusDoc = LichWorkflowConstants.STATUS_PUBLISH_DENIED;
				break;
			case ConfigUtil.LICH_CO_DINH:
				statusDoc = LichWorkflowConstants.STATUS_STABLE;
				break;
			}
			
			if (!PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_VIEW_ALL) 
					&& !configName.equalsIgnoreCase(ConfigUtil.LICH_CO_DINH)) {
				orgId = 0;
				User user = UserLocalServiceUtil.getUser(userId);
				if (user.getOrganizations().size() > 0) {
					orgId = user.getOrganizations().get(0).getOrganizationId();
				}
			}

			long searchUserId = 0;
			if (statusDoc == LichWorkflowConstants.STATUS_DRAFT) {
				searchUserId = userId;
			} else if (statusDoc == LichWorkflowConstants.STATUS_PENDING && !PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_APPROVED)
					&& !PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_VIEW_ALL)) {
				searchUserId = userId;
			}
			
			List<LichChiTiet> lichChiTietList = LichChiTietLocalServiceUtil.searchLichChiTiet(orgId, groupId, locale, statusDoc, searchUserId, 
					searchObject.getFromDate(), searchObject.getToDate());
			if (orgId > 0) {
				List<Organization> childOrgsList = OrganizationLocalServiceUtil.getOrganizations(companyId, orgId);	
				for (Organization childOrg : childOrgsList) {
					List<LichChiTiet> childLichChiTietList = LichChiTietLocalServiceUtil.searchLichChiTiet(childOrg.getOrganizationId(), 
							groupId, locale, statusDoc, searchUserId, searchObject.getFromDate(), searchObject.getToDate());
					lichChiTietList.addAll(childLichChiTietList);
				}
			}
			
			List<LichChiTietObject> lichChiTietObjectList = new ArrayList<>();
			for (LichChiTiet lichChiTiet : lichChiTietList) {
				LichChiTietObject lichChiTietObject = LichCongTacUtil.createLichChiTietObject(lichChiTiet);
				lichChiTietObjectList.add(lichChiTietObject);
			}
			int end = start + limit;
			if (end > lichChiTietObjectList.size()) {
				end = lichChiTietObjectList.size();
			}
			
			List<LichChiTietObject> cutList = lichChiTietObjectList;
			if (end > start) {
				cutList = lichChiTietObjectList.subList(start, end);
			}
			ObjectNode objectNode = mapper.createObjectNode();
			objectNode.putPOJO("data", cutList);
			objectNode.put("total", lichChiTietObjectList.size());
			objectNode.putPOJO("permissions", PermissionUtil.getPermissionNode(userId));
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	/*@POST
	@Path("/create/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("userId") long userId, 
			@PathParam("companyId") long companyId, LichChiTietObject lichChiTietObject) {
		try {
			if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0 || lichChiTietObject.getSelectedDate() == null
					|| lichChiTietObject.getStartTime() == null) {
				return DataResponse.PARAM_ERROR;
			}
			
			LichCongTacUtil.updateLichChiTiet(0, lichChiTietObject, locale, groupId, userId, companyId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}*/
	
	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{companyId}/{lichChiTietId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("userId") long userId, 
			@PathParam("companyId") long companyId, @PathParam("lichChiTietId") long lichChiTietId, LichChiTietObject lichChiTietObject) {
		try {
			if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0 || lichChiTietId < 0 || 
					lichChiTietObject.getSelectedDate() == null || lichChiTietObject.getStartTime() == null) {
				return DataResponse.PARAM_ERROR;
			}
			
			LichCongTacUtil.updateLichChiTiet(lichChiTietId, lichChiTietObject, locale, groupId, userId, companyId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/update/chitiet-status/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateLichChiTietStatus(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long lichChiTietId = ParamUtil.getLong(request, "lichChiTietId", 0);
			if (lichChiTietId <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			int action = ParamUtil.getInteger(request, "action", LichCongTacRoleConstants.SCHEDULE_ADD);
			boolean coLyDo = ParamUtil.getBoolean(request, "coLyDo", false);
			String lyDoTraVe = HtmlUtil.escape(ParamUtil.getString(request, "lyDoTraVe", ""));
			LichChiTietLocalServiceUtil.updateStatus(userId, LichCongTacUtil.getLichCongTacStatus(action), lichChiTietId, coLyDo, lyDoTraVe);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{userId}/{lichChiTietId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("lichChiTietId") long lichChiTietId, @PathParam("userId") long userId) {
		try {
			if (lichChiTietId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			LichChiTiet lichChiTiet = LichChiTietLocalServiceUtil.getLichChiTiet(lichChiTietId);
			LichChiTietObject lichChiTietObject = LichCongTacUtil.createLichChiTietObject(lichChiTiet);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, lichChiTietObject, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/{lichChiTietId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse delete(@PathParam("lichChiTietId") long lichChiTietId) {
		try {
			if (lichChiTietId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			LichChiTietLocalServiceUtil.deleteLichChiTiet(lichChiTietId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
}
