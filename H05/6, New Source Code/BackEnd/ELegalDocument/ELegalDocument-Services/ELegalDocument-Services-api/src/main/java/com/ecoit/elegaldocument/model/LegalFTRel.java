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
 * The extended model interface for the LegalFTRel service. Represents a row in the &quot;ecoit_doc_LegalFTRel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Liverpool
 * @see LegalFTRelModel
 * @generated
 */
@ImplementationClassName("com.ecoit.elegaldocument.model.impl.LegalFTRelImpl")
@ProviderType
public interface LegalFTRel extends LegalFTRelModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.elegaldocument.model.impl.LegalFTRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LegalFTRel, Long> FIELD_ID_ACCESSOR =
		new Accessor<LegalFTRel, Long>() {

			@Override
			public Long get(LegalFTRel legalFTRel) {
				return legalFTRel.getFieldId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LegalFTRel> getTypeClass() {
				return LegalFTRel.class;
			}

		};
	public static final Accessor<LegalFTRel, Long> TYPE_ID_ACCESSOR =
		new Accessor<LegalFTRel, Long>() {

			@Override
			public Long get(LegalFTRel legalFTRel) {
				return legalFTRel.getTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LegalFTRel> getTypeClass() {
				return LegalFTRel.class;
			}

		};

}