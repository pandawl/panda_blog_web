// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import router from './router'
import store from './store/index'
import axios from 'axios'
import qs from "qs"
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'




Vue.config.productionTip = false

Vue.prototype.$axios = axios;
Vue.prototype.HOST = '/api'


axios.defaults.baseURL = 'http://localhost:8888';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.use(Element)

// 添加请求拦截器
axios.interceptors.request.use(function(config) {
    // 参数格式转换
    if (config.method == "post") {
        config.data = qs.stringify(config.data);
    }
    return config;
}, function(error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});


// 添加响应拦截器
axios.interceptors.response.use(function(response) {
    // 对响应数据做点什么
    return response;
}, function(error) {
    // 对响应错误做点什么
    return Promise.reject(error);
});



/* new Vue({
    'el': '#main',
    data() {
        return { value: '' }
    }
}) */
Vue.use(mavonEditor)
    /* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    components: { App },
    template: '<App/>',

})