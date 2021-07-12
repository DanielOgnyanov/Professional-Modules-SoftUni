SELECT DISTINCT(SUBSTRING(`first_name`,1,1)) 
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `first_name`;