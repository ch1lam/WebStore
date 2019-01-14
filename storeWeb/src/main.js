import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './plugins/element.js'
import VCharts from 'v-charts'

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(VCharts)

new Vue({
  el: '#app',
  router,
  render: h => h(App)
}).$mount('#app')
