<template>
  <div>
    <el-menu
      class="header_panda"
      mode="horizontal"
      background-color="#1E9FFF"
      text-color="#fff"
      active-text-color="#ffd04b"
      router
    >
      <el-menu-item class="header_index_panda" index="/named_view">网站首页</el-menu-item>
      <el-menu-item index="/login">技术杂谈</el-menu-item>
      <el-menu-item index="3">生活笔记</el-menu-item>
      <el-menu-item index="4">日志系统</el-menu-item>
      <el-menu-item index="4">我的书单</el-menu-item>
      <el-menu-item index="5">留言板</el-menu-item>
      <el-menu-item index="6">关于我</el-menu-item>

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
.header_index_panda {
  margin-left: 16.7%;
}
.header_search_panda {
  margin-left: 14%;
}
.index-select-button-panda{
   background-color: aqua;

}
</style>
