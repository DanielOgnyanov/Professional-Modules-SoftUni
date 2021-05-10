CREATE TABLE `people` (
	`id` int NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL,
	`picture` BLOB,
	`height` DOUBLE(3,2),
	`weight` DOUBLE(5,2),
	`gender` ENUM('m', 'f') NOT NULL,
	`birthdate` date NOT NULL,
	`biography` LONGTEXT
) ;

INSERT INTO `people`(`name`, `gender`, `birthdate`)
	VALUES 
		('Pesho', 'm', '1980-02-10'),
		('Gosho', 1, '1985-10-15'),
		('Maria', 'f', '1985-10-15'),
		('Pena', 2, '1986-10-15'),
		('Tosho', 1, '1976-10-15');
