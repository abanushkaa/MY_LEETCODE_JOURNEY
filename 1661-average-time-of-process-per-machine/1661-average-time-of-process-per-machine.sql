# Write your MySQL query statement below
select a.machine_id, Round(AVG(end.timestamp-start.timestamp)) as processing time
from activity a,activity b
on a.machine_id=b.machine_id