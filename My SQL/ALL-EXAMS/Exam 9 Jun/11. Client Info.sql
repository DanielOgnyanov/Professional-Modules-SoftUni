DELIMITER $$
CREATE PROCEDURE udp_clientinfo  (full_name VARCHAR(45))
BEGIN



SELECT c.full_name, c.age , b.account_number, CONCAT('$',b.balance) AS 'balance' FROM clients AS c

JOIN bank_accounts AS b
ON c.id = b.client_id

WHERE c.full_name = full_name;



END $$
DELIMITER ;


CALL udp_clientinfo  ('Hunter Wesgate');