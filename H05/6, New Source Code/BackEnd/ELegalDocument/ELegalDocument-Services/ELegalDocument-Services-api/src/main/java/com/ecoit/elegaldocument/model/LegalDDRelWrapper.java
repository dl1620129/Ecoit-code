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
 * This class is a wrapper for {@link LegalDDRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDDRel
 * @generated
 */
public class LegalDDRelWrapper
	extends BaseModelWrapper<LegalDDRel>
	implements LegalDDRel, ModelWrapper<LegalDDRel> {

	public LegalDDRelWrapper(LegalDDRel legalDDRel) {
		super(legalDDRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("docId", getDocId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String docId = (String)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}
	}

	/**
	 * Returns the department ID of this legal dd rel.
	 *
	 * @return the department ID of this legal dd rel
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the doc ID of this legal dd rel.
	 *
	 * @return the doc ID of this legal dd rel
	 */
	@Override
	public String getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the primary key of this legal dd rel.
	 *
	 * @return the primary key of this legal dd rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the department ID of this legal dd rel.
	 *
	 * @param departmentId the department ID of this legal dd rel
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the doc ID of this legal dd rel.
	 *
	 * @param docId the doc ID of this legal dd rel
	 */
	@Override
	public void setDocId(String docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the primary key of this legal dd rel.
	 *
	 * @param primaryKey the primary key of this legal dd rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalDDRelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected LegalDDRelWrapper wrap(LegalDDRel legalDDRel) {
		return new LegalDDRelWrapper(legalDDRel);
	}

}