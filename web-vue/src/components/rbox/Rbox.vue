<template>
  <div class="rbox">
    <card />
    <category />
    <cloud />
    <pigeonhole />
    <notice />
    <paihang />
  </div>
</template>

<script>
import card from "./card";
import notice from "./notice";
import paihang from "./paihang";
import cloud from "./cloud";
import category from "./category";
import pigeonhole from "./pigeonhole";
export default {
  name: "",

  components: { card, notice, paihang, cloud, category, pigeonhole },
  props: {},
  data() {
    return {};
  }
};
</script>
 
<style scoped>
</style>