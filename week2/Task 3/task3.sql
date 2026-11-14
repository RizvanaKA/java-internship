CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(20),
    email VARCHAR(100),
    phone VARCHAR(15),
    department VARCHAR(100),
    course VARCHAR(100),
    semester INT,
    grade DECIMAL(5,2)
);