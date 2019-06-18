import Vue from 'vue'
import Router from 'vue-router'
import Recommand from '@/components/Recommand'
import Blog from '@/components/Blog'
import Resource from '@/components/Resource'
import Bbs from '@/components/Bbs'
import Person from '@/components/Person'
import Login from '@/components/Login'
import Register from '@/components/Register'
import ABlog from '@/components/BlogModel/ABlog'
import WriteBlog from '@/components/Person/WriteBlog'
import RewriteBlog from '@/components/Person/RewriteBlog'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Recommand',
      component: Recommand
    },
    {
      path: '/Recommand',
      name: 'Recommand',
      component: Recommand
    },
    {
      path: '/Resource',
      name: 'Resource',
      component: Resource
    },
    {
      path: '/Blog',
      name: 'Blog',
      component: Blog
    },
    {
      path: '/Bbs',
      name: 'Bbs',
      component: Bbs
    },
    {
      path: '/Person',
      name: 'Person',
      component: Person
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/Register',
      name: Register,
      component: Register
    },
    {
      path: '/Ablog/:id',
      name: ABlog,
      component: ABlog
    },
    {
      path: '/WriteBlog',
      name: WriteBlog,
      component: WriteBlog
    },
    {
      path: '/RewriteBlog/:id',
      name: RewriteBlog,
      component: RewriteBlog
    }
  ]
})
