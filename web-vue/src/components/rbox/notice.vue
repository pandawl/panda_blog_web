<template>
  <div class="whitebg notice">
    <h2 class="htitle">最近更新</h2>
    <ul>
      <li v-for="blog in blogs" :key="blog.id" >
        <router-link :to="`/blog/detail/${blog.id}`">{{blog.title}}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
import { getList } from "../../api/blog";
export default {
  name: "",
  
  components: {},
  props: {},
  data() {
    return {blogs:[],};
  },
  watch: {},
  computed: {},
  methods: {},
  created() {},
  mounted() {
     getList(1, 5).then(res => {   
      this.blogs = res.data.resultJson.list;
    });
  }
};
</script>
 
<style scoped>

</style>