<template>
<div>
  <a-list
    size="large"
    bordered
    :dataSource="data"
  >
    <a-list-item slot="renderItem" slot-scope="item, index">
      {{item}}
      <div>[版块x]</div>
      <div class="pushTime">发布时间：xxxx.xx.xx xx:xx:xx</div>
    </a-list-item>
  </a-list>
</div>
</template>
<script>
const data = [
  'Racing car sprays burning fuel into crowd.',
  'Japanese princess to wed commoner.',
  'Australian walks 100km after outback crash.',
  'Man charged over missing wedding girl.',
  'Los Angeles battles huge wildfires.',
  'Racing car sprays burning fuel into crowd.',
  'Japanese princess to wed commoner.',
  'Australian walks 100km after outback crash.',
  'Man charged over missing wedding girl.',
  'Los Angeles battles huge wildfires.',
  'Racing car sprays burning fuel into crowd.',
  'Japanese princess to wed commoner.',
  'Australian walks 100km after outback crash.',
  'Man charged over missing wedding girl.',
  'Los Angeles battles huge wildfires.'
]

export default {
  name: 'BbsList',
  data () {
    return {
      data
    }
  }
}
</script>
<style>
.pushTime{
  position:absolute;
  right:20px;
}
</style>
