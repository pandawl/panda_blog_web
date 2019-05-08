<!-- -->
<template>
   <el-menu mode="vertical" :default-active="$route.path"  background-color="#304156" text-color="#bfcbd9" active-text-color="#409EFF">
     <panda-sidebar-item></panda-sidebar-item>
   </el-menu>
</template>

<script>
  import PandaSidebarItem from './PandaSidebarItem'
    export default {
        name: "PandaSidebar",
        data() {
            return {};
        },

        components: {
          PandaSidebarItem
        },

        methods: {}
    }
</script>

<style scoped>

</style>
