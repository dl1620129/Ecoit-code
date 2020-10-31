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
public interface CommentFinder {

	public java.util.List<com.software.cms.model.Comment> getCountCommentBySQL(
			String sql, Integer start, Integer end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.software.cms.model.Comment> findComment(
		long groupId, String keyword, int start, int end);

	public int getCountBySQL(long groupId, String keyword)
		throws com.liferay.portal.kernel.exception.SystemException;

}