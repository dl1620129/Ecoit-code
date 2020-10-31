create index IX_4921475B on FOO_Category (groupId, companyId);
create index IX_3FDE2883 on FOO_Category (status);

create index IX_DCD3786C on FOO_Field (fieldId, groupId);

create index IX_CFFD06FF on FOO_Foo (field2);
create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5BFD3695 on FOO_Image (categoryId);
create index IX_DE8EC6D3 on FOO_Image (groupId, companyId, categoryId);

create index IX_29936865 on portal_album_Category (groupId, companyId);
create index IX_4602088D on portal_album_Category (status);

create index IX_4F5F5922 on portal_album_Field (fieldId, groupId);

create index IX_78599C87 on portal_album_Fields (fieldId, groupId);

create index IX_BD22B415 on portal_album_Image (categoryId, isDaiDien);
create index IX_60D03109 on portal_album_Image (groupId, companyId, categoryId);