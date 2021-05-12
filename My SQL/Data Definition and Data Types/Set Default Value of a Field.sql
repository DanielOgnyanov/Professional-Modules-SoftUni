
ALTER TABLE `users` 
DROP `last_login_time`,
ADD `last_login_time` DATETIME DEFAULT CURRENT_TIMESTAMP;

