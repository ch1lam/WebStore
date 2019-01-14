<template>
  <div>
    <button @click="getData">get Data</button>
    <ve-line :data="chartData" :loading="loading" :data-empty="dataEmpty" :settings="chartSettings"></ve-line>
  </div>
</template>
<script>
import axios from "axios";

// const DATA_FROM_BACKEND = {
//   columns: ["name", "price"],
//   rows: [
//     { name: "a", price: 19810 },
//     { name: "b", price: 4398 },
//     { name: "c", price: 52910 }
//   ]
// };
// const EMPTY_DATA = {
//   columns: [],
//   rows: []
// };
export default {
  data() {
    this.chartSettings = {
      yAxisType: ["0,0a"]
    };
    return {
      chartData: {
        columns: [],
        rows: []
      },
      loading: false,
      dataEmpty: false
    };
  },
  methods: {
    getData() {
      this.loading = true;
      // 发起ajax请求获取数据
      axios
        .get("http://localhost:8080/searchGoods", {
          params: {
            data: "",
            type: "3"
          }
        })
        .then(res => {
          res.data.forEach(element => {
            this.chartData.columns = ["name", "price"];
            this.chartData.rows.push({
              name: element.name,
              price: element.price
            });
          });
          this.loading = false;
        }, 1000);
      // setTimeout(() => {
      //   this.chartData = this.chartData.rows.length
      //     ? EMPTY_DATA
      //     : DATA_FROM_BACKEND;
      //   this.dataEmpty = !this.chartData.rows.length;
      //   this.loading = false;
      // }, 1000);
    }
  },
  created() {
    this.getData();
  }
};
</script>