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

package Album.service.model.impl;

import Album.service.model.Fields;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Fields in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FieldsCacheModel implements CacheModel<Fields>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FieldsCacheModel)) {
			return false;
		}

		FieldsCacheModel fieldsCacheModel = (FieldsCacheModel)obj;

		if (fieldId == fieldsCacheModel.fieldId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fieldId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{fieldId=");
		sb.append(fieldId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createByUser=");
		sb.append(createByUser);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", thuThu=");
		sb.append(thuThu);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Fields toEntityModel() {
		FieldsImpl fieldsImpl = new FieldsImpl();

		fieldsImpl.setFieldId(fieldId);
		fieldsImpl.setGroupId(groupId);
		fieldsImpl.setCreateByUser(createByUser);

		if (createDate == Long.MIN_VALUE) {
			fieldsImpl.setCreateDate(null);
		}
		else {
			fieldsImpl.setCreateDate(new Date(createDate));
		}

		fieldsImpl.setModifiedByUser(modifiedByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			fieldsImpl.setModifiedDate(null);
		}
		else {
			fieldsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			fieldsImpl.setName("");
		}
		else {
			fieldsImpl.setName(name);
		}

		if (description == null) {
			fieldsImpl.setDescription("");
		}
		else {
			fieldsImpl.setDescription(description);
		}

		fieldsImpl.setThuThu(thuThu);

		fieldsImpl.resetOriginalValues();

		return fieldsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fieldId = objectInput.readLong();

		groupId = objectInput.readLong();

		createByUser = objectInput.readLong();
		createDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		thuThu = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fieldId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(createByUser);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(modifiedByUser);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(thuThu);
	}

	public long fieldId;
	public long groupId;
	public long createByUser;
	public long createDate;
	public long modifiedByUser;
	public long modifiedDate;
	public String name;
	public String description;
	public int thuThu;

}