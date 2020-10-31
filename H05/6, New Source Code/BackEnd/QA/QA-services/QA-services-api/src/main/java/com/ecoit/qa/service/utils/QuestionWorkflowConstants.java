package com.ecoit.qa.service.utils;

import com.liferay.portal.kernel.workflow.WorkflowConstants;

public class QuestionWorkflowConstants extends WorkflowConstants {
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
			name = "Ä�Ã£ xuáº¥t báº£n";
		} else if (status == STATUS_PUBLISH_DENIED) {
			name = "Há»§y xuáº¥t báº£n";
		} else if (status == STATUS_APPROVE_DENIED) {
			name = "Há»§y duyá»‡t";
		} else if (status == QuestionWorkflowConstants.STATUS_DRAFT) {
			name = "Báº£n nhÃ¡p";
		} else if (status == QuestionWorkflowConstants.STATUS_PENDING) {
			name = "Chá»� duyá»‡t";
		} else if (status == QuestionWorkflowConstants.STATUS_APPROVED) {
			name = "Ä�Ã£ duyá»‡t";
		}
		return name;
	}
}
