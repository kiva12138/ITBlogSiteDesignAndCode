<template>
  <div>
  <div class="left">
    <div class="bbsNotify">
      <BbsNotify></BbsNotify>
    </div>
    <div class="bbsFilter">
      <BbsFilter></BbsFilter>
    </div>
    <div class="bbsList">
      <BbsList></BbsList>
    </div>
  </div>
  <div class="right">
    <div class="bbsRecommand">
      <BbsRecommand></BbsRecommand>
    </div>
  </div>
  </div>
</template>
<script>
import BbsNotify from './Bbs/BbsNotify'
import BbsFilter from './Bbs/BbsFilter'
import BbsList from './Bbs/BbsList'
import BbsRecommand from './Bbs/BbsRecommand'
export default {
  name: 'Bbs',
  components: {
    'BbsNotify': BbsNotify,
    'BbsFilter': BbsFilter,
    'BbsList': BbsList,
    'BbsRecommand': BbsRecommand
  }
}
</script>
<style scoped>
.left{
  width: 74%;
  display: inline-block;
}
.right{
  position: absolute;
  margin-top:3px;
  margin-left: 5px;
  height: 1000px;
  width: 24%;
  display: inline-block;
}
.bbsNotify{
  margin: 3px;
}
.bbsFilter{
  margin: 3px;
}
.bbsList{
  margin: 3px;
  background-color: white;
}
</style>
