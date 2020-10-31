package com.software.util;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.software.cms.model.Article;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;

public class PermissionUtil {
	public static boolean checkPermissionCategory(long userId, long categoryId) {
		return GroupCategoryLocalServiceUtil.hasUserAccessCategory(userId, categoryId);
	}

	/**
	 * 
	 * @param userId    user execute action
	 * @param articleId id of article ( 0 if create article )
	 * @return true if user can execute action into article, false if otherwise
	 */
	/*
	 * public static boolean checkPermissionArticle(long userId,long articleId){ try
	 * { Article article = ArticleLocalServiceUtil.getArticle(articleId); if
	 * (article.getCreatedByUser() == userId) return true;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return true; }
	 */

	public static boolean checkPermissionArticle(long userId, long articleId) {
		if (articleId <= 0)
			return true;
		else {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				if (article.getCreatedByUser() == userId)
					return true;

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return true;
		}
	}

	/**
	 * 
	 * @param userId
	 * @param permission
	 * @param groupId
	 * @return
	 */
	public static boolean checkPermissionAccessZone(long userId, long permission, long groupId) {
		try {
			boolean isAccess = false;
			List<GroupUserUsers> groupUsersList = GroupUserUsersLocalServiceUtil.findByUser_Group(userId, groupId);
			for (GroupUserUsers groupUser :  groupUsersList) {
				System.out.println("groupUserId---" + groupUser.getGroupUserId()); 
				if (PermissionGroupLocalServiceUtil.hasPermissionGroup(permission, groupUser.getGroupUserId())) {
					isAccess = true;
				}
			}
			return isAccess;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}

	
	public static ArrayNode getPermissionNode(long userId, long groupId) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode acceptUserPermissison = mapper.createArrayNode();
		if (checkPermissionAccessZone(userId, RoleConstants.ARTICLE_ADD, groupId)) {
			acceptUserPermissison.add("ADD");
		}
		
		/*if (checkPermissionAccessZone(userId, RoleConstants.ARTICLE_APPROVED, groupId)) {
			acceptUserPermissison.add("APPROVED");
		}
			
		if (checkPermissionAccessZone(userId, RoleConstants.ARTICLE_PUBLISH, groupId)) {
			acceptUserPermissison.add("PUBLISH");
		}
		
		if (checkPermissionAccessZone(userId, RoleConstants.ARTICLE_APPROVED_RETURN, groupId)) {
			acceptUserPermissison.add("DENIEDAPPROVE");
		}
			
		if (checkPermissionAccessZone(userId, RoleConstants.ARTICLE_PUBLISH_RETURN, groupId)) {
			acceptUserPermissison.add("DENIEDPUBLISH");
		}
		
		if (checkPermissionAccessZone(userId, RoleConstants.ARTICLE_PENDING, groupId)) {
			acceptUserPermissison.add("PENDING");
		}*/
		return acceptUserPermissison;
	}
}
