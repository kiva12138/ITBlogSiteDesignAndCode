import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  // 定义状态
  state: {
    isLogin: false,
    searchInfo: '',
    myBlogList: [],
    loginInfo: {
      name: '',
      password: ''
    },
    registerInfo: {
      name: '',
      password: '',
      age: '',
      gender: '',
      phone: ''
    },
    personInfo: {
      name: '',
      userId: '',
      age: '',
      gender: '',
      blogNum: '',
      phone: ''
    }
  },
  mutations: {
    Search (state, payload) {
      state.searchInfo = payload.searchInfo
    },
    Login (state, payload) {
      state.isLogin = true
      state.loginInfo = payload
    },
    Logout (state) {
      state.isLogin = false
    },
    regist (state, payload) {
      state.registerInfo = payload
      state.loginInfo = state.registerInfo
      console.log(state.registerInfo)
    },
    initPersonInfo (state, payload) {
      state.personInfo = payload
    },
    initMyBlogList (state, payload) {
      state.myBlogList = payload
    }
  }
})

export default store
