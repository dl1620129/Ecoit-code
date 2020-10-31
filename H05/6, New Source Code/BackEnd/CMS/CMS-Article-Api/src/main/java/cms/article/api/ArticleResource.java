package cms.article.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.software.cms.model.Article;
import com.software.cms.model.ArticleHistory;
import com.software.cms.model.ArticleMessage;
import com.software.cms.model.Comment;
import com.software.cms.model.Event;
import com.software.cms.model.Logger;
import com.software.cms.model.Tag;
import com.software.cms.service.ArticleHistoryLocalServiceUtil;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.ArticleMessageLocalServiceUtil;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;
import com.software.cms.service.EventLocalServiceUtil;
import com.software.cms.service.LoggerLocalServiceUtil;
import com.software.cms.service.TagLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.software.util.DataResponse.DataType;
import com.software.util.NewsWorkflowConstants;
import com.software.util.PermissionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import cms.article.config.ConfigUtil;
import cms.article.object.ArticleObject;
import cms.article.object.ArticleObject.ArticleInvolve;
import cms.article.object.ArticleObject.ArticlePage;
import cms.article.object.ArticleObject.Category;
import cms.article.util.ArticleCheck;
import cms.article.util.AttachmentUtil;

public class ArticleResource {
	private static ArticleResource instance = null;

	public static ArticleResource getInstance() {
		if (instance == null) {
			instance = new ArticleResource();
		}
		return instance;
	}

	@GET
	@Path("/get-sub-site/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetSubSite(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @DefaultValue("-1") @QueryParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode subSite = ArticleObject.getSubSite(groupId, articleId);
			ObjectNode node = mapper.createObjectNode().putPOJO("subsite", subSite);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/get-by-config/{groupId}/{locale}/{userId}/{configName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetAll(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @DefaultValue("") @PathParam("configName") String configName,
			@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("") @QueryParam("q") String q, ArticleObject.SearchObject searchObject) {
		try {
			locale = HtmlUtil.escape(locale);
			q = HtmlUtil.escape(q);
			configName = HtmlUtil.escape(configName);

			if (groupId < 0 || locale.isEmpty() || configName.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			if (configName.equals(ConfigUtil.THONG_TIN)) {

				Calendar calendar = Calendar.getInstance();
				String textInforArt = "Thống kê tổng bài viết trong năm - " + calendar.get(Calendar.YEAR);
				String textInforViewCount = "Thống kê bài viết có lượt xem nhiều trong năm : "
						+ calendar.get(Calendar.YEAR);
				int toltalDraf = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId,
						NewsWorkflowConstants.STATUS_DRAFT, 0, "", "", "", false, false, false, false, null, null,
						false, false);
				int toltalPending = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId,
						NewsWorkflowConstants.STATUS_PENDING, 0, "", "", "", false, false, false, false, null, null,
						false, false);
				int toltalAppove = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId,
						NewsWorkflowConstants.STATUS_APPROVED, 0, "", "", "", false, false, false, false, null, null,
						false, false);
				int toltalPublish = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId,
						NewsWorkflowConstants.STATUS_PUBLISH, 0, "", "", "", false, false, false, false, null, null,
						false, false);
				int toltalPublishDenied = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId,
						NewsWorkflowConstants.STATUS_PUBLISH_DENIED, 0, "", "", "", false, false, false, false, null,
						null, false, false);
				int toltalApproveDenied = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId,
						NewsWorkflowConstants.STATUS_APPROVE_DENIED, 0, "", "", "", false, false, false, false, null,
						null, false, false);

				ObjectMapper mapper = new ObjectMapper();
				ObjectNode node = mapper.createObjectNode();
				node.put("textInforArt", textInforArt);
				node.put("textInforViewCount", textInforViewCount);
				node.put("toltalDraf", toltalDraf);
				node.put("toltalPending", toltalPending);
				node.put("toltalAppove", toltalAppove);
				node.put("toltalPublish", toltalPublish);
				node.put("toltalPublishDenied", toltalPublishDenied);
				node.put("toltalApproveDenied", toltalApproveDenied);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
			} else if (configName.equals(ConfigUtil.BAI_VIET) || configName.equals(ConfigUtil.BAI_VIET_NHAP)
					|| configName.equals(ConfigUtil.BAI_VIET_CHO_DUYET)
					|| configName.equals(ConfigUtil.BAI_VIET_DA_DUYET)
					|| configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)
					|| configName.equals(ConfigUtil.BAI_VIET_HUY_DUYET)
					|| configName.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN)) {

				long status = NewsWorkflowConstants.STATUS_DRAFT;
				if (configName.equals(ConfigUtil.BAI_VIET_NHAP))
					status = NewsWorkflowConstants.STATUS_DRAFT;
				if (configName.equals(ConfigUtil.BAI_VIET_CHO_DUYET))
					status = NewsWorkflowConstants.STATUS_PENDING;
				if (configName.equals(ConfigUtil.BAI_VIET_DA_DUYET))
					status = NewsWorkflowConstants.STATUS_APPROVED;
				if (configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN))
					status = NewsWorkflowConstants.STATUS_PUBLISH;
				if (configName.equals(ConfigUtil.BAI_VIET_HUY_DUYET))
					status = NewsWorkflowConstants.STATUS_APPROVE_DENIED;
				if (configName.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN))
					status = NewsWorkflowConstants.STATUS_PUBLISH_DENIED;
				long categoryId = searchObject.getCategoryId();
				boolean inTitle = searchObject.isInTitle();
				String eventNames = HtmlUtil.escape(searchObject.getEventNames());
				String tagNames = HtmlUtil.escape(searchObject.getTagNames());
				boolean inSummary = searchObject.isInSummary();
				boolean inContent = searchObject.isInContent();
				boolean inDate = searchObject.isInDate();
				Date fromDate = null;
				Date toDate = null;
				if (inDate) {
					if (searchObject.getFromDate() > 0) {
						fromDate = new Date(new Timestamp(searchObject.getFromDate()).getTime());
					}
					if (searchObject.getToDate() > 0) {
						toDate = new Date(new Timestamp(searchObject.getToDate()).getTime());
					}
				}

				boolean inAuthor = searchObject.isInAuthor();
				boolean userKiemDuyet = searchObject.isUserKiemDuyet();

				int totalRecord = ArticleLocalServiceUtil.getCountByUserNews(groupId, locale, userId, status,
						categoryId, eventNames, tagNames, q, inTitle, inSummary, inContent, inDate, fromDate,
						toDate, inAuthor, userKiemDuyet);
				List<Article> lstArticles = ArticleLocalServiceUtil.findByUserNews(groupId, locale, userId, status,
						categoryId, eventNames, tagNames, q, inTitle, inSummary, inContent, inDate, fromDate,
						toDate, inAuthor, userKiemDuyet, start, limit + start);

				ObjectMapper mapper = new ObjectMapper();
				ArrayNode arrayNode = mapper.createArrayNode();
				ObjectNode objectNode = mapper.createObjectNode();

				for (Article article : lstArticles) {
					ObjectNode node = mapper.createObjectNode();
					node.put("identity", article.getArticleId());
					if (article.getCreatedByUser() > 0) {
						node.put("userCreateArticle",
								UserLocalServiceUtil.getUser(article.getCreatedByUser()).getScreenName());
					}
					
					node.put("author", HtmlUtil.extractText(article.getAuthor()));
					node.put("source", HtmlUtil.extractText(article.getSource()));
					if (article.getPublishedByUser() > 0) {
						node.put("userPushArticle",
								UserLocalServiceUtil.getUser(article.getPublishedByUser()).getScreenName());
					}
					try {
						if (!article.getImage().isEmpty()) {
							String viewDocument = AttachmentUtil.viewDocument(article.getImage());
							node.put("imageUrl", viewDocument);
						}
					} catch (Exception e) {
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
								DataType.JSON_STR);
					}

					node.put("title", HtmlUtil.extractText(article.getTitle()));
					List<com.software.cms.model.Category> categories = CategoryLocalServiceUtil
							.searchByArticle(article.getArticleId());
					List<String> cateList = new ArrayList<String>();
					for (com.software.cms.model.Category cate : categories) {
						cateList.add(cate.getTitle());
					}
					node.putPOJO("cateList", cateList);
					if (configName.equals(ConfigUtil.BAI_VIET_CHO_DUYET)
							|| configName.equals(ConfigUtil.BAI_VIET_NHAP)) {

						if (article.getCreatedDate() != null) {
							node.put("createdDate", article.getCreatedDate().getTime());
						}

					}

					if (configName.equals(ConfigUtil.BAI_VIET_CHO_DUYET)) {
						if (article.getPendingDate() != null) {
							node.put("pendingDate", article.getPendingDate().getTime());
						}
					}

					if (configName.equals(ConfigUtil.BAI_VIET_DA_DUYET)) {
						if (article.getApprovedDate() != null) {
							node.put("approvedDate", article.getApprovedDate().getTime());
						}
					}
					if (configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)) {
						if (article.getPublishedDateFrom() != null) {
							node.put("pendingDate", article.getPublishedDateFrom().getTime());
						}
					}
					if (configName.equals(ConfigUtil.BAI_VIET_HUY_DUYET)) {
						if (article.getModifiedDate() != null) {
							node.put("modifiedDate", article.getModifiedDate().getTime());
						}
					}
					if (configName.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN)) {
						if (article.getModifiedDate() != null) {
							node.put("modifiedDate", article.getModifiedDate().getTime());
						}
					}
					node.put("viewCount", article.getViewCount());

					// check permission user
					ArrayNode acceptUserPermissison = mapper.createArrayNode();
					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId())) {
						acceptUserPermissison.add("EDIT");
					}
					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId())
							&& configName.equals(ConfigUtil.BAI_VIET_NHAP)) {
						acceptUserPermissison.add("PENDING");
					}
					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId())
							&& (configName.equals(ConfigUtil.BAI_VIET_CHO_DUYET)
									|| configName.equals(ConfigUtil.BAI_VIET_HUY_DUYET))) {
						acceptUserPermissison.add("APPROVED");
					}

					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId())
							&& !configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)) {
						acceptUserPermissison.add("PUBLISH");
					}

					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId())
							&& configName.equals(ConfigUtil.BAI_VIET_DA_DUYET)) {
						acceptUserPermissison.add("DENIEDAPPROVE");
					}
					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId())
							&& configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)) {
						acceptUserPermissison.add("DENIEDPUBLISH");
					}
					if (PermissionUtil.checkPermissionArticle(userId, article.getArticleId()) && PermissionUtil
							.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_REMOVE, groupId)) {
						acceptUserPermissison.add("REMOVE");
					}
					node.putPOJO("UserPermissison", acceptUserPermissison);

					arrayNode.add(node);
				}
				objectNode.put("total", totalRecord);
				objectNode.putPOJO("data", arrayNode);
				objectNode.putPOJO("permissions", PermissionUtil.getPermissionNode(userId, groupId));
				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode,
						DataType.JSON_STR);

			}

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
		return null;
	}

	@GET
	@Path("/get/article/{groupId}/{locale}/{userId}/{articleId}/{configName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetArticle(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("") @PathParam("configName") String configName, @PathParam("userId") long userId,
			@PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);
			configName = HtmlUtil.escape(configName);

			if (groupId < 0 || locale.isEmpty() || articleId < 0 || configName.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			ObjectMapper mapper = new ObjectMapper();
			// check permission user
			ArrayNode acceptUserPermissison = mapper.createArrayNode();
			if (PermissionUtil.checkPermissionArticle(userId, articleId)) {
				acceptUserPermissison.add("EDIT");
			}
			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& configName.equals(ConfigUtil.BAI_VIET_NHAP)) {
				acceptUserPermissison.add("PENDING");
			}
			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& (configName.equals(ConfigUtil.BAI_VIET_CHO_DUYET)
							|| configName.equals(ConfigUtil.BAI_VIET_HUY_DUYET))) {
				acceptUserPermissison.add("APPROVED");
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& !configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)) {
				acceptUserPermissison.add("PUBLISH");
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& configName.equals(ConfigUtil.BAI_VIET_DA_DUYET)) {
				acceptUserPermissison.add("DENIEDAPPROVE");
			}
			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& configName.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)) {
				acceptUserPermissison.add("DENIEDPUBLISH");
			}
			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_REMOVE, groupId)) {
				acceptUserPermissison.add("REMOVE");
			}

			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			JsonNode node = ArticleObject.ArticleNode(article);
			((ObjectNode) node).putPOJO("UserPermissison", acceptUserPermissison);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/approved-article/{groupId}/{locale}/{userId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse ApprovedArticle(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_APPROVED, groupId)) {
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					article.setStatus(NewsWorkflowConstants.STATUS_APPROVED);
					article.setApprovedByUser(userId);
					article.setApprovedDate(new Date());
					article.setModifiedByUser(userId);
					article.setModifiedDate(new Date());
					ArticleLocalServiceUtil.updateArticle(article);

					Logger logger = LoggerLocalServiceUtil.createLogger(0);
					logger.setGroupId(groupId);
					logger.setLanguage(locale);
					logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
					logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED));
					logger.setUserId(userId);
					logger.setCreatedDate(new Date());
					logger.setDescription("ARTICLE_APPROVED" + " : " + article.getTitle());
					LoggerLocalServiceUtil.addLogger(logger);

					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT_PERMISSION", DataType.JSON_STR);
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/publish-article/{groupId}/{locale}/{userId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse PublishArticle(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_PUBLISH, groupId)) {
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					if (article.getStatus() != NewsWorkflowConstants.STATUS_PUBLISH_DENIED) {
						if (article.getStatus() == NewsWorkflowConstants.STATUS_APPROVED
								|| article.getStatus() == NewsWorkflowConstants.STATUS_PENDING) {
							article.setApprovedByUser(userId);
							article.setApprovedDate(new Date());
						}
						article.setPublishedByUser(userId);
						article.setPublishedDateFrom(new Date());
						article.setNeverExpire(true);
						article.setModifiedByUser(userId);
						article.setModifiedDate(new Date());
					}
					article.setStatus(NewsWorkflowConstants.STATUS_PUBLISH);

					ArticleLocalServiceUtil.updateArticle(article);
					Logger logger = LoggerLocalServiceUtil.createLogger(0);
					logger.setGroupId(groupId);
					logger.setLanguage(locale);
					logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
					logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED));
					logger.setUserId(userId);
					logger.setCreatedDate(new Date());
					logger.setDescription("ARTICLE_APPROVED" + " : " + article.getTitle());
					LoggerLocalServiceUtil.addLogger(logger);

					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT_PERMISSION", DataType.JSON_STR);
			}

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/denied-approve-article/{groupId}/{locale}/{userId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeniedApproveArticle(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId) && PermissionUtil
					.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_APPROVED_RETURN, groupId)) {
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					article.setStatus(NewsWorkflowConstants.STATUS_APPROVE_DENIED);
					article.setModifiedByUser(userId);
					article.setModifiedDate(new Date());
					ArticleLocalServiceUtil.updateArticle(article);
					Logger logger = LoggerLocalServiceUtil.createLogger(0);
					logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
					logger.setGroupId(groupId);
					logger.setLanguage(locale);
					logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED_RETURN));
					logger.setUserId(userId);
					logger.setCreatedDate(new Date());
					logger.setDescription("ARTICLE_APPROVED_RETURN" + " :" + article.getTitle());
					LoggerLocalServiceUtil.addLogger(logger);

					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT_PERMISSION", DataType.JSON_STR);
			}

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/denied-publish-article/{groupId}/{locale}/{userId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeniedPublishArticle(@PathParam("groupId") long groupId,
			@DefaultValue("") @QueryParam("content") String content, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId) && PermissionUtil
					.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_PUBLISH_RETURN, groupId)) {
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					article.setStatus(NewsWorkflowConstants.STATUS_PUBLISH_DENIED);
					article.setModifiedByUser(userId);
					article.setModifiedDate(new Date());
					ArticleLocalServiceUtil.updateArticle(article);
					// Add message
					if (!"".equals(content)) {
						ArticleMessage message = ArticleMessageLocalServiceUtil.createArticleMessage(
								CounterLocalServiceUtil.increment(ArticleMessage.class.getName()));
						message.setArticleId(articleId);
						message.setCreatedByUser(userId);
						message.setCreatedDate(new Date());
						message.setContent(content);
						ArticleMessageLocalServiceUtil.updateArticleMessage(message);
					}
					// Add logger
					Logger logger = LoggerLocalServiceUtil.createLogger(0);
					logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
					logger.setType(String.valueOf(RoleConstants.ARTICLE_PUBLISH_RETURN));
					logger.setGroupId(groupId);
					logger.setLanguage(locale);
					logger.setUserId(userId);
					logger.setCreatedDate(new Date());
					logger.setDescription("ARTICLE_PUBLISH_RETURN" + " :" + article.getTitle());
					LoggerLocalServiceUtil.addLogger(logger);

					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT_PERMISSION", DataType.JSON_STR);
			}

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/pending-article/{groupId}/{locale}/{userId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse PendingArticle(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("") @QueryParam("content") String content, @PathParam("userId") long userId,
			@PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_PENDING, groupId)) {
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					article.setStatus(NewsWorkflowConstants.STATUS_PENDING);
					article.setPendingDate(new Date());
					article.setModifiedByUser(userId);
					article.setModifiedDate(new Date());
					ArticleLocalServiceUtil.updateArticle(article);
					// Add message

					if (!"".equals(content)) {
						ArticleMessage message = ArticleMessageLocalServiceUtil.createArticleMessage(
								CounterLocalServiceUtil.increment(ArticleMessage.class.getName()));
						message.setArticleId(articleId);
						message.setCreatedByUser(userId);
						message.setCreatedDate(new Date());
						message.setContent(content);
						ArticleMessageLocalServiceUtil.updateArticleMessage(message);
					}
					// Add logger
					Logger logger = LoggerLocalServiceUtil.createLogger(0);
					logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
					logger.setGroupId(groupId);
					logger.setLanguage(locale);
					logger.setType(String.valueOf(RoleConstants.ARTICLE_PENDING));
					logger.setUserId(userId);
					logger.setCreatedDate(new Date());
					logger.setDescription("ARTICLE_PENDING" + " : " + article.getTitle());
					LoggerLocalServiceUtil.addLogger(logger);

					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT_PERMISSION", DataType.JSON_STR);
			}

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/article/{groupId}/{locale}/{userId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteArticle(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("articleId") long articleId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (groupId < 0 || locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			if (PermissionUtil.checkPermissionArticle(userId, articleId)
					&& PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_REMOVE, groupId)) {
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					String imageId = article.getImage().trim();
					if (!imageId.equals("") && !imageId.equals("0")) {
						try {
							DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.parseLong(imageId));
						} catch (Exception e1) {
						}
					}

					ArticleLocalServiceUtil.deleteArticle(articleId);
					CategoryArticleLocalServiceUtil.removeByArticle(articleId);
					List<Comment> comm = CommentLocalServiceUtil.searchComment(articleId);
					for (int i = 0; i < comm.size(); i++) {
						CommentLocalServiceUtil.deleteComment(comm.get(i));
					}

					Logger logger = LoggerLocalServiceUtil.createLogger(0);
					logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
					logger.setType(String.valueOf(RoleConstants.ARTICLE_REMOVE));
					logger.setUserId(userId);
					logger.setCreatedDate(new Date());
					logger.setDescription("ARTICLE_REMOVE" + " : " + article.getTitle());
					LoggerLocalServiceUtil.addLogger(logger);

					return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
				} catch (Exception e) {
					return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
							DataType.JSON_STR);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT_PERMISSION", DataType.JSON_STR);
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/image/{articleId}/{imageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse DeleteImage(@PathParam("articleId") long articleId, @PathParam("imageId") long imageId) {
		try {

			if (articleId < 0 || imageId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			Article article = ArticleLocalServiceUtil.getArticleByImageId(articleId, imageId);
			if (article != null) {
				if (articleId == article.getArticleId()) {
					article.setImage("");
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(imageId);
					ArticleLocalServiceUtil.updateArticle(article);
				}
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "NOT FOUND articleId OR imageId",
						DataType.JSON_STR);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get/article-involve-source/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse ArticleInvolve(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("") @QueryParam("title") String title,
			@DefaultValue("") @QueryParam("involve") String involve,
			@DefaultValue("") @QueryParam("source") String source, @DefaultValue("0") @QueryParam("start") int start) {
		try {
			locale = HtmlUtil.escape(locale);
			source = HtmlUtil.escape(source);
			title = HtmlUtil.escape(title);
			involve = HtmlUtil.escape(involve);

			if (groupId < 0 || locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			// involve
			List<Long> arrInvolve = new ArrayList<>();
			if (!involve.isEmpty()) {
				for (String invo : involve.split(",")) {
					arrInvolve.add(Long.parseLong(invo));
				}
				involve = StringUtils.join(arrInvolve, ",");
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectResponse = mapper.createObjectNode();

			List<Article> filteredEntries = ArticleLocalServiceUtil.getArticleInvolve(groupId, locale,
					NewsWorkflowConstants.STATUS_PUBLISH, title, start, limit, involve);
			ArrayNode arrayNode = mapper.createArrayNode();
			for (Article entries : filteredEntries) {
				String idinvolve = Long.toString(entries.getArticleId());
				String nameinvolve = entries.getTitle();
				ObjectNode objectNode = mapper.createObjectNode();
				objectNode.put("key", idinvolve);
				objectNode.put("name", HtmlUtil.extractText(nameinvolve));
				arrayNode.add(objectNode);
			}
			objectResponse.putPOJO("involve", arrayNode);
			// source
			ArrayNode arrayNodeSouce = mapper.createArrayNode();
			List<Object[]> lst = ArticleLocalServiceUtil.getArticleSource(source, limit);
			for (Object[] objects : lst) {
				String id = String.valueOf(objects[0]);
				String ten = String.valueOf(objects[1]);
				ObjectNode objectNode = mapper.createObjectNode();
				objectNode.put("key", id);
				objectNode.put("name", HtmlUtil.extractText(ten));
				arrayNodeSouce.add(objectNode);
			}
			objectResponse.putPOJO("source", arrayNodeSouce);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectResponse,
					DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/update/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse CreateUpdate(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@DefaultValue("-1") @QueryParam("articleId") long articleId, @PathParam("userId") long userId,
			@Context HttpServletRequest request) {
		try {
			locale = HtmlUtil.escape(locale);

			UploadServletRequest upload = PortalUtil.getUploadServletRequest(request);
			File imageFile = upload.getFile("images");

			String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
			String summary = HtmlUtil.escape(ParamUtil.getString(request, "summary", ""));
			String content = HtmlUtil.escape(ParamUtil.getString(request, "content", ""));
			String imagesDescription = HtmlUtil.escape(ParamUtil.getString(request, "imageDes"));
			String author = HtmlUtil.escape(ParamUtil.getString(request, "author", ""));
			String source = HtmlUtil.escape(ParamUtil.getString(request, "source", ""));
			/*-------*/
			String categoriesStr = ParamUtil.getString(request, "category", "");
			String siteStr = ParamUtil.getString(request, "site", "");
			String involveArtStr = ParamUtil.getString(request, "involve", "");
			/*-------*/
			boolean isAllowComment = ParamUtil.getBoolean(request, "isComment", false);
			boolean isNoiBat = ParamUtil.getBoolean(request, "isNoiBat", false);
			boolean isHomePage = ParamUtil.getBoolean(request, "homePage", false);
			long isOrderShowHomePage = ParamUtil.getLong(request, "orderShowHomePage", 0);

			/*****/
			long action = ParamUtil.getLong(request, "action", -1);

			/*-------*/
			ObjectMapper objectMapper = new ObjectMapper();
			/*****/
			Category[] categories = null;
			if (!categoriesStr.isEmpty())
				categories = objectMapper.readValue(categoriesStr, ArticleObject.Category[].class);
			ArticlePage[] articlePages = null;
			if (!siteStr.isEmpty())
				articlePages = objectMapper.readValue(siteStr, ArticleObject.ArticlePage[].class);
			ArticleInvolve[] articleInvolves = null;
			if (!involveArtStr.isEmpty())
				articleInvolves = objectMapper.readValue(involveArtStr, ArticleObject.ArticleInvolve[].class);
			/*****/
			if (articleId <= 0 && !PermissionUtil.checkPermissionAccessZone(userId, RoleConstants.ARTICLE_ADD, groupId)) {
				return DataResponse.NOT_ACCESS;
			}
			
			if (imageFile != null && imageFile.getName().length() > 0
					&& ArticleCheck.checkImageName(imageFile.getName().toLowerCase())) {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED,
						"IMAGE ARTICLE IS ACCESS PNG,JPG,JPEG", DataType.JSON_STR);
			}

			if (groupId < 0 || locale.isEmpty() || title.isEmpty() || summary.isEmpty() || content.isEmpty()
					|| categories == null || categories.length == 0) {
				return DataResponse.PARAM_ERROR;
			}
			
			/***************/
			Article article = null;
			if (articleId <= 0) {
				article = ArticleLocalServiceUtil.createArticle(0);
				articleId = CounterLocalServiceUtil.increment(Article.class.getName());
				article.setArticleId(articleId);
				article.setStatus(NewsWorkflowConstants.STATUS_NOT_CREATE);
				article.setCreatedByUser(userId);
				article.setCreatedDate(new Date());
				article = ArticleLocalServiceUtil.addArticle(article);
			} else {
				article = ArticleLocalServiceUtil.getArticle(articleId);
			}
			/***************/
			List<String> lstUser = new ArrayList<>();
			List<String> lstUserName = new ArrayList<>();
			String humanAccessArticle = ParamUtil.getString(request, "humanAccessArticle", "");
			cms.article.object.ArticleObject.User[] users = null;
			if (!humanAccessArticle.isEmpty())
				users = objectMapper.readValue(humanAccessArticle, ArticleObject.User[].class);
			if (users != null) {
				for (cms.article.object.ArticleObject.User user : users) {
					if (user.getId() > 0) {
						User oldUser = UserLocalServiceUtil.getUser(user.getId());
						lstUser.add(String.valueOf(oldUser.getUserId()));
						lstUserName.add(oldUser.getScreenName());
					}
				}
			}
			
			String usersId = String.join(",", lstUser);
			String usersName = String.join("~~", lstUserName);
			article.setHumanAccessIds(usersId);
			article.setHumanAccess(usersName);
			
			/***************/
			if (imageFile != null && imageFile.getName().length() > 0) {
				if (article.getImage() != null && !article.getImage().isEmpty()) {
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.parseLong(article.getImage()));
				}
				String titleimages = upload.getFileName("images");
				long imageId = AttachmentUtil.uploadFile(upload, article, imageFile, titleimages, groupId, userId);
				article.setImage(String.valueOf(imageId));
			}
			/***************/
			article.setTitle(title);
			article.setUuid(PortalUUIDUtil.generate());
			article.setSummary(summary);
			article.setContent(content);
			article.setImageTitle(imagesDescription);
			article.setAuthor(author);
			article.setSource(source);
			article.setAllowComent(isAllowComment);
			article.setIsNoiBat(isNoiBat);
			article.setIsHomePage(isHomePage);
			article.setThuTu(isOrderShowHomePage);
			/***************/

			String tagStr = ParamUtil.getString(request, "tags", "");
			cms.article.object.ArticleObject.Tag[] tagObj = null;
			if (!tagStr.isEmpty())
				tagObj = objectMapper.readValue(tagStr, ArticleObject.Tag[].class);

			List<String> lstTag = new ArrayList<>();
			List<String> lstTagName = new ArrayList<>();
			if (tagObj != null)
				for (cms.article.object.ArticleObject.Tag tagItem : tagObj) {
					if (tagItem.getId() <= 0) {
						Tag tag = TagLocalServiceUtil.createTag(CounterLocalServiceUtil.increment(Tag.class.getName()));
						tag.setTagName(HtmlUtil.escape(tagItem.getName().trim()));
						tag.setLanguage(locale);
						tag.setGroupId(groupId);
						tag = TagLocalServiceUtil.updateTag(tag);
						lstTag.add(String.valueOf(tag.getTagId()));
						lstTagName.add(tag.getTagName());
					} else if (tagItem.getId() > 0) {
						Tag tag = TagLocalServiceUtil.getTag(tagItem.getId());
						lstTag.add(String.valueOf(tag.getTagId()));
						lstTagName.add(tag.getTagName());
					}
				}

			/***************/
			String eventStr = ParamUtil.getString(request, "events", "");
			cms.article.object.ArticleObject.Event[] eventObj = null;
			if (!eventStr.isEmpty())
				eventObj = objectMapper.readValue(eventStr, ArticleObject.Event[].class);

			List<String> lstEvent = new ArrayList<>();
			List<String> lstEventName = new ArrayList<>();
			if (eventObj != null)
				for (cms.article.object.ArticleObject.Event eventItem : eventObj) {
					if (eventItem.getId() <= 0) {
						Event event = EventLocalServiceUtil
								.createEvent(CounterLocalServiceUtil.increment(Event.class.getName()));
						event.setEventName(HtmlUtil.escape(eventItem.getName().trim()));
						event.setLanguage(locale);
						event.setGroupId(groupId);
						event = EventLocalServiceUtil.updateEvent(event);
						lstEvent.add(String.valueOf(event.getEventId()));
						lstEventName.add(event.getEventName());
					} else if (eventItem.getId() > 0) {
						Event event = EventLocalServiceUtil.getEvent(eventItem.getId());
						lstEvent.add(String.valueOf(event.getEventId()));
						lstEventName.add(event.getEventName());
					}
				}

			/****************/
			List<String> lstInvArt = new ArrayList<>();
			if (articleInvolves != null) {
				for (ArticleInvolve articleInvolve : articleInvolves) {
					try {
						Article articleEx = ArticleLocalServiceUtil.getArticle(articleInvolve.getId());
						lstInvArt.add(String.valueOf(articleInvolve.getId()));
					} catch (Exception e) {
						ArticleLocalServiceUtil.deleteArticle(article);
						return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
								DataType.JSON_STR);
					}
				}
			}
			String invArt = String.join(",", lstInvArt);
			article.setInvolveArt(invArt);

			boolean henGio = ParamUtil.getBoolean(request, "henGio", false);
			String thoiGianHenGio = ParamUtil.getString(request, "thoiGianHenGio", "");

			article.setIsTimer(henGio);
			if (henGio) {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date datethoiGianHenGio = df.parse(thoiGianHenGio);
				if (datethoiGianHenGio != null) {
					article.setPublishedDateFrom(datethoiGianHenGio);
				}
			}
			/*****************/

			article.setGroupId(groupId);
			article.setLanguage(locale);
			article.setFriendlyURL(FriendlyURLNormalizerUtil.normalize(article.getTitle()).replaceAll("<br>", "-")
					.replaceAll("\"", "-") + "-" + article.getArticleId());

			CategoryArticleLocalServiceUtil.removeByArticle(article.getArticleId());

			if (categories != null) {
				for (Category category : categories) {
					CategoryArticleLocalServiceUtil.addCategoryArticle(article.getArticleId(), category.getId(),
							groupId);
//				CategoryArticleLocalServiceUtil.addCategoryArticle(
//						article.getArticleId(), category.getId());
				}
			}

			/*****************/
			Logger logger = LoggerLocalServiceUtil.createLogger(0);
			if (action == RoleConstants.ARTICLE_ADD) {
				if (article.getStatus() <= 0 || article.getStatus() == NewsWorkflowConstants.STATUS_DRAFT) {
					article.setStatus(NewsWorkflowConstants.STATUS_DRAFT);
					logger.setType(String.valueOf(RoleConstants.ARTICLE_ADD));
				}
			} else if (action == RoleConstants.ARTICLE_PENDING) {
				article.setPendingDate(new Date());
				article.setStatus(NewsWorkflowConstants.STATUS_PENDING);
				logger.setType(String.valueOf(RoleConstants.ARTICLE_PENDING));
			} else if (action == RoleConstants.ARTICLE_APPROVED) {
				article.setStatus(NewsWorkflowConstants.STATUS_APPROVED);
				article.setApprovedByUser(userId);
				article.setApprovedDate(new Date());
				logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED));
			} else if (action == RoleConstants.ARTICLE_PUBLISH) {
				if (article.getStatus() != NewsWorkflowConstants.STATUS_PUBLISH_DENIED) {
					if (article.getStatus() == NewsWorkflowConstants.STATUS_NOT_CREATE
							|| article.getStatus() == NewsWorkflowConstants.STATUS_APPROVED
							|| article.getStatus() == NewsWorkflowConstants.STATUS_PENDING) {
					    // Vào thì xuất bản ko theo quy trình.
						if (articleId <= 0) {
							article.setCreatedByUser(userId);
							article.setCreatedDate(new Date());
						}
						article.setPendingDate(new Date());
						article.setApprovedByUser(userId);
						article.setApprovedDate(new Date());
						article.setPublishedDateFrom(new Date());
						// kết thúc.
					}

					article.setNeverExpire(ParamUtil.getBoolean(request, "never-expire", false));
					if (!article.getNeverExpire()) {
						String strDateFrom = HtmlUtil.escape(ParamUtil.getString(request, "date_from", ""));
						String strDateTo = HtmlUtil.escape(ParamUtil.getString(request, "date_to", ""));
						try {
							if (!strDateFrom.equals("") && !strDateTo.equals("")) {
								DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
								Date fromDate = new Date();
								try {
									fromDate = df.parse(strDateFrom);
									article.setPublishedDateFrom(fromDate);
								} catch (Exception e) {
									article.setPublishedDateFrom(new Date());
								}
								Date toDate = df.parse(strDateTo);
								article.setPublishedDateTo(toDate);
								int sub_date = toDate.compareTo(fromDate);

								if (sub_date <= 0) {
									if (articleId <= 0)
										article.setArticleId(0);
									// TODO:return data

								}
							}
						} catch (Exception e) {
							return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(),
									DataType.JSON_STR);
						}
					} else {
						article.setPublishedDateFrom(new Date());
					}
				}

				article.setPublishedByUser(userId);
				article.setStatus(NewsWorkflowConstants.STATUS_PUBLISH);
				logger.setType(String.valueOf(RoleConstants.ARTICLE_PUBLISH));
			}

			if (action == NewsWorkflowConstants.STATUS_SAVE_ART) {
				if (article.getStatus() <= 0 || article.getStatus() == NewsWorkflowConstants.STATUS_DRAFT) {
					logger.setType(String.valueOf(NewsWorkflowConstants.STATUS_SAVE_ART));
				}
			}

			/***************/
			String eventId = String.join(",", lstEvent);
			String eventName = String.join("~~", lstEventName);
			String tagId = String.join(",", lstTag);
			String tagName = String.join("~~", lstTagName);

			/***************/
			article.setModifiedByUser(userId);
			article.setModifiedDate(new Date());
			article.setTags(tagName);
			article.setTagIds(tagId);
			article.setEvents(eventName);
			article.setEventIds(eventId);
			article = ArticleLocalServiceUtil.updateArticle(article);
			logger.setGroupId(groupId);
			logger.setLanguage(locale);
			logger.setUserId(userId);
			logger.setCreatedDate(new Date());
			logger.setDescription("");
			LoggerLocalServiceUtil.addLogger(logger);

			/***************/
			ArticleHistory history = ArticleHistoryLocalServiceUtil.createArticleHistory(0);
			history.setArticleId(article.getArticleId());
			history.setTitle(article.getTitle());
			history.setUuid(PortalUUIDUtil.generate());
			history.setSummnary(article.getSummary());
			history.setContent(article.getContent());
			history.setAuthor(article.getAuthor());
			history.setSource(article.getSource());
			history.setImage(article.getImage());
			history.setImageDescription(article.getImageTitle());
			history.setUserId(userId);
			history.setCreatedDate(new Date());
			ArticleHistoryLocalServiceUtil.addArticleHistory(history);
			long articleMainId = article.getArticleId();

			if (articlePages != null)
				for (ArticlePage page : articlePages) {
					Article articleSite = null;
					try {
						articleSite = ArticleLocalServiceUtil.getArticleTheoSQL(page.getId(), articleMainId).get(0);
						ArticleLocalServiceUtil.deleteArticle(articleSite);
						articleSite = null;
					} catch (Exception e) {
						articleSite = null;
					}
					if (page.isChecked()) {
						if (Validator.isNull(articleSite)) {
							Group group = GroupLocalServiceUtil.getGroup(page.getId());
							Locale defaultLocale = PortalUtil.getSiteDefaultLocale(group.getGroupId());
							articleSite = ArticleLocalServiceUtil.createArticle(0);
							long artSiteId = CounterLocalServiceUtil.increment(Article.class.getName());
							artSiteId = 1 + Long.valueOf(ArticleLocalServiceUtil.getMaxId());
							articleSite = ArticleLocalServiceUtil.getArticle(articleMainId);
							articleSite.setArticleId(artSiteId);
							articleSite.setGroupId(page.getId());
							articleSite.setUuid(PortalUUIDUtil.generate());
							articleSite.setStatus(NewsWorkflowConstants.STATUS_PENDING);
							articleSite.setLanguage(defaultLocale.toLanguageTag().replace("-", "_"));
							articleSite.setCreatedByUser(userId);
							articleSite.setCreatedDate(new Date());
							articleSite.setApprovedDate(null);
							articleSite.setApprovedByUser(0);
							articleSite.setPublishedDateFrom(null);
							articleSite.setPublishedByUser(0);
							articleSite.setArticleMainId(articleMainId);
							articleSite.setIsSubSite(page.isChecked());
							articleSite = ArticleLocalServiceUtil.addArticle(articleSite);

						}
					}
				}
			// response field
			JsonNode articleNode = ArticleObject.ArticleNode(article);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, articleNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	//search user API
	@GET
	@Path("/get/user/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse searchUser(@PathParam("groupId") long groupId, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("") @QueryParam("q") String q) {
		try {
			q = HtmlUtil.escape(q);
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode userArr = mapper.createArrayNode();
			List<User> usersList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		    for (User user : usersList) {
		    	if (user.getScreenName().toLowerCase().contains(q.toLowerCase())) {
		    		ObjectNode userNode = mapper.createObjectNode();
		    		userNode.put("id", user.getUserId());
		    		userNode.put("name", user.getScreenName());
		    		userArr.add(userNode);
		    	}
		    }
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, userArr, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/comment/approve/{groupId}/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse CommentApproved(@PathParam("groupId") long groupId, @PathParam("commentId") long commentId) {
		try {
			if (commentId < 0 || groupId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			Comment comment = CommentLocalServiceUtil.getComment(commentId);
			comment.setApproved(true);
			CommentLocalServiceUtil.updateComment(comment);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/comment/delete/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public DataResponse CommentDelete(@PathParam("commentId") long commentId) {
		try {
			if (commentId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			CommentLocalServiceUtil.deleteComment(commentId);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
