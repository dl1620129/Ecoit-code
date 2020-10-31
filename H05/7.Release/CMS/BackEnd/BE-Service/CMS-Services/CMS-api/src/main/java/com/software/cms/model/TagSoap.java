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

package com.software.cms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.TagServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class TagSoap implements Serializable {

	public static TagSoap toSoapModel(Tag model) {
		TagSoap soapModel = new TagSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTagId(model.getTagId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTagName(model.getTagName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static TagSoap[] toSoapModels(Tag[] models) {
		TagSoap[] soapModels = new TagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TagSoap[][] toSoapModels(Tag[][] models) {
		TagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TagSoap[] toSoapModels(List<Tag> models) {
		List<TagSoap> soapModels = new ArrayList<TagSoap>(models.size());

		for (Tag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TagSoap[soapModels.size()]);
	}

	public TagSoap() {
	}

	public long getPrimaryKey() {
		return _tagId;
	}

	public void setPrimaryKey(long pk) {
		setTagId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTagName() {
		return _tagName;
	}

	public void setTagName(String tagName) {
		_tagName = tagName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _tagId;
	private long _groupId;
	private String _language;
	private String _tagName;
	private String _description;

}