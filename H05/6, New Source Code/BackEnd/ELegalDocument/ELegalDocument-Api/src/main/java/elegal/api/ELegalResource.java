package elegal.api;

import com.ecoit.elegaldocument.model.DocumentAttachments;
import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.model.LegalField;
import com.ecoit.elegaldocument.model.LegalOrg;
import com.ecoit.elegaldocument.model.LegalSigner;
import com.ecoit.elegaldocument.model.LegalSuggestDocument;
import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.service.DocumentAttachmentsLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDSRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalFieldLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalFieldServiceUtil;
import com.ecoit.elegaldocument.service.LegalOrgLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalSignerLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalSuggestDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalTypeLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.NewsWorkflowConstants;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.ecoit.elegaldocument.utils.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import elegal.object.SearchObject;
import elegal.object.SignerObject;
import elegal.object.TreeOrgObject;
import elegal.utils.AttachmentUtil;
import elegal.utils.ConfigUtil;
import elegal.utils.DocumentUtil;
import elegal.utils.PermissionUtil;
import elegal.utils.SuggestionUtil;
import elegal.utils.TreeLegalType;
import elegal.utils.TreeOrg;

@Path("/doc")
public class ELegalResource {
	private static ELegalResource instance;

	public static ELegalResource getInstance() {
		if (instance == null) {
			instance = new ELegalResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();

	@POST
	@Path("/get-by-config/{groupId}/{locale}/{userId}/{companyId}/{configName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("companyId") long companyId, @DefaultValue("") @PathParam("configName") String configName,
			SearchObject searchObject) {
		try {
			locale = HtmlUtil.escape(locale);
			configName = HtmlUtil.escape(configName);
			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			
			int statusDoc = NewsWorkflowConstants.STATUS_DRAFT;
			switch(configName) {
			case ConfigUtil.VAN_BAN_NHAP:
				statusDoc = NewsWorkflowConstants.STATUS_DRAFT;
				break;
			case ConfigUtil.VAN_BAN_CHO_DUYET:
				statusDoc = NewsWorkflowConstants.STATUS_PENDING;
				break;
			case ConfigUtil.VAN_BAN_DA_DUYET:
				statusDoc = NewsWorkflowConstants.STATUS_APPROVED;
				break;
			case ConfigUtil.VAN_BAN_DA_XUAT_BAN:
				statusDoc = NewsWorkflowConstants.STATUS_PUBLISH;
				break;
			case ConfigUtil.VAN_BAN_HUY_DUYET:
				statusDoc = NewsWorkflowConstants.STATUS_APPROVE_DENIED;
				break;
			case ConfigUtil.VAN_BAN_HUY_XUAT_BAN:
				statusDoc = NewsWorkflowConstants.STATUS_PUBLISH_DENIED;
				break;
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
			dateFormat.setTimeZone(timeZone);
			HashMap<String, Object> searchValues = new HashMap<String, Object>();
			if ((configName.equals(ConfigUtil.VAN_BAN_CHO_DUYET) && !DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_APPROVED))
					|| configName.equals(ConfigUtil.VAN_BAN_NHAP)) {
				searchValues.put("userId", userId);
				System.out.println(userId);
			}
			
			if (searchObject.getTypeId() > 0) {
				searchValues.put("typeId", searchObject.getTypeId());
			}
			
			if (searchObject.getOrganizationId() > 0) {
				searchValues.put("organizationId", searchObject.getOrganizationId());
			}
			
			if (searchObject.getSymbol() != null && !searchObject.getSymbol().isEmpty()) {
	            String symbol = HtmlUtil.escape(searchObject.getSymbol()).trim();
				searchValues.put("symbol", symbol);
			}
			
			if (searchObject.getSignerId() > 0) {
				searchValues.put("sigId", searchObject.getSignerId());
			}
			
			if (searchObject.getFieldId() > 0) {
				searchValues.put("fieldId", searchObject.getFieldId());
			}
			
			if (searchObject.getPromulDate() != null) {
				SimpleDateFormat promulDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				promulDateFormat.setTimeZone(timeZone);
				searchValues.put("promulDate", promulDateFormat.format(searchObject.getPromulDate()));
			}
			
			if (searchObject.getFromDate() != null) {
				searchValues.put("fromDate", dateFormat.format(searchObject.getFromDate()));
			}
			
			if (searchObject.getToDate() != null) {
				searchValues.put("toDate", dateFormat.format(searchObject.getToDate()));
			}
			
			if (searchObject.getNewGopY() != null && !searchObject.getNewGopY().equalsIgnoreCase("both")) {
				searchValues.put("newGopY", Boolean.parseBoolean(searchObject.getNewGopY()));
			}
			
			ObjectNode objectNode = mapper.createObjectNode();
			/*long totalRecord = LegalDocumentLocalServiceUtil.countLegalDocument(statusDoc, groupId, companyId, locale, 
					searchValues);
			objectNode.put("total", totalRecord);*/
			
			//searchValues.put("start", start);
            List<LegalDocument> legalDocumentsList = LegalDocumentLocalServiceUtil.searchLegalDocument(statusDoc, groupId, companyId, locale, 
            		searchValues);
            
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (LegalDocument legalDocument : legalDocumentsList) {
				ObjectNode node = mapper.createObjectNode();
				node.put("docId", legalDocument.getDocId());
				node.put("symbol", HtmlUtil.extractText(legalDocument.getSymbol()));
				node.put("num", legalDocument.getNum());
				String promulDate = "";
				if (legalDocument.getPromulDate() != null) {
					promulDate = dateFormat.format(legalDocument.getPromulDate());
				}
				node.put("promulDate", promulDate);
				node.put("newGopY", legalDocument.getNewGopY());
				String expiredDate = "";
				if (legalDocument.getExpiredDate() != null) {
					expiredDate = dateFormat.format(legalDocument.getExpiredDate());
				}
				node.put("expiredDate", expiredDate);
				node.put("summary", HtmlUtil.extractText(legalDocument.getSummary()));
				arrayNode.add(node);
			}
			
			// check permission user


			objectNode.putPOJO("data", arrayNode);
			objectNode.putPOJO("permissions", PermissionUtil.getPermissionNode(groupId, userId));
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode,
					DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	
	@POST
	@Path("/create/{groupId}/{locale}/{companyId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse createDocument(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, @Context HttpServletRequest request) {
		
		try {
			
			if (groupId < 0 || companyId < 0 || userId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			
			Date now = new Date();
			long legalDocId = CounterLocalServiceUtil.increment();
			LegalDocument legalDocument = LegalDocumentLocalServiceUtil.createLegalDocument(legalDocId);
			legalDocument.setGroupId(groupId);
			legalDocument.setUserId(userId);
			legalDocument.setCompanyId(companyId);
			legalDocument.setCreatedByUser(userId);
			legalDocument.setCreatedDate(now);
			legalDocument.setModifiedByUser(userId);
			legalDocument.setModifiedDate(now);
			legalDocument.setLanguage(locale);
			
			int action = ParamUtil.getInteger(request, "action", DocumentRoleConstants.DOCUMENT_ADD);
			
			legalDocument.setStatusDoc(DocumentUtil.getDocumentStatus(action));		
			legalDocument = DocumentUtil.setDataToLegalDocument(legalDocument, request);
			
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			
			File[] attachmentsList = upload.getFiles("attachments");
			ArrayList<Long> attachmentIdsList = new ArrayList<>();
			if (attachmentsList != null && attachmentsList.length > 0) {
				for (File attachment : attachmentsList) {
					if (!DocumentUtil.checkAttachmentName(attachment.getName().toLowerCase())) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
								"Không đúng định dạng .doc, .docx, .pdf, .zip, .rar", DataType.JSON_STR);
					}
				}
				
				for (File attachment : attachmentsList) {
					long attachmentId = AttachmentUtil.uploadFile(upload, attachment, attachment.getName(), legalDocId, locale, legalDocument.getSymbol(), groupId, userId);
					attachmentIdsList.add(attachmentId);
				}
			}

			String signerStr = ParamUtil.getString(request, "signerRels", "");
			SignerObject[] signerObjList = null;
			if (!signerStr.isEmpty()) {
				signerObjList = mapper.readValue(signerStr, SignerObject[].class);
			}
			
			List<Long> legalSignerIds = new ArrayList<>();
			if (signerObjList != null) {
				for (SignerObject object : signerObjList) {
					if (object.getSigId() <= 0) {
						LegalSigner legalSigner = LegalSignerLocalServiceUtil.createUpdateLegalSigner(0, groupId, companyId, userId, 
								HtmlUtil.escape(object.getFullName()), "", locale, true);
						legalSignerIds.add(legalSigner.getSigId());
					} else {
						legalSignerIds.add(object.getSigId());
					}
				}
			}
			
			LegalDocumentLocalServiceUtil.updateCreateLegalDocument(legalDocument, attachmentIdsList, ParamUtil.getLongValues(request, "typeIds"),  legalSignerIds, userId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/update/{groupId}/{locale}/{companyId}/{userId}/{docId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateDocument(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, @PathParam("docId") long docId, @Context HttpServletRequest request) {
		
		try {
			
			if (groupId < 0 || companyId < 0 || userId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			
			Date now = new Date();
			LegalDocument legalDocument = LegalDocumentLocalServiceUtil.getLegalDocument(docId);
			legalDocument.setGroupId(groupId);
			legalDocument.setUserId(userId);
			legalDocument.setCompanyId(companyId);
			legalDocument.setModifiedByUser(userId);
			legalDocument.setModifiedDate(now);
			legalDocument.setLanguage(locale);
			
			int action = ParamUtil.getInteger(request, "action", -1);
			if (action >= 0) {
				int statusDoc = DocumentUtil.getDocumentStatus(action);
				legalDocument.setStatusDoc(statusDoc);
			}
			
			legalDocument = DocumentUtil.setDataToLegalDocument(legalDocument, request);
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			
			File[] attachmentsList = upload.getFiles("attachments");
			ArrayList<Long> attachmentIdsList = new ArrayList<>();
			if (attachmentsList != null && attachmentsList.length > 0) {
				for (File attachment : attachmentsList) {
					if (!DocumentUtil.checkAttachmentName(attachment.getName().toLowerCase())) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
								"Không đúng định dạng .doc, .docx, .pdf, .zip, .rar", DataType.JSON_STR);
					}
				}
				
				for (File attachment : attachmentsList) {
					long attachmentId = AttachmentUtil.uploadFile(upload, attachment, attachment.getName(), docId, locale, legalDocument.getSymbol(), groupId, userId);
					attachmentIdsList.add(attachmentId);
				}
			}
			
			String signerStr = ParamUtil.getString(request, "signerRels", "");
			SignerObject[] signerObjList = null;
			if (!signerStr.isEmpty()) {
				signerObjList = mapper.readValue(signerStr, SignerObject[].class);
			}

			List<Long> legalSignerIds = new ArrayList<>();
			if (signerObjList != null) {
				for (SignerObject object : signerObjList) {
					if (object.getSigId() <= 0) {
						LegalSigner legalSigner = LegalSignerLocalServiceUtil.createUpdateLegalSigner(0, groupId, companyId, userId, 
								HtmlUtil.escape(object.getFullName()), "", locale, true);
						legalSignerIds.add(legalSigner.getSigId());
					} else {
						legalSignerIds.add(object.getSigId());
					}
				}
			}
			LegalDocumentLocalServiceUtil.updateCreateLegalDocument(legalDocument, attachmentIdsList, ParamUtil.getLongValues(request, "typeIds"), legalSignerIds, userId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/update/status/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse getSuggestedDocument(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long[] docIdList = ParamUtil.getLongValues(request, "docId");
			
			if (docIdList == null || docIdList.length <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			for (long docId : docIdList) {		
				int action = ParamUtil.getInteger(request, "action", DocumentRoleConstants.DOCUMENT_ADD);
				LegalDocumentLocalServiceUtil.updateStatusDoc(docId, DocumentUtil.getDocumentStatus(action), userId);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
			
	@GET
	@Path("/get-suggestion/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getSuggestedDocument(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("companyId") long companyId, @DefaultValue("5") @QueryParam("limit") int limit, 
			@DefaultValue("") @QueryParam("searchValue") String searchValue) {
		try {
			searchValue = HtmlUtil.escape(searchValue);
            List<LegalDocument> legalDocumentsList = LegalDocumentLocalServiceUtil.getSuggestedDocument(groupId, companyId, locale, searchValue, NewsWorkflowConstants.STATUS_PUBLISH, limit);
            
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (LegalDocument legalDocument : legalDocumentsList) {
				ObjectNode node = mapper.createObjectNode();
				node.put("docId", legalDocument.getDocId());
				node.put("symbol", HtmlUtil.extractText(legalDocument.getSymbol()));
				node.put("num", legalDocument.getNum());
				arrayNode.add(node);
			}
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/view/{groupId}/{locale}/{companyId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAllSelectOption(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("companyId") long companyId, @PathParam("userId") long userId, @DefaultValue("0") @QueryParam("docId") long docId) {
		try {
			TreeOrg treeOrg = new TreeOrg();
			List<TreeOrgObject> orgNode = treeOrg.getNodes(0, groupId, companyId, locale, "", 0, -1, userId);
			
			TreeLegalType treeLegaltype = new TreeLegalType();
			ArrayNode legalTypeNode = treeLegaltype.getCheckedDocumentNodes(0, groupId, companyId, locale, docId, userId);
			
			ArrayNode legalFieldNode = mapper.createArrayNode();
			List<LegalField> legalFields = LegalFieldServiceUtil.findAll(groupId, companyId, locale);
			for (LegalField legalField : legalFields) {
				if (PermissionUtil.userHasField(userId, legalField.getFieldId())) {
					legalField.setName(HtmlUtil.extractText(legalField.getName()));
					Map<String, Object> map = legalField.getModelAttributes();
					ObjectNode object = mapper.convertValue(map, ObjectNode.class);
					legalFieldNode.add(object);
				}
			}
			
			ArrayNode legalSignerNode = mapper.createArrayNode();
			List<LegalSigner> legalSigners = LegalSignerLocalServiceUtil.getListLegalSigner("", groupId, companyId, 0, -1);
			for (LegalSigner legalSigner : legalSigners) {
				Map<String, Object> map = legalSigner.getModelAttributes();
				legalSigner.setFullName(HtmlUtil.extractText(legalSigner.getFullName()));
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				legalSignerNode.add(object);
			}
			
			ObjectNode node = mapper.createObjectNode();
			node.putPOJO("organizations", orgNode);
			node.putPOJO("types", legalTypeNode);
			node.putPOJO("fields", legalFieldNode);
			node.putPOJO("signers", legalSignerNode);
			node.putPOJO("permissions", PermissionUtil.getPermissionNode(groupId, userId));
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{docId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getDetailDocument(@PathParam("docId") long docId) {
		try {
			LegalDocument legalDocument = LegalDocumentLocalServiceUtil.getLegalDocument(docId);
			LegalDocumentLocalServiceUtil.updateNewGopY(docId, false);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, DocumentUtil.createDocumentNode(legalDocument), DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/publish/{locale}/{docId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getDetailPublishDocument(@PathParam("locale") String locale, @PathParam("docId") long docId) {
		try {
			LegalDocument legalDocument = LegalDocumentLocalServiceUtil.getLegalDocument(docId);
			if (legalDocument.getStatusDoc() == NewsWorkflowConstants.STATUS_PUBLISH) {
				ObjectNode object = DocumentUtil.createDocumentNode(legalDocument);
				
				List<LegalDSRel> legalDSRelList = LegalDSRelLocalServiceUtil.getByDocId(legalDocument.getDocId());
				String signerName = "";
				for (int i = 0; i < legalDSRelList.size(); i++) {				
					try {
						LegalSigner legalSigner = LegalSignerLocalServiceUtil.getLegalSigner(legalDSRelList.get(i).getSigId());
						signerName += HtmlUtil.extractText(legalSigner.getFullName());
						if (i < (legalDSRelList.size() - 1)) {
							signerName += ", ";
						}
					} catch (Exception e) {
						
					}
				}
				object.put("signerName", signerName);
				
				List<LegalType> legalTypesList = LegalTypeLocalServiceUtil.getByDocumentId(legalDocument.getDocId());
				String legalTypeNames = "";
				for (int i = 0; i < legalTypesList.size(); i++) {
					legalTypeNames += HtmlUtil.extractText(legalTypesList.get(i).getName());
					if (i < (legalTypesList.size() - 1)) {
						legalTypeNames += ", ";
					}
				}
				object.put("typeName", legalTypeNames);
				
				String legalOrgName = "";
				if (legalDocument.getOrganizationId() > 0) {
					LegalOrg org = LegalOrgLocalServiceUtil.getLegalOrg(legalDocument.getOrganizationId());
					legalOrgName = HtmlUtil.extractText(org.getName());
				}
				object.put("organizationName", legalOrgName);
				
				String legalFieldName = "";
				if (legalDocument.getFieldId() > 0) {
					LegalField legalField = LegalFieldLocalServiceUtil.getLegalField(legalDocument.getFieldId());
					legalFieldName = HtmlUtil.extractText(legalField.getName());
				}			
				object.put("fieldName", legalFieldName);
				List<LegalSuggestDocument> suggestionsList = LegalSuggestDocumentLocalServiceUtil.getApprovedSuggestions(docId, locale, true, 0, 0);
				object.putPOJO("suggestions", SuggestionUtil.appendDataToObject(suggestionsList));
				
				legalDocument.setView(legalDocument.getView() + 1);
				LegalDocumentLocalServiceUtil.updateLegalDocument(legalDocument);
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, object, DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/attachment/{attachmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteAttachment(@PathParam("attachmentId") long attachmentId) {
		try {
			if (attachmentId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			DocumentAttachments attachment = DocumentAttachmentsLocalServiceUtil.getDocumentAttachments(attachmentId);
			if (attachment != null) {
				DLFileEntryLocalServiceUtil.deleteDLFileEntry(attachmentId);
				DocumentAttachmentsLocalServiceUtil.deleteDocumentAttachments(attachmentId);
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			} 
			
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT FOUND attachmentId", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/document/{groupId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse deleteDocument(@PathParam("groupId") long groupId, @PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long[] docIdList = ParamUtil.getLongValues(request, "docId");
			
			if (docIdList == null || docIdList.length <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_REMOVE)) {
				for (long docId : docIdList) {
					List<DocumentAttachments> attachmentsList = DocumentAttachmentsLocalServiceUtil.getAttachmentsByDocId(docId);
					for (DocumentAttachments attachment : attachmentsList) {
						DLFileEntryLocalServiceUtil.deleteDLFileEntry(attachment.getAttachmentId());
						DocumentAttachmentsLocalServiceUtil.deleteDocumentAttachments(attachment.getAttachmentId());
					}
					LegalDocumentLocalServiceUtil.removeDocumentByDocId(docId);
					LegalSuggestDocumentLocalServiceUtil.removeByDocId(docId);
				}
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
			}
			return new DataResponse(ResponseCode.NOT_ACCESS, ResponseCode.NOT_ACCESS, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/update/view/attachment/{attachmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateAttachmentView(@PathParam("attachmentId") long attachmentId) {
		try {
			DocumentAttachments docAttach = DocumentAttachmentsLocalServiceUtil.getDocumentAttachments(attachmentId);
			docAttach.setView(docAttach.getView() + 1);
			DocumentAttachmentsLocalServiceUtil.updateDocumentAttachments(docAttach);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/statistic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getStatistic() {
		try {
			
			int totalDraft = LegalDocumentLocalServiceUtil.getCountByStatusDoc(NewsWorkflowConstants.STATUS_DRAFT);
			int totalPending = LegalDocumentLocalServiceUtil.getCountByStatusDoc(NewsWorkflowConstants.STATUS_PENDING);
			int totalApproved = LegalDocumentLocalServiceUtil.getCountByStatusDoc(NewsWorkflowConstants.STATUS_APPROVED);
			int totalPublish = LegalDocumentLocalServiceUtil.getCountByStatusDoc(NewsWorkflowConstants.STATUS_PUBLISH);
			int totalApprovedDenied = LegalDocumentLocalServiceUtil.getCountByStatusDoc(NewsWorkflowConstants.STATUS_APPROVE_DENIED);
			int totalPublishDenied = LegalDocumentLocalServiceUtil.getCountByStatusDoc(NewsWorkflowConstants.STATUS_PUBLISH_DENIED);
					
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();
			node.put("totalDraft", totalDraft);
			node.put("totalPending", totalPending);
			node.put("totalApproved", totalApproved);
			node.put("totalPublish", totalPublish);
			node.put("totalApprovedDenied", totalApprovedDenied);
			node.put("totalPublishDenied", totalPublishDenied);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-latest/{isPublic}/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getLatestDocument(@DefaultValue("0") @PathParam("isPublic") int isPublic, @DefaultValue("3") @QueryParam("limit") int limit,
			@PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {

            List<LegalDocument> legalDocumentsList = LegalDocumentLocalServiceUtil.getLatestDocument(isPublic, limit, groupId, locale);
            
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (LegalDocument legalDocument : legalDocumentsList) {
				legalDocument.setSymbol(HtmlUtil.extractText(legalDocument.getSymbol()));
				legalDocument.setSummary(HtmlUtil.extractText(legalDocument.getSummary()));
				legalDocument.setContent(HtmlUtil.extractText(legalDocument.getContent()));
				Map<String, Object> map = legalDocument.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				arrayNode.add(object);
			}
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-popular/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getPopularDocument(@DefaultValue("5") @QueryParam("limit") int limit,
			@PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {

            List<LegalDocument> legalDocumentsList = LegalDocumentLocalServiceUtil.getPopularDocument(limit, groupId, locale);
            
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (LegalDocument legalDocument : legalDocumentsList) {
				legalDocument.setSymbol(HtmlUtil.extractText(legalDocument.getSymbol()));
				legalDocument.setSummary(HtmlUtil.extractText(legalDocument.getSummary()));
				legalDocument.setContent(HtmlUtil.extractText(legalDocument.getContent()));
				Map<String, Object> map = legalDocument.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				arrayNode.add(object);
			}
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/search-publish/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse searchPublishDocument(@PathParam("groupId") long groupId, @PathParam("companyId") long companyId, @PathParam("locale") String locale, 
			SearchObject searchObject) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
			dateFormat.setTimeZone(timeZone);
			HashMap<String, Object> searchValues = new HashMap<String, Object>();
			if (searchObject.getTypeId() > 0) {
				searchValues.put("typeId", searchObject.getTypeId());
			}
			
			if (searchObject.getOrganizationId() > 0) {
				searchValues.put("organizationId", searchObject.getOrganizationId());
			}
			
			if (searchObject.getSearchKey() != null && !searchObject.getSearchKey().isEmpty()) {
	            String searchKey = HtmlUtil.escape(searchObject.getSearchKey());
				searchValues.put("searchKey", searchKey);
			}
			
			if (searchObject.getFieldId() > 0) {
				searchValues.put("fieldId", searchObject.getFieldId());
			}
			
			/*if (searchObject.getPromulDate() != null) {
				searchValues.put("promulDate", dateFormat.format(searchObject.getPromulDate()));
			}*/
			
			if (searchObject.getFromDate() != null) {
				System.out.println(dateFormat.format(searchObject.getFromDate()));
				searchValues.put("fromDate", dateFormat.format(searchObject.getFromDate()));
			}
			
			if (searchObject.getToDate() != null) {
				searchValues.put("toDate", dateFormat.format(searchObject.getToDate()));
			}
			
			if (searchObject.getSymbol() != null) {
				searchValues.put("symbol", searchObject.getSymbol());
			}
			
			if (searchObject.getIsPublic() > 0) {
				searchValues.put("isPublic", searchObject.getIsPublic());
			}
			
            List<LegalDocument> legalDocumentsList = LegalDocumentLocalServiceUtil.searchLegalDocument(NewsWorkflowConstants.STATUS_PUBLISH, groupId, companyId, locale, 
            		searchValues);
            
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (LegalDocument legalDocument : legalDocumentsList) {
				Map<String, Object> map = legalDocument.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				
				//get legal signers
				List<LegalDSRel> legalDSRelList = LegalDSRelLocalServiceUtil.getByDocId(legalDocument.getDocId());
				String signerName = "";
				for (int i = 0; i < legalDSRelList.size(); i++) {				
					try {
						LegalSigner legalSigner = LegalSignerLocalServiceUtil.getLegalSigner(legalDSRelList.get(i).getSigId());
						signerName += HtmlUtil.extractText(legalSigner.getFullName());
						if (i < (legalDSRelList.size() - 1)) {
							signerName += ", ";
						}
					} catch (Exception e) {
						
					}
				}
				object.put("signerName", signerName);
				
				List<LegalType> legalTypesList = LegalTypeLocalServiceUtil.getByDocumentId(legalDocument.getDocId());
				String legalTypeNames = "";
				for (int i = 0; i < legalTypesList.size(); i++) {
					legalTypeNames += HtmlUtil.extractText(legalTypesList.get(i).getName());
					if (i < (legalTypesList.size() - 1)) {
						legalTypeNames += ", ";
					}
				}
				object.put("typeName", legalTypeNames);
				
				String legalOrgName = "";
				if (legalDocument.getOrganizationId() > 0) {
					LegalOrg org = LegalOrgLocalServiceUtil.getLegalOrg(legalDocument.getOrganizationId());
					legalOrgName = HtmlUtil.extractText(org.getName());
				}
				object.put("organizationName", legalOrgName);
				
				String legalFieldName = "";
				if (legalDocument.getFieldId() > 0) {
					LegalField legalField = LegalFieldLocalServiceUtil.getLegalField(legalDocument.getFieldId());
					legalFieldName = HtmlUtil.extractText(legalField.getName());
				}			
				object.put("fieldName", legalFieldName);
				
				arrayNode.add(object);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, arrayNode, DataType.JSON_STR);			
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/web-view/{groupId}/{locale}/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAllSelectOption(@PathParam("groupId") long groupId, @PathParam("companyId") long companyId, @PathParam("locale") String locale) {
		try {
			//ArrayNode orgNode = mapper.createArrayNode();
			//List<LegalOrg> legalOrgsList = LegalOrgServiceUtil.findAll(groupId, companyId, locale);
			TreeOrg treeOrg = new TreeOrg();
			ArrayNode orgNode = treeOrg.getPublishNodes(0, locale, groupId);
			/*for (LegalOrg legalOrg : legalOrgsList) {
				legalOrg.setName(HtmlUtil.extractText(legalOrg.getName()));
				Map<String, Object> map = legalOrg.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				orgNode.add(object);
			}*/
	
			/*ArrayNode legalTypeNode = mapper.createArrayNode();
			List<LegalType> legalTypesList = LegalTypeServiceUtil.findAll(groupId, companyId, locale);
			for (LegalType legalType : legalTypesList) {
				legalType.setName(HtmlUtil.extractText(legalType.getName()));
				Map<String, Object> map = legalType.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				legalTypeNode.add(object);
			}*/
			TreeLegalType treeType = new TreeLegalType();
			ArrayNode legalTypeNode = treeType.getPublishNodes(0, locale, groupId);
			
			ArrayNode legalFieldNode = mapper.createArrayNode();
			List<LegalField> legalFields = LegalFieldLocalServiceUtil.getPublishFields(locale, true, groupId);
			for (LegalField legalField : legalFields) {
				legalField.setName(HtmlUtil.extractText(legalField.getName()));
				Map<String, Object> map = legalField.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				legalFieldNode.add(object);
			}
			

			ObjectNode node = mapper.createObjectNode();
			node.putPOJO("organizations", orgNode);
			node.putPOJO("types", legalTypeNode);
			node.putPOJO("fields", legalFieldNode);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
