-- scoula_db라는 이름의 db 생성
create database scoula_db;
-- id가 'scoula'고 패스워드가 '1234'인 user 생성
create user 'scoula'@'%' identified by '1234';
-- 'scoula'에게 'scoula_db' 전체에 대한 모든 권한을 주겠다
grant all privileges on scoula_db.* to 'scoula'@'%';

DROP DATABASE scoula_db;

DROP USER IF EXISTS 'scoula'@'%';
CREATE USER 'scoula'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON scoula_db.* TO 'scoula'@'%';
