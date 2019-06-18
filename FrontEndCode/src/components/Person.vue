<template>
  <div class="personBlock">
    <div class="left">
      <div class="personInfo">
        <PersonInfo></PersonInfo>
      </div>
    </div>
    <div class="right">
      <div class="personBlog">
        <PersonBlog></PersonBlog>
      </div>
    </div>
  </div>
</template>
<script>
import PersonInfo from './Person/PersonInfo'
import PersonBlog from './Person/PersonBlog'
export default {
  name: 'Person',
  components: {
    'PersonInfo': PersonInfo,
    'PersonBlog': PersonBlog
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
  margin: 5px;
  width: auto;
  display: inline-block;
  position: absolute;
  top:48px;
  left:270px;
}
</style>
