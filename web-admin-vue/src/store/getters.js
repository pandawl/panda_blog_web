  /* 
        包含多个基于state 的getter计算属性的对象
        */
  const getters = {
      token: state => state.user.token,
  }

  export default getters