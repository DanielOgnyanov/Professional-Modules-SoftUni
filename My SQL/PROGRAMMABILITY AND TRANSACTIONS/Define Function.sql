DELIMITER $$

CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BIT
BEGIN
RETURN `word` REGEXP (CONCAT('^[', `set_of_letters`, ']+$'));
END $$

DELIMITER ;

SELECT UFN_IS_WORD_COMPRISED('oistmiahf', 'Sofia');