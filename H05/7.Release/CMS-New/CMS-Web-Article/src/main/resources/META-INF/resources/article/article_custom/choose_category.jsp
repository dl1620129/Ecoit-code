<%@page import="com.web.util.TreeCategory"%>
<%@page import="com.software.cms.service.GroupCategoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.GroupCategory"%>
<%@page import="com.software.cms.service.CategoryArticleLocalServiceUtil"%>
<%@ include file="../../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />

<%
long cate_articleId = ParamUtil.getLong(request, "articleId", -1);
Article article_cate = null;
if(cate_articleId > 0)article_cate = ArticleLocalServiceUtil.getArticle(cate_articleId);
else article_cate = ArticleLocalServiceUtil.create();
if(renderRequest.getAttribute("article") != null){
	article_cate = (Article) renderRequest.getAttribute("article");
}
long userKiemDuyetId = article_cate.getPendingByUser();
List<Long> list_cates=new ArrayList<Long>();
	try{
		list_cates = CategoryArticleLocalServiceUtil.getCategoryOfArticleWithId(cate_articleId);
}catch(Exception e1){
	list_cates=new ArrayList<Long>();
}
if(renderRequest.getAttribute("listCatesFalse")!=null && renderRequest.getAttribute("rsValidArticle")!=null && renderRequest.getAttribute("rsValidArticle").toString().equals("true")){		 					 			
	list_cates = (List<Long>)renderRequest.getAttribute("listCatesFalse");		 			
}
String selected="";
if(list_cates!=null && list_cates.size()>0){
	for(int k=0;k<list_cates.size();k++){
		if(selected.equals(""))selected=list_cates.get(k)+"";
		else selected+=","+list_cates.get(k);
	}
	
}
List<GroupCategory> result=GroupCategoryLocalServiceUtil.getByUserIdAndGroupId(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
String showCategory="";
if(result!=null && result.size()>0){
	for(int k=0;k<result.size();k++){
		if(showCategory.equals(""))showCategory=result.get(k).getCategoryId()+"";
		else showCategory+=","+result.get(k).getCategoryId();
	}
	
}    

%>
<aui:row>
	<aui:col>
		<h3 class="sheet-subtitle"><i class="icon-list-alt"></i> Chuyên mục</h3>
		<div id="div_category" style="overflow: auto;height: 300px;">
			<%
			try{
				out.print(new TreeCategory().createCategoryTree(new long[]{0}, themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), selected,showCategory,  1,renderRequest,renderResponse));
			}catch(Exception e1){}
			%>
		</div>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col>
		<h3 class="sheet-subtitle"><i class="icon-group"></i> Người kiểm duyệt</h3>
		<div>
			<%
			String sqlUserCate = " SELECT B.userid FROM soft_cms_groupcategory A "+
									 " INNER JOIN soft_cms_groupuserusers B ON A.groupuserid=B.groupuserid "+
									 "	WHERE B.groupid = "+themeDisplay.getScopeGroupId();
			if(!showCategory.equals(""))sqlUserCate += " AND A.categoryId in ("+showCategory+") ";
			sqlUserCate += " AND  B.userId != "+themeDisplay.getUserId()+" "+
									 "	GROUP BY B.userid,B.groupId";
			List<Object> lstobj = ArticleLocalServiceUtil.getDuLieuTheoSql(sqlUserCate);
			%>
			<aui:select label="" name="chonNguoiKiemDuyet">
				<aui:option value="-1">Chọn người kiểm duyệt</aui:option>
				<%for(Object object : lstobj){ 
					long userId = 0;
					String userName = "";
					try{
						User user2 = UserLocalServiceUtil.getUser(Long.valueOf(object.toString()));
						userId = user2.getUserId();
						userName = user2.getFirstName();
				%>
				<option value="<%=userId%>" ><%=userName %></option>
					<%}catch(Exception e){}
				} %>
			</aui:select>
		</div>
	</aui:col>
</aui:row>