SELECT `town_id`, `name` FROM `towns`
WHERE `name` NOT LIKE "R%" 
AND `name` NOT LIKE "D%" 
AND `name` NOT LIKE "B%" 
ORDER BY `name`;