export default [{
        path: '/',
        name: 'home',
        redirect: '/blog/list'

    },
    {
        path: '/blog/list',
        name: 'blog-list',
        component: () =>
            import ('../views/blog/list')

    },

    {
        path: '/blog/edit',
        component: () =>
            import ('../views/blog/edit.vue'),
        name: '博客',
        meta: { title: '', icon: 'form' },

    },
    {
        path: '/blog/tags',
        component: () =>
            import ('../views/tags/index.vue'),
        name: '标签/分类',
        meta: { title: '标签/分类', icon: 'form' },

    },
]