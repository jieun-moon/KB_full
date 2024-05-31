import { createRouter, createWebHistory } from 'vue-router';
// ../와 @/ 모두 src 폴더 내를 가리킴
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      // name: 'home', //name 속성은 핈수가 아니다.

      component: Home,
    },
    // Homeview: 무조건 로딩되어야 하는 페이지이기 때문에 정적으로 처리
    {
      path: '/about',
      // name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // 해당 경로가 방문됐을 때만 로딩되게 만들어둠, 화살표 함수 처리
      // component: () => import('../views/AboutView.vue'),
      component: About,
    },
    {
      path: '/members',
      component: Members,
    },
    {
      path: '/videos',
      component: Videos,
    },
    // AboutView: 필요할 때만 처리가 되도록
  ],
});

// router 만든 후 내보내기
export default router;
