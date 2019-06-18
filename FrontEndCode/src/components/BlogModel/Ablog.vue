<template>
  <div>
    <div class="left">
      <div class="content">
        <div class="title"><h1>{{blogInfo.title}}</h1></div>
        <div class="info">{{blogInfo.time}}</div>
        <hr>
        <div class="main">{{blogInfo.context}}</div>
      </div>
      <div class="comment">
        <div>
          <a-list
            size="large"
            bordered
            :dataSource="commentInfo"
          >
            <a-list-item slot="renderItem" slot-scope="item, index">
              <strong>{{item.authorId}}于{{item.time}}:</strong>
              {{item.content}}
            </a-list-item>
          </a-list>
        </div>
        <div v-if="this.$store.state.isLogin" class="writecomment">
          <div style="margin: 24px 0" />
          <a-textarea  :autosize="{ minRows: 2, maxRows: 6 }" v-model="newComment"/>
          <a-button class="combut" @click="write">评论</a-button>
        </div>
      </div>
    </div>
    <div class="right">
      <div class="author">
        <a-card
          hoverable
          style="width: 240px"
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
    </div>
  </div>
</template>
<script>
import Comment from './Comment'
export default {
  components: {
    'Comment': Comment
  },
  mounted () {
    let self = this
    this.$ajax({
      method: 'get',
      url: '/ITBlogSiteBackEnd/blog/find',
      params: {
        blogId: self.$route.params.id
      }
    }).then(function (res) {
      if (parseInt(res.data.code) === 0) {
        self.blogInfo = res.data.findBlogById
        console.log(res.data)
      } else {
      }
    })
    this.$ajax({
      method: 'post',
      url: '/ITBlogSiteBackEnd/blog/updatereadnum',
      params: {
        blogId: self.$route.params.id
      }
    }).then(function (res) {
      if (parseInt(res.data.code) === 0) {
      } else {
      }
    })
    this.$ajax({
      method: 'get',
      url: '/ITBlogSiteBackEnd/comment/getcommentbyblog',
      params: {
        blogId: self.$route.params.id
      }
    }).then(function (res) {
      if (parseInt(res.data.code) === 0) {
        self.commentInfo = res.data.comments
        console.log(self.commentInfo)
      } else {
      }
    })
  },
  name: 'ABlog',
  data () {
    return {
      newComment: '',
      commentInfo: [],
      blogInfo: {},
      personInfo: {
        age: 10,
        blogNum: 8,
        gender: 'man',
        name: 'rzk',
        phone: 18263635928,
        userId: 10000013
      }
    }
  },
  methods: {
    write () {
      var visitId = this.$store.state.personInfo.userId
      var myDate = new Date()
      var comtime = myDate.getFullYear() + '-' + (parseInt(myDate.getMonth()) + 1) + '-' + myDate.getDate()
      var commentContent = this.newComment
      this.commentInfo.push({
        'commentId': '',
        'blogId': this.blogInfo.blogId,
        'time': comtime,
        'authorId': visitId,
        'content': commentContent
      })
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/comment/addcomment',
        params: {
          blogId: this.blogInfo.blogId,
          authorId: visitId,
          content: commentContent,
          time: comtime
        }
      }).then(function (res) {
        if (parseInt(res.data.code) === 0) {
        } else {
        }
        console.log(res.data)
      })
      this.$ajax({
        method: 'post',
        url: '/ITBlogSiteBackEnd/blog/updatecommentsnum',
        params: {
          blogId: this.blogInfo.blogId
        }
      }).then(function (res) {
        if (parseInt(res.data.code) === 0) {
        } else {
        }
      })
      this.newComment = ''
    }
  }
}
</script>
<style scoped>
.left{
  margin:10px;
  width: 73%;
  height:1200px;
  display: inline-block;
  vertical-align: top;
}
.right{
  vertical-align: top;
  margin:10px;
  width: 24%;
  display: inline-block;
}
.content{
  padding: 5px;
  height:600px;
  border:1px solid;
  border-radius:5px;
  border-color:gainsboro;
}
.comment{
  margin-top:20px;
}
.combut{
  margin-top:10px;
}
</style>
