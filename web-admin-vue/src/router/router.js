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

]