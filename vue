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
添加动态参数 { path: '/home/:id', component: Home} 其中id是个变量 加?可不传
this.$route.params获取
-------------------------------------------------------------------------------------------
//vue的ajax vue-resource和axios
//不简写
this.$http({ 
    method:'GET', 
    url:'http://192.168.30.235:9999/rest/knowledge/list', 
    data:{'websiteId':2,'pageSize':20,'pageNo':1,'isTop':0}, 
    headers: {"X-Requested-With": "XMLHttpRequest"},
    emulateJSON: true 
}) ]).then(function(data){
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
vue中可以通过给标签加ref属性，就可以在js中利用ref去引用它，从而操作该dom元素
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
                            //实例方法 向上触发indexPass自定义事件 还可以传递一个参数
                            this.$emit('indexPass',1)
                        }
                    }
            父组件
                触发方法a
                <select-com :option-array=[...] @indexPass='a'></select-com>
                js:
                    data index:0
                   methods:{
                       a(params){
                        //参数
                        this.index=params
                       }
                   }

                .sync修饰符
                简写 子组件事件中的$event就是$emit出去的参数
                可以直接对声明过的参数 赋值
                <select-com :option-array=[...] @indexPass='index=$event'></select-com>

                但父子组件存在双向通讯，即需要双向绑定时，
                貌似可以用.sync修饰符简写
                如：
                <tab-head :inde='tabIndex' @switch='tabIndex=$event'></tab-head>
                或者在方法里直接第一个参数获取
                
                父传tabIndex给子
                子emit tabIndex给父
                可以写成 ？
                <tab-head :inde.sync='tabIndex'></tab-head>

slot插槽功能，也是父组件向子组件以模板形式，传递信息的一个方式
    当组件中某一项需要单独定义，那么就应该使用solt。                                           
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
    无论在ng还是vue，指令的效果就相当于，提供一种变相操纵dom的方式                                           
                                           
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
            <router-link :to="{path:'apple',params:{color:'red'}}">xxx</router-link>以完成参数传递
        组件中获取：
            this.$route.params                                           
                                           
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
    
vuex状态管理 state,getters,mutations,actions,modules
    实际场景：
        购物车：在首页增添商品到购物车，在内页购物车详情也要进行更新
    传统做法：在首页操作后，触发事件传到另一个组件。缺点当操作频繁，反复调用组件很多，挨个依次去通知很多组件，很繁琐
    用vuex进行状态管理：一个统一的数据中心，某一个组件进行数据更新时，就通知数据中心，数据中心数据变化触发更改调用次数据的组件                                          
    
    Vuex 和全局对象的区别：
    1.响应式
    2.显式地提交 (commit) mutation，以便用工具了解我们的应用。
    
    直接修改this.$store的值，不能commit留下记录，不利于vue tools调试。在严格模式会报错，虽然都能触发响应式。
    
    Store
        const store = new Vuex.Store({
          state: {
            count: 0
          },
          mutations: {
            increment (state) {
              state.count++
            }
          }
        })
        获取 在computed中取store.state
        修改 在methods中store.commit触发mutation        
            
    state:
        在 Vue 组件中获得 Vuex 状态
        *写在computed里触发改变
        子组件通过 this.$store 访问
        computed: {
            count () {
              return this.$store.state.count
            }
          }
        *简化写法，语法糖
        mapState 辅助函数
        import { mapState } from 'vuex'
        export default {
          // ...
          computed: mapState({
            // 箭头函数可使代码更简练
            count: state => state.count
          })
          *或 当映射的计算属性的名称与 state 的子节点（state.count）名称相同时，我们也可以给 mapState 传一个字符串数组  
          computed: mapState([
              // 映射 this.count 为 store.state.count
              'count'
            ])  
        }
        *对象展开运算符
        computed: {
          localComputed () { /* ... */ },
          // 使用对象展开运算符将此对象混入到外部对象中
          ...mapState({
            // ...
          })
        }  
            
    getters            
    对state的初数据进行进一步处理，类似store 的计算属性，有缓存优化，有返回值
    const store = new Vuex.Store({
      state: {
        todos: [
          { id: 1, text: '...', done: true },
          { id: 2, text: '...', done: false }
        ]
      },
      //第一个参数state
      getters: {
        doneTodos: state => {
          return state.todos.filter(todo => todo.done)
        }
      }
    })
    属性访问
    store.getters.doneTodos
    Getter 也可以接受其他 getter 作为第二个参数
    getters: {
      // ...
      doneTodosCount: (state, getters) => {
        return getters.doneTodos.length
      }
    }
    方法访问
    getters: {
      // ...
      getTodoById: (state) => (id) => {
        return state.todos.find(todo => todo.id === id)
      }
    }
    store.getters.getTodoById(2) // -> { id: 2, text: '...', done: false }
    mapGetters 辅助函数
    import { mapGetters } from 'vuex'
    export default {
      // ...
      computed: {
      // 使用对象展开运算符将 getter 混入 computed 对象中
        ...mapGetters([
          'doneTodosCount',
          'anotherGetter',
          // ...
        ])
      }
    }
    如果你想将一个 getter 属性另取一个名字，使用对象形式：
    mapGetters({
      // 把 `this.doneCount` 映射为 `this.$store.getters.doneTodosCount`
      doneCount: 'doneTodosCount'
    })            
            
    显式提交 跟踪状态变化法
    mutations法（同步）类似事件：
    每个 mutation 都有一个字符串的 事件类型 (type)'increment' 和 一个 回调函数 (handler)
    const store = new Vuex.Store({
      state: {
        count: 1
      },
      mutations: {
        increment (state) {
          // 变更状态
          state.count++
        }
      }
    })
    提交方式 ：store.commit('increment')

    提交载荷，额外传参
    第二参数对象形式
    mutations: {
      increment (state, payload) {
        state.count += payload.amount
      }
    }
    提交方式
    store.commit('increment', {
      amount: 10
    })            
    或对象风格的提交方式            
    store.commit({
      type: 'increment',
      amount: 10
    })
            
    响应规则
    1.store 中初始化好所有所需属性
    2.添加新属性时，你应该使用 Vue.set(obj, 'newProp', 123)
            
    在组件中提交 Mutation
    import { mapMutations } from 'vuex'
    export default {
      // ...
      methods: {
        ...mapMutations([
          'increment', // 将 `this.increment()` 映射为 `this.$store.commit('increment')`

          // `mapMutations` 也支持载荷：
          'incrementBy' // 将 `this.incrementBy(amount)` 映射为 `this.$store.commit('incrementBy', amount)`
        ]),
        ...mapMutations({
          add: 'increment' // 将 `this.add()` 映射为 `this.$store.commit('increment')`
        })
      }
    }                                          
                       
    actions法（异步）：
    Action 提交的是 mutation，而不是直接变更状态。
    可以异步
    const store = new Vuex.Store({
      state: {
        count: 0
      },
      mutations: {
        increment (state) {
          state.count++
        }
      },
      actions: {
        increment (context) {//此处context=>store 实例
          context.commit('increment')
        }
      }
    })
    参数解构
    需要调用 commit 很多次的时候
    actions: {
      increment ({ commit }) {
        commit('increment')
      }
    }

    触发
    store.dispatch('increment')
            
    actions: {
      incrementAsync ({ commit }) {
        setTimeout(() => {
          commit('increment')
        }, 1000)
      }
    }        
    和mutations同样的方式传参         
    
    mapActions 辅助函数
    import { mapActions } from 'vuex'
    export default {
      // ...
      methods: {
        ...mapActions([
          'increment', // 将 `this.increment()` 映射为 `this.$store.dispatch('increment')`

          // `mapActions` 也支持载荷：
          'incrementBy' // 将 `this.incrementBy(amount)` 映射为 `this.$store.dispatch('incrementBy', amount)`
        ]),
        ...mapActions({
          add: 'increment' // 将 `this.add()` 映射为 `this.$store.dispatch('increment')`
        })
      }
    }

    组合 Action            
    store.dispatch返回 Promise            
    actions: {
      actionA ({ commit }) {
        return new Promise((resolve, reject) => {
          setTimeout(() => {
            commit('someMutation')
            resolve()
          }, 1000)
        })
      }
    }
    现在你可以：
    store.dispatch('actionA').then(() => {
      // ...
    })
    在另外一个 action 中也可以：
    actions: {
      // ...
      actionB ({ dispatch, commit }) {
        return dispatch('actionA').then(() => {
          commit('someOtherMutation')
        })
      }
    }
    最后，如果我们利用 async / await，我们可以如下组合 action：
    // 假设 getData() 和 getOtherData() 返回的是 Promise
    actions: {
      async actionA ({ commit }) {
        commit('gotData', await getData())
      },
      async actionB ({ dispatch, commit }) {
        await dispatch('actionA') // 等待 actionA 完成
        commit('gotOtherData', await getOtherData())
      }
    }                                      
    组件中：
    this.$store.dispatch('increase',a number');
    所以和后端的api接口必须放在actions里面，如：
    increase(context,id){//传的是一个id
        ajax(id,function(price){
            context.commit('increase',price);
        })        
    }                
     
    Modules
    允许我们将 store 分割成模块（module）。每个模块拥有自己的 state、mutation、action、getter、甚至是嵌套子模块——从上至下进行同样方式的分割    
    modules可以区分不同模块，如：
    const moduleA = {
        state:{},
        mutations:{},
        actions:{},
        getters:{}
    };
    const moduleB = {
        state:{},
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
                              
    模块的局部状态
    对于模块内部的 mutation 和 getter，接收的第一个参数是模块的局部状态对象state
    对于模块内部的 action，局部状态通过 context.state 暴露出来，根节点状态则为 context.rootState
    const moduleA = {
      // ...
      actions: {
        incrementIfOddOnRootSum ({ state, commit, rootState }) {
          if ((state.count + rootState.count) % 2 === 1) {
            commit('increment')
          }
        }
      }
    }            
    对于模块内部的 getter，根节点状态会作为第三个参数暴露出来：
    const moduleA = {
      // ...
      getters: {
        sumWithRootCount (state, getters, rootState) {
          return state.count + rootState.count
        }
      }
    }
    
    默认情况下，模块内部的 action、mutation 和 getter 是注册在全局命名空间
    如果希望你的模块具有更高的封装度和复用性，你可以通过添加 namespaced: true 的方式使其成为带命名空间的模块。
    当模块被注册后，它的所有 getter、action 及 mutation 都会自动根据模块注册的路径调整命名        
    启用了命名空间的 getter 和 action 会收到局部化的 getter，dispatch 和 commit
    
    在带命名空间的模块内访问全局内容
    rootState 和 rootGetter 会作为第三和第四参数传入 getter，也会通过 context 对象的属性传入 action
    
    通过使用 createNamespacedHelpers 创建基于某个命名空间辅助函数
    import { createNamespacedHelpers } from 'vuex'
    const { mapState, mapActions } = createNamespacedHelpers('some/nested/module')   
    export default {
      computed: {
        // 在 `some/nested/module` 中查找
        ...mapState({
          a: state => state.a,
          b: state => state.b
        })
      },
      methods: {
        // 在 `some/nested/module` 中查找
        ...mapActions([
          'foo',
          'bar'
        ])
      }
    }
            
    模块重用
    
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

布局
    components页面公用组件，头尾复用建一个components/layout组件：
        <template>
            <div>
                <div class='app-header'>header</div>
                <div class='app-content'>
                    <keep-alive>
                        <router-view/>//路由首页引入index.vue
                    </keep-alive>                    
                </div>
                <div class='app-footer'>footer</div>
            </div>
        </template>
    pages放页面，与components同级的建一个page文件夹放页面，page/index.vue       
     
    <div v-for="(item,index) in xxxList"></div>   
                                           
json-server前端模拟数据测试服务器npm包，利用proxy功能代理端口跨域。只能通过get请求数据？                                           
express写路由做模拟数据测试服务器                                           
                                           
在awesome-vue仓库找vue插件                                           

class绑定，如：<a :class="{on:index==nowIndex}"></a>，当变量index和nowIndex相等时，加上class 'on'

首页图片轮播组件，新建components/slideShow.vue组件                                   
    用webpack，数据中图片路径要加require，如src:require('../assets/slideShow/pic1.jpg')
    父组件：
        <slide-show :slide='xxx'></slide-show>
    slide子组件:
        props:[slide]选项接收                                           
           
    slide子组件:
        this.$emit('onchange',index)//在子组件把index传给父组件
    父组件：
        <slide-show :slide='xxx' @onchange='xxx'></slide-show>
    
    动画效果，两张图片同时存在，所以有两个
        <transition name='xxx'>
            <img v-if='isShow' :src=''/>
        </transition>
        <transition name='xxx'>
            <img v-if='!isShow' :src=''/>
        </transition>                                           
    用v-if触发动画                                           
                                           
弹窗myDialog组件:                                               
    <div class='popWrap'>
        <div class='title'></div>    
        <div class='content'>
            <slot>empty</slot>//默认内容    
        </div>    
    </div>                                           
    父组件中子组件中间的，或者用slot属性，子组件用slot标签                                           
    layout父组件：                                           
    引入myDialog组件
    加上components选项
    <div class='app-head'></div>
    <div class='app-footer'></div>
    <my-dialog :isShow='isShowDialog'>//里面是比较复杂的html，适合用插槽实现
        <p>xxx</p>//插槽内容
    </my-dialog>
    通过父js控制弹窗显示关闭的
        data(){
            return {
                isShowDialog:false
            }
        }
    弹窗组件：
        props:[isShow]
    
登录和注册表单也分别做成组件    
    
把登录得到的信息通过$emit传递给父组件layout，比如username    
    
增加详情子页面page/detail.vue，分左右两块，左边是导航区，右边是<router-view></router-view>子路由        
    
<router-link active-class='active'></router-link>当前位置属性active-class。不设该属性，则为默认router-link-active该class
    
路由传参
路由表中：:代参
    new Router({
        routes: [

        ]
    })
router-link中to to="/foo"不带参，:to="'varA'"   
:to="{ name: 'user', params: { userId: 123 }}"代参
:to="{ path: 'register', query: { plan: 'private' }}"
带查询参数，下面的结果为 /register?plan=private

路由中中介组件，不希望用户访问到，可以在路由中设置重定向redirect:'/detail/page01'    
    
select组件    
    
vue日期插件，datepicker    
    
vue2.0数据双向绑定原理。Object.defineProperty()
    <input type='text' id='a'/>
    <span id='b'></span>
    js:
    var obj = {};
    //添加新属性
    Object.defineProperty(obj,'newAttr',{userName:'haha'});//给obj对象，添加新属性newAttr，默认值是'haha'
    //get,set方法
    Object.defineProperty(obj,'newAttr',{
        get(){
        
        },
        set(val,oldVal){//新旧值
            $('#a').html(val);//赋新值
            $('#b').html(val);//赋新值
        }
    });
    获取obj.userName时，会触发Object.defineProperty的get方法
    对obj.userName='lala'赋值时，会触发Object.defineProperty的set方法
    $('#a')[0].addEventListner('keyup',function(e){
        obj.userName = e.target.value;
    });
    以实现数据双向绑定

vuex流程
state:{loading:false,list:[],data:{},count:0}
getters:{data(state,getters){return state}}
mutations:{setOne(state,res){},setList(state,res){}}
actions:{getList({state,commit},params={}){    
    xxx=>commit('setList', res)    
}}

state存放数据，共享数据。
对数据赋值：actions通过接口取异步数据，然后commit提交到mutations里的方法，mutations里对state数据进行赋值。
取数据：取computed里的mapGetters的变量，mapGetters的变量读的是state里的数据。
    
vue通讯
父传子，父:xxx='xxx'属性，子props，一层层往里传
子传父，子$emit触发自定义事件，父绑定的自定义事件触发，一层层往外传

$on可以接收自己$emit的自定义事件

vuex-router-sync作用
把 vue-router 的狀態放進 vuex 的 state 中
這樣就可以透過改變 state 來進行路由的一些操作
會同步的是這幾個屬性
{
    path: '',
    query: null,
    params: null
}
以下3个可以从vuex取得并使用
store.state.route.path   // current path (string)
store.state.route.params // current params (object)
store.state.route.query  // current query (object)

vue项目结构整理
frames放页面结构
modules放页面
components放页面需要的组件：
base基础组件，分portal面板组件，packs复杂且复用高的业务组件

大的页面放modules一级。结构复用的页面建空的template，在template里放frames结构组件，结构组件中放router-view路由口，暴露给frames框架组件中的slot插槽。
在frames结构组件中用el-Layout:container,el-aside,el-header,el-main,el-footer中引入面板portals组件布好局，在页面变换处main处设置slot插槽，以接收主页面传来的路由页面。
在modules页面引入packs业务组件和base基础组件，数据交互在页面中进行，把数据通过props传入组件，组件通过组件的按钮等，触发$emit把处理后的数据返回出来

slot用法
比如我要设置一个base组件，组件中要根据情况生产很多不同的html标签的、甚至可以在slot中放入别的base组件，可以用几个slot标签具名留好位置，然后在modules页面中引入base组件中写几个div有slot属性，分别放入该组件中。这样生成html标签方便。/貌似这几个modules页面上的slot标签里的html，因为属于modules组件，所以直接用modules组件的数据渲染就行了，渲染好了再放入base组件中。
如果base组件中要生产的html结构差异不大，只是数据差异大，那完全可以把base组件封装性好点，props传入变量、数据即可。

父子通讯用props和$emit
跨组件通讯方便的用vuex
跨组件通讯不方便的用空Vue事件总线，this.prototype.$emit,this.prototype.$on

computed计算属性不能传参
filters过滤器可以接受过滤的值和传参，且不影响原数据

数组索引更新
this.$set(this.Arr, indexOfArr, newValue)
改变数组长度
vm.items.splice(newLength)

添加一个对象属性
vm.$set(vm.userProfile, 'age', 27)
添加多个对象属性
vm.userProfile = Object.assign({}, vm.userProfile, {
  age: 27,
  favoriteColor: 'Vue Green'
})

两层以上嵌套组件信息传递
简单的项目 用事件总线new Vue,$emit,$on自传自收

vuex方便管理大块数据，如列表加载，存储整块数据。
封装方法方便，如滚动加载。

eventbus是单点数据触发

复杂的项目 用vuex，子胥说为了管理请求。我觉得是留下记录方便调试维护，有迹可循，比如用vuetools

我的思路，数据请求和vuex通讯管理分开写，不想和子胥一样写在一起。

watch侦听数据的简写方式
watch:{
    a(v,ov){//监听a属性

    },
    'b.c'(v,ov){//监听b.c属性

    }
}

组件中的watch会随着组件销毁而销毁
如果全局的watch，不用了要手动销毁
$watch方法返回的就是一个自身销毁函数
如：
侦听时：const unwatch = app.$watch('aa',(newV,oldV)=>{})
取消：unwatch();

计算属性computed中如果有多个vm.xxx值，只要有一个vm.xxx值变化，computed就会执行函数体一遍

能用computed就用computed,节约性能
不能用computed,只能用watch的情况
一、数据侦听用watch
虽然computed也能侦听数据变化,但是得在模板调用后才能生效,类似于函数
而watch不需要另外调用,直接生效
二、在数据变化时执行异步 或开销较大的操作时
执行异步操作 (访问一个 API)，限制我们执行该操作的频率，并在我们得到最终结果前，设置中间状态。这些都是计算属性无法做到的 

computed会侦听函数里所有数据的变化
其中一个data值变了就会执行，等于一下子侦听了多个值的变化。
而watch只侦听一个值的，不会互相影响。

父组件向子组件通过props特性传值流程
自上而下顺序
父data:{a:1}
父created(){this.a=2}
父beforeMount(){this.a=3}
//子组件渲染完成后
//向子组件props传第一次值
子created=>beforeMount=>mounted(){this.a==3}

父mounted(){this.a=4}
//子组件渲染完成后,父组件props数据变化,传第二次值
子beforeUpdate=>updated(){this.a==4}

父接口异步给props赋值
父created=>beforeMount=>mounted(){(res)=>{this.a=res}}
//父组件props数据变化,传第三次值
子beforeUpdate=>updated(){this.a==res}

父组件向props传异步值方法:
一、在父组件的子组件标签上加v-if='',数据变化再次渲染子组件,使子组件获取异步新props数据
二、在子组件watch里侦听获取异步新props数据,用methods来代替created
三、在子组件beforeUpdate,updated里获取异步新props数据(可能由任何数据更新触发,不推荐)

将一个对象的所有属性都作为 prop 传入
<blog-post v-bind="post"></blog-post>
等价于：
<blog-post
  v-bind:id="post.id"
  v-bind:title="post.title"
></blog-post>

子值改变动态传父
子:this.$emit('update:title', newTitle)
父:<text-document
  :title="doc.title"
  @update:title="doc.title = $event"//监听title触发update函数
></text-document>
父简写:<text-document :title.sync="doc.title"></text-document>

vue生命周期
只要url变化，每次进入page
会把page组件 和 page组件中的子组件依次触发
beforeCreate,created,beforeMount,mounted

mpvue生命周期
开始会把所有组件的beforeCreate,created先执行一遍

进入已销毁的page组件时，该page组件 依次触发onLoad,onShow,onReady,beforeMount,mounted
第一次进入已销毁的page组件，该page组件中的子组件 依次触发onLoad,onReady,beforeMount,mounted
第二次进入已销毁的page组件，该page组件中的子组件 依次触发onLoad,onShow,onReady

再次进入 未被销毁的page组件，该page组件 和 该page组件中的子组件时只触发onShow

<div @click='tabC(ind,$event)'></div>
$event传入事件对象

父子组件通讯
父传子，直接通过props就行。props变，子模板自动会变
子传父，得子$emit到父，父event接收$event值

设置props对象默认值办法
在子computed中const设置props对象的默认值，并Object.assign合并默认值和props值，返回默认值，子组件模板中用computed就行了

mpvue别在created和beforeCreate中写逻辑，会出错

mpvue一套代码多端使用
对于onShow等生命周期，可以判断环境在created再加一遍
对于微信api问题，可以用wx.xxx再写一遍覆盖
对于微信小程序组件问题，貌似只能用vue组件自己写一套代替

如果遇到 需要在 模板循环中把对应的值改变的情况
因为computed属性不能传参，在循环中没法用
methods在小程序模板中没法用
可以这么搞：
数组法
如[1,2,3]=>['我','你','他']
<span>{{_array[i.label]}}</span>
对象法 //对象法还可以做一些复杂的操作，比如提前定义好对象对应的处理函数
如['a','b','c']=>['我','你','他']
<span>{{_array.[i.label]}}</span>

子组件编写规则
1、至少用到两次的才有必要抽成子组件，貌似。
2、层级少，两层，一父多子。避免子组件套子组件，传值麻烦。
3、子组件中数据结构自己定，最简化的来，把接口的数据整理重赋。这样能保证组件复用性。

mixins 混入
在调用组件自身的钩子之前被调用
当组件和混入对象含有同名选项时，数据对象在内部会进行浅合并 (一层属性深度)
以组件数据优先
组件：
mixins: [loading],

loading.js:
const loading={
    data(){
        return{

        }
    },
    methods:{

    }
}
export default loading;

vue是单页面，一个page对象。而mpvue是小程序，实际是多页面，多个page对象
引入vuex和router的流程
编译后：
先走store/index.js
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)//在Vue实例中注入Vuex，其实类似绑定在原型中
const store = new Vuex.Store({//在Vuex中注入配置，得到生成好的store vuex实例
    modules: {
        ...modules
    }
})
export default store//暴露生成好的store vuex实例
再走main.js:
import store from './store'; //得到生成好的store vuex实例
import router from './router';
const app = new Vue({
  router,
  store, //生成好的store vuex实例挂载到页面上
  render: h => h(App),
})

mpvue中改为：
Vue.prototype.$store = store; //生成好的store vuex实例挂载到Vue原型上

vuex中
组件通过dispatch触发actions里的方法
通过...mapActions直接触发actions里的方法，不用写dispatch了

actions里通过commit触发mutations里的方法

actions得通过mutations改变state的数据，不能直接改state

computed计算属性里的值，在另一个computed中可以直接改
computed计算属性里的值，在methods和生命周期中不能直接修改
得加set方法来修改
computed: {
  fullName: {
    // getter
    get() {
      return this.firstName + ' ' + this.lastName
    },
    // setter
    set(newValue) {
      var names = newValue.split(' ')
      this.firstName = names[0]
      this.lastName = names[names.length - 1]
    }
  }
}
现在再运行 vm.fullName = 'John Doe' 时，setter 会被调用，vm.firstName 和 vm.lastName 也会相应地被更新

动态组件 component标签
<!-- 组件会在 `currentTabComponent` 改变时改变 -->
<component v-bind:is="currentTabComponent"></component>

ref属性：（非响应式，不能用做数据绑定）
普通节点上，获取dom
子组件上，获取子组件实例
用处：
父调子组件方法。比如父完成按钮，触发子组件校验函数
this.$refs.f.form_validate((res,msg)=>{//传入一个闭包需要res和msg
    console.log(res)
    console.log(msg)
})
子组件：
form_validate: function(cb) {//传入闭包
    let msg;
    let result = true;
    let formList = this.formList;
    ... //处理
    cb(result, msg);//向闭包传入result和msg
}

vuex中
...mapGetters等等辅助函数中路径 不能使用变量，得写死

当值传入子组件时
mounted只走一遍，不能对后期真实数据进行处理
watch虽然可以监听更新的数据，但是像这种：
watch:{
    percent(v){
        this.percent = v*100;//监测自己改变自己，会造成死循环，导致失败
    }
}
所以正确的办法是用computed
computed:{
    percentNew(){
        this.percent = v*100;
        return this.percent
    }
}
然后在模板中用percentNew，解决问题
其实用watch也行，但是得声明一个新的data属性
data(){
    return{
        percent:0,
        percentNew:0
    }
}
watch:{
    percent(v){
        this.percentNew = v*100;//然后用percentNew
    }
}

computed中不能执行异步，虽然computed也能获得异步的返回值，但是结束后不会在模板中同步数据

this.$data是data中的所有数据

this.$options返回实例的所有初始化选项export default中所有对象的初始值，
返回初始data，
貌似除了事件？
在选项中包含自定义属性时会有用处
new Vue({
  customOption: 'foo',
  created: function () {
    console.log(this.$options.customOption) // => 'foo'
  }
})

mpvue 在必要的需要数据重置的page调用
（因为mpvue不做数据重置工作）
onUnload() {  
    Object.assign(this.$data, this.$options.data());
    //离开page时，把data的初始值覆盖data对象，达到数据重置效果    
}

ui框架 use全局引用后，
有组件调用 和 函数调用
组件调用 import引入
import { Toast } from 'vant';
Toast();

函数调用
加this.$ 如：this.$toast()

实战中$nextTick也不能保证所有内部组件都渲染完成再触发？？
vue中调this.$refs.xxx时
解决办法setTimeout()
或者庚哥黑科技
try{
    ...//在这里写也行，不报错
}catch(e){}

vue-router
/user/123 这是一个命名路由
// 命名的路由
this.$router.push({ name: 'user', params: { userId: 123 }})

路由传参
// 带查询参数，变成 /register?plan=private
this.$router.push({ path: 'register', query: { plan: 'private' }})

this.$route.query获取参数

//路由回退
this.$router.go(-1)

vue中路由切换前的定时器是不会被销毁的，到了下个页面，定时器仍能正常进行

路由刷新则之前的定时器不能正常进行

页面回退如何传递值：
1.写在一个页面中，用弹窗或大弹框做内页的展示
2.存storage并设标志。写两个页面，内页存storage并设标志为true，内页只能返回外页，不能去其他页面。外页判断为true时读storage，并设标志为false。
3.存storage并结合路由守卫
4.vue中的全局事件emit加setTimeout延迟发出，因为vue路由切换不销毁其他进程。

vue对seo不友好，只能看见div id='app'
可以用服务端渲染
规模化-服务端渲染
引入prerender-spa-plugin模块，再改webpack配置
或者直接用
Nuxt.js

vue中不涉及需要数据同步，或者提交的地方。不一定要data数据层和视图层同步的，觉得直接粗暴的用原生js写就行了

nuxt的入口文件可以看作layouts里的视图模板文件

vant-ui里的list组件坑点
1.van-list组件外层必须高度占满100%。但是van-list组件高度不能100%，必须为真实高度。

如果van-list组件高度没有达到外层包裹层的高度，也就是没有滚动条，它会一直发起请求，直到van-list组件高度大于包裹层的高度加上offset的值。

2.要修改:offset的值，默认的300太大了，设成10触发

3.van-list组件由于是<van-list @load='onLoad'>组件默认页面初始化就会执行位置检查加载。如果不想页面初始化就加载，而是要通过另外的事件触发，就把 :immediate-check='false'值设为false，finished初始值设为true，然后在要执行的事件里把finished改为false。然后调用list实例的check方法主动检查滚动位置，但是要设延迟，因为可能list组件传值有时间间隔
如：
setTimeout(()=>{
    this.$refs.vanList.check();                             
},10)

在onLoad函数里
要结束加载的话，设置loading:false;finished:true。
加载就await ...里面写index++;this.count = res.data.count;this.loading=false;
if(listArray.length==this.count){
    this.finished = true
}
即可，同官网

sap单页文件
ssr服务端渲染

vue里设置定时器
在data里设个timer:null
mounted里
设个定时器函数
xxxSetInter(){
    this.timer = setInterval(()=>{
        if(...){
            clearInterval(this.timer);
            ...
        }
    });
}
其他调用的函数里
aaa(){
    clearInterval(this.timer);
    this.xxxSetInter();
}

vuex-router-sync一个固定的路由vuex包

vue国际化，$t()，切换语言的

axios.defaults.baseURL
baseURL请求头

[...args]参数格式，扩展参数
比如$emit(eventName,[…args]))
{string} eventName
[...args] //意为可以传,xxx,xxx,xxx 扩展下去
this.$emit('aa','a1','a2','a3')

element ui框架中的el-upload
是不倡导方法公用的，因为el-upload已经是独立封装好的了，
本身就是一个标签一个组件对应一个方法，方法分开写

对于循环的el-upload，方法中套on-success获取外层方法的index就行

实在不行，似乎el-upload中也是能获取原生事件的，
直接在on-success方法中取event，能取到

element ui的el-form-item的select组件的校验，
事件trigger:'change'，是change，而且当提交时才会校验为空

element ui el-select中v-model='form.xxx'时，
如果form.xxx初始值是undefind，后面再次赋值了等于新加属性，
视图层不更新。

this.$refs和props传值 分析
1.this.$refs
获取数据时：
this.$refs.subComponent.xxx也能取到子组件数据，取值赋值
this.$refs中子组件传的数据貌似也不是响应式的，只是渲染完毕时的，官方说只是一个应急方案
且访问了dom，加大了损耗，单纯数据操作不应该访问dom
获取dom时：
获取子组件的dom，this.$refs获取的也是父组件中子组件渲染完毕时的那个子组件dom。不是响应式的，不能获取到后面子组件dom的动态生成

总之：
this.$refs用在dom操作上
props用在数据传递上

vue-router中定义路由时
第一级路由前面都要加/
第二级开始，children里根目录一个重定向redirect:'./level1/level1-1',，后面都不加/，嵌套亦是如此，具体看我github template-elementUi-sass-vue2项目中的路由

但是
router-link和函数式this.$router.push中的path都必须写全路径'/a/b/c'，不然会跳错。
或者定义路由时给name值，根据name值跳，:to="{name: 'Trace'}"，就不必写一大堆前缀了。

路由中带:id，就是为了网页刷新，可以id扔可从url上取得，不掉信息
path : "detail/:id",

filters过滤器 第一个参数是message，arg1为第二个参数
{{ message | filterA('arg1', arg2) }}

slot具名插槽
父组件div slot='xxx'向子组件slot name='xxx'插入dom

slot-scope作用域插槽
父组件div slot='xxx' slot-scope="user" 下面可以用user.data可以取到子组件传过来的['a','b','c']
子组件slot name='xxx' :data="['a','b','c']"
总结：
意思是slot-scope可以使父组件拿到其中一个子组件的dom数据

不用slot-scope，渲染出来的dom都是一样的。取到父组件再渲染，可以在父组件定义不同的样式

官方文档是父组件todos传入，子组件再todo对象传回父组件，父组件通过 slot-scope="slotProps"，传回的todo会自动绑定到slotProps对象中
<template slot-scope="slotProps">
    <!-- 为待办项自定义一个模板，-->
    <!-- 通过 `slotProps` 定制每个待办项。-->
    <span v-if="slotProps.todo.isComplete">✓</span>
    {{ slotProps.todo.text }}
  </template>

或者用es6解构写法取 slot-scope  下面的属性
如：
<template slot-scope="{ todo }">//直接取到slot-scope下面的todo属性
    <span v-if="todo.isComplete">✓</span>
    {{ todo.text }}
  </template>

总结slot-scope，可以使父组件中 子组件的插槽中返回子组件的数据

关于vue slot 的多级传递使用 参考
https://blog.csdn.net/xuxu_qkz/article/details/81115022

在vue子组件上绑定原生事件.native 如@click.native

router-view组件也可以接收自定义方法
如：
<router-view @a='a'/>

Vue.mixin()全局混用 使用出现问题？，有路由嵌套的组件，我怀疑会递归循环很多次，导致全局混入的内容被调很多遍？
每次切换路由，都会执行很多遍

暂时只想到一个个引入，不知道全局混入如何使用不会重复调很多次？

在mixin.js中比如写了async mounted调用异步，组件里mounted没写async，是能正常合并的，不会报错。

从子路由回到父路由是不走created和mounted之流的

vue-cli的npm run build默认执行在根目录
在config-index.js中assetsPublicPath把/改成./即可，在当前目录执行
但是初次运行时应该是/，初次运行assetsPublicPath:'./'会报错

当几个详情页是一样时，把整个详情页作为一个组件，分别放在不同内页页面中，直接一个div包住整个详情页组件，这样可以使路由正常运行，详情页又可公用。

定义路由时可以配置meta字段，
需要遍历 $route.matched 来检查路由记录中的 meta 字段

vue路由守卫
一、全局守卫 router对象中（前置router.beforeEach解析router.beforeResolve后置router.afterEach）
router.beforeEach
const router =  new Router({});
router.beforeEach((to, from, next) => {});
router.afterEach((to, from) => {});
二、路由独享守卫（beforeEnter）
{
      path: '/foo',
      component: Foo,
      beforeEnter: (to, from, next) => {
        // ...
      }
    }
三、组件内守卫 在用了router-view的组件中（beforeRouteEnter，beforeRouteUpdate，beforeRouteLeave）
在export default {}中直接暴露 生命周期钩子
beforeRouteUpdate (to, from, next) {

}
beforeRouteEnter (to, from, next) {
    
}

参数或查询的改变并不会触发进入/离开的导航守卫。
1.你可以通过观察 $route 对象来应对这些变化，
2.或使用 beforeRouteUpdate 的组件内守卫

to/from的值：
fullPath:"/a2"
hash:""
matched:(2) [{…}, {…}]
meta:{aa: "bbbbb"}
name:"a2"
params:{}
path:"/a2"
query:{}

vue根据状态显示不同class方法
<span class='status' :status="xxx.status">{{xxx.string}}</span>
css:
.status[status='aaa']{
    color: #000;background: #fff;
}

h5 native混合开发：
h5调native，调methods里window下的方法
native调h5，在mounted里监听定义在window下的方法

避免重复绑定
this.$event.$off('xxx').$on('xxx',res=>{})

用vux的group组件，一定要设置label-width="4.5em" label-margin-right="2em" label-align="right" 这三个属性
但是尽管如此，还是觉得挺不灵活的
样式不能方便设置，selector没有title插槽，不方便修改
popup-picker引入报错，是因为vux-loader把<style lang="less">@import '../../styles/1px.less';</style>转为@import '../../styles/0.5px.less'了，导致找不到该文件
设vux-loader时要排除1px.less，这个不转，否则引入用了该文件的组件都会报错
x-input的restricted-label不生效
总之很闹心，还是倾向于自己写样式

vue引用插件方法，
import进包
实例化对象，设置参数

vux的selector是个坑，选项不固定会变。用picker插件或者select插件做
相比较select插件还是picker插件好，调整小
select插件难调，select插件在表单中对齐其他控件麻烦

params.categoryId  mattersTypeValue

params.secondCategoryId  mattersCategoryValue

vue单页应用页面组件封装规则:
外层结构相关组件-按照路由分内页-内页中再分别引入页面部分组件。
而且vue的数据传输是单向的，同一页面部分，赋值功能和取值功能最好分开写。
完全一样的部分封装成子组件重复引用，不一样的部分还是放在当前页面就行了，在当前页面做判断写不同，不要把判断写不同放到子组件里做，容易乱，减少嵌套关系。

在<router-link>绑定点击事件，@click.native

脚手架更新
npm uninstall vue-cli -g

cnpm install -g @vue/cli

创建一个项目
vue create hello-world

在 Windows 上通过 minTTY 使用 Git Bash，交互提示符并不工作。通过 winpty vue.cmd create hello-world 可以上下选择

style绑定，对象语法，逗号分隔，样式值要用单引号 括起来 
如：
<ul :style="{transform:'translateY(-32px)',transition:'all 1s'}"></ul>

感觉vue项目要做seo，
只有通过nuxt等服务端渲染？
webpack配置多页面，右击查看代码，还是只有一个div id='app'，对seo没用

返回顶部
data(){
    return{
        scrollTop: 0,
        timer :null
    }
}
methods:{
    timeFun(fn,s=7){
        this.timer = setInterval(fn,s);
    },
}
backToTop(){
    this.timeFun(() => {
        if(this.scrollTop <= 0){
            this.scrollTop = 0;
            document.body.scrollTop = document.documentElement.scrollTop = this.scrollTop;
            clearInterval(this.timer);
        }else{
            this.scrollTop -= 10;
            document.body.scrollTop = document.documentElement.scrollTop = this.scrollTop;
        }
    });
}

v-for v-if可以用在<template></template>标签上，不占位，这时:key要写在子元素中
v-show不行用在<template>上

v-for v-if一起用时，v-for 具有比 v-if 更高的优先级，意味着 v-if 将分别重复运行于每个 v-for 循环中