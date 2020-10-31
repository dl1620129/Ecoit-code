create index IX_4D678805 on ecoit_qa_Answer (questionId);

create index IX_CD073FE0 on ecoit_qa_AttachmentAnswer (answerId);

create index IX_F0EB7530 on ecoit_qa_AttachmentQuestion (questionId);

create index IX_AD58D60F on ecoit_qa_GroupUserCategory (categoryId);

create index IX_A6072CB1 on ecoit_qa_GroupUserPermission (permissionId);

create index IX_47D699E9 on ecoit_qa_GroupUserUser (userId);

create index IX_7D2DF845 on ecoit_qa_Question (categoryId);
create index IX_A6548F78 on ecoit_qa_Question (status, groupId, language[$COLUMN_LENGTH:75$]);
create index IX_AEF1B14C on ecoit_qa_Question (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_938E1ACE on ecoit_qa_Question (uuid_[$COLUMN_LENGTH:75$], groupId);