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

    for (let i = 0; i <= 360; i++) {
      let t = (i / 180) * Math.PI;
      let r = Math.sin(2 * t) * Math.cos(2 * t);
      data.push([r, i]);
    }

    return {
      polar: {
        title : {
        text: '用户统计',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['iphone6','iphone6s','iphone7','iphoneX','iphone7plus']
    },
    series : [
        {
            name: '金额',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'1000'},
                {value:310, name:'2000'},
                {value:234, name:'3000'},
                {value:135, name:'4000'},
                {value:1548, name:'5000'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
      }
    };
  }
};
</script>