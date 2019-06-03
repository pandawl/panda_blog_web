<!--  -->
<template>
  <div>
    <detail class="detail"/>
    <Rbox class="rbox"/>
  </div>
</template>

<script>
import detail from "./detail";
import Rbox from '../../components/rbox/Rbox'

export default {
  components: { detail,Rbox },
  data() {
    return {
      
    };
  },
  computed: {},
  watch: {},
  methods: {},
  created() {},
  mounted() {
  
   
},

};
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类
div{
     width: 80%;
 
  margin: auto;
   margin-top: 10px;
  overflow: hidden;

}
.detail{
 width: 72%;
 float: left;
}
</style>