<template>
  <div id="app">

    <router-view/>
  </div>
</template>

<script>

  export default {
    name: "App",

  };
</script>

<style>
  #app .app-router-view{
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    overflow: hidden;
    backface-visibility: hidden;
    transform: translate3d(0,0,0);
    transform-style: preserve-3d;
    visibility: visible;
  }
  .icon {
    width: 1em; height: 1em;
    vertical-align: -0.15em;
    fill: currentColor;
    overflow: hidden;
  }

</style>
