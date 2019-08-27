<!-- 同步es -->
<template>
  <div>
      <el-button type="primary" @click="sync()" round>同步数据到ES</el-button>
  </div>
</template>

<script>
import { syncBlog} from "../../api/api";
export default {
  data () {
    return {
    };
  },

  components: {},

  computed: {},

  mounted: {},

  methods: {
    sync(){
      syncBlog().then(
        res =>{
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
        }
      )
    }
  }
}

</script>
<style lang='scss' scoped>
</style>
