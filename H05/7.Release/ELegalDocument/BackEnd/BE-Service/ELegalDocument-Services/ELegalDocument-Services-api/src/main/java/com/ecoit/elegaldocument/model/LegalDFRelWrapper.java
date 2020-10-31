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
 * This class is a wrapper for {@link LegalDFRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDFRel
 * @generated
 */
public class LegalDFRelWrapper
	extends BaseModelWrapper<LegalDFRel>
	implements LegalDFRel, ModelWrapper<LegalDFRel> {

	public LegalDFRelWrapper(LegalDFRel legalDFRel) {
		super(legalDFRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docId", getDocId());
		attributes.put("fieldId", getFieldId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}
	}

	/**
	 * Returns the doc ID of this legal df rel.
	 *
	 * @return the doc ID of this legal df rel
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the field ID of this legal df rel.
	 *
	 * @return the field ID of this legal df rel
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the primary key of this legal df rel.
	 *
	 * @return the primary key of this legal df rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the doc ID of this legal df rel.
	 *
	 * @param docId the doc ID of this legal df rel
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the field ID of this legal df rel.
	 *
	 * @param fieldId the field ID of this legal df rel
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the primary key of this legal df rel.
	 *
	 * @param primaryKey the primary key of this legal df rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalDFRelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected LegalDFRelWrapper wrap(LegalDFRel legalDFRel) {
		return new LegalDFRelWrapper(legalDFRel);
	}

}