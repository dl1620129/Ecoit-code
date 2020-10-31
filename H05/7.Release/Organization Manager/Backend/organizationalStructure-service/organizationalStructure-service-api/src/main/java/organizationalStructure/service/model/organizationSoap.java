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

package organizationalStructure.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link organizationalStructure.service.service.http.organizationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class organizationSoap implements Serializable {

	public static organizationSoap toSoapModel(organization model) {
		organizationSoap soapModel = new organizationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setOrganizationCode(model.getOrganizationCode());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLeader(model.getLeader());
		soapModel.setMember(model.getMember());
		soapModel.setAddress(model.getAddress());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setPosition(model.getPosition());
		soapModel.setParentId(model.getParentId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreateUser(model.getCreateUser());
		soapModel.setModifiedUser(model.getModifiedUser());
		soapModel.setStatus(model.getStatus());
		soapModel.setThuTu(model.getThuTu());

		return soapModel;
	}

	public static organizationSoap[] toSoapModels(organization[] models) {
		organizationSoap[] soapModels = new organizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static organizationSoap[][] toSoapModels(organization[][] models) {
		organizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new organizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new organizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static organizationSoap[] toSoapModels(List<organization> models) {
		List<organizationSoap> soapModels = new ArrayList<organizationSoap>(
			models.size());

		for (organization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new organizationSoap[soapModels.size()]);
	}

	public organizationSoap() {
	}

	public long getPrimaryKey() {
		return _organizationId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getOrganizationCode() {
		return _organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		_organizationCode = organizationCode;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getLeader() {
		return _leader;
	}

	public void setLeader(String leader) {
		_leader = leader;
	}

	public long getMember() {
		return _member;
	}

	public void setMember(long member) {
		_member = member;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreateUser() {
		return _createUser;
	}

	public void setCreateUser(long createUser) {
		_createUser = createUser;
	}

	public long getModifiedUser() {
		return _modifiedUser;
	}

	public void setModifiedUser(long modifiedUser) {
		_modifiedUser = modifiedUser;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public int getThuTu() {
		return _thuTu;
	}

	public void setThuTu(int thuTu) {
		_thuTu = thuTu;
	}

	private String _uuid;
	private long _organizationId;
	private String _organizationCode;
	private long _groupId;
	private String _name;
	private String _description;
	private String _leader;
	private long _member;
	private String _address;
	private String _phoneNumber;
	private String _position;
	private long _parentId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createUser;
	private long _modifiedUser;
	private long _status;
	private int _thuTu;

}