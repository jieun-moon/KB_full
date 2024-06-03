<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// await를 쓰기 위해서는 함수 앞에 async를 붙여줌
const requestAPI = async () => {
  const url = '/api/todos2';
  axios
    .get(url, { timeout: 900 })
    // API 호출에 성공했을 경우
    .then((response) => {
      // API 호출에 실패했을 경우
      console.log('# 응답객체: ', response);
    })
    .catch((e) => {
      console.log('에러===================');
      console.log(e);
      if (e instanceof Error) console.log(e.message);
      else console.log(e);
    });
};

requestAPI();
</script>
