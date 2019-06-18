<template>
<div class='menu'>
  <div class='navbar'>
    <a-menu
    mode="horizontal"
  >
    <a-menu-item v-for="(item, index) in menu_items" :key='index' @click="changeBlock(item.path)">
      <a-icon :type="item.icon" />{{item.name}}
    </a-menu-item>
    <a-menu-item>
      <a-input-search
      placeholder="input search text"
      style="width: 200px"
      @search="searchResource"
    />
    </a-menu-item>
    <a-menu-item class='userInfo'>
      <a-dropdown v-if="! isLogin" >
        <span class="ant-dropdown-link">
          <a-icon type="user" />个人中心
        </span>
        <a-menu slot="overlay">
            <a-menu-item>
              <a @click="changeBlock('/Login')">登录</a>
            </a-menu-item>
            <a-menu-item>
              <a @click="changeBlock('/Register')">注册</a>
            </a-menu-item>
        </a-menu>
      </a-dropdown>
      <a-dropdown v-if="isLogin">
      <span class="ant-dropdown-link" @click="changeBlock('/Person')">
        {{loginInfo.name}} <a-icon type="down" />
      </span>
        <a-menu slot="overlay">
          <a-menu-item>
            <a @click="changeBlock('/WriteBlog')">编写博客</a>
          </a-menu-item>
          <a-menu-item>
            <a @click="Logout">登出</a>
          </a-menu-item>
        </a-menu>
      </a-dropdown>
    </a-menu-item>
  </a-menu>
  </div>
</div>
</template>
<script>
export default {
  name: 'Menu',
  data () {
    return {
      menu_items: [
        {
          name: '推荐',
          icon: 'home',
          path: '/Recommand'
        },
        {
          name: '博客',
          icon: 'profile',
          path: '/Blog'
        },
        {
          name: '论坛',
          icon: 'coffee',
          path: '/Bbs'
        },
        {
          name: '内容',
          icon: 'download',
          path: '/Resource'
        }
      ]
    }
  },
  computed: {
    isLogin () {
      return this.$store.state.isLogin
    },
    loginInfo () {
      return this.$store.state.loginInfo
    }
  },
  methods: {
    changeBlock (blockPath) {
      this.$router.push({
        'path': blockPath
      })
    },
    searchResource (value) {
      this.$store.commit('Search', {searchInfo: value})
      this.$router.push({
        'path': '/Resource'
      })
    },
    Login () {
      this.$store.commit('Login')
    },
    Logout () {
      this.$store.commit('Logout')
      this.$router.push({
        'path': '/Recommand'
      })
    }
  }
}
</script>
<style scoped>
.userInfo{
  position: absolute;
  right:0%;
}
</style>
