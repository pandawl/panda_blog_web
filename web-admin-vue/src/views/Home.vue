<template>
  <el-container style="height: 100vh; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: #a7b1c2">
      <el-menu router  :default-openeds="openeds">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-folder"></i>博客管理
          </template>

          <el-menu-item index="/blog/list">博客列表</el-menu-item>
          <el-menu-item index="/blog/edit">博客管理</el-menu-item>

          <el-menu-item index="/blog/tags">标签管理</el-menu-item>

          <el-menu-item index="/blog/categorys">分类管理</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-s-tools"></i>系统管理
          </template>

            <el-menu-item index="/blog/img">图片上传</el-menu-item>
            <el-menu-item index="/blog/sync">数据同步</el-menu-item>
            <el-menu-item index="/blog/server">服务监控</el-menu-item>

        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">

            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span class="name">散落记忆里的时光</span>
      </el-header>

      <el-main>
     
          <router-view></router-view>
      
    
      </el-main>
    </el-container>
  </el-container>
</template>


<style>

.el-header {
 background-color: #409eff;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
.name{
  font-size: 20px;
  color: rgb(206, 17, 174);
}
</style>

<script>
export default {
  data() {
    return {
      openeds: ['1'],
      uniqueOpened: false
    };
  },

  methods: {

  }
};
</script>
