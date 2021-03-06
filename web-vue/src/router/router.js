export default [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
        path: '/login',
        name: 'login',
        component: () =>
            import ( /*webpackChunkName:"about" */ '@/views/Login/login.vue'),
        //可以实现懒加载功能
        meta: {
            showLogin: true
        }
    },
    /*     {
            //动态路由 http://localhost:8080/panda/hh#/  {{$route.params.name}}
            path: '/panda/:name',
            component: () =>
                import ('@/views/index.vue'),
            props: true //里面的参数name 传入到组建中
        }, */
    /*  {
         //嵌套路由
         path: '/parent',
         component: () =>
             import ('@/views/parent.vue'),
         children: [{
             path: 'child',
             component: () =>
                 import ('@/views/child.vue')
         }]
     }, */
    {
        //命名路由 <router-link :to="{name: 'about'}">about<router-link>

        path: '/',
        name: 'index',
        component: () =>
            import ('@/views/index.vue')
    },
    /*   {
          //命名视图
          path: '/named_view',
          components: {
              default: () =>
                  import ('@/views/child.vue'),
              email: () =>
                  import ('@/views/email.vue'),
              tel: () =>
                  import ('@/views/tel.vue')
          }
      }, */
    /*    {
           //重定向
           path: '/main',
           // redirect:'/'
           redirect: to => {
               //可以根据条件进行跳转
               return {
                   name: 'home'

               }
           }
       }, */
    /*  {
         //别名
         path: '/',
         name: 'parent',
         alias: '/home_page',
         component: () =>
             import ('@/views/parent.vue'),
         meta: {
             title: '首页'
         }
     }, */
    /*   {
          path: '*', //放到最后
          component: () =>
              import ('@/views/error_404.vue')
      } */
    {
        path: '/blog/detail/:id',
        name: 'detail',
        component: () =>
            import ('@/views/detail/index'),
    },
    { //关于我
        path: '/blog/about/',
        name: 'about',
        component: () =>
            import ('@/views/aboutme/index'),
    },
    { //日志
        path: '/blog/log/',
        name: 'log',
        component: () =>
            import ('@/views/log/index'),
    },
    {
        path: '/blog/taglist/:id',
        name: 'taglist',
        component: () =>
            import ('../views/tags/index'),
    },
    {
        path: '/blog/category/:id',
        name: 'categorylist',
        component: () =>
            import ('../views/category/index'),
    },

    {
        path: '/blog/pigeonhole/:id',
        name: 'pigeonhole',
        component: () =>
            import ('../views/pigeonhole/index'),
    },
    {
        path: '/blog/search/',
        name: 'searchlist',
        component: () =>
            import ('../views/search/index'),
    },

]