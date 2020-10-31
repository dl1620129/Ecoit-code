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

package organizationalStructure.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link organization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see organization
 * @generated
 */
public class organizationWrapper
	extends BaseModelWrapper<organization>
	implements ModelWrapper<organization>, organization {

	public organizationWrapper(organization organization) {
		super(organization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("organizationCode", getOrganizationCode());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("leader", getLeader());
		attributes.put("member", getMember());
		attributes.put("address", getAddress());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("position", getPosition());
		attributes.put("parentId", getParentId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createUser", getCreateUser());
		attributes.put("modifiedUser", getModifiedUser());
		attributes.put("status", getStatus());
		attributes.put("thuTu", getThuTu());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String organizationCode = (String)attributes.get("organizationCode");

		if (organizationCode != null) {
			setOrganizationCode(organizationCode);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String leader = (String)attributes.get("leader");

		if (leader != null) {
			setLeader(leader);
		}

		Long member = (Long)attributes.get("member");

		if (member != null) {
			setMember(member);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createUser = (Long)attributes.get("createUser");

		if (createUser != null) {
			setCreateUser(createUser);
		}

		Long modifiedUser = (Long)attributes.get("modifiedUser");

		if (modifiedUser != null) {
			setModifiedUser(modifiedUser);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer thuTu = (Integer)attributes.get("thuTu");

		if (thuTu != null) {
			setThuTu(thuTu);
		}
	}

	/**
	 * Returns the address of this organization.
	 *
	 * @return the address of this organization
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the create date of this organization.
	 *
	 * @return the create date of this organization
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create user of this organization.
	 *
	 * @return the create user of this organization
	 */
	@Override
	public long getCreateUser() {
		return model.getCreateUser();
	}

	/**
	 * Returns the description of this organization.
	 *
	 * @return the description of this organization
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this organization.
	 *
	 * @return the group ID of this organization
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leader of this organization.
	 *
	 * @return the leader of this organization
	 */
	@Override
	public String getLeader() {
		return model.getLeader();
	}

	/**
	 * Returns the member of this organization.
	 *
	 * @return the member of this organization
	 */
	@Override
	public long getMember() {
		return model.getMember();
	}

	/**
	 * Returns the modified date of this organization.
	 *
	 * @return the modified date of this organization
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified user of this organization.
	 *
	 * @return the modified user of this organization
	 */
	@Override
	public long getModifiedUser() {
		return model.getModifiedUser();
	}

	/**
	 * Returns the name of this organization.
	 *
	 * @return the name of this organization
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the organization code of this organization.
	 *
	 * @return the organization code of this organization
	 */
	@Override
	public String getOrganizationCode() {
		return model.getOrganizationCode();
	}

	/**
	 * Returns the organization ID of this organization.
	 *
	 * @return the organization ID of this organization
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the parent ID of this organization.
	 *
	 * @return the parent ID of this organization
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the phone number of this organization.
	 *
	 * @return the phone number of this organization
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the position of this organization.
	 *
	 * @return the position of this organization
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this organization.
	 *
	 * @return the primary key of this organization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this organization.
	 *
	 * @return the status of this organization
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the thu tu of this organization.
	 *
	 * @return the thu tu of this organization
	 */
	@Override
	public int getThuTu() {
		return model.getThuTu();
	}

	/**
	 * Returns the uuid of this organization.
	 *
	 * @return the uuid of this organization
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
	 * Sets the address of this organization.
	 *
	 * @param address the address of this organization
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the create date of this organization.
	 *
	 * @param createDate the create date of this organization
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create user of this organization.
	 *
	 * @param createUser the create user of this organization
	 */
	@Override
	public void setCreateUser(long createUser) {
		model.setCreateUser(createUser);
	}

	/**
	 * Sets the description of this organization.
	 *
	 * @param description the description of this organization
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this organization.
	 *
	 * @param groupId the group ID of this organization
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leader of this organization.
	 *
	 * @param leader the leader of this organization
	 */
	@Override
	public void setLeader(String leader) {
		model.setLeader(leader);
	}

	/**
	 * Sets the member of this organization.
	 *
	 * @param member the member of this organization
	 */
	@Override
	public void setMember(long member) {
		model.setMember(member);
	}

	/**
	 * Sets the modified date of this organization.
	 *
	 * @param modifiedDate the modified date of this organization
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified user of this organization.
	 *
	 * @param modifiedUser the modified user of this organization
	 */
	@Override
	public void setModifiedUser(long modifiedUser) {
		model.setModifiedUser(modifiedUser);
	}

	/**
	 * Sets the name of this organization.
	 *
	 * @param name the name of this organization
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the organization code of this organization.
	 *
	 * @param organizationCode the organization code of this organization
	 */
	@Override
	public void setOrganizationCode(String organizationCode) {
		model.setOrganizationCode(organizationCode);
	}

	/**
	 * Sets the organization ID of this organization.
	 *
	 * @param organizationId the organization ID of this organization
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the parent ID of this organization.
	 *
	 * @param parentId the parent ID of this organization
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the phone number of this organization.
	 *
	 * @param phoneNumber the phone number of this organization
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the position of this organization.
	 *
	 * @param position the position of this organization
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this organization.
	 *
	 * @param primaryKey the primary key of this organization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this organization.
	 *
	 * @param status the status of this organization
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the thu tu of this organization.
	 *
	 * @param thuTu the thu tu of this organization
	 */
	@Override
	public void setThuTu(int thuTu) {
		model.setThuTu(thuTu);
	}

	/**
	 * Sets the uuid of this organization.
	 *
	 * @param uuid the uuid of this organization
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected organizationWrapper wrap(organization organization) {
		return new organizationWrapper(organization);
	}

}