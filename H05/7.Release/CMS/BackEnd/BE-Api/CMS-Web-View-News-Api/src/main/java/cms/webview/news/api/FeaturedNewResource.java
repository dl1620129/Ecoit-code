package cms.webview.news.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.software.cms.model.Article;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.util.DataResponse;
import com.software.util.ResponseCode;
import com.software.util.DataResponse.DataType;
import com.software.util.NewsWorkflowConstants;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cms.webview.utils.ArticleObject;

@Path("/featured-new")
public class FeaturedNewResource {
	//private JsonNodeFactory factory = JsonNodeFactory.instance;
	private ObjectMapper mapper = new ObjectMapper();

	@GET
	@Path("/get-all/{locale}/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse GetList(@PathParam("locale") String locale,@PathParam("groupId") long groupId) {
		
		try {
			locale = HtmlUtil.escape(locale);

			if (locale.isEmpty()) {
				return DataResponse.PARAM_ERROR;
			}
			if (groupId<0) {
				return DataResponse.PARAM_ERROR;
			}
			List<Article> listTinMoiNhat = new ArrayList<Article>();
			List<Article> ltmp = ArticleLocalServiceUtil.getArticleFeaturedNew(1, 1, locale, true,
					false, NewsWorkflowConstants.STATUS_PUBLISH, "",groupId);
			if (ltmp != null && ltmp.size() > 0)
				listTinMoiNhat.add(ltmp.get(0));

			ltmp = ArticleLocalServiceUtil.getArticleFeaturedNew(2, 1, locale, true, false,
					NewsWorkflowConstants.STATUS_PUBLISH, "",groupId);
			if (ltmp != null && ltmp.size() > 0)
				listTinMoiNhat.add(ltmp.get(0));

			ltmp = ArticleLocalServiceUtil.getArticleFeaturedNew(3, 1, locale, true, false,
					NewsWorkflowConstants.STATUS_PUBLISH, "",groupId);
			if (ltmp != null && ltmp.size() > 0)
				listTinMoiNhat.add(ltmp.get(0));

			ltmp = ArticleLocalServiceUtil.getArticleFeaturedNew(4, 1, locale, true, false,
					NewsWorkflowConstants.STATUS_PUBLISH, "",groupId);
			if (ltmp != null && ltmp.size() > 0)
				listTinMoiNhat.add(ltmp.get(0));

			String lIds = "";
			if (listTinMoiNhat.size() < 4) {
				if (listTinMoiNhat.size() > 0) {
					for (int i = 0; i < listTinMoiNhat.size(); i++) {
						if (lIds.equals(""))
							lIds = "" + listTinMoiNhat.get(i).getArticleId();
						else
							lIds += "," + listTinMoiNhat.get(i).getArticleId();
					}
				}

				ltmp = ArticleLocalServiceUtil.getArticleFeaturedNew(-1,
						(4 - listTinMoiNhat.size()), locale, true, false, NewsWorkflowConstants.STATUS_PUBLISH, lIds,groupId);
				if (ltmp != null && ltmp.size() > 0) {
					for (int i = 0; i < ltmp.size(); i++) {
						listTinMoiNhat.add(ltmp.get(i));
					}
				}
			}
			List<Article> listTinNoiBat = ArticleLocalServiceUtil.getArticleFeaturedNew(-1, 4,
					locale, false, true, NewsWorkflowConstants.STATUS_PUBLISH, lIds,groupId);
			
			ObjectNode node = mapper.createObjectNode();
			ArrayNode arrayNode = mapper.createArrayNode();
			for (Article article : listTinMoiNhat) {
				arrayNode.addPOJO(ArticleObject.ArticleNode(article));
			}
			ArrayNode arrayNodeNB = mapper.createArrayNode();
			for (Article article : listTinNoiBat) {
				arrayNodeNB.addPOJO(ArticleObject.ArticleNode(article));
			}
			node.putPOJO("listTinMoiNhat", arrayNode);
			node.putPOJO("listTinNoiBat", arrayNodeNB);

			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, node, DataType.JSON_STR);
		} catch (Exception e) {
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
	

	
	@GET
	@Path("/check/admin/{companyId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataResponse checkUser(@PathParam("userId") long userId, @PathParam("companyId") long companyId) {
		try {
			Role role = RoleLocalServiceUtil.getRole(companyId, "Administrator");
			User user = UserLocalServiceUtil.getUser(userId);
			boolean isAdmin = false;
			for (long roleId : user.getRoleIds()) {
				if (roleId == role.getRoleId()) {
					isAdmin = true;
				}
			}
			return new DataResponse(ResponseCode.SUCCESSFUL, ResponseCode.SUCCESSFUL, isAdmin, DataType.JSON_STR); 
		} catch (Exception e) {
			e.printStackTrace();
			return new DataResponse(ResponseCode.FAILED, ResponseCode.FAILED, e.getMessage(), DataType.JSON_STR);
		}
	}
}
