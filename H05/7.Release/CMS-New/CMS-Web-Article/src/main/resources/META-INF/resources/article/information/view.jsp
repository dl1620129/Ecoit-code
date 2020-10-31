<%@page import="com.software.util.NewsWorkflowConstants"%>
<%@page import="java.util.Calendar"%>
<%@ include file="../../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<script src="<%=renderRequest.getContextPath() %>/js/highcharts.js"></script>
<script src="<%=renderRequest.getContextPath() %>/js/exporting.js"></script>
<script src="<%=renderRequest.getContextPath() %>/js/export-data.js"></script>
<aui:row>
	<aui:col md="12">
		<div id="article-infor" style="height: 400px; margin: 0 auto"></div>
	</aui:col>
	<%-- <aui:col md="6">
	</aui:col>	 --%>
</aui:row>

<%
	long groupId = themeDisplay.getScopeGroupId();
	String language = themeDisplay.getLanguageId();
	long userId = themeDisplay.getUserId();
	Calendar calendar = Calendar.getInstance();
	String textInforArt = "Thống kê tổng bài viết trong năm - "+calendar.get(Calendar.YEAR);
	String textInforViewCount = "Thống kê bài viết có lượt xem nhiều trong năm : "+calendar.get(Calendar.YEAR);
	int toltalDraf = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, NewsWorkflowConstants.STATUS_DRAFT, 0, "", "", "", false, false, false, false, null, null, false, false);
	int toltalPending = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, NewsWorkflowConstants.STATUS_PENDING, 0, "", "", "", false, false, false, false, null, null, false, false);
	int toltalAppove = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, NewsWorkflowConstants.STATUS_APPROVED, 0, "", "", "", false, false, false, false, null, null, false, false);
	int toltalPublish = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, NewsWorkflowConstants.STATUS_PUBLISH, 0, "", "", "", false, false, false, false, null, null, false, false);
	int toltalPublishDenied = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, NewsWorkflowConstants.STATUS_PUBLISH_DENIED, 0, "", "", "", false, false, false, false, null, null, false, false);
	int toltalApproveDenied = ArticleLocalServiceUtil.getCountByUserNews(groupId, language, userId, NewsWorkflowConstants.STATUS_APPROVE_DENIED, 0, "", "", "", false, false, false, false, null, null, false, false);
%>
<script>
Highcharts.chart('article-infor', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  credits:{
		  enabled:false
	  },
	  exporting: {
	        buttons: {
	          contextButton: {
	            menuItems: ['downloadPNG', 'downloadJPEG', 'downloadPDF', 'downloadSVG'],
	          },
	        },
	  },
	  title: {
	    text: '<%=textInforArt%>'
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: 'Tổng',
	    colorByPoint: true,
	    data: [{
	      name: 'Bản nháp',
	      y: <%=toltalDraf%>,
	      sliced: true,
	      selected: true
	    }, {
	      name: 'Chờ duyệt',
	      y: <%=toltalPending%>
	    }, {
	      name: 'Hủy xuất bản',
	      y: <%=toltalPublishDenied%>
	    }, {
	      name: 'Hủy duyệt',
	      y: <%=toltalApproveDenied%>
	    }, {
	      name: 'Đã duyệt',
	      y: <%=toltalAppove%>
	    }, {
	      name: 'Xuất bản',
	      y: <%=toltalPublish%>
	    }]
	  }]
	});
</script>

