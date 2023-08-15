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

DROP TABLE if EXISTS user;
CREATE TABLE user (
    seq bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '일련번호',
    id varchar(50) NOT NULL COMMENT '아이디',
    name varchar(50) NOT NULL COMMENT '이름',
    password varchar(80) NOT NULL COMMENT '비밀번호',
    authority varchar(100) NOT NULL COMMENT '권한',
    create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '생성일시',
    PRIMARY KEY (seq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자';

-- ALTER TABLE user ADD authority varchar(100) NOT NULL COMMENT '권한' AFTER password;
-- TRUNCATE user;