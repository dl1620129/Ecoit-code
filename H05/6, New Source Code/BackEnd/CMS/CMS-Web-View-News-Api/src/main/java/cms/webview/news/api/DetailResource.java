package cms.webview.news.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Article;
import com.software.cms.model.Comment;
import com.software.cms.model.Logger;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;
import com.software.cms.service.LoggerLocalServiceUtil;
import com.software.util.CMSPortalUtil;
import com.software.util.DataResponse;
import com.software.util.ResponseCode;
import com.software.util.RoleConstants;
import com.software.util.DataResponse.DataType;
import com.software.util.NewsWorkflowConstants;
import com.software.util.PermissionUtil;

import cms.webview.utils.CommentObject;
import cms.webview.utils.TreeCategory;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cms.webview.utils.ArticleObject;

@Path("/detail")
public class DetailResource {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetDetail(@DefaultValue("-1") @QueryParam("categoryId") long categoryId,
			@DefaultValue("") @QueryParam("urlTitle") String urlTitle,
			@DefaultValue("") @QueryParam("typeArtId") String typeArtId) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();

			urlTitle = HtmlUtil.escape(urlTitle);
			typeArtId = HtmlUtil.escape(typeArtId);

			if (urlTitle.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}

			Article article = null;
			if (typeArtId.equals("")) {
				article = ArticleLocalServiceUtil.getArticleByFriendlyURLAndStatus(urlTitle,
						NewsWorkflowConstants.STATUS_PUBLISH);
			} else {
				article = ArticleLocalServiceUtil.getArticle(Long.valueOf(typeArtId));
			}
			if (article != null && categoryId != -1) {
				String url = CMSPortalUtil.getURLCategory(Long.valueOf(categoryId));
				node.putPOJO("url", url);

				ObjectNode nodeCate = mapper.createObjectNode();
				com.software.cms.model.Category category = CategoryLocalServiceUtil.getCategory(categoryId);

				nodeCate.put("id", categoryId);
				nodeCate.put("name", category.getTitle());

				node.putPOJO("category", nodeCate);
			}
			node.putPOJO("baiViet", ArticleObject.ArticleNode(article));
            article.setViewCount(article.getViewCount() + 1);
            ArticleLocalServiceUtil.updateArticle(article);
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@GET
	@Path("/getall/category")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse getAllCategory(@DefaultValue("-1") @QueryParam("parentId") long parentId,
			@DefaultValue("") @QueryParam("title") String title) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode node = mapper.createArrayNode();

			if (parentId < 0) {
				return DataResponse.PARAM_ERROR;
			}
			TreeCategory treeCategory = new TreeCategory();

			if (parentId == 0) {
				node = treeCategory.getNodes(parentId, -1, "", treeCategory.NODE_PARENT, title, -1, -1);
			} else {
				node = treeCategory.getNodes(parentId, -1, "", treeCategory.NODE_CHILD, title, -1, -1);
			}

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}

	@POST
	@Path("/create/comment/{groupId}/{articleId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse CreateComment(@DefaultValue("-1") @QueryParam("commentId") long commentId,
			@DefaultValue("") @QueryParam("action") String action, CommentObject commentObj,
			@PathParam("groupId") long groupId, @PathParam("articleId") long articleId) {
		try {
			String name = HtmlUtil.escape(commentObj.getName());
			String email = HtmlUtil.escape(commentObj.getEmail());
			String content = HtmlUtil.escape(commentObj.getContent());

			if (articleId < 0 || groupId < 0 || name.isEmpty() || email.isEmpty() || content.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			if (!CommentObject.isValid(email)) {
				return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, "EMAIL NOT VALID", DataType.JSON_STR);
			}

			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.createObjectNode();
			if (action.isEmpty()) {
				Comment cmt = CommentLocalServiceUtil.create();
				cmt.setArticleId(articleId);
				cmt.setApproved(false);
				cmt.setCreatedDate(new Date());
				cmt.setGroupId(groupId);
				cmt.setUsername(name);
				cmt.setEmail(email);
				cmt.setContent(content);
				cmt = CommentLocalServiceUtil.addComment(cmt);
				node.putPOJO("data", cmt.getModelAttributes());
			} else if (action.equals("child")) {
				if (commentId < 0) {
					return DataResponse.PARAM_ERROR;
				}
				Comment cmt = CommentLocalServiceUtil.create();
				cmt.setArticleId(articleId);
				cmt.setApproved(false);
				cmt.setCreatedDate(new Date());
				cmt.setGroupId(groupId);
				cmt.setUsername(name);
				cmt.setEmail(email);
				cmt.setContent(content);
				cmt.setParentId(commentId);
				cmt = CommentLocalServiceUtil.addComment(cmt);
				node.putPOJO("data", cmt.getModelAttributes());
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
