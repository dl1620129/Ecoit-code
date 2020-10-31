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

package LinkManager.Service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GroupLinkSoap implements Serializable {

	public static GroupLinkSoap toSoapModel(GroupLink model) {
		GroupLinkSoap soapModel = new GroupLinkSoap();

		soapModel.setLinksgroupid(model.getLinksgroupid());
		soapModel.setGroupid(model.getGroupid());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateddate(model.getCreateddate());
		soapModel.setModifieddate(model.getModifieddate());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static GroupLinkSoap[] toSoapModels(GroupLink[] models) {
		GroupLinkSoap[] soapModels = new GroupLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupLinkSoap[][] toSoapModels(GroupLink[][] models) {
		GroupLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GroupLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupLinkSoap[] toSoapModels(List<GroupLink> models) {
		List<GroupLinkSoap> soapModels = new ArrayList<GroupLinkSoap>(
			models.size());

		for (GroupLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupLinkSoap[soapModels.size()]);
	}

	public GroupLinkSoap() {
	}

	public long getPrimaryKey() {
		return _linksgroupid;
	}

	public void setPrimaryKey(long pk) {
		setLinksgroupid(pk);
	}

	public long getLinksgroupid() {
		return _linksgroupid;
	}

	public void setLinksgroupid(long linksgroupid) {
		_linksgroupid = linksgroupid;
	}

	public long getGroupid() {
		return _groupid;
	}

	public void setGroupid(long groupid) {
		_groupid = groupid;
	}

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public Date getCreateddate() {
		return _createddate;
	}

	public void setCreateddate(Date createddate) {
		_createddate = createddate;
	}

	public Date getModifieddate() {
		return _modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _linksgroupid;
	private long _groupid;
	private long _createUserId;
	private Date _createddate;
	private Date _modifieddate;
	private String _groupName;
	private String _description;

}