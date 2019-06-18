<template>
  <div class="login">
    <a-input class="ainput"
      placeholder="Username"
      v-model="registerInfo.name"
    >
      <a-icon
        slot="prefix"
        type="user"
        style="color:rgba(0,0,0,.25)"
      />
    </a-input>
    <a-input class="ainput"
      type="password"
      placeholder="Password"
      v-model="registerInfo.password"
    >
      <a-icon
        slot="prefix"
        type="lock"
        style="color:rgba(0,0,0,.25)"
      />
    </a-input>
    <a-input class="ainput"
      type="password"
      placeholder="Confirm Password"
      @blur="pwBlur"
      v-model="confirmpw"
    >
      <a-icon
        slot="prefix"
        type="lock"
        style="color:rgba(0,0,0,.25)"
      />
    </a-input>
    <a-input-number class="ainput" placeholder="Age" :min="1" :max="100" v-model="registerInfo.age"/>
    <a-radio-group class="ainput" buttonStyle="solid" v-model="registerInfo.gender">
        <a-radio-button value="1"><a-icon type="man" /></a-radio-button>
        <a-radio-button value="2"><a-icon type="woman" /></a-radio-button>
    </a-radio-group>
    <a-input-number class="ainput" placeholder="Phone" v-model="registerInfo.phone"/>
    <a-button class="abutton" @click="register">注册</a-button>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      confirmpw: '',
      registerInfo: {
        name: '',
        password: '',
        age: '',
        gender: '1',
        phone: ''
      }
    }
  },
  methods: {
    pwBlur () {
      if (this.registerInfo.password !== this.confirmpw) {
        this.confirmpw = ''
        this.$message.error('Confirm Password Error!')
      }
    },
    register () {
      if (this.registerInfo.name === '' || this.registerInfo.password === '' || this.registerInfo.age === '' || this.registerInfo.phone === '' || this.confirmpw === '') {
        this.$message.error('Please complate your information!')
      } else {
        this.$ajax({
          method: 'post',
          url: '/ITBlogSiteBackEnd/user/adduser',
          params: {
            name: this.registerInfo.name,
            gender: this.registerInfo.gender,
            age: parseInt(this.registerInfo.age),
            password: this.registerInfo.password,
            phone: parseInt(this.registerInfo.phone)
          }
        }).then(function (res) {
          console.log(res)
        }).catch(function (err) {
          console.log(err)
        })
        this.$router.push({
          'path': 'Login'
        })
        this.$message.success('Registered successfully!')
      }
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
