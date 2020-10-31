package cms.article.util;

import com.software.util.NewsWorkflowConstants;

import cms.article.config.ConfigUtil;

public class ArticleCheck {

	public static boolean checkImageName(String name) {
		boolean imnage = true;
		if (name.endsWith("png") || name.endsWith("jpg") || name.endsWith("jpeg")) {
			imnage = false;
		}
		return imnage;
	}

	public void checkPageView(String type) {
		long status = NewsWorkflowConstants.STATUS_DRAFT;
		if (type.equals(ConfigUtil.BAI_VIET_NHAP))
			status = NewsWorkflowConstants.STATUS_DRAFT;
		if (type.equals(ConfigUtil.BAI_VIET_CHO_DUYET))
			status = NewsWorkflowConstants.STATUS_PENDING;
		if (type.equals(ConfigUtil.BAI_VIET_DA_DUYET))
			status = NewsWorkflowConstants.STATUS_APPROVED;
		if (type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN))
			status = NewsWorkflowConstants.STATUS_PUBLISH;
		if (type.equals(ConfigUtil.BAI_VIET_HUY_DUYET))
			status = NewsWorkflowConstants.STATUS_APPROVE_DENIED;
		if (type.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN))
			status = NewsWorkflowConstants.STATUS_PUBLISH_DENIED;
	}
}
