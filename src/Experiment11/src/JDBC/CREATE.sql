CREATE DATABASE Student;
USE Student;
CREATE TABLE `Student` (
    `id` varchar(20) DEFAULT '' NOT NULL COMMENT 'id', 
    `name` char(20) NOT NULL DEFAULT '' COMMENT 'name',
    `grade` float NOT NULL DEFAULT 0.0 COMMENT 'grade',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;