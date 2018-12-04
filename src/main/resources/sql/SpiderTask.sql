-- auto Generated on 2018-12-03 14:43:34 
-- DROP TABLE IF EXISTS `spider_task`; 
CREATE TABLE spider_task(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    `account` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'account',
    `url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'url',
    `status` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'status',
    `post_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'postTime',
    `finish_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'finishTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'spider_task';
