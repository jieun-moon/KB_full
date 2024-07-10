USE employees;

SELECT * FROM employees
-- binary 레벨에서 비교해라
-- 정확하게 대소문자가 맞아야 참으로 간주
WHERE binary(first_name) = 'Georgi';

USE world;
select * from city
WHERE countrycode = 'kor'
order by population desc;

-- 우리나라에서 제주의 인구수보다 작은 도시를 찾아
-- 인구수를 내림차순으로 도시명, 인구수를 출력하세요
SELECT name, population from city
WHERE countrycode = 'kor' and population < (SELECT population
FROM city
WHERE id = '2358')
ORDER BY population desc;

USE employees;
CREATE TABLE users
(SELECT first_name as name, gender from employees);

select * from users;

USE world;
SELECT * FROM city
WHERE countrycode = 'kor';

CREATE TABLE kor_city
(SELECT id, name, district, population FROM city
WHERE countrycode = 'kor');

SELECT * FROM kor_city;

-- WORLD에서 국가별 총 인구수를 출력하라
-- city table을 쓸것
-- ~별: GROUP BY 하라

SELECT * FROM city;

SELECT countrycode, sum(population) AS '인구수' FROM city
GROUP BY countrycode
HAVING sum(population) > 1000000
-- 별칭으로는 정렬이 되지 않음
-- 집계 함수를 정렬할 떄는 집계함수를 그대로 표현해줘야 함
ORDER BY sum(population) desc;
-- 우리나라만 보고 싶으면 WHERE 절을 사용해야함
-- WHERE 절은 GROUPING 하기 전에 적용
-- filtering 먼저 하고 그다음 grouping 적용
-- 그룹핑 이후의 조건 검사는 HAVING으로 
-- 인구수가 1역명 이상인 나라를 찾고 싶다







