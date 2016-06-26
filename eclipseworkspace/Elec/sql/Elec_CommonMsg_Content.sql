create table Elec_CommonMsg_Content(
	comID varchar(50) not null primary key,
	type char(2) null,
	content varchar(5000) null,
	orderby int null
);