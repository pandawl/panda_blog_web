<template>
  <div id="app">
    <div class="header-menus">
      <header-menus/>
    </div>
    
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
  },
  
};
</script>

<style scoped>
.header-menus{
  background: rgb(30, 159, 255);
  margin-top:5px; 
  height: 60px;
}
#app::before {
    background: #000 linear-gradient(to left, #4cd964, #5ac8fa, #007aff, #34aadc, #5856d6, #ff2d55);
    content: "";
    height: 5px;
    position: absolute;
    top: 0;
    width: 100%;
}
</style>
