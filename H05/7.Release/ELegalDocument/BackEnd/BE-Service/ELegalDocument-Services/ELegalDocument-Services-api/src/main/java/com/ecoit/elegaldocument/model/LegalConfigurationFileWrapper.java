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

package com.ecoit.elegaldocument.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegalConfigurationFile}.
 * </p>
 *
 * @author Liverpool
 * @see LegalConfigurationFile
 * @generated
 */
public class LegalConfigurationFileWrapper
	extends BaseModelWrapper<LegalConfigurationFile>
	implements LegalConfigurationFile, ModelWrapper<LegalConfigurationFile> {

	public LegalConfigurationFileWrapper(
		LegalConfigurationFile legalConfigurationFile) {

		super(legalConfigurationFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("keyId", getKeyId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String keyId = (String)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the key ID of this legal configuration file.
	 *
	 * @return the key ID of this legal configuration file
	 */
	@Override
	public String getKeyId() {
		return model.getKeyId();
	}

	/**
	 * Returns the primary key of this legal configuration file.
	 *
	 * @return the primary key of this legal configuration file
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this legal configuration file.
	 *
	 * @return the value of this legal configuration file
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the key ID of this legal configuration file.
	 *
	 * @param keyId the key ID of this legal configuration file
	 */
	@Override
	public void setKeyId(String keyId) {
		model.setKeyId(keyId);
	}

	/**
	 * Sets the primary key of this legal configuration file.
	 *
	 * @param primaryKey the primary key of this legal configuration file
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this legal configuration file.
	 *
	 * @param value the value of this legal configuration file
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected LegalConfigurationFileWrapper wrap(
		LegalConfigurationFile legalConfigurationFile) {

		return new LegalConfigurationFileWrapper(legalConfigurationFile);
	}

}