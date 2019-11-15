import Vue from 'vue'
import Panda from './Panda'
import router from './router'
import Antd from 'ant-design-vue'
import VueApexCharts from 'vue-apexcharts'

import 'ant-design-vue/dist/antd.css'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
    el: '#panda',
    router,
    components: { Panda },
    template: '<panda/>'
})