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
      <el-menu-item class="header_index_panda" index="/index">不完整の旋律博客</el-menu-item>
      <el-menu-item index="#">技术</el-menu-item>
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
  margin-left: 10%;
  font-size: 22px;
  right:50px;
}
el-menu{
   width: 1200px;
  margin: auto;
  overflow: hidden;
}
el-menu::before {
    background: #000 linear-gradient(to left, #4cd964, #5ac8fa, #007aff, #34aadc, #5856d6, #ff2d55);
    content: "";
    height: 5px;
    position: absolute;
    top: 0;
    width: 100%;
}
</style>
