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

package com.ecoit.lichcongtac.services.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LichChiTiet service. Represents a row in the &quot;ecoit_lich_LichChiTiet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietModel
 * @generated
 */
@ImplementationClassName(
	"com.ecoit.lichcongtac.services.model.impl.LichChiTietImpl"
)
@ProviderType
public interface LichChiTiet extends LichChiTietModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LichChiTiet, Long> LICH_CHI_TIET_ID_ACCESSOR =
		new Accessor<LichChiTiet, Long>() {

			@Override
			public Long get(LichChiTiet lichChiTiet) {
				return lichChiTiet.getLichChiTietId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LichChiTiet> getTypeClass() {
				return LichChiTiet.class;
			}

		};

}