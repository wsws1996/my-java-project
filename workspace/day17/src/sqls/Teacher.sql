create table teacher(
	id varchar(40) primary key,
	name varchar(40),
	salary double
);


create table student(
	id varchar(40) primary key,
	name varchar(40)
);

create table teacher_student(
	teacher_id varchar(40),
	student_id varchar(40),
	primary key(teacher_id,student_id),
	constraint teacher_id_FK foreign key(teacher_id) references teacher(id),
	constraint student_id_FK foreign key(student_id) references student(id)
	);
