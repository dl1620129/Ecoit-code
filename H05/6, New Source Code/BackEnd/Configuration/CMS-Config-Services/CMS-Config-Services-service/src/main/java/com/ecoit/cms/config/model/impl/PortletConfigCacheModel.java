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

package com.ecoit.cms.config.model.impl;

import com.ecoit.cms.config.model.PortletConfig;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PortletConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PortletConfigCacheModel
	implements CacheModel<PortletConfig>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortletConfigCacheModel)) {
			return false;
		}

		PortletConfigCacheModel portletConfigCacheModel =
			(PortletConfigCacheModel)obj;

		if (portletId.equals(portletConfigCacheModel.portletId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, portletId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", catgoryId=");
		sb.append(catgoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortletConfig toEntityModel() {
		PortletConfigImpl portletConfigImpl = new PortletConfigImpl();

		if (uuid == null) {
			portletConfigImpl.setUuid("");
		}
		else {
			portletConfigImpl.setUuid(uuid);
		}

		if (portletId == null) {
			portletConfigImpl.setPortletId("");
		}
		else {
			portletConfigImpl.setPortletId(portletId);
		}

		portletConfigImpl.setCatgoryId(catgoryId);

		portletConfigImpl.resetOriginalValues();

		return portletConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		portletId = objectInput.readUTF();

		catgoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (portletId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		objectOutput.writeLong(catgoryId);
	}

	public String uuid;
	public String portletId;
	public long catgoryId;

}