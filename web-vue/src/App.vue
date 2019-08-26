<template>
  <div id="app">
    <div class="">
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
  },  mounted() {
     // 创建cnzz统计js
    const script = document.createElement('script');
    script.src = `https://s95.cnzz.com/z_stat.php?id=1277804844&web_id=1277804844`;
    script.language = 'JavaScript';
    script.id='cnzz';
    document.body.appendChild(script)
  },  watch: {
    $route() {
      if (window._czc) {
        let location = window.location;
        let contentUrl = location.pathname + location.hash;
        let refererUrl = "/";
        window._czc.push(["_trackPageview", contentUrl, refererUrl]);
      }
    }
  }

};
</script>

<style scoped>

</style>
