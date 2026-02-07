# Write your MySQL query statement below
select contest_id,ROUND((count(r.user_id)/(select COUNT(user_id)from users) *100),2) AS percentage
from Users u right join Register r on u.user_id=r.user_id
group by contest_id
order by  percentage desc,contest_id;