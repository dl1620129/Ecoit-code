<%@page import="com.software.cms.service.CategoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.Category"%>
<%@page import="com.software.cms.service.CategoryArticleLocalServiceUtil"%>
<%@page import="com.software.cms.model.CategoryArticle"%>
<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.software.util.CMSPortalUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="init.jsp"%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
List<Article> listTinMoiNhat = (List<Article>)request.getAttribute("listTinMoiNhat");
List<Article> listTinNoiBat = (List<Article>)request.getAttribute("listTinNoiBat");
try{
long groupId = themeDisplay.getScopeGroupId();
%>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
    <%
    	if((listTinNoiBat != null && listTinNoiBat.size() > 0)){ 
    	for(int i=0;i< listTinNoiBat.size();i++){
        	String url = "";
    			try{
    				url = CMSPortalUtil.getUrlArticle(listTinNoiBat.get(i), 0, request, groupId);
    			}catch(Exception e){
    				url = "";
    			}
        		List<CategoryArticle> listCategory = CategoryArticleLocalServiceUtil.getCategoryOfArticle(listTinNoiBat.get(i).getArticleId());
	        	String categoryName = "";
	        	if (listCategory != null && listCategory.size()>0){
	        		categoryName = CategoryLocalServiceUtil.getCategory(listCategory.get(0).getCategoryId()).getTitle();
	        	}
        		String imageId = listTinNoiBat.get(i).getImage();
	        	String title = listTinNoiBat.get(i).getTitle();
	        	String summary = listTinNoiBat.get(i).getSummary();
	        	String ngayXuatBan = "";
	        	if (listTinNoiBat.get(i).getPublishedDateFrom() != null){
	        		ngayXuatBan = sdf.format(listTinNoiBat.get(i).getPublishedDateFrom());
	        	}
	        	
	        	String urlImg = "";
	        	if(!imageId.equals("")){
        		 	try{
	         	    	urlImg = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, imageId, "356x242");
	         	    }
	         		catch(Exception ex){
	         			urlImg = renderRequest.getContextPath()+ "/image/noimage.png";
	         		}
	        	}
	        	else   urlImg=renderRequest.getContextPath()+ "/image/noimage.png";
	        	String classActive = (i == 0) ? "active" : "";
	        		%>
	        		<div class="carousel-item <%=classActive %>">
				       <img src="<%=urlImg %>" alt="<%=title %>" class="d-block w-100">
				       <div class="carousel-caption">
				          <h3 class="title"><a href="<%=url%>"><%=title %></a></h3>
				          <div class="category">
				          	<a href="<%=url%>"><%=categoryName %></a>
				          </div>
				          <div class="publishingdate">
				          	<%=ngayXuatBan %>
				          </div>
				        </div>
				    </div>
	        		<% 
        	}
    }%>
  	</div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" data-slide="next">
     <span class="carousel-control-next-icon"></span>
    </a>
</div>
<%
}catch(Exception e){
	%>
	<div class="alert error">
		Xin lỗi, Hiện chưa có bài viết nào!
	</div>
	<%
}
%>

<script>
$(document).ready(function($) {
	$("#myCarousel").carousel();
});

</script>