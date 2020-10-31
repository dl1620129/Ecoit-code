<%@page import="com.web.util.TreeCategory"%>
<%@ include file="../init.jsp" %>
<%@page pageEncoding="utf-8" %>
<portlet:defineObjects />  
<liferay-theme:defineObjects />  

<c:choose>
	<c:when test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.EDIT_CATEGORY, themeDisplay.getScopeGroupId())%>">
		<portlet:renderURL var="gotoViews"></portlet:renderURL>		
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset label="">
				<liferay-portlet:renderURL var="_addCategory">
					<portlet:param name="mvcRenderCommandName" value="/category/add_category"/>
					<portlet:param name="backURL" value="${themeDisplay.getURLCurrent()}"/>
				</liferay-portlet:renderURL>
				<liferay-portlet:renderURL var="_editCategory">
					<portlet:param name="mvcRenderCommandName" value="/category/edit_category"/>
					<portlet:param name="backURL" value="${themeDisplay.getURLCurrent()}"/>
					<portlet:param name="id-edit" value="0"/>
				</liferay-portlet:renderURL>
				<liferay-portlet:actionURL var="_deleteCategory" name= "/category/delete_category">
					<portlet:param name="cmd" value="delete"/>
					<portlet:param name="curent_url" value="${themeDisplay.getURLCurrent()}"/>
					<portlet:param name="id-delete" value="0"/>
				</liferay-portlet:actionURL>
				<aui:input id="search_tree" type="text" name="" placeholder="Tìm tên chuyên mục..." />
				<aui:button-row>
					<aui:button cssClass="btn btn-primary" icon="icon-plus" value="Thêm mới" onClick="document.location='${_addCategory}'" ></aui:button>
				</aui:button-row>
				<aui:row>
					<aui:col>
						<div style='float: left;width: 99%;font-size: 18px;border-top: 2px solid #bcbcbc;border-left: 1px solid #ececec;border-right: 1px solid #ececec;border-bottom: 2px solid #bcbcbc;; line-height: 30px;color: black;font-weight: 500'>
				           <div style='display: table-cell;width: 60%;float: left;'>Chuyên mục</div>
				           <div style='float: left;width: 25%;display: table-cell;'>Ngày tạo</div>
				           <div style='text-align: center; width: 15%; float: left;'>Sửa | Xóa</div>
				       </div>
				       <%
				 		String selected="";
						String showCategory="";
					    try{
							out.print(new TreeCategory().createCategoryTree(new long[]{0}, themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), selected, showCategory, 2, _editCategory, _deleteCategory, request));
						}
						catch(Exception e1){}
						%>
				       
					</aui:col>
				</aui:row>
			</aui:fieldset>
		</aui:fieldset-group>
	</c:when>
	<c:otherwise>
		<div class="alert">
			<p>Không có quyền thao tác</p>
		</div>
	</c:otherwise>
</c:choose>
<script>
	$(document).ready(function() {
		$("#<portlet:namespace/>search_tree").keyup(function(){
	    var filter = jQuery(this).val();
			var str=[];
	        jQuery(".elementCategory span").each(function () {
				if (jQuery(this).text().search(new RegExp(filter, "i")) < 0) {
					jQuery('#'+this.id.replace('span_','div_div_')).hide();
				} else {
					str=this.id.replace('span_','').split('_');
					var i=0;var tmp='';
					if(str.length>0){
						for(i=0;i<str.length;i++){
							if(tmp=='')tmp=str[i];
							else tmp+='_'+str[i];
							jQuery('#div_div_'+tmp).show();
						}
					}
				}
			});   
	    });
	});
</script>
<script>
	function openTree(d){
		if($("#tree_Category_sub_"+d).css("display") == 'none' ){
			$("#iconSup_"+d).attr("class","icon-minus");
			$("#tree_Category_sub_"+d).slideToggle("slow");
		}else{
			$("#iconSup_"+d).attr("class","icon-plus");
			$("#tree_Category_sub_"+d).slideToggle("slow");
		}
		
	}
	function openTreeChild(e){
		if($("#tree_Category_subChild_"+e).css("display") == 'none'){
			$("#iconSub_"+e).attr("class","icon-minus");
			$("#tree_Category_subChild_"+e).slideToggle("slow");
		}else{
			$("#iconSub_"+e).attr("class","icon-plus");
			$("#tree_Category_subChild_"+e).slideToggle("slow");
		}
		
	}
</script>
