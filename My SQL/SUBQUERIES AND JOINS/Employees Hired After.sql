SELECT `e`.`first_name`,`e`.`last_name` ,`e`.`hire_date`, `d`.`name` 
FROM  `employees` AS `e`

JOIN `departments` AS `d`
ON `e`.`department_id` = `d`.`department_id`

WHERE `d`.`name` IN ('Sales' , 'Finance')
AND  DATE(`e`.`hire_date`) > '1999/1/1'
ORDER BY `e`.`hire_date` ;
