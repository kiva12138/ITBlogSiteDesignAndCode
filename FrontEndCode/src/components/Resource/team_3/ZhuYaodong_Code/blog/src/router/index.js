import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Regist from '@/components/Register'
import Person from '@/components/Person'
import BlogWrite from '@/components/PersonModule/BlogWrite'
import QuesWrite from '@/components/PersonModule/QuesWrite'
import ResUpload from '@/components/PersonModule/ResUpload'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/regist',
      name: 'Regist',
      component: Regist,
      meta: {
        title: '注册'
      }
    },
    {
      path: '/person',
      name: 'Person',
      component: Person,
      meta: {
        title: '个人中心'
      }
    },
    {
      path: '/BlogWrite',
      name: 'BlogWrite',
      component: BlogWrite,
      meta: {
        title: 'BlogWrite'
      }
    },
    {
      path: '/QuesWrite',
      name: 'QuesWrite',
      component: QuesWrite,
      meta: {
        title: 'QuesWrite'
      }
    },
    {
      path: '/ResUpload',
      name: 'ResUpload',
      component: ResUpload,
      meta: {
        title: 'ResUpload'
      }
    }
  ]
})
