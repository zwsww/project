import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
// import 'font-awesome/css/font-awesome.min.css'
import qs from 'qs'
import {
	setSessionStorage,
	getCurDate,
	getSessionStorage,
	removeSessionStorage,
	setLocalStorage,
	getLocalStorage,
	removeLocalStorage
} from './common.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import { Message } from 'element-ui'

Vue.use(ElementUI)

Vue.config.productionTip = false
axios.defaults.baseURL = "http://localhost:8089/";
axios.defaults.withCredentials=true;
axios.interceptors.response.use(resp=>{
		if(resp.data.result == "error"){
			
			Message({
				message:resp.data.data,
				type:"error"
			});
		}else{
			return resp;
		}
	},
	error=>{
		Message({
			message:error,
			type:"error"
		});
		return Promise.reject(error);
	}
)

Vue.prototype.$qs = qs
Vue.prototype.$setSessionStorage = setSessionStorage;
Vue.prototype.$getCurDate = getCurDate;
Vue.prototype.$getSessionStorage = getSessionStorage;
Vue.prototype.$removeSessionStorage = removeSessionStorage;
Vue.prototype.$setLocalStorage = setLocalStorage;
Vue.prototype.$getLocalStorage = getLocalStorage;
Vue.prototype.$removeLocalStorage = removeLocalStorage;

new Vue({
   //render:渲染函数，h:createElement函数
  render: h => h(App),
  router,
}).$mount('#app')
