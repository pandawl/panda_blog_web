<template>
  <div class="rbox">
    <card/>
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
export default {
  name: "",

  components: { card, notice,paihang,cloud },
  props: {},
  data() {
    return {};
  }
};
</script>
 
<style scoped>
</style>