import axios from 'axios'

// 创建axios实例
const service = axios.create({
    baseURL: 'http://localhost:9999', // api的base_url
    timeout: 15000 // 请求超时时间
})