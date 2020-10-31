package com.ecoit.qa.question.utils;

import com.ecoit.qa.service.utils.QuestionPermissionUtil;
import com.ecoit.qa.service.utils.QuestionRoleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class PermissionUtil {

	public static ArrayNode getPermissionNode(long userId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode acceptUserPermissison = mapper.createArrayNode();
		if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_EDIT)) {
			acceptUserPermissison.add("EDIT");
		}
		
		if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_APPROVED)) {
			acceptUserPermissison.add("APPROVED");
		}
			
		if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_PUBLISH)) {
			acceptUserPermissison.add("PUBLISH");
		}
		
		if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_APPROVED_RETURN)) {
			acceptUserPermissison.add("DENIEDAPPROVE");
		}
			
		if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_PUBLISH_RETURN)) {
			acceptUserPermissison.add("DENIEDPUBLISH");
		}
		
		if (QuestionPermissionUtil.checkPermissionAccessZone(userId, QuestionRoleConstants.QUESTION_REMOVE)) {
			acceptUserPermissison.add("REMOVE");
		}
		return acceptUserPermissison;
	}
}
