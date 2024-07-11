USE sakila;

-- SELECT a.*: a 테이블의 모든 걸 다 출력해라
-- N:M 관계 표현: 카테고리 정보
SELECT a.first_name, a.last_name, f.title
FROM film f 
	INNER JOIN film_actor fa
	ON f.film_id = fa.film_id
	INNER JOIN actor a
    ON fa.actor_id = a.actor_id
ORDER BY f.title;