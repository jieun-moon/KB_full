<template>
  <div class="container">
    <Header />
    <!-- 계속 페이지가 바뀌는 부분이 router-view -->
    <router-view />
    <Loading v-if="states.isLoading" />
  </div>
</template>

<script setup>
// script setup 키워드 사용시 components 따로 등록할 필요 없음
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
import Loading from '@/components/Loading.vue';
import axios from 'axios';

const BASEURI = '/api/todos';
const states = reactive({ todoList: [] });

const states = reactive({
  todoList: [
    { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
    { id: 2, todo: 'React학습', desc: '설명2', done: false },
    { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
    { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
  ],
});

// todo를 추가하는 메소드, todo와 desc가 들어있는 객체를 구조 분해 할당으로 받음
const addTodo = async ({ todo, desc }, successCallback) => {
  states.isLoading = true;
  // todoList의 맨 뒤에 새로운 객체 추가
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  // states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
  states.isLoading = false;
};

// todo를 수정하는 메소드, 해당 id의 todo를 찾아서 todo, desc, done 값을 업데이트
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  states.isLoading = true;
  // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
  try {
    const payload = { id, todo, desc, done };
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert('Todo 변경 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  // 찾아온 todo의 값을 그대로 펼친 후 todo, desc, done 값을 업데이트해서 다시 대입
  // states.todoList[index] = { ...states.todoList[index], todo, desc, done };
  states.isLoading = false;
};

// todo를 삭제하는 메소드, 해당 id의 todo를 찾아서 삭제
const deleteTodo = async (id) => {
  states.isLoading = true;
  try {
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

// todo의 done을 true -> false, false -> true로 변경해주는 메소드
const toggleDone = async (id) => {
  states.isLoading = true;
  try {
    let todo = states.todoList.find((todo) => todo.id === id);
    let payload = { ...todo, done: !todo.done };
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert('Todo 완료 변경 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
  // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
  // 해당 todo의 done 값을 반대로 바꿔줌
  // states.todoList[index].done = !states.todoList[index].done;
};

// TodoList 목록을 조회합니다.
const fetchTodoList = async () => {
  states.isLoading = true;
  try {
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert('데이터 조회 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

// provie로 하위 컴포넌트에서 사용 가능하도록 제공해줌
provide(
  'todoList',
  // computed로 감싸주면 반응성과 읽기전용 유지
  computed(() => states.todoList)
);
provide('actions', {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});

fetchTodoList();
</script>
