create index IX_3750D112 on ecoit_doc_DocumentAttachments (docId);

create index IX_38E89CAD on ecoit_doc_DraftAttachments (draftId);

create index IX_CBBFB51 on ecoit_doc_EcmsGURelation (groupUserId, userId);

create index IX_5EEF230A on ecoit_doc_EcmsPGRelation (permission);

create index IX_ABA476C2 on ecoit_doc_GroupCategory (typeid);

create index IX_AAA3D1FA on ecoit_doc_GroupField (fieldid);

create index IX_23992FB0 on ecoit_doc_GroupOrganization (organizationid);

create index IX_75D9E4BA on ecoit_doc_LegalAttachedMessage (articleId[$COLUMN_LENGTH:75$], readMessage);
create index IX_7DFCAD51 on ecoit_doc_LegalAttachedMessage (groupId, readMessage);
create index IX_858669BA on ecoit_doc_LegalAttachedMessage (readMessage, articleId[$COLUMN_LENGTH:75$]);

create index IX_D77E3693 on ecoit_doc_LegalDDRel (docId[$COLUMN_LENGTH:75$]);

create index IX_358C257 on ecoit_doc_LegalDFRel (fieldId);

create index IX_E0A45B3B on ecoit_doc_LegalDSRel (sigId);

create index IX_E0DF2AEA on ecoit_doc_LegalDTypeRel (typeId, docId);

create index IX_D73E7D79 on ecoit_doc_LegalDURel (userid);

create index IX_2C2DFA1 on ecoit_doc_LegalDocument (fieldId, statusDoc);
create index IX_727FBBD7 on ecoit_doc_LegalDocument (groupId, companyId, fieldId);
create index IX_C25F83A4 on ecoit_doc_LegalDocument (groupId, companyId, language[$COLUMN_LENGTH:75$], fieldId, isPublic, statusDoc);
create index IX_1BED6135 on ecoit_doc_LegalDocument (groupId, companyId, language[$COLUMN_LENGTH:75$], isPublic, statusDoc);
create index IX_37B9CAD3 on ecoit_doc_LegalDocument (groupId, companyId, language[$COLUMN_LENGTH:75$], organizationId, isPublic, statusDoc);
create index IX_68E09D7C on ecoit_doc_LegalDocument (groupId, companyId, language[$COLUMN_LENGTH:75$], statusDoc);
create index IX_28E8D2AC on ecoit_doc_LegalDocument (groupId, companyId, language[$COLUMN_LENGTH:75$], typeId, isPublic, statusDoc);
create index IX_978FB3C8 on ecoit_doc_LegalDocument (groupId, companyId, statusDoc);
create index IX_7E174BB7 on ecoit_doc_LegalDocument (groupId, companyId, typeId);
create index IX_709467EA on ecoit_doc_LegalDocument (groupId, createdByUser, language[$COLUMN_LENGTH:75$], statusDoc);
create index IX_DCCA12C9 on ecoit_doc_LegalDocument (groupId, docId);
create index IX_5E699470 on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], fieldId, isPublic, statusDoc);
create index IX_6E8D8E77 on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], fieldId, statusDoc);
create index IX_A7C2FAE9 on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], isPublic, statusDoc);
create index IX_30D9574E on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], organizationId, statusDoc);
create index IX_46E50830 on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], statusDoc);
create index IX_28B69E67 on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], typeId, statusDoc);
create index IX_58116DB6 on ecoit_doc_LegalDocument (groupId, language[$COLUMN_LENGTH:75$], userId, statusDoc);
create index IX_2E638528 on ecoit_doc_LegalDocument (groupId, num[$COLUMN_LENGTH:75$], symbol[$COLUMN_LENGTH:100$]);
create index IX_CDDA6545 on ecoit_doc_LegalDocument (groupId, organizationId, typeId, language[$COLUMN_LENGTH:75$], statusDoc);
create index IX_EA10D920 on ecoit_doc_LegalDocument (groupId, typeId, organizationId, fieldId);
create index IX_9A37CEFF on ecoit_doc_LegalDocument (isPublic, statusDoc);
create index IX_B12842E4 on ecoit_doc_LegalDocument (organizationId, statusDoc);
create index IX_D3D709EC on ecoit_doc_LegalDocument (organizationId, typeId, fieldId, statusDoc);
create index IX_239DFC6 on ecoit_doc_LegalDocument (statusDoc);
create index IX_DBAC8585 on ecoit_doc_LegalDocument (typeId, language[$COLUMN_LENGTH:75$]);
create index IX_A95D7FFD on ecoit_doc_LegalDocument (typeId, statusDoc);

create index IX_DBF894C2 on ecoit_doc_LegalDraftDocument (docCode[$COLUMN_LENGTH:75$]);
create index IX_9B75BD4E on ecoit_doc_LegalDraftDocument (groupId, companyId, statusDraft);
create index IX_A9951875 on ecoit_doc_LegalDraftDocument (groupId, draftId);
create index IX_D12CEBC3 on ecoit_doc_LegalDraftDocument (groupId, language[$COLUMN_LENGTH:75$]);
create index IX_B75F125E on ecoit_doc_LegalDraftDocument (groupId, statusDraft, createdByUser, language[$COLUMN_LENGTH:75$]);
create index IX_D1103CD on ecoit_doc_LegalDraftDocument (groupId, statusDraft, docCode[$COLUMN_LENGTH:75$]);
create index IX_756EB03D on ecoit_doc_LegalDraftDocument (groupId, statusDraft, fieldId);
create index IX_CBEC4B4 on ecoit_doc_LegalDraftDocument (groupId, statusDraft, language[$COLUMN_LENGTH:75$]);
create index IX_54E53291 on ecoit_doc_LegalDraftDocument (groupId, statusDraft, typeId);
create index IX_459F324C on ecoit_doc_LegalDraftDocument (statusDraft);

create index IX_909B506B on ecoit_doc_LegalFTRel (typeId);

create index IX_DAEE837D on ecoit_doc_LegalField (groupId, companyId, language[$COLUMN_LENGTH:75$], statusField);
create index IX_B086989 on ecoit_doc_LegalField (groupId, companyId, statusField);
create index IX_A329D46C on ecoit_doc_LegalField (groupId, fieldId);
create index IX_96682665 on ecoit_doc_LegalField (groupId, language[$COLUMN_LENGTH:75$]);
create index IX_8B0E4B2B on ecoit_doc_LegalField (groupId, statusField, language[$COLUMN_LENGTH:75$]);
create index IX_EA2FA01D on ecoit_doc_LegalField (groupId, statusField, rssable);
create index IX_D6A74387 on ecoit_doc_LegalField (statusField);

create index IX_A3E9F4A9 on ecoit_doc_LegalFoRel (organizationId);

create index IX_855DC509 on ecoit_doc_LegalLevelValidity (groupId, companyId, statusLevelValidity);
create index IX_61E835CB on ecoit_doc_LegalLevelValidity (groupId, language[$COLUMN_LENGTH:75$], statusLevelValidity);
create index IX_7855F224 on ecoit_doc_LegalLevelValidity (groupId, levelValidityId);
create index IX_491DFB07 on ecoit_doc_LegalLevelValidity (statusLevelValidity);

create index IX_143B5171 on ecoit_doc_LegalLogger (createdByUser[$COLUMN_LENGTH:75$], createdDate);
create index IX_2BA96D46 on ecoit_doc_LegalLogger (entryId[$COLUMN_LENGTH:75$], classEntry[$COLUMN_LENGTH:75$]);
create index IX_B5EB9C03 on ecoit_doc_LegalLogger (groupId, companyId);

create index IX_157A3644 on ecoit_doc_LegalOrg (groupId, companyId, language[$COLUMN_LENGTH:75$], parentId, statusOrg);
create index IX_1ABA92BD on ecoit_doc_LegalOrg (groupId, companyId, language[$COLUMN_LENGTH:75$], statusOrg);
create index IX_1A3E53D0 on ecoit_doc_LegalOrg (groupId, companyId, parentId, statusOrg);
create index IX_606FEF49 on ecoit_doc_LegalOrg (groupId, companyId, statusOrg);
create index IX_D402926E on ecoit_doc_LegalOrg (groupId, language[$COLUMN_LENGTH:75$], parentId, statusOrg);
create index IX_61D93A91 on ecoit_doc_LegalOrg (groupId, organizationId);
create index IX_E15508FF on ecoit_doc_LegalOrg (groupId, statusOrg, language[$COLUMN_LENGTH:75$]);
create index IX_CBEFD7C9 on ecoit_doc_LegalOrg (groupId, statusOrg, rssable);
create index IX_F8F17C7 on ecoit_doc_LegalOrg (statusOrg);

create index IX_1548E80D on ecoit_doc_LegalSigner (groupId, companyId, statusSigner);
create index IX_11BB027 on ecoit_doc_LegalSigner (groupId, language[$COLUMN_LENGTH:75$], statusSigner);
create index IX_821AEDF1 on ecoit_doc_LegalSigner (groupId, sigId);
create index IX_C62D50CF on ecoit_doc_LegalSigner (statusSigner);

create index IX_E3C9F722 on ecoit_doc_LegalSuggestDocument (approved, docId);
create index IX_1588B9ED on ecoit_doc_LegalSuggestDocument (docId);
create index IX_93492C9F on ecoit_doc_LegalSuggestDocument (groupId, approved);
create index IX_7DA3F318 on ecoit_doc_LegalSuggestDocument (groupId, language[$COLUMN_LENGTH:75$], approved, docId);
create index IX_46DF30BC on ecoit_doc_LegalSuggestDocument (groupId, sugId);

create index IX_2C1309E5 on ecoit_doc_LegalTDRel (tagId);

create index IX_B5FF45FB on ecoit_doc_LegalTags (groupId, statusTags);

create index IX_4A83AE92 on ecoit_doc_LegalType (groupId, companyId, language[$COLUMN_LENGTH:75$], parentId, statusType);
create index IX_70F7AA39 on ecoit_doc_LegalType (groupId, companyId, language[$COLUMN_LENGTH:75$], statusType);
create index IX_61EC0B86 on ecoit_doc_LegalType (groupId, companyId, parentId, statusType);
create index IX_934DE82D on ecoit_doc_LegalType (groupId, companyId, statusType);
create index IX_E08165E7 on ecoit_doc_LegalType (groupId, language[$COLUMN_LENGTH:75$]);
create index IX_FA1C7F27 on ecoit_doc_LegalType (groupId, statusType, language[$COLUMN_LENGTH:75$]);
create index IX_ECCFCA1 on ecoit_doc_LegalType (groupId, statusType, rssable);
create index IX_7F348484 on ecoit_doc_LegalType (groupId, typeId);
create index IX_839A16F on ecoit_doc_LegalType (statusType);