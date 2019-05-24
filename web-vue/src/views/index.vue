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
  width: 1200px;
 
  margin: auto;
   margin-top: 5px;
  overflow: hidden;
}
</style>
