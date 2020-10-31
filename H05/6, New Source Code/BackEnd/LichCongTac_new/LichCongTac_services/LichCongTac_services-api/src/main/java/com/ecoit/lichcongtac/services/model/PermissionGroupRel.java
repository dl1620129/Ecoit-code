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
 * The extended model interface for the PermissionGroupRel service. Represents a row in the &quot;ecoit_lich_PermissionGroupRel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupRelModel
 * @generated
 */
@ImplementationClassName(
	"com.ecoit.lichcongtac.services.model.impl.PermissionGroupRelImpl"
)
@ProviderType
public interface PermissionGroupRel
	extends PermissionGroupRelModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.lichcongtac.services.model.impl.PermissionGroupRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PermissionGroupRel, Long>
		USER_PERMISSION_GROUP_ID_ACCESSOR =
			new Accessor<PermissionGroupRel, Long>() {

				@Override
				public Long get(PermissionGroupRel permissionGroupRel) {
					return permissionGroupRel.getUserPermissionGroupId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<PermissionGroupRel> getTypeClass() {
					return PermissionGroupRel.class;
				}

			};
	public static final Accessor<PermissionGroupRel, Integer>
		PERMISSION_ID_ACCESSOR = new Accessor<PermissionGroupRel, Integer>() {

			@Override
			public Integer get(PermissionGroupRel permissionGroupRel) {
				return permissionGroupRel.getPermissionId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<PermissionGroupRel> getTypeClass() {
				return PermissionGroupRel.class;
			}

		};

}