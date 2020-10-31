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

import com.ecoit.elegaldocument.model.LegalFoRel;
import com.ecoit.elegaldocument.model.LegalFoRelModel;
import com.ecoit.elegaldocument.model.LegalFoRelSoap;
import com.ecoit.elegaldocument.service.persistence.LegalFoRelPK;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LegalFoRel service. Represents a row in the &quot;ecoit_doc_LegalFoRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>LegalFoRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LegalFoRelImpl}.
 * </p>
 *
 * @author Liverpool
 * @see LegalFoRelImpl
 * @generated
 */
@JSON(strict = true)
public class LegalFoRelModelImpl
	extends BaseModelImpl<LegalFoRel> implements LegalFoRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legal fo rel model instance should use the <code>LegalFoRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "ecoit_doc_LegalFoRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"fieldId", Types.BIGINT}, {"organizationId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("fieldId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ecoit_doc_LegalFoRel (fieldId LONG not null,organizationId LONG not null,primary key (fieldId, organizationId))";

	public static final String TABLE_SQL_DROP =
		"drop table ecoit_doc_LegalFoRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY legalFoRel.id.fieldId DESC, legalFoRel.id.organizationId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ecoit_doc_LegalFoRel.fieldId DESC, ecoit_doc_LegalFoRel.organizationId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long FIELDID_COLUMN_BITMASK = 1L;

	public static final long ORGANIZATIONID_COLUMN_BITMASK = 2L;

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
	public static LegalFoRel toModel(LegalFoRelSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LegalFoRel model = new LegalFoRelImpl();

		model.setFieldId(soapModel.getFieldId());
		model.setOrganizationId(soapModel.getOrganizationId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LegalFoRel> toModels(LegalFoRelSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LegalFoRel> models = new ArrayList<LegalFoRel>(soapModels.length);

		for (LegalFoRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public LegalFoRelModelImpl() {
	}

	@Override
	public LegalFoRelPK getPrimaryKey() {
		return new LegalFoRelPK(_fieldId, _organizationId);
	}

	@Override
	public void setPrimaryKey(LegalFoRelPK primaryKey) {
		setFieldId(primaryKey.fieldId);
		setOrganizationId(primaryKey.organizationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new LegalFoRelPK(_fieldId, _organizationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((LegalFoRelPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return LegalFoRel.class;
	}

	@Override
	public String getModelClassName() {
		return LegalFoRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LegalFoRel, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LegalFoRel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LegalFoRel, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((LegalFoRel)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LegalFoRel, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LegalFoRel, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LegalFoRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LegalFoRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LegalFoRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LegalFoRel>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LegalFoRel.class.getClassLoader(), LegalFoRel.class,
			ModelWrapper.class);

		try {
			Constructor<LegalFoRel> constructor =
				(Constructor<LegalFoRel>)proxyClass.getConstructor(
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

	private static final Map<String, Function<LegalFoRel, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LegalFoRel, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LegalFoRel, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LegalFoRel, Object>>();
		Map<String, BiConsumer<LegalFoRel, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LegalFoRel, ?>>();

		attributeGetterFunctions.put("fieldId", LegalFoRel::getFieldId);
		attributeSetterBiConsumers.put(
			"fieldId", (BiConsumer<LegalFoRel, Long>)LegalFoRel::setFieldId);
		attributeGetterFunctions.put(
			"organizationId", LegalFoRel::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<LegalFoRel, Long>)LegalFoRel::setOrganizationId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getFieldId() {
		return _fieldId;
	}

	@Override
	public void setFieldId(long fieldId) {
		_columnBitmask = -1L;

		if (!_setOriginalFieldId) {
			_setOriginalFieldId = true;

			_originalFieldId = _fieldId;
		}

		_fieldId = fieldId;
	}

	public long getOriginalFieldId() {
		return _originalFieldId;
	}

	@JSON
	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_columnBitmask = -1L;

		if (!_setOriginalOrganizationId) {
			_setOriginalOrganizationId = true;

			_originalOrganizationId = _organizationId;
		}

		_organizationId = organizationId;
	}

	public long getOriginalOrganizationId() {
		return _originalOrganizationId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LegalFoRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LegalFoRel>
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
		LegalFoRelImpl legalFoRelImpl = new LegalFoRelImpl();

		legalFoRelImpl.setFieldId(getFieldId());
		legalFoRelImpl.setOrganizationId(getOrganizationId());

		legalFoRelImpl.resetOriginalValues();

		return legalFoRelImpl;
	}

	@Override
	public int compareTo(LegalFoRel legalFoRel) {
		int value = 0;

		if (getFieldId() < legalFoRel.getFieldId()) {
			value = -1;
		}
		else if (getFieldId() > legalFoRel.getFieldId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getOrganizationId() < legalFoRel.getOrganizationId()) {
			value = -1;
		}
		else if (getOrganizationId() > legalFoRel.getOrganizationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof LegalFoRel)) {
			return false;
		}

		LegalFoRel legalFoRel = (LegalFoRel)obj;

		LegalFoRelPK primaryKey = legalFoRel.getPrimaryKey();

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
		LegalFoRelModelImpl legalFoRelModelImpl = this;

		legalFoRelModelImpl._originalFieldId = legalFoRelModelImpl._fieldId;

		legalFoRelModelImpl._setOriginalFieldId = false;

		legalFoRelModelImpl._originalOrganizationId =
			legalFoRelModelImpl._organizationId;

		legalFoRelModelImpl._setOriginalOrganizationId = false;

		legalFoRelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LegalFoRel> toCacheModel() {
		LegalFoRelCacheModel legalFoRelCacheModel = new LegalFoRelCacheModel();

		legalFoRelCacheModel.legalFoRelPK = getPrimaryKey();

		legalFoRelCacheModel.fieldId = getFieldId();

		legalFoRelCacheModel.organizationId = getOrganizationId();

		return legalFoRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LegalFoRel, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LegalFoRel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LegalFoRel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((LegalFoRel)this));
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
		Map<String, Function<LegalFoRel, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LegalFoRel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LegalFoRel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((LegalFoRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LegalFoRel>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _fieldId;
	private long _originalFieldId;
	private boolean _setOriginalFieldId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private long _columnBitmask;
	private LegalFoRel _escapedModel;

}