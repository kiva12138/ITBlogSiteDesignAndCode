<template>
  <div class="blogListBG">
    <a-list
    itemLayout="vertical"
    size="middle"
    :pagination="pagination"
    :dataSource="myblogList"
    bordered="ture"
  >
    <!-- <div slot="footer"><b>ant design vue</b> footer part</div> -->
    <a-list-item slot="renderItem" slot-scope="item, index" :key="item.title">
      <a-list-item-meta
      >
        <a slot="title" @click="toABlog(item.blogId)">{{item.title}}[{{item.time}}]</a>
      </a-list-item-meta>
      {{item.context}}
    </a-list-item>
  </a-list>
  </div>
</template>
<script>
export default {
  name: 'BlogItem',
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
    height: 1000px;
}
</style>
