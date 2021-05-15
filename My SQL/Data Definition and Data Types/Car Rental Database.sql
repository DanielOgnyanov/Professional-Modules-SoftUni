CREATE TABLE IF NOT EXISTS `categories`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`category` VARCHAR(50) NOT NULL,
	`daily_rate` DECIMAL,
	`weekly_rate` DECIMAL,
	`monthly_rate` DECIMAL,	
	`weekend_rate` DECIMAL
);

INSERT INTO `categories` (`category`)
	VALUES ('Van'),
		('Sedan'),
		('4x4');
		
CREATE TABLE IF NOT EXISTS `cars`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`plate_number` VARCHAR(50) NOT NULL UNIQUE,
	`make` VARCHAR(50),
	`model` VARCHAR(50),
	`car_year` INT(4),	
	`category_id` INT,
	`doors` INT(1),
	`picture` LONGBLOB,
	`car_condition` VARCHAR(50) DEFAULT 0,
	`available` ENUM ('true','false')
);

INSERT INTO `cars` (`plate_number`)
	VALUES ('Van123'),
		('Sedan123'),
		('4x4--');
		
CREATE TABLE IF NOT EXISTS `employees`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`first_name` VARCHAR(50),
	`last_name` VARCHAR(50) NOT NULL,
	`title` VARCHAR(50),
	`notes` TEXT
);				

INSERT INTO `employees`(`last_name`)
	VALUES ('Ivan'),
		('Petkan'),
		('Pesho');
		
CREATE TABLE IF NOT EXISTS `customers`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`driver_licence_number` VARCHAR(50),
	`full_name` VARCHAR(50) NOT NULL,
	`address` VARCHAR(50),
	`city` VARCHAR(50),
	`zip_code` INT,
	`notes` TEXT
);

INSERT INTO `customers`(`full_name`)
	VALUES ('P.P'),
		('D.D'),
		('A.A');
		
CREATE TABLE IF NOT EXISTS `rental_orders`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`employee_id` INT NOT NULL,
	`customer_id` INT NOT NULL,					
	`car_id` INT NOT NULL,
	`car_condition` VARCHAR(50) DEFAULT 0,
	`tank_level` DECIMAL,
	`kilometrage_start` INT(7),
	`kilometrage_end` INT(7),
	`total_kilometrage` INT(7),
	`start_date` DATETIME,
	`end_date` DATETIME,
	`total_days` INT(4),
	`rate_applied` DECIMAL,
	`tax_rate` DECIMAL,
	`order_status` VARCHAR(50),
	`notes` TEXT
);
		
INSERT INTO `rental_orders` (`employee_id`,`customer_id`,`car_id`)
	VALUES (1,1,1),
		(2,2,2),
		(3,3,3);