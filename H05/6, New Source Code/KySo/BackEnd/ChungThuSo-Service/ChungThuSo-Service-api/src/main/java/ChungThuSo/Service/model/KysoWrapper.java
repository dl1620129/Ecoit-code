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

package ChungThuSo.Service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Kyso}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Kyso
 * @generated
 */
@ProviderType
public class KysoWrapper
	extends BaseModelWrapper<Kyso> implements Kyso, ModelWrapper<Kyso> {

	public KysoWrapper(Kyso kyso) {
		super(kyso);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("kysoId", getKysoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("screenName", getScreenName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rawData", getRawData());
		attributes.put("serialNumber", getSerialNumber());
		attributes.put("details", getDetails());
		attributes.put("organization", getOrganization());
		attributes.put("userName", getUserName());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long kysoId = (Long)attributes.get("kysoId");

		if (kysoId != null) {
			setKysoId(kysoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String rawData = (String)attributes.get("rawData");

		if (rawData != null) {
			setRawData(rawData);
		}

		String serialNumber = (String)attributes.get("serialNumber");

		if (serialNumber != null) {
			setSerialNumber(serialNumber);
		}

		String details = (String)attributes.get("details");

		if (details != null) {
			setDetails(details);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}
	}

	/**
	 * Returns the company ID of this kyso.
	 *
	 * @return the company ID of this kyso
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this kyso.
	 *
	 * @return the create date of this kyso
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create user ID of this kyso.
	 *
	 * @return the create user ID of this kyso
	 */
	@Override
	public long getCreateUserId() {
		return model.getCreateUserId();
	}

	/**
	 * Returns the create user uuid of this kyso.
	 *
	 * @return the create user uuid of this kyso
	 */
	@Override
	public String getCreateUserUuid() {
		return model.getCreateUserUuid();
	}

	/**
	 * Returns the details of this kyso.
	 *
	 * @return the details of this kyso
	 */
	@Override
	public String getDetails() {
		return model.getDetails();
	}

	/**
	 * Returns the from date of this kyso.
	 *
	 * @return the from date of this kyso
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this kyso.
	 *
	 * @return the group ID of this kyso
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the kyso ID of this kyso.
	 *
	 * @return the kyso ID of this kyso
	 */
	@Override
	public long getKysoId() {
		return model.getKysoId();
	}

	/**
	 * Returns the modified date of this kyso.
	 *
	 * @return the modified date of this kyso
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization of this kyso.
	 *
	 * @return the organization of this kyso
	 */
	@Override
	public String getOrganization() {
		return model.getOrganization();
	}

	/**
	 * Returns the primary key of this kyso.
	 *
	 * @return the primary key of this kyso
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the raw data of this kyso.
	 *
	 * @return the raw data of this kyso
	 */
	@Override
	public String getRawData() {
		return model.getRawData();
	}

	/**
	 * Returns the screen name of this kyso.
	 *
	 * @return the screen name of this kyso
	 */
	@Override
	public String getScreenName() {
		return model.getScreenName();
	}

	/**
	 * Returns the serial number of this kyso.
	 *
	 * @return the serial number of this kyso
	 */
	@Override
	public String getSerialNumber() {
		return model.getSerialNumber();
	}

	/**
	 * Returns the to date of this kyso.
	 *
	 * @return the to date of this kyso
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this kyso.
	 *
	 * @return the user ID of this kyso
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this kyso.
	 *
	 * @return the user name of this kyso
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this kyso.
	 *
	 * @return the user uuid of this kyso
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this kyso.
	 *
	 * @return the uuid of this kyso
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this kyso.
	 *
	 * @param companyId the company ID of this kyso
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this kyso.
	 *
	 * @param createDate the create date of this kyso
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create user ID of this kyso.
	 *
	 * @param createUserId the create user ID of this kyso
	 */
	@Override
	public void setCreateUserId(long createUserId) {
		model.setCreateUserId(createUserId);
	}

	/**
	 * Sets the create user uuid of this kyso.
	 *
	 * @param createUserUuid the create user uuid of this kyso
	 */
	@Override
	public void setCreateUserUuid(String createUserUuid) {
		model.setCreateUserUuid(createUserUuid);
	}

	/**
	 * Sets the details of this kyso.
	 *
	 * @param details the details of this kyso
	 */
	@Override
	public void setDetails(String details) {
		model.setDetails(details);
	}

	/**
	 * Sets the from date of this kyso.
	 *
	 * @param fromDate the from date of this kyso
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this kyso.
	 *
	 * @param groupId the group ID of this kyso
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the kyso ID of this kyso.
	 *
	 * @param kysoId the kyso ID of this kyso
	 */
	@Override
	public void setKysoId(long kysoId) {
		model.setKysoId(kysoId);
	}

	/**
	 * Sets the modified date of this kyso.
	 *
	 * @param modifiedDate the modified date of this kyso
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization of this kyso.
	 *
	 * @param organization the organization of this kyso
	 */
	@Override
	public void setOrganization(String organization) {
		model.setOrganization(organization);
	}

	/**
	 * Sets the primary key of this kyso.
	 *
	 * @param primaryKey the primary key of this kyso
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the raw data of this kyso.
	 *
	 * @param rawData the raw data of this kyso
	 */
	@Override
	public void setRawData(String rawData) {
		model.setRawData(rawData);
	}

	/**
	 * Sets the screen name of this kyso.
	 *
	 * @param screenName the screen name of this kyso
	 */
	@Override
	public void setScreenName(String screenName) {
		model.setScreenName(screenName);
	}

	/**
	 * Sets the serial number of this kyso.
	 *
	 * @param serialNumber the serial number of this kyso
	 */
	@Override
	public void setSerialNumber(String serialNumber) {
		model.setSerialNumber(serialNumber);
	}

	/**
	 * Sets the to date of this kyso.
	 *
	 * @param toDate the to date of this kyso
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this kyso.
	 *
	 * @param userId the user ID of this kyso
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this kyso.
	 *
	 * @param userName the user name of this kyso
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this kyso.
	 *
	 * @param userUuid the user uuid of this kyso
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this kyso.
	 *
	 * @param uuid the uuid of this kyso
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected KysoWrapper wrap(Kyso kyso) {
		return new KysoWrapper(kyso);
	}

}