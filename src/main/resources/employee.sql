create database employee;
use employee;
create table admin(
	email varchar(50) primary key not null,
	password varchar(32),
	lastdate datetime
	
);

create table dept(
	did int primary key not null auto_increment,
	dname varchar(100),
	note text
);

create table emp(
	eid varchar(50) primary key not null,
	did int,
	name varchar(50),
	age int,
	sex int,
	address text,
	constraint fk_did foreign key(did) references dept(did) on delete set null
);

insert into admin(email,password,lastdate) values('xiaobai@163.com','123456',now());