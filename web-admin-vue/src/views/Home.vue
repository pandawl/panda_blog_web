<template>

  <div>
    <panda-sidebar class="sidebar-container"/>
    <panda-header class="main-container"/>

  </div>
</template>

<script>
  import PandaHeader from '../components/PandaHeader'
  import PandaSidebar from '../components/PandaSidebar'

  export default {
    name: "Home",
    components: {
      PandaHeader,
      PandaSidebar
    }
  }
</script>

<style scoped>

</style>
