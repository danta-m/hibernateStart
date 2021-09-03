CREATE DATABASE library;
USE library;

CREATE TABLE books
(
    id INT PRIMARY KEY,
    title VARCHAR(200),
    author VARCHAR(200),
    genre VARCHAR(50),
    year INT
);