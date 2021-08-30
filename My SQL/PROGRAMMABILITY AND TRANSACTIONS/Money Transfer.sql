DELIMITER $$

CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT, `to_account_id` INT,
`amount` DECIMAL (13,4))
BEGIN 
START TRANSACTION;
IF (`amount` <0
 OR `from_account_id` = `to_account_id`
 OR (SELECT `id` FROM `accounts` WHERE `id` = `from_account_id`) IS NULL
 OR (SELECT `id` FROM `accounts` WHERE `id` = `to_account_id`) IS NULL
 OR (SELECT `balance` FROM  `accounts` WHERE `id` = `from_account_id`)-`amount`< 0) THEN
ROLLBACK;
ELSE
UPDATE `accounts`
SET `balance` = `balance` - `amount`
WHERE
    `id` = `from_account_id`;	
UPDATE `accounts`
SET `balance` = `balance` + `amount`
WHERE
    `id` = `to_account_id`;	    
END IF;
END $$

DELIMITER ;

CALL `usp_transfer_money`(1,2, 10);