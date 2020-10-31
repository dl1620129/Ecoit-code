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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LinksSoap implements Serializable {

	public static LinksSoap toSoapModel(Links model) {
		LinksSoap soapModel = new LinksSoap();

		soapModel.setLinksid(model.getLinksid());
		soapModel.setGroupid(model.getGroupid());
		soapModel.setCreateddate(model.getCreateddate());
		soapModel.setModifieddate(model.getModifieddate());
		soapModel.setLinksgroupid(model.getLinksgroupid());
		soapModel.setName(model.getName());
		soapModel.setDecription(model.getDecription());
		soapModel.setUrl(model.getUrl());
		soapModel.setImageid(model.getImageid());
		soapModel.setHasimage(model.isHasimage());
		soapModel.setPosition(model.getPosition());
		soapModel.setShow(model.isShow());
		soapModel.setIcon(model.isIcon());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static LinksSoap[] toSoapModels(Links[] models) {
		LinksSoap[] soapModels = new LinksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinksSoap[][] toSoapModels(Links[][] models) {
		LinksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinksSoap[] toSoapModels(List<Links> models) {
		List<LinksSoap> soapModels = new ArrayList<LinksSoap>(models.size());

		for (Links model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinksSoap[soapModels.size()]);
	}

	public LinksSoap() {
	}

	public long getPrimaryKey() {
		return _linksid;
	}

	public void setPrimaryKey(long pk) {
		setLinksid(pk);
	}

	public long getLinksid() {
		return _linksid;
	}

	public void setLinksid(long linksid) {
		_linksid = linksid;
	}

	public long getGroupid() {
		return _groupid;
	}

	public void setGroupid(long groupid) {
		_groupid = groupid;
	}

	public Date getCreateddate() {
		return _createddate;
	}

	public void setCreateddate(Date createddate) {
		_createddate = createddate;
	}

	public Date getModifieddate() {
		return _modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	public long getLinksgroupid() {
		return _linksgroupid;
	}

	public void setLinksgroupid(long linksgroupid) {
		_linksgroupid = linksgroupid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDecription() {
		return _decription;
	}

	public void setDecription(String decription) {
		_decription = decription;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public long getImageid() {
		return _imageid;
	}

	public void setImageid(long imageid) {
		_imageid = imageid;
	}

	public boolean getHasimage() {
		return _hasimage;
	}

	public boolean isHasimage() {
		return _hasimage;
	}

	public void setHasimage(boolean hasimage) {
		_hasimage = hasimage;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public boolean getShow() {
		return _show;
	}

	public boolean isShow() {
		return _show;
	}

	public void setShow(boolean show) {
		_show = show;
	}

	public boolean getIcon() {
		return _icon;
	}

	public boolean isIcon() {
		return _icon;
	}

	public void setIcon(boolean icon) {
		_icon = icon;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private long _linksid;
	private long _groupid;
	private Date _createddate;
	private Date _modifieddate;
	private long _linksgroupid;
	private String _name;
	private String _decription;
	private String _url;
	private long _imageid;
	private boolean _hasimage;
	private int _position;
	private boolean _show;
	private boolean _icon;
	private long _parentId;

}