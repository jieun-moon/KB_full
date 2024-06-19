// import, export 키워드 사용하기 위해서는
// 1) 확장자를 mjs로 사용하거나,
// 2) package.json에 "type":"module" 설정 추가할 것
import getBase, { add } from './modules/02-20-module.js';

console.log(add(4));
// default 키워드로 가져온 함수는 이름을 마음대로 지정 가능
console.log(getBase(4));

// console.log(getBase());
// 한개만 디폴트 할 수 있기 때문에 이름이 무엇이든지 상관없다.
