
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

  }
]
