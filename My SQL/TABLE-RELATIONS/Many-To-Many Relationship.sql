CREATE TABLE `students`(
`student_id` INT ,
`name` VARCHAR(50) NOT NULL
);

INSERT INTO `students` VALUES 

(1,'Mila'),
(2,'Toni'),
(3,'Ron');

CREATE TABLE `exams`(
`exam_id` INT ,
`name` VARCHAR(50) NOT NULL
);

INSERT INTO `exams` VALUES 

(101,'Spring MVC'),
(102,'Neo4j'),
(103,'Oracle 11g');

ALTER TABLE `students`
ADD CONSTRAINT `pk_students`
PRIMARY KEY(`student_id`);

ALTER TABLE `exams`
ADD CONSTRAINT `pk_exam`
PRIMARY KEY(`exam_id`);


CREATE TABLE `students_exams`(
`student_id` INT ,
`exam_id` INT ,
CONSTRAINT `pk_students_exams`
PRIMARY KEY(`student_id`,`exam_id`),

CONSTRAINT `fk_students_exams`
FOREIGN KEY (`student_id`)
REFERENCES `students` (`student_id`),

CONSTRAINT `fk_exams_students`
FOREIGN KEY (`exam_id`)
REFERENCES `exams` (`exam_id`)

);


INSERT INTO `students_exams` VALUES
(1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);