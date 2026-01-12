# Write your MySQL query statement below
select MAX(num) as num
from(
    select num
    from myNumbers
    group by num
    having COUNT(num) = 1
) as single_numbers;