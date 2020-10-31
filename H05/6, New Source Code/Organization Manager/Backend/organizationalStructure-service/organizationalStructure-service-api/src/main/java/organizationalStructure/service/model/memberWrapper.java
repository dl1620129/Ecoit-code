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
 * This class is a wrapper for {@link member}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see member
 * @generated
 */
public class memberWrapper
	extends BaseModelWrapper<member> implements member, ModelWrapper<member> {

	public memberWrapper(member member) {
		super(member);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("memberId", getMemberId());
		attributes.put("groupId", getGroupId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("fullName", getFullName());
		attributes.put("birthday", getBirthday());
		attributes.put("address", getAddress());
		attributes.put("sex", getSex());
		attributes.put("position", getPosition());
		attributes.put("createDate", getCreateDate());
		attributes.put("createUser", getCreateUser());
		attributes.put("modifiedUser", getModifiedUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("isLeader", getIsLeader());
		attributes.put("urlImage", getUrlImage());
		attributes.put("folderId", getFolderId());
		attributes.put("imageFileId", getImageFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Boolean sex = (Boolean)attributes.get("sex");

		if (sex != null) {
			setSex(sex);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createUser = (Long)attributes.get("createUser");

		if (createUser != null) {
			setCreateUser(createUser);
		}

		Long modifiedUser = (Long)attributes.get("modifiedUser");

		if (modifiedUser != null) {
			setModifiedUser(modifiedUser);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean isLeader = (Boolean)attributes.get("isLeader");

		if (isLeader != null) {
			setIsLeader(isLeader);
		}

		String urlImage = (String)attributes.get("urlImage");

		if (urlImage != null) {
			setUrlImage(urlImage);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		Long imageFileId = (Long)attributes.get("imageFileId");

		if (imageFileId != null) {
			setImageFileId(imageFileId);
		}
	}

	/**
	 * Returns the address of this member.
	 *
	 * @return the address of this member
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the birthday of this member.
	 *
	 * @return the birthday of this member
	 */
	@Override
	public Date getBirthday() {
		return model.getBirthday();
	}

	/**
	 * Returns the create date of this member.
	 *
	 * @return the create date of this member
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create user of this member.
	 *
	 * @return the create user of this member
	 */
	@Override
	public long getCreateUser() {
		return model.getCreateUser();
	}

	/**
	 * Returns the folder ID of this member.
	 *
	 * @return the folder ID of this member
	 */
	@Override
	public long getFolderId() {
		return model.getFolderId();
	}

	/**
	 * Returns the full name of this member.
	 *
	 * @return the full name of this member
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this member.
	 *
	 * @return the group ID of this member
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image file ID of this member.
	 *
	 * @return the image file ID of this member
	 */
	@Override
	public long getImageFileId() {
		return model.getImageFileId();
	}

	/**
	 * Returns the is leader of this member.
	 *
	 * @return the is leader of this member
	 */
	@Override
	public Boolean getIsLeader() {
		return model.getIsLeader();
	}

	/**
	 * Returns the member ID of this member.
	 *
	 * @return the member ID of this member
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the modified date of this member.
	 *
	 * @return the modified date of this member
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified user of this member.
	 *
	 * @return the modified user of this member
	 */
	@Override
	public long getModifiedUser() {
		return model.getModifiedUser();
	}

	/**
	 * Returns the organization ID of this member.
	 *
	 * @return the organization ID of this member
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the position of this member.
	 *
	 * @return the position of this member
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this member.
	 *
	 * @return the primary key of this member
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sex of this member.
	 *
	 * @return the sex of this member
	 */
	@Override
	public Boolean getSex() {
		return model.getSex();
	}

	/**
	 * Returns the url image of this member.
	 *
	 * @return the url image of this member
	 */
	@Override
	public String getUrlImage() {
		return model.getUrlImage();
	}

	/**
	 * Returns the uuid of this member.
	 *
	 * @return the uuid of this member
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
	 * Sets the address of this member.
	 *
	 * @param address the address of this member
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the birthday of this member.
	 *
	 * @param birthday the birthday of this member
	 */
	@Override
	public void setBirthday(Date birthday) {
		model.setBirthday(birthday);
	}

	/**
	 * Sets the create date of this member.
	 *
	 * @param createDate the create date of this member
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create user of this member.
	 *
	 * @param createUser the create user of this member
	 */
	@Override
	public void setCreateUser(long createUser) {
		model.setCreateUser(createUser);
	}

	/**
	 * Sets the folder ID of this member.
	 *
	 * @param folderId the folder ID of this member
	 */
	@Override
	public void setFolderId(long folderId) {
		model.setFolderId(folderId);
	}

	/**
	 * Sets the full name of this member.
	 *
	 * @param fullName the full name of this member
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this member.
	 *
	 * @param groupId the group ID of this member
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image file ID of this member.
	 *
	 * @param imageFileId the image file ID of this member
	 */
	@Override
	public void setImageFileId(long imageFileId) {
		model.setImageFileId(imageFileId);
	}

	/**
	 * Sets the is leader of this member.
	 *
	 * @param isLeader the is leader of this member
	 */
	@Override
	public void setIsLeader(Boolean isLeader) {
		model.setIsLeader(isLeader);
	}

	/**
	 * Sets the member ID of this member.
	 *
	 * @param memberId the member ID of this member
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the modified date of this member.
	 *
	 * @param modifiedDate the modified date of this member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified user of this member.
	 *
	 * @param modifiedUser the modified user of this member
	 */
	@Override
	public void setModifiedUser(long modifiedUser) {
		model.setModifiedUser(modifiedUser);
	}

	/**
	 * Sets the organization ID of this member.
	 *
	 * @param organizationId the organization ID of this member
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the position of this member.
	 *
	 * @param position the position of this member
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this member.
	 *
	 * @param primaryKey the primary key of this member
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sex of this member.
	 *
	 * @param sex the sex of this member
	 */
	@Override
	public void setSex(Boolean sex) {
		model.setSex(sex);
	}

	/**
	 * Sets the url image of this member.
	 *
	 * @param urlImage the url image of this member
	 */
	@Override
	public void setUrlImage(String urlImage) {
		model.setUrlImage(urlImage);
	}

	/**
	 * Sets the uuid of this member.
	 *
	 * @param uuid the uuid of this member
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected memberWrapper wrap(member member) {
		return new memberWrapper(member);
	}

}