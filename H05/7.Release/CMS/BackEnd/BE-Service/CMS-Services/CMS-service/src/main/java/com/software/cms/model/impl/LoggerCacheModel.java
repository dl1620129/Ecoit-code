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

package com.software.cms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.software.cms.model.Logger;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Logger in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class LoggerCacheModel implements CacheModel<Logger>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoggerCacheModel)) {
			return false;
		}

		LoggerCacheModel loggerCacheModel = (LoggerCacheModel)obj;

		if (loggerId == loggerCacheModel.loggerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loggerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", loggerId=");
		sb.append(loggerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Logger toEntityModel() {
		LoggerImpl loggerImpl = new LoggerImpl();

		if (uuid == null) {
			loggerImpl.setUuid("");
		}
		else {
			loggerImpl.setUuid(uuid);
		}

		loggerImpl.setLoggerId(loggerId);
		loggerImpl.setGroupId(groupId);

		if (language == null) {
			loggerImpl.setLanguage("");
		}
		else {
			loggerImpl.setLanguage(language);
		}

		loggerImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			loggerImpl.setCreatedDate(null);
		}
		else {
			loggerImpl.setCreatedDate(new Date(createdDate));
		}

		if (description == null) {
			loggerImpl.setDescription("");
		}
		else {
			loggerImpl.setDescription(description);
		}

		if (type == null) {
			loggerImpl.setType("");
		}
		else {
			loggerImpl.setType(type);
		}

		loggerImpl.resetOriginalValues();

		return loggerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		loggerId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		description = objectInput.readUTF();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(loggerId);

		objectOutput.writeLong(groupId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public String uuid;
	public long loggerId;
	public long groupId;
	public String language;
	public long userId;
	public long createdDate;
	public String description;
	public String type;

}