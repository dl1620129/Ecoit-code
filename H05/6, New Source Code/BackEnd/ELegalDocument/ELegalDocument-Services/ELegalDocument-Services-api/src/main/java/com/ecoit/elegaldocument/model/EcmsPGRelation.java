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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EcmsPGRelation service. Represents a row in the &quot;ecoit_doc_EcmsPGRelation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Liverpool
 * @see EcmsPGRelationModel
 * @generated
 */
@ImplementationClassName(
	"com.ecoit.elegaldocument.model.impl.EcmsPGRelationImpl"
)
@ProviderType
public interface EcmsPGRelation extends EcmsPGRelationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.elegaldocument.model.impl.EcmsPGRelationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EcmsPGRelation, Long> GROUP_USER_ID_ACCESSOR =
		new Accessor<EcmsPGRelation, Long>() {

			@Override
			public Long get(EcmsPGRelation ecmsPGRelation) {
				return ecmsPGRelation.getGroupUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EcmsPGRelation> getTypeClass() {
				return EcmsPGRelation.class;
			}

		};
	public static final Accessor<EcmsPGRelation, Integer> PERMISSION_ACCESSOR =
		new Accessor<EcmsPGRelation, Integer>() {

			@Override
			public Integer get(EcmsPGRelation ecmsPGRelation) {
				return ecmsPGRelation.getPermission();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<EcmsPGRelation> getTypeClass() {
				return EcmsPGRelation.class;
			}

		};

}