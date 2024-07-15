-- 다음 컬럼을 가지는 userTBL 과 buyTBL 을 정의하세요
-- 기존에 테이블이 존재하면 삭제함
DROP TABLE if exists userTBL;

CREATE TABLE usertbl(
userID CHAR(8) NOT NULL,
name VARCHAR(10) NOT NULL,
birthYear INT NOT NULL,
CONSTRAINT primary key PK_userTBL_userID(userID)
);

DROP TABLE IF EXISTS buyTBL;

CREATE TABLE buytbl(
num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
userID VARCHAR(8) NOT NULL,
prodName VARCHAR(6) NOT NULL,
FOREIGN KEY(userID) REFERENCES userTBL(userid)
);

-- 다음 조건을 만족하는 userTBL 테이블을 정의하세요
-- 기존 buyTBL, userTBL을 삭제하세요
