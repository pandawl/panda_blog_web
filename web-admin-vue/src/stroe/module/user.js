import {login} from "../../api/login"
import {setToken} from "../../../utils/auth";

const state = {
  //
}

const mutations = {
  //
}

const actions = {
  //
  Login ({commit}, userInfo){
    const {username,password} = userInfo
    return new Promise((resolve,reject)=>{
      login({username: username.trim(),password}).then(
        res => {
          const data = res.data
          setToken(data.token)
          commit('SET_TOKEN', data.token)
          resolve()
        }).catch(error =>{
          reject(error)
      })
    })
  }
}

export default {
  state,
  mutations,
  actions
}
