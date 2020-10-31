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

package organizationalStructure.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import organizationalStructure.service.model.UserOrganization;
import organizationalStructure.service.service.persistence.UserOrganizationPK;

/**
 * The cache model class for representing UserOrganization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserOrganizationCacheModel
	implements CacheModel<UserOrganization>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserOrganizationCacheModel)) {
			return false;
		}

		UserOrganizationCacheModel userOrganizationCacheModel =
			(UserOrganizationCacheModel)obj;

		if (userOrganizationPK.equals(
				userOrganizationCacheModel.userOrganizationPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userOrganizationPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserOrganization toEntityModel() {
		UserOrganizationImpl userOrganizationImpl = new UserOrganizationImpl();

		userOrganizationImpl.setUserId(userId);
		userOrganizationImpl.setOrganizationId(organizationId);

		userOrganizationImpl.resetOriginalValues();

		return userOrganizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		organizationId = objectInput.readLong();

		userOrganizationPK = new UserOrganizationPK(userId, organizationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(organizationId);
	}

	public long userId;
	public long organizationId;
	public transient UserOrganizationPK userOrganizationPK;

}