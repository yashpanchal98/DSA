SELECT 
    ROUND(COUNT(A2.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM (
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) AS A1
LEFT JOIN Activity AS A2
    ON A1.player_id = A2.player_id 
    AND A2.event_date = DATE_ADD(A1.first_login, INTERVAL 1 DAY);