export default [{ //
        path: '/login',
        name: 'login',
        component: () =>
            import ('@/views/login/Common'),
    },
    {
        path: '/index',
        name: '首页',
        redirect: '/home'
    }
]
