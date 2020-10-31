/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package Album.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Image service. Represents a row in the &quot;portal_album_Image&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>Album.service.model.impl.ImageModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>Album.service.model.impl.ImageImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Image
 * @generated
 */
@ProviderType
public interface ImageModel extends BaseModel<Image>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a image model instance should use the {@link Image} interface instead.
	 */

	/**
	 * Returns the primary key of this image.
	 *
	 * @return the primary key of this image
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this image.
	 *
	 * @param primaryKey the primary key of this image
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the image ID of this image.
	 *
	 * @return the image ID of this image
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this image.
	 *
	 * @param imageId the image ID of this image
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the group ID of this image.
	 *
	 * @return the group ID of this image
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this image.
	 *
	 * @param groupId the group ID of this image
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this image.
	 *
	 * @return the company ID of this image
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this image.
	 *
	 * @param companyId the company ID of this image
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the add by user of this image.
	 *
	 * @return the add by user of this image
	 */
	@AutoEscape
	public String getAddByUser();

	/**
	 * Sets the add by user of this image.
	 *
	 * @param addByUser the add by user of this image
	 */
	public void setAddByUser(String addByUser);

	/**
	 * Returns the add date of this image.
	 *
	 * @return the add date of this image
	 */
	public Date getAddDate();

	/**
	 * Sets the add date of this image.
	 *
	 * @param addDate the add date of this image
	 */
	public void setAddDate(Date addDate);

	/**
	 * Returns the modified by user of this image.
	 *
	 * @return the modified by user of this image
	 */
	@AutoEscape
	public String getModifiedByUser();

	/**
	 * Sets the modified by user of this image.
	 *
	 * @param modifiedByUser the modified by user of this image
	 */
	public void setModifiedByUser(String modifiedByUser);

	/**
	 * Returns the modified date of this image.
	 *
	 * @return the modified date of this image
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this image.
	 *
	 * @param modifiedDate the modified date of this image
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the category ID of this image.
	 *
	 * @return the category ID of this image
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this image.
	 *
	 * @param categoryId the category ID of this image
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the field ID of this image.
	 *
	 * @return the field ID of this image
	 */
	public long getFieldId();

	/**
	 * Sets the field ID of this image.
	 *
	 * @param fieldId the field ID of this image
	 */
	public void setFieldId(long fieldId);

	/**
	 * Returns the title of this image.
	 *
	 * @return the title of this image
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this image.
	 *
	 * @param title the title of this image
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this image.
	 *
	 * @return the description of this image
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this image.
	 *
	 * @param description the description of this image
	 */
	public void setDescription(String description);

	/**
	 * Returns the file attach ID of this image.
	 *
	 * @return the file attach ID of this image
	 */
	public long getFileAttachId();

	/**
	 * Sets the file attach ID of this image.
	 *
	 * @param fileAttachId the file attach ID of this image
	 */
	public void setFileAttachId(long fileAttachId);

	/**
	 * Returns the display of this image.
	 *
	 * @return the display of this image
	 */
	public boolean getDisplay();

	/**
	 * Returns <code>true</code> if this image is display.
	 *
	 * @return <code>true</code> if this image is display; <code>false</code> otherwise
	 */
	public boolean isDisplay();

	/**
	 * Sets whether this image is display.
	 *
	 * @param display the display of this image
	 */
	public void setDisplay(boolean display);

	/**
	 * Returns the view of this image.
	 *
	 * @return the view of this image
	 */
	public long getView();

	/**
	 * Sets the view of this image.
	 *
	 * @param view the view of this image
	 */
	public void setView(long view);

	/**
	 * Returns the is dai dien of this image.
	 *
	 * @return the is dai dien of this image
	 */
	public boolean getIsDaiDien();

	/**
	 * Returns <code>true</code> if this image is is dai dien.
	 *
	 * @return <code>true</code> if this image is is dai dien; <code>false</code> otherwise
	 */
	public boolean isIsDaiDien();

	/**
	 * Sets whether this image is is dai dien.
	 *
	 * @param isDaiDien the is dai dien of this image
	 */
	public void setIsDaiDien(boolean isDaiDien);

	/**
	 * Returns the tac gia of this image.
	 *
	 * @return the tac gia of this image
	 */
	@AutoEscape
	public String getTacGia();

	/**
	 * Sets the tac gia of this image.
	 *
	 * @param tacGia the tac gia of this image
	 */
	public void setTacGia(String tacGia);

	/**
	 * Returns the thu tu of this image.
	 *
	 * @return the thu tu of this image
	 */
	public int getThuTu();

	/**
	 * Sets the thu tu of this image.
	 *
	 * @param thuTu the thu tu of this image
	 */
	public void setThuTu(int thuTu);

	/**
	 * Returns the image file ID of this image.
	 *
	 * @return the image file ID of this image
	 */
	public long getImageFileId();

	/**
	 * Sets the image file ID of this image.
	 *
	 * @param imageFileId the image file ID of this image
	 */
	public void setImageFileId(long imageFileId);

	/**
	 * Returns the folder ID of this image.
	 *
	 * @return the folder ID of this image
	 */
	public long getFolderId();

	/**
	 * Sets the folder ID of this image.
	 *
	 * @param folderId the folder ID of this image
	 */
	public void setFolderId(long folderId);

	/**
	 * Returns the image url of this image.
	 *
	 * @return the image url of this image
	 */
	@AutoEscape
	public String getImageUrl();

	/**
	 * Sets the image url of this image.
	 *
	 * @param imageUrl the image url of this image
	 */
	public void setImageUrl(String imageUrl);

}