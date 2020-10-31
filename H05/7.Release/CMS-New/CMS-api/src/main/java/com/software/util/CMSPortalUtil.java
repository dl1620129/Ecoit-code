package com.software.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ColorScheme;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.model.Category;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.MapCateLayout;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.cms.service.MapCateLayoutLocalServiceUtil;

public class CMSPortalUtil {
	public static String getMinifyURL(HttpServletRequest request,
			String minifierType) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Theme theme = themeDisplay.getTheme();
		ColorScheme colorScheme = themeDisplay.getColorScheme();
		StringBuilder sb = new StringBuilder();

		// Browser id
		sb.append("?browserId=");
		sb.append(BrowserSnifferUtil.getBrowserId(request));

		// Theme and color scheme
		sb.append("&themeId=");
		sb.append(theme.getThemeId());
		sb.append("&colorSchemeId=");
		sb.append(colorScheme.getColorSchemeId());
		// Minifier
		if (Validator.isNotNull(minifierType)) {
			sb.append("&minifierType=");
			sb.append(minifierType);
		}

		// Timestamp
		sb.append("&t=");
		sb.append(theme.getTimestamp());
		return sb.toString();
	}

	public static void setCacheReponse(RenderRequest renderRequest,
			RenderResponse renderResponse, String etag) throws Exception {
		Calendar c = Calendar.getInstance();
		Date current = c.getTime();
		c.add(Calendar.SECOND,
				GetterUtil.getInteger(PropsUtil.get("action_expires"), 120));
		Date expires = c.getTime();
		renderResponse.setProperty(HttpHeaders.EXPIRES, expires.toString());
		renderResponse.setProperty(HttpHeaders.LAST_MODIFIED,
				current.toString());
		renderResponse.setProperty(HttpHeaders.CACHE_CONTROL, "public");
		renderResponse.setProperty("Etag", etag);
	}
	public static PortletURL getPortletURLSearchFromFriendURLAndPortletId(
			HttpServletRequest request, long groupId, long plid,
			String portletId) throws PortalException, SystemException {
//		String friendUrl = getFriendUrlByCategoryId(categoryId);
		Layout layout = LayoutLocalServiceUtil.getLayout(plid);
		Portlet portlet = getPortletFromLayoutAndPortletId(layout, portletId);
		return PortletURLFactoryUtil.create(request, portlet.getPortletId(),
				layout.getPlid(), PortletRequest.RENDER_PHASE);

	}

	public static PortletURL getPortletURLFromFriendURLAndPortletId(
			HttpServletRequest request, Long groupId, long categoryId,
			String portletId) throws PortalException, SystemException {
		String friendUrl = getFriendUrlByCategoryId(categoryId);
		Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId,
				false, friendUrl);
		Portlet portlet = getPortletFromLayoutAndPortletId(layout, portletId);
		return PortletURLFactoryUtil.create(request, portlet.getPortletId(),
				layout.getPlid(), PortletRequest.RENDER_PHASE);

	}

	public static Portlet getPortletFromLayoutAndPortletId(Layout layout,
			String portletId) {
		try {
			LayoutTypePortlet typePortlet = (LayoutTypePortlet) layout
					.getLayoutType();
			List<Portlet> listPortlet = typePortlet.getPortlets();
			for (Portlet portlet : listPortlet) {
				if (portlet.getPortletName().equals(portletId)) {
					return portlet;
				}
			}
		} catch (SystemException systemException) {
			return null;
		} catch (Exception ex) {
			return null;
		}
		return null;
	}

	public static String getFriendUrlByCategoryId(long categoryId) {
		try {
			MapCateLayout cateLayout = MapCateLayoutLocalServiceUtil
					.getMapCateLayoutByCategoryIdAndType(categoryId, 1);
			if (cateLayout != null) {
				Layout layout = LayoutLocalServiceUtil.getLayout(cateLayout
						.getLayoutId());
				return layout.getFriendlyURL();
			}
		} catch (SystemException systemException) {
			return "/tin-chi-tiet";
		} catch (Exception ex) {
			return "/tin-chi-tiet";
		}
		//return "";
		return "/tin-chi-tiet";
	}
	
	public static String getURLCategory(long categoryId) {
		try {
			MapCateLayout cateLayout = MapCateLayoutLocalServiceUtil
					.getMapCateLayoutByCategoryIdAndType(categoryId,2);
			if (cateLayout != null) {
				Layout layout = LayoutLocalServiceUtil.getLayout(cateLayout
						.getLayoutId());
				return layout.getFriendlyURL();
			}
		} catch (SystemException systemException) {
			return "#";
		} catch (Exception ex) {
			return "#";
		}
		return "#";
	}
	public static String getStringParam(HttpServletRequest request, String paramName, String defaultValue) {
		  String currentURL = PortalUtil.getCurrentURL(request);
		  StringBuffer value = new StringBuffer();

		  if (currentURL.contains(paramName)) {
		   int st = currentURL.indexOf(paramName) + paramName.length() + 1;
		   while (st < currentURL.length() && currentURL.charAt(st) != '&') {
		    value.append(currentURL.charAt(st));
		    st++;
		   }
		  }

		  if (value.toString().equals("")) {
		   return defaultValue;
		  }

		  return value.toString();
		 }
	public static List<Category> getChildCategory(ThemeDisplay themeDisplay, long categoryId) {
		List<Category> listCate = new ArrayList<Category>();
		try {
			listCate = CategoryLocalServiceUtil.getCategoryHaveParentId(themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), categoryId);
			if(listCate!=null && listCate.size()> 4){
				listCate = listCate.subList(0, 4);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCate;
	}
	public static String removeParameter(String url,String param){
   	 url=url.trim();param=param.trim();
		 String str=url;
   	 if(!url.equals("") && !param.equals("")){
   		 str="";
   		 int i=url.indexOf("?");
   		 if(i>=0 && i<url.length()-1){
   			 str=url.substring(0, i+1);
   			 url=url.substring(i+1);
   		 }
   		 if(url.contains("&")){
   			 String[]ls=url.split("&");
   			 String str1="";
   			 for(String s1:ls){
   				 if(!s1.equals("")){
   					 String []ls1=s1.split("=");
   					 if(ls1.length<=2){
   						 if(!ls1[0].contains(param)){
   							 if(str1.equals(""))str1=ls1[0]+"="+((ls1.length>=2)?ls1[1]:"");
   							 else str1+="&"+ls1[0]+"="+((ls1.length>=2)?ls1[1]:"");
   						 }
   					 }
   				 }
   			 }
   			 str+=str1;
   		 }
   		 else str+=url;
   	 }
   	 return str;
    }
	public static String checkInputSearch(String str){
		String result=str.trim();
		if(!result.equals("")){
			result=result.replace("'","''");
			result=result.replaceAll("(?i)insert "," ");
			result=result.replaceAll("(?i)delete "," ");
			result=result.replaceAll("(?i)update "," ");
		}
		return result.trim();
	}
	@SuppressWarnings("deprecation")
	public static String getUrlArticle(Article art, long catId, HttpServletRequest request, long groupId){
		try {
			if(catId<=0){ //Chua co categoryId
				List<CategoryArticle> lt = new ArrayList<CategoryArticle>();
				try{
					lt = CategoryArticleLocalServiceUtil.getCategoryOfArticle(art.getArticleId());
				}catch(Exception e){}
				if(lt!=null&&!lt.isEmpty() && lt.size()>0){
					catId = lt.get(0).getCategoryId();
				}
			}
			PortletURL portletURL = getPortletURLFromFriendURLAndPortletId(request, groupId, Long.valueOf(catId).longValue(), "com_view_article_detail_DetailControllerPortlet");
			portletURL.setParameter("mvcRenderCommandName", "/tin-chi-tiet");
			portletURL.setParameter("categoryId", String.valueOf(catId));
			portletURL.setParameter("urlTitle", art.getFriendlyURL());
			String url1 = portletURL.toString();
			
			return url1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			return art.getFriendlyURL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String getParamUrl(String currentURL,String paramName,String defaultValue){
		StringBuffer value = new StringBuffer();
		if (currentURL.contains(paramName)) {
			   int st = currentURL.indexOf(paramName) + paramName.length() + 1;
			   while (st < currentURL.length() && currentURL.charAt(st) != '&') {
			    value.append(currentURL.charAt(st));
			    st++;
			   }
			  }

			  if (value.toString().equals("")) {
			   return defaultValue;
			  }
		return value.toString();
	}
}

