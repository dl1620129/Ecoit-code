create index IX_8AA3C959 on portal_UserOrganization (organizationId);

create index IX_8A09AFB7 on portal_member (groupId);
create index IX_E685AFF5 on portal_member (organizationId);
create unique index IX_EEA5A1C9 on portal_member (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_167C3B9E on portal_members (groupId);
create index IX_D560422E on portal_members (organizationId);
create unique index IX_DD803402 on portal_members (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BCAC3DBE on portal_organization (groupId);
create unique index IX_9FCF8DE2 on portal_organization (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_382B6E77 on portal_organizations (groupId);
create unique index IX_5193CB09 on portal_organizations (uuid_[$COLUMN_LENGTH:75$], groupId);