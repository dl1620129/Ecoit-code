package com.ecoit.lichcongtac.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
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

import org.apache.poi.ss.usermodel.Workbook;

import com.ecoit.lichcongtac.object.LichChiTietObject;
import com.ecoit.lichcongtac.object.LichCongTacObject;
import com.ecoit.lichcongtac.object.SearchObject;
import com.ecoit.lichcongtac.services.model.LichChiTiet;
import com.ecoit.lichcongtac.services.model.LichCongTac;
import com.ecoit.lichcongtac.services.service.LichChiTietLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.LichCongTacLocalServiceUtil;
import com.ecoit.lichcongtac.util.ConfigUtil;
import com.ecoit.lichcongtac.util.DataResponse;
import com.ecoit.lichcongtac.util.DataResponse.DataType;
import com.ecoit.lichcongtac.util.LichCongTacRoleConstants;
import com.ecoit.lichcongtac.util.LichCongTacUtil;
import com.ecoit.lichcongtac.util.LichWorkflowConstants;
import com.ecoit.lichcongtac.util.PermissionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ecoit.lichcongtac.util.ResponseCode;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;


public class LichCongTacResource {
	private static LichCongTacResource instance = null;
	
	public static LichCongTacResource getInstance() {
		if (instance == null) {
			instance = new LichCongTacResource();
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
			String searchKey = HtmlUtil.escape(searchObject.getSearchKey());
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
			
			List<LichCongTac> lichCongTacList = LichCongTacLocalServiceUtil.searchLichCongTac(orgId, groupId, locale, searchKey, 0, 0, statusDoc, searchUserId, 
					searchObject.getFromDate(), searchObject.getToDate());
			if (orgId > 0) {
				List<Organization> childOrgsList = OrganizationLocalServiceUtil.getOrganizations(companyId, orgId);	
				for (Organization childOrg : childOrgsList) {
					List<LichCongTac> childLichCongTacList = LichCongTacLocalServiceUtil.searchLichCongTac(childOrg.getOrganizationId(), 
							groupId, locale, searchKey, 0, 0, statusDoc, searchUserId, searchObject.getFromDate(), searchObject.getToDate());
					lichCongTacList.addAll(childLichCongTacList);
				}
			}
			
			List<LichCongTacObject> lichCongTacObjectList = new ArrayList<>();
			for (LichCongTac lichCongTac : lichCongTacList) {
				LichCongTacObject lichCongTacObject = LichCongTacUtil.createLichCongTacObject(lichCongTac);
				lichCongTacObjectList.add(lichCongTacObject);
			}
			//int total = LichCongTacLocalServiceUtil.countLichCongTac(orgId, groupId, locale, q, statusDoc, searchUserId, searchObject.getFromDate(), searchObject.getToDate());
			int end = start + limit;
			if (end > lichCongTacObjectList.size()) {
				end = lichCongTacObjectList.size();
			}
			
			List<LichCongTacObject> cutList = lichCongTacObjectList;
			if (end > start) {
				cutList = lichCongTacObjectList.subList(start, end);
			}
			ObjectNode objectNode = mapper.createObjectNode();
			objectNode.putPOJO("data", cutList);
			objectNode.put("total", lichCongTacObjectList.size());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	//fromDate and toDate must be formatted to yyyy-MM-dddd
	@POST
	@Path("/get/publish/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getPublish(@PathParam("groupId") long groupId, @PathParam("locale") String locale, SearchObject searchObject) {
		try {
			locale = HtmlUtil.escape(locale);
			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			
			int status = LichCongTacUtil.getLichCongTacStatus(searchObject.getAction());
			
			List<LichChiTietObject> lichChiTietObjectList = new ArrayList<>();
			/*List<LichChiTiet> lichChiTietList = LichChiTietLocalServiceUtil.getByDateAndStatus(searchObject.getFromDate(), 
					searchObject.getToDate(), groupId, locale, status);*/
			List<LichChiTiet> lichChiTietList = LichChiTietLocalServiceUtil.getPublishLichChiTiet(groupId, locale, status, LichWorkflowConstants.STATUS_STABLE, 
					searchObject.getFromDate(), searchObject.getToDate());
			for (LichChiTiet lichChiTiet : lichChiTietList) {
				LichChiTietObject object = LichCongTacUtil.createLichChiTietObject(lichChiTiet);
				lichChiTietObjectList.add(object);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, lichChiTietObjectList, DataType.JSON_STR);
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
	
	@GET
	@Path("/get/item/{userId}/{lichCongTacId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("lichCongTacId") long lichCongTacId, @PathParam("userId") long userId) {
		try {
			if (lichCongTacId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			LichCongTac lichCongTac = LichCongTacLocalServiceUtil.getLichCongTac(lichCongTacId);
			LichCongTacObject lichCongTacObject = LichCongTacUtil.createLichCongTacObject(lichCongTac);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, lichCongTacObject, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/suggested-user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getSuggestedUser(@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);
			
			List<User> usersList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			ArrayNode arrUser = mapper.createArrayNode();
			for (User user : usersList) {
				String fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
				if (fullName.toLowerCase().contains(q.toLowerCase())) {
					ObjectNode node = mapper.createObjectNode();
					node.put("id", user.getUserId());
					node.put("name", fullName);
					arrUser.addPOJO(node);
				}
				if (arrUser.size() >= limit) {
					break;
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrUser, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/suggested-org")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getSuggestedOrg(@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);
			// organization
			List<Organization> organizationsList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			ArrayNode arrOrg = mapper.createArrayNode();
			for (Organization org : organizationsList) {
				if (org.getName().toLowerCase().contains(q.toLowerCase())) {
					arrOrg.addPOJO(org.getName());
				}
				if (arrOrg.size() >= limit) {
					break;
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrOrg, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse create(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("companyId") long companyId, LichCongTacObject lichCongTacObject) {
		try {
			if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			LichCongTacUtil.createUpdateLichCongTac(0, lichCongTacObject, locale, groupId, userId, companyId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, sw.toString(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{companyId}/{lichCongTacId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse update(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("userId") long userId, 
			@PathParam("companyId") long companyId, @PathParam("lichCongTacId") long lichCongTacId, LichCongTacObject lichCongTacObject) {
		try {
			if (groupId < 0 || locale.isEmpty() || userId < 0 || companyId < 0 || lichCongTacId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			LichCongTacUtil.createUpdateLichCongTac(lichCongTacId, lichCongTacObject, locale, groupId, userId, companyId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	/*@POST
	@Path("/update/status/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateLichCongTacStatus(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long lichCongTacId = ParamUtil.getLong(request, "lichCongTacId", 0);
			if (lichCongTacId <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			int action = ParamUtil.getInteger(request, "action", LichCongTacRoleConstants.SCHEDULE_ADD);
			boolean coLyDo = ParamUtil.getBoolean(request, "coLyDo", false);
			String lyDoTraVe = HtmlUtil.escape(ParamUtil.getString(request, "lyDoTraVe", ""));
			LichCongTacLocalServiceUtil.updateStatus(userId, LichCongTacUtil.getLichCongTacStatus(action), lichCongTacId, coLyDo, lyDoTraVe);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}*/
	
	@POST
	@Path("/update/status/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateLichCongTacStatus(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long[] lichCongTacIdList = ParamUtil.getLongValues(request, "lichCongTacId");
			
			if (lichCongTacIdList == null || lichCongTacIdList.length <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			for (long lichCongTacId : lichCongTacIdList) {
				int action = ParamUtil.getInteger(request, "action", LichCongTacRoleConstants.SCHEDULE_ADD);
				boolean coLyDo = ParamUtil.getBoolean(request, "coLyDo", false);
				String lyDoTraVe = HtmlUtil.escape(ParamUtil.getString(request, "lyDoTraVe", ""));
				LichCongTacLocalServiceUtil.updateStatus(userId, LichCongTacUtil.getLichCongTacStatus(action), lichCongTacId, coLyDo, lyDoTraVe);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	
	@POST
	@Path("/delete-lich/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse delete(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long[] lichCongTacIdList = ParamUtil.getLongValues(request, "lichCongTacId");
			
			if (lichCongTacIdList == null || lichCongTacIdList.length <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (PermissionUtil.checkPermissionAccessZone(userId, LichCongTacRoleConstants.SCHEDULE_REMOVE)) {
				for (long lichCongTacId : lichCongTacIdList) {			
					LichChiTietLocalServiceUtil.deleteByLichCongTacId(lichCongTacId);
					LichCongTacLocalServiceUtil.deleteLichCongTac(lichCongTacId);
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/export/{userId}/{companyId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DataResponse export(@PathParam("companyId") long companyId,
			@PathParam("userId") long userId, @Context HttpServletRequest request) throws IOException {
		long[] lichCongTacIdList = ParamUtil.getLongValues(request, "lichCongTacId");
		
		if (lichCongTacIdList == null || lichCongTacIdList.length <= 0) {
			return DataResponse.PARAM_ERROR;
		}
		
		Workbook wb = LichCongTacUtil.createExcellFile(userId, lichCongTacIdList, companyId);
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		OutputStream outStream = null;
		try {
			wb.write(byteOutputStream);
			byte[] outArray = byteOutputStream.toByteArray();
			//String utf8String = new String(outArray);
			/*String urlEncodedString = URLEncoder.encode(utf8String, StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20")
                                                 .replaceAll("\\%21", "!")
                                                 .replaceAll("\\%27", "'")
                                                 .replaceAll("\\%28", "(")
                                                 .replaceAll("\\%29", ")")
                                                  .replaceAll("\\%7E", "~");*/
			//byte[] byteString = utf8String.getBytes(StandardCharsets.UTF_8);
            String base64 = Base64.getEncoder().encodeToString(outArray);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, base64, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		} finally {
			if (outStream != null) {
				outStream.flush();
			}
			byteOutputStream.close();
	        wb.close();
		}
	}
}
