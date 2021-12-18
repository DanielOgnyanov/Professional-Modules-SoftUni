DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE result INT;
SET result := (

SELECT COUNT(cor.id)
FROM clients AS cli 

LEFT JOIN courses AS cor 
ON cli.id = cor.client_id

WHERE cli.phone_number = phone_num

);

RETURN result;

END $$
DELIMITER ;


SELECT udf_courses_by_client ('(803) 6386812') as `count`; 
