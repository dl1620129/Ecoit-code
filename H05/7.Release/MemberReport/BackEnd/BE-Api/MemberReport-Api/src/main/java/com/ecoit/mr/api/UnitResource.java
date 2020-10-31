package com.ecoit.mr.api;

import java.util.ArrayList;
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
import com.ecoit.mr.model.Unit;
import com.ecoit.mr.object.UnitObject;
import com.ecoit.mr.service.MemberReportLocalServiceUtil;
import com.ecoit.mr.service.UnitLocalServiceUtil;
import com.ecoit.mr.utils.DataResponse;
import com.ecoit.mr.utils.ResponseCode;
import com.ecoit.mr.utils.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

@Path("/unit")
public class UnitResource {
	private static UnitResource instance = null;
	
	public static UnitResource getInstance() {
		if (instance == null) {
			instance = new UnitResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	@GET
	@Path("/getall/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getUnits(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("companyId") long companyId,
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			locale = HtmlUtil.escape(locale);
			q = HtmlUtil.escape(q);
			
			ObjectNode objectNode = mapper.createObjectNode();
			List<UnitObject> objectsList = new ArrayList<>();
			List<Unit> unitsList = UnitLocalServiceUtil.searchUnit(q, groupId, companyId, locale, start, limit);
			for (Unit unit : unitsList) {
				UnitObject unitObject = new UnitObject();
				unitObject.setUnitId(unit.getUnitId());
				unitObject.setName(unit.getName());
				unitObject.setDescription(unit.getDescription());
				objectsList.add(unitObject);
			}
			int total = UnitLocalServiceUtil.countUnit(q, groupId, companyId, locale);
			objectNode.putPOJO("list", objectsList);
			objectNode.putPOJO("total", total);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{unitId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getUnit(@PathParam("unitId") long unitId) {
		try {
			Unit unit = UnitLocalServiceUtil.getUnit(unitId);
			UnitObject unitObject = new UnitObject();
			unitObject.setUnitId(unit.getUnitId());
			unitObject.setName(unit.getName());
			unitObject.setDescription(unit.getDescription());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, unitObject, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse createUnit(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, UnitObject unitObject) {
		try {
			locale = HtmlUtil.escape(locale);
			String name = HtmlUtil.escape(unitObject.getName());
			String description = HtmlUtil.escape(unitObject.getDescription());
			UnitLocalServiceUtil.updateCreateUnit(0, groupId, companyId, userId, locale, name, description);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateUnit(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, UnitObject unitObject) {
		try {
			locale = HtmlUtil.escape(locale);
			String name = HtmlUtil.escape(unitObject.getName());
			String description = HtmlUtil.escape(unitObject.getDescription());
			UnitLocalServiceUtil.updateCreateUnit(unitObject.getUnitId(), groupId, companyId, userId, locale, name, description);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/{userId}/{unitId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteUnit(@PathParam("userId") long userId, @PathParam("unitId") long unitId) {
		try {
			List<MemberReport> memberReportsList = MemberReportLocalServiceUtil.getByUnitId(unitId);
			if (memberReportsList != null && memberReportsList.size() > 0) {
				return new DataResponse(ResponseCode.PARAM_ERROR, ResponseCode.PARAM_ERROR, "", DataType.JSON_STR);
			}
			
			UnitLocalServiceUtil.deleteUnit(unitId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
