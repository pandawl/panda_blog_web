<template>
   <div class="header">
       <!--  <span class="header_search">
            <i class="iconfont icon-sousou"></i>
        </span> -->
        <slot name="search"></slot>
        <span class="header_title">
            <span header_title_text ellipsis>{{title}}</span>
        </span>
      <!--   <span class="header_login">
            <span class="header_login_text">登录|注册</span>
        </span> -->
        <slot name="user"></slot>
   </div>
</template>

<script>
export default {
   name: '',
    
  components:{},
  props:{
      title: String
  },
  data(){
    return {
    }
  },
  watch:{},
  computed:{},
  methods:{},
  created(){},
  mounted(){}
}
</script>
 
<style scoped>
 
</style>