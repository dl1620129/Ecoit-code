create index IX_D9730157 on portal_Links (groupid, parentId);
create index IX_6F10FB01 on portal_Links (linksgroupid);
create index IX_7396CB0B on portal_Links (name[$COLUMN_LENGTH:1000$]);

create index IX_AAA67291 on portal_portal (field2);
create index IX_8F8A4659 on portal_portal (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DB728F1B on portal_portal (uuid_[$COLUMN_LENGTH:75$], groupId);