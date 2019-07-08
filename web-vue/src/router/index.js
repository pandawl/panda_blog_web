import Vue from 'vue'
import Router from 'vue-router'
import routes from './router'
import { setTitle } from '../lib/util';


Vue.use(Router)
    //全局守卫 权限控制，页面跳转
const router = new Router({
    routes
})

// const HAS_LOGINED = true
//     //全局前置守卫 to 要跳转的 from 当前 路由对象 next 函数
// router.beforeEach((to, from, next) => {
//         to.meta && setTitle(to.meta.title)
//         if (to.name !== 'login') {
//             if (HAS_LOGINED) {
//                 next()
//             } else {
//                 next({
//                     name: 'login' //没登录跳转到登录页面
//                 })
//             }
//         } else {
//             if (HAS_LOGINED) next({ name: 'home' })
//             else next()
//         }
//     })
//不能控制页面跳转 路由跳转之后操作
router.afterEach((to, from) => {
        window.scrollTo(0, 0);
    })
    /**
     * -----导航流程-----------
     * 1.导航被触发
     * 2.在失活的组件（即将离开的页面组件）里调用离开守卫 beforeRouteLEAVE
     * 3.调用全局的前置守卫beforeEach
     * 4.在重用的组件里调用 beforeRouteUpdate
     * 5.调用路由独享的守卫 beforeEnter router 配置的
     * 6.解析异步路由组件
     * 7.在被激活的组件（即将进入的页面组件） 里调用beforeRouterEnter
     * 8.调用全局的解析守卫beforeResolve
     * 9.导航被确认
     * 10.调用全局的后置守卫 afterEach
     * 11.触发DOM更新
     * 12.用创建好的实例调用beforeRouterEnter守卫里传递给next函数
     */
export default router