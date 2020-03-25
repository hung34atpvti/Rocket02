drop database if exists FinalTest;
create database if not exists FinalTest;

use FinalTest;

create table User
(
	UId int primary key,
	FirstName varchar(255),
    LastName varchar(255),
    Phone char(12),
    Email varchar(255),
    Password varchar(255)
);

create table Manager
(
	MId int auto_increment primary key,
	UId int,
    ExpInYear int
);

create table Employee
(
	EId int auto_increment primary key,
	UId int,
    ProjectName varchar(255),
    ProSkill varchar(255)
);

insert into User values (1,'1','1','1','1','1');

