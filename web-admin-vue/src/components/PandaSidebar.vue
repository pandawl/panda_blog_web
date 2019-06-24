<!-- -->
<template>
   <el-menu mode="vertical" :default-active="$route.path"  background-color="#304156" text-color="#bfcbd9" active-text-color="#409EFF" :router="true">
     <panda-sidebar-item v-for="item in resource" :key="item.id" :item="item"></panda-sidebar-item>
   </el-menu>
</template>

<script>
  import PandaSidebarItem from './PandaSidebarItem'
    export default {
        name: "PandaSidebar",
        data() {
            return {
              resource:[]
            };
        },
        mounted: function(){
          this.$axios({
            method: "post",
            url: "/panda/resource/list"
          }).then(res =>{
            console.log(res.data.resultJson)
            this.resource = res.data.resultJson
          }).catch()
        },

        components: {
          PandaSidebarItem
        },

    }
</script>

<style scoped>

</style>
