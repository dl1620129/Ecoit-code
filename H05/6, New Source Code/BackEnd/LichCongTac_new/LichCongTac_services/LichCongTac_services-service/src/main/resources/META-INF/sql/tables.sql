create table LichCongTac_LichChiTiet (
	lichChiTietId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	gioBatDau DATE null,
	moTa VARCHAR(75) null,
	nguoiThamDu VARCHAR(75) null,
	nguoiMoi VARCHAR(75) null,
	date_ DATE null,
	trangthaiChiTiet INTEGER,
	lichCongTacId LONG
);

create table LichCongTac_LichCongTac (
	lichCongTacId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdByUser LONG,
	modifiedDate DATE null,
	modifiedByUser LONG,
	tenLich VARCHAR(75) null,
	ngayBatDau DATE null,
	ngayKetThuc DATE null,
	lichChuyenBanNganh VARCHAR(75) null,
	lichChuyenNguoiDung VARCHAR(75) null,
	trangthaiLichCongTac INTEGER
);

create table ecoit_lich_ColumnGroupRel (
	userPermissionGroupId LONG not null,
	columnId INTEGER not null,
	primary key (userPermissionGroupId, columnId)
);

create table ecoit_lich_LichChiTiet (
	lichChiTietId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdByUser LONG,
	modifiedDate DATE null,
	modifiedByUser LONG,
	gioBatDau DATE null,
	moTa VARCHAR(550) null,
	nguoiThamDu STRING null,
	nguoiChuTri STRING null,
	selectedDate DATE null,
	trangthaiChiTiet INTEGER,
	lichCongTacId LONG,
	address VARCHAR(250) null,
	note VARCHAR(250) null,
	lydoTraVe STRING null,
	organizationId LONG
);

create table ecoit_lich_LichCongTac (
	lichCongTacId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdByUser LONG,
	modifiedDate DATE null,
	modifiedByUser LONG,
	tenLich VARCHAR(250) null,
	ngayBatDau DATE null,
	ngayKetThuc DATE null,
	lichChuyenBanNganh STRING null,
	lichChuyenNguoiDung STRING null,
	trangthaiLichCongTac INTEGER,
	organizationId LONG,
	lydoTraVe STRING null
);

create table ecoit_lich_PermissionGroup (
	userPermissionGroupId LONG not null,
	permissionId INTEGER not null,
	primary key (userPermissionGroupId, permissionId)
);

create table ecoit_lich_PermissionGroupRel (
	userPermissionGroupId LONG not null,
	permissionId INTEGER not null,
	primary key (userPermissionGroupId, permissionId)
);

create table ecoit_lich_UserGroup (
	userId LONG not null,
	userPermissionGroupId LONG not null,
	primary key (userId, userPermissionGroupId)
);

create table ecoit_lich_UserGroupRel (
	userId LONG not null,
	userPermissionGroupId LONG not null,
	primary key (userId, userPermissionGroupId)
);

create table ecoit_lich_UserPermissionGroup (
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