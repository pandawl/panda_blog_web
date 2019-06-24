<template>
  <div id="app">
    <home v-if="isReload"/>
  </div>
</template>

<script>
import Home from "./views/Home";

export default {
  name: "App",
  data(){
    return {
      isReload: true
    }
  },
  provide() {
    return {
      reload: this.reload
    };
  },

  methods:{
     reload() {
      this.isReload = false;
      this.$nextTick(function() {
        this.isReload = true;
      });
    }
   },
  components: {
    Home,

  }
};
</script>

<style>
html,
body {
  padding: 0;
  margin: 0;
}
.icon {
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}
</style>
