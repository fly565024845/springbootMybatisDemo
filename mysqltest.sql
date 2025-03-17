CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    gender CHAR(1) NOT NULL,
    age INT,
    birthdate DATE
);

insert into student ("fly1","男"，40，NOW())