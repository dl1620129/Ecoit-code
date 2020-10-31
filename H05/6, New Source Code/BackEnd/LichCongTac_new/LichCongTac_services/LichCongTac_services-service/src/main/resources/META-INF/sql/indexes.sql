create index IX_BDDDEABE on LichCongTac_LichChiTiet (lichCongTacId);

create index IX_C3ABC708 on ecoit_lich_LichChiTiet (lichCongTacId);

create index IX_5C8107D on ecoit_lich_LichCongTac (organizationId);
create index IX_81132174 on ecoit_lich_LichCongTac (trangthaiLichCongTac, lichCongTacId);

create index IX_35FE838B on ecoit_lich_UserGroupRel (userPermissionGroupId);