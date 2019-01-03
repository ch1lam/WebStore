<template>
  <v-chart :options="polar"/>
</template>

<style>
.echarts {
  width: 100%;
  height: 100%;
}
</style>

<script>
import ECharts from "vue-echarts/components/ECharts";
import "echarts/lib/chart/line";
import "echarts/lib/component/polar";

export default {
  components: {
    "v-chart": ECharts
  },
  data: function() {
    let data = [];

    for (let i = 0; i <= 800; i++) {
      let t = (i / 180) * Math.PI;
      let r = Math.sin(2 * t) * Math.cos(2 * t);
      data.push([r, i]);
    }

    return {
      polar: {
        xAxis: {
          type: "category",
          data: ["iphone6", "iphone6s", "iphone7", "iphone7plus", "iphone8", "iphone8plus", "iphoneX"]
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            data: [1537, 2040, 3800, 4500, 6102, 8450, 10500],
            type: "line"
          }
        ]
      }
    };
  }
};
</script>