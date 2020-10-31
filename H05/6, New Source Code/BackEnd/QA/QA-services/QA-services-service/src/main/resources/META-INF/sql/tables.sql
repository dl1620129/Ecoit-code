create table ecoit_qa_Answer (
	answerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdByUser LONG,
	modifiedDate DATE null,
	modifiedByUser LONG,
	content STRING null,
	attachmentId LONG,
	questionId LONG
);

create table ecoit_qa_AttachmentAnswer (
	attachmentId LONG not null,
	answerId LONG not null,
	primary key (attachmentId, answerId)
);

create table ecoit_qa_AttachmentQuestion (
	attachmentId LONG not null,
	questionId LONG not null,
	primary key (attachmentId, questionId)
);

create table ecoit_qa_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdByUser LONG,
	modifiedDate DATE null,
	modifiedByUser LONG,
	name VARCHAR(250) null,
	description VARCHAR(550) null,
	parentId LONG,
	position INTEGER
);

create table ecoit_qa_GroupUser (
	groupUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdByUser LONG,
	modifiedDate DATE null,
	modifiedByUser LONG,
	name VARCHAR(250) null,
	description VARCHAR(550) null
);

create table ecoit_qa_GroupUserCategory (
	groupUserId LONG not null,
	categoryId LONG not null,
	primary key (groupUserId, categoryId)
);

create table ecoit_qa_GroupUserPermission (
	groupUserId LONG not null,
	permissionId LONG not null,
	primary key (groupUserId, permissionId)
);

create table ecoit_qa_GroupUserUser (
	groupUserId LONG not null,
	userId LONG not null,
	primary key (groupUserId, userId)
);

create table ecoit_qa_Question (
	uuid_ VARCHAR(75) null,
	questionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(250) null,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedByUser LONG,
	language VARCHAR(75) null,
	title VARCHAR(250) null,
	email VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	address VARCHAR(250) null,
	view LONG,
	content STRING null,
	attachmentId LONG,
	categoryId LONG,
	status INTEGER
);