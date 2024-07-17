USE sakila;

SELECT * FROM actor_info;

SELECT * FROM buytbl;

-- GROUP_CONCAT
SELECT userID, sum(amount)FROM buytbl GROUP BY userID;
-- 구매 목록이 보고싶을 때
SELECT userID, GROUP_CONCAT(prodName SEPARATOR ', ') FROM buytbl GROUP BY userID;
