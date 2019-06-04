<template>
     <div class="whitebg cloud">
      <h2 class="htitle">标签云</h2>
      <ul>
        <a v-for="(tag) in tags" :key="tag.id"  href="" target="_blank">{{tag.tagName}}</a>       
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