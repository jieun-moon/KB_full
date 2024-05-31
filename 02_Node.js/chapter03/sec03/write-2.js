fs = require('fs');

const data = fs.readFileSync('./chapter03/sec03/example.txt', 'utf8');

// fs.exitsSync: 해당 파일이 존재하는지 여부를 boolean으로 반환
if (fs.exitsSync('text-1.txt')) {
  //text-1.txt 파일이 있다면
  console.log('file already exist');
} else {
  //text-1.txt 파일이 없다면
  fs.writeFileSync('./chapter03/sec03/text-1.txt', data);
}
fs.writeFileSync('./chapter03/sec03/text-1.txt', data);
