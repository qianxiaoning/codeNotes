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
简单方法（直接操作会有问题？）
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
v-model
单个复选框，绑定到布尔值
多个复选框，绑定到同一个数组
select中data: {
    selected: ''
  }为了兼容ios，初始值为空
选择框的选项
<select v-model="selected">
    <!-- 内联对象字面量 -->
  <option v-bind:value="{ number: 123 }">123</option>
</select>
修饰符
.lazy，input中change才执行，input事件不执行
.number将用户的输入值转为数值类型
.trim过滤用户输入的首尾空白字符
Vue 组件
// 定义一个名为 button-counter 的新组件
Vue.component('button-counter', {
  data: function () {
    return {
      count: 0
    }
  },
  template: '<button v-on:click="count++">You clicked me {{ count }} times.</button>'
})
el是根实例特有的选项
组件注册
Vue.component 全局注册
prop向子组件传递数据
$emit 方法并传入事件的名字，向父级传递
is 特性
组件名，字母全小写且必须包含一个连字符
局部注册组件
data-date-picker="activated"特性？
在一个组件的根元素上直接监听一个原生事件。这时，你可以使用 v-on 的 .native 修饰符
<base-input v-on:focus.native="onFocus"></base-input>
有了这个 $listeners 属性，你就可以配合 v-on="$listeners" 将所有的事件监听器指向这个组件的某

个特定的子元素
我们更希望那些标签的组件实例能够被在它们第一次被创建的时候缓存下来。为了解决这个问题，我们

可以用一个 <keep-alive> 元素将其动态组件包裹起来
this.$root访问根实例
$parent访问父组件
动画组件
<transition name="fade">
    <p v-if="show">hello</p>
</transition>
至 渲染函数 & JSX
-------------------------------------------------------------------------------------------
vue2.x
vue ui框架iview,element,MIntUi
状态管理:vuex
数据请求：axios
路由：vue-router
vue-loader是一个webpack的loader；可以将vue文件转换为JS模块:vue-loader
vueify： Browserify transform for Vue.js components, with scoped CSS and component hot-reloading.
lodash：一个javascript库，侧重于基础类型的操作。jq侧重dom    
-------------------------------------------------------------------------------------------
项目笔记：
    生命周期钩子，在created阶段改变数据，mounted时渲染dom，在mounted后才能对dom操作。
    import xxx from 'xxx';引入 第三方js库，不用加文件后缀。类似以前的require();
    组件树：#app根组件:
                     layout:
                            header,footer,content:
                                                  sidebar,...    
全局注册组件
Vue.component('xx',{
    template:'',
    data:{
    
    }
});
局部组件，子组件
import my-header from '@/components/my-header.vue';
new Vue({
    components:{
        'my-header':my-header
    }
});
    
组件中data(){
    return {
        
    }
}    
返回一个函数作用，是实现实例化，每个实例一份数据，不冲突。    
    
vue包含：
    全局配置：   silent
                optionMergeStrategies
                devtools
                errorHandler
                warnHandler
                ignoredElements
                keyCodes
                performance
                productionTip
    全局api：Vue.xxx()。Vue.extend
                                    Vue.nextTick
                                    Vue.set
                                    Vue.delete
                                    Vue.directive
                                    Vue.filter
                                    Vue.component
                                    Vue.use
                                    Vue.mixin
                                    Vue.compile
                                    Vue.version
    实例选项:如el,data,components。选项 / 数据
                                            data
                                            props
                                            propsData
                                            computed
                                            methods
                                            watch
                                  选项 / DOM
                                            el
                                            template
                                            render
                                            renderError
                                  选项 / 生命周期钩子
                                            beforeCreate
                                            created
                                            beforeMount
                                            mounted
                                            beforeUpdate
                                            updated
                                            activated
                                            deactivated
                                            beforeDestroy
                                            destroyed
                                            errorCaptured
                                  选项 / 资源
                                            directives
                                            filters
                                            components
                                  选项 / 组合
                                            parent
                                            mixins
                                            extends
                                            provide / inject
                                  选项 / 其它
                                            name
                                            delimiters
                                            functional
                                            model
                                            inheritAttrs
                                            comments
    实例属性/方法。都以$开头。实例属性，子组件中就是this.$xxx
                        vm.$data
                        vm.$props
                        vm.$el
                        vm.$options
                        vm.$parent
                        vm.$root
                        vm.$children
                        vm.$slots
                        vm.$scopedSlots
                        vm.$refs
                        vm.$isServer
                        vm.$attrs
                        vm.$listeners
                  实例方法 / 数据
                        vm.$watch
                        vm.$set
                        vm.$delete
                  实例方法 / 事件
                        vm.$on
                        vm.$once
                        vm.$off
                        vm.$emit
                  实例方法 / 生命周期
                        vm.$mount
                        vm.$forceUpdate
                        vm.$nextTick
                        vm.$destroy
    指令，都是v-xxx，写在模板中，用于模板和组件数据交互的方法
        v-text
        v-html
        v-show
        v-if
        v-else
        v-else-if
        v-for
        v-on支持修饰符@click.xxx = 
        v-bind支持修饰符:class.xxx = 
        v-model支持修饰符v-model.xxx = 
        v-pre
        v-cloak
        v-once
    内置组件 
            component通过:is=''方法判断加载对应组件
            transition动画效果
            transition-group
            keep-alive进行缓存
            slot
            router-view
v-for
<li v-for='(item,index) in list'>{{item.name}} - {{item.price}} - {{index}}</li>
<li v-for='(value,key) in list'>{{key + value}}</li>
组件也可以v-for循环
                             
引用组件方法：
    一、import引入组件
    二、注册组件                         
        实例选项components:{
                             'xxx':xxx
                           }                
        vue-router里直接component：xxx                            

少部分数组方法不会触发数据更新
对数据的单项修改，和改变数据长度不会触发更新                             
手动修改：
    import引入Vue                             
    Vue.set(this.list,1,{
        name:'',
        price:222                             
    })                             

v-bind绑定class
<a class='a' :class='b'></a>会同时存<a class='a b'></a>
:class='b'，如果b是个对象b:{c:true,d:true},会编译成class='c d'    
:class='b'，如果b是个数组b:[c,d],会编译成class='c d'    
也可以混用b:[c,{d:true}]    
    
自定义事件@my-event='a'
    父组件调用子组件
        <child-a @my-event='a'></child-a>
        methonds:{
            a(param){
                //此处param就能接收参数'aaa'
            }
        }
    子组件
        <template>
            <button @click='emitMyEvent'>emit</button>
        </template>
        methods:{
            emitMyEvent(){
                //实例方法 向上触发my-event自定义事件 还可以传递一个参数
                this.$emit('my-event','aaa')
            }
        }

标签属性绑定用V-bind,如：
    <select v-model='selection'>
        //此处:value='item.value'不加:，'item.value'就会编译成字符串
        <option v-for='item in selectOptions' :value='item.value'>{{item.text}}</option>
    </select>
比如这样一个select组件就很有必要脱离出来，作为单独一个组件。就有很多ui框架帮你做好了

v-model//input后就会改变值
v-model.lazy//完成时才改变指，比如回车后
v-model.number//把string值转为数字

计算属性，可以替代传统的事件监听。比如：
    v-model绑定的不允许输入数字，把它自动过滤
    可以设置computed:{
               //在这里进行逻辑操作
           }
模板里也可以直接调用方法
    <a>{{valueHandle()}}</a>
    methods:{
        valueHandle(){
        
        }
    }
computed和methonds区别在于，computed只会根据数据变化才改变，而methods无论数据变没变都会重复执行。所以computed性能更好

watch属性变化监听，比如：
    v-model='myVal'的值变化，进行的事件
    watch:{           //新旧值
        myVal:function(val,oldVal){
            //当前值，前一次值
        }
    }
    场景，每次改变都要通知用户
        watch:{
            myVal:function(){
                this.tellUser();
            }
        }

xxx.vue中template下面都有export default{}
导出这个vue实例

选项components可以简写：
    components:{com-a,com-b}

组件两种写法：
   <com-a></com-a>
   用is属性//也代表这是com-a组件
   <div is='com-a'></div>
所以v-bind:is='dynamicCom'//可以动态引入组件

父子组件通讯
    parent->child通过父组件直接在标签上赋属性，子组件props接收,pass
    child->parent通过父组件用event绑定自定义事件，子组件调用实例方法this.$emit提交
    例子：
        一、父组件 告诉select组件选项数据
            父组件
                <select-com :option-array=[...] @my-event='a'></select-com>               
            子组件
                模板：<option v-for='option-array'></option>
                js：
                    props:['option-array']
        二、子组件select 告诉父组件最后选了哪一项
            子组件
                模板：<option v-for='option-array' @click='emitMyEvent'></option>
                js：
                    //props接收数组和对象
                    props:['option-array']//对象的话可以规定类型如：props:{'option-array':[Number,String]}，不符合类型会报错
                    methods:{
                        emitMyEvent(){
                            //实例方法 向上触发my-event自定义事件 还可以传递一个参数
                            this.$emit('my-event','aaa')
                        }
                    }
            父组件
                <select-com :option-array=[...] @my-event='a'></select-com>
                js:
                   methods:{
                       a(params){
                        //参数
                       }
                   }
slot插槽功能，也是父组件向子组件以模板形式，传递信息的一个方式
    应用场景，model弹出框。可以用slot插槽向弹出框中插入不同的标题、内容。                                           
    父组件
        <model-a>
            <!-->
                此处就是一个插槽                                           
            <-->                                           
            <p>123</p>                                           
        </model-a>                                           
    子组件                                           
        <template>
            <div>original</div>                                           
            <slot>no content</slot> -> 插槽有内容时<p>123</p> / 插槽无内容时，会显现slot中的默认内容'no content'                                          
        </template> 
    向具名slot中插入信息：
        父组件：
            <model-a>                      
                <!-->用solt属性为插槽命名<-->                           
                <p slot='header'>xxx header</p>                                           
                <p slot='footer'>xxx footer</p>                                           
            </model-a>
        子组件：
            <template>
                <slot name='header'>no header<slot>//用name属性接收具名插槽
                <p>I am the content.</p>                                           
                <slot name='footer'>no footer<slot>                   
            </template>                               

//动态组件                                           
<div :is='currentCom'></div>                                           
<router-view/>就类似动态组件                                           
<keep-alive>//切换组件，比如选项卡时，就会被缓存起来。不用重复消耗
    <div :is='currentCom'></div>                                          
</keep-alive>                                           
                                           
父组件向内传递属性 - 动态属性
子组件向外发布事件
slot插槽传递模板
                                           
过渡动画
    transition标签
    <transition name='xxx'>
        <p v-show='showVariable'>xxx</p>                               
    </transition>
    动画阶段：                                           
        enter阶段 -> leave阶段
        v-enter -> v-enter-active -> v-leave -> v-leave-active                                              
        通常只设定v-enter和v-leave-active的动画。v-enter-active和v-leave采用默认状态                                           
    根据enter和leave起类名
    .xxx-enter-active,.xxx-leave-active{transition:all .5s;}                                           
    .xxx-enter,.xxx-leave-active{opacity:0;}                                       
    .yyy-enter{transform:translateY(-500px);}//到初始位置之前是在上方500px                                                                                  
    .yyy-leave-active{transform:translateY(500px);}//初始位置之后的动画是去下方500px                                           
                     
    接收过渡状态v-show,v-if,动态组件<div :is='xxx'></div>的切换                                       
                                           
    过渡模式，默认是 进入和离开同时发生。下面有两种别的方式
    in-out：新元素先进行过渡，完成之后当前元素才过渡离开。
    <transition mode='in-out'></transition>                                           
    out-in：当前元素先进行过渡，完成之后新元素才过渡进入。                                       
    
    v-if,v-else多元素的过渡。多元素得是不同标签，或者同一标签加上key属性，才能实现过渡效果，如：
    <transition>
        <button v-if='show' key="1">1</button>
        <button v-else key="2">2</button>                                           
    </transition>                                           
    也可以通过给同一个元素的 key 特性设置不同的状态来代替 v-if 和 v-else                                           
    <transition>
        <button v-bind:key="isEditing">{{ isEditing ? 'Save' : 'Edit' }}</button>
    </transition>       
    或：
    <transition>
        <button v-bind:key="docState">{{ buttonMessage }}</button>
    </transition>
                                           
    js动画过渡，不需要name属性
    通过v-on事件监听进入、离开，如: v-on:before-enter="beforeEnter"
                                  v-on:enter="enter"
                                  v-on:after-enter="afterEnter"
                                  v-on:enter-cancelled="enterCancelled"

                                  v-on:before-leave="beforeLeave"
                                  v-on:leave="leave"
                                  v-on:after-leave="afterLeave"
                                  v-on:leave-cancelled="leaveCancelled"                                           
    通过methods来定义方法，方法里有自带参数el，就是dom元素，对dom进行样式的操作。另一个参数done，用以加在enter 和 leave 中。
    注意：
        1.当只用 JavaScript 过渡的时候，在 enter 和 leave 中必须使用 done 进行回调。否则，它们将被同步调用，过渡会立即完成。                                           
        2.对于仅使用 JavaScript 过渡的元素添加 v-bind:css="false"，Vue 会跳过 CSS 的检测。这也可以避免过渡过程中 CSS 的影响。                                   
                                           
自定义指令        
    局部指令 在组件里写                                                                                     
    <div v-color="'red'"></div>                                       
    js:
        directives:{
            color:function(el,binding){//binding指绑定的变量或计算表达式，.value指'red',.name指指令名等等，参见'钩子函数参数'
                el.style.color = binding.value                                           
            },
            color2:function(el,binding){
                el.style.color = binding.value                                           
            }                                           
        }                                           
    全局组件 在main.js里写
    new Vue({
        el:'#app',
        router,        
        template: '<App/>',
        components: { App },
        directives:{
            color:function(el,binding){//binding指绑定的变量或计算表达式，此处指'red'
                el.style.color = binding.value                                           
            }                                           
        }                                           
    });                                           
                                           
    钩子函数bind只调用一次,一次性的初始化设置、inserted被绑定元素插入父节点时、update所在组件的 VNode（虚拟dom） 更新时调用、
    componentUpdated指令所在组件的 VNode 及其子 VNode 全部更新后调用、unbind只调用一次，指令与元素解绑时调用
                                           
    directives:{
        //以下是简写，对应bind和update函数                                           
        color:function(el,binding){//binding指绑定的变量或计算表达式，此处指'red'
            el.style.color = binding.value                                           
        }
        //对应其他事件可以
        color:{
            bind(el,binding){//binding指绑定的变量或计算表达式，此处指'red'
                el.style.color = binding.value                                           
            },
            inserted(el,binding){
                                           
            }                                           
        }                                   
    }                                       
                                           
    自定义指令的实际运用
    当input被插入到页面的时候，直接有focus效果，就可以自定义一个指令，以便在所有input中复用                                               
    <input type='text' v-focus/>
    js:
        directives:{
            focus:{
                //inserted阶段                                           
                inserted(el,binding){
                    el.focus();                                           
                }                                           
            }                                           
        }                                           
                                           
插件                                           
    如：vue-router,vuex,axios                                       
    一、通过npm安装插件包                                               
        npm install xxx --save                                           
    二、main.js引入、注册使用
        import axios from 'axios'//相当于以前用require.js的:var axios = require('axios');                                            
        Vue.use(axios);                                           
                                           
vue的单文件组件 即.vue文件 包含template,script,style scoped。通过vue-loader和webpack实现
                                           
vue-cli vue脚手架工具                                           
    本地测试服务器功能，包含热加载npm run dev                                           
    集成打包功能，npm run build                                           
    
    启动：                                           
    cnpm install webpack -g -> npm install vue-cli -g 
    -> vue init webpack pra02 -> cd pra02 -> cnpm install -> cnpm run dev
                                           
vue-router
    服务器路由，切换页面时会把如：jq,app.js不必要重新加载的文件都加载一遍                                           
    前端路由，不发生页面跳转，只请求需要的资源，节约资源加载，提示速度                                           
                                           
    模式
        hash模式 带'#'
        history模式 不带'#'，利用的h5特性 window.history.pushState等特性                                           
                                           
    vue里页面跳转不用a链接了，有两种方法：
    一、基于router config的路由表进行，<router-view/>插槽                                                
    二、在页面里用<router-link :to="{path:'apple'}">xxx<router-link>，代替a链接                                          
                                           
    路由传参
        路由中：                                           
            path:'/apple/:color/detail/:type'//带:的是参数，这种写法必须传参，否则会找不到这个路由页面。
            写法path:'/apple/red/detail/3'以完成参数传递，或
            <router-link :to="{path:'apple',param:{color:'red'}}">xxx</router-link>以完成参数传递
        组件中获取：
            this.$router.params                                           
                                           
    路由嵌套
        routers:[
            {
                path:'/apple',
                component:apple,
                children:[
                    {
                        path:'redApple',
                        component:redApple,                       
                    },                                           
                    {
                        path:'greenApple',
                        component:greenApple,                       
                    }                       
                ]                           
            }                                           
        ]                                          
    子路由得在父路由组件处也要加上个<router-view/>标签，或：
    用<router-link :to="{path:'apple/redApple'}">xxx</router-link>直接跳转
                                           
    <router-link tag='li'></router-link>默认是a标签，加上tag可以指定为其他标签如：li
                                           
    声明式导航<router-link/>
    编程式导航，在js中：
        this.$router.push('/index');//push跳转,replace删去当前页面记录并跳转,go前进后退多少步
                                           
    导航守卫
        router.beforeEach即将要进入，正要离开，next
    全局后置钩子
        router.afterEach
    组件内的守卫
        选项中   beforeRouteEnter
                beforeRouteUpdate (2.2 新增)
                beforeRouteLeave
                                           
    路由的命名
        如：
        routers:[
            {
                path:'/apple',
                component:apple,
                name:'applePage'//name属性
            }
        ]
        模板里可以通过name跳转
        <router-link :to="{name:'applePage'}"></router-link>
    命名视图：
        父组件中
        <router-view name='viewA'/>
        <router-view name='viewB'/>
        路由表中
        {
            path:'/apple',
            component:{
                viewA:apple,
                viewB:redApple,//分别加载不同组件
            }                
        }
    
    重定向
        路由表中：
        routers:[
            {
                path:'/index',
                redirect:'/login'
            }
        ]
        
    路由的动画过渡
        <transition name='xxx'>
            <keep-alive>//把切换过的页面缓存起来
                <router-view></router-view>
            </keep-alive>
        </transition>
                                           
    导航切换的时候，当前导航项class上会有'router-link-active'这个类
    
vuex状态管理
    实际场景：
        购物车：在首页增添商品到购物车，在内页购物车详情也要进行更新
    传统做法：在首页操作后，触发事件传到另一个组件。缺点当操作频繁，反复调用组件很多，挨个依次去通知很多组件，很繁琐
    用vuex进行状态管理：一个统一的数据中心，某一个组件进行数据更新时，就通知数据中心，数据中心数据变化触发更改调用次数据的组件
                                           
    简单方法（直接操作会有问题？）
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
    
    显式提交 跟踪状态变化法
    mutations法（同步）：
    vuex/store.js里
    const store = new Vuex.Store({
    //定义状态
        state:{
            totalPrice:0
        },
        mutations:{
            increase(state,price){//此处state指上面的state,price为传入的参数
                state.totalPrice += price;
            },
            decrease(state,price){
                state.totalPrice -= price;
            }
        }
    }) 
    组件里取值
    直接 this.$store.state.totalPrice 获得
    组件里赋值，通过methods方法触发
    this.$store.commit('increase',a number');
    这里使用$store.commit显式提交                                           
                       
    actions法（异步）：
    store.js里加上actions选项
    state:{
            totalPrice:0
        },
        mutations:{
            increase(state,price){//此处state指上面的state,price为传入的参数
                state.totalPrice += price;
            },
            decrease(state,price){
                state.totalPrice -= price;
            }
        },
        actions:{//只能调用mutations不能访问state
            increase(context,price){
                context.commit('increase',price);
            }
        }                       
    组件中：
    this.$store.dispatch('increase',a number');
    
    区别：actions可以进行一些异步的操作，然后再去触发mutations
         mutations里必须是同步的操作store里面的数据，不能进行异步的数据请求
    所以和后端的api接口必须放在actions里面，如：
    increase(context,id){//传的是一个id
        ajax(id,function(price){
            context.commit('increase',price);
        })        
    }
                                           
    getters用来获取状态集里的数据
    Vuex.store({
        states:{
        },
        getters:{
            getTotalPrice(state){
                return state.totalPrice
            }
        },
        mutations:{
        },
        actions:{
        }
    })                                           
    组件中：
    不用this.$store.state.xxx取数据了
    可以this.$store.getters.getTotalPrice来取数据
                                           
    modules可以区分不同模块，如：
    const moduleA = {
        states:{},
        mutations:{},
        actions:{},
        getters:{}
    };
    const moduleB = {
        states:{},
        mutations:{},
        actions:{},
        getters:{}
    };                                       
    合成：
    const store = new Vuex.store({
        modules:{
            a:modulesA,
            b:modulesB
        }
    });
    组件中取不同模块的state数据：
    this.$store.state.a
    this.$store.state.b
                                           
    注意：
        一、只有一个数据中心store
        二、只能通过mutations来commit提交同步数据
        三、通过actions来提交异步数据
        
    理想vuex文件结构：                                               
    ..                                       
    components文件夹                                       
    store文件夹
        index.js//统一的输出接口
        actions.js//异步
        mutations.js//同步
        modules
            cart.js//购物车数据
            products.js//产品数据
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
