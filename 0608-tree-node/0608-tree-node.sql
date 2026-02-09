# Write your MySQL query statement below
Select id ,
    CASE 
    WHEN p_id IS NULL then 'Root'
    when id in (Select p_id from Tree where p_id is not null) then 'Inner'
    else 'Leaf'
End as type
from Tree;