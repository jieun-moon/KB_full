<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  let todoList = [];
  // 해당 url에 있는 데이터를 가져와서 전체 리스트 출력
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      console.log('# TodoList: ', todoList);
      return todoList[0].id;
    })
    // 받아온 첫번재 todo의 아이디로 데이터 가져오기
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    })
    // 받아온 데이터로 출력 후 두번째 todo 아이디 리턴
    .then((response) => {
      console.log('## 첫번째 Todo: ', response.data);
      return todoList[1].id;
    })
    // 두번째 todo 아이디로 데이터 받아와서 출력
    .then((id) => {
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두번째 Todo : ', response.data);
      });
    });
};

requestAPI();
</script>
