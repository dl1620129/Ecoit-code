package cms.article.object;

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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cms.article.util.AttachmentUtil;

public class ArticleObject {
	private long id;
	private String title;
	private String summary;
	private String content;
	private long imageId;
	private String imageDes;
	private String author;
	private long time;
	private String source;

	public String getsource() {
		return source;
	}

	public void setsource(String source) {
		this.source = source;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImageDes() {
		return imageDes;
	}

	public void setImageDes(String imageDes) {
		this.imageDes = imageDes;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long gettime() {
		return time;
	}

	public void settime(long time) {
		this.time = time;
	}

	public ArticleObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static class ArticlePage {
		private long id;
		private String name;
		private boolean checked;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		public ArticlePage() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

	public static class ArticleInvolve {
		private long id;
		private String title;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public ArticleInvolve() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

	public static class Tag {
		private long id;
		private String name;

		public Tag() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class User {
		private long id;
		private String name;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
	}

	public static class Event {
		private long id;
		private String name;

		public Event() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class OrtherTask {
		private long id;
		private String name;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public OrtherTask() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

	public static class Category {
		private long id;
		private String name;
		private boolean checked;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

	public static class SearchObject {
		long categoryId = -1;
		boolean inTitle = false;
		String eventNames = "";
		String tagNames = "";
		boolean inSummary = false;
		boolean inContent = false;
		boolean inDate = false;
		long fromDate = -1;
		long toDate = -1;
		boolean inAuthor = false;
		boolean userKiemDuyet = false;

		public long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(long categoryId) {
			this.categoryId = categoryId;
		}

		public boolean isInTitle() {
			return inTitle;
		}

		public void setInTitle(boolean inTitle) {
			this.inTitle = inTitle;
		}

		public String getEventNames() {
			return eventNames;
		}

		public void setEventNames(String eventNames) {
			this.eventNames = eventNames;
		}

		public String getTagNames() {
			return tagNames;
		}

		public void setTagNames(String tagNames) {
			this.tagNames = tagNames;
		}

		public boolean isInSummary() {
			return inSummary;
		}

		public void setInSummary(boolean inSummary) {
			this.inSummary = inSummary;
		}

		public boolean isInContent() {
			return inContent;
		}

		public void setInContent(boolean inContent) {
			this.inContent = inContent;
		}

		public boolean isInDate() {
			return inDate;
		}

		public void setInDate(boolean inDate) {
			this.inDate = inDate;
		}

		public long getFromDate() {
			return fromDate;
		}

		public void setFromDate(long fromDate) {
			this.fromDate = fromDate;
		}

		public long getToDate() {
			return toDate;
		}

		public void setToDate(long toDate) {
			this.toDate = toDate;
		}

		public boolean isInAuthor() {
			return inAuthor;
		}

		public void setInAuthor(boolean inAuthor) {
			this.inAuthor = inAuthor;
		}

		public boolean isUserKiemDuyet() {
			return userKiemDuyet;
		}

		public void setUserKiemDuyet(boolean userKiemDuyet) {
			this.userKiemDuyet = userKiemDuyet;
		}

		public SearchObject() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

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
				node.put("id", (BigInteger) o[0]);
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

			// comment
			if (article.getAllowComent()) {
				List<Comment> commentList = CommentLocalServiceUtil.searchComment(article.getArticleId());
				ObjectNode nodeComment = mapper.createObjectNode();
				if (commentList.size() > 0) {
					ArrayNode parentCommentList = mapper.createArrayNode();
					ArrayNode childCommentList = mapper.createArrayNode();
					for (int i = 0; i < commentList.size(); i++) {
						if (commentList.get(i).getParentId() == 0L)
							parentCommentList.addPOJO(commentList.get(i).getModelAttributes());
						else
							childCommentList.addPOJO(commentList.get(i).getModelAttributes());
					}
					nodeComment.putPOJO("parentCommentList", parentCommentList);
					nodeComment.putPOJO("childCommentList", childCommentList);
					node.putPOJO("comment", nodeComment);
				}
			}

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

			if (!article.getHumanAccessIds().isEmpty()) {
				ArrayNode nodeUserArr = mapper.createArrayNode();
				String[] userIds = article.getHumanAccessIds().split(",");
				String[] userName = article.getHumanAccess().split("~~");
				for (int i = 0; i < userIds.length; i++) {
					ObjectNode nodeUser = mapper.createObjectNode();
					nodeUser.put("id", userIds[i]);
					nodeUser.put("name", userName[i]);
					nodeUserArr.add(nodeUser);
				}
				node.putPOJO("humanAccesses", nodeUserArr);
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
			if (article.getPublishedDateFrom() != null)
				node.put("publishedDateFrom", article.getPublishedDateFrom().getTime());
			if (article.getPublishedDateTo() != null)
				node.put("publishedDateTo", article.getPublishedDateTo().getTime());
			node.putPOJO("involveArt", nodeArtArr);
			node.put("image", article.getImage());
			node.put("imageUrl", AttachmentUtil.viewDocument(article.getImage()));
			node.put("imageTitle", article.getImageTitle());
			node.put("folderId", article.getFolderId());
			node.put("isNoiBat", article.getIsNoiBat());
			node.put("isHomePage", article.getIsHomePage());
			node.put("allowComent", article.getAllowComent());
			node.put("henGio", article.getIsTimer());
			node.put("thuTu", article.getThuTu());
			node.put("status", article.getStatus());
			return node;
		} finally {

		}

	}

}
