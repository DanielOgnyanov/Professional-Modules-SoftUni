CREATE TABLE IF NOT EXISTS `teachers` (
    `teacher_id` INT,
    `name` VARCHAR(50),
    `manager_id` INT
);

ALTER TABLE `teachers`
ADD CONSTRAINT `PK_teacher_id`
PRIMARY KEY (`teacher_id`);
        
INSERT INTO `teachers` VALUES
(101,'John',NULL),
(102,'Maya',106),
(103,'Silvia',106),
(104,'Ted',105),
(105,'Mark',101),
(106,'Greta',101);

ALTER TABLE `teachers`
ADD CONSTRAINT `FK_teachers_teacher_id_manager_id`
FOREIGN KEY (`manager_id`)
REFERENCES `teachers`(`teacher_id`);