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
 * This class is a wrapper for {@link LegalDURel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDURel
 * @generated
 */
public class LegalDURelWrapper
	extends BaseModelWrapper<LegalDURel>
	implements LegalDURel, ModelWrapper<LegalDURel> {

	public LegalDURelWrapper(LegalDURel legalDURel) {
		super(legalDURel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("userid", getUserid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long userid = (Long)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}
	}

	/**
	 * Returns the department ID of this legal du rel.
	 *
	 * @return the department ID of this legal du rel
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the primary key of this legal du rel.
	 *
	 * @return the primary key of this legal du rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalDURelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the userid of this legal du rel.
	 *
	 * @return the userid of this legal du rel
	 */
	@Override
	public long getUserid() {
		return model.getUserid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the department ID of this legal du rel.
	 *
	 * @param departmentId the department ID of this legal du rel
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the primary key of this legal du rel.
	 *
	 * @param primaryKey the primary key of this legal du rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalDURelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the userid of this legal du rel.
	 *
	 * @param userid the userid of this legal du rel
	 */
	@Override
	public void setUserid(long userid) {
		model.setUserid(userid);
	}

	@Override
	protected LegalDURelWrapper wrap(LegalDURel legalDURel) {
		return new LegalDURelWrapper(legalDURel);
	}

}