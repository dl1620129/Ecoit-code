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

package com.web.ecoit.portal.quangcao.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link QuangCao}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCao
 * @generated
 */
@ProviderType
public class QuangCaoWrapper
	extends BaseModelWrapper<QuangCao>
	implements QuangCao, ModelWrapper<QuangCao> {

	public QuangCaoWrapper(QuangCao quangCao) {
		super(quangCao);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("quangCaoId", getQuangCaoId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tenQuangCao", getTenQuangCao());
		attributes.put("moTa", getMoTa());
		attributes.put("target", getTarget());
		attributes.put("imageId", getImageId());
		attributes.put("url", getUrl());
		attributes.put("type", getType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long quangCaoId = (Long)attributes.get("quangCaoId");

		if (quangCaoId != null) {
			setQuangCaoId(quangCaoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String tenQuangCao = (String)attributes.get("tenQuangCao");

		if (tenQuangCao != null) {
			setTenQuangCao(tenQuangCao);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		Boolean target = (Boolean)attributes.get("target");

		if (target != null) {
			setTarget(target);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the create date of this quang cao.
	 *
	 * @return the create date of this quang cao
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this quang cao.
	 *
	 * @return the group ID of this quang cao
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this quang cao.
	 *
	 * @return the image ID of this quang cao
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the language of this quang cao.
	 *
	 * @return the language of this quang cao
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the modified date of this quang cao.
	 *
	 * @return the modified date of this quang cao
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mo ta of this quang cao.
	 *
	 * @return the mo ta of this quang cao
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the primary key of this quang cao.
	 *
	 * @return the primary key of this quang cao
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quang cao ID of this quang cao.
	 *
	 * @return the quang cao ID of this quang cao
	 */
	@Override
	public long getQuangCaoId() {
		return model.getQuangCaoId();
	}

	/**
	 * Returns the status of this quang cao.
	 *
	 * @return the status of this quang cao
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the target of this quang cao.
	 *
	 * @return the target of this quang cao
	 */
	@Override
	public Boolean getTarget() {
		return model.getTarget();
	}

	/**
	 * Returns the ten quang cao of this quang cao.
	 *
	 * @return the ten quang cao of this quang cao
	 */
	@Override
	public String getTenQuangCao() {
		return model.getTenQuangCao();
	}

	/**
	 * Returns the type of this quang cao.
	 *
	 * @return the type of this quang cao
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the url of this quang cao.
	 *
	 * @return the url of this quang cao
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this quang cao.
	 *
	 * @return the user ID of this quang cao
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this quang cao.
	 *
	 * @return the user uuid of this quang cao
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this quang cao.
	 *
	 * @return the uuid of this quang cao
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this quang cao.
	 *
	 * @param createDate the create date of this quang cao
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this quang cao.
	 *
	 * @param groupId the group ID of this quang cao
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this quang cao.
	 *
	 * @param imageId the image ID of this quang cao
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the language of this quang cao.
	 *
	 * @param language the language of this quang cao
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the modified date of this quang cao.
	 *
	 * @param modifiedDate the modified date of this quang cao
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mo ta of this quang cao.
	 *
	 * @param moTa the mo ta of this quang cao
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the primary key of this quang cao.
	 *
	 * @param primaryKey the primary key of this quang cao
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quang cao ID of this quang cao.
	 *
	 * @param quangCaoId the quang cao ID of this quang cao
	 */
	@Override
	public void setQuangCaoId(long quangCaoId) {
		model.setQuangCaoId(quangCaoId);
	}

	/**
	 * Sets the status of this quang cao.
	 *
	 * @param status the status of this quang cao
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the target of this quang cao.
	 *
	 * @param target the target of this quang cao
	 */
	@Override
	public void setTarget(Boolean target) {
		model.setTarget(target);
	}

	/**
	 * Sets the ten quang cao of this quang cao.
	 *
	 * @param tenQuangCao the ten quang cao of this quang cao
	 */
	@Override
	public void setTenQuangCao(String tenQuangCao) {
		model.setTenQuangCao(tenQuangCao);
	}

	/**
	 * Sets the type of this quang cao.
	 *
	 * @param type the type of this quang cao
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the url of this quang cao.
	 *
	 * @param url the url of this quang cao
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this quang cao.
	 *
	 * @param userId the user ID of this quang cao
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this quang cao.
	 *
	 * @param userUuid the user uuid of this quang cao
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this quang cao.
	 *
	 * @param uuid the uuid of this quang cao
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected QuangCaoWrapper wrap(QuangCao quangCao) {
		return new QuangCaoWrapper(quangCao);
	}

}