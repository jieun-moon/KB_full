import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import TodoList from '@/pages/TodoList.vue';
import AddTodo from '@/pages/AddTodo.vue';
import EditTodo from '@/pages/EditTodo.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/about',
      component: About,
    },
    {
      path: '/todos',
      component: TodoList,
    },
    {
      path: '/todos/add',
      component: AddTodo,
    },
    {
      // 바뀌는 값엔 :붙이기
      // 존재하지 않는 사이트라고 오류 뜰때 index.js 확인하기
      path: '/todos/edit/:id',
      component: EditTodo,
    },
    {
      path: '/:paths(.*)*',
      component: NotFound,
    },
  ],
});

export default router;
