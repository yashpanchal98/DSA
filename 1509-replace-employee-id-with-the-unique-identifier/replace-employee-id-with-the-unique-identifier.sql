# Write your MySQL query statement below

SELECT EmployeeUNI.unique_id , Employees.name FROM
Employees
LEFT JOIN 
EMPLOYEEUNI ON EMPLOYEES.ID = EMPLOYEEUNI.ID;