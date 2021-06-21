SELECT `name` FROM `towns`
WHERE length(`name`) = 5 OR length(`name`) = 6
ORDER BY `name` ASC;