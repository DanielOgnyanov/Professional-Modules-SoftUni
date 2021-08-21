DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town( IN `str` VARCHAR(50))
BEGIN
SELECT `e`.`first_name`, `e`.`last_name` FROM `employees` AS  `e`

JOIN `addresses` AS `a`
ON `e`.`address_id` = `a`.`address_id`

JOIN `towns` AS `b`
ON `a`.`town_id` = `b`.`town_id`

WHERE `b`.`name` LIKE `str`
ORDER BY `first_name` , `last_name` , `employee_id`;
END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia')