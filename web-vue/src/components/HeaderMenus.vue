<template>
  
  <div class="header_pa">
    <el-menu
      class="header_panda"
      mode="horizontal"
      background-color="#1E9FFF"
      text-color="#fff"
      active-text-color="#ffd04b"
      router
    > 
      <el-menu-item class="header_index_panda" index="/">散落记忆里的时光</el-menu-item>
  <!--     <el-menu-item index="/">技术</el-menu-item>
      <el-menu-item index="/">技术杂谈</el-menu-item>
      <el-menu-item index="/">生活笔记</el-menu-item>
      <el-menu-item index="/">日志系统</el-menu-item>
      <el-menu-item index="/">我的书单</el-menu-item>
      <el-menu-item index="/">留言板</el-menu-item> -->
      <el-menu-item index="/blog/detail/2">关于我</el-menu-item>
    </el-menu>
  </div>
</template>
<script>
export default {
  name: "HeaderMenus",
  data() {
    return {};
  }
};
</script>

<style scoped>
.header_pa{
  width: 80%;
  margin: auto;
}
.header_index_panda {
  font-size: 22px;
  padding:0;
  text-align: left;
  margin-right: 50px;
  /* right:50px; */
}

/* 
el-menu{
  width: 80%;
  margin: auto;
  overflow: hidden;
} */

</style>
