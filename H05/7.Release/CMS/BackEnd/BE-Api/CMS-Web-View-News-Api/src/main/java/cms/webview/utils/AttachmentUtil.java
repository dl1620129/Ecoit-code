package cms.webview.utils;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;

public class AttachmentUtil {

	/*
	 * public static String getURLImage(RenderRequest renderRequest, RenderResponse
	 * renderResponse, ThemeDisplay themeDisplay, String documentId) { String src =
	 * ""; try { FileEntry fileEntry =
	 * DLAppServiceUtil.getFileEntry(Long.valueOf(documentId)); FileVersion
	 * fileVersion = fileEntry.getFileVersion(); src =
	 * DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, ""); src =
	 * com.liferay.portal.kernel.util.HttpUtil.removeParameter(src, "version");
	 * return src; } catch (Exception e) { } return
	 * renderResponse.encodeURL(renderRequest.getContextPath() +
	 * "/res/no-image.jpg"); }
	 * 
	 * public static String viewDocument(RenderRequest renderRequest, RenderResponse
	 * renderResponse, ThemeDisplay themeDisplay, String documentId, String size) {
	 * String src = ""; try { FileEntry fileEntry =
	 * DLAppServiceUtil.getFileEntry(Long.valueOf(documentId)); FileVersion
	 * fileVersion = fileEntry.getFileVersion(); src =
	 * DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, ""); src =
	 * com.liferay.portal.kernel.util.HttpUtil.removeParameter(src, "version"); }
	 * catch (Exception e) { src =
	 * renderResponse.encodeURL(renderRequest.getContextPath() +
	 * "/images/noimage.png"); } return src; }
	 */

	public static String viewDocument(String documentId) throws Exception {
		String src = "";
		try {
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(documentId));
			src = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFileEntryId() + "/"
					+ fileEntry.getFileName() + "/" + fileEntry.getUuid() + "?t=" + fileEntry.getCreateDate().getTime();
		} finally {
			return src;
		}
	}

}
