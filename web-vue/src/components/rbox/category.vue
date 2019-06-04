<template>
     <div class="whitebg cloud">
      <h2 class="htitle">分类</h2>
      <ul >
        <a v-for="(category) in categorys" :key="category.id"  href="" target="_blank">{{category.categoryName}}</a>       
      </ul>
    </div>
</template>

<script>
import {getCategoryList} from '../../api/blog'
export default {
   name: '',
    
  components:{},
  props:{},
  data(){
    return {
      categorys: []
    }
  },
  watch:{},
  computed:{},
  methods:{},
  created(){
    getCategoryList().then(res=>{
      this.categorys = res.data.resultJson
    })
  },
  mounted(){}
}
</script>
 
<style scoped>
 
</style>