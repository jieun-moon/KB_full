<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// const listUrl = '/api/todos';
// const todoUrlPrefix = '/api/todos/';

// await를 쓰기 위해서는 함수 앞에 async를 붙여줌
const requestAPI = async () => {
  const url = '/api/todos';
  const response = await axios.get(url);
  console.log('# 응답객체 : ', response);
};

requestAPI();
</script>
