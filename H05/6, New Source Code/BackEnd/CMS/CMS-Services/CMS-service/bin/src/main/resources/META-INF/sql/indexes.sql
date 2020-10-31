create index IX_EBCF9F29 on soft_cms_Article (friendlyURL[$COLUMN_LENGTH:10000$], status);
create index IX_59A5C62F on soft_cms_Article (groupId, language[$COLUMN_LENGTH:75$], status, createdByUser);
create index IX_8EF2493A on soft_cms_Article (groupId, language[$COLUMN_LENGTH:75$], status, eventId);
create unique index IX_C5A27C7 on soft_cms_Article (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_371A1872 on soft_cms_ArticleHistory (articleId);
create index IX_E0CC6285 on soft_cms_ArticleHistory (uuid_[$COLUMN_LENGTH:75$]);

create unique index IX_41708506 on soft_cms_ArticleMailSend (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5E346FDF on soft_cms_ArticleMessage (articleId);
create index IX_B6D7872 on soft_cms_ArticleMessage (uuid_[$COLUMN_LENGTH:75$]);

create index IX_41001DA0 on soft_cms_Category (groupId, language[$COLUMN_LENGTH:75$], parentId);
create unique index IX_5F2B8A45 on soft_cms_Category (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8C004260 on soft_cms_CategoryArticle (categoryId);

create index IX_1DA9A78A on soft_cms_Comment (groupId, articleId, parentId);
create unique index IX_28E320F0 on soft_cms_Comment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_33BE8021 on soft_cms_Event (groupId, language[$COLUMN_LENGTH:75$]);
create unique index IX_ED4DEDAB on soft_cms_Event (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5C6A9165 on soft_cms_GroupCategory (categoryId);

create index IX_7FC00851 on soft_cms_GroupUser (groupId, language[$COLUMN_LENGTH:75$]);
create unique index IX_C604D37B on soft_cms_GroupUser (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3F468DBA on soft_cms_GroupUserUsers (groupId, groupUserId);
create index IX_E5F587F5 on soft_cms_GroupUserUsers (groupId, userId);

create index IX_6AA45700 on soft_cms_Logger (groupId, language[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_95F9CE86 on soft_cms_Logger (groupId, language[$COLUMN_LENGTH:75$], userId, type_[$COLUMN_LENGTH:75$]);
create unique index IX_E547E917 on soft_cms_Logger (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_88AE1E98 on soft_cms_MapCateLayout (categoryId, type_);
create index IX_C3AA539B on soft_cms_MapCateLayout (groupId, type_);
create index IX_15C6686C on soft_cms_MapCateLayout (layoutId, type_);
create index IX_85FAE7A4 on soft_cms_MapCateLayout (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_23A10726 on soft_cms_MapCateLayout (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6477376 on soft_cms_PermissionGroup (groupId, groupuserid);

create index IX_CABEB9E1 on soft_cms_Tag (groupId, language[$COLUMN_LENGTH:75$]);
create unique index IX_EC0E0BEB on soft_cms_Tag (uuid_[$COLUMN_LENGTH:75$], groupId);