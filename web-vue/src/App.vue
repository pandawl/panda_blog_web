<template>
  <div id="app">
    <header-menus/>
    <router-view/>
  </div>
</template>

<script>
import HeaderMenus from './components/HeaderMenus.vue'
export default {
  name: "App",
  components: {
    HeaderMenus
  }
};
</script>

<style>

</style>
