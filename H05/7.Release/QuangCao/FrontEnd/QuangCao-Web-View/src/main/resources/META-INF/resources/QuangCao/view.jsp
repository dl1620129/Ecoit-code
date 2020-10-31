<%@page import="com.web.ecoit.portal.quangcao.service.QuangCaoLocalServiceUtil"%>
<%@page import="com.web.ecoit.portal.quangcao.model.QuangCao"%>
<%@page import="com.web.quangcao.view.portlet.FileUtils"%>
<%@page import="java.net.URLDecoder"%>
<%@ include file="../init.jsp" %>
<%@page pageEncoding="utf-8" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/slick.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/slick.css">
<%
PortletPreferences prefs = renderRequest.getPreferences();
String quangCaoSelect = prefs.getValue("quangCaoSelect", "").trim();
boolean isQuangCaoSlider = Boolean.parseBoolean(prefs.getValue("isQuangCaoSlider", "false"));
String idQuangCaos [] = quangCaoSelect.split(",");
if(isQuangCaoSlider){
%>
<div class="section-logos">
	<div class="logos qc-slider-js">
		<%for(String st : idQuangCaos){
			String tenQuangCao = "";
			String url = "";
			String urlImage = "";
			String target = "";
			if(!st.equals("")){
				QuangCao quangCao = QuangCaoLocalServiceUtil.findBybyQuangCaoIdAndStatus(Long.valueOf(st), 0);
				tenQuangCao = quangCao.getTenQuangCao();
				url = URLDecoder.decode(quangCao.getUrl(), "UTF-8");
				if(quangCao.getImageId() > 0){
					urlImage = FileUtils.getUrlFileEntry(quangCao.getImageId(), themeDisplay);	
				}
				if(quangCao.getTarget()){
					target = "target='_blank'";
				}
			}
		%>
			<div class="logo-item">
				<a href="<%=url %>" class="logo-item-a" <%=target %>>
				 <div class="logo-img">
                    <img src="<%=urlImage %>" alt="<%=tenQuangCao%>">
                  </div>
                  <div class="logo-content">
                    <h3><%=tenQuangCao %></h3>
                  </div>
				</a>
			</div>
		<%} %>
	</div>
</div>
<script>
$(window).ready(function ($) {
	$('.qc-slider-js').slick({
	    dots: false,
	    infinite: true,
	    arrows:false,
	    autoplay:true,
	    // item: 5,
	    draggable:false,
	    variableWidth: true
	 });
});

</script>
<%}else{
	int sizeQC = idQuangCaos.length;
	int toltaQC = 12/sizeQC;
	String colMd = "col-md-"+toltaQC;
%>

<div class="row">
	<%for(String st : idQuangCaos){ 
			String tenQuangCao = "";
			String url = "";
			String urlImage = "";
			String target = "";
			if(!st.equals("")){
				QuangCao quangCao = QuangCaoLocalServiceUtil.findBybyQuangCaoIdAndStatus(Long.valueOf(st), 0);
				tenQuangCao = quangCao.getTenQuangCao();
				url = URLDecoder.decode(quangCao.getUrl(), "UTF-8");
				if(quangCao.getImageId() > 0){
					urlImage = FileUtils.getUrlFileEntry(quangCao.getImageId(), themeDisplay);	
				}
				if(quangCao.getTarget()){
					target = "target='_blank'";
				}
			}
		%>
		<div class="<%=colMd%>">
			<div class="high-remove-fk-qc">
				<a href="<%=url%>" <%=target %>>
	              <img src="<%=urlImage %>" alt="<%=tenQuangCao%>">
	            </a>
			</div>
		</div>
	<%} %>
</div>

<%}%>