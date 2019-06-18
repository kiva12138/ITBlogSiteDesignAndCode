<template>
  <a-carousel autoplay >
    <div v-for="(item,index) in carouselItem" :key="index">
      <h1 >{{item.title}}</h1>
      <img :src="item.photo" @click="toABlog(item.url)">
    </div>
  </a-carousel>
</template>
<script>
export default {
  name: 'BlogCarousel',
  data () {
    return {
      carouselItem: [
        {
          title: 'first',
          url: '1000000001',
          photo: 'https://cn.bing.com/th?id=OHR.PantheraLeoDad_ZH-CN9580668524_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp'
        },
        {
          title: 'second',
          url: '1000000003',
          photo: 'https://cn.bing.com/th?id=OHR.SaskFlowers_ZH-CN9497517721_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp'
        },
        {
          title: 'third',
          url: '1000000006',
          photo: 'https://cn.bing.com/th?id=OHR.RioGrande_ZH-CN8091224199_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp'
        },
        {
          title: 'fourth',
          url: '1000000004',
          photo: 'https://cn.bing.com/th?id=OHR.PontadaPiedade_ZH-CN7717691454_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp'
        }
      ]
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
<style scoped>
  .ant-carousel >>> .slick-slide {
  text-align: center;
  height: 400px;
  line-height: 80px;
  overflow: hidden;
}
.ant-carousel >>> .slick-slide h1 {
  color: #fff;
  position: absolute;
  bottom: 0;
  margin-left: 30px;
}
</style>
