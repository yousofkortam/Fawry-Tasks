-- select * from xjudge.contest;

select
	c.id,
	c.name as contest_name,
	c.description as contest_description,
    g.name as group_name
from
	xjudge.contest c
join
	xjudge.group_contests gc on gc.contest_id = c.id
join
	xjudge.`group` g on gc.group_id = g.id
