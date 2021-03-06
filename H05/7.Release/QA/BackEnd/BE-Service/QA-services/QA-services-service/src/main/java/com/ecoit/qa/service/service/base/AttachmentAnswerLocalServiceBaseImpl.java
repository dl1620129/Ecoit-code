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

package com.ecoit.qa.service.service.base;

import com.ecoit.qa.service.model.AttachmentAnswer;
import com.ecoit.qa.service.service.AttachmentAnswerLocalService;
import com.ecoit.qa.service.service.persistence.AnswerPersistence;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPersistence;
import com.ecoit.qa.service.service.persistence.AttachmentQuestionPersistence;
import com.ecoit.qa.service.service.persistence.CategoryPersistence;
import com.ecoit.qa.service.service.persistence.GroupUserCategoryPersistence;
import com.ecoit.qa.service.service.persistence.GroupUserPermissionPersistence;
import com.ecoit.qa.service.service.persistence.GroupUserPersistence;
import com.ecoit.qa.service.service.persistence.GroupUserUserPersistence;
import com.ecoit.qa.service.service.persistence.QuestionPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the attachment answer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ecoit.qa.service.service.impl.AttachmentAnswerLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ecoit.qa.service.service.impl.AttachmentAnswerLocalServiceImpl
 * @generated
 */
public abstract class AttachmentAnswerLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, AttachmentAnswerLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AttachmentAnswerLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.qa.service.service.AttachmentAnswerLocalServiceUtil</code>.
	 */

	/**
	 * Adds the attachment answer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AttachmentAnswer addAttachmentAnswer(
		AttachmentAnswer attachmentAnswer) {

		attachmentAnswer.setNew(true);

		return attachmentAnswerPersistence.update(attachmentAnswer);
	}

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	@Override
	@Transactional(enabled = false)
	public AttachmentAnswer createAttachmentAnswer(
		AttachmentAnswerPK attachmentAnswerPK) {

		return attachmentAnswerPersistence.create(attachmentAnswerPK);
	}

	/**
	 * Deletes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AttachmentAnswer deleteAttachmentAnswer(
			AttachmentAnswerPK attachmentAnswerPK)
		throws PortalException {

		return attachmentAnswerPersistence.remove(attachmentAnswerPK);
	}

	/**
	 * Deletes the attachment answer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AttachmentAnswer deleteAttachmentAnswer(
		AttachmentAnswer attachmentAnswer) {

		return attachmentAnswerPersistence.remove(attachmentAnswer);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			AttachmentAnswer.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return attachmentAnswerPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return attachmentAnswerPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return attachmentAnswerPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return attachmentAnswerPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return attachmentAnswerPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AttachmentAnswer fetchAttachmentAnswer(
		AttachmentAnswerPK attachmentAnswerPK) {

		return attachmentAnswerPersistence.fetchByPrimaryKey(
			attachmentAnswerPK);
	}

	/**
	 * Returns the attachment answer with the primary key.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	@Override
	public AttachmentAnswer getAttachmentAnswer(
			AttachmentAnswerPK attachmentAnswerPK)
		throws PortalException {

		return attachmentAnswerPersistence.findByPrimaryKey(attachmentAnswerPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			attachmentAnswerLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AttachmentAnswer.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.attachmentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			attachmentAnswerLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AttachmentAnswer.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.attachmentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			attachmentAnswerLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AttachmentAnswer.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.attachmentId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return attachmentAnswerLocalService.deleteAttachmentAnswer(
			(AttachmentAnswer)persistedModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return attachmentAnswerPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of attachment answers
	 */
	@Override
	public List<AttachmentAnswer> getAttachmentAnswers(int start, int end) {
		return attachmentAnswerPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	@Override
	public int getAttachmentAnswersCount() {
		return attachmentAnswerPersistence.countAll();
	}

	/**
	 * Updates the attachment answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AttachmentAnswer updateAttachmentAnswer(
		AttachmentAnswer attachmentAnswer) {

		return attachmentAnswerPersistence.update(attachmentAnswer);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AttachmentAnswerLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		attachmentAnswerLocalService = (AttachmentAnswerLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AttachmentAnswerLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AttachmentAnswer.class;
	}

	protected String getModelClassName() {
		return AttachmentAnswer.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = attachmentAnswerPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected AnswerPersistence answerPersistence;

	protected AttachmentAnswerLocalService attachmentAnswerLocalService;

	@Reference
	protected AttachmentAnswerPersistence attachmentAnswerPersistence;

	@Reference
	protected AttachmentQuestionPersistence attachmentQuestionPersistence;

	@Reference
	protected CategoryPersistence categoryPersistence;

	@Reference
	protected GroupUserPersistence groupUserPersistence;

	@Reference
	protected GroupUserCategoryPersistence groupUserCategoryPersistence;

	@Reference
	protected GroupUserPermissionPersistence groupUserPermissionPersistence;

	@Reference
	protected GroupUserUserPersistence groupUserUserPersistence;

	@Reference
	protected QuestionPersistence questionPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}