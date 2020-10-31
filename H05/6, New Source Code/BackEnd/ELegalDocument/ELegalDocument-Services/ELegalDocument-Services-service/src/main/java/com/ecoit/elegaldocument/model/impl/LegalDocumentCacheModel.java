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

import com.ecoit.elegaldocument.model.LegalDocument;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalDocument in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDocumentCacheModel
	implements CacheModel<LegalDocument>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDocumentCacheModel)) {
			return false;
		}

		LegalDocumentCacheModel legalDocumentCacheModel =
			(LegalDocumentCacheModel)obj;

		if (docId == legalDocumentCacheModel.docId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, docId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(87);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", forwardedByUser=");
		sb.append(forwardedByUser);
		sb.append(", forwardedDate=");
		sb.append(forwardedDate);
		sb.append(", publishedByUser=");
		sb.append(publishedByUser);
		sb.append(", publishedDate=");
		sb.append(publishedDate);
		sb.append(", symbol=");
		sb.append(symbol);
		sb.append(", num=");
		sb.append(num);
		sb.append(", promulDate=");
		sb.append(promulDate);
		sb.append(", effectivedDate=");
		sb.append(effectivedDate);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", replaceDoc=");
		sb.append(replaceDoc);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", content=");
		sb.append(content);
		sb.append(", language=");
		sb.append(language);
		sb.append(", userHit=");
		sb.append(userHit);
		sb.append(", statusDoc=");
		sb.append(statusDoc);
		sb.append(", isPublic=");
		sb.append(isPublic);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", orgRels=");
		sb.append(orgRels);
		sb.append(", signerRels=");
		sb.append(signerRels);
		sb.append(", fieldRels=");
		sb.append(fieldRels);
		sb.append(", numRels=");
		sb.append(numRels);
		sb.append(", docCode=");
		sb.append(docCode);
		sb.append(", departmentRels=");
		sb.append(departmentRels);
		sb.append(", signerName=");
		sb.append(signerName);
		sb.append(", ngayDangCongBao=");
		sb.append(ngayDangCongBao);
		sb.append(", soCongBao=");
		sb.append(soCongBao);
		sb.append(", levelValidityId=");
		sb.append(levelValidityId);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", docRelation=");
		sb.append(docRelation);
		sb.append(", newGopY=");
		sb.append(newGopY);
		sb.append(", view=");
		sb.append(view);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDocument toEntityModel() {
		LegalDocumentImpl legalDocumentImpl = new LegalDocumentImpl();

		legalDocumentImpl.setDocId(docId);
		legalDocumentImpl.setGroupId(groupId);
		legalDocumentImpl.setCompanyId(companyId);
		legalDocumentImpl.setUserId(userId);
		legalDocumentImpl.setCreatedByUser(createdByUser);

		if (createdDate == Long.MIN_VALUE) {
			legalDocumentImpl.setCreatedDate(null);
		}
		else {
			legalDocumentImpl.setCreatedDate(new Date(createdDate));
		}

		legalDocumentImpl.setModifiedByUser(modifiedByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			legalDocumentImpl.setModifiedDate(null);
		}
		else {
			legalDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalDocumentImpl.setApprovedByUser(approvedByUser);

		if (approvedDate == Long.MIN_VALUE) {
			legalDocumentImpl.setApprovedDate(null);
		}
		else {
			legalDocumentImpl.setApprovedDate(new Date(approvedDate));
		}

		legalDocumentImpl.setForwardedByUser(forwardedByUser);

		if (forwardedDate == Long.MIN_VALUE) {
			legalDocumentImpl.setForwardedDate(null);
		}
		else {
			legalDocumentImpl.setForwardedDate(new Date(forwardedDate));
		}

		legalDocumentImpl.setPublishedByUser(publishedByUser);

		if (publishedDate == Long.MIN_VALUE) {
			legalDocumentImpl.setPublishedDate(null);
		}
		else {
			legalDocumentImpl.setPublishedDate(new Date(publishedDate));
		}

		if (symbol == null) {
			legalDocumentImpl.setSymbol("");
		}
		else {
			legalDocumentImpl.setSymbol(symbol);
		}

		if (num == null) {
			legalDocumentImpl.setNum("");
		}
		else {
			legalDocumentImpl.setNum(num);
		}

		if (promulDate == Long.MIN_VALUE) {
			legalDocumentImpl.setPromulDate(null);
		}
		else {
			legalDocumentImpl.setPromulDate(new Date(promulDate));
		}

		if (effectivedDate == Long.MIN_VALUE) {
			legalDocumentImpl.setEffectivedDate(null);
		}
		else {
			legalDocumentImpl.setEffectivedDate(new Date(effectivedDate));
		}

		if (expiredDate == Long.MIN_VALUE) {
			legalDocumentImpl.setExpiredDate(null);
		}
		else {
			legalDocumentImpl.setExpiredDate(new Date(expiredDate));
		}

		if (replaceDoc == null) {
			legalDocumentImpl.setReplaceDoc("");
		}
		else {
			legalDocumentImpl.setReplaceDoc(replaceDoc);
		}

		if (summary == null) {
			legalDocumentImpl.setSummary("");
		}
		else {
			legalDocumentImpl.setSummary(summary);
		}

		if (content == null) {
			legalDocumentImpl.setContent("");
		}
		else {
			legalDocumentImpl.setContent(content);
		}

		if (language == null) {
			legalDocumentImpl.setLanguage("");
		}
		else {
			legalDocumentImpl.setLanguage(language);
		}

		legalDocumentImpl.setUserHit(userHit);
		legalDocumentImpl.setStatusDoc(statusDoc);
		legalDocumentImpl.setIsPublic(isPublic);
		legalDocumentImpl.setTypeId(typeId);
		legalDocumentImpl.setFieldId(fieldId);
		legalDocumentImpl.setOrganizationId(organizationId);

		if (orgRels == null) {
			legalDocumentImpl.setOrgRels("");
		}
		else {
			legalDocumentImpl.setOrgRels(orgRels);
		}

		if (signerRels == null) {
			legalDocumentImpl.setSignerRels("");
		}
		else {
			legalDocumentImpl.setSignerRels(signerRels);
		}

		if (fieldRels == null) {
			legalDocumentImpl.setFieldRels("");
		}
		else {
			legalDocumentImpl.setFieldRels(fieldRels);
		}

		if (numRels == null) {
			legalDocumentImpl.setNumRels("");
		}
		else {
			legalDocumentImpl.setNumRels(numRels);
		}

		if (docCode == null) {
			legalDocumentImpl.setDocCode("");
		}
		else {
			legalDocumentImpl.setDocCode(docCode);
		}

		if (departmentRels == null) {
			legalDocumentImpl.setDepartmentRels("");
		}
		else {
			legalDocumentImpl.setDepartmentRels(departmentRels);
		}

		if (signerName == null) {
			legalDocumentImpl.setSignerName("");
		}
		else {
			legalDocumentImpl.setSignerName(signerName);
		}

		if (ngayDangCongBao == Long.MIN_VALUE) {
			legalDocumentImpl.setNgayDangCongBao(null);
		}
		else {
			legalDocumentImpl.setNgayDangCongBao(new Date(ngayDangCongBao));
		}

		if (soCongBao == null) {
			legalDocumentImpl.setSoCongBao("");
		}
		else {
			legalDocumentImpl.setSoCongBao(soCongBao);
		}

		legalDocumentImpl.setLevelValidityId(levelValidityId);

		if (tags == null) {
			legalDocumentImpl.setTags("");
		}
		else {
			legalDocumentImpl.setTags(tags);
		}

		if (docRelation == null) {
			legalDocumentImpl.setDocRelation("");
		}
		else {
			legalDocumentImpl.setDocRelation(docRelation);
		}

		legalDocumentImpl.setNewGopY(newGopY);
		legalDocumentImpl.setView(view);

		legalDocumentImpl.resetOriginalValues();

		return legalDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		createdByUser = objectInput.readLong();
		createdDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		approvedByUser = objectInput.readLong();
		approvedDate = objectInput.readLong();

		forwardedByUser = objectInput.readLong();
		forwardedDate = objectInput.readLong();

		publishedByUser = objectInput.readLong();
		publishedDate = objectInput.readLong();
		symbol = objectInput.readUTF();
		num = objectInput.readUTF();
		promulDate = objectInput.readLong();
		effectivedDate = objectInput.readLong();
		expiredDate = objectInput.readLong();
		replaceDoc = objectInput.readUTF();
		summary = objectInput.readUTF();
		content = objectInput.readUTF();
		language = objectInput.readUTF();

		userHit = objectInput.readInt();

		statusDoc = objectInput.readInt();

		isPublic = objectInput.readInt();

		typeId = objectInput.readLong();

		fieldId = objectInput.readLong();

		organizationId = objectInput.readLong();
		orgRels = objectInput.readUTF();
		signerRels = objectInput.readUTF();
		fieldRels = objectInput.readUTF();
		numRels = objectInput.readUTF();
		docCode = objectInput.readUTF();
		departmentRels = objectInput.readUTF();
		signerName = objectInput.readUTF();
		ngayDangCongBao = objectInput.readLong();
		soCongBao = objectInput.readUTF();

		levelValidityId = objectInput.readLong();
		tags = objectInput.readUTF();
		docRelation = objectInput.readUTF();

		newGopY = objectInput.readBoolean();

		view = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(docId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(createdByUser);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedByUser);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(approvedByUser);
		objectOutput.writeLong(approvedDate);

		objectOutput.writeLong(forwardedByUser);
		objectOutput.writeLong(forwardedDate);

		objectOutput.writeLong(publishedByUser);
		objectOutput.writeLong(publishedDate);

		if (symbol == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(symbol);
		}

		if (num == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(num);
		}

		objectOutput.writeLong(promulDate);
		objectOutput.writeLong(effectivedDate);
		objectOutput.writeLong(expiredDate);

		if (replaceDoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(replaceDoc);
		}

		if (summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summary);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeInt(userHit);

		objectOutput.writeInt(statusDoc);

		objectOutput.writeInt(isPublic);

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(fieldId);

		objectOutput.writeLong(organizationId);

		if (orgRels == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(orgRels);
		}

		if (signerRels == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(signerRels);
		}

		if (fieldRels == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldRels);
		}

		if (numRels == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numRels);
		}

		if (docCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(docCode);
		}

		if (departmentRels == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departmentRels);
		}

		if (signerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(signerName);
		}

		objectOutput.writeLong(ngayDangCongBao);

		if (soCongBao == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soCongBao);
		}

		objectOutput.writeLong(levelValidityId);

		if (tags == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tags);
		}

		if (docRelation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(docRelation);
		}

		objectOutput.writeBoolean(newGopY);

		objectOutput.writeLong(view);
	}

	public long docId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdByUser;
	public long createdDate;
	public long modifiedByUser;
	public long modifiedDate;
	public long approvedByUser;
	public long approvedDate;
	public long forwardedByUser;
	public long forwardedDate;
	public long publishedByUser;
	public long publishedDate;
	public String symbol;
	public String num;
	public long promulDate;
	public long effectivedDate;
	public long expiredDate;
	public String replaceDoc;
	public String summary;
	public String content;
	public String language;
	public int userHit;
	public int statusDoc;
	public int isPublic;
	public long typeId;
	public long fieldId;
	public long organizationId;
	public String orgRels;
	public String signerRels;
	public String fieldRels;
	public String numRels;
	public String docCode;
	public String departmentRels;
	public String signerName;
	public long ngayDangCongBao;
	public String soCongBao;
	public long levelValidityId;
	public String tags;
	public String docRelation;
	public boolean newGopY;
	public long view;

}