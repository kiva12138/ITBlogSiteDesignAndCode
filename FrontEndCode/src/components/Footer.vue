<template>
  <div id='footer'>
    {{info}}
  </div>
</template>
<script>
export default {
  name: 'Footer',
  data () {
    return {
      info: '京ICP备*******号 京公网安备*********号'
    }
  }
}
</script>
<style scoped>
#footer{
  text-align: center;
  color: rgb(197, 197, 197);
  position: relative;
  margin-bottom: 10px;
}
</style>
