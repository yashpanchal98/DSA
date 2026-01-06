-- # Write your MySQL query statement below
-- SELECT CATEGORY, COUNT(ACCOUNT_ID) AS ACCOUNT_COUNT
-- FROM (
--     SELECT ACCOUNT_ID, INCOME,
--     CASE
--         WHEN income < 20000 THEN 'Low Salary'
--         WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
--         ELSE 'High Salary'
--         END AS CATEGORY
--     FROM ACCOUNTS
-- ) AS T
-- GROUP BY CATEGORY;



WITH Categories AS (

    SELECT 'Low Salary' AS category
    UNION SELECT 'Average Salary'
    UNION SELECT 'High Salary'
),
AccountData AS (

    SELECT 
        CASE
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
            ELSE 'High Salary'
        END AS category,
        account_id
    FROM Accounts
)

SELECT 
    C.category, 
    COUNT(A.account_id) AS accounts_count
FROM Categories C
LEFT JOIN AccountData A ON C.category = A.category
GROUP BY C.category;