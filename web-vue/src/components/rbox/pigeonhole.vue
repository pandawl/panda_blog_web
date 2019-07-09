<!--文章归档-->
<template>
     <div class="whitebg cloud">
      <h2 class="htitle">文章归档</h2>
      <ul >
        <router-link v-for="(time) in times" :key="time"  :to="`/blog/category/${time}`" >{{time}}</router-link>      
      </ul>
    </div>
</template>

<script>
import {getTimeList} from '../../api/blog'
export default {
   name: '',
    
  components:{},
  props:{},
  data(){
    return {
      times: []
    }
  },
  watch:{},
  computed:{},
  methods:{},
  created(){
    getTimeList().then(res=>{
      this.times = res.data.resultJson
    })
  },
  mounted(){}
}
</script>
 
<style scoped>
 
</style>