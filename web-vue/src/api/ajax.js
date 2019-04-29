/* ajax 封装 
返回值 promise 对象
*/
import axios from 'axios'
export default function ajax(url, data = {}, type = 'POST') {
    /*     let promise
        if (type === 'GET') {
            let dataStr = '' //数据拼接字符串
            Object.keys(data).forEach(key => {
                dataStr += key + '=' + data[key] + '&'
            })
            if (dataStr !== '') {
                dataStr = dataStr.substring(0, dataStr.lastIndexOf('&'))
                url = url + '?' + dataStr
            }
            //发送get请求
            Promise = axios.get(url)
        } else {
            //发送post请求
            Promise = axios.post(url, data)
        }
        return Promise; 
        返回的是response
        */
    return new Promise(function(resolve, reject) {
        //执行异步ajax请求
        //成功了调用resolve
        //失败了调用reject
        let promise
        if (type === 'GET') {
            let dataStr = '' //数据拼接字符串
            Object.keys(data).forEach(key => {
                dataStr += key + '=' + data[key] + '&'
            })
            if (dataStr !== '') {
                dataStr = dataStr.substring(0, dataStr.lastIndexOf('&'))
                url = url + '?' + dataStr
            }
            //发送get请求
            promise = axios.get(url)
        } else {
            //发送post请求
            promise = axios.post(url, data)
        }
        promise.then(function(response) {
                resolve(response.data)
            }).catch(function(error) {
                reject(error)
            })
            //返回的是response.data
    })

}