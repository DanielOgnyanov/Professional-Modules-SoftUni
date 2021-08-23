DELIMITER $$

CREATE PROCEDURE `usp_get_employees_by_salary_level`(`employee_salary` VARCHAR(10))
BEGIN
DECLARE `salary_min` DECIMAL (13,4);
DECLARE `salary_max` DECIMAL (13,4);
IF `employee_salary`='Low' THEN
SET `salary_min` = 0;
SET `salary_max` = 30000;
ELSEIF `employee_salary`='Average' THEN
SET `salary_min` = 29999.9999;
SET `salary_max` = 50000.0001;
ELSEIF `employee_salary`='High' THEN
SET `salary_min` = 50000;
SET `salary_max` = 999999999;
END IF;

SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `salary` > `salary_min`
        AND `salary` < `salary_max`
ORDER BY `first_name` DESC , `last_name` DESC;

END $$

DELIMITER ;

CALL `usp_get_employees_by_salary_level`('High');