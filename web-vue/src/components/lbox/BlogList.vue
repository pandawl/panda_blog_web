<template>
  <div>
    <div class="whitebg bloglist">
      <h2 class="htitle">最新博文</h2>
      <ul>
        <!--单图-->
        <li v-for="blog in blogs" :key="blog.id" :blogDetail="blog">
          <h3 class="blogtitle">
            <router-link :to="`/blog/detail/${blog.id}`">{{blog.title}}</router-link>
          </h3>
          <span class="blogpic imgscale">
            <i>
              <a href="/">{{blog.categoryName}}</a>
            </i>
            <a href="/" title>
              <img src="../../../static/images/b01.jpg" :alt="blog.title">
            </a>
          </span>
          <p class="blogtext">{{blog.summary}}...</p>
          <p class="bloginfo">
            <i class="avatar">
              <img src="../../../static/images/avatar.jpg">
            </i>
            <span>散落记忆里的时光</span>
            <span>{{blog.updateTime}}</span>
            <span>
              【
              <a href="/">{{blog.categoryName}}</a>】
            </span>
          </p>
          <a href="/" class="viewmore">阅读更多</a>
        </li>
      </ul>
      <!--pagelist-->
      <Pager
        v-if="!dataChanged"
        ref="pager"
        :pageSize="pageSize"
        :curPage="curPage"
        :total="total"
        @setPage="gotoPage"
        @setRowNum="changeRowNum"
      />
    </div>
  </div>
</template>

<script>
import { getList } from "../../api/blog";
import Pager from "../Pager";
export default {
  name: "",

  components: { Pager },
  props: {},
  data() {
    return {
      blogs: [],
      blogDetail: {},
      curPage: 1, //当前页
      total: 0, //总共页数
      pageSize: 10, //每页记录数
      dataChanged: false
    };
  },
  mounted() {
    getList(this.curPage, this.pageSize).then(res => {
      this.blogs = res.data.resultJson.list;
      this.curPage = res.data.resultJson.pageNum;
      this.total = res.data.resultJson.pages;
      this.pageSize = res.data.resultJson.pageSize;
      this.refresh();
    });
  },
  methods: {
    refresh() {
      //用于刷新组件，需手动调用
      this.dataChanged = true;
      this.$nextTick(() => {
        this.dataChanged = false;
      });
    },

    gotoPage(curPage) {
      getList(curPage, this.pageSize).then(res => {
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    },
    changeRowNum(pageSize) {
      this.pageSize = pageSize;
       getList(this.curPage, this.pageSize).then(res => {
      this.blogs = res.data.resultJson.list;
      this.curPage = res.data.resultJson.pageNum;
      this.total = res.data.resultJson.pages;
      this.pageSize = res.data.resultJson.pageSize;
      this.refresh();
    });
    }
  }
};
</script>
 
<style scoped>
.bloglist {
  float: left;
  width: 96%;
}
</style>
