<template>
  <div id="app">
      <home/>
  </div>
</template>

<script>
import Home from "./views/Home";

export default {
  name: "App",
  components: {
    Home,

  }
};
</script>

<style>
html,body{
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
