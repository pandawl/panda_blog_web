
export default [
  {
    path: '/',
    name: 'home',
    component: () =>
      import('../views/Home.vue')

  },{
    path: '/login',
    name: 'login',
    component: () =>
      import('../views/login')

  },

  {
    path: '/blog/edit',
    component: ()=>
    import('../views/blog/edit.vue'),
    name: '博客',
    meta: { title: '', icon: 'form' },
    /* children: [
      {
        path: 'edit',
        name: 'Edit',
        component: () => import('@/views/blog/edit'),
        meta: { title: '发布博客', icon: 'form' }
      }] */
  },

]
