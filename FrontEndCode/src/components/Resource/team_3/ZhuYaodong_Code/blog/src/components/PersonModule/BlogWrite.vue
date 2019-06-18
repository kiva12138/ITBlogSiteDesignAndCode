<template>
  <div id="BlogWrite">
    <h3 class='blogwritetitle'>请撰写您的博客</h3>
    <el-form label-position="right" label-width="80px" :model="blogwritten"
              class="blogwriteform">
      <el-form-item label="标题">
        <el-input v-model="blogwritten.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="blogwritten.content"
          :autosize="{ minRows: 10}"
          type='textarea'></el-input>
      </el-form-item>
      <div class="blogsubmitbutton">
        <el-button type="primary" @click="handleCommitBlog">确 定</el-button>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'BlogWrite',
  data () {
    return {
      blogwritten: {
        title: '',
        content: ''
      }
    }
  },
  methods: {
    handleCommitBlog: function () {
      this.$router.push('/person')
      this.$message({
        message: '博客提交成功',
        type: 'success'
      })
    }
  }
}
</script>

<style>
#BlogWrite{
  margin-top: 80px;
}
.blogwriteform{
  margin-right: 40px;
  margin-left: 40px;
}
.blogwritetitle{
  text-align: center;
  color: #7B7D7D;
}
.blogsubmitbutton{
  text-align: center;
}
</style>
