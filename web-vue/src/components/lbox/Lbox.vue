<template>
   <div class="lbox"> 
     <img-list></img-list>
     <blog-list></blog-list>
  </div>
</template>

<script>
import ImgList from "./ImgList";
import BlogList from "./BlogList";

export default {
   name: '',
    
  components:{ImgList,BlogList},
  props:{},
  data(){
    return {
    }
  },
 
}
</script>
 
<style scoped>
 .lbox {
    width: 75% ;
    float: left;
    overflow: hidden
}
</style>