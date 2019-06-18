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
        <a-button class="publish" type="dashed" @click="publish">修改</a-button>
      </div>
    </div>
  </div>
</template>
<script>
import PersonInfo from './PersonInfo'
export default {
  name: 'RewriteBlog',
  components: {
    'PersonInfo': PersonInfo
  },
  mounted () {
    const self = this
    console.log(self.$route.params)
    this.$ajax({
      method: 'get',
      url: '/ITBlogSiteBackEnd/blog/find',
      params: {
        blogId: self.$route.params.id
      }
    }).then(function (res) {
      if (parseInt(res.data.code) === 0) {
        self.addBlog.title = res.data.findBlogById.title
        self.addBlog.context = res.data.findBlogById.context
        self.addBlog.authorId = res.data.findBlogById.authorId
      } else {
      }
    })
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
      console.log(this.addBlog)
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/blog/updatecontext',
        params: {
          blogId: self.$route.params.id,
          context: self.addBlog.context
        }
      })
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/blog/updatetime',
        params: {
          blogId: self.$route.params.id,
          time: self.addBlog.time
        }
      })
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/blog/updatetitle',
        params: {
          blogId: self.$route.params.id,
          title: self.addBlog.title
        }
      }).then(function (res) {
        if (parseInt(res.data.code) === 0) {
          self.$message.success('Changed successfully!')
          self.$router.push({
            'path': '/Person'
          })
        } else {
          self.$message.error('Changed error!')
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
