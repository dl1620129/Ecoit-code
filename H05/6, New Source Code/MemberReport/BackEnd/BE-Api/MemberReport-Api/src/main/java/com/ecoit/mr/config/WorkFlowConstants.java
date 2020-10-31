package com.ecoit.mr.config;

import com.liferay.portal.kernel.workflow.WorkflowConstants;

public class WorkFlowConstants extends WorkflowConstants {
	public static final int STATUS_PUBLISH = 10;
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
		} else if (status == WorkFlowConstants.STATUS_DRAFT) {
			name = "Bản nháp";
		} else if (status == WorkFlowConstants.STATUS_PENDING) {
			name = "Chờ duyệt";
		} else if (status == WorkFlowConstants.STATUS_APPROVED) {
			name = "Phê duyệt";
		}
		return name;
	}
}
