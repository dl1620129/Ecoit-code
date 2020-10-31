package com.ecoit.lichcongtac.util;


public class LichWorkflowConstants extends com.liferay.portal.kernel.workflow.WorkflowConstants {
	public static final int STATUS_PUBLISH = 10;
	public static final int STATUS_STABLE = 11;
	public static final int STATUS_PUBLISH_DENIED = 5;
	public static final int STATUS_APPROVE_DENIED = 6;
	public static final int STATUS_NOT_CREATE = -1;
	public static final int STATUS_NOT_SEND = -10;
	
	public static String labelNameStatus(int status) {
		String name = "";
		if (status == STATUS_PUBLISH) {
			name = "Xuất bản";
		} else if (status == STATUS_PUBLISH_DENIED) {
			name = "Hủy xuất bản";
		} else if (status == STATUS_APPROVE_DENIED) {
			name = "Hủy duyệt";
		} else if (status == LichWorkflowConstants.STATUS_DRAFT) {
			name = "Bản nháp";
		} else if (status == LichWorkflowConstants.STATUS_PENDING) {
			name = "Chờ duyệt";
		} else if (status == LichWorkflowConstants.STATUS_APPROVED) {
			name = "Phê duyệt";
		}
		return name;
	}
}
