-- auto Generated on 2018-12-03 11:26:33 
-- DROP TABLE IF EXISTS `wechat`; 
CREATE TABLE wechat(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `nick_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'nickName',
    `info` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'info',
    `account` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'account',
    `source_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'sourceUrl',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'wechat';
