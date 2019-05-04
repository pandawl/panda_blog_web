<!--  -->
<template>
  <el-row>
    <el-col :span="11" :offset="4">
      <div class="grid-content bg-purple">
 <article class="excerpt">
          <header>
            <a class="label label-important" href="getcategory.html?categoryid=${blog.categoryid}">
              sdfsd
              <i class="label-arrow"></i>
            </a>
            <h2>
              <a href="getblogdetail.html?blogid=${blog.blogid}" title="${blog.title}">sdfsf</a>
            </h2>
          </header>
          <div class="focus">
            <a href="getblogdetail.html?blogid=${blog.blogid}">
              <img
                class="thumb"
                src="${blog.imageurl}!/both/200x123?imageView2/1/w/200/h/123"
                alt="${blog.title}"
              >
            </a>
          </div>
          <span class="note">111...</span>
          <p class="auth-span">
            <span class="muted">
              <i class="iconfont">&#xe631;</i>
              1111
            </span>
            <span class="muted">
              <i class="iconfont">&#xe651;</i>
              浏览
            </span>
            <span class="muted">
              <a href="${pageContext.request.contextPath}/getblogdetail.html?blogid=${blog.blogid}">
                <span id="sourceId::${blog.blogid}" class="cy_cmt_count"></span>
                <!--畅言导致加载缓慢，有时间处理一下-->
               1评论
              </a>
            </span>
          </p>
        </article>
      </div>
    </el-col>
    <el-col :span="5">
      <div class="grid-content bg-purple-light index-right-panda">
        <left-menus/>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import LeftMenus from "../components/LeftMenus.vue";

export default {
  data() {
    return {};
  },

  components: {
    LeftMenus,

  },

  computed: {},

  mounted: {},

  methods: {}
};
</script>
<style lang='scss' scoped>
.index-right-panda {
  width: auto;
}
</style>
