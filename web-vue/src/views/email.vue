<!--  -->
<template>
  <div>
    <BUtton @click="yonghu"></BUtton>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
    };
  },

  methods: {
    yonghu(){
      this.$axios.post('/panda/user/getUser').then(result => {
        console.log(result);
        
      })
    
    }
  }
}

</script>
<style lang='scss' scoped>
</style>
