package com.ecoit.elegal.signer.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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

import com.ecoit.elegal.signer.object.LegalSignerObject;
import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.model.LegalSigner;
import com.ecoit.elegaldocument.service.LegalDSRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalSignerLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.software.util.ResponseCode;

public class SignerResource {
	
	private static SignerResource instance = null;
	
	public static SignerResource getInstance() {
		if (instance == null) {
			instance = new SignerResource();
		}
		return instance;
	}
	
	@GET
	@Path("/getall/{groupId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @PathParam("companyId") long companyId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);
			
			if (groupId < 0 || companyId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();
			List<LegalSigner> legalSignersList = LegalSignerLocalServiceUtil.getListLegalSigner(q, groupId, companyId, start, limit);
			List<LegalSignerObject> legalSignerObjectsList = new ArrayList<>();
			for (LegalSigner legalSigner : legalSignersList) {
				LegalSignerObject object = new LegalSignerObject();
				object.setFirstName(HtmlUtil.extractText(legalSigner.getFirstName()));
				object.setLastName(HtmlUtil.extractText(legalSigner.getLastName()));
				object.setLanguage(HtmlUtil.extractText(legalSigner.getLanguage()));
				object.setSigId(legalSigner.getSigId());
				object.setFullName(HtmlUtil.extractText(legalSigner.getFullName()));
				legalSignerObjectsList.add(object);
			}
			
			int total = LegalSignerLocalServiceUtil.countTotalLegalSigner(q, groupId, companyId);
			
			objectNode.put("total", total);
			objectNode.putPOJO("data", legalSignerObjectsList);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{sigId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("sigId") long sigId) {
		try {

			if (sigId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			LegalSigner legalSigner = LegalSignerLocalServiceUtil.getLegalSigner(sigId);
			LegalSignerObject legalSignerObject = new LegalSignerObject();
			legalSignerObject.setFirstName(HtmlUtil.extractText(legalSigner.getFirstName()));
			legalSignerObject.setLastName(HtmlUtil.extractText(legalSigner.getLastName()));
			legalSignerObject.setLanguage(HtmlUtil.extractText(legalSigner.getLanguage()));
			legalSignerObject.setSigId(legalSigner.getSigId());
			legalSignerObject.setFullName(HtmlUtil.extractText(legalSigner.getFullName()));
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, legalSignerObject, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/{groupId}/language-list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getLanguageList(@PathParam("groupId") long groupId) {
		try {

			if (groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			Set<Locale> localesList = LanguageUtil.getAvailableLocales(groupId);
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (Locale locale : localesList) {
				ObjectNode object = mapper.createObjectNode();
				object.put("name", locale.getDisplayName());
				object.put("value", LocaleUtil.toLanguageId(locale));
				arrayNode.add(object);
			}
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{userId}/{groupId}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse createNewSigner(@PathParam("userId") long userId, @PathParam("groupId") long groupId, @PathParam("companyId") long companyId,
			LegalSignerObject legalSignerObject) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_SIGNER)) {
				String locale = HtmlUtil.escape(legalSignerObject.getLanguage());
				String firstName = HtmlUtil.escape(legalSignerObject.getFirstName());
				String lastName = HtmlUtil.escape(legalSignerObject.getLastName());
				
				if (groupId < 0 || companyId < 0 || firstName.isEmpty() || lastName.isEmpty()) {
					return DataResponse.PARAM_ERROR;
				}
				
				LegalSignerLocalServiceUtil.createUpdateLegalSigner(-1, groupId, companyId, userId, firstName, lastName, locale, true);		
				
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{userId}/{groupId}/{companyId}/{sigId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateSigner(@PathParam("userId") long userId, @PathParam("groupId") long groupId, @PathParam("companyId") long companyId,
			@PathParam("sigId") long sigId, LegalSignerObject legalSignerObject) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_SIGNER)) {
				String locale = HtmlUtil.escape(legalSignerObject.getLanguage());
				String firstName = HtmlUtil.escape(legalSignerObject.getFirstName());
				String lastName = HtmlUtil.escape(legalSignerObject.getLastName());
				
				if (groupId < 0 || companyId < 0 || firstName.isEmpty() || lastName.isEmpty() || sigId < 0) {
					return DataResponse.PARAM_ERROR;
				}
				
				LegalSignerLocalServiceUtil.createUpdateLegalSigner(sigId, groupId, companyId, userId, firstName, lastName, locale, true);		
				
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
	public DataResponse deleteSigner(@PathParam("userId") long userId, @PathParam("groupId") long groupId,
			@Context HttpServletRequest request) {
		try {
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.EDIT_SIGNER)) {
	            long[] sigIdList = ParamUtil.getLongValues(request, "sigId");
				
	    		if (sigIdList == null || sigIdList.length <= 0) {
	    			return DataResponse.PARAM_ERROR;
	    		}
	    		
	    		for (long sigId : sigIdList) {
					List<LegalDSRel> legalDSRels = LegalDSRelLocalServiceUtil.getBySigId(sigId);
					if (legalDSRels != null && legalDSRels.size() > 0) {
						return DataResponse.CONFLICT_ERROR;
					}
					
					LegalSignerLocalServiceUtil.deleteLegalSigner(sigId);
				    LegalDSRelLocalServiceUtil.deleteBySignerId(sigId);
	    		}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return DataResponse.NOT_ACCESS;
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
