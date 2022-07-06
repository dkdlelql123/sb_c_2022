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
 
INSERT INTO article 
SET regDate = NOW(),
updateDate = NOW(),
title = "제목입니당",
`body` = "내용ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ";

 
INSERT INTO article 
SET regDate = NOW(),
updateDate = NOW(),
title = "안녕하세요~",
`body` = "내용ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ";


# 회원테이블 추가
CREATE TABLE `member` (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
);

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

# 게시물 테이블에 회원정보 추가
ALTER TABLE article 
ADD COLUMN memberId INT UNSIGNED NOT NULL AFTER updateDate;

# 기존 게시물 데이터 회원정보 변경
UPDATE article
SET memberID = 2
WHERE memberid = 0;

# 게시판 만들기
CREATE TABLE board(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`code` CHAR(40) NOT NULL UNIQUE COMMENT 'notice:공지사항, free:자유게시판...',
	`name` CHAR(20) NOT NULL UNIQUE COMMENT '게시판 이름',
	delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0:삭제전, 1:삭제',
	delDate DATETIME COMMENT '삭제 날짜'
);

# 기본 게시판 생성
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지사항';

# 기본 게시판 생성
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free',
`name` = '자유게시판';


# 게시물 테이블에 게시판id 추가하기
ALTER TABLE article ADD COLUMN boardId INT NOT NULL AFTER updateDate;

# 1, 3번은 자유게시판
UPDATE article
SET boardId = 2
WHERE id IN (1,3);

# 2 번은 공지사항
UPDATE article
SET boardId = 1
WHERE id = 2;
 
# 페이징을 위한 게시물 대량 생성
/*
insert into article
(
    regDate, updateDate, memberId, boardId, title, `body`
)
select now(), now(), FLOOR(RAND() * 2) + 1, FLOOR(RAND() * 2) + 1, concat('제목_', rand()), CONCAT('내용_', RAND())
from article;

select * FROM `article`;

*/

# 게시물에 조회수 칼럼 추가
ALTER TABLE `article`
ADD COLUMN hit INT(10) UNSIGNED NOT NULL DEFAULT 0;

# 좋아요, 싫어요 리액션포인트 테이블 생성
CREATE TABLE reactionPoint (
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	relCodeType CHAR(30) NOT NULL COMMENT '관련데이터타입코드',
	relId INT(10) UNSIGNED NOT NULL COMMENT '관련데이터코드',
	`point` SMALLINT(2)
);

# 리액션포인트 테스트 데이터 생성
INSERT INTO reactionPoint 
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
relCodeType = 'article',
relId = 1,
`point` = 1;

# 리액션포인트 테스트 데이터 생성
INSERT INTO reactionPoint 
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
relCodeType = 'article',
relId = 1,
`point` = 1;

# 리액션포인트 테스트 데이터 생성
INSERT INTO reactionPoint 
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
relCodeType = 'article',
relId = 2,
`point` = 1;

# 리액션포인트 테스트 데이터 생성
INSERT INTO reactionPoint 
SET regDate = NOW(),
updateDate = NOW(),
memberId = 3,
relCodeType = 'article',
relId = 2,
`point` = -1;

# 리액션포인트 테스트 데이터 생성
INSERT INTO reactionPoint 
SET regDate = NOW(),
updateDate = NOW(),
memberId = 3,
relCodeType = 'article',
relId = 1,
`point` = -1;

