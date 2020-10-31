package com.ecoit.elegal.api;


import java.util.ArrayList;
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

import com.ecoit.elegal.object.LegalFieldObject;
import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.model.LegalField;
import com.ecoit.elegaldocument.service.GroupFieldLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalFieldLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.software.util.ResponseCode;

public class FieldResource {
	
	private static FieldResource instance = null;
	
	public static FieldResource getInstance() {
		if (instance == null) {
			instance = new FieldResource();
		}
		return instance;
	}
	
	@GET
	@Path("/getall/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("companyId") long companyId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		
        try {
        	locale = HtmlUtil.escape(locale);
			q = HtmlUtil.escape(q);
			
			if (groupId < 0 || locale.isEmpty() || companyId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();	
			List<LegalField> fieldsList = LegalFieldLocalServiceUtil.getListLegalField(q, groupId, locale, companyId, start, limit);
			List<LegalFieldObject> objectsList = new ArrayList<>();
			for (LegalField legalField: fieldsList) {
				LegalFieldObject object = new LegalFieldObject();
				object.setFieldId(legalField.getFieldId());
				object.setName(HtmlUtil.extractText(legalField.getName()));
				object.setDescription(HtmlUtil.extractText(legalField.getDescription()));
				object.setStatusField(legalField.getStatusField());
				object.setPosition(legalField.getPosition());
				objectsList.add(object);
			}
			int total = LegalFieldLocalServiceUtil.countTotalLegalField(groupId, locale, companyId, q);
			
			objectNode.put("total", total);
			objectNode.putPOJO("data", objectsList);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
        } catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/getall/fields/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAllTypes(@PathParam("locale") String locale, @PathParam("groupId") long groupId) {
		try {
			List<LegalField> legalFieldsList = LegalFieldLocalServiceUtil.getPublishFields(locale, true, groupId);
			List<LegalFieldObject> objectsList = new ArrayList<>();
			for (LegalField legalField : legalFieldsList) {
				LegalFieldObject object = new LegalFieldObject();
				object.setFieldId(legalField.getFieldId());
				object.setName(HtmlUtil.extractText(legalField.getName()));
				object.setDescription(HtmlUtil.extractText(legalField.getDescription()));
				object.setStatusField(legalField.getStatusField());
				object.setPosition(legalField.getPosition());
				objectsList.add(object);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectsList, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

    @POST
    @Path("/create/{userId}/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public DataResponse createNewField(@PathParam("userId") long userId, @PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("companyId") long companyId,
    		LegalFieldObject legalFieldObject) {
        try {
        	if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_FIELD)) {
            	locale = HtmlUtil.escape(locale);
            	String name = HtmlUtil.escape(legalFieldObject.getName());
            	String description = HtmlUtil.escape(legalFieldObject.getDescription());
    			
    			if (groupId < 0 || locale.isEmpty() || companyId < 0 || name.isEmpty()) {
    				return DataResponse.PARAM_ERROR;
    			}
    			
    			LegalFieldLocalServiceUtil.createUpdateLegalField(userId, groupId, locale, companyId, -1, name, description, legalFieldObject.isStatusField(), legalFieldObject.getPosition());
    			
    			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
        	}
        	return DataResponse.NOT_ACCESS;
        } catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
    }
    
    @PUT
    @Path("/update/{userId}/{groupId}/{locale}/{companyId}/{legalFieldId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public DataResponse updateField(@PathParam("userId") long userId, @PathParam("groupId") long groupId, @PathParam("locale") String locale, 
    		@PathParam("companyId") long companyId, @PathParam("legalFieldId") long legalFieldId, LegalFieldObject legalFieldObject) {
        try {
        	if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_FIELD)) {
            	locale = HtmlUtil.escape(locale);
            	String name = HtmlUtil.escape(legalFieldObject.getName());
            	String description = HtmlUtil.escape(legalFieldObject.getDescription());
    			
    			if (groupId < 0 || locale.isEmpty() || companyId < 0 || name.isEmpty() || legalFieldId < 0) {
    				return DataResponse.PARAM_ERROR;
    			}
    			
    			LegalFieldLocalServiceUtil.createUpdateLegalField(userId, groupId, locale, companyId, legalFieldId, name, description, legalFieldObject.isStatusField(), legalFieldObject.getPosition());
    			
    			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
        	}
        	return DataResponse.NOT_ACCESS;

        } catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
    }
    
    @POST
    @Path("/delete/{userId}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
    public DataResponse deleteField(@PathParam("groupId") long groupId, @PathParam("userId") long userId, @Context HttpServletRequest request) {
    	try {
    		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_FIELD)) {
    			
                long[] legalFieldIdList = ParamUtil.getLongValues(request, "legalFieldId");
                
        		if (legalFieldIdList == null || legalFieldIdList.length <= 0) {
        			return DataResponse.PARAM_ERROR;
        		}
        		
        		for (long legalFieldId : legalFieldIdList) {
        			if (legalFieldId < 0) {
        				return DataResponse.PARAM_ERROR;
        			}
            		
        			List<LegalDocument> legalDocumentsList = LegalDocumentLocalServiceUtil.getByFieldId(legalFieldId);
        			if (legalDocumentsList != null && legalDocumentsList.size() > 0) {
        				return DataResponse.CONFLICT_ERROR;
        			}
        			
            		LegalFieldLocalServiceUtil.deleteLegalField(legalFieldId);
            		GroupFieldLocalServiceUtil.removeByFieldId(legalFieldId);
        		}
        		return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
    		}
    		return DataResponse.NOT_ACCESS;
    	} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
    }
    
	@GET
	@Path("/get/max-order-number/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetMaxOrderNumber(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("companyId") long companyId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || companyId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			int max = LegalFieldLocalServiceUtil.getMax(locale, groupId, companyId);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();
			node.put("maxOrderNumber", max);
			if (max >= 0) {
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			} else {
				return DataResponse.FAILED;
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{legalFieldId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("legalFieldId") long legalFieldId) {
		try {

			if (legalFieldId < 0) {
				return DataResponse.PARAM_ERROR;
			}

            LegalField legalField = LegalFieldLocalServiceUtil.getLegalField(legalFieldId);
            LegalFieldObject object = new LegalFieldObject();
            object.setDescription(HtmlUtil.extractText(legalField.getDescription()));
            object.setFieldId(legalField.getFieldId());
            object.setName(HtmlUtil.extractText(legalField.getName()));
            object.setStatusField(legalField.getStatusField());
            object.setPosition(legalField.getPosition());
            return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, object, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
