CREATE TABLE student (
    student_id int AUTO_INCREMENT,
    student_name VARCHAR(128) not null,
    student_class int not null,
    PRIMARY key(student_id),
    CONSTRAINT uk_student UNIQUE (student_name,student_class)
);

create table marks (
    marks_id int AUTO_INCREMENT,
    subject varchar(128) not null,
    student_id int not null,
    marks int not NULL,
    PRIMARY key(marks_id),
    constraint uk_marks UNIQUE(subject, student_id),
    CONSTRAINT FK_student_marks FOREIGN KEY (student_id) REFERENCES student(student_id)
);

insert into student (student_name, student_class) values ('A', 7);
insert into student (student_name, student_class) values ('A', 8);
insert into student (student_name, student_class) values ('A', 9);
insert into student (student_name, student_class) values ('B', 9);
insert into marks (subject, student_id, marks) values ('Sub1', 1, 10);
insert into marks (subject, student_id, marks) values ('Sub2', 1, 20);
insert into marks (subject, student_id, marks) values ('Sub3', 1, 20);
insert into marks (subject, student_id, marks) values ('Sub1', 2, 30);
insert into marks (subject, student_id, marks) values ('Sub2', 2, 40);
insert into marks (subject, student_id, marks) values ('Sub3', 2, 50);
