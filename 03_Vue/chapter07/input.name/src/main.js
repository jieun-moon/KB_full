import { createApp } from 'vue';
import App from './App.vue';
// 전역 컴포넌트 등록 방법
// import CheckboxItem from './Components/CheckboxItem.vue'
// createApp(App).component('CheckboxItem', CheckboxItem).mount('#app');
import CheckboxItem from './components/inputName.vue';

createApp(App).mount('#app');
