export default [{
        path: '/',
        name: 'home',
        redirect: '/blog/list'

    },
    {
        path: '/blog/list',
        name: 'blog-list',
        component: () =>
            import ('../views/blog/list'),
        name: '博客',
        meta: {
            title: '',
            keepAlive: false,
            icon: 'form'
        },

    },

    {
        path: '/blog/edit',

        component: () =>
            import ('../views/blog/edit.vue'),
        name: '博客',
        meta: { title: '', icon: 'form', keepAlive: true },
        children: [{
            path: ':id',
            component: () =>
                import ('../views/blog/edit.vue'),
            name: '博客编辑',

        }]

    },
    {
        path: '/blog/tags',
        component: () =>
            import ('../views/tags/index.vue'),
        name: '标签',
        meta: { title: '标签', icon: 'form' },

    }, {
        path: '/blog/categorys',
        component: () =>
            import ('../views/category/index.vue'),
        name: '分类',
        meta: { title: '分类', icon: 'form' },

    },
    {
        path: '/blog/img',
        component: () =>
            import ('../views/img/index.vue'),
        name: '图片',
        meta: { title: '图片', icon: 'form' },

    },
]