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

package com.software.cms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PermissionGroup service. Represents a row in the &quot;soft_cms_PermissionGroup&quot; database table, with each column mapped to a property of this class.
 *
 * @author DungNV
 * @see PermissionGroupModel
 * @generated
 */
@ImplementationClassName("com.software.cms.model.impl.PermissionGroupImpl")
@ProviderType
public interface PermissionGroup extends PermissionGroupModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.software.cms.model.impl.PermissionGroupImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PermissionGroup, Long> PERMISSION_ID_ACCESSOR =
		new Accessor<PermissionGroup, Long>() {

			@Override
			public Long get(PermissionGroup permissionGroup) {
				return permissionGroup.getPermissionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PermissionGroup> getTypeClass() {
				return PermissionGroup.class;
			}

		};
	public static final Accessor<PermissionGroup, Long> GROUPUSERID_ACCESSOR =
		new Accessor<PermissionGroup, Long>() {

			@Override
			public Long get(PermissionGroup permissionGroup) {
				return permissionGroup.getGroupuserid();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PermissionGroup> getTypeClass() {
				return PermissionGroup.class;
			}

		};

}