create table ecoit_mr_MemberReport (
	uuid_ VARCHAR(75) null,
	memberReportId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	tong LONG,
	congTac LONG,
	hocTap LONG,
	nghiPhep LONG,
	nghiOm LONG,
	nghiBu LONG,
	liDoKhac LONG,
	note VARCHAR(550) null,
	unitId LONG,
	language VARCHAR(75) null,
	status LONG
);

create table ecoit_mr_PermissionGroup (
	userPermissionGroupId LONG not null,
	permissionId INTEGER not null,
	primary key (userPermissionGroupId, permissionId)
);

create table ecoit_mr_Unit (
	unitId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	createdByUser LONG,
	modifiedByUser LONG,
	name VARCHAR(250) null,
	description VARCHAR(550) null,
	language VARCHAR(75) null
);

create table ecoit_mr_UserGroup (
	userId LONG not null,
	userPermissionGroupId LONG not null,
	primary key (userId, userPermissionGroupId)
);

create table ecoit_mr_UserPermissionGroup (
	userPermissionGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupName VARCHAR(75) null,
	description VARCHAR(75) null
);