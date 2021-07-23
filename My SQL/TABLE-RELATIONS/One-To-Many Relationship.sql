CREATE TABLE `manufacturers`(
`manufacturer_id` INT  ,
`name` VARCHAR(50) NOT NULL UNIQUE,
`established_on` DATE NOT NULL
);


CREATE TABLE `models`(
`model_id` INT  ,
`name` VARCHAR(50) NOT NULL UNIQUE,
`manufacturer_id` INT 
);



INSERT INTO `manufacturers` VALUES
(1,'BMW',STR_TO_DATE('01/03/1916','%d/%m/%Y')),
(2,'Tesla',STR_TO_DATE('01/01/2003','%d/%m/%Y')),
(3,'Lada',STR_TO_DATE('01/05/1966','%d/%m/%Y'));




INSERT INTO `models` VALUES 

(101,'X1',1),
(102,'i6',1),
(103,'Model S',2),
(104,'Model X',2),
(105,'Model 3',2),
(106,'Nova',3);


ALTER TABLE `manufacturers` 
ADD CONSTRAINT `pk_manufacturers` 
PRIMARY KEY (`manufacturer_id`);

ALTER TABLE `models` 
ADD CONSTRAINT `pk_models` 
PRIMARY KEY (`model_id`),

ADD CONSTRAINT `fk_models_manufacturers` 
FOREIGN KEY (`manufacturer_id`)
REFERENCES `manufacturers` (`manufacturer_id`);
