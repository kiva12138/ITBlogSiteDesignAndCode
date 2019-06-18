<template>
  <div id="QuesWrite">
    <h3 class='queswritetitle'>请撰写您的问题</h3>
    <el-form label-position="right" label-width="80px" :model="queswritten"
              class="queswriteform">
      <el-form-item label="标题">
        <el-input v-model="queswritten.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="queswritten.content"
          :autosize="{ minRows: 10}"
          type='textarea'></el-input>
      </el-form-item>
      <div class="quessubmitbutton">
        <el-button type="primary" @click="handleCommitQues">确 定</el-button>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'QuesWrite',
  data () {
    return {
      queswritten: {
        title: '',
        content: ''
      }
    }
  },
  methods: {
    handleCommitQues: function () {
      this.$router.push('/person')
      this.$message({
        message: '问题提交成功',
        type: 'success'
      })
    }
  }
}
</script>

<style>
#QuesWrite{
  margin-top: 80px;
}
.queswriteform{
  margin-right: 40px;
  margin-left: 40px;
}
.queswritetitle{
  text-align: center;
  color: #7B7D7D;
}
.quessubmitbutton{
  text-align: center;
}
</style>
