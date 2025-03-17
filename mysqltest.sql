CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    gender CHAR(1) NOT NULL,
    age INT,
    birthdate DATE
);

INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly1","男",21,NOW());
INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly2","男",22,NOW());
INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly3","男",23,NOW());
INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly4","男",24,NOW());
INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly4","男",25,NOW());
INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly5","男",26,NOW());
INSERT INTO student (NAME,gender,age,birthdate) VALUES ("fly6","男",27,NOW());

SELECT * FROM student;
