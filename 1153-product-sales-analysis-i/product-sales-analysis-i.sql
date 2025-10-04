# Write your MySQL query statement below
SELECT PRODUCT.product_name, Sales.year, sales.price FROM
SALES
LEFT JOIN
PRODUCT ON SALES.PRODUCT_ID = PRODUCT.PRODUCT_ID;