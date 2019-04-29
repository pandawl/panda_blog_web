<!--  -->
<template>
  <div>
    <input  v-model="userName">
    <input type="password" v-model="password">
    <button @click="handlerSubmit">登录 </button>
  </div>
</template>

<script>
export default {
  name: "Login_page",
  data() {
    return {
      userName: "",
      password: ""
    };
  },

  methods: {
    handlerSubmit(){
      console.log(userName);
      console.log(password);
      
        userName: this.userName
        password: this.password
      this.$axios.post("/panda/user/login",{userName,password}).then(
        res =>{

        }
      )
    }
  }
};
</script>
<style lang='scss' scoped>
</style>
