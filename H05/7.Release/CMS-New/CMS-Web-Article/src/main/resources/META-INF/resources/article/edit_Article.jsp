<%@page import="java.util.Date"%>
<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.software.util.NewsWorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<%
	long articleId = ParamUtil.getLong(request, "articleId", -1);
	Article article = null;
	if(articleId > 0)article = ArticleLocalServiceUtil.getArticle(articleId);
	else{
		article = ArticleLocalServiceUtil.create();
		article.setStatus(NewsWorkflowConstants.STATUS_NOT_CREATE);
	}
	if(renderRequest.getAttribute("article") != null){
		 article = (Article) request.getAttribute("article");
	}
	String backUrl = ParamUtil.getString(request, "backURL");
	if(renderRequest.getAttribute("rsValidArticle")!=null && renderRequest.getAttribute("rsValidArticle").toString().equals("true")){
		backUrl = (String)request.getAttribute("backUrlFalse");		
	}
	String imageIds = "";
	try{imageIds =(String)request.getAttribute("imageId");	}catch(Exception a){ imageIds = "";}
	String imageId = article.getImage();
%>
<portlet:actionURL name="editArticle" var="editArticle">
	<portlet:param name = "currentURL" value="${themeDisplay.getURLCurrent()}"/>
	<portlet:param name="backURL" value="<%= backUrl %>"/>
</portlet:actionURL>
<portlet:actionURL var="deniedApproveArticle" name="deniedApproveArticle">
	<portlet:param name="backURL" value="<%= backUrl %>"/>
	<portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>"/>
</portlet:actionURL>
<portlet:actionURL var="deniedPublishArticle" name="deniedPublishArticle">
	<portlet:param name="backURL" value="<%= backUrl %>"/>
	<portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>"/>
</portlet:actionURL>
<div id="editor-article-js">
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle"><i class="icon-file-alt"></i> Thông tin bài viết <a style="float: right;" href="javascript:openFullScreen();" title="Toàn màn hình (F12)"><i class="icon-resize-full"></i></a></h3>
				<aui:form name="root" action="${editArticle}" method="POST" enctype="multipart/form-data">
					<aui:row>
						<input type="hidden" name="<portlet:namespace/>backURL" value="<%= backUrl %>" />
						<input type="hidden" name="<portlet:namespace/>articleId" value="<%= article.getArticleId() %>"/>
							<aui:col md="8">
								<aui:row>
									<aui:col>
										<liferay-ui:error key="title-is-required" message="ecoit.cms.manage.article.error.title" />	
										<aui:input label="Tiêu đề" name="title" type="textarea" required="<%=true %>" value="<%=HtmlUtil.extractText(article.getTitle()) %>">
											<aui:validator name="maxLength" errorMessage="Không được nhập quá 500 ký tự">501</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col>
										<aui:input label="Tóm tắt" name="summary" type="textarea" value="<%=HtmlUtil.extractText(article.getSummary()) %>">
											<aui:validator name="maxLength" errorMessage="Không được nhập quá 500 ký tự">501</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>	
								<aui:row>
									<aui:col>
										<liferay-ui:error key="content-is-required" message="Vui lòng nhập nội dung" />
										<liferay-ui:input-editor  contents="Nội dung" name="content" initMethod="initEditorContent" />
										<script type="text/javascript">
											function <portlet:namespace />initEditorContent() { return "<%= UnicodeFormatter.toString(article.getContent()) %>"; }
										</script>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col md="6">
										<c:choose>
											<c:when test="<%=!article.getImage().equals("") && !article.getImage().equals("0") %>">
											<portlet:actionURL name="removeImage" var="removeImage">
												<portlet:param name="backURL" value="${themeDisplay.getURLCurrent()}"/>
												<portlet:param name="urlBack" value="<%=backUrl %>"/>
											</portlet:actionURL>
												<div class="box-image pos-re">
													<div class="">
														<img src="<%=AttachmentUtil.getURLImage(renderRequest, renderResponse, themeDisplay, article.getImage()) %>" height="80px" border="1" width="80px" />
														<input type="hidden" name="<portlet:namespace/>image" value="<%=imageId%>">
														<div class="pos-asb">
															<a href="${removeImage}&<portlet:namespace/>articleId=<%=article.getArticleId() %>&<portlet:namespace/>imageId=<%=imageId%>" title="Xóa ảnh"><i class="icon-remove-sign"></i></a>
														</div>
													</div>
												
												</div>
											</c:when>
											<c:otherwise>
												<aui:input type="file" name="images" onChange="checkfileDinhKemPic(this);" label="Ảnh đại diện" accept="image/*" ></aui:input>
												<input type="hidden" name="<portlet:namespace/>marks" value="1" />
												<span id="error_width_image" style="color: red"></span>
												<div id="uploadPreview" style="text-align: center;display: none;" ></div>
												<script type="text/javascript">
													var idIma;
													var validExts = new Array(".jpg", ".png",".jpeg",".gif");
													function checkfileDinhKemPic(sender) {
													    var fileExt = sender.value;
													    idIma = sender.id;
													    if(fileExt != ''){
													    	pathFile = fileExt;
													    	fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
													        if (validExts.indexOf(fileExt.toLowerCase()) < 0) {
													          alert("Không đúng định dạng " +
													                   validExts.toString());
													          sender.value='';
													          jQuery('#uploadPreview').css("display","none");
													          return false;
													        } else {
													       		var totalSize = sender.files[0].size;
													        	var fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
													        	fSize = totalSize; i=0;while(fSize>900){fSize/=1024;i++;}
													    		var total = (Math.round(fSize*100)/100);
													    		if(fSExt[i] == 'MB'){
													    			if(total >= 3){
													    				alert("File đính kèm ảnh không được quá 3 Mb");
													    				sender.value='';
													    				sender.focus();
													    				jQuery('#uploadPreview').css("display","none");
													    				return false;
													    			}else{
													    				var F = sender.files;
																	    if(F && F[0]) for(var i=0; i<F.length; i++) readImage( F[i]);
													    			}
													    		}else{
													    			var F = sender.files;
																    if(F && F[0]) for(var i=0; i<F.length; i++) readImage( F[i]);
													    		}
													        }
													    }
													}
														function readImage(file) {
														    var reader = new FileReader();
														    var image  = new Image();
														    reader.readAsDataURL(file);  
														    reader.onload = function(_file) {
														        image.src    = _file.target.result;              // url.createObjectURL(file);
														        image.onload = function() {
														            var w = this.width,
														                h = this.height,
														                t = file.type,                           // ext only: // file.type.split('/')[1],
														                n = file.name,
														                s = ~~(file.size/1024) +'KB';
														            if(w < 100){
														            	jQuery("#error_width_image").html('Kích thước ảnh không hợp lệ width >= 656');
														            	jQuery('#uploadPreview').html('');
														            }else{
														            	jQuery('#uploadPreview').css("display","block");
														            	jQuery('#uploadPreview').html('<img src="'+ this.src +'" style="width: 300px;height:auto"/>');
														            }
														            
														        };
														        image.onerror= function() {
														        	document.getElementById(idIma).value= "";
														           alert("Không đúng định dạng "+validExts.toString());
														        };      
														    };
													    
														}
													</script>
											</c:otherwise>
										</c:choose>
									</aui:col>
									<aui:col md="6">
										<aui:input name="images-description" label="Chú thích ảnh" type="text">
											<aui:validator name="maxLength" errorMessage="Không được nhập quá 300 ký tự">301</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>	
								<aui:row>
									<aui:col md="6">
										<aui:input label="Tác giả" name="author" value="<%=HtmlUtil.extractText(article.getAuthor()) %>">
											<aui:validator name="maxLength" errorMessage="Không được nhập quá 300 ký tự">301</aui:validator>
										</aui:input>
									</aui:col>
									<aui:col md="6">
										<%-- <aui:input label="Nguồn bài viết" name="source"></aui:input> --%>
										<%@ include file="article_custom/choose_source.jsp" %>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col>
										<aui:input label="Hẹn giờ xuất bản" cssClass="henGio" type="checkbox" name="henGio"></aui:input>
										<div id="box_henGio" style="display: none">
											<aui:input cssClass="date-time-art" type="text" name="thoiGianHenGio" id="thoiGianHenGio" label=""></aui:input>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<%
									  if(article.getStatus()== NewsWorkflowConstants.STATUS_APPROVED || article.getStatus()==NewsWorkflowConstants.STATUS_PUBLISH_DENIED){
									%> 
										<aui:col>
											<h4 class="sheet-subtitle"></h4>
											<%
												boolean checkExpried = false;
												if(article.getNeverExpire()==false){
													if(article.getStatus() < 10){
														checkExpried = true;
													}
												}else{
													checkExpried = article.getNeverExpire();
												}
											%>
											<aui:input id="check-never-expire" label="Bài viết vô hạn" type="checkbox" name="never-expire" checked="<%= checkExpried%>"></aui:input>
										</aui:col>
										<%
										SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm");
											String classHideShow = (article.getNeverExpire()==true ? "none" : "block");
											String date_from = (article.getPublishedDateFrom()!=null?sdfDate.format(article.getPublishedDateFrom()):sdfDate.format(new Date()));
											String data_to = (article.getPublishedDateTo()!=null?sdfDate.format(article.getPublishedDateTo()):sdfDate.format(new Date()));
										%>
										<aui:col md="6" cssClass="<%=classHideShow %>">
											<aui:row>
												<aui:input type="text" cssClass="" id="start_time" name="date_from" value="<%=date_from%>"> </aui:input>
											</aui:row>
										</aui:col>
										<aui:col md="6" cssClass="<%=classHideShow %>">
											<aui:row>
												<aui:input type="text" cssClass="" id="end_time" name="date_to" value="<%=data_to%>"> </aui:input>
											</aui:row>
										</aui:col>
									<%} %>
								</aui:row>
							</aui:col>
							<aui:col md="4">
								<liferay-ui:error key="category-is-required" message="Bạn cần chọn ít nhất một chuyên mục" />
								<%@ include file="article_custom/choose_category.jsp" %>
								<aui:row>
									<aui:col>
										<h3 class="sheet-subtitle"><i class="icon-tasks"></i> Tác vụ khác</h3>
										<div>
											<aui:input label="Cho phép bình luận" name="isComment" type="checkbox" checked="<%=article.getAllowComent()%>"></aui:input>
											<aui:input label="Tin tức nổi bật" name="isNoiBat" type="checkbox" checked="<%=article.getIsNoiBat() %>"></aui:input>
											<aui:input label="Thứ tự tin mới nhất" id="trangChu" name="article-homePage" type="checkbox"></aui:input>
											<div class="box-art-news" style="display: none;">
												<aui:input label="Tin 1" type="checkbox" value="1" onchange="chkChange(this)"  id="thuTuViewNews_1" name="thuTuViewNews"></aui:input>
												<aui:input label="Tin 2" type="checkbox" value="2" onchange="chkChange(this)" id="thuTuViewNews_2" name="thuTuViewNews"></aui:input>
												<aui:input label="Tin 3" type="checkbox" value="3" onchange="chkChange(this)" id="thuTuViewNews_3" name="thuTuViewNews"></aui:input>
												<aui:input label="Tin 4" type="checkbox" value="4" onchange="chkChange(this)" id="thuTuViewNews_4" name="thuTuViewNews"></aui:input>
												<%-- <aui:input label="Tin 5" type="checkbox" value="5" onchange="chkChange(this)" id="thuTuViewNews_5" name="thuTuViewNews"></aui:input>
												<aui:input label="Tin 6" type="checkbox" value="6" onchange="chkChange(this)" id="thuTuViewNews_6" name="thuTuViewNews"></aui:input> --%>
											</div>
											<aui:input type="hidden" id="thuTuHienThiTrangChu" name="thuTuHienThiTrangChu"></aui:input>
										</div>
										<style>
										.box-art-news .form-group{
											border: 1px solid #ccc;
										   	padding: 10px;
										  	margin-bottom: 5px;
										}
										</style>
										<script>
										$(document).ready(function(){
											$("#<portlet:namespace/>trangChu").click(function(){
												if($(".box-art-news").css("display") == "none"){
													$(".box-art-news").slideToggle("slow");
													
												}else{
													$(".box-art-news").slideToggle("slow");
												}
											});	
										});
										    function chkChange(e){
												var c= $(e).val();
												if ($(e).is(':checked')){
													$('#<portlet:namespace/>thuTuHienThiTrangChu').val($(e).val());
												    $('.box-art-news input:checked').each(function(){
														if(c!=$(this).val())this.checked =false;
													});
												}
												else{
													if(c==$('#<portlet:namespace/>thuTuHienThiTrangChu').val())$('#<portlet:namespace/>thuTuHienThiTrangChu').val('');
												}
											}
										</script>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col>
										<h3 class="sheet-subtitle">Sự kiện</h3>
										<div>
											<%@ include file="article_custom/choose_event.jsp" %>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col>
										<h3 class="sheet-subtitle">Tags</h3>
										<div>
											<%@ include file="article_custom/choose_tags.jsp" %>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col>
										<h3 class="sheet-subtitle">Bài viết liên quan</h3>
										<div>
											<%@ include file="article_custom/choose_articleInvolve.jsp" %>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col>
										<h3 class="sheet-subtitle">Chuyển bài viết tới trang</h3>
										<div>
											<%
											String checkedSubsite = "";
											try{
												List<String> lstSubsite=new ArrayList<String>();
												if(renderRequest.getAttribute("lstSubSite")!=null && renderRequest.getAttribute("lstSubSite")!=null && renderRequest.getAttribute("rsValidArticle").toString().equals("true")){		 					 			
													lstSubsite = (List<String>)renderRequest.getAttribute("lstSubSite");		 			
										 		}
												List<Object> lstObj = ArticleLocalServiceUtil.getDuLieuTheoSql("SELECT groupid,name FROM GROUP_ WHERE type_=1 AND site=true AND active_=true");
												List<Object> lstArtSite = ArticleLocalServiceUtil.getDuLieuTheoSql("SELECT articleid,groupid,articlemainid FROM soft_cms_article WHERE articlemainid="+articleId+" AND issubsite=TRUE");
												for(String st : lstSubsite){
													if(checkedSubsite.equals(""))checkedSubsite = st;
													else checkedSubsite+=","+st;
												}
												for(Object obj : lstArtSite){
													Object[]oj=(Object[])obj;
													if(checkedSubsite.equals(""))checkedSubsite = String.valueOf(oj[1]);
													else checkedSubsite+=","+String.valueOf(oj[1]);
												}
												for(Object obj : lstObj){
													Object[]o=(Object[])obj;
													if(themeDisplay.getScopeGroupId() != Long.valueOf(String.valueOf(o[0]))){
														%>
														<div style="display: table-row;">
															<div style="display: table-cell;padding-left: 13px;">
																<input <%if((","+checkedSubsite+",").contains(","+String.valueOf(o[0])+","))out.print("checked='checked'"); %> type="checkbox" value="<%= o[0]%>" id="<%="site_"+o[0] %>" name="<portlet:namespace/>checkbox-site">
															</div>
															<div style="display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px; ">
																<label><%=o[1] %></label>
															</div>
														</div>
														<%
													}
												}
											}catch(Exception e){}
											%>
										</div>
									</aui:col>
								</aui:row>
							</aui:col>
					</aui:row>
					<aui:button-row>
						<c:if test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_ADD, themeDisplay.getScopeGroupId()) %>">
							<c:choose>
								<c:when test="<%=article.getStatus() == NewsWorkflowConstants.STATUS_NOT_CREATE || article.getStatus() == NewsWorkflowConstants.STATUS_DRAFT%>">
									<aui:button icon="icon-save" data-id="<%=RoleConstants.ARTICLE_ADD %>" onClick="submitArticle(this)" type="button" cssClass="btn btn-primary" value="Lưu nháp (F6)"></aui:button>
								</c:when>
								<c:otherwise>
									<c:if test="<%=article.getStatus() != NewsWorkflowConstants.STATUS_PENDING %>"> 
										<aui:button icon="icon-save" data-id="<%=RoleConstants.ARTICLE_ADD %>" onClick="submitArticle(this)" type="button" cssClass="btn btn-primary" value="Lưu (F6)"></aui:button>
									</c:if>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<c:if test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_PENDING, themeDisplay.getScopeGroupId()) 
							&& (article.getStatus() == NewsWorkflowConstants.STATUS_NOT_CREATE || article.getStatus() == NewsWorkflowConstants.STATUS_DRAFT)	%>">
							<aui:button type="button" cssClass="btn btn-primary" icon="icon-share" data-id="<%=RoleConstants.ARTICLE_PENDING %>" onClick="submitArticle(this)" value="Trình duyệt (F7)"></aui:button>
						</c:if>
						<c:if test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_APPROVED, themeDisplay.getScopeGroupId()) 
							&&	(article.getStatus() == NewsWorkflowConstants.STATUS_PENDING || article.getStatus() == NewsWorkflowConstants.STATUS_APPROVE_DENIED)%>">
							<aui:button type="button" cssClass="btn btn-primary" icon="icon-ok-circle" data-id="<%=RoleConstants.ARTICLE_APPROVED %>" onClick="submitArticle(this)" value="Phê duyệt (F8)"></aui:button>
						</c:if>
						<c:if test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_APPROVED_RETURN, themeDisplay.getScopeGroupId()) 
								&&	(article.getStatus() == NewsWorkflowConstants.STATUS_APPROVED)%>">
								<aui:input name="a" value="<%=article.getStatus() %>"></aui:input>
							<aui:button href="${deniedApproveArticle}" cssClass="btn btn-primary" icon="icon-undo" type="button" value="Trả lại"></aui:button>
						</c:if>
						<c:if test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_PUBLISH, themeDisplay.getScopeGroupId()) && article.getStatus() != NewsWorkflowConstants.STATUS_PUBLISH %>">
							<aui:button type="button" cssClass="btn btn-primary" icon="icon-globe" data-id="<%=RoleConstants.ARTICLE_PUBLISH %>" onClick="submitArticle(this)" value="Xuất bản (F9)"></aui:button>
						</c:if>
						<c:if test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_PUBLISH_RETURN, themeDisplay.getScopeGroupId())
								&&	(article.getStatus() == NewsWorkflowConstants.STATUS_PUBLISH)%>">
							<aui:a href="${deniedPublishArticle}"><aui:button cssClass="btn btn-primary" icon="icon-undo" type="button" value="Trả lại"></aui:button></aui:a>
						</c:if>
						<aui:input type="hidden" id="cmd-js" name="cmdAction" value=""></aui:input>
						<aui:button type="button" icon="icon-search" id="previewArticle" value="Xem trước (F1)"></aui:button>
						<aui:button id="submitArt" name="submit" type="submit" cssClass="hide"></aui:button>
						<aui:button href="${param.backURL}" icon="icon-repeat" type="button" value="Quay lại (ESC)"></aui:button>
					</aui:button-row>
				</aui:form>
		</aui:fieldset-group>
	</aui:fieldset>
</div>
<c:if test="<%=article.getStatus() != NewsWorkflowConstants.STATUS_NOT_CREATE %>">
<aui:fieldset>
	<aui:fieldset-group>
		<h3 class="sheet-subtitle"> Bình luận</h3>
		<%@ include file="article_custom/comment.jsp" %>
		<h3 class="sheet-subtitle"> Nhật ký bài viết</h3>
		<%@ include file="article_custom/articleHistory.jsp" %>
	</aui:fieldset-group>
</aui:fieldset>
</c:if>
<%
if(article.getIsTimer()){ %>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#<portlet:namespace/>henGio').attr("checked","checked");
			$("#box_henGio").css("display","block");
			$("#<portlet:namespace/>thoiGianHenGio").val("<%=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(article.getPublishedDateFrom())%>");
		});
	</script>
<%} %>
<%if(article.getIsHomePage()==true) {%>
	<script>
		$(document).ready(function(){
			$(".box-art-news").css("display","block");
			$("#<portlet:namespace/>trangChu").attr("checked","checked");
			$("#<portlet:namespace/>thuTuViewNews_<%=article.getThuTu()%>").attr("checked","checked");
			document.getElementById("<portlet:namespace/>thuTuHienThiTrangChu").value = <%=article.getThuTu()%>;
			
		});
	</script>
<%} %>
<aui:script>
var vala = !$("#<portlet:namespace/>check-never-expire").prop("checked");
if(!vala){
	$(".no-check-never-expire").css("display", "none");			
}
$("#<portlet:namespace/>check-never-expire").click(function(){
	var val = !$("#<portlet:namespace/>check-never-expire").prop("checked");
	if(!val){
		$(".no-check-never-expire").css("display", "none");			
	}else{
		$(".no-check-never-expire").css("display", "block");
	}
});

function submitArticle(e){
	var data = $(e).attr('data-id');
	var content = window.<portlet:namespace/>content.getHTML();
	var totalTrue = 0;
	$("#div_category input[type=checkbox]").each(function () {
		if(this.checked){
			totalTrue ++;
		}
	});
	if(totalTrue <= 0){
		alert('Bạn chưa chọn chuyên mục');
		document.getElementById("div_category").scrollIntoView();
		event.preventDefault();
		return false;
	}
	if(content == ''){
		alert('Bạn chưa nhập Nội dung bài viết');
		document.getElementById("cke_<portlet:namespace/>content").scrollIntoView();
		event.preventDefault();
		return false;
	}
	if(data != undefined && data != ''){
		$('#<portlet:namespace/>cmd-js').val(data);
		$('#<portlet:namespace/>submitArt').trigger("click")
	}
}
</aui:script>
<liferay-portlet:renderURL var="previewArticleUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<liferay-portlet:param name="mvcPath" value="/article/preview_article.jsp"/>
	<liferay-portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:renderURL>
<aui:script>
AUI().use('aui-base',
			'aui-io-plugin-deprecated',
			'liferay-util-window',
			'liferay-portlet-url',
			'aui-dialog-iframe-deprecated',
			 function(A) {
			 	A.one('#<portlet:namespace/>previewArticle').on('click', function(event){
				
				var url = '${previewArticleUrl.toString()}';
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
 function htmlEntities(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}			
</aui:script>
<aui:script use="aui-base">
	YUI().use('event', function (Y) {
		var clickInput = Y.one("#<portlet:namespace/>henGio");
		clickInput.on("click", function (e) {
			var box_henGio = document.getElementById('box_henGio');
			if(box_henGio.style.display == 'none'){
				box_henGio.style.display = 'block';
				
			}else{
				box_henGio.style.display = 'none';
			}
		});
	});
	
</aui:script>
<script type="text/javascript" src="<%=request.getContextPath() %>/pickdate/jquery.datetimepicker.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/pickdate/jquery.datetimepicker.css" />
<script type="text/javascript">
	jQuery('.date-time-art').datetimepicker({
		format: 'd/m/Y H:i'
	});
	jQuery('#<portlet:namespace/>start_time').datetimepicker({
		format: 'd/m/Y H:i'
	});
	jQuery('#<portlet:namespace/>end_time').datetimepicker({
		format: 'd/m/Y H:i'
	});
	function openFullScreen(){
		var boxFull = $("#editor-article-js");
		if(boxFull.hasClass("edit-art-full")){
			boxFull.removeClass("edit-art-full");
			$('.icon-resize-small').addClass('icon-resize-full');
			$('.icon-resize-small').removeClass('icon-resize-small');
		}else{
			boxFull.addClass("edit-art-full");
			$('.icon-resize-full').addClass('icon-resize-small');
			$('.icon-resize-full').removeClass('icon-resize-full');
		}
	}
	document.onkeydown=function(e){
		var e = e || window.event;
		console.log("keyCode: "+e.keyCode);
		if(e.keyCode == 112){
			e.preventDefault();
			$("#<portlet:namespace/>previewArticle").click();
		}else if(e.keyCode == 123){
			e.preventDefault();
			openFullScreen();
		}else if(e.keyCode == 120){
			e.preventDefault();
			submitHotKey(4);
		}else if(e.keyCode == 119){
			e.preventDefault();
			submitHotKey(2);
		}else if(e.keyCode == 118){
			e.preventDefault();
			submitHotKey(12);
		}else if(e.keyCode == 117){
			e.preventDefault();
			submitHotKey(1);
		}else if(e.keyCode == 27){
			e.preventDefault();
			window.location.replace('${param.backURL}');
		}
	}
	function submitHotKey(id){
		var content = window.<portlet:namespace/>content.getHTML();
		var totalTrue = 0;
		$("#div_category input[type=checkbox]").each(function () {
			if(this.checked){
				totalTrue ++;
			}
		});
		if(totalTrue <= 0){
			alert('Bạn chưa chọn chuyên mục');
			document.getElementById("div_category").scrollIntoView();
			event.preventDefault();
			return false;
		}
		if(content == ''){
			alert('Bạn chưa nhập Nội dung bài viết');
			document.getElementById("cke_<portlet:namespace/>content").scrollIntoView();
			event.preventDefault();
			return false;
		}
		if(id != undefined && id != ''){
			$('#<portlet:namespace/>cmd-js').val(id);
			$('#<portlet:namespace/>submitArt').trigger("click")
		}
	}
</script>
<style>
#editor-article-js.edit-art-full{
	position: fixed;
    width: 100%;
    height: 100%;
    z-index: 99999;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    overflow: auto;
}
</style>