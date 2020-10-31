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

package com.software.cms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TagLocalService}.
 *
 * @author DungNV
 * @see TagLocalService
 * @generated
 */
public class TagLocalServiceWrapper
	implements ServiceWrapper<TagLocalService>, TagLocalService {

	public TagLocalServiceWrapper(TagLocalService tagLocalService) {
		_tagLocalService = tagLocalService;
	}

	/**
	 * Adds the tag to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tag the tag
	 * @return the tag that was added
	 */
	@Override
	public com.software.cms.model.Tag addTag(com.software.cms.model.Tag tag) {
		return _tagLocalService.addTag(tag);
	}

	@Override
	public com.software.cms.model.Tag create() {
		return _tagLocalService.create();
	}

	/**
	 * Creates a new tag with the primary key. Does not add the tag to the database.
	 *
	 * @param tagId the primary key for the new tag
	 * @return the new tag
	 */
	@Override
	public com.software.cms.model.Tag createTag(long tagId) {
		return _tagLocalService.createTag(tagId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag that was removed
	 * @throws PortalException if a tag with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Tag deleteTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagLocalService.deleteTag(tagId);
	}

	/**
	 * Deletes the tag from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tag the tag
	 * @return the tag that was removed
	 */
	@Override
	public com.software.cms.model.Tag deleteTag(
		com.software.cms.model.Tag tag) {

		return _tagLocalService.deleteTag(tag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tagLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.TagModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.TagModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tagLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tagLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tagLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.Tag fetchTag(long tagId) {
		return _tagLocalService.fetchTag(tagId);
	}

	/**
	 * Returns the tag matching the UUID and group.
	 *
	 * @param uuid the tag's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tag, or <code>null</code> if a matching tag could not be found
	 */
	@Override
	public com.software.cms.model.Tag fetchTagByUuidAndGroupId(
		String uuid, long groupId) {

		return _tagLocalService.fetchTagByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tagLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountByTag(String name, long groupId, String language)
		throws Exception {

		return _tagLocalService.getCountByTag(name, groupId, language);
	}

	@Override
	public int getCountByTagName(
		long groupId, String language, String tagname) {

		return _tagLocalService.getCountByTagName(groupId, language, tagname);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tagLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.software.cms.model.Tag> getListTag(
			String name, long groupId, String language, int start, int limit)
		throws Exception {

		return _tagLocalService.getListTag(
			name, groupId, language, start, limit);
	}

	@Override
	public int getMaxId(String sql) {
		return _tagLocalService.getMaxId(sql);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tagLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tag with the primary key.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag
	 * @throws PortalException if a tag with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Tag getTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagLocalService.getTag(tagId);
	}

	/**
	 * Returns the tag matching the UUID and group.
	 *
	 * @param uuid the tag's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tag
	 * @throws PortalException if a matching tag could not be found
	 */
	@Override
	public com.software.cms.model.Tag getTagByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagLocalService.getTagByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @return the range of tags
	 */
	@Override
	public java.util.List<com.software.cms.model.Tag> getTags(
		int start, int end) {

		return _tagLocalService.getTags(start, end);
	}

	/**
	 * Returns the number of tags.
	 *
	 * @return the number of tags
	 */
	@Override
	public int getTagsCount() {
		return _tagLocalService.getTagsCount();
	}

	@Override
	public java.util.List<com.software.cms.model.Tag> searchByArticle(
		long articleId) {

		return _tagLocalService.searchByArticle(articleId);
	}

	@Override
	public java.util.List<com.software.cms.model.Tag> searchByTagName(
		String name, long groupid, String language) {

		return _tagLocalService.searchByTagName(name, groupid, language);
	}

	@Override
	public java.util.List<com.software.cms.model.Tag>
		searchTagByGroupIdAndLanguage(long groupId, String language) {

		return _tagLocalService.searchTagByGroupIdAndLanguage(
			groupId, language);
	}

	/**
	 * Updates the tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tag the tag
	 * @return the tag that was updated
	 */
	@Override
	public com.software.cms.model.Tag updateTag(
		com.software.cms.model.Tag tag) {

		return _tagLocalService.updateTag(tag);
	}

	@Override
	public TagLocalService getWrappedService() {
		return _tagLocalService;
	}

	@Override
	public void setWrappedService(TagLocalService tagLocalService) {
		_tagLocalService = tagLocalService;
	}

	private TagLocalService _tagLocalService;

}