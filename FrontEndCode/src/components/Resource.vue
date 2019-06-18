<template>
  <div>
    <div class="left">
      <div class="resourceList">
        <ResourceList></ResourceList>
      </div>
    </div>
    <div class="right">
      <div class="resourceAction">
        <ResourceAction></ResourceAction>
      </div>
    </div>
  </div>
</template>
<script>
import ResourceList from './Resource/ResourceList'
import ResourceAction from './Resource/ResourceAction'
export default {
  name: 'Resource',
  components: {
    'ResourceList': ResourceList,
    'ResourceAction': ResourceAction
  }
}
</script>
<style scoped>
.left{
  width: 74%;
  margin: 3px;
  display: inline-block;
}
.right{
  width: 24%;
  display: inline-block;
  position: absolute;
  top:50px;
}

</style>
