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
 * This class is a wrapper for {@link LegalDTypeRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDTypeRel
 * @generated
 */
public class LegalDTypeRelWrapper
	extends BaseModelWrapper<LegalDTypeRel>
	implements LegalDTypeRel, ModelWrapper<LegalDTypeRel> {

	public LegalDTypeRelWrapper(LegalDTypeRel legalDTypeRel) {
		super(legalDTypeRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docId", getDocId());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	/**
	 * Returns the doc ID of this legal d type rel.
	 *
	 * @return the doc ID of this legal d type rel
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the primary key of this legal d type rel.
	 *
	 * @return the primary key of this legal d type rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the type ID of this legal d type rel.
	 *
	 * @return the type ID of this legal d type rel
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
	 * Sets the doc ID of this legal d type rel.
	 *
	 * @param docId the doc ID of this legal d type rel
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the primary key of this legal d type rel.
	 *
	 * @param primaryKey the primary key of this legal d type rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type ID of this legal d type rel.
	 *
	 * @param typeId the type ID of this legal d type rel
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	protected LegalDTypeRelWrapper wrap(LegalDTypeRel legalDTypeRel) {
		return new LegalDTypeRelWrapper(legalDTypeRel);
	}

}