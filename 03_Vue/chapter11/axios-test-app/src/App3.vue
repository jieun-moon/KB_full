<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

// await를 쓰기 위해서는 함수 앞에 async를 붙여줌
const requestAPI = async () => {
  let todoList;

  // 전체 리스트 데이터 출력
  // get을 할 때는 데이터를 가져오고 다음 문장이 실행되어야 하므로 await를 붙여줌
  let response = await axios.get(listUrl);
  todoList = response.data;
  console.log('# TodoList: ', todoList);
  // 리스트의 길이만큼 돌면서 각각의 리스트 데이터 출력
  for (let i = 0; i < todoList.length; i++) {
    response = await axios.get(todoUrlPrefix + todoList[i].id);
    console.log(`# ${i + 1}번째 Todo: `, response.data);
  }
};

requestAPI();
</script>
