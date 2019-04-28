import axios from 'axios'
import { baseURL } from '@/config'
class HttpRequest {
    constructor(baseUrl = baseURL) {
        this.baseUrl = baseUrl
        this.queue = {}
    }
    getInsideConfig() {
        const config = {
            baseUrl: this.baseUrl,
            headers: {

            }
        }
        return config
    }
    interceptors(instance) {
        instance.interceptors.request.use(config => {
            //添加全局的loading...
            return config
        }, error => {
            return Promise.reject(error)
        })
        instance.interceptors.response.use(
            res => { return res }, error => {
                return Promise.reject(error)
            }
        )
    }
    request(options) {
        const instance = axios.create()
        options = Object.assign(this.getInsideConfig(), options)
        this.interceptors(instance)
        return instance(options)
    }
}

export default HttpRequest