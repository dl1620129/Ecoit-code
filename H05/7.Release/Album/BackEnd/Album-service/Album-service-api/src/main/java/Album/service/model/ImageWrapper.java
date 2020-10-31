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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Image}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Image
 * @generated
 */
@ProviderType
public class ImageWrapper
	extends BaseModelWrapper<Image> implements Image, ModelWrapper<Image> {

	public ImageWrapper(Image image) {
		super(image);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("imageId", getImageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("addByUser", getAddByUser());
		attributes.put("addDate", getAddDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("fieldId", getFieldId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("fileAttachId", getFileAttachId());
		attributes.put("display", isDisplay());
		attributes.put("view", getView());
		attributes.put("isDaiDien", isIsDaiDien());
		attributes.put("tacGia", getTacGia());
		attributes.put("thuTu", getThuTu());
		attributes.put("imageFileId", getImageFileId());
		attributes.put("folderId", getFolderId());
		attributes.put("imageUrl", getImageUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String addByUser = (String)attributes.get("addByUser");

		if (addByUser != null) {
			setAddByUser(addByUser);
		}

		Date addDate = (Date)attributes.get("addDate");

		if (addDate != null) {
			setAddDate(addDate);
		}

		String modifiedByUser = (String)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long fileAttachId = (Long)attributes.get("fileAttachId");

		if (fileAttachId != null) {
			setFileAttachId(fileAttachId);
		}

		Boolean display = (Boolean)attributes.get("display");

		if (display != null) {
			setDisplay(display);
		}

		Long view = (Long)attributes.get("view");

		if (view != null) {
			setView(view);
		}

		Boolean isDaiDien = (Boolean)attributes.get("isDaiDien");

		if (isDaiDien != null) {
			setIsDaiDien(isDaiDien);
		}

		String tacGia = (String)attributes.get("tacGia");

		if (tacGia != null) {
			setTacGia(tacGia);
		}

		Integer thuTu = (Integer)attributes.get("thuTu");

		if (thuTu != null) {
			setThuTu(thuTu);
		}

		Long imageFileId = (Long)attributes.get("imageFileId");

		if (imageFileId != null) {
			setImageFileId(imageFileId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}
	}

	/**
	 * Returns the add by user of this image.
	 *
	 * @return the add by user of this image
	 */
	@Override
	public String getAddByUser() {
		return model.getAddByUser();
	}

	/**
	 * Returns the add date of this image.
	 *
	 * @return the add date of this image
	 */
	@Override
	public Date getAddDate() {
		return model.getAddDate();
	}

	/**
	 * Returns the category ID of this image.
	 *
	 * @return the category ID of this image
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this image.
	 *
	 * @return the company ID of this image
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the description of this image.
	 *
	 * @return the description of this image
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the display of this image.
	 *
	 * @return the display of this image
	 */
	@Override
	public boolean getDisplay() {
		return model.getDisplay();
	}

	/**
	 * Returns the field ID of this image.
	 *
	 * @return the field ID of this image
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the file attach ID of this image.
	 *
	 * @return the file attach ID of this image
	 */
	@Override
	public long getFileAttachId() {
		return model.getFileAttachId();
	}

	/**
	 * Returns the folder ID of this image.
	 *
	 * @return the folder ID of this image
	 */
	@Override
	public long getFolderId() {
		return model.getFolderId();
	}

	/**
	 * Returns the group ID of this image.
	 *
	 * @return the group ID of this image
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image file ID of this image.
	 *
	 * @return the image file ID of this image
	 */
	@Override
	public long getImageFileId() {
		return model.getImageFileId();
	}

	/**
	 * Returns the image ID of this image.
	 *
	 * @return the image ID of this image
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the image url of this image.
	 *
	 * @return the image url of this image
	 */
	@Override
	public String getImageUrl() {
		return model.getImageUrl();
	}

	/**
	 * Returns the is dai dien of this image.
	 *
	 * @return the is dai dien of this image
	 */
	@Override
	public boolean getIsDaiDien() {
		return model.getIsDaiDien();
	}

	/**
	 * Returns the modified by user of this image.
	 *
	 * @return the modified by user of this image
	 */
	@Override
	public String getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this image.
	 *
	 * @return the modified date of this image
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this image.
	 *
	 * @return the primary key of this image
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tac gia of this image.
	 *
	 * @return the tac gia of this image
	 */
	@Override
	public String getTacGia() {
		return model.getTacGia();
	}

	/**
	 * Returns the thu tu of this image.
	 *
	 * @return the thu tu of this image
	 */
	@Override
	public int getThuTu() {
		return model.getThuTu();
	}

	/**
	 * Returns the title of this image.
	 *
	 * @return the title of this image
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the view of this image.
	 *
	 * @return the view of this image
	 */
	@Override
	public long getView() {
		return model.getView();
	}

	/**
	 * Returns <code>true</code> if this image is display.
	 *
	 * @return <code>true</code> if this image is display; <code>false</code> otherwise
	 */
	@Override
	public boolean isDisplay() {
		return model.isDisplay();
	}

	/**
	 * Returns <code>true</code> if this image is is dai dien.
	 *
	 * @return <code>true</code> if this image is is dai dien; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDaiDien() {
		return model.isIsDaiDien();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the add by user of this image.
	 *
	 * @param addByUser the add by user of this image
	 */
	@Override
	public void setAddByUser(String addByUser) {
		model.setAddByUser(addByUser);
	}

	/**
	 * Sets the add date of this image.
	 *
	 * @param addDate the add date of this image
	 */
	@Override
	public void setAddDate(Date addDate) {
		model.setAddDate(addDate);
	}

	/**
	 * Sets the category ID of this image.
	 *
	 * @param categoryId the category ID of this image
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this image.
	 *
	 * @param companyId the company ID of this image
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the description of this image.
	 *
	 * @param description the description of this image
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets whether this image is display.
	 *
	 * @param display the display of this image
	 */
	@Override
	public void setDisplay(boolean display) {
		model.setDisplay(display);
	}

	/**
	 * Sets the field ID of this image.
	 *
	 * @param fieldId the field ID of this image
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the file attach ID of this image.
	 *
	 * @param fileAttachId the file attach ID of this image
	 */
	@Override
	public void setFileAttachId(long fileAttachId) {
		model.setFileAttachId(fileAttachId);
	}

	/**
	 * Sets the folder ID of this image.
	 *
	 * @param folderId the folder ID of this image
	 */
	@Override
	public void setFolderId(long folderId) {
		model.setFolderId(folderId);
	}

	/**
	 * Sets the group ID of this image.
	 *
	 * @param groupId the group ID of this image
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image file ID of this image.
	 *
	 * @param imageFileId the image file ID of this image
	 */
	@Override
	public void setImageFileId(long imageFileId) {
		model.setImageFileId(imageFileId);
	}

	/**
	 * Sets the image ID of this image.
	 *
	 * @param imageId the image ID of this image
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the image url of this image.
	 *
	 * @param imageUrl the image url of this image
	 */
	@Override
	public void setImageUrl(String imageUrl) {
		model.setImageUrl(imageUrl);
	}

	/**
	 * Sets whether this image is is dai dien.
	 *
	 * @param isDaiDien the is dai dien of this image
	 */
	@Override
	public void setIsDaiDien(boolean isDaiDien) {
		model.setIsDaiDien(isDaiDien);
	}

	/**
	 * Sets the modified by user of this image.
	 *
	 * @param modifiedByUser the modified by user of this image
	 */
	@Override
	public void setModifiedByUser(String modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this image.
	 *
	 * @param modifiedDate the modified date of this image
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this image.
	 *
	 * @param primaryKey the primary key of this image
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tac gia of this image.
	 *
	 * @param tacGia the tac gia of this image
	 */
	@Override
	public void setTacGia(String tacGia) {
		model.setTacGia(tacGia);
	}

	/**
	 * Sets the thu tu of this image.
	 *
	 * @param thuTu the thu tu of this image
	 */
	@Override
	public void setThuTu(int thuTu) {
		model.setThuTu(thuTu);
	}

	/**
	 * Sets the title of this image.
	 *
	 * @param title the title of this image
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the view of this image.
	 *
	 * @param view the view of this image
	 */
	@Override
	public void setView(long view) {
		model.setView(view);
	}

	@Override
	protected ImageWrapper wrap(Image image) {
		return new ImageWrapper(image);
	}

}