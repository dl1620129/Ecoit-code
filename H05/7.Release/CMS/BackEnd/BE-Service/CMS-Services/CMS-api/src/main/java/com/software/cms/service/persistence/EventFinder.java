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

package com.software.cms.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author DungNV
 * @generated
 */
@ProviderType
public interface EventFinder {

	public java.util.List<com.software.cms.model.Event> findEvent(
		long groupId, String language, String keyword, int start, int limit);

	public int getCountEvent(long groupId, String language, String keyword);

	public java.util.List<com.software.cms.model.Event> getEventBySql(
		String sql, int start, int end);

}