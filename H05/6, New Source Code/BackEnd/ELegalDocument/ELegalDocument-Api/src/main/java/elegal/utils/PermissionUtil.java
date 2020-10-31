package elegal.utils;

import com.ecoit.elegaldocument.model.GroupCategory;
import com.ecoit.elegaldocument.model.GroupField;
import com.ecoit.elegaldocument.model.GroupOrganization;
import com.ecoit.elegaldocument.service.EcmsGURelationServiceUtil;
import com.ecoit.elegaldocument.service.EcmsPGRelationServiceUtil;
import com.ecoit.elegaldocument.service.GroupCategoryLocalServiceUtil;
import com.ecoit.elegaldocument.service.GroupFieldLocalServiceUtil;
import com.ecoit.elegaldocument.service.GroupOrganizationLocalServiceUtil;
import com.ecoit.elegaldocument.utils.DocumentPermissionUtil;
import com.ecoit.elegaldocument.utils.DocumentRoleConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;

public class PermissionUtil {
	
	public static boolean checkPermission(long groupId, int permission) {
		return EcmsPGRelationServiceUtil.checkPermission(groupId, permission);
	}
	
	public static boolean userHasType(long userId, long typeId) throws Exception {
		List<GroupCategory> groupTypesList = GroupCategoryLocalServiceUtil.getByCategory(typeId);
		for (GroupCategory groupCategory : groupTypesList) {
			if (EcmsGURelationServiceUtil.isContain(groupCategory.getGroupUserId(), userId)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean userHasField(long userId, long fieldId) throws Exception {
		List<GroupField> groupFieldsList = GroupFieldLocalServiceUtil.getByField(fieldId);
		for (GroupField groupField : groupFieldsList) {
			if (EcmsGURelationServiceUtil.isContain(groupField.getGroupUserId(), userId)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean userHasOrganization(long userId, long organizationId) throws Exception {
		List<GroupOrganization> groupOrgsList = GroupOrganizationLocalServiceUtil.getByOrganization(organizationId);
		for (GroupOrganization groupOrg : groupOrgsList) {
			if (EcmsGURelationServiceUtil.isContain(groupOrg.getGroupUserId(), userId)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayNode getPermissionNode(long groupId, long userId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode acceptUserPermissison = mapper.createArrayNode();
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_ADD)) {
			acceptUserPermissison.add("ADD");
		}

		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_EDIT)) {
			acceptUserPermissison.add("EDIT");
		}
		
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_APPROVED)) {
			acceptUserPermissison.add("APPROVED");
		}
			
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_PUBLISH)) {
			acceptUserPermissison.add("PUBLISH");
		}
		
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_APPROVED_RETURN)) {
			acceptUserPermissison.add("DENIEDAPPROVE");
		}
			
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_PUBLISH_RETURN)) {
			acceptUserPermissison.add("DENIEDPUBLISH");
		}
		
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_REMOVE)) {
			acceptUserPermissison.add("REMOVE");
		}
		
		if (DocumentPermissionUtil.checkPermissionAccessZone(groupId, userId, DocumentRoleConstants.DOCUMENT_PENDING)) {
			acceptUserPermissison.add("PENDING");
		}
		return acceptUserPermissison;
	}

}
