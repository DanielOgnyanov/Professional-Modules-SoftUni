DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above`(IN `salary_above` DOUBLE)
BEGIN
SELECT `first_name`, `last_name`
FROM`employees`
WHERE`salary` >= `salary_above`
ORDER BY `first_name` , `last_name` , `employee_id`;
END $$

DELIMITER ;

CALL `usp_get_employees_salary_above`(45000);