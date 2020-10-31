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
 * This class is a wrapper for {@link LegalTDRel}.
 * </p>
 *
 * @author Liverpool
 * @see LegalTDRel
 * @generated
 */
public class LegalTDRelWrapper
	extends BaseModelWrapper<LegalTDRel>
	implements LegalTDRel, ModelWrapper<LegalTDRel> {

	public LegalTDRelWrapper(LegalTDRel legalTDRel) {
		super(legalTDRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docId", getDocId());
		attributes.put("tagId", getTagId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}
	}

	/**
	 * Returns the doc ID of this legal td rel.
	 *
	 * @return the doc ID of this legal td rel
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the primary key of this legal td rel.
	 *
	 * @return the primary key of this legal td rel
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.LegalTDRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the tag ID of this legal td rel.
	 *
	 * @return the tag ID of this legal td rel
	 */
	@Override
	public long getTagId() {
		return model.getTagId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the doc ID of this legal td rel.
	 *
	 * @param docId the doc ID of this legal td rel
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the primary key of this legal td rel.
	 *
	 * @param primaryKey the primary key of this legal td rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.LegalTDRelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tag ID of this legal td rel.
	 *
	 * @param tagId the tag ID of this legal td rel
	 */
	@Override
	public void setTagId(long tagId) {
		model.setTagId(tagId);
	}

	@Override
	protected LegalTDRelWrapper wrap(LegalTDRel legalTDRel) {
		return new LegalTDRelWrapper(legalTDRel);
	}

}