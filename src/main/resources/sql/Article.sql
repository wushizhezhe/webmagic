-- auto Generated on 2018-12-03 12:02:36 
-- DROP TABLE IF EXISTS `article`; 
CREATE TABLE article(
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `wechat_id` BIGINT NOT NULL DEFAULT -1 COMMENT 'wechatId',
    `original_id` BIGINT NOT NULL DEFAULT -1 COMMENT 'originalId',
    `play_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'playUrl',
    `author` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'author',
    `title` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'title',
    `content` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'content',
    `source_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'sourceUrl',
    `cover` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'cover',
    `content_url` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'contentUrl',
    `publish_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'publishTime',
    `digest` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'digest',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'article';
