package com.ecoit.cms.config.api;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.ecoit.cms.config.model.PortletConfig;
import com.ecoit.cms.config.service.PortletConfigLocalServiceUtil;
import com.ecoit.cms.config.utils.DataResponse;
import com.ecoit.cms.config.utils.DataResponse.DataType;
import com.ecoit.cms.config.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class ConfigResource {
	private static ConfigResource instance = null;
	
	public static ConfigResource getInstance() {
		if (instance == null) {
			instance = new ConfigResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/getall/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("userId") long userId, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);
            
            List<PortletConfig> configsList = PortletConfigLocalServiceUtil.searchConfig(q, start, limit);
            ArrayNode arrNode = mapper.createArrayNode();
            for (PortletConfig config : configsList) {
            	ObjectNode objectNode = mapper.createObjectNode();
            	objectNode.put("portletId", config.getPortletId());
                objectNode.put("categoryId", config.getCatgoryId());
                arrNode.add(objectNode);
            }
            int total = PortletConfigLocalServiceUtil.countConfig(q);
            ObjectNode responseNode = mapper.createObjectNode();
            responseNode.putPOJO("data", arrNode);
            responseNode.putPOJO("total", total);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, responseNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-config/{portletId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("portletId") String portletId) {
		try {
			portletId = HtmlUtil.escape(portletId);
            if (portletId.isEmpty()) {
            	return DataResponse.PARAM_ERROR;
            }
            
            PortletConfig config = null;
			try {
	            config = PortletConfigLocalServiceUtil.getPortletConfig(portletId);
			} catch (Exception e) {
				
			}
            if (config == null) {
            	config = PortletConfigLocalServiceUtil.createPortletConfig(portletId);
            	config.setCatgoryId(0);
            	PortletConfigLocalServiceUtil.updatePortletConfig(config);
            }
            
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("portletId", config.getPortletId());
            objectNode.put("categoryId", config.getCatgoryId());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/config/{userId}/{portletId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse getSuggestedDocument(@PathParam("userId") long userId, @PathParam("portletId") String portletId, @Context HttpServletRequest request) {
		try {
			long categoryId = ParamUtil.getLong(request, "categoryId", 0);
			if (categoryId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			PortletConfig config = PortletConfigLocalServiceUtil.getPortletConfig(portletId);
        	config.setCatgoryId(categoryId);
        	PortletConfigLocalServiceUtil.updatePortletConfig(config);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/config/{userId}/{portletId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteQuestion(@PathParam("userId") long userId, @PathParam("portletId") String portletId) {
		try {
			PortletConfigLocalServiceUtil.deletePortletConfig(portletId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
