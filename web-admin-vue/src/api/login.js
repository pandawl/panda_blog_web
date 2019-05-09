
export function login(data) {
  this.$axios.post('/panda/user/getUser',data)

}
