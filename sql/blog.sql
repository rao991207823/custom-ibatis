-- 初始化博客表
CREATE TABLE `blog` (
  `bid` int(11) NOT NULL COMMENT '文章ID',
  `name` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `author_id` int(11) DEFAULT NULL COMMENT '作者ID',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `blog`(`bid`,`author_id`,`name`) VALUES (1, 1001, 'MySQL从入门到改行');