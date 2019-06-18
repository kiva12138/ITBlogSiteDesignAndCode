<template>
  <div class="login">
    <a-input class="ainput"
        v-model="loginInfo.name"
        placeholder="Username"
      >
        <a-icon
          slot="prefix"
          type="user"
          style="color:rgba(0,0,0,.25)"
        />
      </a-input>
      <a-input class="ainput"
        v-model="loginInfo.password"
        type="password"
        placeholder="Password"
      >
        <a-icon
          slot="prefix"
          type="lock"
          style="color:rgba(0,0,0,.25)"
        />
      </a-input>
      <a-button class="abutton" @click="login">登录</a-button>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginInfo: {
        name: '',
        password: ''
      }
    }
  },
  methods: {
    init () {
      console.log('sdfsfd')
    },
    login () {
      let self = this
      if (this.loginInfo.name === '' || this.loginInfo.password === '') {
        self.$message.error('Please input your name and password')
      } else {
        this.$ajax({
          method: 'get',
          url: '/ITBlogSiteBackEnd/user/getuserbynameandpassword',
          params: {
            name: this.loginInfo.name,
            password: this.loginInfo.password
          }
        }).then(function (res) {
          if (parseInt(res.data.code) === 0) {
            self.$message.success('Login successfully!')
            self.$store.commit('initPersonInfo', res.data)
            self.$router.push({
              'path': 'Person'
            })
            self.$store.commit('Login', {
              name: self.loginInfo.name,
              password: self.loginInfo.password
            })
          } else {
            self.$message.error('Uername or password error!')
          }
          console.log(res.data)
        })
        // this.$ajax({
        //   method: 'get',
        //   url: '/ITBlogSiteBackEnd/blog/findlikebytitle',
        //   params: {
        //     title: 'rzk'
        //   }
        // }).then(function (res) {
        //   if (parseInt(res.data.code) === 0) {
        //     console.log('aaa')
        //     console.log(res.data.findBlog)
        //     self.$store.commit('initMyBlogList', res.data.findBlog)
        //   } else {
        //   }
        // })
      }
    },
    submitForm () {
    }
  }
}
</script>
<style scoped>
.login{
  position:relative;
  width:400px;
  margin:100px auto;
}
.ainput{
  width: 200px;
  margin:10px auto;
  display: block;
}
.abutton{
  width: 100px;
  margin: 10px auto;
  display: block;
}
</style>
