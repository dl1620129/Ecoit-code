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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link ChungThuSo.Service.service.http.KysoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class KysoSoap implements Serializable {

	public static KysoSoap toSoapModel(Kyso model) {
		KysoSoap soapModel = new KysoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setKysoId(model.getKysoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRawData(model.getRawData());
		soapModel.setSerialNumber(model.getSerialNumber());
		soapModel.setDetails(model.getDetails());
		soapModel.setOrganization(model.getOrganization());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());

		return soapModel;
	}

	public static KysoSoap[] toSoapModels(Kyso[] models) {
		KysoSoap[] soapModels = new KysoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KysoSoap[][] toSoapModels(Kyso[][] models) {
		KysoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KysoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KysoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KysoSoap[] toSoapModels(List<Kyso> models) {
		List<KysoSoap> soapModels = new ArrayList<KysoSoap>(models.size());

		for (Kyso model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KysoSoap[soapModels.size()]);
	}

	public KysoSoap() {
	}

	public long getPrimaryKey() {
		return _kysoId;
	}

	public void setPrimaryKey(long pk) {
		setKysoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getKysoId() {
		return _kysoId;
	}

	public void setKysoId(long kysoId) {
		_kysoId = kysoId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getRawData() {
		return _rawData;
	}

	public void setRawData(String rawData) {
		_rawData = rawData;
	}

	public String getSerialNumber() {
		return _serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		_serialNumber = serialNumber;
	}

	public String getDetails() {
		return _details;
	}

	public void setDetails(String details) {
		_details = details;
	}

	public String getOrganization() {
		return _organization;
	}

	public void setOrganization(String organization) {
		_organization = organization;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	private String _uuid;
	private long _kysoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _screenName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _rawData;
	private String _serialNumber;
	private String _details;
	private String _organization;
	private String _userName;
	private long _createUserId;
	private Date _fromDate;
	private Date _toDate;

}