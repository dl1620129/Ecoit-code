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

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link members}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see members
 * @generated
 */
@ProviderType
public class membersWrapper
	extends BaseModelWrapper<members>
	implements members, ModelWrapper<members> {

	public membersWrapper(members members) {
		super(members);
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
	 * Returns the address of this members.
	 *
	 * @return the address of this members
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the birthday of this members.
	 *
	 * @return the birthday of this members
	 */
	@Override
	public Date getBirthday() {
		return model.getBirthday();
	}

	/**
	 * Returns the create date of this members.
	 *
	 * @return the create date of this members
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create user of this members.
	 *
	 * @return the create user of this members
	 */
	@Override
	public long getCreateUser() {
		return model.getCreateUser();
	}

	/**
	 * Returns the folder ID of this members.
	 *
	 * @return the folder ID of this members
	 */
	@Override
	public long getFolderId() {
		return model.getFolderId();
	}

	/**
	 * Returns the full name of this members.
	 *
	 * @return the full name of this members
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this members.
	 *
	 * @return the group ID of this members
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image file ID of this members.
	 *
	 * @return the image file ID of this members
	 */
	@Override
	public long getImageFileId() {
		return model.getImageFileId();
	}

	/**
	 * Returns the is leader of this members.
	 *
	 * @return the is leader of this members
	 */
	@Override
	public Boolean getIsLeader() {
		return model.getIsLeader();
	}

	/**
	 * Returns the member ID of this members.
	 *
	 * @return the member ID of this members
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the modified date of this members.
	 *
	 * @return the modified date of this members
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified user of this members.
	 *
	 * @return the modified user of this members
	 */
	@Override
	public long getModifiedUser() {
		return model.getModifiedUser();
	}

	/**
	 * Returns the organization ID of this members.
	 *
	 * @return the organization ID of this members
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the position of this members.
	 *
	 * @return the position of this members
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this members.
	 *
	 * @return the primary key of this members
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sex of this members.
	 *
	 * @return the sex of this members
	 */
	@Override
	public Boolean getSex() {
		return model.getSex();
	}

	/**
	 * Returns the url image of this members.
	 *
	 * @return the url image of this members
	 */
	@Override
	public String getUrlImage() {
		return model.getUrlImage();
	}

	/**
	 * Returns the uuid of this members.
	 *
	 * @return the uuid of this members
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
	 * Sets the address of this members.
	 *
	 * @param address the address of this members
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the birthday of this members.
	 *
	 * @param birthday the birthday of this members
	 */
	@Override
	public void setBirthday(Date birthday) {
		model.setBirthday(birthday);
	}

	/**
	 * Sets the create date of this members.
	 *
	 * @param createDate the create date of this members
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create user of this members.
	 *
	 * @param createUser the create user of this members
	 */
	@Override
	public void setCreateUser(long createUser) {
		model.setCreateUser(createUser);
	}

	/**
	 * Sets the folder ID of this members.
	 *
	 * @param folderId the folder ID of this members
	 */
	@Override
	public void setFolderId(long folderId) {
		model.setFolderId(folderId);
	}

	/**
	 * Sets the full name of this members.
	 *
	 * @param fullName the full name of this members
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this members.
	 *
	 * @param groupId the group ID of this members
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image file ID of this members.
	 *
	 * @param imageFileId the image file ID of this members
	 */
	@Override
	public void setImageFileId(long imageFileId) {
		model.setImageFileId(imageFileId);
	}

	/**
	 * Sets the is leader of this members.
	 *
	 * @param isLeader the is leader of this members
	 */
	@Override
	public void setIsLeader(Boolean isLeader) {
		model.setIsLeader(isLeader);
	}

	/**
	 * Sets the member ID of this members.
	 *
	 * @param memberId the member ID of this members
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the modified date of this members.
	 *
	 * @param modifiedDate the modified date of this members
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified user of this members.
	 *
	 * @param modifiedUser the modified user of this members
	 */
	@Override
	public void setModifiedUser(long modifiedUser) {
		model.setModifiedUser(modifiedUser);
	}

	/**
	 * Sets the organization ID of this members.
	 *
	 * @param organizationId the organization ID of this members
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the position of this members.
	 *
	 * @param position the position of this members
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this members.
	 *
	 * @param primaryKey the primary key of this members
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sex of this members.
	 *
	 * @param sex the sex of this members
	 */
	@Override
	public void setSex(Boolean sex) {
		model.setSex(sex);
	}

	/**
	 * Sets the url image of this members.
	 *
	 * @param urlImage the url image of this members
	 */
	@Override
	public void setUrlImage(String urlImage) {
		model.setUrlImage(urlImage);
	}

	/**
	 * Sets the uuid of this members.
	 *
	 * @param uuid the uuid of this members
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected membersWrapper wrap(members members) {
		return new membersWrapper(members);
	}

}