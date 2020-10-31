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
 * The extended model interface for the LegalFoRel service. Represents a row in the &quot;ecoit_doc_LegalFoRel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Liverpool
 * @see LegalFoRelModel
 * @generated
 */
@ImplementationClassName("com.ecoit.elegaldocument.model.impl.LegalFoRelImpl")
@ProviderType
public interface LegalFoRel extends LegalFoRelModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.elegaldocument.model.impl.LegalFoRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LegalFoRel, Long> FIELD_ID_ACCESSOR =
		new Accessor<LegalFoRel, Long>() {

			@Override
			public Long get(LegalFoRel legalFoRel) {
				return legalFoRel.getFieldId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LegalFoRel> getTypeClass() {
				return LegalFoRel.class;
			}

		};
	public static final Accessor<LegalFoRel, Long> ORGANIZATION_ID_ACCESSOR =
		new Accessor<LegalFoRel, Long>() {

			@Override
			public Long get(LegalFoRel legalFoRel) {
				return legalFoRel.getOrganizationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LegalFoRel> getTypeClass() {
				return LegalFoRel.class;
			}

		};

}