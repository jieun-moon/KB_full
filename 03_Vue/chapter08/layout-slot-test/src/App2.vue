<template>
  <div>
    <CheckBoxList />
    <ScopedSlotTest />
  </div>
</template>

<script>
import ScopedSlotTest from './components/ScopedSlotTest.vue';
import CheckBoxList from './components/CheckBoxList.vue';
export default {
  name: 'App2',
  // components 적용 안되는 건 script script 뿐임
  components: { ScopedSlotTest, CheckBoxList },
};
</script>
