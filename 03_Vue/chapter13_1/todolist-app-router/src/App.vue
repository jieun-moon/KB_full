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
import { computed } from 'vue';
import Header from '@/components/Header.vue';
import Loading from '@/components/Loading.vue';
import { useTodoListStore } from './stores/todoList';
// import axios from 'axios';

const todoListStore = useTodoListStore();
const isLoading = computed(() => todoListStore.isLoading);
const fetchTodoList = todoListStore.fetchTodoList;
fetchTodoList();
</script>
