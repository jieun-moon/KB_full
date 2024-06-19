<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
      <button class="btn btn-primary ms-1" @click="fetchTodoList">
        새로 고침
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col p-3">
      <ul class="list-group">
        <!-- TodoList를 돌면서 todoItem 출력하고 자식에게 props로 todoItem을 전송 -->
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
    <span>완료된 할일: {{ doneCount }}</span>
  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useTodoListStore } from '@/stores/todoList';
// import { inject } from 'vue';
import TodoItem from '@/components/TodoItem.vue';

// App.vue가 provide한 todoList를 inject로 받아옴
const todoListStore = useTodoListStore();
const doneCount = computed(() => todoListStore.doneCount);
const todoList = computed(() => todoListStore.todoList);
const { fetchTodoList } = todoListStore;
</script>
