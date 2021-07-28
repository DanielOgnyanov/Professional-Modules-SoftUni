CREATE DATABASE `university`;

CREATE TABLE `subjects`(
`subject_id` INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE,
`subject_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `majors`(
`major_id` INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE,
`name` VARCHAR(50)
);


CREATE TABLE `students`(
`student_id` INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE,
`student_number` VARCHAR(12) NOT NULL,
`student_name` VARCHAR(50) NOT NULL,
`major_id` INT(11) NOT NULL,
CONSTRAINT `fk_majors_student`
FOREIGN KEY (`major_id`)
REFERENCES  `majors` (`major_id`)
);


CREATE TABLE `payments`(
`payment_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
`payment_date` DATE NOT NULL,
`payment_amount` DECIMAL(8,2) NOT NULL,
`student_id` INT(11) NOT NULL,
CONSTRAINT `fk_student_pay`
FOREIGN KEY (`student_id`)
REFERENCES `students` (`student_id`)
);

CREATE TABLE `agenda`(
`student_id` INT(11),
`subject_id` INT(11),

PRIMARY KEY(`student_id` , `subject_id`),

FOREIGN KEY (`student_id`)
REFERENCES `students` (`student_id`),


FOREIGN KEY (`subject_id`)
REFERENCES `subjects` (`subject_id`)
);
