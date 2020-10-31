create index IX_B1C3D8BA on portal_user_UserChucDanh (groupId, companyId);
create index IX_E8D22870 on portal_user_UserChucDanh (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A4AA0AF2 on portal_user_UserChucDanh (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2B617ECC on portal_user_UserPoisition (groupId, companyId);
create index IX_B7662B02 on portal_user_UserPoisition (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_33218A04 on portal_user_UserPoisition (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1B3BD071 on portal_user_UserPoisition_Dang (groupId, companyId);
create index IX_7C82A1E7 on portal_user_UserPoisition_Dang (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_26487629 on portal_user_UserPoisition_Dang (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3C64DE1C on portal_user_UserRank (groupId, companyId);
create index IX_79591E52 on portal_user_UserRank (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_84D91154 on portal_user_UserRank (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7A3C30E3 on portal_user_UserRankPosition (userPoisitionDangId);
create index IX_F24B06D on portal_user_UserRankPosition (userRankId);