CREATE DATABASE
    IF NOT EXISTS `users`
    /*!40100 DEFAULT CHARACTER SET latin1 */
;

USE `users`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE
    `user` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `firstname` varchar(255) DEFAULT NULL,
        `lastname` varchar(255) DEFAULT NULL,
        `nickname` varchar(255) DEFAULT NULL,
        `email` varchar(255) DEFAULT NULL,
        `password` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = latin1;

-- drop user admin@localhost;
-- flush privileges;
-- create user admin@localhost identified by 'admins_password'