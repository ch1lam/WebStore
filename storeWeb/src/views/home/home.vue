<template>
  <div>
    <el-container style="height: 960px">
      <Aside></Aside>
      <el-main>
        <transition>
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </transition>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Aside from "../../components/aside";
export default {
  components: {
    Aside
  }
};
</script>

<style scoped>
</style>
