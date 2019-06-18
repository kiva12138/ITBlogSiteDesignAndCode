<template>
  <div id="persondetail">
    <span class='persondetailline'></span>
    <h3 class='persondetailtitle'>您的用户信息</h3>
    <div class='mainpersondetail'>
      <div class='detailedinfo'>
        <div class='part1'>
          <p class='personalname'>昵称: {{personalName}}</p>
          <p class='personalphone'>手机号: {{personalPhone}}</p>
          <p class='personalregtime'>注册时间: {{personalRegTime}}</p>
          <p class='personalbirth'>生日: {{birthDate}}</p>
        </div>
        <div class='part2'>
          <p class='numofblogs'>已发表博客数: {{numOfBlogs}}</p>
          <p class='numofques'>论坛提问数: {{numOfQues}}</p>
          <p class='numofres'>上传资源数: {{numOfRes}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PersonalDetail',
  data () {
    return {
      personalName: null,
      personalRegTime: null,
      personalPhone: null,
      birthDate: null,
      numOfBlogs: null,
      numOfQues: null,
      numOfRes: null
    }
  },
  created: function () {
    this.personalName = this.$cookie.get('username')
    this.personalRegTime = this.$cookie.get('regtime')
    this.personalPhone = this.$cookie.get('phone')
    this.birthDate = this.$cookie.get('birth')
    this.numOfBlogs = this.$cookie.get('numofblog')
    this.numOfQues = this.$cookie.get('numofques')
    this.numOfRes = this.$cookie.get('numofres')
  }
}
</script>

<style>
#persondetail{
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 20px;
  text-align: left;
  display: block;
}
.persondetailline{
  padding-left: 10px;
  margin-left: 30px;
  background: #2E86C1;
}
.persondetailtitle{
  color: #2E86C1;
  padding-left: 20px;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  display: inline-block;
}
.mainpersondetail{
  display: block-inline;
  margin-left: 40px;
  margin-right: 40px;
}
.persondetailhead{
  padding-right: 30px;
  padding-top: 30px;
  vertical-align: top;
}
.detailedinfo{
  display: inline-block;
}
.part1{
  display: inline-block;
}
.part2{
  margin-left: 40px;
  vertical-align: top;
  display: inline-block;
}
</style>
