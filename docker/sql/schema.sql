DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo DEFAULT CHARSET utf8;

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, ALTER ON `demo`.* TO 'demo'@'%';

USE demo;

DROP TABLE if EXISTS board;
CREATE TABLE board (
  seq bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  title varchar(200) NOT NULL COMMENT '제목',
  content text NOT NULL COMMENT '내용',
  reg_type ENUM('User','Kafka') NOT NULL DEFAULT 'User' COMMENT '글 분류 : 사용자(User), Kafka(Kafka)',
  reg_name varchar(20) NOT NULL COMMENT '등록자이름',
  reg_dt datetime NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '등록일시',
  PRIMARY KEY (seq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판';