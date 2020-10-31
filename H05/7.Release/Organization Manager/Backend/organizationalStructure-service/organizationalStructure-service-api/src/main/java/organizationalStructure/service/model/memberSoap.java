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
 * This class is used by SOAP remote services, specifically {@link organizationalStructure.service.service.http.memberServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class memberSoap implements Serializable {

	public static memberSoap toSoapModel(member model) {
		memberSoap soapModel = new memberSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setFullName(model.getFullName());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setAddress(model.getAddress());
		soapModel.setSex(model.getSex());
		soapModel.setPosition(model.getPosition());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreateUser(model.getCreateUser());
		soapModel.setModifiedUser(model.getModifiedUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIsLeader(model.getIsLeader());
		soapModel.setUrlImage(model.getUrlImage());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setImageFileId(model.getImageFileId());

		return soapModel;
	}

	public static memberSoap[] toSoapModels(member[] models) {
		memberSoap[] soapModels = new memberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static memberSoap[][] toSoapModels(member[][] models) {
		memberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new memberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new memberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static memberSoap[] toSoapModels(List<member> models) {
		List<memberSoap> soapModels = new ArrayList<memberSoap>(models.size());

		for (member model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new memberSoap[soapModels.size()]);
	}

	public memberSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Boolean getSex() {
		return _sex;
	}

	public void setSex(Boolean sex) {
		_sex = sex;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Boolean getIsLeader() {
		return _isLeader;
	}

	public void setIsLeader(Boolean isLeader) {
		_isLeader = isLeader;
	}

	public String getUrlImage() {
		return _urlImage;
	}

	public void setUrlImage(String urlImage) {
		_urlImage = urlImage;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public long getImageFileId() {
		return _imageFileId;
	}

	public void setImageFileId(long imageFileId) {
		_imageFileId = imageFileId;
	}

	private String _uuid;
	private long _memberId;
	private long _groupId;
	private long _organizationId;
	private String _fullName;
	private Date _birthday;
	private String _address;
	private Boolean _sex;
	private String _position;
	private Date _createDate;
	private long _createUser;
	private long _modifiedUser;
	private Date _modifiedDate;
	private Boolean _isLeader;
	private String _urlImage;
	private long _folderId;
	private long _imageFileId;

}