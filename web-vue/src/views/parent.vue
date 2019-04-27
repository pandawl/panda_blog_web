<!--  -->
<template>
  <div>
    i am parent
    <button @click="handleClick('back')">返回上一页</button>
    <button @click="handleClick('push')">返回上一页</button>
    <button @click="handleClick('replace')">返回上一页</button>
    <router-view/>
  </div>

</template>

<script>
export default {
  data () {
    return {
    };
  },

  components: {},

  computed: {},

  mounted: {},

  methods: {
    handleClick(type){
      if(type === 'back'){
        this.$router.back()//this.$router.go(-1)//返回上一页
      }else if (type === 'push'){
        this.$router.push('/login')// mame:'login跳转
      }else if (type === 'replace'){
        this.$router.replace({
            name: '/login'
        })// mame:'login 替换
      }

    }
  }
}

</script>
<style lang='scss' scoped>
</style>
