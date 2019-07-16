<template>
  <div class="head_aricle">
    <div>
      <div class="whitebg bloglist left">
        <h2 class="htitle">{{categoryName}}</h2>
        <canvas id="mycanvas" width="612" height="280" style="margin-left:200px" v-show="loading"></canvas>
        <ul v-show="article">
          <!--单图-->
          <li v-for="blog in blogs" :key="blog.id" :blogDetail="blog">
            <h3 class="blogtitle">
              <router-link :to="`/blog/detail/${blog.id}`">{{blog.title}}</router-link>
            </h3>
            <span class="blogpic imgscale">
              <i>
                 <router-link :to="`/blog/category/${blog.categoryId}`">{{blog.categoryName}}</router-link>
              </i>
    
              <router-link :to="`/blog/detail/${blog.id}`">
                <img src="http://img.wangleihh.cn/blog/web/static/images/b02.jpg" :alt="blog.title" />
              </router-link>
            </span>
            <p class="blogtext">{{blog.summary}}...</p>
            <p class="bloginfo">
              <i class="avatar">
                <img src="http://img.wangleihh.cn/blog/web/static/images/wl.jpg" />
              </i>
              <span>散落记忆里的时光</span>
              <span>{{blog.createTime}}</span>
              <span>
                【
                 <router-link :to="`/blog/category/${blog.categoryId}`">{{blog.categoryName}}</router-link>】
              </span>
            </p>
             <router-link :to="`/blog/detail/${blog.id}`" class="viewmore">阅读更多</router-link>
          </li>
        </ul>
        <h2 v-show="!article" style="text-align: center;">该分类下暂无文章~~~</h2>
        <!--pagelist-->
        <Pager
          v-if="!dataChanged"
          ref="pager"
          :pageSize="pageSize"
          :curPage="curPage"
          :total="total"
          @setPage="gotoPage"
          @setRowNum="changeRowNum"
        v-show="article"/>
      </div>
    </div>
    <Rbox />
  </div>
</template>

<script>
import Rbox from "../../components/rbox/Rbox";
import { getBlogByCategory,getCategory } from "../../api/blog";
import Pager from "../../components/Pager";
export default {
  name: "",

  components: { Pager, Rbox },
  props: {},
  data() {
    return {
      id: 0,
      blogs: [],
      blogDetail: {},
      curPage: 1, //当前页
      total: 0, //总共页数
      pageSize: 10, //每页记录数
      dataChanged: false,
      article: true,
      categoryName: "",
      loading:false
    };
  },
  mounted() {
     var stage = new createjs.Stage("mycanvas")
createjs.Ticker.addEventListener("tick", stageBreakHandler);
var img =  new Image()
img.src = "http://img.wangleihh.cn/blog/web/static/images/horse.png"
img.onload = function(){
	var ss = new createjs.SpriteSheet({
		"images": ["http://img.wangleihh.cn/blog/web/static/images/horse.png"], 
		"frames": [
			[519,1352,468,225,0,-39.5,-6.05],
			[525,694,405,225,0,-39.5,-6.05],
			[402,1577,398,241,0,-37.5,-9.05],
			[0,1565,402,239,0,-33.5,-8.05],
			[521,920,430,233,0,-23.5,-14.05],
			[520,0,465,228,0,-7.5,-22.05],
			[515,238,479,228,0,-8.5,-24.05],
			[508,470,500,224,0,-2.5,-26.05],
			[0,470,508,231,0,-5.5,-20.05],
			[0,238,515,232,0,-9.5,-17.05],
			[0,0,520,238,0,-12.5,-11.05],
			[0,920,521,219,0,-18.5,-11.05],
			[0,701,525,219,0,-18.5,-11.05],
			[0,1352,519,213,0,-28.5,-10.05],
			[0,1139,520,213,0,-28.5,-10.05]
		],
		"animations" : {
			"run": [0,14,"run"]
		}
	})

	var sp = new createjs.Sprite(ss,"run")
	stage.addChild(sp)
	stage.update();
}

function stageBreakHandler(event){
	stage.update();
}



 this.loading= true;
   let id = this.$route.params.id;
      getBlogByCategory(this.curPage, this.pageSize,id).then(res => {
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
      getCategory(id).then(res=>{
        this.categoryName= res.data.resultJson.categoryName
      })
  },
  watch: {
    $route(to, from) {
      let id = this.$route.params.id;
      this.initData(id);
    },
   blogs:{handler(){
     
     this.article = this.blogs.length >0  ?true :false
      this.loading = this.blogs.length >0  ?false :true
    
   }} 
  },
  methods: {
    refresh() {
      //用于刷新组件，需手动调用
      this.dataChanged = true;
      this.$nextTick(() => {
        this.dataChanged = false;
      });
    },
    initData(id) {
       this.loading= true;
      getBlogByCategory(this.curPage, this.pageSize,id).then(res => {
        this.loading= false;
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
      getCategory(id).then(res=>{
        this.categoryName= res.data.resultJson.categoryName
      })
    },

    gotoPage(curPage) {
       this.loading= true;
      let id = this.$route.params.id;
      getBlogByCategory(curPage, this.pageSize,id).then(res => {
        this.loading= false;
        this.blogs = res.data.resultJson.list;
        this.curPage = res.data.resultJson.pageNum;
        this.total = res.data.resultJson.pages;
        this.pageSize = res.data.resultJson.pageSize;
        this.refresh();
      });
    },
    changeRowNum(pageSize) {
       this.loading= true;
      this.pageSize = pageSize;
      let id = this.$route.params.id;
      getBlogByCategory(this.curPage, this.pageSize,id).then(res => {
        this.loading= false;
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
.left {
  float: left;
  width: 71.5%;
}
.head_aricle {
  width: 80%;

  margin: auto;
  margin-top: 10px;
  overflow: hidden;
}
</style>
