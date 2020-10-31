<%@page import="com.software.cms.model.Comment"%>
<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.software.cms.model.Category"%>
<%@page import="com.software.cms.service.CategoryLocalServiceUtil"%>
<%@page import="com.software.util.CMSPortalUtil"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="init.jsp"%>
<link rel="stylesheet" href="<%=renderRequest.getContextPath() %>/css/jquery.fancybox.min.css" />
<script src="<%=renderRequest.getContextPath() %>/js/jquery.fancybox.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<portlet:resourceURL var="countView" id="resource" />
<liferay-ui:error key="error_NULL" message="please.enter.all.required.information"></liferay-ui:error>
<%
try{
	String artcleSelect = portletPreferences.getValue("artcleSelect", "").trim();
	if(!artcleSelect.equals("")){
		long artId = Long.valueOf(artcleSelect);
		Article art = ArticleLocalServiceUtil.getArticle(artId);
	%>
	<script type="text/javascript">
		$(document).ready(function($){
			CheckCountView();
		});
		function CheckCountView(){
			var url = "${countView.toString()}";
			jQuery.ajax({
				type: "GET",
				url: url,
				data:{
					<portlet:namespace/>articleId:<%=art.getArticleId()%>,
				}, 
				success: function() {}
				}
			);
		}
	</script>
	<div class="entry-content">
		<%
		String content = art.getContent()!=null?art.getContent():"";
		if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
		    //you're in mobile land
		    Pattern findStyle = Pattern.compile("<img[^>]*(width[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;[^>]*height[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;)[^>]*>");
			Matcher m = findStyle.matcher(content);
			while(m.find()){
			    content = content.replace(m.group(1), "");
			}
		} else{%>
		<%}
		%>
		<%=content%>
		</div>
		<aui:script>
		AUI().ready('aui-module', function(A){ 
				$("#contentnews").find("*").css("font-size", "").css("line-height","").css("font-family", "").css("background", "").css("background-color", "");
				$('#contentnews img').each(function(e) {
					var hrefImg = this.src;
					 $(this).wrap('<a href="'+hrefImg+'" data-fancybox="images"></a>');
			    });
			});
	</aui:script>
	<%	
	}else{
		String typeArtId = (String) request.getAttribute("typeArtId");
		if(!typeArtId.equals("")){
			Article art = null;
			try{
				art =  (Article) request.getAttribute("baiViet");
			}catch(Exception e){
				 art = null; 
			}
			if(art != null){
				%>
				
				<div class="col-md-12 box-right1">
					<section class="article-detail ">
						<div class="alert">	
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<%=art.getTitle()!=null&&!art.getTitle().equals("") ?art.getTitle():""%>
						</div>
				        <article>
				        	<div id="contentnews" style="text-align: justify;">
								<%
									String content = art.getContent()!=null?art.getContent():"";
									if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
									    //you're in mobile land
									    Pattern findStyle = Pattern.compile("<img[^>]*(width[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;[^>]*height[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;)[^>]*>");
										Matcher m = findStyle.matcher(content);
										while(m.find()){
										    content = content.replace(m.group(1), "");
										}
									} else{%>
									<%}
								%>
								<%=content%>
								
							</div>
				        </article>
				    </section>
				</div>
				<style>
						table {width: 100% !important;}
					</style>
				<%
			}
		}else{
			Article art = (Article) request.getAttribute("baiViet");
			List<Comment> listComment = (List<Comment>)request.getAttribute("commentList");
		        String categoryId = (String) request.getAttribute("categoryId");
		        try{
		            categoryId =""+Long.valueOf(categoryId);
		        }
		        catch(Exception e){
		            categoryId ="-1";
		        }
			if (art != null && categoryId !="-1"){
				String url  = CMSPortalUtil.getURLCategory(Long.valueOf(categoryId));
				String actionSearchTag = themeDisplay.getURLPortal()+"/web"+themeDisplay.getLayout().getGroup().getFriendlyURL()+"/tim-kiem?tags=";
				Category cate = CategoryLocalServiceUtil.getCategory(Long.valueOf(categoryId));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				response.setHeader("og:title", art.getTitle());
				List<Tag> listTag = new ArrayList<Tag>();
				String urlImageAvt = !art.getImage().equals("")? AttachmentUtil.getURLImage(renderRequest, renderResponse, themeDisplay, art.getImage()) : "";
				try {
					if(!art.getTagIds().equals(""))listTag = TagLocalServiceUtil.getListTag("SELECT * FROM soft_cms_TAG WHERE TAGID IN ("+art.getTagIds()+")", QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				} catch (Exception e) {
				}
				String titleCateParent = "";
				String urlCatParent  = "";
				if(cate.getParentId() > 0){
					titleCateParent = CategoryLocalServiceUtil.getCategory(cate.getParentId()).getTitle();
					urlCatParent = CMSPortalUtil.getURLCategory(cate.getParentId());
				}
				PortalUtil.addPageTitle(art.getTitle(), request);
				PortalUtil.setPageDescription(art.getSummary(), request);
				String tags = "";
				if (listTag != null && !listTag.isEmpty()) {
					for (int i = 0; i < listTag.size(); i++) {
						Tag t = listTag.get(i);
						tags += "<a href='"+actionSearchTag+t.getTagName()+"' class='label label-default'>"+t.getTagName()+"</a>";
//		 				tags += (i == listTag.size() - 1 ? ", " : "");
					}
				}
		%>
		<liferay-util:html-top>
			<meta property="og:url" content="<%=themeDisplay.getPortalURL()+themeDisplay.getURLCurrent() %>" />
		   	<meta property="og:type" content="<%=themeDisplay.getScopeGroupName() %>" />
		  	<meta property="og:title" content="<%= HtmlUtil.extractText(art.getTitle()) %>" />
		  	<meta property="og:description" content="<%=art.getSummary() %>" />
			<meta property="og:image" content="<%=urlImageAvt %>" />
			<meta property="og:image:type" content="image/jpeg">
			<meta property="og:image:width" content="600">
			<meta property="og:image:height" content="315">
			<meta property="og:type" content="Article">
		</liferay-util:html-top>
		<script type="text/javascript">
		$(document).ready(function($){
			CheckCountView();
			$("#contentnews").find("*").css("font-size", "").css("line-height","").find("*").css("font-family", "").css("background", "").css("background-color", "");;
		});
		function CheckCountView(){
			var url = "${countView.toString()}";
			jQuery.ajax({
				type: "GET",
				url: url,
				data:{
					<portlet:namespace/>articleId:<%=art.getArticleId()%>,
				}, 
				success: function() {}
				}
			);
		}
		</script>
		<script type="text/javascript">	
		function fontPlus(){
			var b=document.getElementById("contentnews");
			if(b.style.fontSize==""){
				b.style.fontSize="12px";
			}
				var a=b.style.fontSize;
			if((a.indexOf("px")>-1)&&(a.indexOf("px")==(a.length-2))){
				a=a.substring(0,a.indexOf("px"));
			}
				b.style.fontSize=(parseFloat(a)+1)+"px";
				
			if(b.style.fontSize==""){b.style.fontSize="12px"}
				a=b.style.fontSize;
			if((a.indexOf("px")>-1)&&(a.indexOf("px")==(a.length-2))){a=a.substring(0,a.indexOf("px"))}
				b.style.fontSize=(parseFloat(a)+1)+"px";
		}
		function fontMinus(){
			var b=document.getElementById("contentnews");
			if(b.style.fontSize==""){b.style.fontSize="12px"}
				var a=b.style.fontSize;
			if((a.indexOf("px")>-1)&&(a.indexOf("px")==(a.length-2))){a=a.substring(0,a.indexOf("px"))}
				b.style.fontSize=(parseFloat(a)-1)+"px";
				
			if(b.style.fontSize==""){b.style.fontSize="12px"}
				a=b.style.fontSize;
			if((a.indexOf("px")>-1)&&(a.indexOf("px")==(a.length-2))){a=a.substring(0,a.indexOf("px"))}
				b.style.fontSize=(parseFloat(a)-1)+"px";
		}
		</script>
		<div class="primary-content">
			<div class="row">
				<div class="col-md-12 mb-3">
					<ol class="breadcrumb">
	                  <li class="breadcrumb-item"><a href="<%=themeDisplay.getURLHome()%>">Trang chủ</a></li>
	                  <%if(!titleCateParent.equals("")) {%><li class="breadcrumb-item"><a href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+urlCatParent%>"><%=titleCateParent %></a></li><%} %>
	                  <li class="breadcrumb-item active" aria-current="page"><a href="<%="/web"+themeDisplay.getScopeGroup().getFriendlyURL()+url%>"></a> <%=cate!=null&&!cate.getTitle().equals("")?cate.getTitle():"" %></li>
	                </ol><!-- /. breadcrum -->
	                <div class="entry-heading">
	                    <h1 class="entry-title"><%=art.getTitle()!=null&&!art.getTitle().equals("") ?art.getTitle():""%></h1>
	                    <div class="displaytime">
	                    	<div class="timer">
	                    		<%=art.getPublishedDateFrom()!=null?sdf.format(art.getPublishedDateFrom()):"" %>
	                    	</div>
	                    	<div class="share">
		                    	<ul class="newsTool">
				                    <li class="font">
				                      <a href="Javascript:fontMinus()" id="largerfont" class="md fontSizePlus">
											<i style="font-size: 12px;" class="icon-font"></i>
										</a> 
										<a href="Javascript:fontPlus()" class="xl fontSizePlusMin">
											<i style="font-size: 17px;" class="icon-font"></i>
										</a>
				                    </li>
				                </ul>
	                    	</div>
	                    </div>
	                </div>
	                <article id="contentnews" class="entry">
 						<div class="desc my-3">
		                 	 <%= art.getSummary()!=null?(art.getSummary().replace("\\r\\n", "<br>").replace("\n", "<br>")):"" %>
		                </div>
		                <%if(!art.getInvolveArt().equals("")){ %>
							<div class="dongsukien">
								<ul class="list-cycle">
			          				<%for(String st : art.getInvolveArt().split(",")){ 
			          					String sqlTinLq = "SELECT * FROM ecoit_cms_article WHERE articleid='"+st+"' AND groupid="+themeDisplay.getScopeGroupId()+" AND language='"+themeDisplay.getLanguageId()+"' AND status=10 AND interest <=0 ORDER BY publisheddatefrom DESC LIMIT 1";
			          					String linkTin = "";
			          					String titleInvolve = "";
			          					try{
			          						Article tinLienQuan = ArticleLocalServiceUtil.getArticleTheoSQL(sqlTinLq).get(0);
			          							titleInvolve = tinLienQuan.getTitle();
				          						linkTin = CMSPortalUtil.getUrlArticle(tinLienQuan, 0, request, themeDisplay.getScopeGroupId());	
			          					}catch(Exception e){
			          						linkTin = "";
				          					titleInvolve = "";
			          					}
			          				%>
			          					<li style="text-align: justify;border-top: 0;"><a href="<%=linkTin%>" title="<%=titleInvolve %>"><%=titleInvolve %></a></li>
			          				<%} %>
			          			</ul>
							</div>
						<%} %>
						<div class="detail">
							<%if(urlImageAvt.indexOf("/res/no-image.jpg") < 0){ %>
		                  		<div class="entry-img" style="text-align: center;margin-bottom: 10px;">
		                  			<img alt="" src="<%=urlImageAvt%>">
									<figcaption><p><%=art.getImageTitle() %></p></figcaption>
		                  		</div>
							<%} %>
							<div class="entry-content">
							<%
								String content = art.getContent()!=null?art.getContent():"";
								if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
								    //you're in mobile land
								    Pattern findStyle = Pattern.compile("<img[^>]*(width[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;[^>]*height[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;)[^>]*>");
									Matcher m = findStyle.matcher(content);
									while(m.find()){
									    content = content.replace(m.group(1), "");
									}
								} else{%>
								<%}
							%>
			                <%=content%>
							</div>
						</div>
		                <div class="entry-body">
							<div class="entry-source-author" align="right">
								<%
									String tac_gia = "";
									String nguon = "";
									if(!art.getAuthor().equals("")) tac_gia = art.getAuthor();
									if(!art.getSource().equals("")) nguon = art.getSource();
								%>
								<div class="article-Author">
									<%=tac_gia %>
								</div>
								<div class="article-Source">
									<%=nguon %>
								</div>
							</div>
							 <%if(!tags.equals("")){ %>
								<section class="tags">
									<strong>Tags: </strong><%=tags %>
								</section>
							<%} %>
		                  </div>
		                  <aui:script>
							AUI().ready('aui-module', function(A){ 
									$('#contentnews img').each(function(e) {
										var hrefImg = this.src;
										 $(this).wrap('<a href="'+hrefImg+'" data-fancybox="images"></a>');
								    });
								});
							</aui:script>
	                </article>
	                <div class="art-share">
						<portlet:renderURL var="print" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
							<portlet:param name="articleId"
								value="<%=String.valueOf(art.getArticleId())%>" />
							<portlet:param name="mvcPath" value="/print_cms.jsp" />
						</portlet:renderURL>
							<a
								onclick="Javascript:expandingWindow('${print}');"
								href="Javascript:"
								title="<liferay-ui:message key="soft.cms.label.print"/>"> <img class="icon-share" alt="<liferay-ui:message key="soft.cms.label.print"/>"
								src="<%=renderRequest.getContextPath() %>/image/iconprinters.png" />
							</a>
						<portlet:renderURL windowState="<%=LiferayWindowState.POP_UP.toString()%>" var="SendMail">
							<portlet:param name="action" value="ActionSendMail" />
							<portlet:param name="articleId"
								value="<%=String.valueOf(art.getArticleId())%>" />
							<portlet:param name="cat" value="<%=categoryId%>" />
							<portlet:param name="link"
								value="<%=themeDisplay.getPortalURL() + themeDisplay.getURLCurrent()%>" />
								<portlet:param name="mvcPath" value="/sendMailTo.jsp" />
						</portlet:renderURL>
						<a onclick="Javascript:expandingWindow('${SendMail}');"
							href="Javascript:"
							title="<liferay-ui:message key="soft.cms.label.sendmail"/>"> <img class="icon-share"
							alt="<liferay-ui:message key="soft.cms.label.sendmail"/>"
							src="<%=renderRequest.getContextPath() %>/image/sharemail.png">
						</a>
						<%-- <a
							href="https://www.facebook.com/sharer/sharer.php?u=<%=URLEncoder.encode(themeDisplay.getPortalURL()
											+ themeDisplay.getURLCurrent(), "UTF-8")%>&t=<%=art.getTitle()%>"
							onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;"
							target="_blank" title="Share on Facebook"> <img
							class="icon-share" alt="Share Facebook"
							src="<%=renderRequest.getContextPath() %>/image/shareFB.png">
						</a> 
						<a
							href="<%="https://twitter.com/share?url="
											+ themeDisplay.getPortalURL()
											+ themeDisplay.getURLCurrent()%>"
							title="Share Twitter"
							onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;"
							data-text="<%=themeDisplay.getScopeGroupName()%>"> 
							<img class="icon-share" alt=""
							src="<%=renderRequest.getContextPath() %>/image/twitter.jpg">
						</a> --%>
					</div>
				<div class="page-content">
				<div class="page-category-content">
				<%
				    List<Comment> parentCommentList = new ArrayList<Comment>();
					List<Comment> childCommentList = new ArrayList<Comment>();
					for(int i = 0; i < listComment.size(); i++){
						if(listComment.get(i).getParentId() == 0L)
							parentCommentList.add(listComment.get(i));
						else
							childCommentList.add(listComment.get(i));
					}
					if(art.getAllowComent()==true){
				    %>
				    <div class="comments">
						<h4 class="comment-title">
		                    Thêm bình luận :
		                </h4>
		                <div class="form-comment">
		                	<portlet:actionURL var="ActionCommentURL" name="ActionComment">
						   		<portlet:param name="articleid" value="<%=String.valueOf(art.getArticleId()) %>"/>
						   		<portlet:param name="categoryId" value="<%=categoryId %>"/>
						   		<portlet:param name = "currentURL" value="${themeDisplay.getURLCurrent()}"/>
						    </portlet:actionURL>
		                	<aui:form action="${ActionCommentURL}" method="POST">
						    	<div class="row">
		                			<div class="col-md-6">
		                				<div class="form-group">
											<label><liferay-ui:message key="soft.cms.label.comment.hvt"/>(<span class="red">*</span>):</label> 
											<aui:input cssClass="form-control" name="ho_va_ten" label="" required="<%=true %>">
												<aui:validator name="maxLength" errorMessage="Không được nhập quá 300 ký tự">300</aui:validator>
											</aui:input>
										</div>
		                			</div>
		                			<div class="col-md-6">
		                				<div class="form-group">
											<label><liferay-ui:message key="soft.cms.label.comment.email"/>(<span class="red">*</span>):</label> 
											<aui:input cssClass="form-control" label="" name="email" required="<%=true %>" type="text">
												<aui:validator name="required"></aui:validator>
													<aui:validator name="maxLength" errorMessage="Không được nhập quá 70 ký tự">70</aui:validator>
													<aui:validator name="custom"
														errorMessage="Vui lòng nhập nhập đúng định dạng email">
															function (val, fieldNode, ruleValue) {
																return validateEmail(val);
															}
														</aui:validator>
											</aui:input>
										</div>
		                			</div>
		                			<div class="col-md-12">
			                			<div class="form-group">
											<label><liferay-ui:message key="soft.cms.label.comment.content"/>(<span class="red">*</span>):</label>
											<div class="control-group input-text-wrapper">
												<aui:input type="textarea" class="form-control" label="" required="<%=true %>" name="noi_dung_comment">
													<aui:validator name="required"></aui:validator>
													<aui:validator name="maxLength" errorMessage="Không được nhập quá 400 ký tự">400</aui:validator>
												</aui:input>
											</div>
										</div>
		                			</div>
		                		</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary"><liferay-ui:message key="soft.cms.label.comment.btn.submit"/></button>
									<button type="reset" class="btn btn-default"><liferay-ui:message key="soft.cms.label.comment.btn.retype"/></button>
								</div>
						    </aui:form>
							<%for(int i = 0; i < parentCommentList.size(); i++){
								if(parentCommentList.get(i).getApproved()==true){
							%>
								<div class="media">
						             <div class="media-left">
						                    <a href="#">
						                        <img class="media-object" src="<%=renderRequest.getContextPath() %>/res/m.jpg">
						                    </a>
						                </div>
						                <div class="media-body">
						                    <h5 class="media-heading"><%= parentCommentList.get(i).getUsername() %><small class="text-muted">- <%=sdf.format(parentCommentList.get(i).getCreatedDate()) %></small></h5>
						                   	<%= parentCommentList.get(i).getContent() %>
						                   	<%
											String idPrev = "CommentChild"+parentCommentList.get(i).getCommentId();
											%>
						                  	<p><a id="<%=idPrev %>" style="cursor: pointer;font-size: 10px;"><i class="icon-comment" style="color: #4266cb"></i> <liferay-ui:message key="soft.cms.label.comment.btn.reply"/></a></p>
						                  	<aui:script>
							                  	AUI().ready('aui-module', function(A){
							                  		$("#CommentChild<%=parentCommentList.get(i).getCommentId()%>").click(function(){
							                  			$("#<portlet:namespace/>fromChildCommnet<%=parentCommentList.get(i).getCommentId()%>").css("display","block");
							                  		});
							                  		$("#an_tra_loi<%=parentCommentList.get(i).getCommentId()%>").click(function(){
							                  			$("#<portlet:namespace/>fromChildCommnet<%=parentCommentList.get(i).getCommentId()%>").css("display","none");
							                  		});
							                  	});
						                  	</aui:script>
						                  	 <portlet:actionURL var="ActionChildCommentURL" name="ActionChildComment">
						   						<portlet:param name="commentId" value="<%=String.valueOf(parentCommentList.get(i).getCommentId()) %>"/>
						   						<portlet:param name = "currentURL" value="${themeDisplay.getURLCurrent()}"/>
						   						<portlet:param name="articleid" value="<%=String.valueOf(art.getArticleId()) %>"/>
						   						<portlet:param name="categoryId" value="<%=categoryId %>"/>
						   					 </portlet:actionURL>
						   					 <%
						   					 	String nameForm = "fromChildCommnet"+parentCommentList.get(i).getCommentId();
						   					 %>
									         <aui:form class="well" name="<%=nameForm %>" action="${ActionChildCommentURL}" method="POST" style="display: none;" id="<%=nameForm%>">
									               <div class="row">
		                								<div class="col-md-6">
		                									<div class="form-group">
																<label><liferay-ui:message key="soft.cms.label.comment.hvt"/>(<span class="red">*</span>):</label> 
																<aui:input cssClass="form-control" name="ho_va_ten" label="" required="<%=true %>">
																	<aui:validator name="maxLength" errorMessage="Không được nhập quá 300 ký tự">300</aui:validator>
																</aui:input>
															</div>
		                								</div>
		                								<div class="col-md-6">
		                									<div class="form-group">
																<label><liferay-ui:message key="soft.cms.label.comment.email"/>(<span class="red">*</span>):</label>
																<aui:input cssClass="form-control" label="" name="email" required="<%=true %>" type="text">
																	<aui:validator name="required"></aui:validator>
																		<aui:validator name="maxLength" errorMessage="Không được nhập quá 70 ký tự">70</aui:validator>
																		<aui:validator name="custom"
																			errorMessage="Vui lòng nhập nhập đúng định dạng email">
																				function (val, fieldNode, ruleValue) {
																					return validateEmail(val);
																				}
																			</aui:validator>
																</aui:input>
															</div>
		                								</div>
		                								<div class="col-md-12">
		                									<div class="form-group">
																<label><liferay-ui:message key="soft.cms.label.comment.content"/>(<span class="red">*</span>):</label>
																<div class="control-group input-text-wrapper">
																	<aui:input type="textarea" class="form-control" label="" required="<%=true %>" name="noi_dung_comment">
																		<aui:validator name="required"></aui:validator>
																		<aui:validator name="maxLength" errorMessage="Không được nhập quá 400 ký tự">400</aui:validator>
																	</aui:input>
																</div>
															</div>
		                								</div>
		                							</div>
											        <div class="form-group">
											            <button type="submit" class="btn btn-primary"><liferay-ui:message key="soft.cms.label.comment.btn.submit"/></button>
											            <button type="reset" class="btn btn-default"><liferay-ui:message key="soft.cms.label.comment.btn.retype"/></button>
											            <button id="an_tra_loi<%=parentCommentList.get(i).getCommentId()%>" class="btn btn-default"><liferay-ui:message key="soft.cms.label.comment.btn.hideAns"/></button>
											        </div>
									        </aui:form>
							                   <%
							                   for(int j = 0; j < childCommentList.size(); j++){
							           			if(childCommentList.get(j).getParentId() == parentCommentList.get(i).getCommentId()){
							           				if(childCommentList.get(j).getApproved()==true){
							           				%>
							           				  <div class="media">
							                        <div class="media-left">
							                            <a href="#">
							                                <img class="media-object" src="<%=renderRequest.getContextPath() %>/res/m.jpg">
							                            </a>
							                        </div>
							                        <div class="media-body">
							                            <h5 class="media-heading"><%=childCommentList.get(j).getUsername()%> <small class="text-muted">- <%=sdf.format(childCommentList.get(j).getCreatedDate()) %></small></h5>
							                            <%=childCommentList.get(j).getContent() %>
							                        </div>
							                    </div>
							           				<%
							           				}
							           			}
							           		}
							                   %>
							                </div>
									   </div>
							<%	}
							} %>
		                </div>
					</div>
				    <%} %>
					
				</div>
			</div>
				</div>
				 <hr class="gaps">
				  <div class="col-md-12 related">
				  	<div class="head">Tin mới</div>
	                  <ul class="lists-view">
	                  <%
							List<Article> listArticleEvent = new ArrayList<Article>();
							try {
								listArticleEvent = ArticleLocalServiceUtil.getListArticleByEvent(themeDisplay.getScopeGroupId(),art.getArticleId(), Long.valueOf(categoryId).longValue(), "", 0, 10);
							} catch (Exception e) {
							}
							for (int h = 0; h < listArticleEvent.size() && h < 5; h++) {
								Article arEvent = listArticleEvent.get(h);
								String url2 = CMSPortalUtil.getUrlArticle(arEvent,Long.valueOf(categoryId).longValue(), request, themeDisplay.getScopeGroupId());
							%>
							<li>
		                        <a href="<%=url2%>"><%=arEvent.getTitle() %></a>
		                      </li>
							<%}
							%>
	                  </ul>
                  </div>
			</div>
		</div>
		<%}else{
			%>
			<div class="article-not-found alert">
				<p><liferay-ui:message key="soft.cms.article.isNull"/></p>
			</div>
			<%
		}
		}%>
		<style>
		.entry-heading .entry-title {
		    font: 700 25px/35px Roboto,Arial,Tahoma;
		    color: #004175;
		    margin-bottom: 20px;
		    text-align: justify;
		}
		.displaytime {
		    border-bottom: 1px solid #333;
		    margin-bottom: 20px;
		    overflow: auto;
		}
		#contentnews .desc {
		    font: 700 15px/20px Roboto,Arial,Tahoma;
		    color: #333;
		    text-align: justify;
		}
		#contentnews .detail{
			width: 100%;
    		height: auto;
		}
		.entry-heading .article-Author,#contentnews .article-Source {
		    font: 700 14px Roboto,Arial,Tahoma;
		    color: #333;
		    text-align: right;
		    margin: 20px 0;
		    width: 100%;
		}
		.related{
		    padding: 15px 0 10px;
		}
		.related .head {
		    color: #be1e2d;
		    font: 700 18px Roboto,Arial,Tahoma;
		    border-bottom: 2px solid #be1e2d;
		    text-transform: uppercase;
		    padding-bottom: 5px;
		    margin: 20px 0;
		}
		.related ul{
			list-style-type: square;
		    padding-left: 15px;
		    color: #1b75bb;
		    font-size: 9px;
		}
		.related ul li a, .related ul li a:link, .related ul li a:visited {
		    font: 400 14px/20px Roboto,Arial,Tahoma;
		    color: #1b75bb;
		}
		.related ul li span {
		    color: #6d6e70;
		    font: 400 13px Roboto,Arial,Tahoma;
		}
		.displaytime .timer {
		    font: 400 12px Roboto,Arial,Tahoma;
		    background: url(<%=renderRequest.getContextPath() %>/image/i-time.png) no-repeat left center;
		    padding-left: 25px;
		    width: 200px;
		    float: left;
		}
		.newsTool {
		    list-style: none;
		}
		.newsTool li.font {
		    float: right;
		}
		.font a#largerfont {
		    border-right: 1px solid #428dc5;
		    padding-right: 5px;
		}
		.font a.fontSizePlusMin {
		    padding-left: 5px;
		}
		[align="center"]{
			text-align: center;
		}
		.art-share img {
			width: 25px;
		}
		.page-title a .ico-2{
			    background-image: url(<%=renderRequest.getContextPath() %>/image/home_icon.png) !important;
		    }
		    .page-title h2 a {
		      width: auto;
		      background: #3498db;
		      text-transform: inherit;
		      position: relative;
		      height: 32px;
		      line-height: 32px;
		      padding: 6px 0px 5px 0px;
		      text-align: center;
		      margin-right: 15px;
		      color:#ffffff !important;
		    }
		    .page-title h2  a:last-child{
		      padding-right: 15px;
		      -moz-border-radius: 0 4px 4px 0;
		      -webkit-border-radius: 0;
		      border-radius: 0 4px 4px 0;
		      background: #f5f5f5;

		    }
		    .page-title h2 a:first-child{
		      padding-left: 5px;
		      padding-right: 5px;
		      -moz-border-radius: 4px 0 0 4px;
		      -webkit-border-radius: 4px;
		      border-radius: 4px 0 0 4px;
		    }
		    .page-title h2 a:not(:first-child):before, .page-title h2 a:not(:last-child):after {
		      content: "";
		      position: absolute;
		      top: 0;
		      border: 0 solid #3498db;
		      border-width: 14px 5px;
		      width: 0;
		      height: 0;
		    }
		    .page-title h2 a:not(:first-child):before {
		       left: -10px;
		       border-left-color: transparent;
		     }
		    .page-title h2 a:not(:last-child):after{
		      left: 100%;
		      border-color: transparent;
		      border-left-color: #3498db;
		    }
		    .page-title h2 a:hover:before {
		      border-color: #0084c5;
		      border-left-color: transparent;
		    }
		    .page-title h2 a:hover:after {
		      border-left-color: #0084c5;
		    }
		    .page-title h2 a:hover {
		      background: #0084c5;
		    }
		    .page-title h2 a:last-child {
		      background: #ffffff;
		      color:#000 !important;
		    }
		    .page-title h2 a:last-child:before,.page-title h2 a:last-child:after {
		      border-color: #ffffff;
		      border-left-color: transparent;
		    }
		
		.form-comment .media .media-left{
			    margin-right: 10px;
		    margin-bottom: 5px;
		}
		.form-comment .media .media-object{
			width: 30px !important;
		}
		.form-comment .form-group {
			margin-bottom: 1rem;
		}
		.red{
			color: red;
		}
		.btn-fb{
			margin-bottom: 15px !important;
		    color: #ffffff !important;
		    background: #4267b2;
		    border: 1px solid #4267b2;
		    border-radius: 3px;
		}
		.btn-gplus{
			margin-bottom: 15px !important;
		    color: #db4437 !important;
		    background: #ffffff;
		    border: 1px solid #9c9b9b;
		    border-radius: 3px;
		}
		.tags{
			padding: 10px 0;
		}
		/* .tags .label-default{
			color: #fff !important;
		} */
		.tags .label-default:hover{
			color: #31bde3 !important
		}
		.entry .entry-related {
			padding: 10px;
		    border-top: 1px solid #ccc;
		    border-bottom: 1px solid #ccc;
		}
		.entry .entry-related .list-cycle a{
		    color: #3b5998 !important;
		}
		.page-content table{
			width: 100% !important;
		}
		.comments{
			padding: 10px 15px 15px 15px !important;
		}
		.entry{
			text-align: justify;
		}
		</style>
	<%} 
}catch(Exception e){
	%>
	<div class="alert alert-warning">
	    <strong class="lead"><i class="icon-warning-sign"></i></strong> Hiện không có bài viết nào. Quay lại trang chủ  <a href="<%=themeDisplay.getURLHome() %>" class="alert-link">Tại đây</a>
	</div>
	<%
}
%>
 <aui:script>
  function shareGoogPlus(){
	  var thread_url = "<%=themeDisplay.getPortalURL()+themeDisplay.getURLCurrent() %>";
	 window.open("https://plus.google.com/share?url=" + thread_url, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
  }
</aui:script>
<script>
function validateEmail(obj) {
  var reg = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  	if(reg.test(obj)){
		return true;
	}else{
		return false;
	}
}
</script>