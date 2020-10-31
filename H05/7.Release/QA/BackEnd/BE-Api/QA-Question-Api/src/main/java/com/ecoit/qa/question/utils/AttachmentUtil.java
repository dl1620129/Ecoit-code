package com.ecoit.qa.question.utils;

import java.io.File;
import java.util.Calendar;
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
import com.liferay.portal.kernel.util.LocaleUtil;

public class AttachmentUtil {
	public static long uploadFile(UploadServletRequest upload, File file, String title, String locale,
			String questionTitle, long scopeGroupId, long userId) throws PortalException, SystemException {
		long entryId = 0;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), upload);
		Date dt = new Date();
		Calendar calendar = Calendar.getInstance(LocaleUtil.fromLanguageId(locale));
		calendar.setTime(dt);
		// ========== create folder year ==========
		DLFolder folderYear = null;
		try {
			folderYear = DLFolderLocalServiceUtil.getFolder(scopeGroupId, 0, "NAM_" + (calendar.get(Calendar.YEAR) + 1900));
		} catch (Exception e) {
			folderYear = null;
		}
		if (folderYear == null) {
			folderYear = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false, 0,
					"NAM_" + (calendar.get(Calendar.YEAR) + 1900), "NAM_" + (calendar.get(Calendar.YEAR) + 1900), false, serviceContext);
		}

		DLFolder folderMonth = null;
		try {
			folderMonth = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folderYear.getFolderId(),
					"THANG_" + (calendar.get(Calendar.MONTH) + 1));
			// System.out.println("-------->tim duoc folder Thang<----------: "+"THANG_" +
			// (dt.getMonth()+1));
		} catch (Exception e) {
			folderMonth = null;
		}
		if (folderMonth == null) {
			folderMonth = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
					folderYear.getFolderId(), "THANG_" + (calendar.get(Calendar.MONTH) + 1), "THANG_" + (calendar.get(Calendar.MONTH) + 1), false,
					serviceContext);
		}
		System.out.println("--------> bat dau them anh <----------");

		try {
			if ("".equals(title) || title == null)
				return 0;
			title = (dt.getTime()) + title;
			title = title.replaceAll(":", "").replace(" ", "_").replace("[", "_").replace("]", "_");
			String mimeType = title.substring(title.lastIndexOf("."));

			DLFolder dlFolder = null;

			try {
				dlFolder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folderMonth.getFolderId(),
						"QuestionAttachment");
			} catch (Exception e) {
				dlFolder = null;
			}
			if (dlFolder == null) {
				dlFolder = DLFolderLocalServiceUtil.addFolder(userId, scopeGroupId, scopeGroupId, false,
						folderMonth.getFolderId(), "QuestionAttachment", questionTitle,
						false, serviceContext);

			}
			System.out.println("--------> THEM MOI FILEENTRY<---------- FOLDERID: " + dlFolder.getFolderId());
			FileEntry image = DLAppLocalServiceUtil.addFileEntry(userId, scopeGroupId, dlFolder.getFolderId(), title,
					mimeType, title, "", "", file, serviceContext);
			return image.getPrimaryKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryId;
	}
	
	public static String viewDocument(long documentId) throws Exception {
		String src = "";
		try {
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(documentId);
			src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
					+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t="
					+ fileEntry.getCreateDate().getTime();

		} finally {
			
		}
		return src;
	}
	
	public static boolean checkAttachmentName(String name) {
		boolean isAttachment = false;
		if (name.endsWith("doc") || name.endsWith("docx") || name.endsWith("pdf") || name.endsWith("zip") || name.endsWith("rar")) {
			isAttachment = true;
		}
		return isAttachment;
	}
}
