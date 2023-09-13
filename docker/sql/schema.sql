--
-- mysql> CREATE USER demo@'127.0.0.1' IDENTIFIED BY 'dem0Passw*rd'; -- 계정 생성
-- mysql> GRANT SELECT, INSERT, UPDATE, DELETE, DROP, ALTER ON demo.* TO demo@'127.0.0.1' WITH GRANT OPTION; -- 권한 생성
-- mysql> FLUSH PRIVILEGES;
--

DROP DATABASE IF EXISTS board;
CREATE DATABASE demo DEFAULT CHARSET utf8;

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, ALTER ON `demo`.* TO 'demo'@'%';

USE demo;

DROP TABLE if EXISTS board;
CREATE TABLE board (
    seq bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '일련번호',
    title varchar(200) NOT NULL COMMENT '제목',
    content text NOT NULL COMMENT '내용',
    reg_type ENUM('User','Kafka') NOT NULL DEFAULT 'User' COMMENT '글 분류 : 사용자(User), Kafka(Kafka)',
    reg_name varchar(50) NOT NULL COMMENT '작성자',
    reg_dt datetime NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '등록일시',
    PRIMARY KEY (seq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판';