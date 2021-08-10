SELECT 
`e`.`employee_id`,
CONCAT(`e`.`first_name`, " ", `e`.`last_name`) AS `employee_name`,
CONCAT(`em`.`first_name`, " ", `em`.`last_name`) AS `manager_name`, 
`ep`.`name` AS `department_name`

FROM `employees` AS `e`

JOIN `departments` AS `ep`
ON `e`.`department_id` = `ep`.`department_id`

JOIN `employees` AS `em` 
ON `e`.`manager_id` = `em`.`employee_id`

WHERE `e`.`manager_id` IS NOT NULL 

ORDER BY `e`.`employee_id`
LIMIT 5;