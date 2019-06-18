<template>
   <div>
      <RecommandCarousel></RecommandCarousel>
      <BlogList></BlogList>
   </div>
</template>
<script>
import RecommandCarousel from './Recommand/RecommandCarousel'
import BlogList from './Recommand/BlogList'
export default {
  name: 'Recommand',
  components: {
    'RecommandCarousel': RecommandCarousel,
    'BlogList': BlogList
  }
}
</script>
<style>

</style>
