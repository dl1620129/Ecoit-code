<%@page import="com.software.cms.article.portlet.ConfigUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page pageEncoding="utf-8" %>
<%@ include file="../init.jsp"%>

<%
String type = portletPreferences.getValue("type", "");
boolean flag1 = type.equals(ConfigUtil.THONG_TIN);
boolean flag2 = type.equals(ConfigUtil.BAI_VIET);
boolean flag3 = type.equals(ConfigUtil.QUAN_LY_CHUNG);
boolean flag4 = type.equals(ConfigUtil.THONG_KE);
boolean flag5 = type.equals(ConfigUtil.PHAN_QUYEN);
boolean flag6 = type.equals(ConfigUtil.NHAT_KY_HE_THONG);
boolean flag7 = type.equals(ConfigUtil.BAI_VIET_CHO_DUYET);
boolean flag8 = type.equals(ConfigUtil.BAI_VIET_DA_DUYET);
boolean flag9 = type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN);
boolean flag10 = type.equals(ConfigUtil.BAI_VIET_XEM_THEO_CHUYEN_MUC_CHO_DUYET);
boolean flag11 = type.equals(ConfigUtil.BAI_VIET_XEM_THEO_CHUYEN_MUC_DA_DUYET);
boolean flag12 = type.equals(ConfigUtil.BAI_VIET_XEM_THEO_CHUYEN_MUC);
boolean flag13 = type.equals(ConfigUtil.BAI_VIET_HUY_DUYET);
boolean flag14 = type.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN);
boolean flag15 = type.equals(ConfigUtil.BAI_VIET_BINH_LUAN);
boolean flag16 = type.equals(ConfigUtil.QUAN_LY_CHUYEN_MUC);
boolean flag17 = type.equals(ConfigUtil.QUAN_LY_DONG_SU_KIEN);
boolean flag18 = type.equals(ConfigUtil.QUAN_LY_TAGS);
boolean flag19 = type.equals(ConfigUtil.THONG_KE_BAI_VIET);
boolean flag20 = type.equals(ConfigUtil.THONG_KE_THEO_NGUOI_DUNG);
boolean flag21 = type.equals(ConfigUtil.THONG_KE_THEO_CHUYEN_MUC);
boolean flag22 = type.equals(ConfigUtil.BAI_VIET_NHAP);
%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="${configurationActionURL}" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="${configurationRenderURL}" />
	<aui:fieldset cssClass="sheet sheet-lg">
			<aui:select name="type" label="CHỌN KIỂU HIỂN THỊ">
				<aui:option value="${THONG_TIN }" selected="<%=flag1 %>" >THÔNG TIN</aui:option>
				<aui:option value="${BAI_VIET }" selected="<%=flag2%>">BÀI VIẾT</aui:option>
				<aui:option value="${THONG_KE }" selected="<%=flag4 %>">THỐNG KÊ</aui:option>
				<aui:option value="${NHAT_KY_HE_THONG }" selected="<%=flag6 %>">NHẬT KÝ HỆ THỐNG</aui:option>
				<aui:option value="${BAI_VIET_NHAP }" selected="<%=flag22 %>">BÀI VIẾT NHÁP</aui:option>
				<aui:option value="${BAI_VIET_CHO_DUYET }" selected="<%=flag7 %>">CHỜ DUYỆT</aui:option>
				<aui:option value="${BAI_VIET_DA_DUYET }" selected="<%=flag8 %>">ĐÃ DUYỆT</aui:option>
				<aui:option value="${BAI_VIET_DA_XUAT_BAN }" selected="<%=flag9 %>">ĐÃ XUẤT BẢN</aui:option>
				<aui:option value="${BAI_VIET_HUY_DUYET }" selected="<%=flag13 %>">HUỶ DUYỆT</aui:option>
				<aui:option value="${BAI_VIET_HUY_XUAT_BAN }" selected="<%=flag14 %>">HUỶ XUẤT BẢN</aui:option>
				<aui:option value="${BAI_VIET_BINH_LUAN }" selected="<%=flag15 %>">BÌNH LUẬN</aui:option>
				<aui:option value="${THONG_KE_BAI_VIET }" selected="<%=flag19 %>">THỐNG KÊ THEO BÀI VIẾT</aui:option>
			</aui:select>
	</aui:fieldset>
    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit" />
    </aui:button-row>
</aui:form>