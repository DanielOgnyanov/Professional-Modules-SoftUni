 SELECT COUNT(`country_code`) - (SELECT COUNT(DISTINCT(`country_code`)) FROM `mountains_countries` )
 AS `country_count`
 FROM `countries`;