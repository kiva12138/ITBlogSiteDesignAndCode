<template>
  <div id='Login'>
    <form>
      <h3 class='logintitle'>请登录</h3>
      <el-row>
        <div class='idtip'>ID：</div>
        <div class='idinput'>
          <el-input placeholder="请输入您的ID"
                  v-model="userid"
                  clearable/>
        </div>
      </el-row>
      <el-row>
        <div class='passwordtip'>密码：</div>
        <div class='passwordinput'>
          <el-input placeholder="请输入您的密码"
                  v-model="password"
                  clearable
                  type='password'/>
        </div>
      </el-row>
      <div class="loginbutton">
        <el-button type="primary"
                 v-on:click='handleLogin'>
                登录
      </el-button>
      </div>
      <div class='regbutton'>
        <el-button type="primary"
                 v-on:click='handlejumptoreg'>
                注册
        </el-button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      userid: null,
      password: null
    }
  },
  methods: {
    handleLogin: function () {
      this.$cookie.set('login', 1, {expires: '10m'})
      this.$cookie.set('username', 'Mike', {expires: '10m'})
      this.$cookie.set('phone', '12334444', {expires: '10m'})
      this.$cookie.set('regtime', '2018-2-8', {expires: '10m'})
      this.$cookie.set('numofblog', 2, {expires: '10m'})
      this.$cookie.set('numofques', 5, {expires: '10m'})
      this.$cookie.set('numofres', 33, {expires: '10m'})
      this.$cookie.set('birth', '1998-2-2', {expires: '10m'})
      this.$router.push('/person')
      this.$message({
        message: '登录成功',
        type: 'success'
      })
    },
    handlejumptoreg: function () {
      this.$router.push('/regist')
    }
  }
}
</script>

<style>
#Login{
  margin-top: 60px;
  text-align: center;
  color: #7B7D7D;
}
.idinput{
  width: 20%;
  display: inline-block;
  margin-top: 20px;
}
.passwordinput{
  width: 20%;
  display: inline-block;
  margin-top: 20px;
}
.loginbutton{
  margin-top: 20px;
  padding: 5px;
  display: inline-block;
}
.regbutton{
  margin-top: 20px;
  padding: 5px;
  display: inline-block;
}
.idtip{
  width: 4%;
  display: inline-block;
}
.passwordtip{
  width: 4%;
  display: inline-block;
}
</style>
