create index IX_28DA1CB7 on soft_adv_QuangCao (quangCaoId, groupId, type_);
create index IX_9A69A5B2 on soft_adv_QuangCao (quangCaoId, status);
create unique index IX_7D0E5918 on soft_adv_QuangCao (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C705A63D on soft_adv_QuangCaoSlider (quangCaoId, groupId);
create index IX_833FB2DC on soft_adv_QuangCaoSlider (quangCaoSliderId, groupId);
create unique index IX_EFFD8AD9 on soft_adv_QuangCaoSlider (uuid_[$COLUMN_LENGTH:75$], groupId);