create index IX_58D456D5 on portal_Category (groupId, companyId);

create index IX_D13273D6 on portal_Clip (categoryId);
create index IX_4C99D994 on portal_Clip (groupId, companyId, categoryId);

create index IX_D9730157 on portal_Links (groupid, parentId);
create index IX_6F10FB01 on portal_Links (linksgroupid);
create index IX_7396CB0B on portal_Links (name[$COLUMN_LENGTH:1000$]);

create index IX_AAA67291 on portal_portal (field2);
create index IX_8F8A4659 on portal_portal (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DB728F1B on portal_portal (uuid_[$COLUMN_LENGTH:75$], groupId);