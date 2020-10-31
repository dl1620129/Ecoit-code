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
 * This class is a wrapper for {@link Links}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Links
 * @generated
 */
@ProviderType
public class LinksWrapper
	extends BaseModelWrapper<Links> implements Links, ModelWrapper<Links> {

	public LinksWrapper(Links links) {
		super(links);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linksid", getLinksid());
		attributes.put("groupid", getGroupid());
		attributes.put("createddate", getCreateddate());
		attributes.put("modifieddate", getModifieddate());
		attributes.put("linksgroupid", getLinksgroupid());
		attributes.put("name", getName());
		attributes.put("decription", getDecription());
		attributes.put("url", getUrl());
		attributes.put("imageid", getImageid());
		attributes.put("hasimage", isHasimage());
		attributes.put("position", getPosition());
		attributes.put("show", isShow());
		attributes.put("icon", isIcon());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linksid = (Long)attributes.get("linksid");

		if (linksid != null) {
			setLinksid(linksid);
		}

		Long groupid = (Long)attributes.get("groupid");

		if (groupid != null) {
			setGroupid(groupid);
		}

		Date createddate = (Date)attributes.get("createddate");

		if (createddate != null) {
			setCreateddate(createddate);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}

		Long linksgroupid = (Long)attributes.get("linksgroupid");

		if (linksgroupid != null) {
			setLinksgroupid(linksgroupid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String decription = (String)attributes.get("decription");

		if (decription != null) {
			setDecription(decription);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long imageid = (Long)attributes.get("imageid");

		if (imageid != null) {
			setImageid(imageid);
		}

		Boolean hasimage = (Boolean)attributes.get("hasimage");

		if (hasimage != null) {
			setHasimage(hasimage);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Boolean show = (Boolean)attributes.get("show");

		if (show != null) {
			setShow(show);
		}

		Boolean icon = (Boolean)attributes.get("icon");

		if (icon != null) {
			setIcon(icon);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	/**
	 * Returns the createddate of this links.
	 *
	 * @return the createddate of this links
	 */
	@Override
	public Date getCreateddate() {
		return model.getCreateddate();
	}

	/**
	 * Returns the decription of this links.
	 *
	 * @return the decription of this links
	 */
	@Override
	public String getDecription() {
		return model.getDecription();
	}

	/**
	 * Returns the groupid of this links.
	 *
	 * @return the groupid of this links
	 */
	@Override
	public long getGroupid() {
		return model.getGroupid();
	}

	/**
	 * Returns the hasimage of this links.
	 *
	 * @return the hasimage of this links
	 */
	@Override
	public boolean getHasimage() {
		return model.getHasimage();
	}

	/**
	 * Returns the icon of this links.
	 *
	 * @return the icon of this links
	 */
	@Override
	public boolean getIcon() {
		return model.getIcon();
	}

	/**
	 * Returns the imageid of this links.
	 *
	 * @return the imageid of this links
	 */
	@Override
	public long getImageid() {
		return model.getImageid();
	}

	/**
	 * Returns the linksgroupid of this links.
	 *
	 * @return the linksgroupid of this links
	 */
	@Override
	public long getLinksgroupid() {
		return model.getLinksgroupid();
	}

	/**
	 * Returns the linksid of this links.
	 *
	 * @return the linksid of this links
	 */
	@Override
	public long getLinksid() {
		return model.getLinksid();
	}

	/**
	 * Returns the modifieddate of this links.
	 *
	 * @return the modifieddate of this links
	 */
	@Override
	public Date getModifieddate() {
		return model.getModifieddate();
	}

	/**
	 * Returns the name of this links.
	 *
	 * @return the name of this links
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this links.
	 *
	 * @return the parent ID of this links
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the position of this links.
	 *
	 * @return the position of this links
	 */
	@Override
	public int getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this links.
	 *
	 * @return the primary key of this links
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the show of this links.
	 *
	 * @return the show of this links
	 */
	@Override
	public boolean getShow() {
		return model.getShow();
	}

	/**
	 * Returns the url of this links.
	 *
	 * @return the url of this links
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns <code>true</code> if this links is hasimage.
	 *
	 * @return <code>true</code> if this links is hasimage; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasimage() {
		return model.isHasimage();
	}

	/**
	 * Returns <code>true</code> if this links is icon.
	 *
	 * @return <code>true</code> if this links is icon; <code>false</code> otherwise
	 */
	@Override
	public boolean isIcon() {
		return model.isIcon();
	}

	/**
	 * Returns <code>true</code> if this links is show.
	 *
	 * @return <code>true</code> if this links is show; <code>false</code> otherwise
	 */
	@Override
	public boolean isShow() {
		return model.isShow();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the createddate of this links.
	 *
	 * @param createddate the createddate of this links
	 */
	@Override
	public void setCreateddate(Date createddate) {
		model.setCreateddate(createddate);
	}

	/**
	 * Sets the decription of this links.
	 *
	 * @param decription the decription of this links
	 */
	@Override
	public void setDecription(String decription) {
		model.setDecription(decription);
	}

	/**
	 * Sets the groupid of this links.
	 *
	 * @param groupid the groupid of this links
	 */
	@Override
	public void setGroupid(long groupid) {
		model.setGroupid(groupid);
	}

	/**
	 * Sets whether this links is hasimage.
	 *
	 * @param hasimage the hasimage of this links
	 */
	@Override
	public void setHasimage(boolean hasimage) {
		model.setHasimage(hasimage);
	}

	/**
	 * Sets whether this links is icon.
	 *
	 * @param icon the icon of this links
	 */
	@Override
	public void setIcon(boolean icon) {
		model.setIcon(icon);
	}

	/**
	 * Sets the imageid of this links.
	 *
	 * @param imageid the imageid of this links
	 */
	@Override
	public void setImageid(long imageid) {
		model.setImageid(imageid);
	}

	/**
	 * Sets the linksgroupid of this links.
	 *
	 * @param linksgroupid the linksgroupid of this links
	 */
	@Override
	public void setLinksgroupid(long linksgroupid) {
		model.setLinksgroupid(linksgroupid);
	}

	/**
	 * Sets the linksid of this links.
	 *
	 * @param linksid the linksid of this links
	 */
	@Override
	public void setLinksid(long linksid) {
		model.setLinksid(linksid);
	}

	/**
	 * Sets the modifieddate of this links.
	 *
	 * @param modifieddate the modifieddate of this links
	 */
	@Override
	public void setModifieddate(Date modifieddate) {
		model.setModifieddate(modifieddate);
	}

	/**
	 * Sets the name of this links.
	 *
	 * @param name the name of this links
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this links.
	 *
	 * @param parentId the parent ID of this links
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the position of this links.
	 *
	 * @param position the position of this links
	 */
	@Override
	public void setPosition(int position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this links.
	 *
	 * @param primaryKey the primary key of this links
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this links is show.
	 *
	 * @param show the show of this links
	 */
	@Override
	public void setShow(boolean show) {
		model.setShow(show);
	}

	/**
	 * Sets the url of this links.
	 *
	 * @param url the url of this links
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	@Override
	protected LinksWrapper wrap(Links links) {
		return new LinksWrapper(links);
	}

}