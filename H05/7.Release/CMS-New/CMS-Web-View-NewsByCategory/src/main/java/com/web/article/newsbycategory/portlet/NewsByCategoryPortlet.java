package com.web.article.newsbycategory.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.model.Category;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.web.article.newsbycategory.constants.NewsByCategoryPortletKeys;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CMS VIEW",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NewsByCategory",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/newByCategory/view.jsp",
		"javax.portlet.name=" + NewsByCategoryPortletKeys.NEWSBYCATEGORY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsByCategoryPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		try {
			PortletPreferences preferences = request.getPreferences();
			String cateConfig = preferences.getValue("categorySelect", "-1");
			String cau_hinh_trang_chi_tiet = preferences.getValue("cau_hinh_trang_chi_tiet", "");
			String hien_thi_theo_thong_bao = preferences.getValue("hien_thi_theo_thong_bao", "");
			String hien_thi_theo_thong_bao_theo_slide = preferences.getValue("hien_thi_theo_thong_bao_theo_slide", "");
			String hien_thi_theo_dang_tabs = preferences.getValue("hien_thi_theo_dang_tabs", "");
			String day_bai_viet_thong_bao_len_menu = preferences.getValue("day_bai_viet_thong_bao_len_menu", "");
			System.out.println("cateConfig : "+ cateConfig);
			
			if(!cateConfig.equals("") && !cateConfig.equals("-1")){
				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);
				List<Category> lstCate = null;
				if(hien_thi_theo_dang_tabs.equals("true")){
					lstCate = CategoryLocalServiceUtil.getCateTheoSQL("SELECT * FROM soft_cms_category WHERE groupid = "+themeDisplay.getScopeGroupId()+" AND language='"+themeDisplay.getLanguageId()+"' AND categoryid IN ("+cateConfig+") ORDER BY thutu ASC ");
					long cateId = 0;
					for(String st : cateConfig.split(",")){
						cateId = Long.valueOf(st);
						break;
					}
					List<Article> list = ArticleLocalServiceUtil.getListArticleByCaterory(themeDisplay.getScopeGroupId(), cateId, null, Integer.valueOf(0), Integer.valueOf(4));
					request.setAttribute("lstCate", lstCate);
					request.setAttribute("listArticleTypeTwo", list);
					request.setAttribute("categoryIdTypeTwo",
							String.valueOf(cateId));
				}
				else{
					long cateId = Long.valueOf(cateConfig);
					Category cate = CategoryLocalServiceUtil.getCategory(cateId);
					List<Article> list = ArticleLocalServiceUtil.getListArticleByCaterory(themeDisplay.getScopeGroupId(), Long.valueOf(cate.getCategoryId()), null, Integer.valueOf(0), Integer.valueOf(4));
					List<Article> listNotification = ArticleLocalServiceUtil
							.getListArticleByCaterory(themeDisplay.getScopeGroupId(),
									Long.valueOf(cate.getCategoryId()), null,
									Integer.valueOf(0), Integer.valueOf(3));
					request.setAttribute("categoryIdTypeTwo",
							String.valueOf(cate.getCategoryId()));
					request.setAttribute("categoryNameTypeTwo", cate.getTitle());
					request.setAttribute("listNotification", listNotification);
					request.setAttribute("listArticleTypeTwo", list);
				}
				request.setAttribute("cau_hinh_trang_chi_tiet", cau_hinh_trang_chi_tiet);
				request.setAttribute("hien_thi_theo_thong_bao", hien_thi_theo_thong_bao);
				request.setAttribute("hien_thi_theo_thong_bao_theo_slide", hien_thi_theo_thong_bao_theo_slide);
				request.setAttribute("hien_thi_theo_dang_tabs", hien_thi_theo_dang_tabs);
				request.setAttribute("day_bai_viet_thong_bao_len_menu", day_bai_viet_thong_bao_len_menu);
			}

		} catch (Exception ex) {
		}	
		super.render(request, response);
	}
}