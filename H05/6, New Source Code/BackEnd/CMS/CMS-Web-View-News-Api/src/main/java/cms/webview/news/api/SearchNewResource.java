package cms.webview.news.api;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Article;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.Event;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.EventLocalServiceUtil;
import com.software.cms.service.persistence.CategoryArticlePK;
import com.software.util.DataResponse;
import com.software.util.NewsWorkflowConstants;
import com.software.util.ResponseCode;
import com.software.util.DataResponse.DataType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cms.webview.news.object.SearchObject;
import cms.webview.utils.ArticleObject;

@Path("/search-new")
public class SearchNewResource {
	private JsonNodeFactory factory = JsonNodeFactory.instance;
	//private ObjectMapper mapper = new ObjectMapper();

	@POST
	@Path("/get-all/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetList(@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("10") @QueryParam("limit") int limit,
			@PathParam("locale") String locale, @PathParam("groupId") long groupId, SearchObject searchObject) {

		try {
			locale = HtmlUtil.escape(locale);
			String keyword = HtmlUtil.escape(searchObject.getKeyword()).trim();

			if (locale.isEmpty() || start < 0 || limit < 0) {
				return DataResponse.PARAM_ERROR;
			}

			ObjectNode objectNode = factory.objectNode();
			List<Article> result = new ArrayList<Article>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate = "";
			if (searchObject.getFromDate() != null) {
				fromDate = dateFormat.format(searchObject.getFromDate());
			}
			
			String toDate = "";
			if (searchObject.getToDate() != null) {
				toDate = dateFormat.format(searchObject.getToDate());
			}

			result = ArticleLocalServiceUtil.searchNewArticle(groupId, NewsWorkflowConstants.STATUS_PUBLISH, keyword, 
					fromDate, toDate);

			List<Article> filterResult = new ArrayList<Article>();
			for (Article article : result) {
				boolean isAdd = true;
				
				//check for match event
				boolean isEventId = false;
				String[] eventIds = article.getEventIds().split(",");
				if (searchObject.getEventId() == 0) {
					isEventId = true;
				} else {
					for (int i = 0; i < eventIds.length; i++) {
						if (!eventIds[i].isEmpty()) {
							if (Long.parseLong(eventIds[i]) == searchObject.getEventId()) {
								isEventId = true;
							}
						}
					}
				}

				isAdd = isEventId;
				
				//check for match tag
				for (int i = 0; i < searchObject.getTags().length; i++) {
					String tag = HtmlUtil.escape(searchObject.getTags()[i]);
					if (!article.getTags().contains(tag)) {
						isAdd = false;
					}
				}
			    
				//check for match category
				for (int i = 0; i < searchObject.getCategoryIds().length; i++) {
					if (searchObject.getCategoryIds()[i] > 0) {
						CategoryArticle ca = CategoryArticleLocalServiceUtil.fetchCategoryArticle(new CategoryArticlePK(article.getArticleId(), searchObject.getCategoryIds()[i]));
						if (ca == null) {
							isAdd = false;
						}
					}
				}
				
				if (isAdd) {
					filterResult.add(article);
				}
			}

			
			ArrayNode arrNode = factory.arrayNode();
			int end = start + limit;
			if (end > filterResult.size()) {
				end = filterResult.size();
			}
			
			List<Article> cutList = filterResult.subList(start, end);
			for (Article article : cutList) {
				arrNode.addPOJO(ArticleObject.ArticleNode(article));
			}
			objectNode.putPOJO("data", arrNode);
			objectNode.put("total", filterResult.size());

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, objectNode, DataType.JSON_STR);
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	
	@GET
	@Path("/get-event/{locale}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getList(@PathParam("locale") String locale) {
		try {
			locale = HtmlUtil.escape(locale);

			if (locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			List<Event> listEvent = EventLocalServiceUtil.getEventByLanguage(locale);
			ArrayNode entries = JsonNodeFactory.instance.arrayNode();

			ObjectNode resEntry = null;
			for (Event eve : listEvent) {
				resEntry = JsonNodeFactory.instance.objectNode();
				resEntry.put("id", eve.getEventId());
				resEntry.put("name", eve.getEventName());
				resEntry.put("description", eve.getDescription());
				entries.add(resEntry);
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, entries, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
