
create database day28;
use day28;
create table students(
	id int primary key auto_increment,
	username varchar(100) not null unique,
	password varchar(100) not null,
	gender varchar(10),
	hobby varchar(100),
	birthday date,
	email varchar(100),
	grade int
);