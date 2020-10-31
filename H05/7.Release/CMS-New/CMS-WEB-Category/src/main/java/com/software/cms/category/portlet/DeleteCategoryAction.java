package com.software.cms.category.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.category.constants.CategoryControllerPortletKeys;
import com.software.cms.model.Article;
import com.software.cms.model.Category;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.Comment;
import com.software.cms.service.ArticleLocalService;
import com.software.cms.service.CategoryArticleLocalService;
import com.software.cms.service.CategoryLocalService;
import com.software.cms.service.CommentLocalService;
import com.software.cms.service.GroupCategoryLocalService;
import com.software.util.PermissionUtil;
import com.software.util.RoleConstants;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + CategoryControllerPortletKeys.CATEGORYCONTROLLER,
	        "mvc.command.name=/category/delete_category"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteCategoryAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long idDelete = ParamUtil.getLong(request, "id-delete", 0);
		long articleId = 0;
		String curent_url = ParamUtil.getString(request, "curent_url");
		
		try {
			
			if (idDelete < 0) {
				throw new Exception();
			}
			else if (idDelete == 0) {
				List<CategoryArticle> lCA = _categoryArticleService.findByCategory(idDelete);
				if (lCA != null && lCA.size() > 0) {
					for (CategoryArticle ca : lCA) {
						articleId = ca.getArticleId();
						if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), articleId)
								&& PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(),
										RoleConstants.ARTICLE_REMOVE, themeDisplay.getScopeGroupId())) {
							try {
								Article article = _articleService.getArticle(articleId);
								String imageId = article.getImage().trim();
								if (!imageId.equals("") && !imageId.equals("0")) {
									try {
										DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.parseLong(imageId));
									} catch (Exception e1) {
									}
								}
								_articleService.deleteArticle(articleId);
								List<Comment> comm = _commentService.findByArticleId(themeDisplay.getSiteGroupId(),articleId);
								for (int i = 0; i < comm.size(); i++) {
									_commentService.deleteComment(comm.get(i));
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					_categoryArticleService.removeByCategory(idDelete);
				}
				_categoryService.deleteCategory(idDelete);
			} else {
				if (_categoryArticleService.getCountById(idDelete) <= 0) {
					Category cate = _categoryService.getCategory(idDelete);
					List<Category> lstCate = _categoryService.getCateTheoSQL("select * from soft_cms_category where parentid=" + cate.getCategoryId());
					if (lstCate == null || lstCate.size() <= 0) {
						lstCate = _categoryService.getCateTheoSQL("select * from soft_cms_category where (',' || catechild || ',') like '%,"+ cate.getCategoryId() + ",%'");
						if (lstCate != null && lstCate.size() > 0) {
							String str = "";
							for (Category cat : lstCate) {
								str = "";
								for (String st : cat.getCateChild().split(",")) {
									if (idDelete != Long.valueOf(st)) {
										if (str.equals("")) {
											str = st;
										} else {
											str += "," + st;
										}
									}
								}
								cat.setCateChild(str);
								_categoryService.updateCategory(cat);
							}
						}
						_groupCategoryService.removeByCategoryId(idDelete);
						_categoryService.deleteCategory(idDelete);
						// addLogger(request, response, cate, themeDisplay, logger, "delete");
					} else {
						SessionErrors.add(request, "error_has_child_category");
					}
				} else {
					SessionErrors.add(request, "error_has_article");
				}
			}
		} catch (Exception ex) {
			SessionErrors.add(request, "error_remove_unsuccessful");
		}
		response.sendRedirect(curent_url);
	}
	
	@Reference(unbind = "-")
	protected void setCategoryService(CategoryLocalService categoryService) {
		_categoryService = categoryService;
	}
	private CategoryLocalService _categoryService;
	
	@Reference(unbind = "-")
	protected void setCategoryArticleService(CategoryArticleLocalService categoryArticleService) {
		_categoryArticleService = categoryArticleService;
	}
	private CategoryArticleLocalService _categoryArticleService;
	
	@Reference(unbind = "-")
	protected void setArticleService(ArticleLocalService articleService) {
		_articleService = articleService;
	}
	private ArticleLocalService _articleService;
	
	@Reference(unbind = "-")
	protected void setCommentService(CommentLocalService commentService) {
		_commentService = commentService;
	}
	private CommentLocalService _commentService;
	
	@Reference(unbind = "-")
	protected void setGroupCategoryService(GroupCategoryLocalService groupCategoryService) {
		_groupCategoryService = groupCategoryService;
	}
	private GroupCategoryLocalService _groupCategoryService;
}
