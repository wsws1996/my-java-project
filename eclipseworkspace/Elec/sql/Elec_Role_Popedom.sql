create table Elec_Role_Popedom(
	roleID varchar(32) not null,
	mid varchar(32) not null,
	pid varchar(32) not null,
	primary key(roleID,mid,pid)
);