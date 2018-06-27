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
vue官网探索
vue-devtools谷歌插件安装
Vue CLI使用文档
如要避免不必要的子组件的重渲染，你需要在所有可能的地方使用 PureComponent，或是手动实现 

shouldComponentUpdate 方法。
Vue中，组件的依赖是在渲染过程中自动追踪的，所以系统能精确知晓哪个组件确实需要被重渲染。你可

以理解为每一个组件都已经自动获得了shouldComponentUpdate。
vue的slot内容分发，父组件内容在子组件显示
Object.freeze()停止追踪;var obj = {foo: 'bar'};Object.freeze(obj)
实例属性与方法。它们都有前缀 vm.$data,vm.$el,$watch
render 函数,直接写渲染 (render) 函数
v-html 指令，编译标签
.修饰符，<form v-on:submit.prevent="onSubmit">...</form>，.prevent 修饰符告诉 v-on 指令对于

触发的事件调用 event.preventDefault()
v-bind 缩写:,v-on 缩写@
对于任何复杂逻辑，你都应当使用计算属性computed
计算属性会缓存 vs 方法会每次都调用一遍
侦听属性watch
计算属性默认只有 getter ，不过在需要时你也可以提供一个 setter 
当需要在数据变化时执行异步或开销较大的操作时，侦听器watch是最有用的
使用 watch 选项允许我们执行异步操作 (访问一个 API)，限制我们执行该操作的频率，并在我们得到

最终结果前，设置中间状态。这些都是计算属性无法做到的。
除了 watch 选项之外，您还可以使用命令式的 vm.$watch API
绑定 HTML Class
支持对象和数组
<div v-bind:class="{ active: isActive }"></div>
<div v-bind:class="[activeClass, errorClass]"></div>
绑定style内联样式
<div v-bind:style="{ color: activeColor, fontSize: fontSize + 'px' }"></div>
<div v-bind:style="styleObject"></div>
data: {
  styleObject: {
    color: 'red',
    fontSize: '13px'
  }
}
v-bind:style自动添加webkit等前缀
v-else
v-else-if
<h1 v-if="ok">Yes</h1>
<h1 v-else>No</h1>
<template>是不可见的包裹元素，判断多个节点时
<template v-if="ok">
  <h1>Title</h1>
  <p>Paragraph 1</p>
  <p>Paragraph 2</p>
</template>
用key不复用
<input placeholder="Enter your email address" key="email-input">
v-show和v-if
v-for 具有比 v-if 更高的优先级
v-for加key,<div v-for="item in items" :key="item.id"></div>
以下数组改变非响应式
vm.items[indexOfItem] = newValue
vm.items.length = newLength
方法
Vue.set(vm.items, indexOfItem, newValue)
vm.items.splice(newLength)
Vue 不能检测对象属性的添加或删除
var vm = new Vue({
  data: {
    userProfile: {
      name: 'Anika'
    }
  }
})
Vue.set(vm.userProfile, 'age', 27)或vm.$set(vm.userProfile, 'age', 27)，响应式
添加多个属性
vm.userProfile = Object.assign({}, vm.userProfile, {
  age: 27,
  favoriteColor: 'Vue Green'
})
访问原始的 DOM 事件，用特殊变量 $event 把它传入
<button v-on:click="warn('Form cannot be submitted yet.', $event)">Submit</button>
尽管我们可以在方法中轻松实现这点，但更好的方式是：方法只有纯粹的数据逻辑，而不是去处理 DOM 事件细节
.stop阻止事件继续传播
.prevent阻止默认事件
.capture添加事件监听器时使用事件捕获模式
.self只当在 event.target 是当前元素自身时触发处理函数，即事件不是从内部元素触发的
.once一次
.passive这个事件的默认行为不会被取消，滚动事件的默认行为 (即滚动行为) 将会立即触发，而不会等待 `onScroll` 完成，能够提升移动端的性能
按键修饰符
<input v-on:keyup.13="submit">
别名
<input v-on:keyup.enter="submit">
可以通过全局 config.keyCodes 对象自定义按键修饰符别名
系统修饰键
<!-- Alt + C -->
<input @keyup.alt.67="clear">
.exact 修饰符，多按了不行
<!-- 有且只有 Ctrl 被按下的时候才触发 -->
<button @click.ctrl.exact="onCtrlClick">A</button>
鼠标按钮修饰符
.left
.right
.middle
-------------------------------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
