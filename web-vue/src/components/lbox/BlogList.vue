<template>
  <div>
 <div class="whitebg bloglist">
      <h2 class="htitle">最新博文</h2>
      <ul>
        
        
        <!--单图-->
       <li v-for="blog in blogs" :key="blog.id" :blogDetail="blog">
          <h3 class="blogtitle"><router-link :to="`/blog/detail/${blog.id}`" >{{blog.title}}</router-link></h3>
          <span class="blogpic imgscale"><i><a href="/">{{blog.categoryName}}</a></i><a href="/" title=""><img src="../../../static/images/b01.jpg" :alt="blog.title"></a></span>
          <p class="blogtext">{{blog.summary}}... </p>
          <p class="bloginfo"><i class="avatar"><img src="images/avatar.jpg"></i><span>panda</span><span>{{blog.updateTime}}</span><span>【<a href="/">{{blog.categoryName}}</a>】</span></p>
          <a href="/" class="viewmore">阅读更多</a> </li>


  
      </ul>
      <!--pagelist-->
      <div class="pagelist"><a title="Total record">&nbsp;<b>67</b> </a>&nbsp;&nbsp;&nbsp;<b>1</b>&nbsp;<a href="/download/index_2.html">2</a>&nbsp;<a href="/download/index_3.html">3</a>&nbsp;<a href="/download/index_2.html">下一页</a>&nbsp;<a href="/download/index_3.html">尾页</a></div>
      <!--pagelist end--> 
    </div>
  </div>
</template>

<script>
import {getList} from '../../api/blog'
export default {
  name: "",

  components: {},
  props: {},
  data() {
    return {
      blogs: [],
      blogDetail: {}
    };
  },
  mounted(){
    getList().then(
      res=>{
        this.blogs = res.data.resultJson
      }
    )
  }

};
</script>
 
<style scoped>

.bloglist{
   float: left;
   width: 96%;
 }
</style>
