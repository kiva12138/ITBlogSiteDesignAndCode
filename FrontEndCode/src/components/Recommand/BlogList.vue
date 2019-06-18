<template>
  <div class="blogListBG">
    <a-list
    itemLayout="vertical"
    size="large"
    :pagination="pagination"
    :dataSource="myblogList"
  >
    <a-list-item slot="renderItem" slot-scope="item, index" :key="item.title">
      <template slot="actions">
        <span key="readnum">
          <a-icon type="star-o" style="margin-right: 8px" />
          {{item.readNum}}
          <a-icon type="message" style="margin-right: 8px" />
          {{item.commentsNum}}
        </span>
      </template>
      <img slot="extra" width="272" alt="logo" src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png" />
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
// import imgpath from '@/assets/th.jpg'
export default {
  name: 'BlogList',
  mounted () {
    const self = this
    this.$ajax({
      method: 'get',
      // url: '/ITBlogSiteBackEnd/blog/findlikebytitle',
      url: '/ITBlogSiteBackEnd/blog/findbytime',
      params: {
        // title: ''
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
    toABlog (blogURL) {
      this.$router.push({
        path: '/Ablog/' + blogURL// 提供博客id，下一个页面根据博客id来获取博客内容
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
</style>
