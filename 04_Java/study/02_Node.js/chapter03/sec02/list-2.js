const fs = require('fs');

// fs.readdir: 비동기로 폴더를 읽어온다.
// 안쪽 콜백함수에서 files를 처리해서 let files를 할 필요 없음.
fs.readdir('./', (err, files) => {
  // 만약, 없는 파일 명'./ff'을 넣는다면, 에러.
  if (err) {
    console.error(err);
    // return을 만나면 함수 종료
    return;
  }
  console.log(files);
});
