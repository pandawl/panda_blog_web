import request from '@/utils/request'

/**
 * 取操作员登录信息，获取token
 * @type {string}
 */
const POST_LOGIN_URL = '/login'

/**
 * 获取所有不猛
 * @type {string}
 */
const GET_DEPT_URL = '/dept'
/**
 * 获取用户下拉列表
 * @type {string}
 */
const GET_USER_URL = '/user'


export default {
  /**
   * 获取操作员登录信息，获取token
   * @param userName ⽤户名
   * @param password 密码
   * @param verifyCode 验证码
   * @returns {AxiosPromise|*}
   */
  login: (username, password) => {

    return request.post(POST_LOGIN_URL, {
      username: username,
      password: password
    })
  },

  dept:()=>{
    return request.get(GET_DEPT_URL)
  },

  user:(...params)=>{
    return request.get(GET_USER_URL,...params)
  }
}
