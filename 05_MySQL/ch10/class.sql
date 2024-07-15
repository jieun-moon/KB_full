SELECT * FROM buytbl;

START TRANSACTION;
DELETE FROM buytbl WHERE num = 1;
DELETE FROM buytbl WHERE num = 2;

SELECT * FROM buytbl;

ROLLBACK;

SELECT @@autocommit; -- @@은 mysql의 환경 변수

-- 데이터베이스 생성
CREATE DATABASE jdbc_ex;

-- %: 접속 ip. 어디서든지 가능하다(접속한 컴퓨터는 신경쓰지 않겠다)
-- ROOT: LOCAL HOST로만 접속가능하게 돼 있음
-- jdbc_ex.*에 있는 모든 것 
-- CREATE USER: 'jdbc_ex'라는 이름의 사용자 생성
-- IDENTIFIED BY: 비밀번호를 'jdbc_ex'로 설정
CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex';
-- GRANT ~ on: 권한 부여하는 명령어
-- ALL PRIVILEGES: 모든 권한 부여
-- 'jdbc_ex'라는 사용자에게 jdbc_ex 데이터베이스 내의 모든 권한 부여
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%';
-- 권한 즉시 서버에 적용
FLUSH PRIVILEGES;

DROP USER 'jdbc_ex'@'%';
SHOW GRANTS FOR 'jdbc_ex'@'%';

CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex';
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%';

FLUSH PRIVILEGES;

SELECT user, host FROM mysql.user WHERE user = 'jdbc_ex';


