<template>
  <div id="AccountOperation">
    <span class='personopline'></span>
    <h3 class='personoptitle'>您可以</h3>
    <div class='personopmain'>
      <el-button type="primary" v-on:click='modifyProfile = true'>修改资料</el-button>
      <el-button type="primary" v-on:click='modifyPassword = true'>修改密码</el-button>
      <el-button type="primary" v-on:click='logout'>退出登录</el-button>
    <el-dialog title="修改密码" :visible.sync="modifyPassword" center width='40%'>
      <el-form>
        <el-form-item label="输入旧密码" :label-width="formLabelWidth">
          <el-input v-model="oldpass" type='password' placeholder="请输入旧密码"></el-input>
        </el-form-item>
        <el-form-item label="输入新密码" :label-width="formLabelWidth">
          <el-input v-model="newpass" type='password' placeholder="请输入新密码"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="modifyPassword = false">取 消</el-button>
        <el-button type="primary" @click="handleModifyPassword">确 定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="修改资料" :visible.sync="modifyProfile" center width='40%'>
      <el-form>
        <el-form-item label="新用户名" :label-width="formLabelWidth">
          <el-input v-model="newname" placeholder="请输入新用户名"></el-input>
        </el-form-item>
        <el-form-item label="新手机号" :label-width="formLabelWidth">
          <el-input v-model="newphone" placeholder="请输入新手机号"></el-input>
        </el-form-item>
        <el-form-item label="生日更改" :label-width="formLabelWidth">
          <el-date-picker v-model="newbirth" type="date"
            placeholder="选择日期" format='yyyy-MM-dd'/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="modifyProfile = false">取 消</el-button>
        <el-button type="primary" @click="handleModifyProfile">确 定</el-button>
      </div>
    </el-dialog>
    </div>
    <div class="accountop">
      <el-button type="primary" v-on:click="handleWriteBlog">撰写博客</el-button>
      <el-button type="primary" v-on:click="handleWriteQues">提问问题</el-button>
      <el-button type="primary" v-on:click="handleUploadRes">上传资源</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AccountOperation',
  data () {
    return {
      modifyPassword: false,
      oldpass: null,
      newpass: null,
      formLabelWidth: '120px',
      modifyProfile: false,
      newname: null,
      newphone: null,
      newbirth: null
    }
  },
  methods: {
    logout: function () {
      this.$session.destroy()
      this.$cookie.delete('login')
      this.$cookie.delete('username')
      this.$cookie.delete('phone')
      this.$cookie.delete('regtime')
      this.$cookie.delete('numofblog')
      this.$cookie.delete('numofques')
      this.$cookie.delete('numofres')
      this.$cookie.delete('birth')
      this.$cookie.delete('userblogs')
      this.$cookie.delete('userques')
      this.$cookie.delete('userres')
      this.$router.push('/login')
    },
    handleModifyProfile: function () {
      this.modifyProfile = false
      this.$message({
        message: '修改成功',
        type: 'success'
      })
    },
    handleModifyPassword: function () {
      this.modifyPassword = false
      this.$message({
        message: '修改成功',
        type: 'success'
      })
    },
    handleWriteBlog: function () {
      this.$router.push('/BlogWrite')
    },
    handleWriteQues: function () {
      this.$router.push('/QuesWrite')
    },
    handleUploadRes: function () {
      this.$router.push('/ResUpload')
    }
  }
}
</script>

<style>
#AccountOperation{
  margin-top: 20px;
  text-align: left;
}
.personopline{
  padding-left: 10px;
  margin-left: 30px;
  background: #2E86C1;
}
.personoptitle{
  color: #2E86C1;
  padding-left: 20px;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  display: inline-block;
}
.personopmain{
  margin-left: 40px;
  margin-top: 40px;
}
.accountop{
  margin-left: 40px;
  margin-top: 20px;
}
</style>
