<template>
  <div>
    <el-container>
      <el-header style="text-align: right; font-size: 14px">
        <h2>网店管理系统</h2>
        <span>{{msg}}</span>
      </el-header>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "header",
  props: {
    msg: String
  }
};
</script>

<style scoped>
.el-header h2 {
  text-align: center;
}
</style>
