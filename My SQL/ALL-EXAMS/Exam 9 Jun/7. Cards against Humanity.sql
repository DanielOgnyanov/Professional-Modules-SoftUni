SELECT c.id , CONCAT(c.card_number, ' ' , ':' ,' ',  cl.full_name) AS 'card_token' FROM cards AS c

JOIN bank_accounts AS b
ON b.id = c.bank_account_id

JOIN clients AS cl
ON cl.id = b.client_id

ORDER BY c.id DESC;

