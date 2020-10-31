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
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
@ProviderType
public class CategoryWrapper
	extends BaseModelWrapper<Category>
	implements Category, ModelWrapper<Category> {

	public CategoryWrapper(Category category) {
		super(category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createByUser", getCreateByUser());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("view", getView());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("tacGiaAlbum", getTacGiaAlbum());
		attributes.put("fieldId", getFieldId());
		attributes.put("status", getStatus());
		attributes.put("thuTu", getThuTu());
		attributes.put("isDaiDien", isIsDaiDien());
		attributes.put("urlImage", getUrlImage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String createByUser = (String)attributes.get("createByUser");

		if (createByUser != null) {
			setCreateByUser(createByUser);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String modifiedByUser = (String)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long view = (Long)attributes.get("view");

		if (view != null) {
			setView(view);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String tacGiaAlbum = (String)attributes.get("tacGiaAlbum");

		if (tacGiaAlbum != null) {
			setTacGiaAlbum(tacGiaAlbum);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer thuTu = (Integer)attributes.get("thuTu");

		if (thuTu != null) {
			setThuTu(thuTu);
		}

		Boolean isDaiDien = (Boolean)attributes.get("isDaiDien");

		if (isDaiDien != null) {
			setIsDaiDien(isDaiDien);
		}

		String urlImage = (String)attributes.get("urlImage");

		if (urlImage != null) {
			setUrlImage(urlImage);
		}
	}

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this category.
	 *
	 * @return the company ID of this category
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create by user of this category.
	 *
	 * @return the create by user of this category
	 */
	@Override
	public String getCreateByUser() {
		return model.getCreateByUser();
	}

	/**
	 * Returns the create date of this category.
	 *
	 * @return the create date of this category
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this category.
	 *
	 * @return the description of this category
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the field ID of this category.
	 *
	 * @return the field ID of this category
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the group ID of this category.
	 *
	 * @return the group ID of this category
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is dai dien of this category.
	 *
	 * @return the is dai dien of this category
	 */
	@Override
	public boolean getIsDaiDien() {
		return model.getIsDaiDien();
	}

	/**
	 * Returns the modified by user of this category.
	 *
	 * @return the modified by user of this category
	 */
	@Override
	public String getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this category.
	 *
	 * @return the modified date of this category
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this category.
	 *
	 * @return the name of this category
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this category.
	 *
	 * @return the parent ID of this category
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this category.
	 *
	 * @return the status of this category
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tac gia album of this category.
	 *
	 * @return the tac gia album of this category
	 */
	@Override
	public String getTacGiaAlbum() {
		return model.getTacGiaAlbum();
	}

	/**
	 * Returns the thu tu of this category.
	 *
	 * @return the thu tu of this category
	 */
	@Override
	public int getThuTu() {
		return model.getThuTu();
	}

	/**
	 * Returns the url image of this category.
	 *
	 * @return the url image of this category
	 */
	@Override
	public String getUrlImage() {
		return model.getUrlImage();
	}

	/**
	 * Returns the view of this category.
	 *
	 * @return the view of this category
	 */
	@Override
	public long getView() {
		return model.getView();
	}

	/**
	 * Returns <code>true</code> if this category is is dai dien.
	 *
	 * @return <code>true</code> if this category is is dai dien; <code>false</code> otherwise
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
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this category.
	 *
	 * @param companyId the company ID of this category
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create by user of this category.
	 *
	 * @param createByUser the create by user of this category
	 */
	@Override
	public void setCreateByUser(String createByUser) {
		model.setCreateByUser(createByUser);
	}

	/**
	 * Sets the create date of this category.
	 *
	 * @param createDate the create date of this category
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this category.
	 *
	 * @param description the description of this category
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the field ID of this category.
	 *
	 * @param fieldId the field ID of this category
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the group ID of this category.
	 *
	 * @param groupId the group ID of this category
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this category is is dai dien.
	 *
	 * @param isDaiDien the is dai dien of this category
	 */
	@Override
	public void setIsDaiDien(boolean isDaiDien) {
		model.setIsDaiDien(isDaiDien);
	}

	/**
	 * Sets the modified by user of this category.
	 *
	 * @param modifiedByUser the modified by user of this category
	 */
	@Override
	public void setModifiedByUser(String modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this category.
	 *
	 * @param modifiedDate the modified date of this category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this category.
	 *
	 * @param name the name of this category
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this category.
	 *
	 * @param parentId the parent ID of this category
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this category.
	 *
	 * @param status the status of this category
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tac gia album of this category.
	 *
	 * @param tacGiaAlbum the tac gia album of this category
	 */
	@Override
	public void setTacGiaAlbum(String tacGiaAlbum) {
		model.setTacGiaAlbum(tacGiaAlbum);
	}

	/**
	 * Sets the thu tu of this category.
	 *
	 * @param thuTu the thu tu of this category
	 */
	@Override
	public void setThuTu(int thuTu) {
		model.setThuTu(thuTu);
	}

	/**
	 * Sets the url image of this category.
	 *
	 * @param urlImage the url image of this category
	 */
	@Override
	public void setUrlImage(String urlImage) {
		model.setUrlImage(urlImage);
	}

	/**
	 * Sets the view of this category.
	 *
	 * @param view the view of this category
	 */
	@Override
	public void setView(long view) {
		model.setView(view);
	}

	@Override
	protected CategoryWrapper wrap(Category category) {
		return new CategoryWrapper(category);
	}

}