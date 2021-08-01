SELECT `employee_id`, `job_title`, d.`address_id`, d.`address_text` 
FROM `employees` AS a
JOIN `addresses`  AS d
ON a.`address_id` = d.`address_id`
ORDER BY `address_id`
LIMIT 5;