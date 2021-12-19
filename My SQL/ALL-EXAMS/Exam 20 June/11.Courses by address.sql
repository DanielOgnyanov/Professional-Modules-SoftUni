DELIMITER $$
CREATE PROCEDURE udp_courses_by_address  (address_name  VARCHAR(100))
BEGIN


SELECT a.`name`, 
cli.`full_name`, 
(
    CASE 
        WHEN cor.`bill`<20 THEN 'Low'
        WHEN cor.`bill`<30 THEN 'Medium'
                ELSE 'High'
    END)  AS 'level_of_bill', 
    
    car.`make`, 
    car.`condition`, 
    cat.`name` AS 'cat_name' 
   
   
   FROM addresses AS a

JOIN courses AS cor
ON cor.`from_address_id` = a.`id`

JOIN cars AS car
ON cor.`car_id` = car.`id`

JOIN clients AS cli
ON cor.`client_id`= cli.`id`

JOIN categories AS cat
ON car.`category_id` = cat.`id`


WHERE a.`name` =  address_name
ORDER BY car.`make`, cli.`full_name`;



END $$
DELIMITER ;


CALL udp_courses_by_address('700 Monterey Avenue');
