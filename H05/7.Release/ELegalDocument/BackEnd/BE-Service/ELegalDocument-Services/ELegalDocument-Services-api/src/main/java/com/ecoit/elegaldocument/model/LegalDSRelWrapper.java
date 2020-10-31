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
 * This class is a wrapper for {@link LegalDSRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDSRel
 * @generated
 */
public class LegalDSRelWrapper
	extends BaseModelWrapper<LegalDSRel>
	implements LegalDSRel, ModelWrapper<LegalDSRel> {

	public LegalDSRelWrapper(LegalDSRel legalDSRel) {
		super(legalDSRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docId", getDocId());
		attributes.put("sigId", getSigId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Long sigId = (Long)attributes.get("sigId");

		if (sigId != null) {
			setSigId(sigId);
		}
	}

	/**
	 * Returns the doc ID of this legal ds rel.
	 *
	 * @return the doc ID of this legal ds rel
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the primary key of this legal ds rel.
	 *
	 * @return the primary key of this legal ds rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalDSRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the sig ID of this legal ds rel.
	 *
	 * @return the sig ID of this legal ds rel
	 */
	@Override
	public long getSigId() {
		return model.getSigId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the doc ID of this legal ds rel.
	 *
	 * @param docId the doc ID of this legal ds rel
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the primary key of this legal ds rel.
	 *
	 * @param primaryKey the primary key of this legal ds rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalDSRelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sig ID of this legal ds rel.
	 *
	 * @param sigId the sig ID of this legal ds rel
	 */
	@Override
	public void setSigId(long sigId) {
		model.setSigId(sigId);
	}

	@Override
	protected LegalDSRelWrapper wrap(LegalDSRel legalDSRel) {
		return new LegalDSRelWrapper(legalDSRel);
	}

}