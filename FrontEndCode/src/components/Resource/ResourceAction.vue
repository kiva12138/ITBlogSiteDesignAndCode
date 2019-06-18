<template>
  <div>
    <a-collapse>
      <a-collapse-panel header="资源板块公告" key="1">
        <div calss="inList">
          <a-list
            size="large"
            :dataSource="data"
          >
            <a-list-item slot="renderItem" slot-scope="item, index">
            {{item}}
            </a-list-item>
          </a-list>
        </div>
      </a-collapse-panel>
      <a-collapse-panel header="排序" key="2" :disabled='false'>
        <ResourceFilter></ResourceFilter>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
<script>
import ResourceFilter from './ResourceFilter'
const data = [
  'aaaaaaaaaaaaaaaaa',
  'aaaaaaaaaaaaaaavvvvvvvvvv',
  'xxxxxxxxxxxxxxxxxxxxxxxx'
]
export default {
  name: 'ResourceAction',
  components: {
    'ResourceFilter': ResourceFilter
  },
  data () {
    return {
      data,
      text: `A dog is a type of domesticated animalds across the world.`
    }
  }
}
</script>
<style scoped>
.block1{
  background-color: rgba(80, 145, 175, 0.8);
  width: 10px;
  height: 50px;
  display: inline-block;
  position: absolute;
  margin:auto;
}
.block2{
  background-color: rgba(80, 145, 175, 0.8);
  width: 3px;
  height: 50px;
  display: inline-block;
  position: absolute;
  margin:auto;
  left:12px;
}
span{
  font-size: 35px;
  margin-left: 20px;
}
</style>
