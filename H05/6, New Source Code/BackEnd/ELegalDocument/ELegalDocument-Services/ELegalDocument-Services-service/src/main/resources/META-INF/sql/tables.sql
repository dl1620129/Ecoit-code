create table ecoit_doc_DocumentAttachments (
	attachmentId LONG not null primary key,
	docId LONG,
	view LONG
);

create table ecoit_doc_DraftAttachments (
	attachmentId LONG not null primary key,
	draftId LONG
);

create table ecoit_doc_EcmsGURelation (
	userId LONG not null,
	groupUserId LONG not null,
	primary key (userId, groupUserId)
);

create table ecoit_doc_EcmsGroup (
	groupUserId LONG not null primary key,
	groupName VARCHAR(250) null,
	description VARCHAR(550) null,
	groupId LONG,
	createdDate DATE null
);

create table ecoit_doc_EcmsPGRelation (
	groupUserId LONG not null,
	permission INTEGER not null,
	primary key (groupUserId, permission)
);

create table ecoit_doc_GroupCategory (
	groupUserId LONG not null,
	typeid LONG not null,
	primary key (groupUserId, typeid)
);

create table ecoit_doc_GroupField (
	groupUserId LONG not null,
	fieldid LONG not null,
	primary key (groupUserId, fieldid)
);

create table ecoit_doc_GroupOrganization (
	groupUserId LONG not null,
	organizationid LONG not null,
	primary key (groupUserId, organizationid)
);

create table ecoit_doc_LegalAttachedMessage (
	messageId VARCHAR(75) not null primary key,
	groupId LONG,
	companyId LONG,
	createdDate DATE null,
	createdByUser VARCHAR(75) null,
	articleId VARCHAR(75) null,
	content VARCHAR(75) null,
	readMessage BOOLEAN
);

create table ecoit_doc_LegalConfigurationFile (
	keyId VARCHAR(75) not null primary key,
	value VARCHAR(75) null
);

create table ecoit_doc_LegalDDRel (
	departmentId LONG not null,
	docId VARCHAR(75) not null,
	primary key (departmentId, docId)
);

create table ecoit_doc_LegalDFRel (
	docId LONG not null,
	fieldId LONG not null,
	primary key (docId, fieldId)
);

create table ecoit_doc_LegalDSRel (
	docId LONG not null,
	sigId LONG not null,
	primary key (docId, sigId)
);

create table ecoit_doc_LegalDTypeRel (
	docId LONG not null,
	typeId LONG not null,
	primary key (docId, typeId)
);

create table ecoit_doc_LegalDURel (
	departmentId LONG not null,
	userid LONG not null,
	primary key (departmentId, userid)
);

create table ecoit_doc_LegalDocument (
	docId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdByUser LONG,
	createdDate DATE null,
	modifiedByUser LONG,
	modifiedDate DATE null,
	approvedByUser LONG,
	approvedDate DATE null,
	forwardedByUser LONG,
	forwardedDate DATE null,
	publishedByUser LONG,
	publishedDate DATE null,
	symbol VARCHAR(100) null,
	num VARCHAR(75) null,
	promulDate DATE null,
	effectivedDate DATE null,
	expiredDate DATE null,
	replaceDoc VARCHAR(75) null,
	summary VARCHAR(550) null,
	content STRING null,
	language VARCHAR(75) null,
	userHit INTEGER,
	statusDoc INTEGER,
	isPublic INTEGER,
	typeId LONG,
	fieldId LONG,
	organizationId LONG,
	orgRels VARCHAR(550) null,
	signerRels STRING null,
	fieldRels VARCHAR(75) null,
	numRels VARCHAR(75) null,
	docCode VARCHAR(75) null,
	departmentRels VARCHAR(75) null,
	signerName VARCHAR(75) null,
	ngayDangCongBao DATE null,
	soCongBao VARCHAR(75) null,
	levelValidityId LONG,
	tags VARCHAR(75) null,
	docRelation VARCHAR(550) null,
	newGopY BOOLEAN,
	view LONG
);

create table ecoit_doc_LegalDraftDocument (
	draftId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdByUser LONG,
	createdDate DATE null,
	modifiedByUser LONG,
	modifiedDate DATE null,
	approvedByUser LONG,
	approvedDate DATE null,
	publishedByUser LONG,
	publishedDate DATE null,
	title VARCHAR(75) null,
	expiredDate DATE null,
	language VARCHAR(75) null,
	content VARCHAR(75) null,
	typeId LONG,
	fieldId LONG,
	draftLevel INTEGER,
	docCode VARCHAR(75) null,
	statusDraft INTEGER,
	email VARCHAR(75) null,
	destination VARCHAR(75) null
);

create table ecoit_doc_LegalFTRel (
	fieldId LONG not null,
	typeId LONG not null,
	primary key (fieldId, typeId)
);

create table ecoit_doc_LegalField (
	fieldId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	name VARCHAR(250) null,
	description VARCHAR(550) null,
	language VARCHAR(75) null,
	statusField BOOLEAN,
	rssable BOOLEAN,
	position INTEGER
);

create table ecoit_doc_LegalFoRel (
	fieldId LONG not null,
	organizationId LONG not null,
	primary key (fieldId, organizationId)
);

create table ecoit_doc_LegalLevelValidity (
	levelValidityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	language VARCHAR(75) null,
	statusLevelValidity BOOLEAN,
	position INTEGER
);

create table ecoit_doc_LegalLogger (
	loggerId VARCHAR(75) not null primary key,
	groupId LONG,
	companyId LONG,
	language VARCHAR(75) null,
	entryId VARCHAR(75) null,
	createdDate DATE null,
	createdByUser VARCHAR(75) null,
	classEntry VARCHAR(75) null,
	content VARCHAR(75) null
);

create table ecoit_doc_LegalOrg (
	organizationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	name VARCHAR(250) null,
	description VARCHAR(550) null,
	language VARCHAR(75) null,
	statusOrg BOOLEAN,
	rssable BOOLEAN,
	position INTEGER,
	parentId LONG
);

create table ecoit_doc_LegalSigner (
	sigId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	firstName VARCHAR(550) null,
	lastName VARCHAR(550) null,
	language VARCHAR(75) null,
	statusSigner BOOLEAN,
	fullName STRING null
);

create table ecoit_doc_LegalSuggestDocument (
	sugId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	modifiedByUser LONG,
	approved BOOLEAN,
	approvedByUser LONG,
	approvedDate DATE null,
	title VARCHAR(250) null,
	content VARCHAR(550) null,
	language VARCHAR(75) null,
	visitorName VARCHAR(250) null,
	visitorEmail VARCHAR(100) null,
	visitorTel VARCHAR(75) null,
	visitorAddress VARCHAR(75) null,
	docId LONG,
	hasAttachment BOOLEAN
);

create table ecoit_doc_LegalTDRel (
	docId LONG not null,
	tagId LONG not null,
	primary key (docId, tagId)
);

create table ecoit_doc_LegalTags (
	tagId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	statusTags BOOLEAN
);

create table ecoit_doc_LegalType (
	typeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	name VARCHAR(250) null,
	description VARCHAR(550) null,
	language VARCHAR(75) null,
	statusType BOOLEAN,
	rssable BOOLEAN,
	position INTEGER,
	parentId LONG
);