<template>
  <div>
    <h2>최신 인기곡</h2>
    <!-- songs를 props로 SongList에게 넘겨줌 -->
    <SongList :songs="songs" />
  </div>
</template>

<script>
import { computed } from 'vue';
import SongList from './components/SongList.vue';

export default {
  name: 'App',
  components: { SongList },
  data() {
    return {
      // 노래 목록이 들어있는 객체 배열
      songs: [
        { id: 1, title: 'Blueming', done: true },
        { id: 2, title: 'Dynamite', done: true },
        { id: 3, title: 'Lovesick Girls', done: false },
        { id: 4, title: '마리아(Maria)', done: false },
      ],
    };
  },
  // provide: 하위 컴포넌트에 속성이나 함수를 전달할 수 있음
  // 부모 컴포넌트에서 제공해야함
  provide() {
    return {
      icons: {
        checked: 'far fa-check-circle',
        unchecked: 'far fa-circle',
      },
      // filter: 현재 노래 목록에서 done이 true인 항목을 리스트로 반환 => 1번, 2번 항목
      // length: 필터링된 항목이 들어있는 배열의 길이 => 2
      doneCount: computed(() => {
        return this.songs.filter((s) => s.done === true).length;
      }),
    };
  },
};
</script>

<style>
/* fontAwesome 아이콘을 사용하기 위해 해당 CSS가져옴 */
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css');
</style>
