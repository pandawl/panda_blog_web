// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './styles/index.scss'
import './assets/iconfont/iconfont.js'
import axios from 'axios'
import qs from 'qs'

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$axios = axios;
axios.defaults.baseURL = 'http://localhost:9999'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.filter('switchdate', function(value) {
    return moment(value).format('l');
})


axios.interceptors.request.use(function(config) {
    if (config.method == 'post') {
        config.data = qs.stringify(config.data)
    }
    return config;
}, function(error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

/* eslint-disable no-new */
new Vue({
    el: '#app',
    store,
    router,
    components: { App },
    template: '<App/>'
})