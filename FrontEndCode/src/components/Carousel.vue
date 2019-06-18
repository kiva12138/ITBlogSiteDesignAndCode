<template>
  <a-carousel autoplay >
    <div v-for="(item,index) in carouselItem" :key="index">
      <h1>{{item.title}}</h1>
      <img :src="item.photo">
    </div>
  </a-carousel>
</template>
<script>
export default {
  name: 'Carousel',
  data () {
    return {
      carouselItem: [
        {
          title: 'first',
          photo: ''
        },
        {
          title: 'second',
          photo: ''
        },
        {
          title: 'third',
          photo: ''
        },
        {
          title: 'fourth',
          photo: ''
        }
      ]
    }
  }
}
</script>
<style scoped>
  .ant-carousel >>> .slick-slide {
  text-align: center;
  height: 400px;
  line-height: 80px;
  background: #364d79;
  overflow: hidden;
}
.ant-carousel >>> .slick-slide h1 {
  color: #fff;
  position: absolute;
  bottom: 0;
  margin-left: 30px;
}
</style>
