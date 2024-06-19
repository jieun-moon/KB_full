<template>
  <ul>
    <!-- songs를 돌면서 꺼내온 s를 props로 자식에게 전달 -->
    <SongListItem v-for="s in songs" :key="s.id" :song="s" />
  </ul>
  <div>체크된 곡 수: {{ doneCount }}</div>
</template>

<script>
import SongListItem from './SongListItem.vue';
export default {
  name: 'SongList',
  components: {
    SongListItem,
  },
  // App.vue의 songs를 props로 받아옴
  props: ['songs'],
  // provide된 donecount 값을 주입받음
  inject: ['doneCount'],
};
</script>
