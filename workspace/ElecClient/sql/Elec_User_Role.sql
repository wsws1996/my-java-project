create table Elec_User_Role(
	userID varchar(32) not null,
	roleID varchar(32) not null,
	primary key(userID,roleID)
);