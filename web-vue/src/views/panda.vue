<!--  -->
<template>
  <div>
     {{$name}}
  </div>
</template>

<script>
export default {
  data () {
    return {
    };
  },

  props: {
    name: {
      type: String,
      default: 'panda'
    }
  },

  components: {},

  computed: {},

  mounted: {},

  methods: {}
}

</script>
<style lang='scss' scoped>
</style>
