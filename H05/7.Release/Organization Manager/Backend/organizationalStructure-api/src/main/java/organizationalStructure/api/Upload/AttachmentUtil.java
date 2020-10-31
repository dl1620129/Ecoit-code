package organizationalStructure.api.Upload;

import java.io.File;
import java.util.Date;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadServletRequest;

import organizationalStructure.service.model.member;




public class AttachmentUtil {
	public static long uploadFile(UploadServletRequest upload, member member, File file, String title,
			long scopeGroupId, long userId) throws PortalException, SystemException {
		long entryId = 0;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), upload);
		Date dt = new Date();

		// ========== create folder year ==========
		DLFolder folderYear = null;
		try {
			folderYear = DLFolderLocalServiceUtil.getFolder(scopeGroupId, 0, "NAM_" + (dt.getYear() + 1900));
		} catch (Exception e) {
			folderYear = null;
		}
		if (folderYear == null) {
			folderYear = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false, 0,
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
		System.out.println("--------> bat dau them anh <----------");

		try {
			if ("".equals(title) || title == null)
				return 0;
			title = (new Date().toGMTString()) + title;
			title = title.replaceAll(":", "").replace(" ", "_").replace("[", "_").replace("]", "_");
			String mimeType = title.substring(title.lastIndexOf("."));

			DLFolder dlFolder = null;

			if (member.getFolderId() <= 0) {
				try {
					dlFolder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folderMonth.getFolderId(),
							"Image_avatar_" + member.getMemberId());
				} catch (Exception e) {
					dlFolder = null;
				}
				if (dlFolder == null) {
					dlFolder = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
							folderMonth.getFolderId(), "Image_avatar_" + member.getMemberId(), member.getFullName(),
							false, serviceContext);

				}

				member.setFolderId(dlFolder.getFolderId());
			} else {
				try {
					dlFolder = DLFolderLocalServiceUtil.getDLFolder(member.getFolderId());
				} catch (Exception e) {
					dlFolder = null;
				}
				if (dlFolder == null) {
					dlFolder = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
							folderMonth.getFolderId(), "Image_avatar_" + member.getMemberId(), member.getFullName(),
							false, serviceContext);
					member.setFolderId(dlFolder.getFolderId());
				}
			}
			System.out.println("--------> THEM MOI FILEENTRY<---------- FOLDERID: " + dlFolder.getFolderId());
			FileEntry images = DLAppLocalServiceUtil.addFileEntry(userId, scopeGroupId, dlFolder.getFolderId(), title,
					mimeType, title, "", "", file, serviceContext);
			return images.getPrimaryKey();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return entryId;
	}
	public static String viewDocument(long documentId) throws Exception {
		String src = "";
		try {
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(documentId));
			src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
					+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
					+ fileEntry.getCreateDate().getTime();
		} finally {
			System.out.println("url: "+src);
			return src;
		}
	}

}
