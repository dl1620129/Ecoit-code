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
 * The extended model interface for the ColumnGroupRel service. Represents a row in the &quot;ecoit_lich_ColumnGroupRel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelModel
 * @generated
 */
@ImplementationClassName(
	"com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelImpl"
)
@ProviderType
public interface ColumnGroupRel extends ColumnGroupRelModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ColumnGroupRel, Long>
		USER_PERMISSION_GROUP_ID_ACCESSOR =
			new Accessor<ColumnGroupRel, Long>() {

				@Override
				public Long get(ColumnGroupRel columnGroupRel) {
					return columnGroupRel.getUserPermissionGroupId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ColumnGroupRel> getTypeClass() {
					return ColumnGroupRel.class;
				}

			};
	public static final Accessor<ColumnGroupRel, Integer> COLUMN_ID_ACCESSOR =
		new Accessor<ColumnGroupRel, Integer>() {

			@Override
			public Integer get(ColumnGroupRel columnGroupRel) {
				return columnGroupRel.getColumnId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<ColumnGroupRel> getTypeClass() {
				return ColumnGroupRel.class;
			}

		};

}