<template>
  <!-- 모듈로 등록한 스타일은 style 내에 저장됨 -->
  <div :class="$style.child">
    <h2>Child3</h2>
  </div>
</template>

<script>
export default {
  name: 'Child3',
  created() {
    console.log(this.$style);
  },
};
</script>

<!-- 모듈을 붙이면 스타일을 객체처럼 사용 가능 -->
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
