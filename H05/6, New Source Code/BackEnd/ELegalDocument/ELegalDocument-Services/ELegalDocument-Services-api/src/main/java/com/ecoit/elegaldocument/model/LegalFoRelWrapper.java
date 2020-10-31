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
 * This class is a wrapper for {@link LegalFoRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalFoRel
 * @generated
 */
public class LegalFoRelWrapper
	extends BaseModelWrapper<LegalFoRel>
	implements LegalFoRel, ModelWrapper<LegalFoRel> {

	public LegalFoRelWrapper(LegalFoRel legalFoRel) {
		super(legalFoRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fieldId", getFieldId());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	/**
	 * Returns the field ID of this legal fo rel.
	 *
	 * @return the field ID of this legal fo rel
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the organization ID of this legal fo rel.
	 *
	 * @return the organization ID of this legal fo rel
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this legal fo rel.
	 *
	 * @return the primary key of this legal fo rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalFoRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the field ID of this legal fo rel.
	 *
	 * @param fieldId the field ID of this legal fo rel
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the organization ID of this legal fo rel.
	 *
	 * @param organizationId the organization ID of this legal fo rel
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this legal fo rel.
	 *
	 * @param primaryKey the primary key of this legal fo rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalFoRelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected LegalFoRelWrapper wrap(LegalFoRel legalFoRel) {
		return new LegalFoRelWrapper(legalFoRel);
	}

}