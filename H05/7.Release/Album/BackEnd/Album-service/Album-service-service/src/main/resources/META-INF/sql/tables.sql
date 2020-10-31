create table FOO_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createByUser VARCHAR(75) null,
	createDate DATE null,
	modifiedByUser VARCHAR(75) null,
	modifiedDate DATE null,
	view LONG,
	parentId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	tacGiaAlbum VARCHAR(75) null,
	fieldId LONG,
	status LONG,
	thuTu INTEGER,
	isDaiDien BOOLEAN
);

create table FOO_Field (
	fieldId LONG not null primary key,
	groupId LONG,
	createByUser LONG,
	createDate DATE null,
	modifiedByUser LONG,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	thuThu INTEGER
);

create table FOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
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

create table FOO_Image (
	imageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	addByUser VARCHAR(75) null,
	addDate DATE null,
	modifiedByUser VARCHAR(75) null,
	modifiedDate DATE null,
	categoryId LONG,
	fieldId LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	fileAttachId LONG,
	display BOOLEAN,
	view LONG,
	isDaiDien BOOLEAN,
	tacGia VARCHAR(75) null,
	thuTu INTEGER,
	imageFileId LONG,
	folderId LONG
);

create table portal_album_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createByUser VARCHAR(75) null,
	createDate DATE null,
	modifiedByUser VARCHAR(75) null,
	modifiedDate DATE null,
	view LONG,
	parentId LONG,
	name VARCHAR(1000) null,
	description VARCHAR(1000) null,
	tacGiaAlbum VARCHAR(75) null,
	fieldId LONG,
	status LONG,
	thuTu INTEGER,
	isDaiDien BOOLEAN,
	urlImage VARCHAR(75) null
);

create table portal_album_Field (
	fieldId LONG not null primary key,
	groupId LONG,
	createByUser LONG,
	createDate DATE null,
	modifiedByUser LONG,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	thuThu INTEGER
);

create table portal_album_Fields (
	fieldId LONG not null primary key,
	groupId LONG,
	createByUser LONG,
	createDate DATE null,
	modifiedByUser LONG,
	modifiedDate DATE null,
	name VARCHAR(1000) null,
	description VARCHAR(1000) null,
	thuThu INTEGER
);

create table portal_album_Image (
	imageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	addByUser VARCHAR(75) null,
	addDate DATE null,
	modifiedByUser VARCHAR(75) null,
	modifiedDate DATE null,
	categoryId LONG,
	fieldId LONG,
	title VARCHAR(1000) null,
	description VARCHAR(1000) null,
	fileAttachId LONG,
	display BOOLEAN,
	view LONG,
	isDaiDien BOOLEAN,
	tacGia VARCHAR(75) null,
	thuTu INTEGER,
	imageFileId LONG,
	folderId LONG,
	imageUrl VARCHAR(1000) null
);