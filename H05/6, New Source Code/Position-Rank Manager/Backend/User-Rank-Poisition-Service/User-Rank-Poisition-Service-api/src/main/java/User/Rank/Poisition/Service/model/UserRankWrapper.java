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
 * This class is a wrapper for {@link UserRank}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRank
 * @generated
 */
@ProviderType
public class UserRankWrapper
	extends BaseModelWrapper<UserRank>
	implements UserRank, ModelWrapper<UserRank> {

	public UserRankWrapper(UserRank userRank) {
		super(userRank);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userRankId", getUserRankId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("rankName", getRankName());
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

		Long userRankId = (Long)attributes.get("userRankId");

		if (userRankId != null) {
			setUserRankId(userRankId);
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

		String rankName = (String)attributes.get("rankName");

		if (rankName != null) {
			setRankName(rankName);
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
	 * Returns the company ID of this user rank.
	 *
	 * @return the company ID of this user rank
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user rank.
	 *
	 * @return the create date of this user rank
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this user rank.
	 *
	 * @return the description of this user rank
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this user rank.
	 *
	 * @return the group ID of this user rank
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this user rank.
	 *
	 * @return the modified date of this user rank
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user rank.
	 *
	 * @return the primary key of this user rank
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rank name of this user rank.
	 *
	 * @return the rank name of this user rank
	 */
	@Override
	public String getRankName() {
		return model.getRankName();
	}

	/**
	 * Returns the total member of this user rank.
	 *
	 * @return the total member of this user rank
	 */
	@Override
	public long getTotalMember() {
		return model.getTotalMember();
	}

	/**
	 * Returns the user ID of this user rank.
	 *
	 * @return the user ID of this user rank
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user rank ID of this user rank.
	 *
	 * @return the user rank ID of this user rank
	 */
	@Override
	public long getUserRankId() {
		return model.getUserRankId();
	}

	/**
	 * Returns the user uuid of this user rank.
	 *
	 * @return the user uuid of this user rank
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user rank.
	 *
	 * @return the uuid of this user rank
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
	 * Sets the company ID of this user rank.
	 *
	 * @param companyId the company ID of this user rank
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user rank.
	 *
	 * @param createDate the create date of this user rank
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this user rank.
	 *
	 * @param description the description of this user rank
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this user rank.
	 *
	 * @param groupId the group ID of this user rank
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this user rank.
	 *
	 * @param modifiedDate the modified date of this user rank
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user rank.
	 *
	 * @param primaryKey the primary key of this user rank
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rank name of this user rank.
	 *
	 * @param rankName the rank name of this user rank
	 */
	@Override
	public void setRankName(String rankName) {
		model.setRankName(rankName);
	}

	/**
	 * Sets the total member of this user rank.
	 *
	 * @param totalMember the total member of this user rank
	 */
	@Override
	public void setTotalMember(long totalMember) {
		model.setTotalMember(totalMember);
	}

	/**
	 * Sets the user ID of this user rank.
	 *
	 * @param userId the user ID of this user rank
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user rank ID of this user rank.
	 *
	 * @param userRankId the user rank ID of this user rank
	 */
	@Override
	public void setUserRankId(long userRankId) {
		model.setUserRankId(userRankId);
	}

	/**
	 * Sets the user uuid of this user rank.
	 *
	 * @param userUuid the user uuid of this user rank
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user rank.
	 *
	 * @param uuid the uuid of this user rank
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
	protected UserRankWrapper wrap(UserRank userRank) {
		return new UserRankWrapper(userRank);
	}

}