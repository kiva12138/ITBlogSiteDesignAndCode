<template>
  <a-card class="card" title="版块筛选" bordered="true">
    <div>
    <div :style="{ borderBottom: '1px solid #E9E9E9' }">
      <a-checkbox
        :indeterminate="indeterminate"
        @change="onCheckAllChange"
        :checked="checkAll"
      >
        Check all
      </a-checkbox>
    </div>
    <br />
    <a-checkbox-group :options="plainOptions" v-model="checkedList" @change="onChange" />
  </div>
  </a-card>
</template>
<script>
const plainOptions = ['版块1', '版块2', '版块3', '版块4', '版块5']
const defaultCheckedList = []
export default {
  name: 'BbsFilter',
  data () {
    return {
      checkedList: defaultCheckedList,
      indeterminate: true,
      checkAll: false,
      plainOptions
    }
  },
  methods: {
    onChange (checkedList) {
      this.indeterminate = !!checkedList.length && (checkedList.length < plainOptions.length)
      this.checkAll = checkedList.length === plainOptions.length
    },
    onCheckAllChange (e) {
      Object.assign(this, {
        checkedList: e.target.checked ? plainOptions : [],
        indeterminate: false,
        checkAll: e.target.checked
      })
    }
  }
}
</script>
<style scoped>
</style>
