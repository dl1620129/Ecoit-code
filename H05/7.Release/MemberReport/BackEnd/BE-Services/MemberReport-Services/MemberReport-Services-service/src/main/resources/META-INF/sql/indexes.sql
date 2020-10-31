create index IX_9E373C1E on ecoit_mr_MemberReport (unitId);
create index IX_B136E2DF on ecoit_mr_MemberReport (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6A889521 on ecoit_mr_MemberReport (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CB4B574D on ecoit_mr_UserGroup (userPermissionGroupId);