CREATE DATABASE `Movies`;

CREATE TABLE `directors`(
`id` INT AUTO_INCREMENT PRIMARY KEY ,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT  NULL
);
CREATE TABLE `Genres`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`genre_name` VARCHAR(50) NOT NULL ,
`notes` TEXT  NULL
);
CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY ,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT  NULL
);



CREATE TABLE `movies`(
`id` INT  PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT ,
`copyright_year` year,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DECIMAL,
`notes` TEXT
);



INSERT INTO `directors`(`director_name`)

VALUES

('Marto'),
('Dimo'),
('Lora'),
('Desi'),
('Trayan');


INSERT INTO `genres`(`genre_name`)

VALUES

('Comedy'),
('Love'),
('Fantasy'),
('Biographic'),
('Action');


INSERT INTO `categories`(`category_name`)

VALUES

('First'),
('Second'),
('Third'),
('Fourth'),
('Fifth');


INSERT INTO `movies`
(`title`)

VALUES
('One'),
('Two'),
('Three'),
('Four'),
('Five');




