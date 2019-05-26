<!--  -->
<template>
  <div>
    <Lbox/>
    <Rbox/>
  </div>
</template>

<script>

import Lbox from '../components/lbox/Lbox'
import Rbox from '../components/rbox/Rbox'

export default {
  data() {
    return {};
  },

  components: {
    Lbox,
    Rbox

  },

  
};
</script>
<style lang='scss' scoped>
div {
  width: 80%;
 
  margin: auto;
   margin-top: 10px;
  overflow: hidden;
}

</style>
