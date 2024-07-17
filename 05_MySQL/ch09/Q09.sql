-- 1. sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl1 을 생성하고, 
-- 자동 생성된 인덱스 목록을 확인하세요
USE sqldb;

CREATE TABLE tbl1(
a INT PRIMARY KEY,
b INT,
c INT
);

-- 해당 테이블에 대한 인덱스를 보여줌
-- PRIMARY KEY 제약조건을 걸면, 해당 속성이 클러스터형 인덱스로 자동 생성됨
SHOW INDEX FROM tbl1;

-- 2. sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl2 를 생성하고,
-- 자동 생성된 인덱스 목록을 확인하세요
CREATE TABLE tbl2(
-- pk는 클러스터형 인덱스 자동 생성, 테이블 당 하나만 생성됨
a INT PRIMARY KEY,
-- UNIQUE는 보조 인덱스 자동 생성, 보조 인덱스는 여러 개 생성 가능
b INT UNIQUE,
c INT UNIQUE,
d INT
);

SHOW INDEX FROM tbl2;

-- 3. sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl3 를 생성하고 ,
-- 자동 생성된 인덱스 목록을 확인하세요
CREATE TABLE tbl3(
	a INT UNIQUE,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
-- UNIQUE 컬럼만 세 개이기 때문에 보조인덱스만 3개 생성됨
SHOW INDEX FROM tbl3;

-- 4. sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl4 를 생성하고 ,
-- 자동 생성된 인덱스 목록을 확인하세요
CREATE TABLE tbl4(
	-- UNIQUE + NOT NULL은 PK와 동일하게 클러스터형 인덱스로 생성된다
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
-- a는 클러스터형 인덱스
-- b, c는 보조형 인덱스

SHOW INDEX FROM tbl4;

-- 5. sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl5 를 생성하고 ,
-- 자동 생성된 인덱스 목록을 확인하세요
CREATE TABLE tbl5(
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT PRIMARY KEY
);
-- 한 테이블에는 무조건 클러스터형 인덱스가 하나만 가능하기 때문에
-- 우선 순위가 높은 PK가 클러스터형 인덱스가 되고
-- 나머지 UNIQUE 값들은 모두 보조형 인덱스가 된다
SHOW INDEX FROM tbl5;

-- 6. testdb에 다음 컬럼 목록을 가지는 usertbl 을 만드세요
-- testdb가 존재하지 않으면 만들어주겠다
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;
-- usertbl이 존재하면 지워주겠다
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
	name VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL,
	addr NCHAR(2) NOT NULL
);
-- 아래 데이터를 추가하고 , 클러스터형 인덱스의 테이블 내용을 확인하세요
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울');

-- primary key인 userid 기준으로 데이터가 정렬되어있다(ABC순)
SELECT * FROM usertbl;

-- 7. ALTER를 사용하여 usertbl 에서 PRIMARY KEY 제약조건을 제거하고
-- name 컬럼에 pk_name 이라는 제약조건명으로 기본키를 설정하세요
-- ALTER TABLE 키워드로 제약조건을 추가하거나 삭제할 수 있다
-- PIRMARY KEY 제약 조건 삭제
ALTER TABLE usertbl DROP PRIMARY KEY;
-- PRIMARY KEY 제약 조건을 name 컬럼에 추가
ALTER TABLE usertbl
	ADD CONSTRAINT pk_name PRIMARY KEY(name);
    
-- 8. usertbl의 내용을 출력하여, 새로운 클러스터형 인덱스를 확인하세요
-- PK가 변경되면서 클러스터형 인덱스도 함께 변경되어 정렬 순서가 name 순으로 변경됨(가나다순)
SELECT * FROM usertbl;