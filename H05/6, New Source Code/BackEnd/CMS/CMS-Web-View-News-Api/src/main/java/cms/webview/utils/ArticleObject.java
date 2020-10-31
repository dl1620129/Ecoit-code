package cms.webview.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Article;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.Comment;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class ArticleObject {
	public static ArrayNode getSubSite(long groupId, long articleId) {
		String checkedSubsite = "";

		List<String> lstSubsite = new ArrayList<String>();
		// TODO:something
		List<Object> lstObj = ArticleLocalServiceUtil
				.getDuLieuTheoSql("SELECT groupid,name FROM GROUP_ WHERE type_=1 AND site=true AND active_=true");
		List<Object> lstArtSite = ArticleLocalServiceUtil
				.getDuLieuTheoSql("SELECT articleid,groupid,articlemainid FROM soft_cms_article WHERE articlemainid="
						+ articleId + " AND issubsite=TRUE");
		for (String st : lstSubsite) {
			if (checkedSubsite.equals(""))
				checkedSubsite = st;
			else
				checkedSubsite += "," + st;
		}
		for (Object obj : lstArtSite) {
			Object[] oj = (Object[]) obj;
			if (checkedSubsite.equals(""))
				checkedSubsite = String.valueOf(oj[1]);
			else
				checkedSubsite += "," + String.valueOf(oj[1]);
		}
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		for (Object obj : lstObj) {
			ObjectNode node = mapper.createObjectNode();
			Object[] o = (Object[]) obj;
			if (groupId != Long.valueOf(String.valueOf(o[0]))) {
				if (("," + checkedSubsite + ",").contains("," + String.valueOf(o[0]) + ",")) {
					node.put("checked", true);
				} else {
					node.put("checked", false);
				}
				node.put("name", (String) o[1]);
				arrayNode.addPOJO(node);
			}
		}

		return arrayNode;
	}

	public static JsonNode ArticleNode(com.software.cms.model.Article article) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ObjectNode node = mapper.createObjectNode();
			node.put("articleId", article.getArticleId());
			node.put("title", HtmlUtil.extractText(article.getTitle()));
			node.put("content", HtmlUtil.extractText(article.getContent()));
			node.put("summary", HtmlUtil.extractText(article.getSummary()));
			node.put("source", HtmlUtil.extractText(article.getSource()));
			node.put("author", HtmlUtil.extractText(article.getAuthor()));

			List<CategoryArticle> categoryOfArticle = CategoryArticleLocalServiceUtil
					.getCategoryOfArticle(article.getArticleId());
			ArrayNode nodeCateArr = mapper.createArrayNode();

			ArrayNode subSite = ArticleObject.getSubSite(article.getGroupId(), article.getArticleId());
			node.putPOJO("subsite", subSite);

			if (categoryOfArticle != null && categoryOfArticle.size() > 0) {
				for (CategoryArticle cateArt : categoryOfArticle) {
					ObjectNode nodeCate = mapper.createObjectNode();
					com.software.cms.model.Category category = CategoryLocalServiceUtil
							.getCategory(cateArt.getCategoryId());

					nodeCate.put("id", cateArt.getCategoryId());
					nodeCate.put("name", category.getTitle());
					nodeCateArr.add(nodeCate);

				}
				node.putPOJO("categories", nodeCateArr);
			}

			if (!article.getTagIds().isEmpty()) {
				ArrayNode nodeTagArr = mapper.createArrayNode();
				String[] tagId = article.getTagIds().split(",");
				String[] tagName = article.getTags().split("~~");
				for (int i = 0; i < tagName.length; i++) {
					ObjectNode nodeTag = mapper.createObjectNode();
					nodeTag.put("id", tagId[i]);
					nodeTag.put("name", tagName[i]);
					nodeTagArr.add(nodeTag);
				}
				node.putPOJO("tags", nodeTagArr);
			}

			if (!article.getEventIds().isEmpty()) {
				ArrayNode nodeEventArr = mapper.createArrayNode();
				String[] eventId = article.getEventIds().split(",");
				String[] eventName = article.getEvents().split("~~");
				for (int i = 0; i < eventName.length; i++) {
					ObjectNode nodeEvent = mapper.createObjectNode();
					nodeEvent.put("id", eventId[i]);
					nodeEvent.put("name", eventName[i]);
					nodeEventArr.add(nodeEvent);
				}

				node.putPOJO("events", nodeEventArr);
			}

			node.put("friendlyURL", article.getFriendlyURL());

			ArrayNode nodeArtArr = mapper.createArrayNode();

			if (!article.getInvolveArt().isEmpty()) {
				String[] artLst = article.getInvolveArt().split(",");

				for (int j = 0; j < artLst.length; j++) {
					ObjectNode nodeArt = mapper.createObjectNode();
					nodeArt.put("id", artLst[j]);
					Article articleName = ArticleLocalServiceUtil.getArticle(Long.parseLong(artLst[j]));
					nodeArt.put("name", articleName.getTitle());
					nodeArtArr.add(nodeArt);
				}
			}

			// comment
			if (article.getAllowComent()) {
				List<Comment> commentList = CommentLocalServiceUtil.searchComment(article.getArticleId());
				ObjectNode nodeComment = mapper.createObjectNode();
				if (commentList.size() > 0) {
					ArrayNode parentCommentList = mapper.createArrayNode();
					ArrayNode childCommentList = mapper.createArrayNode();
					for (int i = 0; i < commentList.size(); i++) {
						if (commentList.get(i).isApproved()) {
							if (commentList.get(i).getParentId() == 0L)
								parentCommentList.addPOJO(commentList.get(i).getModelAttributes());
							else
								childCommentList.addPOJO(commentList.get(i).getModelAttributes());
						}
					}
					nodeComment.putPOJO("parentCommentList", parentCommentList);
					nodeComment.putPOJO("childCommentList", childCommentList);
					node.putPOJO("comment", nodeComment);
				}
			}

			node.putPOJO("involveArt", nodeArtArr);
			node.put("image", article.getImage());
			node.put("imageUrl", AttachmentUtil.viewDocument(article.getImage()));
			node.put("imageTitle", article.getImageTitle());
			node.put("folderId", article.getFolderId());
			node.put("isNoiBat", article.getIsNoiBat());
			node.put("isHomePage", article.getIsHomePage());
			node.put("allowComent", article.getAllowComent());
			node.put("thuTu", article.getThuTu());
			node.put("status", article.getStatus());
			node.putPOJO("publishedDateFrom", article.getPublishedDateFrom());
			node.putPOJO("publishedDateTo", article.getPublishedDateTo());
			
			return node;
		} finally {

		}

	}
}
