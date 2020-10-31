<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script>
	document.title = "Send Mail to You";
</script>
<%
	long articleId = ParamUtil.getLong(request, "articleId");
	long cat = ParamUtil.getLong(request, "cat");
	String link = ParamUtil.getString(request, "link", "#");
	System.out.println(articleId+" - "+cat);
	String closeWTab = ParamUtil.getString(request, "closeWTab", "");
	System.out.println(closeWTab);
	if(articleId > 0){
		Article art = ArticleLocalServiceUtil.getArticle(articleId);
		if(art != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
%>
<liferay-ui:success key="SENDMAIL_OK" message="Gửi mail tới bạn thành công"/>
<portlet:actionURL var="ActionSendMail" name="ActionSendMail">
	<portlet:param name="articleId" value="<%=String.valueOf(articleId)%>" />
	<portlet:param name="cateId" value="<%=String.valueOf(cat)%>" />
	<portlet:param name="linkBaiViet" value="<%=link%>" />
	<portlet:param name="Link" value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:actionURL>
<form class="well" action="${ActionSendMail }" method="POST">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label>Người gửi: <b><span class="red">*</span></b></label>
                        <input class="form-control" name="<portlet:namespace/>nguoiGui" required="required" style="background: #fff !important;">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label>Email người gửi: <b><span class="red">*</span></b></label>
                        <input class="form-control" name="<portlet:namespace/>mailNguoiGui" type="email" required="required" style="background: #fff !important;">
                    </div>
                </div>
                <div class="col-md-12">
                	<div class="form-group">
		                <label>Người nhận: <b><span class="red">*</span></b></label>
		                <input type="text" class="form-control" label="" required="required" name="<portlet:namespace/>nguoiNhan" style="width: 100%;background: #fff !important;"></input>
		            </div>
                </div>
                <div class="col-md-12">
                	<div class="form-group">
		                <label>Email người nhận: <b><span class="red">*</span></b></label>
		                <input type="text" class="form-control" label="" required="required" name="<portlet:namespace/>mailNguoiNhan" style="width: 100%;background: #fff !important;"></input>
		            </div>
                </div>
                <div class="col-md-12">
                	<div class="form-group">
		                <label>Tiêu đề: <b><span class="red">*</span></b></label>
		                <input type="text" class="form-control" label="" required="required" name="<portlet:namespace/>tieuDe" style="width: 100%;background: #fff !important;"></input>
		            </div>
                </div>
                <div class="col-md-12">
                	<div class="form-group">
		                <label>Địa chỉ trang:</label>
		                <p><%=link%></p>
		            </div>
                </div>
                 <div class="col-md-12">
                	<div class="form-group">
		                <label>Nội dung: <b><span class="red">*</span></b></label>
		                <textarea class="form-control" name="<portlet:namespace/>noiDung" required="required" rows="4" style="height: 70px !important;background: #fff !important;"></textarea>
		            </div>
                </div>
                <div class="col-md-12">
                	<button type="submit" class="btn btn-primary">Gửi</button>
		            <button type="reset" onclick="window.close();" class="btn btn-default">Hủy</button>
                </div>
            </div>
        </form>
<%if(!closeWTab.equals("")){ %>
	<script> 
		setTimeout (function() {window.close();},2000);
	</script>
<%} %>        
<style>
.red{
	color: red;
}
</style>
<%}}%>