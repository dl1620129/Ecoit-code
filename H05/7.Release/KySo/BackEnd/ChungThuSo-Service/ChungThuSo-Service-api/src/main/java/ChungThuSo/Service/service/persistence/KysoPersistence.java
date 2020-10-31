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

package ChungThuSo.Service.service.persistence;

import ChungThuSo.Service.exception.NoSuchKysoException;
import ChungThuSo.Service.model.Kyso;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the kyso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KysoUtil
 * @generated
 */
@ProviderType
public interface KysoPersistence extends BasePersistence<Kyso> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KysoUtil} to access the kyso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the kysos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kysos
	 */
	public java.util.List<Kyso> findByUuid(String uuid);

	/**
	 * Returns a range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of matching kysos
	 */
	public java.util.List<Kyso> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kysos
	 */
	@Deprecated
	public java.util.List<Kyso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Kyso> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kysos
	 */
	public java.util.List<Kyso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Kyso> orderByComparator);

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findByUuid_First(
			String uuid, OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException;

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchByUuid_First(
		String uuid, OrderByComparator<Kyso> orderByComparator);

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findByUuid_Last(
			String uuid, OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException;

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchByUuid_Last(
		String uuid, OrderByComparator<Kyso> orderByComparator);

	/**
	 * Returns the kysos before and after the current kyso in the ordered set where uuid = &#63;.
	 *
	 * @param kysoId the primary key of the current kyso
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public Kyso[] findByUuid_PrevAndNext(
			long kysoId, String uuid, OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException;

	/**
	 * Removes all the kysos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of kysos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kysos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findByUUID_G(String uuid, long groupId)
		throws NoSuchKysoException;

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	public Kyso fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the kyso where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kyso that was removed
	 */
	public Kyso removeByUUID_G(String uuid, long groupId)
		throws NoSuchKysoException;

	/**
	 * Returns the number of kysos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kysos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kysos
	 */
	public java.util.List<Kyso> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of matching kysos
	 */
	public java.util.List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kysos
	 */
	@Deprecated
	public java.util.List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Kyso> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kysos
	 */
	public java.util.List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Kyso> orderByComparator);

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException;

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<Kyso> orderByComparator);

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException;

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<Kyso> orderByComparator);

	/**
	 * Returns the kysos before and after the current kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param kysoId the primary key of the current kyso
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public Kyso[] findByUuid_C_PrevAndNext(
			long kysoId, String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException;

	/**
	 * Removes all the kysos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kysos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the kyso where screenName = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param screenName the screen name
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findBygetByScreenName(String screenName)
		throws NoSuchKysoException;

	/**
	 * Returns the kyso where screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBygetByScreenName(String)}
	 * @param screenName the screen name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	public Kyso fetchBygetByScreenName(
		String screenName, boolean useFinderCache);

	/**
	 * Returns the kyso where screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param screenName the screen name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchBygetByScreenName(String screenName);

	/**
	 * Removes the kyso where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 * @return the kyso that was removed
	 */
	public Kyso removeBygetByScreenName(String screenName)
		throws NoSuchKysoException;

	/**
	 * Returns the number of kysos where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching kysos
	 */
	public int countBygetByScreenName(String screenName);

	/**
	 * Returns the kyso where serialNumber = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param serialNumber the serial number
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public Kyso findBygetBySerialNumber(String serialNumber)
		throws NoSuchKysoException;

	/**
	 * Returns the kyso where serialNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBygetBySerialNumber(String)}
	 * @param serialNumber the serial number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	public Kyso fetchBygetBySerialNumber(
		String serialNumber, boolean useFinderCache);

	/**
	 * Returns the kyso where serialNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialNumber the serial number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public Kyso fetchBygetBySerialNumber(String serialNumber);

	/**
	 * Removes the kyso where serialNumber = &#63; from the database.
	 *
	 * @param serialNumber the serial number
	 * @return the kyso that was removed
	 */
	public Kyso removeBygetBySerialNumber(String serialNumber)
		throws NoSuchKysoException;

	/**
	 * Returns the number of kysos where serialNumber = &#63;.
	 *
	 * @param serialNumber the serial number
	 * @return the number of matching kysos
	 */
	public int countBygetBySerialNumber(String serialNumber);

	/**
	 * Caches the kyso in the entity cache if it is enabled.
	 *
	 * @param kyso the kyso
	 */
	public void cacheResult(Kyso kyso);

	/**
	 * Caches the kysos in the entity cache if it is enabled.
	 *
	 * @param kysos the kysos
	 */
	public void cacheResult(java.util.List<Kyso> kysos);

	/**
	 * Creates a new kyso with the primary key. Does not add the kyso to the database.
	 *
	 * @param kysoId the primary key for the new kyso
	 * @return the new kyso
	 */
	public Kyso create(long kysoId);

	/**
	 * Removes the kyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso that was removed
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public Kyso remove(long kysoId) throws NoSuchKysoException;

	public Kyso updateImpl(Kyso kyso);

	/**
	 * Returns the kyso with the primary key or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public Kyso findByPrimaryKey(long kysoId) throws NoSuchKysoException;

	/**
	 * Returns the kyso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso, or <code>null</code> if a kyso with the primary key could not be found
	 */
	public Kyso fetchByPrimaryKey(long kysoId);

	/**
	 * Returns all the kysos.
	 *
	 * @return the kysos
	 */
	public java.util.List<Kyso> findAll();

	/**
	 * Returns a range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of kysos
	 */
	public java.util.List<Kyso> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of kysos
	 */
	@Deprecated
	public java.util.List<Kyso> findAll(
		int start, int end, OrderByComparator<Kyso> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kysos
	 */
	public java.util.List<Kyso> findAll(
		int start, int end, OrderByComparator<Kyso> orderByComparator);

	/**
	 * Removes all the kysos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of kysos.
	 *
	 * @return the number of kysos
	 */
	public int countAll();

}