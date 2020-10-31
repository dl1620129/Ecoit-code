create table soft_cms_Article (
	uuid_ VARCHAR(75) null,
	articleId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	title STRING null,
	summary STRING null,
	content STRING null,
	image VARCHAR(75) null,
	imageTitle VARCHAR(75) null,
	author STRING null,
	source STRING null,
	eventId LONG,
	allowComent BOOLEAN,
	viewCount LONG,
	status LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	pendingDate DATE null,
	approvedDate DATE null,
	neverExpire BOOLEAN,
	publishedDateFrom DATE null,
	publishedDateTo DATE null,
	createdByUser LONG,
	pendingByUser LONG,
	modifiedByUser LONG,
	approvedByUser LONG,
	publishedByUser LONG,
	friendlyURL STRING null,
	isImageArticle BOOLEAN,
	isHomePage BOOLEAN,
	thuTu LONG,
	InvolveArt STRING null,
	folderId LONG,
	tags STRING null,
	tagIds STRING null,
	eventIds STRING null,
	events STRING null,
	isRss BOOLEAN,
	articleMainId LONG,
	isSubSite BOOLEAN,
	isNoiBat BOOLEAN,
	donVi VARCHAR(75) null,
	loaiTinBai STRING null,
	soKyTuBaiViet STRING null,
	soAnhBaiViet STRING null,
	loaiAnh STRING null,
	theLoaiTinBai STRING null,
	isTimer BOOLEAN
);

create table soft_cms_ArticleConfig (
	uuid_ VARCHAR(75) null,
	articleConfigId LONG not null primary key
);

create table soft_cms_ArticleHistory (
	uuid_ VARCHAR(75) null,
	articleHistoryId LONG not null primary key,
	articleId LONG,
	title STRING null,
	summnary STRING null,
	content STRING null,
	imageDescription STRING null,
	image STRING null,
	author STRING null,
	source STRING null,
	userId LONG,
	createdDate DATE null,
	donVi STRING null,
	loaiTinBai STRING null,
	soKyTuBaiViet VARCHAR(75) null,
	soAnhBaiViet VARCHAR(75) null,
	loaiAnh VARCHAR(75) null,
	theLoaiTinBai VARCHAR(75) null
);

create table soft_cms_ArticleMailSend (
	uuid_ VARCHAR(75) null,
	mailSendId LONG not null primary key,
	createDate DATE null,
	groupId LONG,
	nguoiGui VARCHAR(75) null,
	mailNguoiGui VARCHAR(75) null,
	nguoiNhan VARCHAR(75) null,
	mailNguoiNhan VARCHAR(75) null,
	tieuDe VARCHAR(75) null,
	noiDung VARCHAR(75) null,
	articleId LONG,
	categoryId LONG
);

create table soft_cms_ArticleMessage (
	uuid_ VARCHAR(75) null,
	messageId LONG not null primary key,
	content VARCHAR(75) null,
	articleId LONG,
	createdByUser LONG,
	createdDate DATE null
);

create table soft_cms_Category (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	title VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null,
	createdUser LONG,
	modifiedUser LONG,
	path_ VARCHAR(75) null,
	description STRING null,
	display BOOLEAN,
	parentId LONG,
	active_ LONG,
	cateChild VARCHAR(75) null,
	thuTu INTEGER,
	link STRING null,
	isRss BOOLEAN
);

create table soft_cms_CategoryArticle (
	articleId LONG not null,
	categoryId LONG not null,
	groupId LONG,
	primary key (articleId, categoryId)
);

create table soft_cms_Comment (
	uuid_ VARCHAR(75) null,
	commentId LONG not null primary key,
	groupId LONG,
	createdDate DATE null,
	username VARCHAR(75) null,
	email VARCHAR(75) null,
	content STRING null,
	likes LONG,
	approved BOOLEAN,
	articleId LONG,
	parentId LONG
);

create table soft_cms_Event (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	eventName VARCHAR(75) null,
	description STRING null
);

create table soft_cms_GroupCategory (
	groupuserid LONG not null,
	categoryId LONG not null,
	primary key (groupuserid, categoryId)
);

create table soft_cms_GroupUser (
	groupUserId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null
);

create table soft_cms_GroupUserUsers (
	groupUserId LONG not null,
	userId LONG not null,
	groupId LONG,
	primary key (groupUserId, userId)
);

create table soft_cms_Logger (
	uuid_ VARCHAR(75) null,
	loggerId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	userId LONG,
	createdDate DATE null,
	description STRING null,
	type_ VARCHAR(75) null
);

create table soft_cms_MapCateLayout (
	uuid_ VARCHAR(75) null,
	mapCateLayoutId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	categoryId LONG,
	layoutId LONG,
	type_ INTEGER
);

create table soft_cms_PermissionGroup (
	permissionId LONG not null,
	groupuserid LONG not null,
	groupId LONG,
	primary key (permissionId, groupuserid)
);

create table soft_cms_Tag (
	uuid_ VARCHAR(75) null,
	tagId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	tagName VARCHAR(75) null,
	description STRING null
);