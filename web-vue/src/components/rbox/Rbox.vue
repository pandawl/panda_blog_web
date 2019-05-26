<template>
  <div class="rbox">
   <card/>
   <category/>
    
    <notice/>
    <paihang/>
    <cloud/>
  </div>
</template>

<script>
import card from "./card";
import notice from "./notice";
import paihang from "./paihang";
import cloud from './cloud'
import category from './category'
export default {
  name: "",

  components: { card, notice,paihang,cloud,category },
  props: {},
  data() {
    return {};
  }
};
</script>
 
<style scoped>
</style>