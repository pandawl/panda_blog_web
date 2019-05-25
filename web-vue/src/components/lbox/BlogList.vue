<template>
  <div>
 <div class="whitebg bloglist">
      <h2 class="htitle">最新博文</h2>
      <ul>
        
        
        <!--单图-->
        <li>
          <h3 class="blogtitle"><a href="/" target="_blank">【个人博客网站制作】自己不会个人博客网站制作，你会选择用什么博客程序源码？</a></h3>
          <span class="blogpic imgscale"><i><a href="/">原创模板</a></i><a href="/" title=""><img src="../../../static/images/b01.jpg" alt=""></a></span>
          <p class="blogtext">这些开源的博客程序源码，都是经过很多次版本测试的，都有固定的使用人群。我所知道的主流的博客程序有，Z-blog，Emlog，WordPress，Typecho等，免费的cms系统有，织梦cms（dedecms），phpcms，帝国cms（EmpireCMS）！... </p>
          <p class="bloginfo"><i class="avatar"><img src="images/avatar.jpg"></i><span>杨青青</span><span>2018-10-28</span><span>【<a href="/">原创模板</a>】</span></p>
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
    return {};
  },
  mounted(){
    getList()
  }

};
</script>
 
<style scoped>

.bloglist{
   float: left;
 }
</style>
