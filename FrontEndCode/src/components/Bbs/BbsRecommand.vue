<template>
  <div>
    <div class="blogerHead">
      <div class="block1"></div>
      <div class="block2"></div>
      <span>热帖推荐</span>
    </div>
    <a-collapse accordion header="ddfsdfs">
      <a-collapse-panel header="This is panel header 1" key="1">
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
      <a-collapse-panel header="This is panel header 2" key="2" :disabled='false'>
        <p>{{text}}</p>
      </a-collapse-panel>
      <a-collapse-panel header="This is panel header 3" key="3">
        <p>{{text}}</p>
      </a-collapse-panel>
    </a-collapse>
  </div>
</template>
<script>
const data = [
  'Racing car sprays burning fuel into crowd.',
  'Japanese princess to wed commoner.',
  'Australian walks 100km after outback crash.'
]
export default {
  name: 'BbsRecommand',
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
