package adv.manager.utils;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.Validator;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

public class FileUtils {

	public static File byteArrayToFile(byte[] bytearray, String pathFile) throws IOException {
		File file = new File(pathFile);
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytearray);
		fos.close();
		return file;
	}

	public static void fileUploadByDL(UploadServletRequest upload, long userId, long groupId, long repositoryId,
			String duongDanFileLocal, String folderName) {
		File file = new File(duongDanFileLocal);
		System.out.println("Exist=>" + file.exists());
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String description = "This file is added via programatically";
		String changeLog = "hi";
		try {
			DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, 0, folderName);
			long fileEntryTypeId = dlFolder.getDefaultFileEntryTypeId();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), upload);
			InputStream is = new FileInputStream(file);
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, repositoryId,
					dlFolder.getFolderId(), file.getName(), mimeType, title, description, changeLog, fileEntryTypeId,
					null, file, is, file.getTotalSpace(), serviceContext);

			// Change mode of Draft to Approved

			DLFileEntryLocalServiceUtil.updateFileEntry(userId, dlFileEntry.getFileEntryId(), file.getName(),
					MimeTypesUtil.getContentType(file), title, description, "Draft to save", true,
					dlFileEntry.getFileEntryTypeId(), null, file, null, file.getTotalSpace(), serviceContext);
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	public static Folder getFolder(long groupId) {
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "FileLuuTru");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return folder;
	}

	public static Folder getOrCreateFolder(final ServiceContext serviceContext, long userId, long groupId,
			String folderName) throws PortalException, SystemException {
		final long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		final long repositoryId = groupId;

		try {
			final Folder prev = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			return prev;
		} catch (final NoSuchFolderException e) {
			final Folder newFolder = DLAppLocalServiceUtil.addFolder(userId, repositoryId, parentFolderId, folderName,
					"My cool new folder", serviceContext);
			return newFolder;
		}
	}

	public static String getTitleFileEntry(long fileEntryID) throws PortalException, SystemException {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryID);
		fileEntry = fileEntry.toEscapedModel();
		String title = fileEntry.getTitle();
		return title;
	}

	public static String getUrlFileEntry(Long fileEntryID, long groupId) throws PortalException, SystemException {
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryID);
		fileEntry = fileEntry.toEscapedModel();

		return "/documents/" + groupId + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle();
	}

	public static boolean isFolderExist(long groupId, String folder_name) {
		boolean folderExist = false;
		try {
			DLAppLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folder_name);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return folderExist;
	}

	public static FileEntry uploadFileFormLocalToServer(UploadServletRequest upload, long groupId, long siteGroup,
			long userId, File file, String nameFile, String nameFolder) throws Exception {
		FileEntry fileEntry = null;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), upload);
		Folder folder = getOrCreateFolder(serviceContext, userId, siteGroup, nameFolder);

		// file

		System.out.println("uploadFileFormLocalToServer");

		if (file.exists()) {
			System.out.println("file.exists()");

			long folderId = folder.getFolderId();
			long repositoryId = groupId;

			String sourceFileName = file.getName();
			String mimeType = MimeTypesUtil.getContentType(file);

			String title = Long.toString(System.currentTimeMillis()) + "-" + nameFile;// TĂªn

			String description = file.getName();

			// Log

			String changeLog = "Xuat file PDF";

			// ServiceContext serviceContext = new ServiceContext();

			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, sourceFileName, mimeType,
					title, description, changeLog, file, serviceContext);

			/*
			 * AssetPublisherUtil.addAndStoreSelection(upload, DLFileEntry.class.getName(),
			 * fileEntry.getFileEntryId(), -1);
			 */

			ResourcePermission resourcePermission = null;
			final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST);
			System.out.println("siteMemberRole: " + siteMemberRole);
			ResourceAction resourceAction = ResourceActionLocalServiceUtil
					.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
			try {
				resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(fileEntry.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(fileEntry.getPrimaryKey()), siteMemberRole.getRoleId());

				if (Validator.isNotNull(resourcePermission)) {
					System.out.println("Validator.isNotNull(resourcePermission) ");

					resourcePermission.setActionIds(resourceAction.getBitwiseValue());
					ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
				}
			} catch (NoSuchResourcePermissionException e) {
				System.out.println("catch ");
				resourcePermission = ResourcePermissionLocalServiceUtil
						.createResourcePermission(CounterLocalServiceUtil.increment());
				resourcePermission.setCompanyId(fileEntry.getCompanyId());
				resourcePermission.setName(DLFileEntry.class.getName());
				resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
				resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
				resourcePermission.setRoleId(siteMemberRole.getRoleId());
				resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
			}
		}

		return fileEntry;
	}

	public static FileEntry uploadFileFormLocalToServer(HttpServletRequest upload, long userId, long siteGroup,
			long groupId, String filename, String nameFolder) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), upload);
		FileEntry fileEntry = null;
		Folder folder = getOrCreateFolder(serviceContext, userId, siteGroup, nameFolder);

		// file

		System.out.println("uploadFileFormLocalToServer");
		File file = new File(filename);

		if (file.exists()) {
			System.out.println("file.exists()");

			long folderId = folder.getFolderId();
			long repositoryId = groupId;

			// TĂªn file

			String sourceFileName = file.getName();

			// Kiá»ƒu file

			String mimeType = MimeTypesUtil.getContentType(file);
			String title = Long.toString(System.currentTimeMillis()) + "-" + sourceFileName;// TĂªn
			String description = file.getName();
			String changeLog = "Xuat file PDF";
			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, sourceFileName, mimeType,
					title, description, changeLog, file, serviceContext);

			ResourcePermission resourcePermission = null;
			final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST);
			System.out.println("siteMemberRole: " + siteMemberRole);
			ResourceAction resourceAction = ResourceActionLocalServiceUtil
					.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
			try {
				resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(fileEntry.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(fileEntry.getPrimaryKey()), siteMemberRole.getRoleId());

				if (Validator.isNotNull(resourcePermission)) {
					System.out.println("Validator.isNotNull(resourcePermission) ");

					resourcePermission.setActionIds(resourceAction.getBitwiseValue());
					ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
				}
			} catch (NoSuchResourcePermissionException e) {
				System.out.println("catch ");
				resourcePermission = ResourcePermissionLocalServiceUtil
						.createResourcePermission(CounterLocalServiceUtil.increment());
				resourcePermission.setCompanyId(fileEntry.getCompanyId());
				resourcePermission.setName(DLFileEntry.class.getName());
				resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
				resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
				resourcePermission.setRoleId(siteMemberRole.getRoleId());
				resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
			}
		}

		return fileEntry;
	}

	public static boolean XoaFile(long idFileEntry) throws PortalException, SystemException {
		boolean isValid = false;
		try {
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(idFileEntry);
			isValid = true;
		} catch (Exception e) {
			isValid = false;
		}

		System.out.println("isValid: " + isValid);
		return isValid;
	}

	public static ArrayList<FileEntry> uploadNhieuFile(HttpServletRequest upload, Map<String, FileItem[]> files,
			String nameFolder, long userId, long siteGroup, long groupId) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), upload);
		Folder folder = getOrCreateFolder(serviceContext, userId, siteGroup, nameFolder);
		InputStream is;
		File file;
		String title, description, mimeType;
		long repositoryId;
		FileEntry fileEntry = null;
		ArrayList<FileEntry> listFileEntry = new ArrayList<FileEntry>();

		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			FileItem item[] = file2.getValue();

			try {
				for (FileItem fileItem : item) {
					title = Long.toString(System.currentTimeMillis()) + "-" + fileItem.getFileName();// TĂªn

					// file

					System.out.println(fileItem.getFileName() + "" + fileItem.getFileNameExtension() + "/"
							+ fileItem.getFieldName() + "/" + fileItem.getFullFileName());
					description = title + " is added via programatically";
					repositoryId = groupId;

					mimeType = fileItem.getContentType();
					file = fileItem.getStoreLocation();
					is = fileItem.getInputStream();

					try {
						fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folder.getFolderId(),
								title, mimeType, title, description, "", is, file.getTotalSpace(), serviceContext);

						ResourcePermission resourcePermission = null;
						final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(),
								RoleConstants.GUEST);
						System.out.println("siteMemberRole: " + siteMemberRole);
						ResourceAction resourceAction = ResourceActionLocalServiceUtil
								.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
						try {
							resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(
									fileEntry.getCompanyId(), DLFileEntry.class.getName(),
									ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getPrimaryKey()),
									siteMemberRole.getRoleId());

							if (Validator.isNotNull(resourcePermission)) {
								System.out.println("Validator.isNotNull(resourcePermission) ");

								resourcePermission.setActionIds(resourceAction.getBitwiseValue());
								ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
							}
						} catch (NoSuchResourcePermissionException e) {
							System.out.println("catch ");
							resourcePermission = ResourcePermissionLocalServiceUtil
									.createResourcePermission(CounterLocalServiceUtil.increment());
							resourcePermission.setCompanyId(fileEntry.getCompanyId());
							resourcePermission.setName(DLFileEntry.class.getName());
							resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
							resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
							resourcePermission.setRoleId(siteMemberRole.getRoleId());
							resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
							ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
						}

						listFileEntry.add(fileEntry);

					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return listFileEntry;
	}

	public static FileEntry uploadMotFile(HttpServletRequest request, ActionResponse actionResponse,
			String parameterName, String nameFolder, long userId, long siteGroup, long groupId) {
		System.out.println("uploadMotFile::: " + parameterName);
		UploadServletRequest uploadRequest = PortalUtil.getUploadServletRequest(request);

		FileEntry fileEntry = null;
		try {
			System.out.println("size file: " + uploadRequest.getSize(parameterName));

			if (uploadRequest.getSize(parameterName) > 0) {
				System.out.println("file name: " + uploadRequest.getFileName(parameterName));
				String sourceFileName = uploadRequest.getFileName(parameterName);
				InputStream in = null;
				try {
					String contentType = uploadRequest.getContentType(parameterName);
					long size = uploadRequest.getSize(parameterName);
					int i = sourceFileName.lastIndexOf('.');
					String extension = "";

					if (i > 0) {
						extension = sourceFileName.substring(i + 1);
					}

					// File file = uploadRequest.getFile(parameterName);

					in = new BufferedInputStream(uploadRequest.getFileAsStream(parameterName));

					long repositoryId = DLFolderConstants.getDataRepositoryId(groupId,
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
					System.out.println("contentType::: " + contentType + " : " + sourceFileName);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
							request);
					String fileTitle = Long.toString(System.currentTimeMillis()) + "-" + sourceFileName;
					Folder folder = getOrCreateFolder(serviceContext, userId, siteGroup, nameFolder);
					System.out.println("ten file goc: " + sourceFileName);

					// Add file entry

					fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folder.getFolderId(),
							sourceFileName, contentType, fileTitle, fileTitle, "change log", in, size, serviceContext);

					ResourcePermission resourcePermission = null;
					final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(),
							RoleConstants.GUEST);
					ResourceAction resourceAction = ResourceActionLocalServiceUtil
							.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
					try {
						resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(
								fileEntry.getCompanyId(), DLFileEntry.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getPrimaryKey()),
								siteMemberRole.getRoleId());

						if (Validator.isNotNull(resourcePermission)) {
							resourcePermission.setActionIds(resourceAction.getBitwiseValue());
							ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
						}
					} catch (NoSuchResourcePermissionException e) {

						resourcePermission = ResourcePermissionLocalServiceUtil
								.createResourcePermission(CounterLocalServiceUtil.increment());
						resourcePermission.setCompanyId(fileEntry.getCompanyId());
						resourcePermission.setName(DLFileEntry.class.getName());
						resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
						resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
						resourcePermission.setRoleId(siteMemberRole.getRoleId());
						resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
						ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
					}

					// end tubnd

				} catch (FileNotFoundException e) {
					System.out.println("exep 1");

					// jsonObject.put("errorid", 1);

					e.printStackTrace();
				} catch (IOException e1) {
					System.out.println("exep 2");

					// jsonObject.put("errorid", 1);

					e1.printStackTrace();
				} catch (Exception e) {
					System.out.println("exep 3");

					// jsonObject.put("errorid", 1);

					e.printStackTrace();
				} finally {
					System.out.println("cleanUp");
					StreamUtil.cleanUp(in);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileEntry;
	}

	public static FileEntry uploadGuest(HttpServletRequest request, String parameterName, String nameFolder,
			long siteGroupId, long userId) throws PortalException, SystemException {
		System.out.println("uploadMotFile::: " + parameterName);
		FileEntry fileEntry = null;
		try {
			UploadServletRequest uploadRequest = PortalUtil.getUploadServletRequest(request);
			if (uploadRequest.getSize(parameterName) > 0) {
				String sourceFileName = uploadRequest.getFileName(parameterName);
				InputStream in = null;
				try {
					String contentType = uploadRequest.getContentType(parameterName);
					long size = uploadRequest.getSize(parameterName);
					int i = sourceFileName.lastIndexOf('.');

					in = new BufferedInputStream(uploadRequest.getFileAsStream(parameterName));

					long repositoryId = DLFolderConstants.getDataRepositoryId(siteGroupId,
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
					System.out.println("contentType::: " + contentType + " : " + sourceFileName);
					System.out.println("repositoryId: " + repositoryId);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
							request);
					String fileTitle = Long.toString(System.currentTimeMillis()) + "-" + sourceFileName;
					Folder folder = getOrCreateFolder(serviceContext, userId, siteGroupId, nameFolder);
					System.out.println("ten file goc: " + sourceFileName);

					// Add file entry

					fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folder.getFolderId(),
							sourceFileName, contentType, fileTitle, fileTitle, "change log", in, size, serviceContext);

					ResourcePermission resourcePermission = null;
					final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(),
							RoleConstants.USER);
					ResourceAction resourceAction = ResourceActionLocalServiceUtil
							.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
					try {
						resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(
								fileEntry.getCompanyId(), DLFileEntry.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getPrimaryKey()),
								siteMemberRole.getRoleId());

						if (Validator.isNotNull(resourcePermission)) {
							resourcePermission.setActionIds(resourceAction.getBitwiseValue());
							ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
						}
					} catch (NoSuchResourcePermissionException e) {

						resourcePermission = ResourcePermissionLocalServiceUtil
								.createResourcePermission(CounterLocalServiceUtil.increment());
						resourcePermission.setCompanyId(fileEntry.getCompanyId());
						resourcePermission.setName(DLFileEntry.class.getName());
						resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
						resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
						resourcePermission.setRoleId(siteMemberRole.getRoleId());
						resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
						ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
					}

					// end tubnd

				} catch (FileNotFoundException e) {
					System.out.println("exep 1");
					e.printStackTrace();
				} catch (IOException e1) {
					System.out.println("exep 2");
					e1.printStackTrace();
				} catch (Exception e) {
					System.out.println("exep 3");
					e.printStackTrace();
				} finally {
					StreamUtil.cleanUp(in);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileEntry;
	}
}
