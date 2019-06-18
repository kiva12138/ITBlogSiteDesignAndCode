<template>
  <div id='Blog'>
    <div class="BlogContent">
      <div class="BlogCarousel">
        <BlogCarousel></BlogCarousel>
      </div>
      <div class="BlogItem">
        <BlogItem></BlogItem>
      </div>
    </div>
    <div class="Bloger">
      <Bloger></Bloger>
    </div>
  </div>
</template>
<script>
import BlogCarousel from './Blog/BlogCarousel'
import BlogItem from './Blog/BlogItem'
import Bloger from './Blog/Bloger'
export default {
  name: 'Blog',
  components: {
    'BlogCarousel': BlogCarousel,
    'BlogItem': BlogItem,
    'Bloger': Bloger
  }
}
</script>
<style scoped>
.BlogContent{
  width: 75%;
  display: inline-block;
  margin: 5px 5px;
}
.Bloger{
  position: absolute;
  top: 55px;
  width:24%;
  display: inline-block;
}
.BlogItem{
  margin-top: 5px;
}
</style>
