<script setup>
import Header from './Header.vue';
import Navbar from './Navbar.vue';
import Footer from './Footer.vue';
</script>

<template>
  <div class="container">
    <Header />
    <Navbar />
    <div class="content my-5 px-3">
      <!-- 부모 컴포넌트에게 정보를 받아와서 해당 위치에 렌더링한다 -->
      <slot></slot>
    </div>
    <Footer />
  </div>
</template>
