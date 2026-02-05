# Write your MySQL query statement below
select b.id
from Weather a join Weather b
on DATEDIFF(b.recordDate,a.recordDate)=1
and a.temperature < b.temperature;