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

package LinkManager.Service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link GroupLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupLink
 * @generated
 */
@ProviderType
public class GroupLinkWrapper
	extends BaseModelWrapper<GroupLink>
	implements GroupLink, ModelWrapper<GroupLink> {

	public GroupLinkWrapper(GroupLink groupLink) {
		super(groupLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linksgroupid", getLinksgroupid());
		attributes.put("groupid", getGroupid());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createddate", getCreateddate());
		attributes.put("modifieddate", getModifieddate());
		attributes.put("groupName", getGroupName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linksgroupid = (Long)attributes.get("linksgroupid");

		if (linksgroupid != null) {
			setLinksgroupid(linksgroupid);
		}

		Long groupid = (Long)attributes.get("groupid");

		if (groupid != null) {
			setGroupid(groupid);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date createddate = (Date)attributes.get("createddate");

		if (createddate != null) {
			setCreateddate(createddate);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the createddate of this group link.
	 *
	 * @return the createddate of this group link
	 */
	@Override
	public Date getCreateddate() {
		return model.getCreateddate();
	}

	/**
	 * Returns the create user ID of this group link.
	 *
	 * @return the create user ID of this group link
	 */
	@Override
	public long getCreateUserId() {
		return model.getCreateUserId();
	}

	/**
	 * Returns the create user uuid of this group link.
	 *
	 * @return the create user uuid of this group link
	 */
	@Override
	public String getCreateUserUuid() {
		return model.getCreateUserUuid();
	}

	/**
	 * Returns the description of this group link.
	 *
	 * @return the description of this group link
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the groupid of this group link.
	 *
	 * @return the groupid of this group link
	 */
	@Override
	public long getGroupid() {
		return model.getGroupid();
	}

	/**
	 * Returns the group name of this group link.
	 *
	 * @return the group name of this group link
	 */
	@Override
	public String getGroupName() {
		return model.getGroupName();
	}

	/**
	 * Returns the linksgroupid of this group link.
	 *
	 * @return the linksgroupid of this group link
	 */
	@Override
	public long getLinksgroupid() {
		return model.getLinksgroupid();
	}

	/**
	 * Returns the modifieddate of this group link.
	 *
	 * @return the modifieddate of this group link
	 */
	@Override
	public Date getModifieddate() {
		return model.getModifieddate();
	}

	/**
	 * Returns the primary key of this group link.
	 *
	 * @return the primary key of this group link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the createddate of this group link.
	 *
	 * @param createddate the createddate of this group link
	 */
	@Override
	public void setCreateddate(Date createddate) {
		model.setCreateddate(createddate);
	}

	/**
	 * Sets the create user ID of this group link.
	 *
	 * @param createUserId the create user ID of this group link
	 */
	@Override
	public void setCreateUserId(long createUserId) {
		model.setCreateUserId(createUserId);
	}

	/**
	 * Sets the create user uuid of this group link.
	 *
	 * @param createUserUuid the create user uuid of this group link
	 */
	@Override
	public void setCreateUserUuid(String createUserUuid) {
		model.setCreateUserUuid(createUserUuid);
	}

	/**
	 * Sets the description of this group link.
	 *
	 * @param description the description of this group link
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the groupid of this group link.
	 *
	 * @param groupid the groupid of this group link
	 */
	@Override
	public void setGroupid(long groupid) {
		model.setGroupid(groupid);
	}

	/**
	 * Sets the group name of this group link.
	 *
	 * @param groupName the group name of this group link
	 */
	@Override
	public void setGroupName(String groupName) {
		model.setGroupName(groupName);
	}

	/**
	 * Sets the linksgroupid of this group link.
	 *
	 * @param linksgroupid the linksgroupid of this group link
	 */
	@Override
	public void setLinksgroupid(long linksgroupid) {
		model.setLinksgroupid(linksgroupid);
	}

	/**
	 * Sets the modifieddate of this group link.
	 *
	 * @param modifieddate the modifieddate of this group link
	 */
	@Override
	public void setModifieddate(Date modifieddate) {
		model.setModifieddate(modifieddate);
	}

	/**
	 * Sets the primary key of this group link.
	 *
	 * @param primaryKey the primary key of this group link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupLinkWrapper wrap(GroupLink groupLink) {
		return new GroupLinkWrapper(groupLink);
	}

}