package elegal.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ecoit.elegaldocument.model.DocumentAttachments;
import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.model.LegalSigner;
import com.ecoit.elegaldocument.service.DocumentAttachmentsLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDSRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDTypeRelLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalSignerLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.ecoit.elegaldocument.utils.NewsWorkflowConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class DocumentUtil {
	
	public static boolean checkAttachmentName(String name) {
		boolean isAttachment = false;
		if (name.endsWith("doc") || name.endsWith("docx") || name.endsWith("pdf") || name.endsWith("zip") || name.endsWith("rar")) {
			isAttachment = true;
		}
		return isAttachment;
	}
	
	public static int getDocumentStatus(int action) {
		int statusDoc = NewsWorkflowConstants.STATUS_DRAFT;
		switch(action) {
		case DocumentRoleConstants.DOCUMENT_ADD:
			statusDoc = NewsWorkflowConstants.STATUS_DRAFT;
		    break;
		case DocumentRoleConstants.DOCUMENT_PENDING:
			statusDoc = NewsWorkflowConstants.STATUS_PENDING;
		    break;
		case DocumentRoleConstants.DOCUMENT_APPROVED:
			statusDoc = NewsWorkflowConstants.STATUS_APPROVED;
		    break;
		case DocumentRoleConstants.DOCUMENT_PUBLISH:
			statusDoc = NewsWorkflowConstants.STATUS_PUBLISH;
		    break;
		case DocumentRoleConstants.DOCUMENT_APPROVED_RETURN:
			statusDoc = NewsWorkflowConstants.STATUS_APPROVE_DENIED;
		    break;
		case DocumentRoleConstants.DOCUMENT_PUBLISH_RETURN:
			statusDoc = NewsWorkflowConstants.STATUS_PUBLISH_DENIED;
		    break;
		}
		return statusDoc;
	}
	
	public static ObjectNode createDocumentNode(LegalDocument legalDocument) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode documentNode = mapper.createObjectNode();
		documentNode.put("docId", legalDocument.getDocId());
		documentNode.put("symbol", HtmlUtil.extractText(legalDocument.getSymbol()));
		documentNode.put("isPublic", legalDocument.getIsPublic());
		documentNode.put("summary", HtmlUtil.extractText(legalDocument.getSummary()));
		
		if (legalDocument.getPublishedDate() != null) {
			documentNode.put("publishedDate", legalDocument.getPublishedDate().getTime());
		}
		
		if (legalDocument.getPromulDate() != null) {
			documentNode.put("promulDate", legalDocument.getPromulDate().getTime());
		}

		if (legalDocument.getEffectivedDate() != null) {
			documentNode.put("effectivedDate", legalDocument.getEffectivedDate().getTime());
		}
		
		boolean isNeverExpired = true;
		if (legalDocument.getExpiredDate() != null) {
			isNeverExpired = false;
			documentNode.put("expiredDate", legalDocument.getExpiredDate().getTime());
		}
		
		documentNode.put("isNeverExpired", isNeverExpired);
		documentNode.put("organizationId", legalDocument.getOrganizationId());
		documentNode.put("fieldId", legalDocument.getFieldId());
		documentNode.put("content", HtmlUtil.extractText(legalDocument.getContent()));
		documentNode.put("view", legalDocument.getView());
		//get attachment URL
		List<DocumentAttachments> attachmentsList = DocumentAttachmentsLocalServiceUtil.getAttachmentsByDocId(legalDocument.getDocId());
		ArrayNode attachmentURLsList = mapper.createArrayNode();
		for (DocumentAttachments attachment : attachmentsList) {
			ObjectNode attachmentNode = mapper.createObjectNode();
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(attachment.getAttachmentId());
			String src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
					+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
					+ fileEntry.getCreateDate().getTime();
			attachmentNode.put("attachmentId", attachment.getAttachmentId());
			attachmentNode.put("attachmentName", fileEntry.getFileName());
			attachmentNode.put("attachmentUrl", src);
			attachmentNode.put("view", attachment.getView());
			attachmentURLsList.add(attachmentNode);
		}
		documentNode.putPOJO("attachmentURLsList", attachmentURLsList);
		
		//get typeIds
		List<LegalDTypeRel> legalDTypeRelsList = LegalDTypeRelLocalServiceUtil.getByDocId(legalDocument.getDocId());
		List<Long> typeIdsList = new ArrayList<>();
		for (LegalDTypeRel legalDTypeRel : legalDTypeRelsList) {
			typeIdsList.add(legalDTypeRel.getTypeId());
		}
		documentNode.putPOJO("typesList", typeIdsList);
		
		//get legal signers
		List<LegalDSRel> legalDSRelList = LegalDSRelLocalServiceUtil.getByDocId(legalDocument.getDocId());
		ArrayNode signerRelsList = mapper.createArrayNode();
		for (LegalDSRel legalDSRel : legalDSRelList) {
			try {
				LegalSigner legalSigner = LegalSignerLocalServiceUtil.getLegalSigner(legalDSRel.getSigId());
				ObjectNode signerObject = mapper.createObjectNode();
				signerObject.put("sigId", legalSigner.getSigId());
				signerObject.put("fullName", HtmlUtil.extractText(legalSigner.getFullName()));
				signerRelsList.add(signerObject);
			} catch (Exception e) {
				
			}
		}
		documentNode.putPOJO("signerRels", signerRelsList);
		
		//get related document
		ArrayNode relatedDocumentNode = mapper.createArrayNode();
		ArrayNode relatedeDocIdNode = mapper.createArrayNode();
		JSONArray relatedDocArray = JSONFactoryUtil.createJSONArray(legalDocument.getDocRelation());
		for (int i =0; i < relatedDocArray.length(); i++) {
			try {
				LegalDocument relatedDocument = LegalDocumentLocalServiceUtil.getLegalDocument(relatedDocArray.getLong(i));
				relatedDocument.setSymbol(HtmlUtil.extractText(relatedDocument.getSymbol()));
				Map<String, Object> map = relatedDocument.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				relatedDocumentNode.add(object);
				relatedeDocIdNode.add(relatedDocArray.getLong(i));
			} catch (Exception e){
				
			}
		}
		documentNode.putPOJO("docRelation", relatedeDocIdNode);

		//get repalced document
		ArrayNode replacedDocumentNode = mapper.createArrayNode();
		ArrayNode replacedDocIdNode = mapper.createArrayNode();
		JSONArray replacedDocArray = JSONFactoryUtil.createJSONArray(legalDocument.getDocRelation());
		for (int i =0; i < replacedDocArray.length(); i++) {
			try {
				LegalDocument replacedDocument = LegalDocumentLocalServiceUtil.getLegalDocument(replacedDocArray.getLong(i));
				replacedDocument.setSymbol(HtmlUtil.extractText(replacedDocument.getSymbol()));
				Map<String, Object> map = replacedDocument.getModelAttributes();
				ObjectNode object = mapper.convertValue(map, ObjectNode.class);
				replacedDocumentNode.add(object);
				replacedDocIdNode.add(replacedDocArray.getLong(i));
			} catch (Exception e){
				
			}
		}	 
		documentNode.putPOJO("replaceDoc", replacedDocIdNode);
		
		ObjectNode mainNode = mapper.createObjectNode();
		mainNode.putPOJO("document", documentNode);
		mainNode.putPOJO("selectedSignersList", signerRelsList);
		mainNode.putPOJO("selectedRelatedDocumentsList", relatedDocumentNode);
		mainNode.putPOJO("selectedReplacedDocumentsList", replacedDocumentNode);
		return mainNode;
	}
	
	public static LegalDocument setDataToLegalDocument(LegalDocument legalDocument, HttpServletRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		legalDocument.setSymbol(HtmlUtil.escape(ParamUtil.getString(request, "symbol", "")).trim());
		if (!ParamUtil.getString(request, "promulDate", "").isEmpty()) {
			legalDocument.setPromulDate(ParamUtil.getDate(request, "promulDate", dateFormat));
		}
		
		if (!ParamUtil.getString(request, "effectivedDate", "").isEmpty()) {
			legalDocument.setEffectivedDate(ParamUtil.getDate(request, "effectivedDate", dateFormat));
		}
		
		if (!ParamUtil.getString(request, "expiredDate", "").isEmpty()) {
			legalDocument.setExpiredDate(ParamUtil.getDate(request, "expiredDate", dateFormat));
		}
		
		legalDocument.setSignerRels(ParamUtil.getString(request, "signerRels", ""));

		legalDocument.setReplaceDoc(ParamUtil.getString(request, "replaceDoc", ""));
		legalDocument.setSummary(HtmlUtil.escape(ParamUtil.getString(request, "summary", "")).trim());
		legalDocument.setContent(HtmlUtil.escape(ParamUtil.getString(request, "content", "")).trim());
		
		legalDocument.setIsPublic(ParamUtil.getInteger(request, "isPublic", 0));
		legalDocument.setFieldId(ParamUtil.getLong(request, "fieldId", 0));
		legalDocument.setOrganizationId(ParamUtil.getLong(request, "organizationId", 0));
		legalDocument.setDocRelation(ParamUtil.getString(request, "docRelation", ""));
		return legalDocument;
	}
}
