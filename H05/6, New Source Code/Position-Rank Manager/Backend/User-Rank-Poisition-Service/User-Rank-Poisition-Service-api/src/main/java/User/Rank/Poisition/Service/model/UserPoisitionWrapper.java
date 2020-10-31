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

package User.Rank.Poisition.Service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link UserPoisition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition
 * @generated
 */
@ProviderType
public class UserPoisitionWrapper
	extends BaseModelWrapper<UserPoisition>
	implements UserPoisition, ModelWrapper<UserPoisition> {

	public UserPoisitionWrapper(UserPoisition userPoisition) {
		super(userPoisition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userPoisitionId", getUserPoisitionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userPoisitionName", getUserPoisitionName());
		attributes.put("description", getDescription());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("totalMember", getTotalMember());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userPoisitionId = (Long)attributes.get("userPoisitionId");

		if (userPoisitionId != null) {
			setUserPoisitionId(userPoisitionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userPoisitionName = (String)attributes.get("userPoisitionName");

		if (userPoisitionName != null) {
			setUserPoisitionName(userPoisitionName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long totalMember = (Long)attributes.get("totalMember");

		if (totalMember != null) {
			setTotalMember(totalMember);
		}
	}

	/**
	 * Returns the company ID of this user poisition.
	 *
	 * @return the company ID of this user poisition
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user poisition.
	 *
	 * @return the create date of this user poisition
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this user poisition.
	 *
	 * @return the description of this user poisition
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this user poisition.
	 *
	 * @return the group ID of this user poisition
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this user poisition.
	 *
	 * @return the modified date of this user poisition
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user poisition.
	 *
	 * @return the primary key of this user poisition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total member of this user poisition.
	 *
	 * @return the total member of this user poisition
	 */
	@Override
	public long getTotalMember() {
		return model.getTotalMember();
	}

	/**
	 * Returns the user ID of this user poisition.
	 *
	 * @return the user ID of this user poisition
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user poisition ID of this user poisition.
	 *
	 * @return the user poisition ID of this user poisition
	 */
	@Override
	public long getUserPoisitionId() {
		return model.getUserPoisitionId();
	}

	/**
	 * Returns the user poisition name of this user poisition.
	 *
	 * @return the user poisition name of this user poisition
	 */
	@Override
	public String getUserPoisitionName() {
		return model.getUserPoisitionName();
	}

	/**
	 * Returns the user uuid of this user poisition.
	 *
	 * @return the user uuid of this user poisition
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user poisition.
	 *
	 * @return the uuid of this user poisition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this user poisition.
	 *
	 * @param companyId the company ID of this user poisition
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user poisition.
	 *
	 * @param createDate the create date of this user poisition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this user poisition.
	 *
	 * @param description the description of this user poisition
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this user poisition.
	 *
	 * @param groupId the group ID of this user poisition
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this user poisition.
	 *
	 * @param modifiedDate the modified date of this user poisition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user poisition.
	 *
	 * @param primaryKey the primary key of this user poisition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total member of this user poisition.
	 *
	 * @param totalMember the total member of this user poisition
	 */
	@Override
	public void setTotalMember(long totalMember) {
		model.setTotalMember(totalMember);
	}

	/**
	 * Sets the user ID of this user poisition.
	 *
	 * @param userId the user ID of this user poisition
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user poisition ID of this user poisition.
	 *
	 * @param userPoisitionId the user poisition ID of this user poisition
	 */
	@Override
	public void setUserPoisitionId(long userPoisitionId) {
		model.setUserPoisitionId(userPoisitionId);
	}

	/**
	 * Sets the user poisition name of this user poisition.
	 *
	 * @param userPoisitionName the user poisition name of this user poisition
	 */
	@Override
	public void setUserPoisitionName(String userPoisitionName) {
		model.setUserPoisitionName(userPoisitionName);
	}

	/**
	 * Sets the user uuid of this user poisition.
	 *
	 * @param userUuid the user uuid of this user poisition
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user poisition.
	 *
	 * @param uuid the uuid of this user poisition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected UserPoisitionWrapper wrap(UserPoisition userPoisition) {
		return new UserPoisitionWrapper(userPoisition);
	}

}