SELECT 

cli.full_name AS 'full_name',
COUNT(cor.id) AS 'count_of_cars',
SUM(cor.bill) AS 'total_sum'

FROM clients AS cli

JOIN courses AS cor 
ON cli.id = cor.client_id

GROUP BY cli.id
HAVING cli.full_name like '_a%' AND `count_of_cars` > 1
ORDER BY `full_name`;


