package com.software.cms.article.portlet;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.software.cms.article.constants.ArticleActionPortletKeys;
import com.software.cms.model.Article;
import com.software.cms.model.ArticleHistory;
import com.software.cms.service.ArticleHistoryLocalServiceUtil;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.web.util.diff_match_patch;
import com.web.util.diff_match_patch.Diff;

@Component(immediate = true, property = {
		"javax.portlet.name=" + ArticleActionPortletKeys.ARTICLEACTION,
		"mvc.command.name=/history/directArticleHistory" },
		service = MVCRenderCommand.class)
public class ArticleHistoryRender implements MVCRenderCommand{

	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		String cmd = ParamUtil.getString(request, "cmd");
		if (cmd.equals("showDiffArticleHistory")) {
			try {
				long idah = ParamUtil.getLong(request, "idah");
				ArticleHistory ah = ArticleHistoryLocalServiceUtil
						.getArticleHistory(idah);
				long ida = ah.getArticleId();
				Article ar = ArticleLocalServiceUtil.getArticle(ida);
				request.setAttribute("ah", ah);
				request.setAttribute("ar", ar);
			} catch (Exception e) {
			}
		} else if (cmd.equals("showdiff")) {
			long idold_ = ParamUtil.getLong(request, "idold");
			long idcur_ = ParamUtil.getLong(request, "idcur");
			String showType = ParamUtil.getString(request, "showType");
			try {
				Article acur_ = ArticleLocalServiceUtil.getArticle(idcur_);
				ArticleHistory ahis_ = ArticleHistoryLocalServiceUtil.getArticleHistory(idold_);
				if (showType.equals("sho")) {
					ArticleHistory acom = ArticleHistoryLocalServiceUtil.getArticleHistory(idold_);
					acom.setTitle(checkDiff(ahis_.getTitle(), acur_.getTitle()));
					acom.setSummnary(checkDiff(ahis_.getSummnary(), acur_.getSummary()));
					acom.setImage(ahis_.getImage());
					acom.setImageDescription(checkDiff(ahis_.getImageDescription(), acur_.getImageTitle()));
					acom.setContent(checkDiff(ahis_.getContent(), acur_.getContent()));
					request.setAttribute("ah", acom);
					request.setAttribute("showType", "nor");
				} else {
					request.setAttribute("ah", ahis_);
					request.setAttribute("showType", "sho");
				}
				request.setAttribute("ar", acur_);
			} catch (Exception e) {
			}
			
			return "/article/article_custom/showDiffArticleHistory.jsp";
		}
		return "/article/article_custom/" + cmd+".jsp";
	}
	private String checkDiff(String x, String y) {
		String diffStr = "";
		diff_match_patch dmp = new diff_match_patch();
		dmp.Diff_Timeout = 0;
		List<Diff> listDiff = dmp.diff_main(x, y, false);
		for (Diff diff : listDiff) {
			String status = diff.operation.toString();
			if (status.equals("DELETE")) {
				diffStr += "<span class='del-text'>" + diff.text + "</span>";
			} else if (status.equals("INSERT")) {
				diffStr += "<span class='ins-text'>" + diff.text + "</span>";
			} else if (status.equals("EQUAL")) {
				diffStr += "<span>" + diff.text + "</span>";
			}

		}
		return diffStr;
	}
}
