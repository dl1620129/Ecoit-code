package com.software.cms.article.portlet;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.article.constants.ArticleActionPortletKeys;
import com.software.cms.model.Article;
import com.software.cms.model.ArticleHistory;
import com.software.cms.model.Logger;
import com.software.cms.service.ArticleHistoryLocalServiceUtil;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.LoggerLocalServiceUtil;
import com.software.util.RoleConstants;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ArticleActionPortletKeys.ARTICLEACTION,
	        "mvc.command.name=/history/doArticleHistory"
	    },
	    service = MVCActionCommand.class
	)
public class ArticleHistoryAction extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(request, "cmd", "no");
		String backUrl = ParamUtil.getString(request, "backUrl");
		Logger logger = LoggerLocalServiceUtil.createLogger(0);
		backUrl += "#gotoarticlehistory";
		
		if(cmd.equals("delete")){
			long id = ParamUtil.getLong(request, "idah");
			ArticleHistory ahis_ = ArticleHistoryLocalServiceUtil
					.getArticleHistory(id);
			ArticleHistoryLocalServiceUtil.deleteArticleHistory(id);			
			addLogger(request, response, ahis_, themeDisplay, logger, cmd);
		}
		else if(cmd.equals("revive")){
			long idold = ParamUtil.getLong(request, "idold");
			long idcur = ParamUtil.getLong(request, "idcur");
			Article acur = ArticleLocalServiceUtil.getArticle(idcur);
			ArticleHistory ahis = ArticleHistoryLocalServiceUtil.getArticleHistory(idold);
			acur.setTitle(ahis.getTitle());
			acur.setSummary(ahis.getSummnary());
			acur.setContent(ahis.getContent());
			acur.setImage(ahis.getImage());
			acur.setImageTitle(ahis.getImageDescription());
			acur.setAuthor(ahis.getAuthor());
			acur.setSource(ahis.getSource());
			Date date = new Date();
			acur.setModifiedDate(date);
			acur.setModifiedByUser(themeDisplay.getUserId());
			ArticleLocalServiceUtil.updateArticle(acur);
			addLogger(request, response, ahis, themeDisplay, logger, cmd);
		}		
		response.sendRedirect(backUrl);
		
	}
	public void addLogger(ActionRequest request, ActionResponse response,
			ArticleHistory articleHistory, ThemeDisplay themeDisplay,
			Logger logger, String action) throws Exception {
		logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
		logger.setUserId(themeDisplay.getUserId());
		logger.setLanguage(themeDisplay.getLocale().toString());
		logger.setGroupId(themeDisplay.getScopeGroupId());
		logger.setCreatedDate(new Date());
		logger.setType(String.valueOf(RoleConstants.EDIT_HISTORY));
		if(action.equals("revive"))		
			logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(), "soft.manage.articleHistory.logger.revive")+" : "+articleHistory.getTitle());
		if(action.equals("delete"))
			logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(), "soft.manage.articleHistory.logger.delete")+" : "+articleHistory.getTitle());
		LoggerLocalServiceUtil.addLogger(logger);
	}

}
