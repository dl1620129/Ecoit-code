package com.view.article.detail.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.model.ArticleMailSend;
import com.software.cms.model.Comment;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.ArticleMailSendLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;
import com.software.util.CMSPortalUtil;
import com.software.util.NewsWorkflowConstants;
import com.view.article.detail.constants.DetailControllerPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CMS VIEW",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=DetailController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DetailControllerPortletKeys.DETAILCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DetailControllerPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String friendUrl = ParamUtil.getString(renderRequest, "urlTitle", "");
			String categoryId = ParamUtil.getString(renderRequest, "categoryId", "-1");
			String typeArtId = (ParamUtil.getString(renderRequest, "typeArtId", "").equals("")? CMSPortalUtil.getStringParam(httpRequest, "typeArtId", ""):ParamUtil.getString(renderRequest, "typeArtId", ""));
			Article article = null;
			if(typeArtId.equals("")){
				article = ArticleLocalServiceUtil.getArticleByFriendlyURLAndStatus(friendUrl, NewsWorkflowConstants.ACTION_PUBLISH);
			}else{
				article = ArticleLocalServiceUtil.getArticle(Long.valueOf(typeArtId));
			}
			List<Comment> commentList = null;
			if(article!=null && typeArtId.equals("")){
				commentList = CommentLocalServiceUtil.searchComment(article.getArticleId());
			}
			renderRequest.setAttribute("categoryId", categoryId);
			renderRequest.setAttribute("baiViet", article);
			renderRequest.setAttribute("commentList", commentList);
			renderRequest.setAttribute("typeArtId", typeArtId);
		} catch (Exception e) {}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd", "");
		System.out.println("cmd: "+cmd);
		if(cmd.equals("CONFIG_DETAIL")) {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long categoryId = ParamUtil.getLong(resourceRequest, "categoryId",-1);
			System.out.println("categoryId: "+categoryId);
			String sql = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article INNER JOIN soft_cms_categoryarticle "
					+ "ON soft_cms_article.articleid=soft_cms_categoryarticle.articleid "
					+ "WHERE soft_cms_categoryarticle.categoryid = "+categoryId
					+ " and soft_cms_article.groupid = "+themeDisplay.getScopeGroupId()
					+ " AND soft_cms_article.status= "
					+ NewsWorkflowConstants.STATUS_PUBLISH;
			sql += " ORDER BY publisheddatefrom DESC";
			System.out.println(sql);
			List<Article> listArticles = ArticleLocalServiceUtil.getArticleTheoSQL(sql);
			String html = "<table id=\"table-view-data\" class=\"display\" style=\"width:100%\">";
					html += "<thead>";
						html +="<tr>";
							html +="<th>Article</th>";
							html +="<th>Choose</th>";
						html +="</tr>";
					html += "</thead>";
					html += "<tbody>";
				for(Article article : listArticles){
					html += "<tr>";
						html += "<td>"+article.getTitle()+"</td>";
						html += "<td><input name='select-article' id='id_"+article.getArticleId()+"' value='"+article.getArticleId()+"' type='radio'/></td>";
					html += "</tr>";
				}
				html += "</tbody>";
			html += "</table>";
			PrintWriter writer = resourceResponse.getWriter();
			resourceResponse.setContentType("application/text");
			resourceResponse.setCharacterEncoding("UTF-8");
			writer.println(html);
			writer.flush();
			writer.close();
		}else {
			long articleId = ParamUtil.getLong(resourceRequest, "articleId",-1);
			long viewCount = 0;
			if(articleId != -1){
				try {
					Article article = ArticleLocalServiceUtil.getArticle(articleId);
					if(article != null){
						viewCount = article.getViewCount()+1;
						System.out.println("viewCount: "+viewCount);
						article.setViewCount(viewCount);
						ArticleLocalServiceUtil.updateArticle(article);
					}
				} catch (Exception e) {
					System.out.println("error_view_count");
				}
			}
		}
	}
	public void ActionSendMail(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long articleid = ParamUtil.getLong(request, "articleId");
		long cateId = ParamUtil.getLong(request, "cateId");
		String nguoiGui = HtmlUtil.escape(ParamUtil.getString(request, "nguoiGui"));
		String mailNguoiGui = HtmlUtil.escape(ParamUtil.getString(request, "mailNguoiGui"));
		String nguoiNhan = HtmlUtil.escape(ParamUtil.getString(request, "nguoiNhan"));
		String mailNguoiNhan = HtmlUtil.escape(ParamUtil.getString(request, "mailNguoiNhan"));
		String tieuDe = HtmlUtil.escape(ParamUtil.getString(request, "tieuDe"));
		String noiDung = HtmlUtil.escape(ParamUtil.getString(request, "noiDung"));
		String linkBaiViet = HtmlUtil.escape(ParamUtil.getString(request, "linkBaiViet",""));
		String Link = HtmlUtil.escape(ParamUtil.getString(request, "Link",""));
		System.out.println(PortalUtil.getHttpServletRequest(request).getRemoteAddr()+"-"+PortalUtil.getHttpServletRequest(request).getRemoteHost());
		System.out.println(articleid+" ActionSendMail ho_va_ten : "+nguoiGui);
		request.setAttribute("closeWTab", "closeWTab");
		try{
			ArticleMailSend articleMailSend = ArticleMailSendLocalServiceUtil.create();
			articleMailSend.setArticleId(articleid);
			articleMailSend.setCategoryId(cateId);
			articleMailSend.setCreateDate(new Date());
			articleMailSend.setGroupId(themeDisplay.getScopeGroupId());
			articleMailSend.setNguoiGui(nguoiGui);
			articleMailSend.setMailNguoiGui(mailNguoiGui);
			articleMailSend.setNguoiNhan(nguoiNhan);
			articleMailSend.setMailNguoiNhan(mailNguoiNhan);
			articleMailSend.setTieuDe(tieuDe);
			articleMailSend.setNoiDung(noiDung);
			ArticleMailSendLocalServiceUtil.addArticleMailSend(articleMailSend);
			//SendMail.sendMailMessage(request, response, nguoiGui, mailNguoiGui, nguoiNhan, mailNguoiNhan, tieuDe, noiDung, linkBaiViet);
			SessionMessages.add(request, "SENDMAIL_OK");
		}catch(Exception e){}
		if(!Link.equals(""))response.sendRedirect(Link+"&"+response.getNamespace()+"closeWTab=closeWTab");
	}
	public void ActionComment(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String currentURL = ParamUtil.getString(request, "currentURL");
		String ho_va_ten = HtmlUtil.escape(ParamUtil.getString(request, "ho_va_ten"));
		String email = HtmlUtil.escape(ParamUtil.getString(request, "email"));
		String noi_dung_comment = HtmlUtil.escape(ParamUtil.getString(request, "noi_dung_comment"));
		long articleid = ParamUtil.getLong(request, "articleid");
		long cateId = ParamUtil.getLong(request, "categoryId",-1);
		if(!ho_va_ten.equals("") && !email.equals("")){
			Comment cmt = CommentLocalServiceUtil.create();
			cmt.setArticleId(articleid);
			cmt.setApproved(false);
			cmt.setCreatedDate(new Date());
			cmt.setGroupId(themeDisplay.getScopeGroupId());
			cmt.setUsername(ho_va_ten);
			cmt.setEmail(email);
			cmt.setContent(noi_dung_comment);
			cmt = CommentLocalServiceUtil.addComment(cmt);
			//SendMail.sendMailComment(request, response, cmt, articleid, cateId);
		}else{
			SessionErrors.add(request, "error_NULL");
		}
		response.sendRedirect(currentURL);
	}
	public void ActionChildComment(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String currentURL = ParamUtil.getString(request, "currentURL");
		String ho_va_ten = HtmlUtil.escape(ParamUtil.getString(request, "ho_va_ten",""));
		String email = HtmlUtil.escape(ParamUtil.getString(request, "email",""));
		String noi_dung_comment = HtmlUtil.escape(ParamUtil.getString(request, "noi_dung_comment"));
		long articleid = ParamUtil.getLong(request, "articleid");
		long commentId = ParamUtil.getLong(request, "commentId");
		long cateId = ParamUtil.getLong(request, "categoryId",-1);
		if(!ho_va_ten.equals("") && !email.equals("")){
			Comment cmt = CommentLocalServiceUtil.create();
			cmt.setArticleId(articleid);
			cmt.setApproved(false);
			cmt.setCreatedDate(new Date());
			cmt.setGroupId(themeDisplay.getScopeGroupId());
			cmt.setUsername(ho_va_ten);
			cmt.setEmail(email);
			cmt.setContent(noi_dung_comment);
			cmt.setParentId(commentId);
			cmt = CommentLocalServiceUtil.addComment(cmt);
			//SendMail.sendMailComment(request, response,cmt, articleid, cateId);
		}else{
			SessionErrors.add(request, "error_NULL");
		}
		response.sendRedirect(currentURL);
	}
}