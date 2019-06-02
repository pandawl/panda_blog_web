<!--  -->
<template>
  <div>
    <detail class="detail" :blogid = "blog.blogid"/>
    <Rbox class="rbox"/>
  </div>
</template>

<script>
import detail from "./detail";
import Rbox from '../../components/rbox/Rbox'

export default {
  components: { detail,Rbox },
  props: {
  
  },
  data() {
    return {
        blog: {}
    };
  },
  computed: {},
  watch: {},
  methods: {},
  created() {},
  mounted() {
    this.blog.blog.blogid = this.$route.params.id
    console.this.blog.blogid
},
  beforeCreate() {}, //生命周期 - 创建之前
  beforeMount() {}, //生命周期 - 挂载之前
  beforeUpdate() {}, //生命周期 - 更新之前
  updated() {}, //生命周期 - 更新之后
  beforeDestroy() {}, //生命周期 - 销毁之前
  destroyed() {}, //生命周期 - 销毁完成
  activated() {} //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类
div{
     width: 80%;
 
  margin: auto;
   margin-top: 10px;
  overflow: hidden;

}
.detail{
 width: 72%;
 float: left;
}
</style>