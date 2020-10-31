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
 * This class is a wrapper for {@link Fields}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Fields
 * @generated
 */
@ProviderType
public class FieldsWrapper
	extends BaseModelWrapper<Fields> implements Fields, ModelWrapper<Fields> {

	public FieldsWrapper(Fields fields) {
		super(fields);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fieldId", getFieldId());
		attributes.put("groupId", getGroupId());
		attributes.put("createByUser", getCreateByUser());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("thuThu", getThuThu());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createByUser = (Long)attributes.get("createByUser");

		if (createByUser != null) {
			setCreateByUser(createByUser);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer thuThu = (Integer)attributes.get("thuThu");

		if (thuThu != null) {
			setThuThu(thuThu);
		}
	}

	/**
	 * Returns the create by user of this fields.
	 *
	 * @return the create by user of this fields
	 */
	@Override
	public long getCreateByUser() {
		return model.getCreateByUser();
	}

	/**
	 * Returns the create date of this fields.
	 *
	 * @return the create date of this fields
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this fields.
	 *
	 * @return the description of this fields
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the field ID of this fields.
	 *
	 * @return the field ID of this fields
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the group ID of this fields.
	 *
	 * @return the group ID of this fields
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by user of this fields.
	 *
	 * @return the modified by user of this fields
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this fields.
	 *
	 * @return the modified date of this fields
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this fields.
	 *
	 * @return the name of this fields
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this fields.
	 *
	 * @return the primary key of this fields
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the thu thu of this fields.
	 *
	 * @return the thu thu of this fields
	 */
	@Override
	public int getThuThu() {
		return model.getThuThu();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create by user of this fields.
	 *
	 * @param createByUser the create by user of this fields
	 */
	@Override
	public void setCreateByUser(long createByUser) {
		model.setCreateByUser(createByUser);
	}

	/**
	 * Sets the create date of this fields.
	 *
	 * @param createDate the create date of this fields
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this fields.
	 *
	 * @param description the description of this fields
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the field ID of this fields.
	 *
	 * @param fieldId the field ID of this fields
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the group ID of this fields.
	 *
	 * @param groupId the group ID of this fields
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by user of this fields.
	 *
	 * @param modifiedByUser the modified by user of this fields
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this fields.
	 *
	 * @param modifiedDate the modified date of this fields
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this fields.
	 *
	 * @param name the name of this fields
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this fields.
	 *
	 * @param primaryKey the primary key of this fields
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the thu thu of this fields.
	 *
	 * @param thuThu the thu thu of this fields
	 */
	@Override
	public void setThuThu(int thuThu) {
		model.setThuThu(thuThu);
	}

	@Override
	protected FieldsWrapper wrap(Fields fields) {
		return new FieldsWrapper(fields);
	}

}