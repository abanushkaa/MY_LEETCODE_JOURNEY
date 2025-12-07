# Write your MySQL query statement below
select query_name,
round(AVG(rating/position),2) as quality,
round(SUM(CASE WHEN rating <3 THEN 1 ELSE 0 END) * 100.0/COUNT(*),2)  as poor_query_percentage
FROM Queries
group by query_name;