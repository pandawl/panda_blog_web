<template>
     <div class="whitebg paihang">
      <h2 class="htitle">点击排行</h2>
      <section class="topnews imgscale"><a href="https://cuiqingcai.com/" target="_blank"><img src="../../../static/images/h1.jpg"><span>崔庆才博客</span></a></section>
      <ul>
        <li  v-for="blog in blogs" :key="blog.id"><i></i> <router-link :to="`/blog/detail/${blog.id}`">{{blog.title}}</router-link></li>   
      </ul>
    </div>
</template>

<script>
import { getList } from "../../api/blog";
export default {
   name: '',
    
  components:{},
  props:{},
  data(){
    return {
      blogs:[],
    }
  }, mounted() {
     getList(1, 8).then(res => {   
      this.blogs = res.data.resultJson.list;
    });
  }

}
</script>
 
<style scoped>
 
</style>