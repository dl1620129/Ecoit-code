package com.web.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Mode;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;

public class AttachmentUtil {
	/**
	 * 
	 * @param upload as request
	 * @param userId id of userupload
	 * @param groupId id of community
	 * @param folderId id of folder ( can use article )
	 * @param params name of element in html form
	 * @return id of file in repository( return 0 if no file upload or upload invalid)
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static long uploadFile(UploadPortletRequest upload,Article article,File file, String title) throws PortalException, SystemException{
		long entryId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) upload.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
				upload);
		Date dt=new Date();
		// ========== create folder year ==========
		DLFolder folderYear = null;
		try {
			folderYear = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "NAM_" + (dt.getYear()+1900));
		} catch (Exception e) {
			folderYear = null;
		}
		if (folderYear == null) {
			folderYear = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0, 
					"NAM_" + (dt.getYear()+1900), "NAM_" + (dt.getYear()+1900), false, serviceContext);
		}
		
		DLFolder folderMonth = null;
		try {
			folderMonth = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folderYear.getFolderId(), "THANG_" + (dt.getMonth()+1));
			//System.out.println("-------->tim duoc folder Thang<----------: "+"THANG_" + (dt.getMonth()+1));
		} catch (Exception e) {
			folderMonth = null;
		}
		if (folderMonth == null) {
			folderMonth = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, folderYear.getFolderId(), 
					"THANG_" + (dt.getMonth()+1), "THANG_" + (dt.getMonth()+1), false, serviceContext);
		}
		System.out.println("--------> bat dau them anh <----------");
		
		try {	
			if ("".equals(title) || title == null) return 0;
			title = (new Date().toGMTString())+ title;
			title = title.replaceAll(":", "").replace(" ", "_").replace("[", "_").replace("]","_") ;
			String mimeType = title.substring(title.lastIndexOf("."));

			DLFolder dlFolder = null;
			
			if (article.getFolderId() <= 0) {
				try {
					dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folderMonth.getFolderId(), "ArticleImage_"+article.getArticleId());
				} catch (Exception e) {
					dlFolder = null;
				}
				if (dlFolder == null) {
					dlFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, folderMonth.getFolderId(), 
							"ArticleImage_"+article.getArticleId(),  article.getTitle(), false, serviceContext);
							
				}
				
				article.setFolderId(dlFolder.getFolderId());
			}else{ 
				try {
					dlFolder = DLFolderLocalServiceUtil.getDLFolder(article.getFolderId());
				} catch (Exception e) {
					dlFolder = null;
				}
				if (dlFolder == null) {
					dlFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
							false, folderMonth.getFolderId(), "ArticleImage_"+article.getArticleId(), article.getTitle(),false, serviceContext) ;
					article.setFolderId(dlFolder.getFolderId());
				}
			}
			System.out.println("--------> THEM MOI FILEENTRY<---------- FOLDERID: "+ dlFolder.getFolderId());
			FileEntry image = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId()	, dlFolder.getFolderId(), title, mimeType, title, "", "", file, serviceContext);
			return image.getPrimaryKey();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return entryId;
	}
	
	
	
	public static long uploadFileResize(UploadPortletRequest upload,Article article,File file, String title, int w, int h ){
		long entryId = 0;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) upload.getAttribute(WebKeys.THEME_DISPLAY);
			File fileDes = new File(PortalUtil.getPortalWebDir()+"image_resize/"+title);
			String end = title.substring(title.indexOf(".")+1);
			try{
				File dl = new File(PortalUtil.getPortalWebDir()+"image_resize");
				if(!dl.exists()){
					dl.mkdir();
				}
				BufferedImage img = ImageIO.read(file);
				BufferedImage scaledImg = Scalr.resize(img, Mode.AUTOMATIC, w, h);
				ImageIO.write(scaledImg, "jpg", fileDes);
				System.out.println("Done resizing");
				
            }catch(Exception e){
                e.printStackTrace();
            }
			
			if ("".equals(title) || title == null) return 0;
			title = (new Date().toGMTString())+ title;
			title = title.replaceAll(":", "").replace(" ", "_").replace("[", "_").replace("]","_") ;
			String mimeType = title.substring(title.lastIndexOf("."));
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setSignedIn(true);
			DLFolder dlFolder = null;
			if (article.getFolderId() <= 0) {
				dlFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
						false, 0, "ArticleImage_"+article.getArticleId(),  article.getTitle(),false, serviceContext) ;
				article.setFolderId(dlFolder.getFolderId());
			}
			else dlFolder = DLFolderLocalServiceUtil.getDLFolder(article.getFolderId());
			FileEntry image = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId()	, dlFolder.getFolderId(), title, mimeType, title, "", "", fileDes, serviceContext);
			

			return image.getPrimaryKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryId;
	}
	
	public static long ResizeImage(UploadPortletRequest upload,Article article,File file, String title, int w, int h ){
		long entryId = 0;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) upload.getAttribute(WebKeys.THEME_DISPLAY);
			File fileDes = new File(PortalUtil.getPortalWebDir()+"image_resize/"+title);
			//String end = title.substring(title.indexOf(".")+1);
			try{
				File dl = new File(PortalUtil.getPortalWebDir()+"image_resize");
				if(!dl.exists()){
					dl.mkdir();
				}
				BufferedImage img = ImageIO.read(file);
				String type = "crop";
				SizeF outer = new SizeF(-1.0, -1.0);
				double width = img.getWidth();
				double height = img.getHeight();
		        double maxWidth = 800;
		        double maxHeight = 800;
		        SizeF copySize = new SizeF(w, h);
		        double num = width / height;
		        double num2 = 1.0;
				if ((maxWidth > 0.0) && (width > 0.0))
		        {
		            width = Math.min(maxWidth, width);
		            maxWidth = -1.0;
		        }
		        if ((maxHeight > 0.0) && (height > 0.0))
		        {
		            height = Math.min(maxHeight, height);
		            maxHeight = -1.0;
		        }
		        if ((width != -1.0) && (maxHeight != -1.0))
		        {
		            maxHeight = Math.min(maxHeight, width / num);
		        }
		        if ((height != -1.0) && (maxWidth != -1.0))
		        {
		            maxWidth = Math.min(maxWidth, height * num);
		        }
		        width = Math.max(width, maxWidth);
		        height = Math.min(height, maxHeight);
		        if ((width > 0.0) && (height <= 0.0))
		        {
		            height = width / num;
		        }
		        else if ((height > 0.0) && (width <= 0.0))
		        {
		            width = height * num;
		        }
		        outer = new SizeF((float) width, (float) height);
		        //bounding = outer;
		        SizeF size = ScaleInside(outer, copySize);	
		        // resize
		        outer.setWidth(outer.getWidth()* (float) num2);
		        outer.setHeight(outer.getHeight()* (float) num2);
		        
		        outer.setWidth(Math.max(1f, (float) Math.round((double) outer.getWidth())));
		        outer.setHeight(Math.max(1f, (float) Math.round((double) outer.getHeight())));
		        
		        BufferedImage reImg = Scalr.resize(img, Mode.AUTOMATIC, (int) outer.getWidth(), (int) outer.getHeight());
		        
		        if(reImg.getWidth()<copySize.getWidth() && reImg.getHeight()<copySize.getHeight())
		        	type = "scare";
		        else if((reImg.getWidth()<copySize.getWidth() && reImg.getHeight()>copySize.getHeight())
		        		&& (reImg.getWidth()>copySize.getWidth() && reImg.getHeight()<copySize.getHeight()))
		        	type = "cropandscare";
		        // crop
		        long x = 0;
		        long y = 0;
		        if(type.equals("crop")){
		        	if(reImg.getWidth()>=copySize.getWidth() && reImg.getHeight()>=copySize.getHeight()){
			        	x = Math.round((reImg.getWidth()-copySize.getWidth())/2);
			        	y = Math.round((reImg.getHeight()-copySize.getHeight())/2);
			        	reImg = reImg.getSubimage((int)x, (int)y, (int) copySize.getWidth(), (int) copySize.getHeight());
			        	size = copySize;
		        	}else
		        		size = outer;
		        }
		        else if(type.equals("cropandscare")){
		        	x = Math.round((reImg.getWidth()-size.getWidth())/2);
		        	y = Math.round((reImg.getHeight()-size.getHeight())/2);
		        	reImg = reImg.getSubimage((int)x, (int)y, (int) size.getWidth(), (int) size.getHeight());
		        }
		        else{
		        	reImg = Scalr.resize(img, Mode.AUTOMATIC, (int) size.getWidth(), (int) size.getHeight());
		        }
		        // draw
				BufferedImage bufferedResizedImage = new BufferedImage((int)Math.round(copySize.getWidth()), (int)Math.round(copySize.getHeight()), BufferedImage.TYPE_INT_RGB);
		        Graphics2D    graphics = bufferedResizedImage.createGraphics();
		        graphics.setBackground(Color.WHITE);
		        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		        graphics.fillRect ( 0, 0, bufferedResizedImage.getWidth(), bufferedResizedImage.getHeight() );
		        
		        x = Math.round((copySize.getWidth()-size.getWidth())/2);
		        y = Math.round((copySize.getHeight()-size.getHeight())/2);
		        
		        graphics.drawImage(reImg, (int)x, (int)y, null);
		        graphics.dispose();
		        
				ImageIO.write(bufferedResizedImage, "jpg", fileDes);
				System.out.println("Done resizing");
				
            }catch(Exception e){
                e.printStackTrace();
            }
			
			if ("".equals(title) || title == null) return 0;
			title = (new Date().toGMTString())+ title;
			title = title.replaceAll(":", "").replace(" ", "_").replace("[", "_").replace("]","_") ;
			String mimeType = title.substring(title.lastIndexOf("."));
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setSignedIn(true);
			DLFolder dlFolder = null;
			if (article.getFolderId() <= 0) {
				dlFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
						false, 0, "ArticleImage_"+article.getArticleId(),  article.getTitle(), false, serviceContext) ;
				article.setFolderId(dlFolder.getFolderId());
			}
			else dlFolder = DLFolderLocalServiceUtil.getDLFolder(article.getFolderId());
			FileEntry image = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId()	, dlFolder.getFolderId(), title, mimeType, title, "", "", fileDes, serviceContext);
			return image.getPrimaryKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryId;
	}
	
    public static SizeF ScaleInside(SizeF inner, SizeF bounding)
    {
        double num = inner.getWidth() / inner.getHeight();
        double num2 = bounding.getWidth() / bounding.getHeight();
        if (num2 > num)
        {
            return new SizeF((float) (num * bounding.getHeight()), bounding.getHeight());
        }
        return new SizeF(bounding.getWidth(), (float) (((double) bounding.getWidth()) / num));
    }
	
	public static String getURLImage(RenderRequest renderRequest,RenderResponse renderResponse,ThemeDisplay themeDisplay, String documentId){
		String src = "";
		try{
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(documentId));
		    FileVersion fileVersion = fileEntry.getFileVersion();
	        src = DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "");
	        src = com.liferay.portal.kernel.util.HttpUtil.removeParameter(src, "version");
	        return src;
		}catch(Exception e){}
		return renderResponse.encodeURL(renderRequest.getContextPath() + "/res/no-image.jpg");
	}
	
	public static String viewDocument(RenderRequest renderRequest,RenderResponse renderResponse,ThemeDisplay themeDisplay, String documentId, String size){
		String src = "";
		try{
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(documentId));
		    FileVersion fileVersion = fileEntry.getFileVersion();
	        src = DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "");
	        src = com.liferay.portal.kernel.util.HttpUtil.removeParameter(src, "version");
		}catch(Exception e){src = renderResponse.encodeURL(renderRequest.getContextPath() + "/images/noimage.png");}
		return src;
//	}
	}
}
