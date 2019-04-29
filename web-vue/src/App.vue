<template>
  <div id="app">
    
    <header-menus v-show="!$route.meta.showLogin"/>
    <router-view/>
   <footer-menus/>
  </div>
</template>

<script>
import HeaderMenus from './components/HeaderMenus.vue'
import FooterMenus from './components/Footer.vue'
export default {
  name: "App",
  components: {
    HeaderMenus,
    FooterMenus
  }
};
</script>

<style>

</style>
