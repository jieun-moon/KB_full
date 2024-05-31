let msg = 'GLOBAL';
function outer() {
  // 스코프 내에서 가장 가까이 있는 변수 값을 먼저 찾는다.
  // 같은 스코프 내에 변수가 없으면 더 넓은 스코프로 이동
  let msg = 'OUTER';
  console.log(msg); //OUTER
  if (true) {
    //무조건 참인 if문
    let msg = 'BLOCK';
    console.log(msg); //BLOCK
  }
}

outer();
