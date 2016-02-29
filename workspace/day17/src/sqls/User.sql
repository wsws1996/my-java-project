create database day17;
use day17;
create table user(
	id int primary key auto_increment,
	name varchar(40),
	password varchar(40),
	email varchar(60),
	birthday date
);
insert into user(name,password,email,birthday) values('zs','123456','zs@sina.com','1980-09-09');
insert into user(name,password,email,birthday) values('lisi','123456','lisi@sina.com','1980-09-09');
insert into user(name,password,email,birthday) values('wangwu','123456','wangwu@sina.com','1980-09-09');

create table testclob(
	id int key auto_increment,
	resume text
);