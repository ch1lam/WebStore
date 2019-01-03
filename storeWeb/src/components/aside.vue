<template>
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu router :default-openeds="['1','2']">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-menu"></i>管理
        </template>
        <el-menu-item-group>
          <el-menu-item index="goodsManager">商品管理</el-menu-item>
          <el-menu-item index="userManager">用户管理</el-menu-item>
          <el-menu-item index="billManager">订单管理</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-tickets"></i>统计
        </template>
        <el-menu-item-group>
          <el-menu-item index="chart">统计示例</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <el-menu-item index="chart2">统计示例</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>
</template>
<script>
</script>
<style scoped>
</style>
