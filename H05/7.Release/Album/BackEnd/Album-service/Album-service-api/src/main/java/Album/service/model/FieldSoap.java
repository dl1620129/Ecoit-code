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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link Album.service.service.http.FieldServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FieldSoap implements Serializable {

	public static FieldSoap toSoapModel(Field model) {
		FieldSoap soapModel = new FieldSoap();

		soapModel.setFieldId(model.getFieldId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateByUser(model.getCreateByUser());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setThuThu(model.getThuThu());

		return soapModel;
	}

	public static FieldSoap[] toSoapModels(Field[] models) {
		FieldSoap[] soapModels = new FieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FieldSoap[][] toSoapModels(Field[][] models) {
		FieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FieldSoap[] toSoapModels(List<Field> models) {
		List<FieldSoap> soapModels = new ArrayList<FieldSoap>(models.size());

		for (Field model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FieldSoap[soapModels.size()]);
	}

	public FieldSoap() {
	}

	public long getPrimaryKey() {
		return _fieldId;
	}

	public void setPrimaryKey(long pk) {
		setFieldId(pk);
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCreateByUser() {
		return _createByUser;
	}

	public void setCreateByUser(long createByUser) {
		_createByUser = createByUser;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getThuThu() {
		return _thuThu;
	}

	public void setThuThu(int thuThu) {
		_thuThu = thuThu;
	}

	private long _fieldId;
	private long _groupId;
	private long _createByUser;
	private Date _createDate;
	private long _modifiedByUser;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private int _thuThu;

}