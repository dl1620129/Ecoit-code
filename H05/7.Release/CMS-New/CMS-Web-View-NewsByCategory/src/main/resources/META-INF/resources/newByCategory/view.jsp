<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.software.util.CMSPortalUtil"%>
<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.software.cms.service.CategoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.Category"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page pageEncoding="utf-8" %>
<%@ include file="../init.jsp"%>
<%

List<Article> listTinTheoChuyenMuc = (List<Article>)request.getAttribute("listArticleTypeTwo");
List<Article> listNotification = (List<Article>)request.getAttribute("listNotification");
List<Category> listCate = (List<Category>)request.getAttribute("lstCate");
if(listTinTheoChuyenMuc==null) listTinTheoChuyenMuc = new ArrayList<Article>();
String cau_hinh_trang_chi_tiet = (String)request.getAttribute("cau_hinh_trang_chi_tiet");
if(cau_hinh_trang_chi_tiet == null) cau_hinh_trang_chi_tiet="";
String hien_thi_theo_thong_bao = (String)request.getAttribute("hien_thi_theo_thong_bao");
if(hien_thi_theo_thong_bao == null) hien_thi_theo_thong_bao="";
String hien_thi_theo_thong_bao_theo_slide = (String)request.getAttribute("hien_thi_theo_thong_bao_theo_slide");
if(hien_thi_theo_thong_bao_theo_slide == null) hien_thi_theo_thong_bao_theo_slide="";
String hien_thi_theo_dang_tabs = (String)request.getAttribute("hien_thi_theo_dang_tabs");
if(hien_thi_theo_dang_tabs == null) hien_thi_theo_dang_tabs="";
String day_bai_viet_thong_bao_len_menu = (String)request.getAttribute("day_bai_viet_thong_bao_len_menu");
if(day_bai_viet_thong_bao_len_menu == null) day_bai_viet_thong_bao_len_menu="";
String categoryTitle = (String)request.getAttribute("categoryNameTypeTwo");
if(categoryTitle==null) categoryTitle="";
long catId = 0;
List<Category> listCategoryCon = new ArrayList<Category>();
int lengthCatCon = 0;
try{
	catId = Long.valueOf((String)request.getAttribute("categoryIdTypeTwo"));
	listCategoryCon = CategoryLocalServiceUtil.getCategoryHaveParentId(themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), catId);
}catch(Exception e){}
if(listCategoryCon!=null) lengthCatCon = listCategoryCon.size();

int lengthNotification = listNotification!=null?listNotification.size():0;
int lengthTinChuyenMuc = listTinTheoChuyenMuc.size();
String title1 = "";
Article art1 = null;
Article art2 = null;
if(lengthTinChuyenMuc>0) art1 = listTinTheoChuyenMuc.get(0);
if(lengthTinChuyenMuc>1) art2 = listTinTheoChuyenMuc.get(1);
String title2 = "";
String img2 = "";
String url2 = "";
if(art2 != null){
	title2 = art2.getTitle();
	if(art2.getImage() != null && !art2.getImage().equals("")){
		img2 = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, art2.getImage(), "162x110");
	}
	url2 = CMSPortalUtil.getUrlArticle(art2, catId, request, themeDisplay.getScopeGroupId());
}

if(art1!=null) title1 = art1.getTitle();

String img1 = "";
if(art1!=null){
	String imgId = art1.getImage();
    img1 = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, imgId, "162x110");
}

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String summary1 = "";
if(art1!=null) summary1 = StringUtil.shorten(art1.getSummary(), 180);

String url1 = "/";
if(art1!=null){
	url1 = CMSPortalUtil.getUrlArticle(art1, catId, request, themeDisplay.getScopeGroupId());
}
String siteURL="/web"+GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId()).getFriendlyURL();

String urlCat1 = CMSPortalUtil.getURLCategory(catId);


if(cau_hinh_trang_chi_tiet.equals("true")){
%>
<section class="panel panel-hotnews  small-col">
	<header class="panel-heading"><a href='<%=( siteURL+urlCat1)%>'> <%=categoryTitle.toUpperCase() %></a></header>
         <ul class="list-unstyled">
	         <li class="item">
	         	<a href="<%=url1 %>"><img class="img-responsive center-block indeximg" src="<%=img1%>" onerror="this.onerror=null;this.style.display='none';" alt="" >
	      			<%=title1 %>
	      		</a>
	         </li>
	         <%
	         for(int i=1;i<lengthTinChuyenMuc;i++){
	        	 Article art = listTinTheoChuyenMuc.get(i);
				 String url = art.getFriendlyURL();
				 try{
					 PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, themeDisplay.getScopeGroupId(), catId, "CmsView-ChiTietBaiViet");
					 portletURL.setParameter("categoryId", String.valueOf(catId));
					 portletURL.setParameter("urlTitle", art.getFriendlyURL());
					 url = portletURL.toString();
				 }catch(Exception e){}
	         %>
	            <li class="item" style="text-align: justify;">
	               <a href="<%=url%>"><%=art.getTitle() %></a>
	            </li>
	         <%} %>   
         </ul>
   </section>
<%}else if(hien_thi_theo_thong_bao.equals("true")){
	%>
	<div class="latest-news">
		<h2 class="title-line text-uppercase"><span><a href="<%=( siteURL+urlCat1)%>"> <%=categoryTitle.toUpperCase() %></a></span></h2>
		<ul>
           <%
			for(int i=0;i<lengthNotification;i++){
				 Article art = listNotification.get(i);
				String url = art.getFriendlyURL();
				 try{
					 PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, themeDisplay.getScopeGroupId(), catId, "CmsView-ChiTietBaiViet");
					 portletURL.setParameter("categoryId", String.valueOf(catId));
					 portletURL.setParameter("urlTitle", art.getFriendlyURL());
					 url = portletURL.toString();
				 }catch(Exception e){}
			%>
			       <li><a href="<%=url%>" title="<%=art.getTitle()%>"><%=StringUtil.shorten(art.getTitle(), 65) %> </a></li>
			<%}%>
        </ul>
	</div>
<%}else if(hien_thi_theo_thong_bao_theo_slide.equals("true")){
	%>
<section class="section-top-page">
	<div class="row align-items-center">
		<div class="col-lg-12 mb-2 mb-lg-0"> 
			<div class="notification">
				<label><%=LanguageUtil.get(
						themeDisplay.getLocale(),
						"ecoit.asia.cms.label.noti") %></label>
				<div class="d-inline-block">
					<div class="slider-noti">
					<%for (int i = 0; i < lengthNotification; i++) {
						Article art = listNotification.get(i);
						String url = "";
						try {
							PortletURL portletURL = CMSPortalUtil
									.getPortletURLFromFriendURLAndPortletId(
											request,
											themeDisplay.getScopeGroupId(), catId,
											"CmsView-ChiTietBaiViet");
							portletURL.setParameter("categoryId",
									String.valueOf(catId));
							portletURL.setParameter("urlTitle",
									art.getFriendlyURL());
							url = portletURL.toString();
						} catch (Exception e) {
						}
						%>
						<div class="item">
							<a href="<%=url%>"><%=art.getTitle() %></a>
						</div>
					<%} %>
					</div>
					<!-- /.slider-noti -->
				</div>
			</div>
		</div>
		<%-- <div class="col-lg-3">
			<div class="search-top-page">
				<form action="<%="/web"+themeDisplay.getLayout().getGroup().getFriendlyURL()+"/tim-kiem?p_p_id=CmsViewTimKiemBaiViet_WAR_CmsViewEcoITportlet&p_p_lifecycle=0" %>"  method="post" class="form-search-header">
				     <input class="search-ip" type="text" placeholder="<%=LanguageUtil.get(portletConfig,themeDisplay.getLocale(),"ecoit.asia.search.placeholder") %>" name="_CmsViewTimKiemBaiViet_WAR_CmsViewEcoITportlet_keyword" aria-label="Search">
				</form>
			</div>
		</div> --%>
	</div>
</section>
	<%
}else if(hien_thi_theo_dang_tabs.equals("true")){
	%>
	<section class="category-box">
		<div class="header-category">
        	<ul class="main">
        		<%for(int i =0;i<listCate.size();i++){
        			Category category = listCate.get(i); 
        			String UrlCat =  CMSPortalUtil.getURLCategory(category.getCategoryId());%>
        			<li class="<%=i==0?"active":"d-none d-md-block" %>"><a href="<%=siteURL+ UrlCat%>"><%=category.getTitle() %></a></li>
        		<%} %>
        		<li class="dropdown d-md-none">
        			<button class="btn-toggle-submenu"><i class="icon-ellipsis-vertical"></i></button>
        			<ul>
        			<%for(int i =0;i<listCate.size();i++){
	        			Category category = listCate.get(i); 
	        			String UrlCat =  CMSPortalUtil.getURLCategory(category.getCategoryId());%>
	        			<li><a href="<%=siteURL+UrlCat%>"><%=category.getTitle() %></a></li>
	        		<%} %>
        			</ul>
        		</li>
        	</ul>
		</div><!-- /.header-category -->
		<div class="content-category">
			<div class="row">
				<div class="col-lg-8 mb-3 mb-lg-0">
					<div class="card-category">
						<div class="card-category-left">
	                        <div class="effect-2">
	                          <a href="<%=url1 %>" title="<%=title1%>"><img class="card-category-img" src="<%=img1 %>" alt=""></a>
	                        </div>
	                    </div>    
	                    <div class="card-category-right">
	                       <h3 class="card-category-title"><a href="<%=url1 %>"><%=title1%></a></h3>
	                        <div class="card-category-text desc"><%=HtmlUtil.extractText(summary1) %></div>
	                     </div>
					</div><!-- /.card-category -->
				</div>
				
				<div class="col-lg-4">
					<%if(themeDisplay.getLanguageId().equals("en_US")){ %>
						<div>
		                	<h3 class="card-category-title"><a href="<%=url2%>"><%=title2%></a></h3>
						</div>
					<%}else{ %>
						<div class="news-sm-thumbs">
							<div class="img effect-1">
								<a href="<%=url2%>"><img src="<%=img2 %>" alt=""></a>
							</div>
							<div class="text">
		                       <h4><a href="<%=url2%>"><%=title2%></a></h4>
		                    </div>
						</div>
					<%} %>
					<ul class="list-cycle">
						<%
				         for(int i=2;i<lengthTinChuyenMuc;i++){
				        	 Article art = listTinTheoChuyenMuc.get(i);
							 String url = art.getFriendlyURL();
							 try{
								 PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, themeDisplay.getScopeGroupId(), catId, "CmsView-ChiTietBaiViet");
								 portletURL.setParameter("categoryId", String.valueOf(catId));
								 portletURL.setParameter("urlTitle", art.getFriendlyURL());
								 url = portletURL.toString();
							 }catch(Exception e){}
				         %>	 
				          <li><a href="<%=url%>" title="<%=art.getTitle() %>"><%=StringUtil.shorten(art.getTitle(),90) %></a></li>
				         <%}%>
					</ul>
				</div>
			</div>
		</div><!-- /.content-category-->
	</section>
	<%
}else if(day_bai_viet_thong_bao_len_menu.equals("true")){
	StringBuffer stringBuffer = new StringBuffer();
	try{
		stringBuffer.append("<div class=\"notification_marquee\">");
		/* stringBuffer.append("<label style=\"padding: 4px;font-size: 12px;\">"+LanguageUtil.get(portletConfig,themeDisplay.getLocale(),"ecoit.asia.cms.label.noti")+"</label>"); */
		stringBuffer.append("<marquee direction=\"left\" scrollamount=\"3\">");
		for (int i = 0; i < lengthTinChuyenMuc; i++) {
			Article article = listTinTheoChuyenMuc.get(i);
			String url = "";
			try {
				PortletURL portletURL = CMSPortalUtil
						.getPortletURLFromFriendURLAndPortletId(
								request,
								themeDisplay.getScopeGroupId(), catId,
								"CmsView-ChiTietBaiViet");
				portletURL.setParameter("categoryId", String.valueOf(catId));
				portletURL.setParameter("urlTitle",
						article.getFriendlyURL());
				url = portletURL.toString();
			} catch (Exception e) {
			}
			stringBuffer.append("<div class=\"item-marquee\">");
			if(i > 0)stringBuffer.append(" | ");
			stringBuffer.append(article.getTitle());
			
			stringBuffer.append("</div>");
		}
		stringBuffer.append("</marquee>");
		stringBuffer.append("</div>");
	}catch(Exception e){
		
	}
	String idPortlet = "p_p_id_"+PortalUtil.getPortletId(request)+"_";
	%>
	<script>
	document.getElementById('<%=idPortlet%>').style.height = '0';
	var child = document.createElement('div');
	child.innerHTML = '<%=stringBuffer.toString()%>';
	child = child.firstChild;
	document.getElementById("putCaiDMNoti").appendChild(child);
	</script>
	<style>
		.notification_marquee .item-marquee{
			display: inline-block;
			padding-right: 5px;
			color: red;
			font-weight: bold;
			font-size: 1.1em;
		}
		.notification_marquee marquee{
		    margin-top: 6px;
		}
		.section-top-page{
			border: none !important;
		}
	</style>
<%
}else{ %>
<div class="other-article">
	<h3 class="tle inline-block bg-tle">
		<img src="/o/portal-h05-bca-theme/images/logo/logo.png" style="height: 30px;" alt="">
		<span  class="text-white"><a href="<%=(siteURL+urlCat1)%>"><%=categoryTitle.toUpperCase() %></a></span>
	</h3>
	<div class="box-tin bo-topdo row">
		<div class="col-md-8">
			<a href="<%=url1 %>" title="<%=title1 %>"> 
				<img class="card-info-img" src="<%=img1 %>" alt="<%=title1 %>">
			</a>
			<div class="pt-3">
				<h4  class="text-justify mt-0">
					<a href="<%=url1 %>"><%=title1 %></a>
				</h4>
				<p class="text-tomtat">
					<%=summary1 %>
				</p>
			</div>
		</div>
		<div class="col-md-4">
			<ul class="list-unstyled">
				<%
		        for(int i=1;i<lengthTinChuyenMuc;i++){
		       	 Article art = listTinTheoChuyenMuc.get(i);
				 String url = CMSPortalUtil.getUrlArticle(art, catId, request, themeDisplay.getScopeGroupId());
				 String img = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, art.getImage(), "162x110");
				 /* try{
					 PortletURL portletURL = CMSPortalUtil.getPortletURLFromFriendURLAndPortletId(request, themeDisplay.getScopeGroupId(), catId, "com_view_article_detail_DetailControllerPortlet");
					 portletURL.setParameter("categoryId", String.valueOf(catId));
					 portletURL.setParameter("urlTitle", art.getFriendlyURL());
					 url = portletURL.toString();
				 }catch(Exception e){} */
				 
		        %>	 
		         <li>
		         	<a class="ls-title-or" href="<%=url%>" title="<%=art.getTitle() %>">
		         		<img alt="<%=art.getTitle() %>" src="<%=img%>">
		         		<%=StringUtil.shorten(art.getTitle(),90) %>
		         	</a>
		         </li>
		        <%}%>
			</ul>
		</div>
	</div>
</div>
<style>
.other-article .ls-title-or{
	display: flex;
	color: #000000;
    font-weight: 500;
    font-size: 15px;
}
.other-article .ls-title-or img{
	width: 100px;
    margin-right: 10px;
}
@media only screen and (min-width: 768px){
.other-content .card-info .photo .card-info-img{
	height: auto !important;
}
.card-info-img{
 	max-height: 100%;
 	padding: 0;
}

</style>
 <%}%>