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
 * This class is a wrapper for {@link QuangCaoSlider}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoSlider
 * @generated
 */
@ProviderType
public class QuangCaoSliderWrapper
	extends BaseModelWrapper<QuangCaoSlider>
	implements QuangCaoSlider, ModelWrapper<QuangCaoSlider> {

	public QuangCaoSliderWrapper(QuangCaoSlider quangCaoSlider) {
		super(quangCaoSlider);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("quangCaoSliderId", getQuangCaoSliderId());
		attributes.put("quangCaoId", getQuangCaoId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tenQuangCao", getTenQuangCao());
		attributes.put("moTa", getMoTa());
		attributes.put("target", getTarget());
		attributes.put("url", getUrl());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long quangCaoSliderId = (Long)attributes.get("quangCaoSliderId");

		if (quangCaoSliderId != null) {
			setQuangCaoSliderId(quangCaoSliderId);
		}

		Long quangCaoId = (Long)attributes.get("quangCaoId");

		if (quangCaoId != null) {
			setQuangCaoId(quangCaoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the create date of this quang cao slider.
	 *
	 * @return the create date of this quang cao slider
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this quang cao slider.
	 *
	 * @return the group ID of this quang cao slider
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this quang cao slider.
	 *
	 * @return the modified date of this quang cao slider
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mo ta of this quang cao slider.
	 *
	 * @return the mo ta of this quang cao slider
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the primary key of this quang cao slider.
	 *
	 * @return the primary key of this quang cao slider
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quang cao ID of this quang cao slider.
	 *
	 * @return the quang cao ID of this quang cao slider
	 */
	@Override
	public long getQuangCaoId() {
		return model.getQuangCaoId();
	}

	/**
	 * Returns the quang cao slider ID of this quang cao slider.
	 *
	 * @return the quang cao slider ID of this quang cao slider
	 */
	@Override
	public long getQuangCaoSliderId() {
		return model.getQuangCaoSliderId();
	}

	/**
	 * Returns the target of this quang cao slider.
	 *
	 * @return the target of this quang cao slider
	 */
	@Override
	public Boolean getTarget() {
		return model.getTarget();
	}

	/**
	 * Returns the ten quang cao of this quang cao slider.
	 *
	 * @return the ten quang cao of this quang cao slider
	 */
	@Override
	public String getTenQuangCao() {
		return model.getTenQuangCao();
	}

	/**
	 * Returns the type of this quang cao slider.
	 *
	 * @return the type of this quang cao slider
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the url of this quang cao slider.
	 *
	 * @return the url of this quang cao slider
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this quang cao slider.
	 *
	 * @return the user ID of this quang cao slider
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this quang cao slider.
	 *
	 * @return the user uuid of this quang cao slider
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this quang cao slider.
	 *
	 * @return the uuid of this quang cao slider
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
	 * Sets the create date of this quang cao slider.
	 *
	 * @param createDate the create date of this quang cao slider
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this quang cao slider.
	 *
	 * @param groupId the group ID of this quang cao slider
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this quang cao slider.
	 *
	 * @param modifiedDate the modified date of this quang cao slider
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mo ta of this quang cao slider.
	 *
	 * @param moTa the mo ta of this quang cao slider
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the primary key of this quang cao slider.
	 *
	 * @param primaryKey the primary key of this quang cao slider
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quang cao ID of this quang cao slider.
	 *
	 * @param quangCaoId the quang cao ID of this quang cao slider
	 */
	@Override
	public void setQuangCaoId(long quangCaoId) {
		model.setQuangCaoId(quangCaoId);
	}

	/**
	 * Sets the quang cao slider ID of this quang cao slider.
	 *
	 * @param quangCaoSliderId the quang cao slider ID of this quang cao slider
	 */
	@Override
	public void setQuangCaoSliderId(long quangCaoSliderId) {
		model.setQuangCaoSliderId(quangCaoSliderId);
	}

	/**
	 * Sets the target of this quang cao slider.
	 *
	 * @param target the target of this quang cao slider
	 */
	@Override
	public void setTarget(Boolean target) {
		model.setTarget(target);
	}

	/**
	 * Sets the ten quang cao of this quang cao slider.
	 *
	 * @param tenQuangCao the ten quang cao of this quang cao slider
	 */
	@Override
	public void setTenQuangCao(String tenQuangCao) {
		model.setTenQuangCao(tenQuangCao);
	}

	/**
	 * Sets the type of this quang cao slider.
	 *
	 * @param type the type of this quang cao slider
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the url of this quang cao slider.
	 *
	 * @param url the url of this quang cao slider
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this quang cao slider.
	 *
	 * @param userId the user ID of this quang cao slider
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this quang cao slider.
	 *
	 * @param userUuid the user uuid of this quang cao slider
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this quang cao slider.
	 *
	 * @param uuid the uuid of this quang cao slider
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected QuangCaoSliderWrapper wrap(QuangCaoSlider quangCaoSlider) {
		return new QuangCaoSliderWrapper(quangCaoSlider);
	}

}