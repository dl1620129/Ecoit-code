create table portal_UserOrganization (
	userId LONG not null,
	organizationId LONG not null,
	primary key (userId, organizationId)
);

create table portal_member (
	uuid_ VARCHAR(75) null,
	memberId LONG not null primary key,
	groupId LONG,
	organizationId LONG,
	fullName VARCHAR(75) null,
	birthday DATE null,
	address VARCHAR(75) null,
	sex BOOLEAN,
	position VARCHAR(75) null,
	createDate DATE null,
	createUser LONG,
	modifiedUser LONG,
	modifiedDate DATE null,
	isLeader BOOLEAN,
	urlImage VARCHAR(75) null,
	folderId LONG,
	imageFileId LONG
);

create table portal_members (
	uuid_ VARCHAR(75) null,
	memberId LONG not null primary key,
	groupId LONG,
	organizationId LONG,
	fullName VARCHAR(75) null,
	birthday DATE null,
	address VARCHAR(75) null,
	sex BOOLEAN,
	position VARCHAR(75) null,
	createDate DATE null,
	createUser LONG,
	modifiedUser LONG,
	modifiedDate DATE null,
	isLeader BOOLEAN,
	urlImage VARCHAR(75) null,
	folderId LONG,
	imageFileId LONG
);

create table portal_organization (
	uuid_ VARCHAR(75) null,
	organizationId LONG not null primary key,
	organizationCode VARCHAR(75) null,
	groupId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	leader VARCHAR(75) null,
	member LONG,
	address VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	position VARCHAR(75) null,
	parentId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createUser LONG,
	modifiedUser LONG,
	status LONG,
	thuTu INTEGER
);

create table portal_organizations (
	uuid_ VARCHAR(75) null,
	organizationId LONG not null primary key,
	organizationCode VARCHAR(75) null,
	groupId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	leader VARCHAR(75) null,
	member LONG,
	address VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	position VARCHAR(75) null,
	parentId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createUser LONG,
	modifiedUser LONG,
	status LONG,
	thuTu INTEGER
);