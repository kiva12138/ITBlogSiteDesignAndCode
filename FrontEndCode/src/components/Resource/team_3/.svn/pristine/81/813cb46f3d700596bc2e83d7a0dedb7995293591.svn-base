<template>
  <div id="ResWrite">
    <h3 class='reswritetitle'>请上传您的资源</h3>
    <el-form label-position="right" label-width="80px" :model="reswritten"
              class="reswriteform">
      <el-form-item label="资源标题">
        <el-input v-model="reswritten.title"></el-input>
      </el-form-item>
      <el-form-item label="资源描述">
        <el-input v-model="reswritten.content"
          :autosize="{ minRows: 2}"
          type='textarea'></el-input>
      </el-form-item>
      <el-upload
        class="uploadres"
        drag
        action="https://jsonplaceholder.typicode.com/posts/"
        v-bind:multiple='multiple'>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">只能上传不超过50Mb文件</div>
      </el-upload>
      <div class="ressubmitbutton">
        <el-button type="primary" @click="handleCommitRes">确 定</el-button>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'ResWrite',
  data () {
    return {
      reswritten: {
        title: '',
        content: ''
      },
      multiple: false
    }
  },
  methods: {
    handleCommitRes: function () {
      this.$router.push('/person')
      this.$message({
        message: '资源上传成功',
        type: 'success'
      })
    }
  }
}
</script>

<style>
#ResWrite{
  margin-top: 80px;
}
.reswriteform{
  margin-right: 40px;
  margin-left: 40px;
}
.reswritetitle{
  text-align: center;
  color: #7B7D7D;
}
.ressubmitbutton{
  text-align: center;
  margin-top: 40px;
}
.uploadres{
  text-align: center;
}
</style>
