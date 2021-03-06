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

package User.Rank.Poisition.Service.model.impl;

import User.Rank.Poisition.Service.model.UserPoisition;
import User.Rank.Poisition.Service.model.UserPoisitionModel;
import User.Rank.Poisition.Service.model.UserPoisitionSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the UserPoisition service. Represents a row in the &quot;portal_user_UserPoisition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>UserPoisitionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserPoisitionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisitionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class UserPoisitionModelImpl
	extends BaseModelImpl<UserPoisition> implements UserPoisitionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user poisition model instance should use the <code>UserPoisition</code> interface instead.
	 */
	public static final String TABLE_NAME = "portal_user_UserPoisition";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"userPoisitionId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userPoisitionName", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"totalMember", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userPoisitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userPoisitionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("totalMember", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table portal_user_UserPoisition (uuid_ VARCHAR(75) null,userPoisitionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userPoisitionName VARCHAR(75) null,description VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,totalMember LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table portal_user_UserPoisition";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userPoisition.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY portal_user_UserPoisition.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserPoisition toModel(UserPoisitionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserPoisition model = new UserPoisitionImpl();

		model.setUuid(soapModel.getUuid());
		model.setUserPoisitionId(soapModel.getUserPoisitionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserPoisitionName(soapModel.getUserPoisitionName());
		model.setDescription(soapModel.getDescription());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTotalMember(soapModel.getTotalMember());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserPoisition> toModels(UserPoisitionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserPoisition> models = new ArrayList<UserPoisition>(
			soapModels.length);

		for (UserPoisitionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public UserPoisitionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userPoisitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserPoisitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userPoisitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserPoisition.class;
	}

	@Override
	public String getModelClassName() {
		return UserPoisition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserPoisition, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserPoisition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserPoisition, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((UserPoisition)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserPoisition, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserPoisition, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserPoisition)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserPoisition, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserPoisition, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UserPoisition>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UserPoisition.class.getClassLoader(), UserPoisition.class,
			ModelWrapper.class);

		try {
			Constructor<UserPoisition> constructor =
				(Constructor<UserPoisition>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<UserPoisition, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserPoisition, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserPoisition, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<UserPoisition, Object>>();
		Map<String, BiConsumer<UserPoisition, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UserPoisition, ?>>();

		attributeGetterFunctions.put("uuid", UserPoisition::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<UserPoisition, String>)UserPoisition::setUuid);
		attributeGetterFunctions.put(
			"userPoisitionId", UserPoisition::getUserPoisitionId);
		attributeSetterBiConsumers.put(
			"userPoisitionId",
			(BiConsumer<UserPoisition, Long>)UserPoisition::setUserPoisitionId);
		attributeGetterFunctions.put("groupId", UserPoisition::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<UserPoisition, Long>)UserPoisition::setGroupId);
		attributeGetterFunctions.put("companyId", UserPoisition::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<UserPoisition, Long>)UserPoisition::setCompanyId);
		attributeGetterFunctions.put("userId", UserPoisition::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<UserPoisition, Long>)UserPoisition::setUserId);
		attributeGetterFunctions.put(
			"userPoisitionName", UserPoisition::getUserPoisitionName);
		attributeSetterBiConsumers.put(
			"userPoisitionName",
			(BiConsumer<UserPoisition, String>)
				UserPoisition::setUserPoisitionName);
		attributeGetterFunctions.put(
			"description", UserPoisition::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<UserPoisition, String>)UserPoisition::setDescription);
		attributeGetterFunctions.put(
			"createDate", UserPoisition::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<UserPoisition, Date>)UserPoisition::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", UserPoisition::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<UserPoisition, Date>)UserPoisition::setModifiedDate);
		attributeGetterFunctions.put(
			"totalMember", UserPoisition::getTotalMember);
		attributeSetterBiConsumers.put(
			"totalMember",
			(BiConsumer<UserPoisition, Long>)UserPoisition::setTotalMember);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getUserPoisitionId() {
		return _userPoisitionId;
	}

	@Override
	public void setUserPoisitionId(long userPoisitionId) {
		_userPoisitionId = userPoisitionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserPoisitionName() {
		if (_userPoisitionName == null) {
			return "";
		}
		else {
			return _userPoisitionName;
		}
	}

	@Override
	public void setUserPoisitionName(String userPoisitionName) {
		_userPoisitionName = userPoisitionName;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getTotalMember() {
		return _totalMember;
	}

	@Override
	public void setTotalMember(long totalMember) {
		_totalMember = totalMember;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(UserPoisition.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), UserPoisition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserPoisition toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserPoisition>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserPoisitionImpl userPoisitionImpl = new UserPoisitionImpl();

		userPoisitionImpl.setUuid(getUuid());
		userPoisitionImpl.setUserPoisitionId(getUserPoisitionId());
		userPoisitionImpl.setGroupId(getGroupId());
		userPoisitionImpl.setCompanyId(getCompanyId());
		userPoisitionImpl.setUserId(getUserId());
		userPoisitionImpl.setUserPoisitionName(getUserPoisitionName());
		userPoisitionImpl.setDescription(getDescription());
		userPoisitionImpl.setCreateDate(getCreateDate());
		userPoisitionImpl.setModifiedDate(getModifiedDate());
		userPoisitionImpl.setTotalMember(getTotalMember());

		userPoisitionImpl.resetOriginalValues();

		return userPoisitionImpl;
	}

	@Override
	public int compareTo(UserPoisition userPoisition) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), userPoisition.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPoisition)) {
			return false;
		}

		UserPoisition userPoisition = (UserPoisition)obj;

		long primaryKey = userPoisition.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		UserPoisitionModelImpl userPoisitionModelImpl = this;

		userPoisitionModelImpl._originalUuid = userPoisitionModelImpl._uuid;

		userPoisitionModelImpl._originalGroupId =
			userPoisitionModelImpl._groupId;

		userPoisitionModelImpl._setOriginalGroupId = false;

		userPoisitionModelImpl._originalCompanyId =
			userPoisitionModelImpl._companyId;

		userPoisitionModelImpl._setOriginalCompanyId = false;

		userPoisitionModelImpl._setModifiedDate = false;

		userPoisitionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserPoisition> toCacheModel() {
		UserPoisitionCacheModel userPoisitionCacheModel =
			new UserPoisitionCacheModel();

		userPoisitionCacheModel.uuid = getUuid();

		String uuid = userPoisitionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userPoisitionCacheModel.uuid = null;
		}

		userPoisitionCacheModel.userPoisitionId = getUserPoisitionId();

		userPoisitionCacheModel.groupId = getGroupId();

		userPoisitionCacheModel.companyId = getCompanyId();

		userPoisitionCacheModel.userId = getUserId();

		userPoisitionCacheModel.userPoisitionName = getUserPoisitionName();

		String userPoisitionName = userPoisitionCacheModel.userPoisitionName;

		if ((userPoisitionName != null) && (userPoisitionName.length() == 0)) {
			userPoisitionCacheModel.userPoisitionName = null;
		}

		userPoisitionCacheModel.description = getDescription();

		String description = userPoisitionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			userPoisitionCacheModel.description = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			userPoisitionCacheModel.createDate = createDate.getTime();
		}
		else {
			userPoisitionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userPoisitionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userPoisitionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userPoisitionCacheModel.totalMember = getTotalMember();

		return userPoisitionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserPoisition, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserPoisition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserPoisition, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((UserPoisition)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<UserPoisition, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UserPoisition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserPoisition, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((UserPoisition)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UserPoisition>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _userPoisitionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userPoisitionName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _totalMember;
	private long _columnBitmask;
	private UserPoisition _escapedModel;

}