SELECT MAX(salary) AS SecondHighestSalary
FROM Employee E1
WHERE 2 = (
    SELECT COUNT(DISTINCT salary)
    FROM Employee E2
    WHERE E2.salary >= E1.salary
);