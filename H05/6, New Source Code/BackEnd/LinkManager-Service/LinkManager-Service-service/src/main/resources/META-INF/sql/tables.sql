create table portal_Category (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	createByUser VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedByUser VARCHAR(75) null,
	title VARCHAR(1000) null,
	description VARCHAR(1000) null,
	isAudio BOOLEAN,
	view LONG
);

create table portal_Clip (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	createByUser VARCHAR(75) null,
	modifiedDate DATE null,
	modifiedByUser VARCHAR(75) null,
	title VARCHAR(1000) null,
	description VARCHAR(1000) null,
	clipAttachId LONG,
	imageAttachId LONG,
	viewCount LONG,
	likeCount LONG,
	categoryId LONG,
	isAudio BOOLEAN,
	display BOOLEAN,
	nguonVideo VARCHAR(75) null,
	tacGia VARCHAR(75) null,
	thoiLuongVideo VARCHAR(75) null,
	isDaiDien BOOLEAN,
	clipUrl VARCHAR(75) null,
	clipFileId LONG,
	folderId LONG
);

create table portal_GroupLink (
	linksgroupid LONG not null primary key,
	groupid LONG,
	createUserId LONG,
	createddate DATE null,
	modifieddate DATE null,
	groupName VARCHAR(1000) null,
	description VARCHAR(1000) null
);

create table portal_Links (
	linksid LONG not null primary key,
	groupid LONG,
	createddate DATE null,
	modifieddate DATE null,
	linksgroupid LONG,
	name VARCHAR(1000) null,
	decription VARCHAR(1000) null,
	url VARCHAR(1000) null,
	imageid LONG,
	hasimage BOOLEAN,
	position INTEGER,
	show_ BOOLEAN,
	icon BOOLEAN,
	parentId LONG
);

create table portal_portal (
	uuid_ VARCHAR(75) null,
	portalId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);