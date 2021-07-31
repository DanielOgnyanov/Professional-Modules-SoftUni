SELECT `mountains`.`mountain_range`, `peaks`.`peak_name`, `peaks`.`elevation` AS `peak_elevation`
FROM`mountains`
JOIN `peaks` ON `peaks`.`mountain_id` = `mountains`.`id`
HAVING `mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;	