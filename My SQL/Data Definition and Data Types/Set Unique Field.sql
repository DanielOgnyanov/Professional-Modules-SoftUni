ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT new_pr PRIMARY KEY(`id`),
DROP `username`,
ADD `username` VARCHAR(30) NOT NULL UNIQUE;
