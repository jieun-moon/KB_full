-- USE: 기본 데이터베이스 설정
USE sqldb;

-- CREATE TABLE: 테이블 생성
CREATE TABLE stdtbl (
stdName VARCHAR(10) NOT NULL PRIMARY KEY,
addr CHAR(4) NOT NULL
);
-- NOT NULL: NULL이 될 수 없다
-- PRIMARY KEY: 기본키(식별자), 중복되지 않고 NULL이 될 수 없다
CREATE TABLE clubtbl (
clubName VARCHAR(10) NOT NULL PRIMARY KEY,
roomNo CHAR(4) NOT NULL
);

CREATE TABLE stdclubtbl(
num int AUTO_INCREMENT NOT NULL PRIMARY KEY,
stdName VARCHAR(10) NOT NULL,
clubName VARCHAR(10) NOT NULL,
FOREIGN KEY (stdName) REFERENCES stdtbl(stdName),
FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

-- INSERT INTO 테이블명 VALUES 실제 값들: 테이블의 컬럼들에 실제 값들을 추가함(행 추가)
INSERT INTO stdtbl VALUES ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'),('바비킴','서울');
INSERT INTO clubtbl VALUES ('수영', '101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');
INSERT INTO stdclubtbl
VALUES (NULL, '김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'),
(NULL, '은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');
