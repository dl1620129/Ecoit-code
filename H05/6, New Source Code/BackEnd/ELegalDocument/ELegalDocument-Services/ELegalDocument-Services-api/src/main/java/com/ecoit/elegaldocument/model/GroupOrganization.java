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
 * The extended model interface for the GroupOrganization service. Represents a row in the &quot;ecoit_doc_GroupOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * @author Liverpool
 * @see GroupOrganizationModel
 * @generated
 */
@ImplementationClassName(
	"com.ecoit.elegaldocument.model.impl.GroupOrganizationImpl"
)
@ProviderType
public interface GroupOrganization
	extends GroupOrganizationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GroupOrganization, Long>
		GROUP_USER_ID_ACCESSOR = new Accessor<GroupOrganization, Long>() {

			@Override
			public Long get(GroupOrganization groupOrganization) {
				return groupOrganization.getGroupUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GroupOrganization> getTypeClass() {
				return GroupOrganization.class;
			}

		};
	public static final Accessor<GroupOrganization, Long>
		ORGANIZATIONID_ACCESSOR = new Accessor<GroupOrganization, Long>() {

			@Override
			public Long get(GroupOrganization groupOrganization) {
				return groupOrganization.getOrganizationid();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GroupOrganization> getTypeClass() {
				return GroupOrganization.class;
			}

		};

}