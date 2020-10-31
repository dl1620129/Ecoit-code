package com.ecoit.elegaldocument.utils;

public class NewsWorkflowConstants extends com.liferay.portal.kernel.workflow.WorkflowConstants {
	public static final int STATUS_PUBLISH = 10;
	public static final int STATUS_PUBLISH_DENIED = 5;
	public static final int STATUS_APPROVE_DENIED = 6;
	public static final int STATUS_NOT_CREATE = -1;
	public static final int STATUS_NOT_SEND = -10;
	// public static final int STATUS_DRAFT = 2;
	// public static final int STATUS_PENDING = 1;
	// public static final int STATUS_APPROVED = 0;

	public static final int STATUS_SAVE_ART = 37;

	public static String labelNameStatus(int status) {
		String name = "";
		if (status == STATUS_PUBLISH) {
			name = "Đã xuất bản";
		} else if (status == STATUS_PUBLISH_DENIED) {
			name = "Hủy xuất bản";
		} else if (status == STATUS_APPROVE_DENIED) {
			name = "Hủy duyệt";
		} else if (status == NewsWorkflowConstants.STATUS_DRAFT) {
			name = "Bản nháp";
		} else if (status == NewsWorkflowConstants.STATUS_PENDING) {
			name = "Chờ duyệt";
		} else if (status == NewsWorkflowConstants.STATUS_APPROVED) {
			name = "Đã duyệt";
		}
		return name;
	}
}
