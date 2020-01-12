import Vue from 'vue'
import App from './App.vue'
Vue.config.productionTip = false
import VueLogger from 'vuejs-logger';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css'
import vuetify from './plugins/vuetify';

const options = {
  isEnabled: true,
  logLevel : 'debug',
  stringifyArguments : false,
  showLogLevel : true,
  showMethodName : false,
  separator: '|',
  showConsoleColors: true
};
export const bus = new Vue();
export const bus2 = new Vue();
Vue.use(VueLogger, options);
Vue.use(Vuetify);
new Vue({
  el: '#app',
  template: '<App/>',
  vuetify,
  components: { App }
});

/*/

new Vue({
  render: h => h(App),
}).$mount('#app')
*/