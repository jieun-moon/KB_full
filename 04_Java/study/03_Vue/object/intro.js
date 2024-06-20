let human = {
  name: '김상형',
  age: 29,
  //   객체 내의 함수를 메소드라고 한다.
  intro: function () {
    console.log('name = ' + this.name);
    console.log('age = ' + this.age);
  },
};
// 메소드를 호출할 때도 객체 먼저 접근한다.
human.intro();
