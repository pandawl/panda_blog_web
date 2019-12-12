import Vue from 'vue'
import Router from 'vue-router'
import routes from './router'
import db from '@/utils/localstorage'
import HomePageView from '@/views/Home'
import PageView from '@/views/common/PageView'
import EmptyPageView from '@/views/common/EmptyPageView'
import MenuView from '@/views/common/MenuView'
import request from '@/utils/request'

Vue.use(Router)
    //全局守卫 权限控制，页面跳转
const router = new Router({
    routes
})

// 全局Router异常处理
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => { if (typeof err !== 'undefined') console.log() })
}
const whiteList = ['/login']

let asyncRouter

// 导航守卫，渲染动态路由
// 导航守卫，渲染动态路由
router.beforeEach((to, from, next) => {

    if (whiteList.indexOf(to.path) !== -1) {
        next()
    }
    let token = db.get('USER_TOKEN')
    let user = db.get('USER')
    let userRouter = get('USER_ROUTER')
    if (token.length && user) {
        if (!asyncRouter) {
            if (!userRouter) {
                // request.post(`menu`, { username: user.username }).then((res) => {
                request.get(`menu/${user.username}`).then((res) => {
                    asyncRouter = res.data
                    save('USER_ROUTER', asyncRouter)
                    go(to, next)
                }).catch(err => { console.error(err) })
            } else {
                asyncRouter = userRouter
                go(to, next)
            }
        } else {
            next()
        }
    } else {
        if (to.path === '/login') {
            next()
        } else {
            next("/login")
        }

    }
})

function go(to, next) {
    asyncRouter = filterAsyncRouter(asyncRouter)
    router.addRoutes(asyncRouter)
    next({...to, replace: true })
}

function save(name, data) {
    localStorage.setItem(name, JSON.stringify(data))
}

function get(name) {
    return JSON.parse(localStorage.getItem(name))
}

function filterAsyncRouter(routes) {
    return routes.filter((route) => {
        let component = route.component
        if (component) {
            switch (route.component) {
                case 'MenuView':
                    route.component = MenuView
                    break
                case 'PageView':
                    route.component = PageView
                    break
                case 'EmptyPageView':
                    route.component = EmptyPageView
                    break
                case 'HomePageView':
                    route.component = HomePageView
                    break
                default:
                    route.component = view(component)
            }
            if (route.children && route.children.length) {
                route.children = filterAsyncRouter(route.children)
            }
            return true
        }
    })
}

function view(path) {
    return function(resolve) {
        import (`@/views/${path}.vue`).then(mod => {
            resolve(mod)
        })
    }
}
export default router
