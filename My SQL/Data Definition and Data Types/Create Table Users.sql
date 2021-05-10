CREATE TABLE `minions`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(26) NOT NULL,
  `profile_picture` BLOB NULL,
  `last_login_time` TIME NULL,
  `is_deleted` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);
  
  
  INSERT INTO `users`(`id`,`username`,`password`,`profile_picture`,`last_login_time`,is_deleted)
  
  VALUES
  
  (1,'Marto','123',NULL,NULL,NULL),
  (2,'Dimo','1234',NULL,NULL,NULL),
  (3,'Lora','1235',NULL,NULL,NULL),
  (4,'Desi','1236',NULL,NULL,NULL),
  (5,'Trayan','1237',NULL,NULL,NULL);