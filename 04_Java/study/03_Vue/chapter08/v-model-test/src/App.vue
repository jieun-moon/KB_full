<template>
  <!-- 자식의 name을 searchName으로 전달하고 다시 자식의 변경값을 받아옴 -->
  <!-- <InputName :name="searchName" @update:name="changeSearchName" /> 아래 코드로 생략 가능 -->
  <div>
    <InputName v-model:name="searchName" />
    <h3>검색어: {{ searchName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';

export default {
  name: 'App',
  // components 적용 안되는 건 script script 뿐임
  components: { InputName },
  data() {
    return { searchName: 'John' };
  },
  // v-model로 양방향 바인딩시 생략 가능
  methods: {
    changeSearchName(name) {
      console.log(name);
      this.searchName = name;
    },
  },
};
</script>
<style></style>
