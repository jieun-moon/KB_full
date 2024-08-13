-- sqldb에서 usertbl 테이블에서 다음 내용들을 확인하세요
USE sqldb;

CREATE TABLE `usertbl` (
  `userID` char(8) NOT NULL PRIMARY KEY,
  `name` varchar(10) NOT NULL,
  `birthYear` int NOT NULL,
  `addr` char(2) NOT NULL,
  `mobile1` char(3) DEFAULT NULL,
  `mobile2` char(8) DEFAULT NULL,
  `height` smallint DEFAULT NULL,
  `mDate` date DEFAULT NULL
  );
  
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');

SELECT * FROM usertbl;
-- usertbl의 인덱스 목록 확인
SHOW INDEX FROM usertbl;
-- usertbl의 데이터 크기와 인덱스 크기 확인
SHOW TABLE STATUS LIKE 'usertbl';

-- usertbl의 addr 컬럼에 대해 idx_usertbl_addr 이름으로 인덱스를 만들고 인덱스 목록을 확인하세요
CREATE INDEX idx_usertbl_addr
ON usertbl(addr);

SHOW INDEX FROM usertbl;

-- usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인하고 
-- 내용이 없다면 실제 적용되도록 한 후 , 인덱스의 크기를 확인하세요
SHOW TABLE STATUS LIKE 'usertbl';

-- 생성한 인덱스를 실제로 적용하기 위해서 ANALYZE로 테이블을 분석하고 처리해줘야함
ANALYZE TABLE usertbl;
-- INDEX_length가 0이었는데 분석 후 제대로 나오는 걸 볼 수 있다
SHOW TABLE STATUS LIKE 'usertbl';

-- 출생년도(birthYear)에 보조 인덱스 생성
-- 범수랑 시경이 생일이 둘다 1979이므로 중복값 때문에 인덱스 생성 에러 발생
CREATE UNIQUE INDEX idx_usertbl_birthYear
ON usertbl(birthYear);

-- 이름(name)에 보조 인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_name
ON usertbl(name);

SHOW INDEX FROM usertbl;

-- 이름(name)에 보조 인덱스 삭제
DROP INDEX idx_usertbl_name ON usertbl;

-- name, birthYear 조합으로 인덱스 생성
-- 컬럼 조합시 , 로 이어서 넣어준다
-- 여러 개의 컬럼으로 인덱스를 만들 경우 각 컬럼당 한 행이 추가된다
CREATE UNIQUE INDEX idx_usertbl_name_birthYear
ON usertbl(name, birthYear);

SHOW INDEX FROM usertbl;

ALTER TABLE usertbl
ADD PRIMARY KEY(userID);

-- 인덱스 삭제(DROP INDEX 또는 ALTER TABLE 구문으로 둘 다 가능)
DROP INDEX idx_usertbl_addr ON usertbl;
ALTER TABLE usertbl DROP INDEX idx_usertbl_name_birthYear;

SHOW INDEX FROM usertbl;