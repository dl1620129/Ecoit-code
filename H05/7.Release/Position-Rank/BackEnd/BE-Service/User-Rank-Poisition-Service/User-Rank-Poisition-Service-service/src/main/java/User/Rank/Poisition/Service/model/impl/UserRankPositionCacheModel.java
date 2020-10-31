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

package User.Rank.Poisition.Service.model.impl;

import User.Rank.Poisition.Service.model.UserRankPosition;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing UserRankPosition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserRankPositionCacheModel
	implements CacheModel<UserRankPosition>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserRankPositionCacheModel)) {
			return false;
		}

		UserRankPositionCacheModel userRankPositionCacheModel =
			(UserRankPositionCacheModel)obj;

		if (userId == userRankPositionCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", userRankId=");
		sb.append(userRankId);
		sb.append(", userPoisitionDangId=");
		sb.append(userPoisitionDangId);
		sb.append(", userPoisitionId=");
		sb.append(userPoisitionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserRankPosition toEntityModel() {
		UserRankPositionImpl userRankPositionImpl = new UserRankPositionImpl();

		userRankPositionImpl.setUserId(userId);
		userRankPositionImpl.setUserRankId(userRankId);
		userRankPositionImpl.setUserPoisitionDangId(userPoisitionDangId);
		userRankPositionImpl.setUserPoisitionId(userPoisitionId);

		userRankPositionImpl.resetOriginalValues();

		return userRankPositionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		userRankId = objectInput.readLong();

		userPoisitionDangId = objectInput.readLong();

		userPoisitionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(userRankId);

		objectOutput.writeLong(userPoisitionDangId);

		objectOutput.writeLong(userPoisitionId);
	}

	public long userId;
	public long userRankId;
	public long userPoisitionDangId;
	public long userPoisitionId;

}