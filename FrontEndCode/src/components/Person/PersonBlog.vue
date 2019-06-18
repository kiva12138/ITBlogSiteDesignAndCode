<template>
  <div class="blogListBG">
    <a-list
    class="alist"
    itemLayout="vertical"
    size="large"
    bordered
    style="background-color:white"
    :pagination="pagination"
    :dataSource="myblogList"
  >
    <a-list-item slot="renderItem" slot-scope="item, index" :key="item.title">
      <!-- <template slot="actions" v-for="{type, text} in item.actions">
        <span :key="type">
          <a-icon :type="type" style="margin-right: 8px" />
          {{text}}
        </span>
      </template> -->
      <template slot="actions">
        <span key="readnum">
          <a-icon type="star-o" style="margin-right: 8px" />
          {{item.readNum}}
          <a-icon type="message" style="margin-right: 8px" />
          {{item.commentsNum}}
        </span>
      </template>
      <a-list-item-meta
        :description="item.title"
      >
        <a slot="title" @click="toABlog(item.blogId)">{{item.title}}</a>
      </a-list-item-meta>
      {{item.context}}
    </a-list-item>
  </a-list>
  </div>
</template>
<script>
export default {
  name: 'PersonBlog',
  mounted () {
    const self = this
    this.$ajax({
      method: 'get',
      url: '/ITBlogSiteBackEnd/blog/findbyuserid',
      params: {
        userId: self.$store.state.personInfo.userId
      }
    }).then(function (res) {
      if (parseInt(res.data.code) === 0) {
        self.myblogList = res.data.findBlog
      } else {
      }
    })
  },
  data () {
    return {
      myblogList: [],
      pagination: {
        onChange: (page) => {
          console.log(page)
        },
        pageSize: 5
      }
    }
  },
  methods: {
    initPersonBlog () {
      this.$ajax({
        method: 'get',
        url: '/ITBlogSiteBackEnd/blog/find',
        params: {
          blogId: 1000000001
        }
      }).then(function (res) {
        if (parseInt(res.data.code) === 0) {
          console.log(res.data)
        } else {
        }
      })
    },
    toABlog (blogURL) {
      this.$router.push({
        path: '/RewriteBlog/' + blogURL// 提供博客id，下一个页面根据博客id来获取博客内容
      })
    }
  }
}
</script>
<style>
.blogListBG{
    height: 1100px;
    margin: 0 10px;
}
.alist{
  width: 1200px;
}
</style>
