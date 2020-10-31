<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.software.cms.article.portlet.ConfigUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.software.cms.service.CategoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.Category"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.software.util.NewsWorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />

<%
String type = GetterUtil.getString(portletPreferences.getValue("type",""));
long status = NewsWorkflowConstants.STATUS_DRAFT;
if (type.equals(ConfigUtil.BAI_VIET_NHAP)) status = NewsWorkflowConstants.STATUS_DRAFT;
if (type.equals(ConfigUtil.BAI_VIET_CHO_DUYET)) status = NewsWorkflowConstants.STATUS_PENDING;
if (type.equals(ConfigUtil.BAI_VIET_DA_DUYET)) status = NewsWorkflowConstants.STATUS_APPROVED;
if (type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)) status = NewsWorkflowConstants.STATUS_PUBLISH;
if (type.equals(ConfigUtil.BAI_VIET_HUY_DUYET)) status = NewsWorkflowConstants.STATUS_APPROVE_DENIED;
if (type.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN)) status = NewsWorkflowConstants.STATUS_PUBLISH_DENIED;
PortletURL portletURL = renderResponse.createRenderURL();
int delta = 20, count = 0, cur = 1, totalRecord = 0;
cur = ParamUtil.getInteger(request, "cur", 1);
delta = ParamUtil.getInteger(request, "delta", 20); 
String keyword = HtmlUtil.escape(ParamUtil.getString(request, "keyword",""));
long categoryId = ParamUtil.getLong(request, "category",-1);
String eventNames = HtmlUtil.escape(ParamUtil.getString(request, "eventname",""));
String tagNames = HtmlUtil.escape(ParamUtil.getString(request, "tagname",""));
boolean inTitle = ParamUtil.getBoolean(request, "title",false);
boolean inSummary = ParamUtil.getBoolean(request, "summary",false);
boolean inContent = ParamUtil.getBoolean(request, "content",false);
boolean inDate = ParamUtil.getBoolean(request,"date",false);
boolean inAuthor = ParamUtil.getBoolean(request,"inAuthor",false);
boolean userKiemDuyet = ParamUtil.getBoolean(request,"userKiemDuyet",false);

String strDateFrom = ParamUtil.getString(request, "date-from","");
String strDateTo = ParamUtil.getString(request, "date-to","");
DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
Date fromDate = null,toDate = null;
if(strDateFrom!=null && strDateFrom!=""){		
	fromDate = df.parse(strDateFrom);
}
if(strDateTo!=null && strDateTo!=""){				
	toDate = df.parse(strDateTo);	
}

portletURL.addProperty("category", String.valueOf(categoryId));
portletURL.addProperty("event", eventNames);
portletURL.addProperty("tag", tagNames);
portletURL.addProperty("keyword", keyword);
portletURL.addProperty("title", String.valueOf(inTitle));
portletURL.addProperty("summary", String.valueOf(inSummary));
portletURL.addProperty("content", String.valueOf(inContent));
portletURL.addProperty("date", String.valueOf(inDate));
portletURL.addProperty("inAuthor", String.valueOf(inAuthor));
portletURL.addProperty("userKiemDuyet", String.valueOf(userKiemDuyet));
portletURL.addProperty("date-from", strDateFrom);
portletURL.addProperty("date-to", strDateTo);
long groupId = themeDisplay.getScopeGroupId();
String language = themeDisplay.getLanguageId();
long userId = themeDisplay.getUserId();
%>
<c:if test='<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_ADD, themeDisplay.getScopeGroupId())%>'>
	<portlet:renderURL var="editArticle">
		<portlet:param name="mvcPath" value="/article/edit_Article.jsp" />
		<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
	</portlet:renderURL>
	<aui:button-row>
		<aui:button cssClass="btn btn-primary fl-right" icon="icon-plus" value="Thêm mới bài viết" onClick="document.location='${editArticle}'" ></aui:button>
	</aui:button-row>
</c:if>
<aui:fieldset>
<aui:fieldset-group>
	<h3 class="sheet-subtitle">Tìm kiếm</h3>
	<aui:form action="<%=portletURL.toString() %>" method="POST">
		<aui:row>
			<aui:col md="4" >
				<aui:input id="search" type="text" name="keyword" value="<%=HtmlUtil.extractText(ParamUtil.getString(request, "keyword","")) %>" placeholder="Từ khóa" label="" />	
			</aui:col>
	  	</aui:row>
	  	<aui:row>
	  		<aui:col>
	      		<aui:button icon="icon-search" type="submit" value="Tìm kiếm" />
	   		</aui:col>
	  	</aui:row>
	</aui:form>
</aui:fieldset-group>
</aui:fieldset>
<%
totalRecord = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, status, categoryId, eventNames, tagNames, keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate, inAuthor, userKiemDuyet);
int totalPage = (totalRecord  % delta == 0)?  totalRecord /delta : totalRecord /delta+1;
if (totalRecord  == 0) totalPage = 0;
int start = delta*(cur-1);
int end = delta*cur;
if (end > totalRecord ) end = totalRecord ;
List<Article> lstArticles = ArticleLocalServiceUtil.findByUserNews(groupId, language, userId, status, categoryId, eventNames, tagNames, keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate, inAuthor, userKiemDuyet, start, end);
SearchContainer searchContainerArt = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, "Không có dữ liệu!");
searchContainerArt.setResults(lstArticles);
searchContainerArt.setTotal(totalRecord);
SimpleDateFormat format_time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
%>
<aui:fieldset>
	<aui:fieldset-group>
		<h3 class="sheet-subtitle">Kết quả</h3>
		<aui:row>
			<aui:col md="12">
				<liferay-ui:search-container searchContainer="<%=searchContainerArt %>" >
					<liferay-ui:search-container-row className="com.software.cms.model.Article"
					 keyProperty="articleId"
					 modelVar="article">
						<liferay-ui:search-container-column-text
							name="STT" cssClass=" w5"
							value="<%= Integer.toString(searchContainer.getStart() + (++count))%>">
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Mã bài viết" cssClass="tex-center w5"
							property="articleId">
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Người tạo tin" cssClass="w5">
						    <% 							
						        if(article.getCreatedByUser() > 0){ 
						        	try{
						        		out.print(UserLocalServiceUtil.getUser(article.getCreatedByUser()).getScreenName());
				        			}catch(Exception e){}
						       }
						       %>       	
					    </liferay-ui:search-container-column-text>	
					    <liferay-ui:search-container-column-text name="Nguồn bài viết " cssClass="w10">
							<div class="white-space ">
							 <% 							
						        if(!article.getAuthor().equals("")){ 
						        	out.print(""+article.getAuthor()+"<br/>");
						       }
						    	if(!article.getSource().equals("")){ 
						         	out.print(""+article.getSource());
						       }
						       %> 
							</div>
				    	</liferay-ui:search-container-column-text>	
				    	 <c:if test='<%=type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN) %>'>
							<liferay-ui:search-container-column-text name="Người kiểm duyệt" cssClass="w5">
					        		<%
					        		if(article.getPublishedByUser() > 0){
					        			try{
					        				out.print(UserLocalServiceUtil.getUser(article.getPublishedByUser()).getScreenName());
					        			}catch(Exception e){}
					        		}
					        		%>
					        </liferay-ui:search-container-column-text>
					     </c:if>		
				    	<liferay-ui:search-container-column-text cssClass="tex-center  w10" name="Hình ảnh">
				        	<img src="<%=AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, article.getImage(), "80x60") %>" style="width:90px ;height:70px" />
				        </liferay-ui:search-container-column-text>
				    	<liferay-ui:search-container-column-text name="Tiêu đề" cssClass="w25">
						<liferay-portlet:renderURL var="previewArticle" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
							<liferay-portlet:param name="mvcPath" value="/article/preview_article.jsp"/>
							<liferay-portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
							<liferay-portlet:param name="articleId" value="${article.getArticleId()}"/>
						</liferay-portlet:renderURL>
		         			<%
								String preview = "Viewpre"+article.getArticleId();
							%>
		        			<b><aui:a href="javascript:;" id="<%=preview %>"><%= article.getTitle() %></aui:a></b>
		        			<aui:script>
		        			 AUI().use('aui-base',
		        			 			'aui-io-plugin-deprecated',
		        			 			'liferay-util-window',
		        			 			'liferay-portlet-url',
		        			 			'aui-dialog-iframe-deprecated',
		        			 			 function(A) {
		        			 			 	A.one('#<portlet:namespace />Viewpre<%=article.getArticleId()%>').on('click', function(event){
		        			 			 		 var url = '${previewArticle.toString()}';
		        			 			 		 var popUpWindow = Liferay.Util.Window.getWindow({
		        			 			 		 		dialog: {
                                                                    centered : true,
                                                                    constrain2view : true,
                                                                    modal : true,
                                                                    resizable : false,
                                                                    width : 800,
                                                                    destroyOnClose:true
                                                                },
                                                                id : '<portlet:namespace/>dialogPreviewArticle'
		        			 			 		 }).plug(
													A.Plugin.DialogIframe,
													{
                                                            autoLoad : false,
                                                            iframeCssClass : 'dialog-iframe',
                                                            uri : url.toString()
                                                        }).render();
                                                popUpWindow.show();
                                           	 	popUpWindow.titleNode.html("Xem trước bài viết");
                                            	  
		        			 			 	});
		        			 			 }
		        			 			);
		        			 			
		        			</aui:script>
		        			
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Chuyên mục" cssClass="w10"> 
				        	<%
				        		List<Category> categories = CategoryLocalServiceUtil.searchByArticle(article.getArticleId());
				        		for(Category category:categories){
				        	%>
				        	<%=category.getTitle() %><br/>
				        	<%}%>
				        </liferay-ui:search-container-column-text>
				        <c:if test='<%=(type.equals(ConfigUtil.BAI_VIET_CHO_DUYET) || type.equals(ConfigUtil.BAI_VIET_NHAP)) %>'>
							<liferay-ui:search-container-column-text cssClass="tex-center w10" name="Ngày viết bài">
					        	<i> <% 							
					          			if(article.getCreatedDate()!=null){ 
					          				out.print(format_time.format(article.getCreatedDate()));
					          			}else{
					          				out.print("---");
					          			}
					          		%> </i>        	
				        	</liferay-ui:search-container-column-text>		
						</c:if>
						<c:if test='<%=type.equals(ConfigUtil.BAI_VIET_CHO_DUYET) %>'>
							<liferay-ui:search-container-column-text cssClass="tex-center w10" name="Ngày gửi chờ duyệt">
				        		<i> <% 							
				          			if(article.getPendingDate()!=null){ 
				          				out.print(format_time.format(article.getPendingDate()));
				          			}else{
				          				out.print("---");
				          			}
				          		%> </i>        	
			        		</liferay-ui:search-container-column-text>	
						</c:if>
						<c:if test='<%=type.equals(ConfigUtil.BAI_VIET_DA_DUYET) %>'>
							<liferay-ui:search-container-column-text cssClass="tex-center w10" name="Ngày duyệt">
					        	<i> <% 							
					          			if(article.getApprovedDate()!=null){ 
					          				out.print(format_time.format(article.getApprovedDate()));
					          			}else{
					          				out.print("---");
					          			}
					          		%> </i>        	
				        	</liferay-ui:search-container-column-text>			
						</c:if>
						<c:if test='<%=type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN) %>'>
							<liferay-ui:search-container-column-text cssClass="tex-center w10" name="Ngày xuất bản">
					        	<i> <% 							
					          			if(article.getPublishedDateFrom()!=null){ 
					          				out.print(format_time.format(article.getPublishedDateFrom()));
					          			}else{
					          				out.print("---");
					          			}
					          		%> </i>        	
				        	</liferay-ui:search-container-column-text>			
				        	<liferay-ui:search-container-column-text cssClass="tex-center w5" name="Lượt người xem">
					        	<i>
					        		<%
					        		out.print(article.getViewCount());
					        		%>
					        	</i>
				        	</liferay-ui:search-container-column-text>
						</c:if>
						<c:if test='<%=type.equals(ConfigUtil.BAI_VIET_HUY_DUYET) %>'>
							<liferay-ui:search-container-column-text cssClass="tex-center w10" name="Ngày hủy duyệt">
					        	<i> <% 							
					          			if(article.getModifiedDate()!=null){ 
					          				out.print(format_time.format(article.getModifiedDate()));
					          			}else{
					          				out.print("---");
					          			}
					          		%> </i>        	
				        	</liferay-ui:search-container-column-text>			
						</c:if>
						<c:if test='<%=type.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN) %>'>
							<liferay-ui:search-container-column-text cssClass="tex-center w10" name="Ngày hủy xuất bản">
					        	<i> <% 							
					          			if(article.getModifiedDate()!=null){ 
					          				out.print(format_time.format(article.getModifiedDate()));
					          			}else{
					          				out.print("---");
					          			}
					          		%> </i>        	
				        	</liferay-ui:search-container-column-text>			
						</c:if>
				        <liferay-ui:search-container-column-text name="Hành động" cssClass="w15">
				        	<portlet:renderURL var="editArticle">
								<portlet:param name="mvcPath" value="/article/edit_Article.jsp" />
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:renderURL>
							<portlet:actionURL var="pendingArticle" name="pendingArticle">
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:actionURL>
							<portlet:actionURL var="approvedArticle" name="approvedArticle">
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:actionURL>
							<portlet:actionURL var="publishArticle" name="publishArticle">
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:actionURL>
							<portlet:actionURL var="deniedApproveArticle" name="deniedApproveArticle">
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:actionURL>
							<portlet:actionURL var="deniedPublishArticle" name="deniedPublishArticle">
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:actionURL>
							<portlet:actionURL var="removeArticle" name="removeArticle">
								<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
								<portlet:param name="articleId" value="${article.getArticleId()}"/>
							</portlet:actionURL>
							<liferay-ui:icon-menu>
								<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId()) %>'>
									<liferay-ui:icon image="edit" message="Chỉnh sửa" url="${editArticle}" />
								</c:if>
								<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId())  && type.equals(ConfigUtil.BAI_VIET_NHAP)  %>'>
									<liferay-ui:icon image="post" message="Gửi duyệt" url="${pendingArticle}" />
								</c:if>
								<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId()) && (type.equals(ConfigUtil.BAI_VIET_CHO_DUYET) || type.equals(ConfigUtil.BAI_VIET_HUY_DUYET) )%>'>
									<liferay-ui:icon image="checked" message="Duyệt" url="${approvedArticle.toString()}" />
								</c:if>
								<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId()) && !type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN)  %>'>
									<liferay-ui:icon image="activate" message="Xuất bản" url="${publishArticle}" />
								</c:if>
								<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId()) && type.equals(ConfigUtil.BAI_VIET_DA_DUYET) %>'>
									<liferay-ui:icon image="lock" message="Hủy duyệt" url="${deniedApproveArticle}" />
								</c:if>
								<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId()) && type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN) %>'>
									<liferay-ui:icon image="deactivate" message="Hủy xuất bản" url="${deniedPublishArticle}" />
								</c:if>
								<%
									String previewArt = "ViewArt"+article.getArticleId();
								%>
								<liferay-ui:icon id="<%=previewArt %>" image="search" message="Xem trước" url="javascript:;" />
								<aui:script>
									AUI().use('aui-base',
												'aui-io-plugin-deprecated',
												'liferay-util-window',
												'liferay-portlet-url',
												'aui-dialog-iframe-deprecated',
												 function(A) {
												 	A.one('#<portlet:namespace />ViewArt<%=article.getArticleId()%>').on('click', function(event){
													
													var url = '${previewArticle.toString()}';
													var popUpWindow = Liferay.Util.Window.getWindow({
															dialog: {
									                             centered : true,
									                             constrain2view : true,
									                             modal : true,
									                             resizable : false,
									                             width : 800,
									                             destroyOnClose:true
									                         },
									                         id : '<portlet:namespace/>dialogPreviewArticle'
									 			 		 }).plug(
														A.Plugin.DialogIframe,
														{
									                        autoLoad : false,
									                        iframeCssClass : 'dialog-iframe',
									                        uri : url.toString()
									                    }).render();
									                    popUpWindow.show();
									               	 	popUpWindow.titleNode.html("Xem trước bài viết");
									                               	  
									 			 	});
									 			 }
									 			);
									</aui:script>
							<c:if test='<%=PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), article.getArticleId()) && PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_REMOVE, groupId) %>'>
								<liferay-ui:icon-delete image="delete" message="Xóa" url="${removeArticle}" />
							</c:if>
							</liferay-ui:icon-menu>
				        </liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</aui:col>
		</aui:row>
	</aui:fieldset-group>
</aui:fieldset>
<style>
.white-space{
	overflow: hidden;
    width: 110px;
}
</style>
<aui:script use="aui-base">

</aui:script>