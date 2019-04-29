import ajax from "./ajax";
const BASE_URL = 'http://localhost:9999'
    //const BASE_URL = '/api' //使用代理

/* 包含n个接口请求函数的模块  */
//1.根据id获取用户信息

export const reqUser = (id) => ajax(BASE_URL + '/panda/user/getUser', { id })