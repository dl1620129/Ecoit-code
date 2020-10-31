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

package User.Rank.Poisition.Service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserPoisition service. Represents a row in the &quot;portal_user_UserPoisition&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisitionModel
 * @generated
 */
@ImplementationClassName(
	"User.Rank.Poisition.Service.model.impl.UserPoisitionImpl"
)
@ProviderType
public interface UserPoisition extends PersistedModel, UserPoisitionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>User.Rank.Poisition.Service.model.impl.UserPoisitionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserPoisition, Long>
		USER_POISITION_ID_ACCESSOR = new Accessor<UserPoisition, Long>() {

			@Override
			public Long get(UserPoisition userPoisition) {
				return userPoisition.getUserPoisitionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserPoisition> getTypeClass() {
				return UserPoisition.class;
			}

		};

}