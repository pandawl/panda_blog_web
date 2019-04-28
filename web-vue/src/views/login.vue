<!--  -->
<template>
  <div>登录页<button @click="yonghu">fsf</button></div>
</template>

<script>
import {getUserInfo} from '@/api/user'
export default {
  data () {
    return {
    };
  },

  components: {},

  computed: {},

  mounted: {},

  methods: {yonghu(){
     getUserInfo({id:5}).then(res =>{
      console.log(res);
       
     })
    }}
}

</script>
<style lang='scss' scoped>
</style>
