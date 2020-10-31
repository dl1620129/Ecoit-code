package com.ecoit.qa.question.utils;

import com.ecoit.qa.service.utils.QuestionRoleConstants;
import com.ecoit.qa.service.utils.QuestionWorkflowConstants;

public class QuestionUtil {
	
	public static int getQuestionStatus(int action) {
		int statusDoc = QuestionWorkflowConstants.STATUS_DRAFT;
		switch(action) {
		case QuestionRoleConstants.QUESTION_PENDING:
			statusDoc = QuestionWorkflowConstants.STATUS_PENDING;
		    break;
		case QuestionRoleConstants.QUESTION_APPROVED:
			statusDoc = QuestionWorkflowConstants.STATUS_APPROVED;
		    break;
		case QuestionRoleConstants.QUESTION_PUBLISH:
			statusDoc = QuestionWorkflowConstants.STATUS_PUBLISH;
		    break;
		case QuestionRoleConstants.QUESTION_APPROVED_RETURN:
			statusDoc = QuestionWorkflowConstants.STATUS_APPROVE_DENIED;
		    break;
		case QuestionRoleConstants.QUESTION_PUBLISH_RETURN:
			statusDoc = QuestionWorkflowConstants.STATUS_PUBLISH_DENIED;
		    break;
		}
		return statusDoc;
	}
}
