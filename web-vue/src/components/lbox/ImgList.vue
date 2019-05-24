<template>
  <div>
    <div class="banbox">
      <div class="banner">
        <div class="block">
          <el-carousel style=" position: relative;width: 100%;height: 260px;overflow: hidden;">
            <el-carousel-item v-for="item in imgList" :key="item.id">
              <el-image :src="item.url" style="width:100%"></el-image>
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
    </div>

    <div class="headline">
      <ul>
        <li>
          <a href="/" title="为什么说10月24日是程序员的节日？">
            <img src="../../../static/images/h1.jpg" alt="为什么说10月24日是程序员的节日？">
            <span>为什么说10月24日是程序员的节日？</span>
          </a>
        </li>
        <li>
          <a href="/" title="个人网站做好了，百度不收录怎么办？来，看看他们怎么做的">
            <img src="../../../static/images/h2.jpg" alt="个人网站做好了，百度不收录怎么办？来，看看他们怎么做的。">
            <span>个人网站做好了，百度不收录怎么办？来，看看他们怎么做的。</span>
          </a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "",

  components: {},
  props: {},
  data() {
    return {
      imgList: [
        { id: 1, url: "../../../static/images/1.jpg" },
        { id: 2, url: "../../../static/images/2.jpg" },
        { id: 3, url: "../../../static/images/3.jpg" },
        { id: 4, url: "../../../static/images/4.jpg" }
      ]
    };
  },
  watch: {},
  computed: {},
  methods: {},
  created() {},
  mounted() {}
};
</script>
 
<style scoped>
</style>