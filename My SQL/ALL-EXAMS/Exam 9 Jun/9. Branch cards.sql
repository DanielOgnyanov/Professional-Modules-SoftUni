SELECT b.`name`,COUNT(car.id) AS 'count_of_cards' FROM branches AS b

LEFT JOIN employees AS e 
ON b.id = e.branch_id

LEFT JOIN employees_clients AS el
ON e.id = el.employee_id

LEFT JOIN clients AS c 
ON c.id = el.client_id

LEFT JOIN bank_accounts AS ba
ON ba.client_id = c.id

LEFT JOIN cards AS car 
ON car.bank_account_id = ba.id

GROUP BY b.`name`
ORDER BY `count_of_cards` DESC, b.`name`;

