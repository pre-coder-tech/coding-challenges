
-- Get the second highest salaries employee of each department

/* RANK() assigns a rank to each employee based on salary.
   Employees with the second-highest salary will have rank = 2. */

SELECT name 
FROM (
    SELECT name, salary, RANK() OVER (ORDER BY salary DESC) AS rank
    FROM employee
) ranked_employees
WHERE rank = 2;

---------------------------------------------------------------------------------------

-- Write a query to find duplicate records in a table.

SELECT column1, column2, COUNT(*) AS record_count
    FROM table_name
    GROUP BY column1, column2
    HAVING COUNT(*) > 1;

--------------------------------------------------------------------------------------

-- Write a query to retrieve employees who joined in the last 6 months.

SELECT emp_name
    FROM employees
    WHERE emp_doj > CURRENT_DATE - INTERVAL 6 MONTH;

----------------------------------------------------------------------------------------

-- Write a query to calculate the average salary of employees in each department.

SELECT emp_dept, AVG(emp_sal) 
    FROM employees
    GROUP BY emp_dept;

