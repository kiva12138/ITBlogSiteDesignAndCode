<template>
  <div>
    <a-modal
      title="修改信息"
      :visible="visible"
      @ok="handleOk"
      :confirmLoading="confirmLoading"
      @cancel="handleCancel"
    >
      <div>
        <a-input class="ainput"
          :placeholder="personInfo.name"
          v-model="registerInfo.name"
          disabled
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
      </div>
    </a-modal>
    <a-card
      hoverable
      style="width: 240px"
      @click="showModal"
    >
      <img
          alt="example"
          src="@/assets/th.jpg"
          slot="cover"
      />
      <a-card-meta
          :title="personInfo.name">
          <template slot="description">
          <div class="age">Age:{{personInfo.age}}</div>
          <div class="gender">Gender:{{personInfo.gender}}</div>
          <div class="blognum">BlogNum:{{personInfo.blogNum}}</div>
          <div class="phone">Phone:{{personInfo.phone}}</div>
          </template>
      </a-card-meta>
    </a-card>
  </div>
</template>
<script>
export default {
  name: 'PersonInfo',
  data () {
    return {
      ModalText: 'Content of the modal',
      visible: false,
      confirmLoading: false,
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
  computed: {
    loginInfo () {
      return this.$store.state.loginInfo
    },
    personInfo () {
      return this.$store.state.personInfo
    }
  },
  methods: {
    pwBlur () {
      if (this.registerInfo.password !== this.confirmpw) {
        this.confirmpw = ''
        this.$message.error('Confirm Password Error!')
      }
    },
    showModal () {
      this.visible = true
      console.log(this.personInfo)
    },
    handleOk (e) {
      let self = this
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/user/updatepassword',
        params: {
          userId: this.personInfo.userId,
          password: this.registerInfo.password
        }
      }).then(function (res) {
        console.log(res.data)
      })
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/user/updateage',
        params: {
          userId: this.personInfo.userId,
          age: this.registerInfo.age
        }
      }).then(function (res) {
        self.personInfo.age = self.registerInfo.age
        console.log(res.data)
      })
      this.visible = false
    },
    handleCancel (e) {
      console.log('Clicked cancel button')
      this.visible = false
    }
  }
}
</script>
<style>
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
