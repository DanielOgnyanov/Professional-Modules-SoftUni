DELIMITER $$

CREATE FUNCTION `ufn_calculate_future_value`(`initial_sum` DECIMAL (13,4), 
`yearly_interest_rate` DECIMAL (13,4), `number_of_years` INT)
RETURNS DECIMAL(13,4)
deterministic
BEGIN
RETURN `initial_sum` * POW(1+`yearly_interest_rate`,`number_of_years`);
END $$

CREATE PROCEDURE `usp_calculate_future_value_for_account`(`account_id` INT, 
`yearly_interest_rate` DECIMAL (13,4))
BEGIN
SELECT 
    `a`.`id`,
    `ah`.`first_name`,
    `ah`.`last_name`,
    `a`.`balance` AS `current_balance`,
    UFN_CALCULATE_FUTURE_VALUE(`a`.`balance`,
            `yearly_interest_rate`,
            5) AS `balance_in_5_years`
FROM
    `account_holders` AS `ah`
        JOIN
    `accounts` AS `a` ON `ah`.`id` = `a`.`account_holder_id`
WHERE `a`.`id` = `account_id`;
END $$

DELIMITER ;

CALL `usp_calculate_future_value_for_account`(1, 0.10);