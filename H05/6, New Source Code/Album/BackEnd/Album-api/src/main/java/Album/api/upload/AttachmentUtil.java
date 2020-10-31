package Album.api.upload;

import java.io.File;
import java.util.Date;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.WebKeys;

import Album.service.model.Image;


public class AttachmentUtil {
	public static long uploadFile(UploadServletRequest upload, Image image, File file, String title,
			long scopeGroupId, long userId,long companyId) throws PortalException, SystemException {
		long entryId = 0;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), upload);
		Date dt = new Date();

		// ========== create folder root ==========
		DLFolder folderRoot = null;
		try {
			folderRoot = DLFolderLocalServiceUtil.getFolder(scopeGroupId, 0, "THU_VIEN_ANH");
		} catch (Exception e) {
			folderRoot = null;
		}
		if (folderRoot == null) {
			folderRoot = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false, 0,
					"THU_VIEN_ANH", "THU_VIEN_ANH", false, serviceContext);
		}

		// ========== create folder year ==========
		DLFolder folderYear = null;
		try {
			folderYear = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folderRoot.getFolderId(), "NAM_" + (dt.getYear() + 1900));
		} catch (Exception e) {
			folderYear = null;
		}
		if (folderYear == null) {
			folderYear = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false, folderRoot.getFolderId(),
					"NAM_" + (dt.getYear() + 1900), "NAM_" + (dt.getYear() + 1900), false, serviceContext);
		}

		DLFolder folderMonth = null;
		try {
			folderMonth = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folderYear.getFolderId(),
					"THANG_" + (dt.getMonth() + 1));
			// System.out.println("-------->tim duoc folder Thang<----------: "+"THANG_" +
			// (dt.getMonth()+1));
		} catch (Exception e) {
			folderMonth = null;
		}
		if (folderMonth == null) {
			folderMonth = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
					folderYear.getFolderId(), "THANG_" + (dt.getMonth() + 1), "THANG_" + (dt.getMonth() + 1), false,
					serviceContext);
		}
	

		try {
			if ("".equals(title) || title == null)
				return 0;
			title = (new Date().toGMTString()) + title;
			title = title.replaceAll(":", "").replace(" ", "_").replace("[", "_").replace("]", "_");
			String mimeType = title.substring(title.lastIndexOf("."));

			DLFolder dlFolder = null;

			if (image.getFolderId() <= 0) {
				try {
					dlFolder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folderMonth.getFolderId(),
							"Image_" + image.getImageId());
				} catch (Exception e) {
					dlFolder = null;
				}
				if (dlFolder == null) {
					dlFolder = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
							folderMonth.getFolderId(), "Image_" + image.getImageId(), image.getTitle(),
							false, serviceContext);

				}

				image.setFolderId(dlFolder.getFolderId());
			} else {
				try {
					dlFolder = DLFolderLocalServiceUtil.getDLFolder(image.getFolderId());
				} catch (Exception e) {
					dlFolder = null;
				}
				if (dlFolder == null) {
					dlFolder = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
							folderMonth.getFolderId(), "Image_" + image.getImageId(), image.getTitle(),
							false, serviceContext);
					image.setFolderId(dlFolder.getFolderId());
				}
			}
		
			FileEntry images = DLAppLocalServiceUtil.addFileEntry(userId, scopeGroupId, dlFolder.getFolderId(), title,
					mimeType, title, "", "", file, serviceContext);
			definePermission(images.getFileEntryId(),companyId, "Guest",new String[] {ActionKeys.VIEW});
			return images.getFileEntryId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryId;
	}
	public static boolean definePermission(long fileAttachId, long companyId,String userName, String actionIds[]) {

		int scope = 4;
		String primKey = Long.toString(fileAttachId);
		String name = "com.liferay.document.library.kernel.model.DLFileEntry";
		long roleId = getUserRoleId(userName, companyId);

		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, name, scope,
					primKey, roleId, actionIds);
			return true;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static long getUserRoleId(String userName, long companyId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, userName).getClassPK();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static String viewDocument(long documentId) throws Exception {
		String src = "";
		try {
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(documentId));
			src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
					+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
					+ fileEntry.getCreateDate().getTime();
		} finally {
			
			
		}
		return src;
	}

}
