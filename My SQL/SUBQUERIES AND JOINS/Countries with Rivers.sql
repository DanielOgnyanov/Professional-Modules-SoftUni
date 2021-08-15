SELECT `e`.`country_name`, `d`.`river_name` 
FROM   `countries` AS `e`

LEFT JOIN `countries_rivers` AS `s`
ON `e`.`country_code` = `s`.`country_code` 


LEFT JOIN `rivers` AS `d`
ON  `s`.`river_id` = `d`.`id` 
WHERE `e`.`continent_code` = 'AF'

ORDER BY `e`.`country_name`
LIMIT 5;