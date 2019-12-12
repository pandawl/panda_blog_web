<template>
  <a-tree-select
    :allowClear="true"
    :dropdownStyle="{ maxHeight: '220px', overflow: 'auto' }"
    :treeData="deptTreeData"
    v-model="value">
  </a-tree-select>
</template>

<script>
  import userApi from '@/api/user'
export default {
  name: 'DetpInputTree',
  data () {
    return {
      deptTreeData: [],
      value: undefined
    }
  },
  methods: {
    reset () {
      this.value = ''
    }
  },
  mounted () {
 /*   this.$get('dept').pm((r) => {
      this.deptTreeData = r.data.rows.children
    })*/
    userApi.dept().then((r)=>{
      this.deptTreeData = r.data.data.rows.children
    })
  },
  watch: {
    value (value) {
      this.$emit('change', value)
    }
  }
}
</script>
