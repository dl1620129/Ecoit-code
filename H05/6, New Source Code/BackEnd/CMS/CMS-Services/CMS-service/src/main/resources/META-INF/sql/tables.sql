create table soft_cms_Article (
	uuid_ VARCHAR(75) null,
	articleId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	title TEXT null,
	summary TEXT null,
	content TEXT null,
	image VARCHAR(75) null,
	imageTitle TEXT null,
	author TEXT null,
	source TEXT null,
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
	friendlyURL TEXT null,
	isImageArticle BOOLEAN,
	isHomePage BOOLEAN,
	thuTu LONG,
	InvolveArt TEXT null,
	folderId LONG,
	tags TEXT null,
	tagIds TEXT null,
	eventIds TEXT null,
	events TEXT null,
	isRss BOOLEAN,
	articleMainId LONG,
	isSubSite BOOLEAN,
	isNoiBat BOOLEAN,
	donVi TEXT null,
	loaiTinBai TEXT null,
	soKyTuBaiViet TEXT null,
	soAnhBaiViet TEXT null,
	loaiAnh TEXT null,
	theLoaiTinBai TEXT null,
	isTimer BOOLEAN,
	humanAccess TEXT null,
	humanAccessIds TEXT null
);

create table soft_cms_ArticleConfig (
	uuid_ VARCHAR(75) null,
	articleConfigId LONG not null primary key
);

create table soft_cms_ArticleHistory (
	uuid_ VARCHAR(75) null,
	articleHistoryId LONG not null primary key,
	articleId LONG,
	title TEXT null,
	summnary TEXT null,
	content TEXT null,
	imageDescription TEXT null,
	image VARCHAR(75) null,
	author TEXT null,
	source TEXT null,
	userId LONG,
	createdDate DATE null,
	donVi TEXT null,
	loaiTinBai TEXT null,
	soKyTuBaiViet TEXT null,
	soAnhBaiViet TEXT null,
	loaiAnh TEXT null,
	theLoaiTinBai TEXT null
);

create table soft_cms_ArticleMailSend (
	uuid_ VARCHAR(75) null,
	mailSendId LONG not null primary key,
	createDate DATE null,
	groupId LONG,
	nguoiGui VARCHAR(75) null,
	mailNguoiGui TEXT null,
	nguoiNhan TEXT null,
	mailNguoiNhan TEXT null,
	tieuDe TEXT null,
	noiDung TEXT null,
	articleId LONG,
	categoryId LONG
);

create table soft_cms_ArticleMessage (
	uuid_ VARCHAR(75) null,
	messageId LONG not null primary key,
	content TEXT null,
	articleId LONG,
	createdByUser LONG,
	createdDate DATE null
);

create table soft_cms_Category (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	title TEXT null,
	createdDate DATE null,
	modifiedDate DATE null,
	createdUser LONG,
	modifiedUser LONG,
	path_ VARCHAR(75) null,
	description TEXT null,
	display BOOLEAN,
	parentId LONG,
	active_ LONG,
	cateChild TEXT null,
	thuTu INTEGER,
	link TEXT null,
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
	username TEXT null,
	email TEXT null,
	content TEXT null,
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
	eventName TEXT null,
	description TEXT null
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
	name TEXT null,
	description TEXT null
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
	description TEXT null,
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
	tagName TEXT null,
	description TEXT null
);