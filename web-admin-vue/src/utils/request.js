import axios from 'axios'
import qs from 'qs'
// 创建axios实例
const service = axios.create({
    //baseURL: 'http://www.wangleihh.cn:9999/panda', // api的base_url
    baseURL: 'http://localhost:9999/panda',
    timeout: 15000, // 请求超时时间
    transformRequest: data => qs.stringify(data)
})

export default service
