CREATE DATABASE ACMS;
USE ACMS;

CREATE TABLE MANAGERS(
	manager_id BIGINT IDENTITY(2022020001,1) PRIMARY KEY NOT NULL,
	manager_name VARCHAR(50) NOT NULL,
	manager_phone VARCHAR(50) NOT NULL,
	manager_email VARCHAR(100) NOT NULL,
	manager_pass VARCHAR(100) NOT NULL,
);

CREATE TABLE BRANCHES(
	branch_id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	branch_name VARCHAR(50) NOT NULL,
	branch_address VARCHAR(100) NOT NULL,
	branch_district VARCHAR(50) NOT NULL,
	manager_id BIGINT FOREIGN KEY REFERENCES MANAGERS(manager_id) NOT NULL
);

CREATE TABLE COURSES(
	course_id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	course_name VARCHAR(50) NOT NULL,
	course_fee VARCHAR(50) NOT NULL
);

CREATE TABLE BATCHS(
	batch_id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	batch_name VARCHAR(50) NOT NULL,
	course_id BIGINT FOREIGN KEY REFERENCES COURSES(course_id) NOT NULL	
);

CREATE TABLE TEACHERS(
	teacher_id BIGINT IDENTITY(2022030001,1) PRIMARY KEY NOT NULL,
	teacher_name VARCHAR(50) NOT NULL,
	teacher_email VARCHAR(50) NOT NULL,
	teacher_phone VARCHAR(50) NOT NULL,
	teacher_salary VARCHAR(50) NOT NULL,
	teacher_joining_date VARCHAR(50) NOT NULL,
	branch_id BIGINT FOREIGN KEY REFERENCES BRANCHES(branch_id) NOT NULL,
	teacher_pass VARCHAR(100) NOT NULL,
	teacher_reg_status VARCHAR(50) NOT NULL DEFAULT 'UNREGISTERED',	
);

CREATE TABLE ROOMS(
	room_id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,	
	branch_id BIGINT FOREIGN KEY REFERENCES BRANCHES(branch_id) NOT NULL,	
);

Create table STUDENTS(
	student_id bigint IDENTITY(20220400001,1) primary key not null,
	student_name varchar(50) not null,
	student_phone varchar(50) not null,
	student_email varchar(50) not null,
	student_admission_date varchar(50) not null,
	course_id bigint not null foreign key references COURSES(course_id),
	batch_id bigint not null foreign key references BATCHS(batch_id),
	branch_id bigint not null foreign key references BRANCHES(branch_id),
	student_pass VARCHAR(100) NOT NULL,
	student_reg_status VARCHAR(50) NOT NULL DEFAULT 'UNREGISTERED',
);

Create table SUBJECTS(
	subject_id bigint IDENTITY(3100,1) primary key not null,
	subject_name varchar(50) not null,
	course_id bigint not null foreign key references COURSES(course_id),
	teacher_id bigint null foreign key references TEACHERS(teacher_id),
);

Create table SCHEDULES(
	schedule_id bigint IDENTITY(1,1) primary key not null,
	schedule_weekday varchar(50) not null,
	schedule_activity_type varchar(50) not null,
	schedule_starting_time varchar(50) not null,
	subject_id bigint not null foreign key references SUBJECTS(subject_id),
	batch_id bigint not null foreign key references BATCHS(batch_id),
	room_id bigint not null foreign key references ROOMS(room_id),
	teacher_id bigint not null foreign key references TEACHERS(teacher_id),
);

Create table EXAMS(
	exam_id bigint IDENTITY(1,1) primary key not null,
	exam_type varchar(50) not null,
	exam_date varchar(50) not null,
	exam_duration varchar(50) not null,
	exam_total_marks varchar(50) not null,
	subject_id bigint not null foreign key references SUBJECTS(subject_id),
	exam_time varchar(50) not null
);

Create table RESULTS(
	result_id bigint IDENTITY(1,1) primary key not null,
	exam_id bigint not null foreign key references EXAMS(exam_id),
	student_id bigint not null foreign key references STUDENTS(student_id),
	result_obtained_marks varchar(50) not null,
	result_grade varchar(50) not null,
);

/*----------------*/
		
INSERT INTO MANAGERS(manager_name,manager_email,manager_phone,manager_pass)
VALUES('Mahin Hossain','190204061@aust.edu','01717177717','123456'),
		('Afia Afrin','190204062@aust.edu','01717177718','123456'),
		('Mohaiminul Nirjhor','190204063@aust.edu','01717177719','123456');
SELECT * FROM MANAGERS;

INSERT INTO BRANCHES(branch_name,branch_address,branch_district,manager_id)
VALUES('Azimpur','Building-01, Road-02, Azimmpur','DHAKA',2022020001),
		('Chawkbazar','Building-02,Road-03, Chawkbazar','DHAKA',2022020002),
		('Mohammadpur','Building-11, Road-Babar Road','DHAKA',2022020003);
SELECT * FROM BRANCHES;

INSERT INTO COURSES(course_name,course_fee)
VALUES('ENGINEERING','18500'),
	('ENGINEERING + BIOLOGY','24500'),
	('ENGINEERING + VARSITY','24000');	
SELECT * FROM COURSES;

INSERT BATCHS(batch_name,course_id)
VALUES('Tukhor1',1),
	('Anonto1',1),
	('Adommo1',1),
	('Tukhor2',2),
	('Anonto2',2),
	('Adommo2',2),
	('Tukhor3',3),
	('Anonto3',3),
	('Adommo3',3);
SELECT * FROM BATCHS;
		
INSERT INTO TEACHERS(teacher_name,teacher_email,teacher_phone,teacher_joining_date,teacher_salary,branch_id,teacher_pass,teacher_reg_status)
VALUES('Farhan Abid','190204012@aust.edu','01711222111','01-08-2022','40000',1,'123456','REGISTERED'),
	('Zabin Shreya','190204003@aust.edu','01711222112','01-08-2022','40000',2,'123456','REGISTERED'),
	('Ayon Raihan','190204057@aust.edu','01711222113','01-08-2022','40000',3,'123456','REGISTERED'),
	('Ashraful Abid','190204108@aust.edu','01711222114','01-08-2022','40000',1,'123456','REGISTERED'),
	('Sifat Ahmed','190204006@aust.edu','01711222115','01-08-2022','40000',1,'123456','REGISTERED');
INSERT INTO TEACHERS(teacher_name,teacher_email,teacher_phone,teacher_joining_date,teacher_salary,branch_id,teacher_pass,teacher_reg_status)
VALUES('Mrinmoy Joy','190204017@aust.edu','01711222111','01-08-2022','40000',1,'123456','UNREGISTERED')
SELECT * FROM TEACHERS;

INSERT INTO ROOMS(branch_id)
VALUES(1),
	(1),
	(2),
	(2),
	(3);
SELECT * FROM ROOMS;	

INSERT INTO STUDENTS(student_name,student_email,student_phone,student_admission_date,branch_id,student_pass,course_id,batch_id,student_reg_status)
VALUES('Fariha Zahin','190204007@aust.edu','01711222333','01-08-2022',1,'123456',1,1,'REGISTERED'),
	('Abir Bony','190204021@aust.edu','01711222334','01-08-2022',1,'123456',1,1,'REGISTERED'),
	('Mrinmoy Joy','190204017@aust.edu','01711222335','01-08-2022',1,'123456',1,1,'REGISTERED');
SELECT * FROM STUDENTS;	
INSERT INTO STUDENTS(student_name,student_email,student_phone,student_admission_date,branch_id,student_pass,course_id,batch_id,student_reg_status)
VALUES('Afia Khan','190204010@aust.edu','01711222333','01-08-2022',1,'123456',1,1,'UNREGISTERED')


INSERT INTO SUBJECTS(subject_name,course_id,teacher_id)
VALUES('PHYSICS',1,2022030001),
	('CHEMISTRY',1,2022030002),
	('HIGHER MATHEMATICS',2,2022030003)

INSERT INTO SCHEDULES(schedule_weekday, schedule_activity_type, schedule_starting_time, subject_id, batch_id, room_id, teacher_id)
VALUES('SUNDAY','Class','10:00 PM', 3100, 1, 1, 2022030001),
	('SATURDAY','Class','11:00 PM', 3101, 1, 2, 2022030003),
	('MONDAY','Class','10:10 PM', 3102, 2, 1, 2022030002)

INSERT INTO EXAMS
VALUES('CT','01-09-22','2hr', '50', 3100,'10:00 AM')

INSERT INTO RESULTS
VALUES(1,20220400001,'40', 'A+')