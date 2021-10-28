DELIMITER $$
CREATE FUNCTION udf_client_cards_count(name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN(SELECT COUNT(c.full_name) AS 'cards' FROM clients AS c

       LEFT JOIN bank_accounts AS ba
       ON c.id = ba.client_id

       LEFT JOIN cards AS car
       ON ba.id = car.bank_account_id

       WHERE c.full_name = `name`
       GROUP BY c.full_name);

END $$
DELIMITER ;

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';


