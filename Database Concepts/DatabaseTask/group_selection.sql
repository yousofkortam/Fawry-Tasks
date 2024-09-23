-- select * from xjudge.`group`;

-- select `name`, `description` from xjudge.`group`;

-- Get number of contests in group

SELECT group_id , COUNT(DISTINCT contest_id) AS number_of_contests
FROM xjudge.group_contests
GROUP BY group_id;