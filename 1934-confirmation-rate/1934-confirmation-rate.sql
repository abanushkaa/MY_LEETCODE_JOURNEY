SELECT s.user_id,
       CAST(
         ROUND(
           IF(COUNT(c.action)=0,
              0,
              SUM(c.action = 'confirmed') / COUNT(c.action)
           ), 2
         ) AS DECIMAL(4,2)
       ) AS confirmation_rate
FROM signups s
LEFT JOIN confirmations c
  ON s.user_id = c.user_id
GROUP BY s.user_id;
