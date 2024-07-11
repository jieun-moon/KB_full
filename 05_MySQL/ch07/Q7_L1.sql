-- sqldb 데이터베이스에서 다음 조건을 처리하세요
-- 사용자별로 구매 이력을 출력함 => buytbl과 usertbl 둘다 필요
-- 모든 컬럼을 출력함 => SELECT *
-- 구매 이력이 없는 정보는 출력하지 않음 => INNER JOIN(JOIN)은 두 테이블에 모두 정보가 존재해야 출력된다
-- JOIN 시 보통 테이블의 별칭을 정해준다
-- ON 뒤에는 어떤 컬럼을 기준으로 합쳐줄지를 적어준다
-- OUTER JOIN이 었다면 다 NULL로 나왔음(구매이력이 없기 때문에)

USE sqldb;

SELECT *
FROM buytbl b
INNER JOIN usertbl u
	ON b.userID = u.userID;

-- 앞의 결과에서 userID 가 'JYP' 인 데이터만 출력하세요
-- 앞의 쿼리에서 WHERE절만 추가
-- 어떤 테이블의 userID여도 동일한 결과가 출력된다
SELECT *
FROM buytbl b
INNER JOIN usertbl u
	ON b.userID = u.userID
    WHERE b.userID = 'JYP';

-- sqldb 데이터베이스에서 다음 조건을 처리하세요
-- 각 사용자별로 구매 이력을 출력하세요 => buytbl과 usertbl 둘다 필요
-- 연결 컬럼은 userID로 함 => ON b.userID = u.userID
-- 결과를 userID를 기준으로 오름차순으로 정렬함 => ORDER BY userID
-- 구매 이력이 없는 사용자도 출력하세요 => OUTER JOIN(usertbl 기준)
-- userID, name, prodName, addr, 연락처를 다음과 같이 출력함 => SELECT문에 해당 컬럼 넣기
-- 연락처는 mobile1과 mobile2를 합쳐서 만듦 => CONCAT(u.mobile1, u.mobile2) as '연락처'
SELECT u.userID, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2) as '연락처'
FROM usertbl u LEFT OUTER JOIN buytbl b 
ON b.userID = u.userID
ORDER BY userID;

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력하세요
-- 1) 서브쿼리 생성: IS NULL을 이용하여 전화가 없는 사람을 가져오자(성시경, 윤종신)
SELECT name FROM usertbl WHERE mobile1 IS NULL;
-- 2) NOT IN을 사용하여 해당 범위에 없는 데이터를 가져온다
SELECT * FROM usertbl
WHERE name NOT IN (SELECT name FROM usertbl WHERE mobile1 IS NULL);

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람만 출력하세요
-- 1) 서브쿼리 생성: IS NULL을 이용하여 전화가 없는 사람을 가져오자(성시경, 윤종신)
SELECT name FROM usertbl WHERE mobile1 IS NULL;
-- 2) IN을 사용하여 해당 범위에 있는 데이터를 가져온다
SELECT * FROM usertbl
WHERE name IN (SELECT name FROM usertbl WHERE mobile1 IS NULL);
