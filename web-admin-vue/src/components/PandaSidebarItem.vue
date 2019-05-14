<template>
  <div class="menu-wrapper">
      <el-menu-item :index="item.url">
        <span slot="title">{{item.name}}</span>
      </el-menu-item>
  </div>
</template>

<script>
export default {
  name: 'SidebarItem',
  props: {
    item: {
      type: Object,
      required: true
    }

  },
  data() {
    return {

    }
  },

}
</script>

