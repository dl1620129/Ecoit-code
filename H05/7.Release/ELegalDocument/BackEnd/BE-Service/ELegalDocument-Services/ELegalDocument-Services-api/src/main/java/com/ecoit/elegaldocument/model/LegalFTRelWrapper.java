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
 * This class is a wrapper for {@link LegalFTRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalFTRel
 * @generated
 */
public class LegalFTRelWrapper
	extends BaseModelWrapper<LegalFTRel>
	implements LegalFTRel, ModelWrapper<LegalFTRel> {

	public LegalFTRelWrapper(LegalFTRel legalFTRel) {
		super(legalFTRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fieldId", getFieldId());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	/**
	 * Returns the field ID of this legal ft rel.
	 *
	 * @return the field ID of this legal ft rel
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the primary key of this legal ft rel.
	 *
	 * @return the primary key of this legal ft rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalFTRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the type ID of this legal ft rel.
	 *
	 * @return the type ID of this legal ft rel
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the field ID of this legal ft rel.
	 *
	 * @param fieldId the field ID of this legal ft rel
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the primary key of this legal ft rel.
	 *
	 * @param primaryKey the primary key of this legal ft rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalFTRelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type ID of this legal ft rel.
	 *
	 * @param typeId the type ID of this legal ft rel
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	protected LegalFTRelWrapper wrap(LegalFTRel legalFTRel) {
		return new LegalFTRelWrapper(legalFTRel);
	}

}