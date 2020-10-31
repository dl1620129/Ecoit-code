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

package User.Rank.Poisition.Service.service;

import User.Rank.Poisition.Service.model.UserPoisition_Dang;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for UserPoisition_Dang. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UserPoisition_DangLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPoisition_DangLocalServiceUtil} to access the user poisition_ dang local service. Add custom service methods to <code>User.Rank.Poisition.Service.service.impl.UserPoisition_DangLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the user poisition_ dang to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserPoisition_Dang addUserPoisition_Dang(
		UserPoisition_Dang userPoisition_Dang);

	/**
	 * Creates a new user poisition_ dang with the primary key. Does not add the user poisition_ dang to the database.
	 *
	 * @param userPoisitionDangId the primary key for the new user poisition_ dang
	 * @return the new user poisition_ dang
	 */
	@Transactional(enabled = false)
	public UserPoisition_Dang createUserPoisition_Dang(
		long userPoisitionDangId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the user poisition_ dang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 * @throws PortalException if a user poisition_ dang with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserPoisition_Dang deleteUserPoisition_Dang(long userPoisitionDangId)
		throws PortalException;

	/**
	 * Deletes the user poisition_ dang from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserPoisition_Dang deleteUserPoisition_Dang(
		UserPoisition_Dang userPoisition_Dang);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserPoisition_Dang fetchUserPoisition_Dang(long userPoisitionDangId);

	/**
	 * Returns the user poisition_ dang matching the UUID and group.
	 *
	 * @param uuid the user poisition_ dang's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserPoisition_Dang fetchUserPoisition_DangByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountAll(String name, long groupId) throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserPoisition_Dang> getListUserPoisition_Dang(
			long groupId, String name, int start, int limit)
		throws Exception;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the user poisition_ dang with the primary key.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang
	 * @throws PortalException if a user poisition_ dang with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserPoisition_Dang getUserPoisition_Dang(long userPoisitionDangId)
		throws PortalException;

	/**
	 * Returns the user poisition_ dang matching the UUID and group.
	 *
	 * @param uuid the user poisition_ dang's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition_ dang
	 * @throws PortalException if a matching user poisition_ dang could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserPoisition_Dang getUserPoisition_DangByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of user poisition_ dangs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserPoisition_Dang> getUserPoisition_Dangs(int start, int end);

	/**
	 * Returns all the user poisition_ dangs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisition_ dangs
	 * @param companyId the primary key of the company
	 * @return the matching user poisition_ dangs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserPoisition_Dang> getUserPoisition_DangsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of user poisition_ dangs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisition_ dangs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user poisition_ dangs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserPoisition_Dang> getUserPoisition_DangsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the number of user poisition_ dangs.
	 *
	 * @return the number of user poisition_ dangs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserPoisition_DangsCount();

	/**
	 * Updates the user poisition_ dang in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserPoisition_Dang updateUserPoisition_Dang(
		UserPoisition_Dang userPoisition_Dang);

}