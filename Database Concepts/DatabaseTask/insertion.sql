insert into xjudge.`group`
(`name`, `description`)
values
('Group 1', 'Desctioption for group 1'),
('Group 2', 'Desctioption for group 2');

-- ---------------------------------------------------------

insert into xjudge.contest
(`name`, `description`)
values
('contest 1', 'Description for contest 1'),
('contest 2', 'Description for contest 2'),
('contest 3', 'Description for contest 3'),
('contest 4', 'Description for contest 4'),
('contest 5', 'Description for contest 5');

--  ---------------------------------------------------------

insert into xjudge.group_contests
(group_id, contest_id)
values
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5);

--  ---------------------------------------------------------