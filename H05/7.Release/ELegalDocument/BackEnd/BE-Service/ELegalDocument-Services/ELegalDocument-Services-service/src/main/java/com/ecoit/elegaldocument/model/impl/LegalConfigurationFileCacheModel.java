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

package com.ecoit.elegaldocument.model.impl;

import com.ecoit.elegaldocument.model.LegalConfigurationFile;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalConfigurationFile in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalConfigurationFileCacheModel
	implements CacheModel<LegalConfigurationFile>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalConfigurationFileCacheModel)) {
			return false;
		}

		LegalConfigurationFileCacheModel legalConfigurationFileCacheModel =
			(LegalConfigurationFileCacheModel)obj;

		if (keyId.equals(legalConfigurationFileCacheModel.keyId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, keyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{keyId=");
		sb.append(keyId);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalConfigurationFile toEntityModel() {
		LegalConfigurationFileImpl legalConfigurationFileImpl =
			new LegalConfigurationFileImpl();

		if (keyId == null) {
			legalConfigurationFileImpl.setKeyId("");
		}
		else {
			legalConfigurationFileImpl.setKeyId(keyId);
		}

		if (value == null) {
			legalConfigurationFileImpl.setValue("");
		}
		else {
			legalConfigurationFileImpl.setValue(value);
		}

		legalConfigurationFileImpl.resetOriginalValues();

		return legalConfigurationFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		keyId = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (keyId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(keyId);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String keyId;
	public String value;

}