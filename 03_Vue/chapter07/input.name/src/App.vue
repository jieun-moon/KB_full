<template>
  <div>
    <!-- 자식 컴포넌트에서 정의한 nameChanged 이벤트를 nameChangedHandler 함수와 연결 -->
    <!-- (사용자 정의 이벤트) -->
    <inputName @nameChanged="NameChangedHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>

<script>
// 지역 컴포넌트 등록 방법 (사용할 파일에서만 명시)
import InputName from './components/inputName.vue';
export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    NameChangedHandler(e) {
      // 받아온 객체 안에 있는 name을 접근해서 data에 있는 paretName에 넣어줌
      this.parentName = e.name;
    },
  },
};
</script>
