/*Module 5 Challenge */
/*Miguel Ramirez*/

/*Product Categories*/
SELECT DISTINCT category
FROM northwind.products;

/*Dell Products*/
SELECT * 
FROM northwind.products 
WHERE product_name
LIKE 'Dell%';

/*Pennsylvania Orders*/
SELECT *
FROM northwind.orders 
WHERE ship_state = "Pennsylvania" ;

/*Employees with last names starting with W*/
SELECT first_name, last_name
FROM northwind.employees
WHERE last_name 
LIKE 'W%';

/*Customers with Zip Codes starting with 55*/
SELECT *
FROM northwind.customers 
WHERE postal_code  
LIKE '55%';

/*Customers with Zip Codes ending with 0*/
SELECT *
FROM northwind.customers 
WHERE postal_code  
LIKE '%0';

/*Customers with .org e-mail address*/
SELECT first_name ,last_name ,email 
from northwind.customers 
WHERE email  
LIKE '%.org';

/*Customers with 202 Area Code*/
SELECT first_name, last_name, phone 
FROM northwind.customers 
WHERE phone  
LIKE '%(202)%';

/*Customers with 202 Area Code Sorted by Last Name and First Name*/
SELECT first_name, last_name, phone 
FROM northwind.customers 
WHERE phone  
LIKE '%(202)%'
ORDER BY last_name,first_name;
