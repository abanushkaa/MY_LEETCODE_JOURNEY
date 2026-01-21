# Write your MySQL query statement below
# Write your MySQL query statement below
select e.name,e2.unique_id from
employees e left join employeeUNI e2 on
e.id= e2.id;