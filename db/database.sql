# DB생성
DROP DATABASE IF EXISTS sb_c_2022;
CREATE DATABASE sb_c_2022;
USE sb_c_2022;

# 게시물 테이블 생성
CREATE TABLE article(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL	
);

# 게시물, 테이스 데이터 생성
INSERT INTO article 
SET regDate = NOW(),
updateDate = NOW(),
title = "제목",
`body` = "내용";

# 회원테이블 추가
CREATE TABLE `member` (
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(20) NOT NULL,
	loginPw CHAR(40) NOT NULL,
	`name` CHAR(20) NOT NULL,
	nickname CHAR(20) NOT NULL,
	email CHAR(50) NOT NULL,
	phoneNumber CHAR(20) NOT NULL,
	authLevel SMALLINT(2) NOT NULL,
	delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0:탈퇴전/1:탈퇴',
	delDate DATETIME COMMENT '탈퇴날짜'
)

# 관리자 회원 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
`name` = '관리자',
nickname = '내가 관리자',
email = '관리자@naver.com',
phoneNumber = '010-1111-1111',
authLevel = 10;
	
# 테스트 회원 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`name` = '사용자1 이름',
nickname = '사용자1 별명',
email = '사용자1@naver.com',
phoneNumber = '010-1111-1111',
authLevel = 2;	 

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = 'user2',
`name` = '사용자2 이름',
nickname = '사용자2 별명',
email = '사용자2@naver.com',
phoneNumber = '010-1111-1111',
authLevel = 2;	
