<template>
  <div>
    <!-- icon이라는 이름의 슬롯을 받아옴 -->
    <slot name="icon"></slot>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- label이라는 이름의 슬롯을 받아옴 -->

    <slot name="label">Item</slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBox2',
  props: ['id', 'checked', 'label'], //부모 컴포넌트로부터 받을 속성들
};
</script>
