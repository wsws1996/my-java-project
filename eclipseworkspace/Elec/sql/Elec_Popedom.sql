create table Elec_Popedom(
	mid varchar(32) not null,
	pid varchar(32) not null,
	NAME varchar(500) null,
	url varchar(5000) null,
	icon varchar(5000) null,
	target varchar(500) null,
	isParent boolean null,
	isMenu boolean null,
	primary key(mid,pid)
);