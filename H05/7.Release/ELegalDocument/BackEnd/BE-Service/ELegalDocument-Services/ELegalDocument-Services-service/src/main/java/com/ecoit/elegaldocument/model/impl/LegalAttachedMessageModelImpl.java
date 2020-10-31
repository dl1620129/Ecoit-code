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

package com.ecoit.elegaldocument.model.impl;

import com.ecoit.elegaldocument.model.LegalAttachedMessage;
import com.ecoit.elegaldocument.model.LegalAttachedMessageModel;
import com.ecoit.elegaldocument.model.LegalAttachedMessageSoap;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
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

/**
 * The base model implementation for the LegalAttachedMessage service. Represents a row in the &quot;ecoit_doc_LegalAttachedMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>LegalAttachedMessageModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LegalAttachedMessageImpl}.
 * </p>
 *
 * @author Liverpool
 * @see LegalAttachedMessageImpl
 * @generated
 */
@JSON(strict = true)
public class LegalAttachedMessageModelImpl
	extends BaseModelImpl<LegalAttachedMessage>
	implements LegalAttachedMessageModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legal attached message model instance should use the <code>LegalAttachedMessage</code> interface instead.
	 */
	public static final String TABLE_NAME = "ecoit_doc_LegalAttachedMessage";

	public static final Object[][] TABLE_COLUMNS = {
		{"messageId", Types.VARCHAR}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"createdDate", Types.TIMESTAMP},
		{"createdByUser", Types.VARCHAR}, {"articleId", Types.VARCHAR},
		{"content", Types.VARCHAR}, {"readMessage", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("messageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdByUser", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("articleId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("readMessage", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ecoit_doc_LegalAttachedMessage (messageId VARCHAR(75) not null primary key,groupId LONG,companyId LONG,createdDate DATE null,createdByUser VARCHAR(75) null,articleId VARCHAR(75) null,content VARCHAR(75) null,readMessage BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table ecoit_doc_LegalAttachedMessage";

	public static final String ORDER_BY_JPQL =
		" ORDER BY legalAttachedMessage.createdDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ecoit_doc_LegalAttachedMessage.createdDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ARTICLEID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long READMESSAGE_COLUMN_BITMASK = 4L;

	public static final long CREATEDDATE_COLUMN_BITMASK = 8L;

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
	public static LegalAttachedMessage toModel(
		LegalAttachedMessageSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		LegalAttachedMessage model = new LegalAttachedMessageImpl();

		model.setMessageId(soapModel.getMessageId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setCreatedByUser(soapModel.getCreatedByUser());
		model.setArticleId(soapModel.getArticleId());
		model.setContent(soapModel.getContent());
		model.setReadMessage(soapModel.isReadMessage());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LegalAttachedMessage> toModels(
		LegalAttachedMessageSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<LegalAttachedMessage> models = new ArrayList<LegalAttachedMessage>(
			soapModels.length);

		for (LegalAttachedMessageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public LegalAttachedMessageModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return LegalAttachedMessage.class;
	}

	@Override
	public String getModelClassName() {
		return LegalAttachedMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LegalAttachedMessage, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LegalAttachedMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LegalAttachedMessage, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LegalAttachedMessage)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LegalAttachedMessage, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LegalAttachedMessage, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LegalAttachedMessage)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LegalAttachedMessage, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LegalAttachedMessage, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LegalAttachedMessage>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LegalAttachedMessage.class.getClassLoader(),
			LegalAttachedMessage.class, ModelWrapper.class);

		try {
			Constructor<LegalAttachedMessage> constructor =
				(Constructor<LegalAttachedMessage>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<LegalAttachedMessage, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LegalAttachedMessage, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LegalAttachedMessage, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<LegalAttachedMessage, Object>>();
		Map<String, BiConsumer<LegalAttachedMessage, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<LegalAttachedMessage, ?>>();

		attributeGetterFunctions.put(
			"messageId", LegalAttachedMessage::getMessageId);
		attributeSetterBiConsumers.put(
			"messageId",
			(BiConsumer<LegalAttachedMessage, String>)
				LegalAttachedMessage::setMessageId);
		attributeGetterFunctions.put(
			"groupId", LegalAttachedMessage::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<LegalAttachedMessage, Long>)
				LegalAttachedMessage::setGroupId);
		attributeGetterFunctions.put(
			"companyId", LegalAttachedMessage::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<LegalAttachedMessage, Long>)
				LegalAttachedMessage::setCompanyId);
		attributeGetterFunctions.put(
			"createdDate", LegalAttachedMessage::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<LegalAttachedMessage, Date>)
				LegalAttachedMessage::setCreatedDate);
		attributeGetterFunctions.put(
			"createdByUser", LegalAttachedMessage::getCreatedByUser);
		attributeSetterBiConsumers.put(
			"createdByUser",
			(BiConsumer<LegalAttachedMessage, String>)
				LegalAttachedMessage::setCreatedByUser);
		attributeGetterFunctions.put(
			"articleId", LegalAttachedMessage::getArticleId);
		attributeSetterBiConsumers.put(
			"articleId",
			(BiConsumer<LegalAttachedMessage, String>)
				LegalAttachedMessage::setArticleId);
		attributeGetterFunctions.put(
			"content", LegalAttachedMessage::getContent);
		attributeSetterBiConsumers.put(
			"content",
			(BiConsumer<LegalAttachedMessage, String>)
				LegalAttachedMessage::setContent);
		attributeGetterFunctions.put(
			"readMessage", LegalAttachedMessage::getReadMessage);
		attributeSetterBiConsumers.put(
			"readMessage",
			(BiConsumer<LegalAttachedMessage, Boolean>)
				LegalAttachedMessage::setReadMessage);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getMessageId() {
		if (_messageId == null) {
			return "";
		}
		else {
			return _messageId;
		}
	}

	@Override
	public void setMessageId(String messageId) {
		_messageId = messageId;
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
		_companyId = companyId;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_columnBitmask = -1L;

		_createdDate = createdDate;
	}

	@JSON
	@Override
	public String getCreatedByUser() {
		if (_createdByUser == null) {
			return "";
		}
		else {
			return _createdByUser;
		}
	}

	@Override
	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	@JSON
	@Override
	public String getArticleId() {
		if (_articleId == null) {
			return "";
		}
		else {
			return _articleId;
		}
	}

	@Override
	public void setArticleId(String articleId) {
		_columnBitmask |= ARTICLEID_COLUMN_BITMASK;

		if (_originalArticleId == null) {
			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public String getOriginalArticleId() {
		return GetterUtil.getString(_originalArticleId);
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@JSON
	@Override
	public boolean getReadMessage() {
		return _readMessage;
	}

	@JSON
	@Override
	public boolean isReadMessage() {
		return _readMessage;
	}

	@Override
	public void setReadMessage(boolean readMessage) {
		_columnBitmask |= READMESSAGE_COLUMN_BITMASK;

		if (!_setOriginalReadMessage) {
			_setOriginalReadMessage = true;

			_originalReadMessage = _readMessage;
		}

		_readMessage = readMessage;
	}

	public boolean getOriginalReadMessage() {
		return _originalReadMessage;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LegalAttachedMessage toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LegalAttachedMessage>
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
		LegalAttachedMessageImpl legalAttachedMessageImpl =
			new LegalAttachedMessageImpl();

		legalAttachedMessageImpl.setMessageId(getMessageId());
		legalAttachedMessageImpl.setGroupId(getGroupId());
		legalAttachedMessageImpl.setCompanyId(getCompanyId());
		legalAttachedMessageImpl.setCreatedDate(getCreatedDate());
		legalAttachedMessageImpl.setCreatedByUser(getCreatedByUser());
		legalAttachedMessageImpl.setArticleId(getArticleId());
		legalAttachedMessageImpl.setContent(getContent());
		legalAttachedMessageImpl.setReadMessage(isReadMessage());

		legalAttachedMessageImpl.resetOriginalValues();

		return legalAttachedMessageImpl;
	}

	@Override
	public int compareTo(LegalAttachedMessage legalAttachedMessage) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreatedDate(), legalAttachedMessage.getCreatedDate());

		value = value * -1;

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

		if (!(obj instanceof LegalAttachedMessage)) {
			return false;
		}

		LegalAttachedMessage legalAttachedMessage = (LegalAttachedMessage)obj;

		String primaryKey = legalAttachedMessage.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		LegalAttachedMessageModelImpl legalAttachedMessageModelImpl = this;

		legalAttachedMessageModelImpl._originalGroupId =
			legalAttachedMessageModelImpl._groupId;

		legalAttachedMessageModelImpl._setOriginalGroupId = false;

		legalAttachedMessageModelImpl._originalArticleId =
			legalAttachedMessageModelImpl._articleId;

		legalAttachedMessageModelImpl._originalReadMessage =
			legalAttachedMessageModelImpl._readMessage;

		legalAttachedMessageModelImpl._setOriginalReadMessage = false;

		legalAttachedMessageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LegalAttachedMessage> toCacheModel() {
		LegalAttachedMessageCacheModel legalAttachedMessageCacheModel =
			new LegalAttachedMessageCacheModel();

		legalAttachedMessageCacheModel.messageId = getMessageId();

		String messageId = legalAttachedMessageCacheModel.messageId;

		if ((messageId != null) && (messageId.length() == 0)) {
			legalAttachedMessageCacheModel.messageId = null;
		}

		legalAttachedMessageCacheModel.groupId = getGroupId();

		legalAttachedMessageCacheModel.companyId = getCompanyId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			legalAttachedMessageCacheModel.createdDate = createdDate.getTime();
		}
		else {
			legalAttachedMessageCacheModel.createdDate = Long.MIN_VALUE;
		}

		legalAttachedMessageCacheModel.createdByUser = getCreatedByUser();

		String createdByUser = legalAttachedMessageCacheModel.createdByUser;

		if ((createdByUser != null) && (createdByUser.length() == 0)) {
			legalAttachedMessageCacheModel.createdByUser = null;
		}

		legalAttachedMessageCacheModel.articleId = getArticleId();

		String articleId = legalAttachedMessageCacheModel.articleId;

		if ((articleId != null) && (articleId.length() == 0)) {
			legalAttachedMessageCacheModel.articleId = null;
		}

		legalAttachedMessageCacheModel.content = getContent();

		String content = legalAttachedMessageCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			legalAttachedMessageCacheModel.content = null;
		}

		legalAttachedMessageCacheModel.readMessage = isReadMessage();

		return legalAttachedMessageCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LegalAttachedMessage, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LegalAttachedMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LegalAttachedMessage, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((LegalAttachedMessage)this));
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
		Map<String, Function<LegalAttachedMessage, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LegalAttachedMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LegalAttachedMessage, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((LegalAttachedMessage)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LegalAttachedMessage>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _messageId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private String _articleId;
	private String _originalArticleId;
	private String _content;
	private boolean _readMessage;
	private boolean _originalReadMessage;
	private boolean _setOriginalReadMessage;
	private long _columnBitmask;
	private LegalAttachedMessage _escapedModel;

}