DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with( IN `str` VARCHAR(50))
BEGIN
SELECT `name` AS `town_name`FROM `towns`
WHERE `name` LIKE (CONCAT(`str`,'%'))
ORDER BY `name`;
END $$
DELIMITER ;

CALL `usp_get_towns_starting_with`('b');