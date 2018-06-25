-------------------------------------------------------------------------------------------
vue 2.x笔记
node install->cnpm install->webpack install->vue-cli install
->vue init webpack pra02->cd pra02->cnpm install->cnpm run dev
如果cnpm run dev失败 检查下来是vue-cli的问题，就先npm卸载vue-cli，然后参照http://www.jb51.net/article/126221.htm进行设置，
可能再需要清理npm cache clean --force或者手动删除根目录的npm cache文件夹，最后目的就是要用npm安装vue-cli成功。
然后vue-cli就不会有问题了，可以正常cnpm run dev启动项目了。
-------------------------------------------------------------------------------------------
全局
主模板主组件 pra02/src/App.vue
new Vue({
el:'#app',
data:{
a:'aaaa',
isShow:true,
items:[{label:'apple'},{label:'banana'}]
},
methods:{
doSth:function(){
console.log(this.a);
}
},
//监听值的变化
watch:{
'a':function(val,oldVal){
console.log(val,oldVal);
}
},
//注册组件
components:{
Header,Footer,componentsA
},
//调用的时候<component-a></component-a>
//props组件间的通信 父传子 暴露的接口
props:['msg'],
//如
//主页面
//<header msg='sth intersting'></header>
//子组件的js获取主页面传来的数据，通过msg接口
//子组件也可以直接获取到msg变量
//<h1>{{msg}}</h1>
//new Vue({
// data:{},
// props:['msg'],
// methods:{
// doThis:function(){
// console.log(this.msg);
// }
// }
//})
});
-------------------------------------------------------------------------------------------
实例属性
vm.$parent获取父实例
vm.$children获取子实例
vm.$root获取根实例
-------------------------------------------------------------------------------------------
指令
数据渲染 {{}},v-text,v-html
<p>{{a}}</p > <p v-text='a'>{{a}}</p > <p v-html='a'>{{a}}</p >
控制模块隐藏 v-if,v-show
<p v-if='isShow'></p > <p v-show='isShow'></p >
渲染循环列表：v-for
<ul>
<li v-for='item in items'>
<p v-text='item.label'></p >
</li>
</ul>
需要index时：
<li v-for='(item,index) in items'>
<p>{{index}}</p>
</li>
循环对象时
<li v-for='(value,key) in obj'>
<p>{{key+value}}</p>
</li>
事件绑定：v-on 可以缩写为@
<button v-on:click='doSth'></button>
<button @click='doSth'></button>
属性绑定：v-bind
< img v-bind:src='imageSrc'>
v-bind:class可以缩写为:
<div v-bind:class='{red:isRed}'></div>其中red是class名，isRed是布尔值变量
<div v-bind:class='[classA,classB]'></div>其中classA和classB都是js里class变量名，代表有两个class
<div v-bind:class='[classA,{classB:isB,classC:isC}]'></div>上两种的混合用法
index.html页面主入口
<input v-model='newItem'>绑定js变量newItem 双向绑定
-------------------------------------------------------------------------------------------
组件通讯$emit和vuex
//子传父通讯
//父组件
//child-tell-me自定义事件
<component-a v-on:child-tell-me='listenToMyBoy'></component-a>
//父js
listenToMyBoy:function(msg){
console.log(msg);
}
//子组件js
methods:{
onClickMe:function(){
//$emit向上传递信息。 $emit第一个参数触发父组件的child-tell-me自定义事件，第二个参数传递的信息，如'aaa'
this.$emit('child-tell-me','aaa');
}
}
//$dispatch子组件向上传递
//父组件<component-a v-on:child-tell-me='listenToMyBoy'></component-a>
//用on就监听不到了
//得在父js里用event获取
event:{
child-tell-me:function(msg){
console.log(msg);
}
}
//$broadcast父组件向下传递
//父js
//第一个参数事件名。第二个参数传的信息
//this.$broadcast('onAddNew','ddd')
//子组件js
events:{
'onAddNew':function(items){
console.log(items);
}
}
$dispatch和$broadcast已被弃用
使用vuex实现组件间通讯 http://blog.csdn.net/TONELESS/article/details/71638369
--------------------------------------------
简单方法
vuex/store.js里
const store = new Vuex.Store({
//定义状态
    state:{
        author:'Wise Wrong'
    }
}) 
组件里取值
直接 this.$store.state.author 获得
main.js取值
store.state.author 获得
组件里赋值
也是直接 this.$store.state.author = 'xxx' 就行了
--------------------------------------------
显式提交 跟踪状态变化法
vuex/store.js里
const store = new Vuex.Store({
//定义状态
    state:{
        author:'Wise Wrong'
    },
    mutations:{
        newAuthor(state,msg){
            state.author = msg;
        }   
    }    
}) 
组件里取值
直接 this.$store.state.author 获得
组件里赋值
this.$store.commit('newAuthor','xxx');
这里使用$store.commit显式提交
-------------------------------------------------------------------------------------------
//vue的路由vue-router
引入https://router.vuejs.org/zh-cn/installation.html
简单路由https://router.vuejs.org/zh-cn/essentials/getting-started.html
路由加变量https://router.vuejs.org/zh-cn/essentials/dynamic-matching.html
嵌套路由https://router.vuejs.org/zh-cn/essentials/nested-routes.html
路由带参就是传统的get路径带参
this.$router.push(`/repayMethod?NowShouldRepaymentAmount=${this.NowShouldRepaymentAmount}`);
添加动态参数 { path: '/home/:id', component: Home} 其中id是个变量
-------------------------------------------------------------------------------------------
//vue的ajax vue-resource和axios
//不简写
this.$http({ 
method:'GET', 
url:'http://192.168.30.235:9999/rest/knowledge/list', 
data:{'websiteId':2,'pageSize':20,'pageNo':1,'isTop':0}, 
headers: {"X-Requested-With": "XMLHttpRequest"},
emulateJSON: true }) ]).then(function(data){
//es5写法 return{ toplist:data[0].data.knowledgeList, alllist:data[1].data.knowledgeList }
//简写
// 基于全局Vue对象使用http
Vue.http.get('/someUrl', [options]).then(successCallback, errorCallback);
Vue.http.post('/someUrl', [body], [options]).then(successCallback, errorCallback);
// 在一个Vue实例内使用$http
this.$http.get('/someUrl', [options]).then(successCallback, errorCallback);
this.$http.post('/someUrl', [body], [options]).then(successCallback, errorCallback);
this.$http.post(url, {key:'value'}).then(res => {
      console.log(res);
    }, res => {
      console.log(res);
    });
vue-resource中的promise用法 https://www.v2ex.com/t/338620简写语法  
vue2.0 推荐使用axios
vue-resource和axios 参考 https://www.cnblogs.com/Juphy/p/7073027.html
axios参考  https://www.cnblogs.com/zhouyangla/p/6753673.html
-------------------------------------------------------------------------------------------
cnpm run build 将项目打包   在dist文件夹下 static和index.html放在服务器上即可
-------------------------------------------------------------------------------------------
框架中 数据双向绑定 即为 响应式
-------------------------------------------------------------------------------------------
vue-router的两种路由模式 
hash模式 即为#
history模式 即为/ 需要服务端配合 打开方式：
export default new Router({
  mode:'history',       //此处mode
  // base:'/',
  routes: [
    {
      path: '/',
      component: login
    },    
   ]
})
两种都为不刷新跳转
官网参考 https://router.vuejs.org/zh-cn/essentials/history-mode.html
-------------------------------------------------------------------------------------------
vue中可以通过给标签加ref属性，就可以在js中利用ref去引用它，从而操作该dom元素 （待测）
<div id="box" ref="mybox">demo</div>
js中   
let that = this;  
that.$refs.mybox.style.color = 'red';  
-------------------------------------------------------------------------------------------
