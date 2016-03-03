create table person(
	id varchar(40) primary key,
	name varchar(40)
);
create table idcard(
	id varchar(40) primary key,
	address varchar(100),
	constraint id_FK foreign key(id) references person(id)
);