<template>
  <div>
    <div class="left">
      <PersonInfo></PersonInfo>
    </div>
    <div class="right">
      <div class="right1">
        标题:
        <a-input class="title" v-model="addBlog.title"/>
      </div>
      <div class="right2">
        作者:
        <a-input class="author" v-model="personInfo.name" disabled/>
      </div>
      <div class="right3">
        内容:<a-textarea
          class="context"
          v-model="addBlog.context"
          :autosize="{ minRows: 15 ,maxRows: 35}"
        />
      </div>
      <div class="right4">
        <a-button class="publish" type="dashed" @click="publish">发布</a-button>
      </div>
    </div>
  </div>
</template>
<script>
import PersonInfo from './PersonInfo'
export default {
  name: 'WriteBlog',
  components: {
    'PersonInfo': PersonInfo
  },
  data () {
    return {
      addBlog: {
        title: '',
        context: '',
        authorId: '',
        time: ''
      }
    }
  },
  computed: {
    personInfo () {
      return this.$store.state.personInfo
    }
  },
  methods: {
    publish () {
      let self = this
      var myDate = new Date()
      this.addBlog.time = myDate.getFullYear() + '-' + (parseInt(myDate.getMonth()) + 1) + '-' + myDate.getDate()
      this.addBlog.authorId = this.personInfo.userId
      console.log(this.addBlog)
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/blog/addblog',
        params: {
          title: this.addBlog.title,
          context: this.addBlog.context,
          authorId: parseInt(this.addBlog.authorId),
          time: this.addBlog.time
        }
      }).then(function (res) {
        if (parseInt(res.data.code) === 0) {
          self.$message.success('Published successfully!')
          self.$router.push({
            'path': 'Person'
          })
        } else {
          self.$message.error('Published error!')
        }
        console.log(res.data)
      })
    }
  }
}
</script>
<style scoped>
.left{
  margin-left: 25px;
  margin-top:5px;
  height: 1000px;
  display: inline-block;
  vertical-align: top;
}
.right{
  margin: 5px 5px 5px 10px;
  width: 75%;
  height: 1000px;
  display: inline-block;
  position: absolute;
  top:48px;
  left:270px;
}
.title{
  width: 80%;
  height: 40px;
  margin:10px 9px;
}
.author{
  width: 20%;
  height: 40px;
  margin:10px 9px;
}
.context{
  height: 600px;
  width: 80%;
  margin:8px 10px 10px 14px;
  vertical-align: top;
}
.publish{
  margin:5px 0px 0px 45px;
}
</style>
