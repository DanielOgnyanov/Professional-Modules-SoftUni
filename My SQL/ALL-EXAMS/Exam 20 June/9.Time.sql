SELECT
a.name,  
if (HOUR(cor.start) >= 6 and hour(cor.start) <= 20, 'Day', 'Night') as day_time, 
sum(bill) AS 'bill', 
cli.full_name AS 'full_name', 
car.make AS 'make', 
car.model AS 'model', 
cat.name AS 'category_name'

from addresses a

JOIN courses cor
ON cor.from_address_id = a.id

JOIN clients cli
ON cli.id = cor.client_id

JOIN cars car
ON cor.car_id = car.id

JOIN categories cat
ON cat.id = car.category_id

GROUP BY cor.id
ORDER BY cor.id




