create table Elec_User(
	userID varchar(50) not null primary key,
	jctID varchar(50) null,
	jctUnitID varchar(50) null,
	userName varchar(50) null,
	logonName varchar(50) null,
	logonPwd varchar(50) null,
	sexID varchar(50) null,
	birthday  datetime null,
	address varchar(100) null,
	contactTel varchar(50) null,
	email varchar(100) null,
	mobile varchar(50) null,
	isDuty varchar(50) null,
	postID varchar(50) null,
	onDutyDate datetime null,
	offDutyDate datetime null,
	remark varchar(500) null
);