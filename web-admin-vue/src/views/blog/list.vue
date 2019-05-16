<template>
  <div>
    <el-table :data="tableData">
      <el-table-column prop="id" label="序号" width="140"></el-table-column>
      <el-table-column prop="title" label="标题" width="120"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row.id)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getBlogs, deleteBlogById } from "../../api/blog";
export default {
  name: "",

  components: {},

  created(){
    this.getBlogs()
  },
  data() {
    return {
      tableData: []
    };
  },
  methods: {
    getBlogs() {
      getBlogs().then(res => {
        if (res.data.resultCode == 200) {
          this.tableData = res.data.resultJson
        }
      });
    },
    handleDelete(id){
       deleteBlogById({id}).then(res => {
          if (res.data.resultCode == 200) {
           this.$message({
            message: res.data.resultMessage || '删除成功',
            type: "success",
            showClose: true,
            duration: 1000
          });
          this.getBlogs();
        }else {
            this.$message({
            message: res.data.resultMessage || '删除失败，请联系管理员',
            type: "error",
            showClose: true,
            duration: 1000
          });
        }
      }) 
      
    }
  }
};
</script>
 
<style scoped>
</style>