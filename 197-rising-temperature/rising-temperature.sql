# Write your MySQL query statement below
SELECT w1.ID
FROM WEATHER AS w1
JOIN WEATHER AS w2
ON DATE_SUB(w1.recordDate, INTERVAL 1 DAY)  = w2.recordDate
WHERE w1.temperature > w2.temperature;