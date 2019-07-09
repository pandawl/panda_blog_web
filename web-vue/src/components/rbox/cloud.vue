<template>
     <div class="whitebg cloud">
      <h2 class="htitle">标签云</h2>
      <ul>
        <router-link v-for="(tag) in tags" :key="tag.id"  :to="`/blog/taglist/${tag.id}`" >{{tag.tagName}}</router-link>       
      </ul>
    </div>
</template>
<script>
import {getTagList} from '../../api/blog'
export default {
   name: '',
    
  components:{},
  props:{},
  data(){
    return {
      tags:[]
    }
  },
  watch:{},
  computed:{},
  methods:{},
  created(){
        getTagList().then(res=>{
      this.tags = res.data.resultJson
    })
  },
  mounted(){}
}
</script>
 
<style scoped>
 
</style>