# Write your MySQL query statement below

select s.user_id,
CAST(ROUND (IF (count(c.action)=0,
 0,
SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END) / COUNT(c.action)),2
)as decimal(4,2)
) as confirmation_rate 
from signups s  
left join confirmations c on 
s.user_id = c.user_id
group by s.user_id;