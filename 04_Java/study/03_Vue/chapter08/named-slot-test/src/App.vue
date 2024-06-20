<template>
  <div>
    <NoSlotTest />
    <SlotTest />
    <NamedSlotTest />
  </div>
</template>

<script>
import SlotTest from './components/SlotTest.vue';
import NamedSlotTest from './components/NamedSlotTest.vue';

export default {
  name: 'App',
  components: { SlotTest, SlotTest, NamedSlotTest },
};
</script>
