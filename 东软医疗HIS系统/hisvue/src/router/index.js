import Vue from 'vue'
import VueRouter from 'vue-router'

//安装vueRouter插件，对vue功能的扩展
Vue.use(VueRouter)

export default new VueRouter({
	routes:[
		{
			path:"/",
			redirect:'/login'//重定向
		},
		{
			name:"login",
			path:"/login",
			component: ()=> import("../views/login.vue")
		},
		{
			name:"mainpage",
			path:"/mainpage",
			component: ()=> import("../views/mainpage.vue")
		},
		{
			name:"test",
			path:"/test",
			component: ()=> import("../views/test.vue")
		}
	]
});