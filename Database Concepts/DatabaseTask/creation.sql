DROP DATABASE IF EXISTS xjudge;

CREATE DATABASE xjudge;

CREATE table xjudge.`user` (
	id int primary key auto_increment,
	`name` char(255),
    handle char,
    age int
);

CREATE table xjudge.`group` (
	id int primary key auto_increment,
	`name` char(255),
    `description` longtext
);

CREATE table xjudge.contest (
	id int primary key auto_increment,
	`name` char(255),
    `description` longtext
);
-- ------------------------------------------------------------
-- CREATE table xjudge.contest (
-- 	id int primary key,
-- 	`name` char(255),
--   group_id int,
--   foreign key (group_id) references xjudge.`group`(id)
-- );

CREATE table xjudge.group_contests (
	id int primary key auto_increment,
    group_id int,
    contest_id int,
    foreign key (group_id) references xjudge.`group`(id),
    foreign key (contest_id) references xjudge.contest(id)
);
-- ------------------------------------------------------------