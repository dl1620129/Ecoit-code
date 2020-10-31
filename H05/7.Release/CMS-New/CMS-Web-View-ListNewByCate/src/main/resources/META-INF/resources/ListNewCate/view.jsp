<%@page import="com.software.util.CMSPortalUtil"%>
<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.software.cms.service.CategoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.Article"%>
<%@page import="com.software.cms.model.Category"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="../init.jsp"%>
<%
try{
Category cat = (Category)request.getAttribute("category");
List<Article> lstArtSlide = (List<Article>)request.getAttribute("resultHotNew");
String slide_tin_chuyen_muc = (String)request.getAttribute("slide_tin_chuyen_muc");
String danh_sach_slide_tin_chuyen_muc = (String)request.getAttribute("danh_sach_slide_tin_chuyen_muc");
SearchContainer searchContainer = (SearchContainer)request.getAttribute("searchContainerTinTucTrangChuyenMuc");
String check_remove_category = (String)request.getAttribute("check_remove_category");
String srcImgDefault = renderRequest.getContextPath()+"/image/noimage.png";
String titleCateParent = "";
String urlCatParent  = "";
if(cat.getParentId() > 0){
	titleCateParent = CategoryLocalServiceUtil.getCategory(cat.getParentId()).getTitle();
	urlCatParent = CMSPortalUtil.getURLCategory(cat.getParentId());
}
if((searchContainer!=null && cat!=null) || (lstArtSlide != null)){
if(slide_tin_chuyen_muc != null && slide_tin_chuyen_muc.equals("false")){
	List<Article> listArt = searchContainer.getResults();
	if(listArt==null) listArt = new ArrayList<Article>();
	SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
	String url1 = CMSPortalUtil.getUrlArticle(listArt.get(0), cat.getCategoryId(), request, themeDisplay.getScopeGroupId());
	String urlImg1 = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, listArt.get(0).getImage(), "210x160");
	String urlCat  = CMSPortalUtil.getURLCategory(cat.getCategoryId());
	
%>
<div class="primary-box">
	<h3 class="tle inline-block bg-tle">
		<img src="/o/portal-h05-bca-theme/images/logo/logo.png" style="height: 30px;" alt="">
		<span  class="text-white"><a href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+urlCat%>"><%=cat.getTitle() %></a></span>
	</h3>
	<%-- <%if(!check_remove_category.equals("true")){ %>
		<div class="page-category">
			<div class="page-title">
				<h3>
					<a class="cate-Parent-0" href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()%>"><i class="ico-2"></i></a>
					<%if(!titleCateParent.equals("")) {%><a class="cate-Parent-1" href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+urlCatParent%>"><%=titleCateParent %></a> 
					<%} %>
					<a href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+urlCat%>"><%=cat.getTitle() %></a>
				</h3>
			</div>
		</div>
	<%} %> --%>
	<div class="page-category-content mt-3">
		<div class="news-list">
			<%
		   for(Article art : listArt){ 
			   String urlImg = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, art.getImage(), "210x160");
			   String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, themeDisplay.getScopeGroupId());
		   %>
		   <div class="newsItem">
			   <div class="ItemContent">
				    <%if(!urlImg.equals(srcImgDefault)){ %>
				       	<a href="<%=url%>"><img class="card-category-img" src="<%=urlImg %>" alt=""></a>
			       	<%} %>
			       	<h2>
			       		<a href="<%=url%>"  title="<%=art.getTitle()%>"><%=art.getTitle() %></a>
			       	</h2>
			       	<div class="time">
			       	
			       	</div>
			       	<p class="des"><%=art.getSummary() %></p>
		    	</div>
	        </div>
		   <%} %>
		</div>
	</div>
	<liferay-ui:search-paginator searchContainer="<%=searchContainer%>"></liferay-ui:search-paginator>
</div>
<%}else{
	String urlCat  = CMSPortalUtil.getURLCategory(cat.getCategoryId());
int sizeArtSlide = 0;
try{
	sizeArtSlide = lstArtSlide.size();
}catch(Exception e){sizeArtSlide = 0;}%>
<div class="primary-box">
	<h3 class="tle inline-block bg-tle">
		<img src="/o/portal-h05-bca-theme/images/logo/logo.png" style="height: 30px;" alt="">
		<span  class="text-white"><a href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+urlCat%>"><%=cat.getTitle() %></a></span>
	</h3>
	<%-- <%if(danh_sach_slide_tin_chuyen_muc.equals("false")){ %>
		<%if(!check_remove_category.equals("true")){ %>
			<div class="page-category">
				<div class="page-title">
					<h3>
						<a class="cate-Parent-0" href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()%>"><i class="ico-2"></i></a>
						<%if(!titleCateParent.equals("")) {%>
						<%} %>
						<a href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+urlCat%>"><%=cat.getTitle() %></a>
					</h3>
				</div>
			</div>
		<%} %>
	<%}%>	 --%>
	<div class="page-content box-tin bo-topdo row">
		<%if(danh_sach_slide_tin_chuyen_muc.equals("false")){ %>
			<section class="main-box">
				<div class="row">
					<div class="col-md-8 mb-3 mb-md-0">
						<div class="slider-news">
							<%int i = 0;
							for(i=0;i< sizeArtSlide && i<5;i++){
								Article art = lstArtSlide.get(i);
								 String urlImg = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, art.getImage(), "210x160");
								   String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, themeDisplay.getScopeGroupId());
								   %>
								<div class="item">
		                          <div class="main-news">
		                            <div class="img">
		                              <a href="<%=url%>"><img src="<%=urlImg %>" alt=""></a>
		                            </div>
		                            <div class="text">
		                              <h3><a href="<%=url%>"><%=art.getTitle() %></a></h3>
		                              <div class="desc dotdotdot">
		                                <%=StringUtil.shorten(art.getSummary(),160) %>
		                              </div>
		                            </div>
		                          </div><!-- /.main-news -->
		                        </div>
							<%} %>
						</div>
					</div>
					<div class="col-md-4">
						<div class="latest-news">
	                        <h3 class="title-line text-uppercase"><span><liferay-ui:message key="ecoit.asia.cms.label.tinmoinhat"></liferay-ui:message></span></h3>
	                        <ul>
	                        	<%
	                        	for(int j=i;j< sizeArtSlide;j++){
	                        			Article art = lstArtSlide.get(j);
	                        			String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, themeDisplay.getScopeGroupId());
	                        		%>
	                        		<li>
			                           <a href="<%=url%>"><%=StringUtil.shorten(art.getTitle(),120) %></a>
			                        </li>
	                        	<%} %>
	                        </ul>
	                    </div>    
					</div>
				</div>
			</section>
		<%}else{
			List<Article> listArt = searchContainer.getResults();
			if(listArt==null) listArt = new ArrayList<Article>();
			SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
			/* String url1 = CMSPortalUtil.getUrlArticle(listArt.get(0), cat.getCategoryId(), request, themeDisplay.getScopeGroupId());
			String urlImg1 = AttachmentUtil.viewDocumentNew(renderRequest, renderResponse, themeDisplay, listArt.get(0).getImage(), "210x160"); */
			%>
			<div class="page-category-content">
				<div class="news-list">
					<%
				   for(Article art : listArt){ 
					   String urlImg = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, art.getImage(), "210x160");
					   String url = CMSPortalUtil.getUrlArticle(art, cat.getCategoryId(), request, themeDisplay.getScopeGroupId());
				   %>
				   <div class="newsItem">
					   <div class="ItemContent">
						    <%if(!urlImg.equals(srcImgDefault)){ %>
						       	<a href="<%=url%>"><img class="card-category-img" src="<%=urlImg %>" alt=""></a>
					       	<%} %>
					       	<h2>
					       		<a href="<%=url%>"  title="<%=art.getTitle()%>"><%=art.getTitle() %></a>
					       	</h2>
					       	<div class="time">
					       	
					       	</div>
					       	<p class="des"><%=art.getSummary() %></p>
				    	</div>
			        </div>
				   <%} %>
				</div>
			</div>
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>"></liferay-ui:search-paginator>
		<%} %>
	</div>
</div>
<%
	}
%>
<style>
.lfr-pagination-config {
	display: none !important;
}
</style>
<%}
}catch(Exception e){}%>
