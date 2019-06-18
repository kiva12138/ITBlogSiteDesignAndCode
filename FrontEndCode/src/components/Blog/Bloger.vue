<template>
  <div>
    <div class="blogerHead">
      <div class="block1"></div>
      <div class="block2"></div>
      <span>知名博主</span>
    </div>
    <hr>
    <ul >
      <li v-for="(blogerInfo,index) in blogerInfos" :key="index">
        <a-card hoverable>
          <img
          alt="example"
          :src="blogerInfo.photo"
          slot="cover"
          />
          <a-card-meta
          :title="blogerInfo.name"
          :description="blogerInfo.description">
          </a-card-meta>
        </a-card>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: 'Bloger',
  data () {
    return {
      blogerInfos: [
        {
          photo: 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png',
          name: 'name',
          description: 'This is the description'
        },
        {
          photo: 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png',
          name: 'name',
          description: 'This is the description'
        },
        {
          photo: 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png',
          name: 'name',
          description: 'This is the description'
        }
      ]
    }
  }
}
</script>
<style scoped>
ul{
  list-style-type : none;
  margin: 3px;
  padding: 0;
}
li{
  margin-bottom:8px;
}
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
