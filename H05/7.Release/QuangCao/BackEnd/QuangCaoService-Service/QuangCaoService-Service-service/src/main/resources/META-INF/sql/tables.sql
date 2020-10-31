create table soft_adv_QuangCao (
	uuid_ VARCHAR(75) null,
	quangCaoId LONG not null primary key,
	groupId LONG,
	language VARCHAR(75) null,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	tenQuangCao VARCHAR(1000) null,
	moTa VARCHAR(1000) null,
	target BOOLEAN,
	imageId LONG,
	url VARCHAR(1000) null,
	type_ INTEGER,
	status INTEGER
);

create table soft_adv_QuangCaoSlider (
	uuid_ VARCHAR(75) null,
	quangCaoSliderId LONG not null primary key,
	quangCaoId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	tenQuangCao VARCHAR(1000) null,
	moTa VARCHAR(1000) null,
	target BOOLEAN,
	url VARCHAR(1000) null,
	type_ INTEGER
);