import Vue from "vue";
import Router from "vue-router";
import Home from "./views/home/home.vue";
import Login from "./views/login/login.vue";
import GoodsManager from "./views/home/goodsManager.vue"
import UserManager from "./views/home/userManager.vue"
import BillManager from "./views/home/billManager.vue"
import Chart from "./views/home/chart.vue"
import Chart2 from "./views/home/chart2.vue"

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "login",
      component: Login
    },
    {
      path: "/login",
      name: "login",
      component: Login
    },
    {
      path: "/home",
      name: "home",
      component: Home,
      children:[
        {
          path:"/goodsManager",
          name:"goodManager",
          component: GoodsManager
        },
        {
          path:"/userManager",
          name:"userManager",
          component: UserManager
        },
        {
          path:"/billManager",
          name:"billManager",
          component: BillManager
        },
        {
          path:"/chart",
          name:"chart",
          component: Chart
        },
        {
          path:"/chart2",
          name:"chart2",
          component: Chart2
        },
      ]
    },
    
    
  ]
});
