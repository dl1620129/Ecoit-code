package elegal.api;

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

import com.ecoit.elegaldocument.model.LegalSuggestDocument;
import com.ecoit.elegaldocument.service.LegalDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.service.LegalSuggestDocumentLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DataResponse;
import com.ecoit.elegaldocument.utils.ResponseCode;
import com.ecoit.elegaldocument.utils.DataResponse.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;

import elegal.object.SuggestObject;

@Path("/suggest-doc")
public class SuggestResource {
	private static SuggestResource instance;

	public static SuggestResource getInstance() {
		if (instance == null) {
			instance = new SuggestResource();
		}
		return instance;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/getall/{groupId}/{locale}/{docId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale, @PathParam("docId") long docId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start) {
		
        try {
        	locale = HtmlUtil.escape(locale);
			
			if (groupId < 0 || locale.isEmpty() || docId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();	
			List<LegalSuggestDocument> suggestionsList = LegalSuggestDocumentLocalServiceUtil.getSuggestions(docId, locale, start, limit);
			List<SuggestObject> objectsList = new ArrayList<>();
			for (LegalSuggestDocument suggestion: suggestionsList) {
				SuggestObject object = new SuggestObject();
				object.setSugId(suggestion.getSugId());
				object.setDocId(suggestion.getDocId());
				object.setUserName(suggestion.getVisitorName());
				object.setEmail(suggestion.getVisitorEmail());
				object.setTitle(suggestion.getTitle());
				object.setContent(suggestion.getContent());
				object.setApproved(suggestion.getApproved());
				objectsList.add(object);
			}
			int total = LegalSuggestDocumentLocalServiceUtil.countSuggestions(docId, locale);
			
			objectNode.put("total", total);
			objectNode.putPOJO("data", objectsList);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
        } catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{sugId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("sugId") long sugId) {
		
        try {
			
			if (sugId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			LegalSuggestDocument legalSuggestionDocument = LegalSuggestDocumentLocalServiceUtil.getLegalSuggestDocument(sugId);
			
			SuggestObject object = new SuggestObject();
			object.setSugId(legalSuggestionDocument.getSugId());
			object.setDocId(legalSuggestionDocument.getDocId());
			object.setUserName(HtmlUtil.extractText(legalSuggestionDocument.getVisitorName()));
			object.setEmail(HtmlUtil.extractText(legalSuggestionDocument.getVisitorEmail()));
			object.setTitle(HtmlUtil.extractText(legalSuggestionDocument.getTitle()));
			object.setContent(HtmlUtil.extractText(legalSuggestionDocument.getContent()));
			object.setApproved(legalSuggestionDocument.getApproved());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, object, DataType.JSON_STR);
        } catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse createSuggest(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("userId") long userId, SuggestObject suggestObject) {
		try {
			String userName = HtmlUtil.escape(suggestObject.getUserName());
			String email = HtmlUtil.escape(suggestObject.getEmail());
			String title = HtmlUtil.escape(suggestObject.getTitle());
			String content = HtmlUtil.escape(suggestObject.getContent());
			LegalSuggestDocumentLocalServiceUtil.createUpdateSuggestion(0, suggestObject.getDocId(), groupId, locale, userId, userName, email, title, content, false);
			LegalDocumentLocalServiceUtil.updateNewGopY(suggestObject.getDocId(), true);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update/{groupId}/{locale}/{userId}/{sugId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse updateSuggest(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("userId") long userId, @PathParam("sugId") long sugId, SuggestObject suggestObject) {
		try {
			String userName = HtmlUtil.escape(suggestObject.getUserName());
			String email = HtmlUtil.escape(suggestObject.getEmail());
			String title = HtmlUtil.escape(suggestObject.getTitle());
			String content = HtmlUtil.escape(suggestObject.getContent());
			LegalSuggestDocumentLocalServiceUtil.createUpdateSuggestion(sugId, suggestObject.getDocId(), groupId, locale, userId, userName, email, title, content, suggestObject.isApproved());
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/suggesion/{sugId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteSuggestion(@PathParam("sugId") long sugId) {
		try {
			LegalSuggestDocumentLocalServiceUtil.deleteLegalSuggestDocument(sugId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/approved/{userId}/{isApproved}/{sugId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse approvedSuggestion(@PathParam("userId") long userId, @PathParam("isApproved") boolean isApproved, @PathParam("sugId") long sugId) {
		try {
			LegalSuggestDocumentLocalServiceUtil.approvedSuggestion(sugId, isApproved, userId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
