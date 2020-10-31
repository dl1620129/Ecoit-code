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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link UserRankPosition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRankPosition
 * @generated
 */
@ProviderType
public class UserRankPositionWrapper
	extends BaseModelWrapper<UserRankPosition>
	implements UserRankPosition, ModelWrapper<UserRankPosition> {

	public UserRankPositionWrapper(UserRankPosition userRankPosition) {
		super(userRankPosition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("userRankId", getUserRankId());
		attributes.put("userPoisitionDangId", getUserPoisitionDangId());
		attributes.put("userPoisitionId", getUserPoisitionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userRankId = (Long)attributes.get("userRankId");

		if (userRankId != null) {
			setUserRankId(userRankId);
		}

		Long userPoisitionDangId = (Long)attributes.get("userPoisitionDangId");

		if (userPoisitionDangId != null) {
			setUserPoisitionDangId(userPoisitionDangId);
		}

		Long userPoisitionId = (Long)attributes.get("userPoisitionId");

		if (userPoisitionId != null) {
			setUserPoisitionId(userPoisitionId);
		}
	}

	/**
	 * Returns the primary key of this user rank position.
	 *
	 * @return the primary key of this user rank position
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user rank position.
	 *
	 * @return the user ID of this user rank position
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user poisition dang ID of this user rank position.
	 *
	 * @return the user poisition dang ID of this user rank position
	 */
	@Override
	public long getUserPoisitionDangId() {
		return model.getUserPoisitionDangId();
	}

	/**
	 * Returns the user poisition ID of this user rank position.
	 *
	 * @return the user poisition ID of this user rank position
	 */
	@Override
	public long getUserPoisitionId() {
		return model.getUserPoisitionId();
	}

	/**
	 * Returns the user rank ID of this user rank position.
	 *
	 * @return the user rank ID of this user rank position
	 */
	@Override
	public long getUserRankId() {
		return model.getUserRankId();
	}

	/**
	 * Returns the user uuid of this user rank position.
	 *
	 * @return the user uuid of this user rank position
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this user rank position.
	 *
	 * @param primaryKey the primary key of this user rank position
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user rank position.
	 *
	 * @param userId the user ID of this user rank position
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user poisition dang ID of this user rank position.
	 *
	 * @param userPoisitionDangId the user poisition dang ID of this user rank position
	 */
	@Override
	public void setUserPoisitionDangId(long userPoisitionDangId) {
		model.setUserPoisitionDangId(userPoisitionDangId);
	}

	/**
	 * Sets the user poisition ID of this user rank position.
	 *
	 * @param userPoisitionId the user poisition ID of this user rank position
	 */
	@Override
	public void setUserPoisitionId(long userPoisitionId) {
		model.setUserPoisitionId(userPoisitionId);
	}

	/**
	 * Sets the user rank ID of this user rank position.
	 *
	 * @param userRankId the user rank ID of this user rank position
	 */
	@Override
	public void setUserRankId(long userRankId) {
		model.setUserRankId(userRankId);
	}

	/**
	 * Sets the user uuid of this user rank position.
	 *
	 * @param userUuid the user uuid of this user rank position
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserRankPositionWrapper wrap(UserRankPosition userRankPosition) {
		return new UserRankPositionWrapper(userRankPosition);
	}

}