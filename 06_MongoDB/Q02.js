use my_database;

db.users.find();

//자바 스크립트의 문자열이므로 작은따옴표, 큰따옴표 상관 없음
db.users.insert({username: "smith"});
db.users.find();

use tutorial;
//실제 생성은 데이터가 들어갈 때 생김
db.users.insert({username: 'smith'});

//find 안에 매개변수가 없으면 전부 다 보여 달라는 의미
db.users.find();
db.users.insert({username: "jones"})
