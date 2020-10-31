package com.view.article.render.detail;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.software.cms.model.Article;
import com.software.cms.model.Comment;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;
import com.software.util.CMSPortalUtil;
import com.view.article.detail.constants.DetailControllerPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DetailControllerPortletKeys.DETAILCONTROLLER,
		"mvc.command.name=/tin-chi-tiet" },
		service = MVCRenderCommand.class)
public class DetailRender implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String friendUrl = ParamUtil.getString(renderRequest, "urlTitle", "");
			String categoryId = ParamUtil.getString(renderRequest, "categoryId", "-1");
			String typeArtId = (ParamUtil.getString(renderRequest, "typeArtId", "").equals("")? CMSPortalUtil.getStringParam(httpRequest, "typeArtId", ""):ParamUtil.getString(renderRequest, "typeArtId", ""));
			Article article = null;
			if(typeArtId.equals("")){
				article = ArticleLocalServiceUtil.getArticleByFriendlyURL(friendUrl);
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
		return "/view.jsp";
	}

}
