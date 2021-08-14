SELECT `e`.`country_code`, COUNT(`s`.`mountain_range`) AS `mountain_range`
FROM  `countries` AS `e`

JOIN`mountains_countries` AS `d` 
ON `e`.`country_code` = `d`.`country_code`

JOIN `mountains` AS `s`
ON `d`.`mountain_id` = `s`.`id`

WHERE `e`.`country_code` IN('RU','BG','US')
GROUP BY `e`.`country_code`
ORDER BY COUNT(`s`.`mountain_range`) DESC;





