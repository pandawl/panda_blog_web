<!-- 同步es -->
<template>
  <div class="server">
    <div class="top">
      <div class="left">
        <el-card class="box-card">
          <h2>CPU</h2>
          <el-divider></el-divider>
         <el-table
    :data="tableData"
    height="200"
    border
    style="width: 100%">
    <el-table-column
      prop="date"
      label="属性"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="值"
      width="180">
    </el-table-column>
</el-table>
                      
        </el-card>
      </div>
      <div class="right">
        <el-card class="box-card">
          <h2>内存</h2>
          <el-divider></el-divider>
          <P>FDSAF</P>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import { syncBlog } from "../../api/api";
export default {
  data() {
    return {};
  },

  components: {},

  computed: {},

  mounted: {},

  methods: {
    sync() {
      syncBlog().then(res => {
        if (res.data.resultCode == 200) {
          this.$message({
            message: res.data.resultMessage,
            type: "success",
            showClose: true,
            duration: 1000
          });
        } else {
          this.$message({
            message: res.data.resultMessage,
            type: "error",
            showClose: true,
            duration: 1000
          });
        }
      });
    }
  }
};
</script>
<style lang='scss' scoped>
.left {
  width: 48%;
  float: left;
}
.right {
  width: 48%;
  float: right;
}
.box-card {
}
</style>
