import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './plugins/element.js'
import ECharts from 'vue-echarts/components/ECharts.vue'
import 'echarts/lib/chart/bar'
import 'echarts/lib/component/tooltip'
import 'echarts/lib/chart/pie'

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.component('v-chart', ECharts)


new Vue({
  el: '#app',
  router,
  render: h => h(App)
}).$mount('#app')
