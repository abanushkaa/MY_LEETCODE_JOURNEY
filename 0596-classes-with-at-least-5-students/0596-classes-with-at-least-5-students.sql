# Write your MySQL query statement below
Select class 
from courses
group by class
having COUNT(student)>=5;