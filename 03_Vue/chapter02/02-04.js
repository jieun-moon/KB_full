const p1 = { name: 'john', age: 20 };
p1 = { name: 'susan', age: 20 };

// 직접 p1을 변경하면 메모리 주소가 변경되기 때문에 오류
console.log(p1);
