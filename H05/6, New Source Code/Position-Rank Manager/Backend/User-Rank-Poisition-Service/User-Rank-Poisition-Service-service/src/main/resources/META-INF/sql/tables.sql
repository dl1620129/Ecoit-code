create table portal_user_UserChucDanh (
	uuid_ VARCHAR(75) null,
	userChucDanhId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userChucDanhName VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	totalMember LONG
);

create table portal_user_UserPoisition (
	uuid_ VARCHAR(75) null,
	userPoisitionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userPoisitionName VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	totalMember LONG
);

create table portal_user_UserPoisition_Dang (
	uuid_ VARCHAR(75) null,
	userPoisitionDangId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userPoisitionDangName VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	totalMember LONG
);

create table portal_user_UserRank (
	uuid_ VARCHAR(75) null,
	userRankId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	rankName VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	totalMember LONG
);

create table portal_user_UserRankPosition (
	userId LONG not null primary key,
	userRankId LONG,
	userPoisitionDangId LONG,
	userPoisitionId LONG
);