package com.software.util;

import com.software.cms.model.Article;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;

public class PermissionUtil {
	public static boolean checkPermissionCategory(long userId,long categoryId){
		return GroupCategoryLocalServiceUtil.hasUserAccessCategory(userId, categoryId);
	}
	/**
	 * 
	 * @param userId user execute action
	 * @param articleId id of article ( 0 if create article )
	 * @return true if user can execute action into article, false if otherwise
	 */
	/*public static boolean checkPermissionArticle(long userId,long articleId){
		try {
			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			if (article.getCreatedByUser() == userId) return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}*/
	
	public static boolean checkPermissionArticle(long userId,long articleId){
		if(articleId<=0) return true;
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
	public static boolean checkPermissionAccessZone(long userId,long permission,long groupId){
		try {
			long groupUserId = GroupUserUsersLocalServiceUtil.findByUser_Group(userId, groupId).get(0).getGroupUserId();
			return PermissionGroupLocalServiceUtil.hasPermissionGroup(permission, groupUserId);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
	
}
