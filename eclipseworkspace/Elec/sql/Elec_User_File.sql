create table Elec_User_File(
	fileID varchar(50) not null primary key,
	userID varchar(50) null,
	fileName varchar(50) null,
	fileURL varchar(1000) null,
	progressTime timestamp null,
	constraint foreign key(userID) references Elec_User(userID)
);