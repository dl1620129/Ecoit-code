package cms.article.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Article;
import com.software.cms.model.ArticleHistory;
import com.software.cms.model.Logger;
import com.software.cms.service.ArticleHistoryLocalServiceUtil;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.LoggerLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.software.util.DataResponse.DataType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cms.article.util.AttachmentUtil;

@Path("/history")
public class ArticleHistoryResource {
	private static ArticleHistoryResource instance = null;

	public static ArticleHistoryResource getInstance() {
		if (instance == null) {
			instance = new ArticleHistoryResource();
		}
		return instance;
	}

	@GET
	@Path("/getall/{locale}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetAll(@PathParam("locale") String locale, @PathParam("articleId") long articleId,
			@DefaultValue("10") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("start") int start) {
		try {
			locale = HtmlUtil.escape(locale);

			if (locale.isEmpty() || articleId < 0) {
				return DataResponse.PARAM_ERROR;
			}

			long idart = 0;
			try {
				Article articleHistory = null;
				if (articleId > 0)
					articleHistory = ArticleLocalServiceUtil.getArticle(articleId);
				else
					articleHistory = ArticleLocalServiceUtil.create();
				idart = articleHistory.getArticleId();
			} catch (Exception ex) {
			}

			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arrayNode = mapper.createArrayNode();
			ObjectNode objectNode = mapper.createObjectNode();

			List<ArticleHistory> listArticleHistory = ArticleHistoryLocalServiceUtil.getHistoryFromArticle(idart, start,
					start + limit);
			int total = ArticleHistoryLocalServiceUtil.countByArticle(idart);
			for (ArticleHistory articleHistory : listArticleHistory) {
				ObjectNode node = mapper.createObjectNode();

				String fullName = UserLocalServiceUtil.getUser(articleHistory.getUserId()).getFullName();
				String date = DateUtil.getDate(articleHistory.getCreatedDate(), "E dd / MMMMM / yyyy hh:mm aaa",
						Locale.forLanguageTag(locale));

				node.put("fullName", fullName);
				node.put("date", date);
				node.put("articleHistoryId", articleHistory.getArticleHistoryId());

				arrayNode.addPOJO(node);

			}

			objectNode.put("total", total);
			objectNode.putPOJO("data", arrayNode);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/get-detail/{groupId}/{locale}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetDetail(@PathParam("locale") String locale, @PathParam("userId") long userId,
			@PathParam("groupId") long groupId, @DefaultValue("") @QueryParam("action") String action,
			@DefaultValue("-1") @QueryParam("articleId") long articleId,
			@DefaultValue("-1") @QueryParam("historyId") long historyId,
			@QueryParam("articleHistoryId") long articleHistoryId) {
		try {
			locale = HtmlUtil.escape(locale);
			if (locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			ObjectMapper mapper = new ObjectMapper();
			if (action.isEmpty()) {
				if (articleHistoryId < 0) {
					return DataResponse.PARAM_ERROR;
				}

				ObjectNode objectNode = mapper.createObjectNode();
				ObjectNode objNodeHistory = mapper.createObjectNode();
				ObjectNode objNodeCurrent = mapper.createObjectNode();

				ArticleHistory articleHistory = ArticleHistoryLocalServiceUtil.getArticleHistory(articleHistoryId);
				long articleHId = articleHistory.getArticleId();
				Article article = ArticleLocalServiceUtil.getArticle(articleHId);

				objNodeHistory.put("user", UserLocalServiceUtil.getUser(articleHistory.getUserId()).getFullName());
				objNodeCurrent.put("user", UserLocalServiceUtil.getUser(article.getModifiedByUser()).getFullName());

				objNodeHistory.put("date", DateUtil.getDate(articleHistory.getCreatedDate(),
						"E dd / MMMMM / yyyy hh:mm aaa", Locale.forLanguageTag(locale)));
				objNodeCurrent.put("date", DateUtil.getDate(article.getModifiedDate(), "E dd / MMMMM / yyyy hh:mm aaa",
						Locale.forLanguageTag(locale)));

				objNodeHistory.put("title", articleHistory.getTitle());
				objNodeCurrent.put("title", article.getTitle());

				objNodeHistory.put("summary", articleHistory.getSummnary());
				objNodeCurrent.put("summary", article.getSummary());

				objNodeHistory.put("author", articleHistory.getAuthor());
				objNodeCurrent.put("author", article.getAuthor());

				objNodeHistory.put("source", articleHistory.getSource());
				objNodeCurrent.put("source", article.getSource());

				objNodeHistory.put("imageDes", articleHistory.getImageDescription());
				objNodeCurrent.put("imageDes", article.getImageTitle());

				if (!articleHistory.getImage().isEmpty() && Long.parseLong(articleHistory.getImage()) > 0)
					objNodeHistory.put("image", AttachmentUtil.viewDocument(articleHistory.getImage()));
				if (!article.getImage().isEmpty() && Long.parseLong(article.getImage()) > 0)
					objNodeCurrent.put("image", AttachmentUtil.viewDocument(article.getImage()));

				objNodeHistory.put("content", HtmlUtil.extractText(articleHistory.getContent()));
				objNodeCurrent.put("content", HtmlUtil.extractText(article.getContent()));

				objectNode.putPOJO("history", objNodeHistory);
				objectNode.putPOJO("current", objNodeCurrent);

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode,
						DataType.JSON_STR);
			} else if (action.equals("revive")) {
				if (articleId < 0 || historyId < 0) {
					return DataResponse.PARAM_ERROR;
				}

				Article acur = ArticleLocalServiceUtil.getArticle(articleId);
				ArticleHistory ahis = ArticleHistoryLocalServiceUtil.getArticleHistory(historyId);
				acur.setTitle(ahis.getTitle());
				acur.setSummary(ahis.getSummnary());
				acur.setContent(ahis.getContent());
				acur.setImage(ahis.getImage());
				acur.setImageTitle(ahis.getImageDescription());
				acur.setAuthor(ahis.getAuthor());
				acur.setSource(ahis.getSource());
				Date date = new Date();
				acur.setModifiedDate(date);
				acur.setModifiedByUser(userId);
				ArticleLocalServiceUtil.updateArticle(acur);
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				addLogger(userId, groupId, locale, ahis, logger, "revive");

				return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, ahis.getModelAttributes(),
						DataType.JSON_STR);
			} else {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "ACTION FAIL", DataType.JSON_STR);
			}
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@DELETE
	@Path("/delete/{groupId}/{locale}/{userId}/{articleHistoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse Delete(@PathParam("groupId") long groupId, @PathParam("locale") String locale,
			@PathParam("userId") long userId, @PathParam("articleHistoryId") long articleHistoryId) {
		try {
			locale = HtmlUtil.escape(locale);

			if (locale.isEmpty() || articleHistoryId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			Logger logger = LoggerLocalServiceUtil.createLogger(0);
			ArticleHistory articleHistory = ArticleHistoryLocalServiceUtil.getArticleHistory(articleHistoryId);
			ArticleHistoryLocalServiceUtil.deleteArticleHistory(articleHistoryId);
			addLogger(userId, groupId, locale, articleHistory, logger, "delete");

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, "", DataType.JSON_STR);

		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	public void addLogger(long userId, long groupId, String locale, ArticleHistory articleHistory, Logger logger,
			String action) throws Exception {
		logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
		logger.setUserId(userId);
		logger.setLanguage(locale);
		logger.setGroupId(groupId);
		logger.setCreatedDate(new Date());
		logger.setType(String.valueOf(RoleConstants.EDIT_HISTORY));
		if (action.equals("revive"))
			logger.setDescription("ArticleHistory.logger.revive" + articleHistory.getTitle());
		if (action.equals("delete"))
			logger.setDescription("ArticleHistory.logger.delete" + articleHistory.getTitle());
		LoggerLocalServiceUtil.addLogger(logger);
	}

}
