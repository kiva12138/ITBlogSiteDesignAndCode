<template>
  <div id="Person">
    <div id='personaldetail'>
      <personaldetail/>
    </div>
    <div id='accountoperation'>
      <accountoperation/>
    </div>
  </div>
</template>

<script>
import AccountOperation from './PersonModule/AccountOperation.vue'
import PersonalDetail from './PersonModule/PersonalDetail.vue'
export default {
  name: 'Person',
  components: {
    'accountoperation': AccountOperation,
    'personaldetail': PersonalDetail
  }
}
</script>

<style>
#Person {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 40px;
  width: 100%;
  text-align: left;
}
#personaldetail{
  width: 50%;
  display: inline-block;
}
#accountoperation{
  width: 45%;
  display: inline-block;
  vertical-align: top;
}
</style>
