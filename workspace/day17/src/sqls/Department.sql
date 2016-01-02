create table department
(
	id varchar(40) primary key,
	name varchar(40)
);
create table employee
(
	id varchar(40) primary key,
	name varchar(40),
	salary double,
	department_id varchar(40),
	constraint department_id_FK foreign key(department_id) references department(id)
);