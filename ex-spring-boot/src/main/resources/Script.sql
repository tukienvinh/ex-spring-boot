drop table if exists employee;

ALTER SEQUENCE employees_sequence restart with 100 increment 1;

create table employee (
	id int not null default nextval('employees_sequence'),
	name varchar(250) not null,
	gender int not null,
	job varchar(250) not null
);

insert into employee (name, gender, job) values 
	('Nguyen Van A', 0, 'Developer'),
	('Le Thi B', 1, 'HR'),
	('Tran Van C', 0, 'Tester'),
	('Le Thi D', 1, 'QA');