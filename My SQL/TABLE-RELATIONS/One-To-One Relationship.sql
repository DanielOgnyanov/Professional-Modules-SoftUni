CREATE TABLE `people` (
`person_id` INT AUTO_INCREMENT UNIQUE,
`first_name` VARCHAR(45) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`passport_id` INT UNIQUE NOT NULL
);

CREATE TABLE `passports` (
`passport_id` INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
`passport_number` VARCHAR(45) UNIQUE NOT NULL
);

INSERT INTO `people` VALUES  
(1,'Roberto',43300.00,102),
(2,'Tom',56100.00,103),
(3,'Yana',60200.00,101);

INSERT INTO `passports` VALUES 
(101,'N34FG21B'),
(102,'K65LO4R7'),
(103,'ZE657QP2');

ALTER TABLE `people` 
ADD CONSTRAINT `pk_persons` 
PRIMARY KEY (`person_id`),
   
ADD CONSTRAINT `fk_persons_passports` 
FOREIGN KEY(`passport_id`) 
REFERENCES `passports`(`passport_id`);


