-- 현재 서버에 존재하는 데이터베이스 확인
SHOW DATABASES;

-- 현재 데이터베이스를 employees로 설정
USE employees;

-- employees 데이터베이스의 테이블 목록 보기
SHOW TABLES;

-- employees 테이블의 열 목록 출력하기
DESCRIBE employees;

-- titles 테이블의 데이터 출력하기alter
-- 기본 데이터베이스가 설정 안되어있을 경우 employees.titles로 적어줘야 한다
SELECT * FROM titles;

-- employees 테이블에서 first_name 컬럼만 출력하기
SELECT first_name FROM employees;

-- employees 테이블에서 first_name 컬럼, last_name 컬럼, gender 컬럼 출력하기
SELECT first_name, last_name, gender FROM employees;

-- employees 테이블 출력시 이름, 성별, 회사 입사일로 별칭 수정하여 출력하기
-- AS 생략 가능
-- 별칭에 띄어쓰기가 들어가는 경우 반드시 따옴표로 묶어줘야 한다
SELECT first_name AS 이름, gender AS 성별, hire_date AS '회사 입사일' FROM employees;

-- 배포된 sqldb.sql 파일을 이용하여 sqldb 데이터베이스를 구축하세요
USE sqldb;
SELECT * FROM usertbl;

-- usertbl 테이블에서 이름이 '김경호'인 행을 출력하세요
-- WHERE 절 뒤에는 조건이 온다
SELECT name FROM usertbl WHERE name = '김경호';

-- usertbl 테이블에서 생년이 1970이상이고 키가 182이상인 데이터를 출력하세요
-- 조건 두개를 모두 만족해야 하는 경우 AND로 연결해준다
SELECT * FROM usertbl WHERE birthYear>=1970 AND height>=182;

-- usertbl 테이블에서 키가 180~183 범위인 데이터를 출력하세요
-- 범위값을 설정할 경우 BETWEEN '시작값' AND '끝값'을 사용한다
SELECT * FROM usertbl WHERE height BETWEEN 180 and 183;

-- usertbl 테이블에서 주소가 '경남' 또는 '전남' 또는 '경북' 인 데이터를 출력하세요
-- IN으로 값이 해당 범위 안에 있는지 체크해준다
SELECT * FROM usertbl WHERE addr IN ('경남', '전남', '경북');

-- usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력하세요
-- LIKE 뒤에 &를 붙인 문자열을 명시하면 %의 위치에 따라 해당 문자열을 검색 가능
-- 김%: 김으로 시작하는 데이터
-- %김: 김으로 끝나는 데이터
-- %김%: 김이 포함된 데이터
SELECT * FROM usertbl WHERE name LIKE '김%';

-- usertbl에서 김경호 보다 큰 사람들의 이름과 키를 출력하세요
-- 서브쿼리를 이용하여 쿼리를 작성하세요
-- 서브쿼리부터 작성해서 실행해보고 리턴된 값을 확인 후 바깥 쿼리문 작성
SELECT name, height FROM usertbl WHERE height > (SELECT height FROM usertbl WHERE name ='김경호');

-- usertbl을 mdata 의 오름 차순으로 정렬하여 출력하세요
-- ORDER BY 절을 이용해서 정렬을 해준다 ORDER BY 뒤에는 정렬 기준을 넣는다
-- 기본적으로 ORDER BY는 오름차순으로 정렬된다 (ASC 생략)
SELECT * FROM usertbl ORDER BY mdate;

-- usertbl을 mdata 의 내림 차순으로 정렬하여 출력하세요
-- 내림차순으로 변경하기 위해서는 DESC를 맨 뒤에 붙여준다
SELECT * FROM usertbl ORDER BY mdate DESC;

-- usertbl을 height 의 내림차순으로 정렬하고, 동률인 경우 name 의 내림차순으로 정렬하여 출력하세요
-- 정렬 기준이 여러 개인 경우 ,를 이용해서 뒤에 이어 적어준다 (ASC는 생략 가능)
SELECT * FROM usertbl ORDER BY height DESC, name DESC;

-- usertbl의 주소지를 중복없이 오름 차순으로 출력하세요
-- DISTINCT를 사용하면 중복된 데이터를 제거할 수 있다
SELECT DISTINCT addr FROM usertbl ORDER BY addr;

-- 국가 코드가 'KOR'인 도시를 찾아 인구수를 역순으로 표시하세요
-- 작성 순서: SELECT -> FROM -> WHERE -> ORDER BY
USE world;
SELECT * FROM city WHERE CountryCode = 'KOR' ORDER BY population DESC;

-- City 테이블에서 국가코드와 인구수를 출력하라. 
-- 정렬은 국가코드별로 오름차순으로, 동일한 코드(국가) 안에서는 인구 수의 역순으로 표시하세요
SELECT CountryCode, population FROM city 
ORDER BY CountryCode, population DESC;

-- City 테이블에서 국가코드가 'KOR'인 도시의 수를 표시하세요
-- COUNT로 행의 갯수를 셀 수 있다.
-- 선택 컬럼이 바뀌더라도 행의 개수는 동일하다
SELECT COUNT(name) FROM city WHERE CountryCode = 'kor';

-- city 테이블에서 국가코드가 'KOR', 'CHN', 'JPN'인 도시를 찾으세요.
SELECT * FROM city WHERE CountryCode IN('KOR', 'CHN', 'JPN');

-- 국가코드가 'KOR'이면서 인구가 100만 이상인 도시를 찾으세요.
SELECT * FROM city WHERE CountryCode = 'KOR' AND population >= 1000000;

-- 국가코드가 'KOR'인 도시 중 인구수가 많은 순서로 상위 10개만 표시하세요
-- 작성 순서 중 LIMIT가 가장 뒤에 온다. LIMIT로 보여줄 데이터 개수를 제한 가능
SELECT * FROM city WHERE CountryCode = 'KOR' ORDER BY population DESC LIMIT 10;

-- City 테이블에서 국가코드가 'KOR'이고, 인구수가 100만 이상 500만 이하인 도시를 찾으세요
SELECT * FROM city WHERE CountryCode = 'KOR' AND Population BETWEEN 1000000 AND 5000000;






















