package com.ecoit.qa.question.api;

import java.io.File;
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

import com.ecoit.qa.question.object.AnswerObject;
import com.ecoit.qa.question.object.AttachmentObject;
import com.ecoit.qa.question.object.QuestionObject;
import com.ecoit.qa.question.object.SearchObject;
import com.ecoit.qa.question.utils.AttachmentUtil;
import com.ecoit.qa.question.utils.CategoryUtil;
import com.ecoit.qa.question.utils.PermissionUtil;
import com.ecoit.qa.question.utils.QuestionUtil;
import com.ecoit.qa.service.model.Answer;
import com.ecoit.qa.service.model.AttachmentAnswer;
import com.ecoit.qa.service.model.AttachmentQuestion;
import com.ecoit.qa.service.model.Category;
import com.ecoit.qa.service.model.Question;
import com.ecoit.qa.service.service.AnswerLocalServiceUtil;
import com.ecoit.qa.service.service.AttachmentAnswerLocalServiceUtil;
import com.ecoit.qa.service.service.AttachmentQuestionLocalServiceUtil;
import com.ecoit.qa.service.service.CategoryLocalServiceUtil;
import com.ecoit.qa.service.service.QuestionLocalServiceUtil;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;
import com.ecoit.qa.service.service.persistence.AttachmentQuestionPK;
import com.ecoit.qa.service.utils.ConfigUtil;
import com.ecoit.qa.service.utils.DataResponse;
import com.ecoit.qa.service.utils.QuestionPermissionUtil;
import com.ecoit.qa.service.utils.QuestionWorkflowConstants;
import com.ecoit.qa.service.utils.ResponseCode;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import com.ecoit.qa.service.utils.DataResponse.DataType;
import com.ecoit.qa.service.utils.QuestionRoleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QuestionResource {
	private static QuestionResource instance = null;
	
	public static QuestionResource getInstance() {
		if (instance == null) {
			instance = new QuestionResource();
		}
		return instance;
	}
	ObjectMapper mapper = new ObjectMapper();
	@POST
	@Path("/get-by-config/{locale}/{groupId}/{userId}/{configName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@PathParam("userId") long userId, SearchObject searchObject, @DefaultValue("10") @QueryParam("limit") int limit, 
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("") @PathParam("configName") String configName,
			@PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {
			locale = HtmlUtil.escape(locale);
			String searchKey = HtmlUtil.escape(searchObject.getSearchKey());
			int statusDoc = QuestionWorkflowConstants.STATUS_DRAFT;
			switch(configName) {
			case ConfigUtil.PHAN_HOI_NHAP:
				statusDoc = QuestionWorkflowConstants.STATUS_DRAFT;
				break;
			case ConfigUtil.PHAN_HOI_CHO_DUYET:
				statusDoc = QuestionWorkflowConstants.STATUS_PENDING;
				break;
			case ConfigUtil.PHAN_HOI_DA_DUYET:
				statusDoc = QuestionWorkflowConstants.STATUS_APPROVED;
				break;
			case ConfigUtil.PHAN_HOI_DA_XUAT_BAN:
				statusDoc = QuestionWorkflowConstants.STATUS_PUBLISH;
				break;
			case ConfigUtil.PHAN_HOI_HUY_DUYET:
				statusDoc = QuestionWorkflowConstants.STATUS_APPROVE_DENIED;
				break;
			case ConfigUtil.PHAN_HOI_HUY_XUAT_BAN:
				statusDoc = QuestionWorkflowConstants.STATUS_PUBLISH_DENIED;
				break;
			}
			
			List<Question> questionsList = QuestionLocalServiceUtil.getAllQuestions(groupId, locale, searchObject.getCategoryId(), searchKey, start, limit, statusDoc);
			ArrayNode questionsNode = mapper.createArrayNode();
			for (Question question : questionsList) {
				ObjectNode questionObject = mapper.createObjectNode();
				questionObject.put("userName", question.getUserName());
				questionObject.put("email", question.getEmail());
				String categoryName = "";
				try {
					Category category = CategoryLocalServiceUtil.getCategory(question.getCategoryId());
					categoryName = category.getName();
				} catch (Exception e) {
					
				}
				questionObject.put("questionId", question.getQuestionId());
				questionObject.put("categoryName", categoryName);
				questionObject.put("title", question.getTitle());
				questionObject.put("view", question.getView());
				questionsNode.add(questionObject);
			}
			long total = QuestionLocalServiceUtil.countQuestions(groupId, locale, searchObject.getCategoryId(), searchKey, statusDoc);
			ObjectNode responseNode = mapper.createObjectNode();
			responseNode.putPOJO("questions", questionsNode);
			responseNode.put("total", total);
			responseNode.putPOJO("permissions", PermissionUtil.getPermissionNode(userId));
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, responseNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/get-publish/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getPublish(SearchObject searchObject,
			@PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {
			String searchKey = HtmlUtil.escape(searchObject.getSearchKey());
			
			List<Question> questionsList = QuestionLocalServiceUtil.getAllQuestions(groupId, locale, searchObject.getCategoryId(), searchKey, 0, 0, QuestionWorkflowConstants.STATUS_PUBLISH);
			ArrayNode questionsNode = mapper.createArrayNode();
			for (Question question : questionsList) {
				ObjectNode questionObject = mapper.createObjectNode();
				questionObject.put("userName", question.getUserName());
				questionObject.put("email", question.getEmail());
				String categoryName = "";
				if (question.getCategoryId() > 0) {
					Category category = CategoryLocalServiceUtil.getCategory(question.getCategoryId());
					categoryName = category.getName();
				}
				
				questionObject.put("questionId", question.getQuestionId());
				questionObject.put("categoryName", categoryName);
				
				Answer answer = AnswerLocalServiceUtil.getByQuestionId(question.getQuestionId());
				String answerContent = "";
				if (answer != null) {
					answerContent = answer.getContent();
				}
				questionObject.put("answer", answerContent);
				
				questionObject.put("title", question.getTitle());
				questionObject.put("view", question.getView());
				questionsNode.add(questionObject);
			}
			long total = QuestionLocalServiceUtil.countQuestions(groupId, locale, searchObject.getCategoryId(), searchKey, QuestionWorkflowConstants.STATUS_PUBLISH);
			ObjectNode responseNode = mapper.createObjectNode();
			responseNode.putPOJO("questions", questionsNode);
			responseNode.put("total", total);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, responseNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-publish/item/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getPublishItem(@PathParam("userId") long userId, @PathParam("questionId") long questionId) {
		try {
			if (questionId < 0 ) {
				return DataResponse.PARAM_ERROR;
			}

			ObjectNode responseNode = mapper.createObjectNode();
			Question question = QuestionLocalServiceUtil.getQuestionByStatusAndId(QuestionWorkflowConstants.STATUS_PUBLISH, questionId);
			if (question != null) {
				ObjectNode questionObject = mapper.createObjectNode();
				questionObject.put("userName", question.getUserName());
				questionObject.put("email", question.getEmail());
				String categoryName = "";
				if (question.getCategoryId() > 0) {
					Category category = CategoryLocalServiceUtil.getCategory(question.getCategoryId());
					categoryName = category.getName();
				}
				
				questionObject.put("questionId", question.getQuestionId());
				questionObject.put("categoryId", question.getCategoryId());
				questionObject.put("categoryName", categoryName);
				questionObject.put("title", question.getTitle());
				questionObject.put("content", question.getContent());
				List<AttachmentQuestion> attachmentQuestionsList = AttachmentQuestionLocalServiceUtil.getByQuestionId(questionId);
				if (attachmentQuestionsList != null && attachmentQuestionsList.size() > 0) {
					ArrayNode attachObject = mapper.createArrayNode();
					for (AttachmentQuestion attachmentQuestion : attachmentQuestionsList) {
						ObjectNode object = mapper.createObjectNode();
						FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(attachmentQuestion.getAttachmentId());
						String src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
								+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
								+ fileEntry.getCreateDate().getTime();
						object.put("attachmentUrl", src);
						object.put("attachmentName", fileEntry.getFileName());
						attachObject.add(object);
					}
					questionObject.putPOJO("attachments", attachObject);
				}
				responseNode.putPOJO("question", questionObject);
				Answer answer = AnswerLocalServiceUtil.getByQuestionId(questionId);
				if (answer != null) {
					AnswerObject answerObject = new AnswerObject();
					answerObject.setAnswerId(answer.getAnswerId());
					answerObject.setContent(answer.getContent());
					List<AttachmentAnswer> attachmentAnswersList = AttachmentAnswerLocalServiceUtil.getByAnswerId(answer.getAnswerId());
					if (attachmentAnswersList != null && attachmentAnswersList.size() > 0) {
						List<AttachmentObject> attachmentsList = new ArrayList<>();
						for (AttachmentAnswer attachmentAnswer : attachmentAnswersList) {
							AttachmentObject object = new AttachmentObject();
							FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(attachmentAnswer.getAttachmentId());
							String src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
									+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
									+ fileEntry.getCreateDate().getTime();
							object.setAttachmentUrl(src);
							object.setAttachmentName(fileEntry.getFileName());
							object.setAttachmentId(attachmentAnswer.getAttachmentId());
							attachmentsList.add(object);
						}
						answerObject.setAttachments(attachmentsList);
					}
					responseNode.putPOJO("answer", answerObject);
				}
			}
			QuestionLocalServiceUtil.updateView(questionId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, responseNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/item/{userId}/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getItem(@PathParam("userId") long userId, @PathParam("questionId") long questionId) {
		try {
			if (questionId < 0 || userId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			Question question = QuestionLocalServiceUtil.getQuestion(questionId);
			QuestionObject questionObject = new QuestionObject();
			questionObject.setAddress(question.getAddress());
			questionObject.setCategoryId(question.getCategoryId());
			questionObject.setContent(question.getContent());
			questionObject.setEmail(question.getEmail());
			questionObject.setUserName(question.getUserName());
			questionObject.setPhoneNumber(question.getPhoneNumber());
			questionObject.setStatus(question.getStatus());
			questionObject.setQuestionId(question.getQuestionId());
			questionObject.setTitle(question.getTitle());
			List<AttachmentQuestion> attachmentQuestionsList = AttachmentQuestionLocalServiceUtil.getByQuestionId(questionId);
			if (attachmentQuestionsList != null && attachmentQuestionsList.size() > 0) {
				List<AttachmentObject> attachmentsList = new ArrayList<>();
				for (AttachmentQuestion attachmentQuestion : attachmentQuestionsList) {
					AttachmentObject object = new AttachmentObject();
					FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(attachmentQuestion.getAttachmentId());
					String src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
							+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
							+ fileEntry.getCreateDate().getTime();
					object.setAttachmentUrl(src);
					object.setAttachmentName(fileEntry.getFileName());
					object.setAttachmentId(attachmentQuestion.getAttachmentId());
					attachmentsList.add(object);
				}
				questionObject.setAttachments(attachmentsList);
			}
			
			ObjectNode responseNode = mapper.createObjectNode();
			responseNode.putPOJO("question", questionObject);
			responseNode.putPOJO("permissions", PermissionUtil.getPermissionNode(userId));
			
			Answer answer = AnswerLocalServiceUtil.getByQuestionId(questionId);
			if (answer != null) {
				AnswerObject answerObject = new AnswerObject();
				answerObject.setAnswerId(answer.getAnswerId());
				answerObject.setContent(answer.getContent());
				List<AttachmentAnswer> attachmentAnswersList = AttachmentAnswerLocalServiceUtil.getByAnswerId(answer.getAnswerId());
				if (attachmentAnswersList != null && attachmentAnswersList.size() > 0) {
					List<AttachmentObject> attachmentsList = new ArrayList<>();
					for (AttachmentAnswer attachmentAnswer : attachmentAnswersList) {
						AttachmentObject object = new AttachmentObject();
						FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(attachmentAnswer.getAttachmentId());
						String src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
								+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
								+ fileEntry.getCreateDate().getTime();
						object.setAttachmentUrl(src);
						object.setAttachmentName(fileEntry.getFileName());
						object.setAttachmentId(attachmentAnswer.getAttachmentId());
						attachmentsList.add(object);
					}
					answerObject.setAttachments(attachmentsList);
				}
				responseNode.putPOJO("answer", answerObject);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, responseNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/create-question/{groupId}/{userId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse createQuestion(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			String title = HtmlUtil.escape(ParamUtil.get(request, "title", ""));
			String address = HtmlUtil.escape(ParamUtil.get(request, "address", ""));
			String email = HtmlUtil.escape(ParamUtil.get(request, "email", ""));
			String content = HtmlUtil.escape(ParamUtil.get(request, "content", ""));
			String phoneNumber = HtmlUtil.escape(ParamUtil.get(request, "phoneNumber", ""));
			String name = HtmlUtil.escape(ParamUtil.get(request, "name", ""));		
			long categoryId = ParamUtil.getLong(request, "categoryId", 0);
			
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			File[] attachmentsList = upload.getFiles("attachments");
			ArrayList<Long> attachmentIdsList = new ArrayList<>();
			if (attachmentsList != null && attachmentsList.length > 0) {
				for (File attachment : attachmentsList) {
					if (!AttachmentUtil.checkAttachmentName(attachment.getName().toLowerCase())) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
								"Không đúng định dạng .doc, .docx, .pdf, .zip, .rar", DataType.JSON_STR);
					}
				}
				
				for (File attachment : attachmentsList) {
					long attachmentId = AttachmentUtil.uploadFile(upload, attachment, attachment.getName(), locale, title, groupId, userId);
					attachmentIdsList.add(attachmentId);
				}
			}
			
			QuestionLocalServiceUtil.createUpdateQuestion(groupId, locale, userId, 0, title, email, content, phoneNumber, address, attachmentIdsList, categoryId, name, QuestionWorkflowConstants.STATUS_PENDING);
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@PUT
	@Path("/update-question/{groupId}/{userId}/{locale}/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse updateQuestion(@PathParam("groupId") long groupId, @PathParam("locale") String locale, 
			@PathParam("userId") long userId, @PathParam("questionId") long questionId, @Context HttpServletRequest request) {
		try {
			//update question
			String title = HtmlUtil.escape(ParamUtil.get(request, "title", ""));
			String address = HtmlUtil.escape(ParamUtil.get(request, "address", ""));
			String email = HtmlUtil.escape(ParamUtil.get(request, "email", ""));
			String content = HtmlUtil.escape(ParamUtil.get(request, "content", ""));
			String phoneNumber = HtmlUtil.escape(ParamUtil.get(request, "phoneNumber", ""));
			String name = HtmlUtil.escape(ParamUtil.get(request, "name", ""));
			int action = ParamUtil.getInteger(request, "action", -1);
			int statusDoc = -1;
			if (action >= 0) {
				statusDoc = QuestionUtil.getQuestionStatus(action);
			}
			long categoryId = ParamUtil.getLong(request, "categoryId", 0);
			
			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			File[] attachmentsList = upload.getFiles("attachments");
			ArrayList<Long> attachmentIdsList = new ArrayList<>();
			if (attachmentsList != null && attachmentsList.length > 0) {
				for (File attachment : attachmentsList) {
					if (!AttachmentUtil.checkAttachmentName(attachment.getName().toLowerCase())) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
								"Không đúng định dạng .doc, .docx, .pdf, .zip, .rar", DataType.JSON_STR);
					}
				}
				
				for (File attachment : attachmentsList) {
					long attachmentId = AttachmentUtil.uploadFile(upload, attachment, attachment.getName(), locale, title, groupId, userId);
					attachmentIdsList.add(attachmentId);
				}
			}
			Question question = QuestionLocalServiceUtil.createUpdateQuestion(groupId, locale, userId, questionId, title, email, content, phoneNumber, address, attachmentIdsList, categoryId, name, statusDoc);
			//update question
			
			//update answer
			String answerContent = HtmlUtil.escape(ParamUtil.get(request, "answerContent", ""));
			//update answer
			Answer answer = AnswerLocalServiceUtil.getByQuestionId(question.getQuestionId());
			long answerId = 0;
			if (answer != null) {
				answerId = answer.getAnswerId();
			}
			
			/*File answerFile = upload.getFile("answerAttachment");
			long answerAttachmentId = 0;
			if (answerFile != null) {
				answerAttachmentId = AttachmentUtil.uploadFile(upload, answerFile, answerFile.getName(), locale, title, groupId, userId);
			}*/
			
			File[] answerAttachmentsList = upload.getFiles("answerAttachments");
			ArrayList<Long> answerAttachmentIdsList = new ArrayList<>();
			if (answerAttachmentsList != null && answerAttachmentsList.length > 0) {
				for (File attachment : answerAttachmentsList) {
					if (!AttachmentUtil.checkAttachmentName(attachment.getName().toLowerCase())) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
								"Không đúng định dạng .doc, .docx, .pdf, .zip, .rar", DataType.JSON_STR);
					}
				}
				
				for (File attachment : answerAttachmentsList) {
					long attachmentId = AttachmentUtil.uploadFile(upload, attachment, attachment.getName(), locale, title, groupId, userId);
					answerAttachmentIdsList.add(attachmentId);
				}
			}
			AnswerLocalServiceUtil.createUpdateAnswer(userId, answerId, questionId, answerAttachmentIdsList, answerContent);
			//update answer
			
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/question-attachment/{userId}/{questionId}/{attachmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteQuestionAttachment(@PathParam("userId") long userId, @PathParam("questionId") long questionId, @PathParam("attachmentId") long attachmentId) {
		try {
			//Question question = QuestionLocalServiceUtil.getQuestion(questionId);
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(attachmentId);
			AttachmentQuestionLocalServiceUtil.deleteAttachmentQuestion(new AttachmentQuestionPK(attachmentId, questionId));
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@DELETE
	@Path("/delete/answer-attachment/{userId}/{answerId}/{attachmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse deleteAnswerAttachment(@PathParam("userId") long userId, @PathParam("answerId") long answerId, @PathParam("attachmentId") long attachmentId) {
		try {
			//Answer answer = AnswerLocalServiceUtil.getAnswer(answerId);
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(attachmentId);
			AttachmentAnswerLocalServiceUtil.deleteAttachmentAnswer(new AttachmentAnswerPK(attachmentId, answerId));
			/*answer.setAttachmentId(0);
			AnswerLocalServiceUtil.updateAnswer(answer);*/
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@POST
	@Path("/delete/question/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse deleteQuestion(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_REMOVE)) {
				long[] questionIdList = ParamUtil.getLongValues(request, "questionId");
				
				if (questionIdList == null || questionIdList.length <= 0) {
					return DataResponse.PARAM_ERROR;
				}
				
				for (long questionId : questionIdList) {
					QuestionLocalServiceUtil.deleteQuestion(questionId);
					try {
						Answer answer = AnswerLocalServiceUtil.getByQuestionId(questionId);
						if (answer != null) {
							AttachmentAnswerLocalServiceUtil.deleteByAnswerId(answer.getAnswerId());
							AnswerLocalServiceUtil.deleteAnswer(answer);
						}
					} catch (Exception e) {
						
					}
					AttachmentQuestionLocalServiceUtil.deleteByQuestionId(questionId);
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
	@Path("/update/status/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse getSuggestedDocument(@PathParam("userId") long userId, @Context HttpServletRequest request) {
		try {
			long[] questionIdList = ParamUtil.getLongValues(request, "questionId");
		
			if (questionIdList == null || questionIdList.length <= 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			for (long questionId : questionIdList) {
				int action = ParamUtil.getInteger(request, "action", QuestionRoleConstants.QUESTION_PENDING);
				QuestionLocalServiceUtil.updateStatus(questionId, QuestionUtil.getQuestionStatus(action), userId);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/update/view/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse getSuggestedDocument(@PathParam("questionId") long questionId) {
		try {
			
			if (questionId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			QuestionLocalServiceUtil.updateView(questionId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/popular/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAll(@DefaultValue("5") @QueryParam("limit") int limit, @PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {
			
			List<Question> questionsList = QuestionLocalServiceUtil.getMostPopular(groupId, locale, QuestionWorkflowConstants.STATUS_PUBLISH, limit);
			ArrayNode questionsNode = mapper.createArrayNode();
			for (Question question : questionsList) {
				ObjectNode questionObject = mapper.createObjectNode();
				questionObject.put("userName", question.getUserName());
				questionObject.put("email", question.getEmail());
				String categoryName = "";
				if (question.getCategoryId() > 0) {
					Category category = CategoryLocalServiceUtil.getCategory(question.getCategoryId());
					categoryName = category.getName();
				}
				questionObject.put("questionId", question.getQuestionId());
				questionObject.put("categoryName", categoryName);
				questionObject.put("title", question.getTitle());
				questionObject.put("view", question.getView());
				questionsNode.add(questionObject);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, questionsNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get/statistic/{groupId}/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getStatistic(@PathParam("groupId") long groupId, @PathParam("locale") String locale) {
		try {
			int totalPending = QuestionLocalServiceUtil.countByStatus(QuestionWorkflowConstants.STATUS_PENDING, groupId, locale);
			int totalApproved = QuestionLocalServiceUtil.countByStatus(QuestionWorkflowConstants.STATUS_APPROVED, groupId, locale);
			int totalPublish = QuestionLocalServiceUtil.countByStatus(QuestionWorkflowConstants.STATUS_PUBLISH, groupId, locale);
			int totalApprovedDenied = QuestionLocalServiceUtil.countByStatus(QuestionWorkflowConstants.STATUS_APPROVE_DENIED, groupId, locale);
			int totalPublishDenied = QuestionLocalServiceUtil.countByStatus(QuestionWorkflowConstants.STATUS_PUBLISH_DENIED, groupId, locale);
			
			ObjectNode node = mapper.createObjectNode();
			node.put("totalPending", totalPending);
			node.put("totalApproved", totalApproved);
			node.put("totalPublish", totalPublish);
			node.put("totalApprovedDenied", totalApprovedDenied);
			node.put("totalPublishDenied", totalPublishDenied);
			
			ArrayNode cateNode = CategoryUtil.getCategoryNodes(0, groupId);
			node.putPOJO("categoryData", cateNode);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
		    e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
