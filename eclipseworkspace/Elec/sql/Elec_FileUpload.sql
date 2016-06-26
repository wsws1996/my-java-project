create table Elec_FileUpload(
	SeqID int not null primary key,
	ProjID varchar(50) null,
	BelongTo varchar(50) null,
	FileName varchar(50) null,
	FileURL varchar(1000) null,
	ProgressTime varchar(20) null,
	comment varchar(500) null
);