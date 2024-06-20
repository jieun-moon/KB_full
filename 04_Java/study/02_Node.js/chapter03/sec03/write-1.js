fs = require('fs');

const data = fs.readFileSync('./chapter03/sec03/example.txt', 'utf8');
// fs.readFileSync: 동기로 파일 쓰기
fs.writeFileSync('./chapter03/sec03/text-1.txt', data);
