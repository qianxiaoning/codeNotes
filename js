------------------------------------------------------------------------------------------------------------------
js网页特效经典300例笔记
------------------------------------------------------------------------------------------------------------------
js基础（包含旧技术）
刷新页面window.location.reload();
meta法 <meta http-equiv='refresh' content='20'>20秒自动刷新
前进后退 window.history.forward(); window.history.back(); history.go(1);history.go(-1);
关闭窗口 window.close();
修改网页标题 document.title = '新的标题';
top顶层窗口self当前窗口
js跳转链接 self.location.href = newUrl;

try...catch...
try {
    adddlert("欢迎光临！");//尝试执行的代码块
}
catch(err) {
    console.log(err.message);//获取的错误信息
}

取得html头部dom
var head = document.getElemenetsByTagName('head').item(0);//.item(0)等同于[0]
创造原生节点 var newDom = document.createElement('div');
js加节点 parentDom.appendChild(newDom);
js加文本节点span.appendChild(document.createTextNode('我的dom文本节点'))
js删除节点 .removeChild()删除子节点 dom.parentNode.removeChild(dom)获取父元素以删除自身
页面所有元素加载完成
window.onload = function(){}
页面文档加载完成
document.onreadystatechange = function(){
    //判断readyState属性
    if(document.readyState == 'complete'){
        console.log('文档加载完毕');
    }
}
清除缓存 链接后加时间戳 href += '&time='+ new Data().getTime();

dom属性
窗口可视高度 (document.documentElement||document.body).clientHeight

div.clientWidth/div.clientHeight 可见区域宽高（不含border）
div.offsetWidth/div.offsetHeight可见区域宽高（含border）
div.scrollWidth/div.scrollHeight全宽高（不含border含scroll隐藏部分）

div.clientLeft 返回元素周围边框的厚度
div.scrollLeft/div.scrollTop被卷去的左，高
div.offsetTop dom距离上方存在定位控件的距离

MouseEvent事件对象属性
offsetX//指针相对于目标节点内边位置的坐标
clientX//指针相对于浏览器可视页面，不含标题栏
x//是 MouseEvent.clientX 属性的别名
screenX//相对于全局（屏幕）的坐标
pageX//指针相对于整个文档的坐标

movementX//指针相对于最后mousemove事件位置的坐标
layerX//事件相对于当前层中的水平坐标

composed//该事件是否会通过阴影DOM边界传播到标准DOM的属性
detail//是1加上当前的点击次数
which//当鼠标事件触发时，表示被按下的按钮

getElementsByName根据name获取
doms[i].tagName获得dom节点的标签名字
for in 遍历对象属性
for(var prop in obj){
    str+=prop + '':'+obj[prop]+'<br/>'
}
访问父节点js .parentNode jq .parent() .parents()
访问子节点js .childNodes会返回回车空格#text文本节点 jq .children() .find()
js节点对象三个属性 nodeName,nodeValue,nodeType(1:元素element,2:属性attr,3:文本text,8:注释<!---->)
js克隆节点 .cloneNode(false)不包括后代（甚至文本节点）.cloneNode(true)包括后代
js获得节点行内样式jsDom.style.display
js 是否包含子元素 .hasChildNodes()
js获取表单dom document.forms[0]//获取表单的控件数组form.elements//控件的值form.elements.value
转义字符'\r'光标到行首（回车）'\n'光标下移一行（换行）
js 通过控件name获得控件dom
<input type='text' name='myText'/> //获得var inp = document.forms[0].myText;
js修改表单的提交方法 forms[0].method = 'post'
js 表单的action提交地址 forms[0].action;
js 重置表单 forms[0].reset();
js 获得select的值select.value
<input type='hidden'/>为了传隐藏参数的一个容器
checkbox.checked = true/false;
window.frames;得到window里的框架数组
iframe框架 self,parent,top自身，父级，顶级
49

js new操作符的作用
var obj  = {};
obj.__proto__ = Base.prototype;
Base.call(obj);
eval使用
eval并不会引起xss攻击，性能确实慢一些，但是不是这么夸张
eval()可以访问和修改它外部作用域中的变量,会污染全局变量，主要缺点
可以用Function或new Function代替，两者一样，前者是简写。Function访问自己的局部，不影响其他上下文变量
Function用法，Function接收多个字符串参数arg1,function：
var message = new Function('msg','alert(msg)');
// 等价于：
function message(msg) {
    alert(msg);
}
用Function代替eval如：
function evil(str) {
    return new Function('return ' + str)();
}
关于new关键字
Number、String、Boolean、Date时，new返回一个实例
Object、Array、Function、RegExp时，new和直接调用函数产生的结果等同，都是新建一个自身对象，不用new为简写。

DOM.select();选中文本域中的内容

string.fontsize(size);用于按照指定的尺寸来显示字符串;参数必须是从 1 至 7 的数字

reduce() 方法接收一个函数作为累加器
array.reduce(function(total, currentValue, currentIndex, arr), initialValue)
e.g.
var numbers = [65, 44, 12, 4];
function getSum(total, num) {
    return total + num;
}
document.getElementById("demo").innerHTML = numbers.reduce(getSum);

Date.now()
获取1970至今的毫秒数

js立即执行函数和var声明变量
除了(function(){})()之外，+-*!function(){}()都能起到立即执行效果，但是这作用只是不污染全局变量
js还是顺序执行的，立即执行函数也是顺序执行到该函数，再立即执行，不会比前面的代码快
在同一级作用域（子作用域不行），js解析最快的还是var变量声明，第一时间把全文所有的var变量赋为undefined，使前面碰到这些变量不会报错

obj.hasOwnProperty(prop)
用来判断某个对象是否含有指定的属性，返回Boolean值
用来检测一个对象是否含有特定的自身属性；和 in 运算符不同，该方法会忽略掉那些从原型链上继承到的属性。
如：
function A(){this.q=1;};
A.prototype.w=2;
var b=new A();
b.e=3;
b.hasOwnProperty('q');//true 检测到 继承构造函数的函数内方法
b.hasOwnProperty('w');//false 忽略原型链继承
b.hasOwnProperty('e');//true 检测到 自身属性

get和post的参数传递
GET把参数包含在URL中
POST通过request body传递参数

js分原始类型和引用类型
数组和对象存在内存地址，需要深拷贝
嵌套的数组对象也要深拷贝，所以单层for in循环不行，内层还是关联的
浅复制（拷贝）深复制（拷贝）
    如果堆地址指向没变就是 浅复制
    堆地址指向一个新地址 深复制
实现方法
    浅复制：
        直接赋值        
    单层深复制：
        Object.assign()
        lodash:_.assign()
    多层深复制：
        或者直接用类改写
        for in循环
        function deepCopy(p, c) {
    　　　　var c = c || {};
    　　　　for (var i in p) {
    　　　　　　if (typeof p[i] === 'object') {
    　　　　　　　　c[i] = (p[i].constructor === Array) ? [] : {};
    　　　　　　　　deepCopy(p[i], c[i]);
    　　　　　　} else {
    　　　　　　　　　c[i] = p[i];
    　　　　　　}
    　　　　}
    　　　　return c;
    　　}
        或
        function deepcopy(obj) {
            var out = [],i = 0,len = obj.length;
            for (; i < len; i++) {
                if (obj[i] instanceof Array){
                    out[i] = deepcopy(obj[i]);
                }
                else out[i] = obj[i];
            }
            return out;
        }
        转成 JSON 再转回来：var obj2 = JSON.parse(JSON.stringify(obj1));会破坏constructor对象，只对Number, String, Boolean, Array有效
        递归拷贝
        使用for in配合Object.create()方法
        lodash:_.merge()
        jq的$.extend

es6 ...
...对象展开运算符
可以将数组和对象转为参数列
可以将一个数组展开为另一个数组，或将一个对象展开为另一个对象

...[1,2,3] 可以将数组转化为参数。代替了es5的f.apply(null,[1,2,3])
可以 array1.push(...array2);
let first = [1, 2];
let second = [3, 4];
let bothPlus = [0, ...first, ...second, 5];

let defaults = { food: "spicy", price: "$$", ambiance: "noisy" };
let search = { ...defaults, food: "rich" };

解构赋值
...赋值
数组：
let [a,b,...c] = [1,2,3,4,5]
//c为[3,4,5]
let [name,,age]=['wayou','male','secrect'];

对象：
let o = {
    a: "foo",
    b: 12,
    c: "bar"
};
let { a, b } = o;
let { a, ...b1 } = o; 
b1//为{b: 12, c: "bar"}

Obejct.keys 只对最外层
一、Obejct.keys把对象转为key值数组，让对象可以和数组一样用forEach循环。
let params={xxx};
Object.keys(params).forEach((key,index)=>{
    console.log(key+' '+index);//返回键和序号
})
不能用以两个不同属性的对象一对一赋值

二、拥有数组特性，比如数组的length长度。
判断时，Obejct.keys(Obj).length!=0;//判断对象为不为空

返回一个所有元素为字符串的数组，其元素来自于从给定的object上面可直接枚举的属性。这些属性的顺序与手动遍历该对象属性时的一致
// simple array
var arr = ['a', 'b', 'c'];
console.log(Object.keys(arr)); // console: ['0', '1', '2']
// array like object
var obj = { 0: 'a', 1: 'b', 2: 'c' };
console.log(Object.keys(obj)); // console: ['0', '1', '2']

Object.values() 只对最外层 
返回值的数组，与Object.keys相反

Object.assign()
用于将所有可枚举属性的值从一个或多个源对象复制到目标对象。后面会把前面覆盖。它将返回目标对象。
相当于把有值的对象传给没值的对象，避免直接赋值产生的地址指向相同影响

js map()
map() 方法返回一个新数组，数组中的元素为原始数组元素调用函数处理后的值。
array.map(function(currentValue,index,arr), thisValue)
var numbers = [4, 9, 16, 25];
numbers.map((item)=>{return item*item}));//[2,3,4,5]

普通函数：this 永远指向调用它的对象，new的时候，指向new出来的对象
箭头函数：this 
箭头函数没有自己的 this，当在内部使用了 this时，它会指向最近一层作用域内的 this
默认指向在定义它时所处的对象(宿主对象),而不是执行时的对象
定义时候绑定，就是this是继承自父执行上下文
因为没有自己的this，无法用做构造函数,call,apply等动态上下文this的情况
(定义对象方法、定义原型方法、定义构造函数、定义事件回调函数)

es6 箭头函数 相当于匿名函数 默认有个返回值
setInterval(()=>{
     console.log(this.fileList);
 }, 1000)
1. 具有一个参数的简单函数
var single = a => a
single('hello, world') // 'hello, world'
　　
2. 没有参数的需要用在箭头前加上小括号
var log = () => {
    alert('no param')
}　　

3. 多个参数需要用到小括号，参数间逗号间隔，例如两个数字相加
var add = (a, b) => a + b
add(3, 8) // 11　　

4. 函数体多条语句需要用到大括号
var add = (a, b) => {
    if (typeof a == 'number' && typeof b == 'number') {
        return a + b
    } else {
        return 0
    }
}
　　
5. 返回对象时需要用小括号包起来，因为大括号被占用解释为代码块了
var getHash = arr => {
    // ...
    return ({
        name: 'Jack',
        age: 33
    })
}
　　
6. 直接作为事件handler
document.addEventListener('click', ev => {
    console.log(ev)
})　　

7. 作为数组排序回调
var arr = [1, 9 , 2, 4, 3, 8].sort((a, b) => {
    if (a - b > 0 ) {
        return 1
    } else {
        return -1
    }
})
arr // [1, 2, 3, 4, 8, 9]

Array filter(i,ind,arr) 方法
lter() 方法返回一个新的数组，新数组中的元素是通过检查指定数组中符合条件的所有元素。
var ages = [32, 33, 16, 40];
function checkAdult(age) {
    return age >= 18;
}
function myFunction() {
    xxx.innerHTML = ages.filter(checkAdult);
}

Promise异步链式机制
比如微信小程序wx.request封装
const request = function (url, method, data) {
    return new Promise((resolve, reject) => {//返回一个Promise对象
    wx.request({
        url: url,
        method: method,
        data: data,
        success(res) {
        if(res.data.code==200){
            resolve(res);//此处调成功的resolve函数
        }                                
        },
        complete(){

        },
        fail(err) {
            reject(err);//此处调失败的reject函数
        }
    });
    });
};
调用：
request(
    this.$url.login,
    'POST',
    this.form
).then(
    (res) => {
    console.log(res)
    }
).catch(
    (err) => {
    console.log(data)
    }
);
链式调用：
request(
    this.$url.login,
    'POST',
    this.form
).then(
    (res) => {
    console.log(res);
    return request(
        this.$url.login1,
        'POST',
        this.form
    )
    }
).then(
    (res1)=>{
        console.log(res1);
    }
).catch(
    (err) => {
    console.log(err)
    }
);

async await
异步操作用了await，其父元素必需用async，否则会报错

如果在函数中 return 一个直接量，async 会把这个直接量通过 Promise.resolve()封装成 Promise 对象
如果 async 函数没有返回值，它会返回 Promise.resolve(undefined);
await只能获取到resolve值，得用其他方法（后文有）获取reject值
取await后面的值，let res = (await this.$http(...)).data; 加括号即可

用了async,await后 如果await没有成功返回，后面的代码都会被阻塞
比如：
let res =await this.$http(this.$url.trace_record,'POST',this.formData);
console.log(1);
//如果上面await没有正常通过resolve(res.data)，得到res.data值，后面的代码不会执行，比如日志的1

const loginRequest=(url,data)=>{
    return new Promise((resolve,reject)=>{
        success(res){
            resolve(res);
        },fail(err){
            reject(err);
        }
    })
}
async function login(){
    let res=await loginRequest('',{});
    //得到login接口的返回值，把异步变成同步的书写方式
}

async await处理then链
//obj1到obj4顺序执行
const httpFun1=(obj)=>{
    return xxx.then(
        (res)=>{
            return res
        }
    )
}
const httpFun2=(obj)=>{
    return xxx.then(
        (res)=>{
            return res
        }
    )
}
const httpFun3=(obj)=>{
    return xxx.then(
        (res)=>{
            return res
        }
    )
}
//把异步完全变成同步写
async function callChaining1(){    
    let obj1=await httpFun1({});
    let obj2=await httpFun1({});
    let obj3=await httpFun1({});
    //得到我要的obj4
    console.log(obj4)
}
//下面是Promise法
    const obj1 = {};
    step1(obj1)
        .then(obj2 => step2(obj2))//前面值不用注入后面，不用return
        .then(obj3 => step3(obj3))
        .then(obj4 => {
            console.log(obj4);//得到obj4           
        });

//obj1到obj4，后一步需要前一步结果
const httpFun1=(obj1)=>{
    return xxx.then(
        (res)=>{
            return res
        }
    )
}
const httpFun2=(obj1,obj2)=>{
    return xxx.then(
        (res)=>{
            return res
        }
    )
}
const httpFun3=(obj1,obj2,obj3)=>{
    return xxx.then(
        (res)=>{
            return res
        }
    )
}
async/await：
async function callChaining2(){
    const time1 = 300;
    const time2 = await step1(time1);
    const time3 = await step2(time1, time2);
    const result = await step3(time1, time2, time3);
}
Promise://？对写法有疑问
const time1 = 300;
    step1(time1)
        .then(time2 => {
            return step2(time1, time2)
                .then(time3 => [time1, time2, time3]);//?
        })
        .then(times => {
            const [time1, time2, time3] = times;
            return step3(time1, time2, time3);
        })
        .then(result => {
            console.log(`result is ${result}`);
            console.timeEnd("doIt");
        });

async/await的reject结果
async function myFunction() {
  try {
    await somethingThatReturnsAPromise();
  } catch (err) {
    console.log(err);
  }
}
// 另一种写法
async function myFunction() {
  await somethingThatReturnsAPromise().catch(function (err){
    console.log(err);
  });
}

确实希望多个请求并发执行，可以使用 Promise.all 方法
async function dbFuc(db) {
  let docs = [{}, {}, {}];
  let promises = docs.map((doc) => db.post(doc));

  let results = await Promise.all(promises);
  console.log(results);
}
// 或者使用下面的写法
async function dbFuc(db) {
  let docs = [{}, {}, {}];
  let promises = docs.map((doc) => db.post(doc));

  let results = [];
  for (let promise of promises) {
    results.push(await promise);
  }
  console.log(results);
}

in运算符
如果指定的属性在指定的对象或其原型链中，则in 运算符返回true
var trees = new Array("redwood", "bay", "cedar", "oak", "maple");
0 in tree//true

forEach
用于调用数组的每个元素，并将元素传递给回调函数
array.forEach(function(currentValue, index, arr), thisValue)
[4, 9, 16, 25].forEach(function(item, index){demoP.innerHTML += index + item + "<br>";})

arr1.forEach((v,i)=>{        
    if(v=='完成'){arr1[i]='f'}
    else if(v=='重置'){arr1[i]='r'}
});
forEach第三个参数是自身数组，可以即时操作改变自身

Number.isInteger()
判断一个值是否为整数，返回布尔值
Number.isInteger(25.0) // true

ea6的export,export default,import
export可以暴露多个对象 export default只能暴露一个匿名对象
引用方法：
export:
    a文件export {a,b,c};    
    b文件import {a,b} from './a.js'
    使用 a();

    导入所有
    b文件import * as xname from "./a.js";
    使用 xname.a();

export default:
    a文件export default{}或export default[]等等;
    b文件import xname from './a.js'
    使用 xname.a();或xname[0];

Object.defineProperties()
在一个对象上定义新的属性或修改现有属性，并返回该对象

if...else...不写()的简写，{}层只能写一行
if(...)
xxx
else
xxx

工厂函数 创建类实例
function a(myname){
    var obj = new Object();
    obj.name=myname;
    obj.intro=function(){
        console.log(this.name)
    }
}
var p1 = a('aa');
var p2 = a('bb');
构造函数
function a(myname){    
    this.name=myname;
    this.intro=function(){
        console.log(this.name)
    }
}
var p1 = new a('aa');
var p2 = new a('bb');

==和===，对于引用类型，不光比值和类型，还有比内存地址

Symbol 新的数据类型 表示独一无二的值
let s1 = Symbol('foo');//'foo'为此Symbol值的描述
let mySymbol = Symbol();
// 第一种写法
let a = {};
a[mySymbol] = 'Hello!';
// 第二种写法
let a = {
  [mySymbol]: 'Hello!'
};

Class类 类和模块的内部，默认就是严格模式
5：
function Point(x, y) {
  this.x = x;
  this.y = y;
  this.methodA=function(){

  }
}
Point.prototype.toString = function () {
  return '(' + this.x + ', ' + this.y + ')';
};
Point.prototype.toString1 = function () {
  return '(' + this.x + ', ' + this.y + ')';
};
var p = new Point(1, 2);
6：
//定义类
class Point {
  //构造函数部分  
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.methodA=function(){

    }    
  }
  //静态方法//可以被子类继承
  static classMethod() {//调用，Point.classMethod()
    return 'hello';
  }
  //原型方法
  toString() {
    return '(' + this.x + ', ' + this.y + ')';
  }
  //原型方法间不加逗号
  toString1() {
    return '(' + this.x + ', ' + this.y + ')';
  }
}
6:
表达式定义法
const A = class a{

}
类名是A，a是Class内部代码用，指代当前类
//调用时5，6一致,new 出来
类继承
extends
class Point {
}
class ColorPoint extends Point {//子类ColorPoint
    constructor(){
        super();
        this.xx...//调用super后才能调用this
    }    
}
class ColorPoint extends Point {
  constructor(x, y, color) {
    super(x, y); // 调用父类的constructor(x, y)
    this.color = color;
  }
  toString() {
    return this.color + ' ' + super.toString(); // 调用父类的toString()
  }
}
子类的constructor中必须调用super，表示父类
super(x, y)表示构造方法，super.toString()表示原型方法

es6可以为原生构造函数定义子类
Boolean()
Number()
String()
Array()
Date()
Function()
RegExp()
Error()
Object()

function a(obj={}){//参数中，等号后面是默认值
    console.log(obj)
};
a()
a({q:1})
function a(s=''){//参数中，等号后面是默认值
    console.log(s)
};
a()
a('aa')

------------------------------------------------------------------------------------------------------------------
jq
each循环
var ss = $(".stars0 ul li");
ss.each(function(i,d){
    $(d).addClass("on");
    if(i == _index){return false;}
});
end() 方法结束当前链条中的最近的筛选操作，并将匹配元素集还原为之前的状态。
end()
$("p").find("span").end().css("border", "2px red solid");操作p
addBack()
addBack()把堆栈中之前的元素集添加到当前集合,andSelf()已废弃
$("div").find("p").addBack().addClass("border");

keydown事件e.keyCode按键码，比如13是回车

$(":animated")选择器选取当前的所有动画元素

jq css({})里可以用变量代替，如var aCss={"background":"#fff","color":"red"};xxx.css(aCss);这样

closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上。parent()不包含当前元素
可以传递 DOM 元素作为 context，在其中搜索最接近的元素。listItemII中最接近的ul
$('li.item-a').closest('ul', listItemII).css('background-color', 'red');

:contains 选择器选取包含指定字符串的元素
$(":contains(text)")
$("p:contains(is)").css("background-color","red");

$("tr:lt(4)") :lt() 选择器选取 index 值小于指定数字的元素。
$("tr:gt(3)") :gt() 选择器选取 index 值大于指定数字的元素。


------------------------------------------------------------------------------------------------------------------
工作感悟
------------------------------------------------------------------------------------------------------------------
判断对象是否为空
用JSON.stringify({})=='{}'判断对象是否为空
因为{}=={}和[]==[]都为false
原理 {}和[]都是对象（引用值），都是存在内存的不同位置，确实存在的东西，所以不相等
所以Boolean({}),Boolean([])都为true Boolean(!{}),Boolean(![])都为false
------------------------------------------------------------------------------------------------------------------
this的指向与改变 call,apply,bind
call和apply调用都会立即执行。bind会生成个新的函数，下次再执行。
如果只是单纯传参不需要调用子类，则传this即可
Js apply()使用详解 http://blog.csdn.net/business122/article/details/8000676
对象方法调用test.sum(); this指向对象
函数调用sum(); this指向window
js中call apply bind
参考：https://www.zhihu.com/question/20289071
function Cat(){
}
cat.prototype={
    food:"fish",
    say: function(){
        alert("I love "+this.food);
    }
}
var blackCat = new Cat;
blackCat.say();
whiteDog = {food:"bone"};
blackCat.say.call(whiteDog);
明确参数时oldObj.call(newObj, arg1, arg2);
不明确参数时oldObj.apply(newObj, [arg1, arg2]);
function add(j, k){ return j+k;}
function sub(j, k){ return j-k;}
sub(5, 3); //2
sub.call(add, 5, 3); //2
sub.apply(add, [5, 3]); //2 
用来实现对象的继承
var Parent = function(){ this.name = "yjc"; this.age = 22;}
var child = {};console.log(child);//Object {} ,空对象
Parent.call(child);
console.log(child); //Object {name: "yjc", age: 22}
进阶--------------------
参考https://www.cnblogs.com/tingyu-blog/p/6212392.html
var test = {
    a : 5,
    b : 6,
    sum : function (a,b) {
        var self = this;
        function getA() { return self.a; }//返回值指向obj对象本身的值
        function getB(){ return self.b; }//返回值指向obj对象本身的值
        alert(a);//形参指向call,apply,bind传入的参数
        alert(b);//形参指向call,apply,bind传入的参数
        return getA() + getB(); //obj对象本身的值相加
    }
}
var obj = {a:2,b:3};
alert(test.sum.call(obj,4,5)); // 调用时self = this = obj，alert顺序4,5,5 //call直接执行
alert(test.sum.apply(obj,[6,7])); // 调用时self = this = obj，alert顺序6,7,5 //apply直接执行
var sum = test.sum.bind(obj,8); // 此处返回一个只有一个参数的函数sum(b) //bind返回一个新的方法，得再调用一次
alert(sum(9)); // 调用时self = this = obj，alert顺序8,9,5 //bind传参
或者
var sum = test.sum.bind(obj); // 此处返回一个只有一个参数的函数sum(b) //bind返回一个新的方法，得再调用一次
alert(sum(8,9)); // 调用时self = this = obj，alert顺序8,9,5  //bind传参
alert(sum(8,9,10));//alert顺序8,9,5 多传不用
----------------------------------
正如vue里面 mounted和methods里的this指向vue实例
但是通过this.$options.methods.test2();调用methods的test2方法时，test2方法里的this指向就是methods对象了，不是vue实例了，指向变了。
如果我还是需要context上下文是vue实例，只需要this.$options.methods.test2.bind(this)();把this通过bind传入，重新把test2方法里的this指向回归vue实例即可。
这里this.$options.methods.test2.bind(this)();
this.$options.methods.test2.call(this);
this.$options.methods.test2.apply(this);
都是一样的效果，区别在于call和apply直接执行，bind需要再调用一次。
apply会把第二个参数中的数组中的每一项都当成参数一一传入，所以Math.min.apply(null, [3,12,56,22,83,67])能这样取最小值。
------------------------------------------------------------------------------------------------------------------
数据双向绑定框架中
字符串直接调用字符串方法 如'aaa'.substring(0,2)  为'aa' 
数值直接调用数值方法 套个括号()就行 如(111).toFixed(2) 为"111.00"
vue中.vue实例的html里，方法直接写在双括号里就行了 如{{string.substring(0,2)}}，{{number.toFixed(2)}}
但是微信小程序不行 微信小程序的wxml只能用正则表达式，不能直接调用js对象的方法 如{{string.substring(0,2)}}是不行的。
------------------------------------------------------------------------------------------------------------------
js静态方法、原型扩展，实例方法
//构造函数 function A(){}
A.staticMethod = function(){}//为静态方法，直接加在构造函数上的
//var a = new A(); a为实例对象
a.prototype.newWay = function(){}//原型扩展 加在构造函数A的原型上的，所有A的实例对象可以调用new A().newWay();//即为实例方法
$.fn==$.prototype 返回jquery实例（对象）所有继承来的属性数组
$.constructor 返回的是创建jquery实例的构造函数
jq中extend 将后一个对象覆盖前一个对象的属性
插件两方法：
jQuery.extend(object);为扩展jQuery类本身.为类添加新的方法 添加静态方法。之前没有调用的实例 本身就是一个函数，可以直接调用。
比如$.extend({ add:function(a,b){returna+b;}}); 调用时只需$.add $.add(3,4); return 7;
jQuery.fn.extend(object);给jQuery对象添加方法 添加实例方法。 所有jq实例可以调用
比如:$.fn.extend({alertWhileClick:function(){$(this).click(function(){ alert($(this).val());}); }});
构造函数（类）的prototype属性和 实例化后的对象的__proto__指的是同一个东西 即类的原型扩展
实例化后的对象的__proto__指的是构造函数的原型
而实例化后的对象的.__proto__.__proto__指的是构造函数(函数)的构造函数是对象Object的原型 在对象里有一个属性方法hasOwnProperty属性方法 再.__proto__就是null了
.hasOwnProperty()属性方法用来检验一个对象是否自己拥有一个属性而非通过进化链__proto__继承来的属性
__proto__隐式原型 指向其构造函数的prototype原型扩展
构造函数，实例对象，实例，继承新感悟
构造函数只是创建实例的模板，构造函数自身的prototype属性指向原型对象，开始只有constructor一个属性，也就是这个构造函数只有这一个属性。构造函数里面的this.xxx=xxx，不属于原型，只是实例继承原型后追加的属性。
万物皆对象，分普通对象和函数对象，只有函数对象有prototype属性，其余万物都是__proto__属性。函数对象可以看做类，类的原型只是指自身以及后面追加的原型方法。而和类里面的this.xxx=xxx，没有关系。
总之原型和类的原型属性有关，和类里面的this附加的属性没有关系。

__proto__也能用于继承
var a={a:1}//看作是类的原型，相当于A.prototype
var b={},c={}
b.__proto__=a;c.__proto__=a;
相当于b和c对象继承了a这个原型对象,（实际a并不存在A这个构造函数）
{a:1}都存在于b和c的原型链中，不存在于对象内，对象内都是空的
给对象b和c赋值，互不影响，但是对他们的原型链修改，就互相影响，如：b.__proto__.a=9，就互相影响
------------------------------------------------------------------------------------------------------------------
//Promise机制了解
//执行步骤 4321
new Promise(resolve =>{
    resolve(1);
    Promise.resolve().then(()=>console.log(2));
    console.log(4);    
}).then(t=>console.log(t));
console.log(3);
//王的解释 没有进resolve都是同步，所以43。promise的队列任务永远往前插入，所以resolve之后插入到执行任务队列最前2先执行，然后1，4321。
//我的理解 没有进resolve都是同步，所以43。Promiese里面执行完毕再执行外面的then，所以21。
------------------------------------------------------------------------------------------------------------------
js中ontouchstart事件中 e.touches[0].clientX代表第一根手指触屏屏幕的x坐标 e.touches[0].clientY代表y
------------------------------------------------------------------------------------------------------------------
js闭包
闭包获取ajax回调函数的值，到别的函数中，究极闭包
1.同级取变量。
function aAjax(callback){//将函数作为参数传入函数
    $.ajax('test.php' , function(data){
        callback(data);//将返回结果当作参数返回
    });
}
function needData(data){
    console.log(data);
}
aAjax(needData);//调用
2.跨两级，取同级的内部函数变量。
同理。
------------------------------------------------------------------------------------------------------------------
前端跨域
简单的跨域请求jsonp即可，复杂的cors，窗口之间JS跨域postMessage，开发环境下接口跨域用nginx反向代理或node中间件比较方便。
1.CORS（Cross-Origin Resource Sharing 跨源资源共享）支持所有类型的HTTP请求
相对路径需改为绝对路径
普通跨域请求：只服务端设置Access-Control-Allow-Origin即可，前端无须设置。

如果要发送Cookie，Access-Control-Allow-Origin就不能设为星号，必须指定明确的、与请求网页一致的域名。
带cookie请求：前后端都需要设置字段，
var xhr = new XMLHttpRequest();
xhr.withCredentials = true;//打开withCredentials属性
另外需注意：所带cookie为跨域请求接口所在域的cookie，而非当前页。
IE8+：IE8/9需要使用XDomainRequest对象来支持CORS

2.h5的window.postMessage和onmessage
postMessage(data,origin)
window.postMessage(JSON.stringify(data), 'http://www.domain2.com');
//发送 postMessage()方法允许来自不同源的脚本采用异步方式进行有限的通信，可以实现跨文本档、多窗口、跨域消息传递。
//接收  onMessage(data, source, origin) 方法监听并接收来自postMessage传递的数据。

PostMessage（异步）只把消息放入队列，不管其他程序是否处理都返回，然后继续执行，这是个异步消息投放函数。
而SendMessage（同步）必须等待其他程序处理消息完了之后才返回，继续执行，这是个同步消息投放函数。

3.jsonp跨域。只能get请求
    js jsonp跨域方法
    生成一个script标签，src路径上写要请求的域的资源。路径上加上?callback=前端写的一个函数名。
    和后台约定好，获取callback这个参数名字后面的值。把要返回的json数据放入callback值(data)中。
    通过script标签，返回的默认是一段js代码，而callback值(data)会调用前端写的callback值函数，json数据会作为参数传入callback值这个函数中。
    获取到跨域数据
    
    jq jsonp跨域方法
    通过$.ajax，要注意的是两个参数，dataType:"jsonp"，jsonp:"callback"，就能在success回调函数中取到值了。
    其中jsonp:"callback"指约定的存放数据的函数名的参数叫"callback"。
    而jsonpCallback这个参数指的是，指定处理jsonp数据的函数，取代jq自动生成的匿名函数，方便自己提供回调函数和错误处理。
    
    jsonp跨域的原理就是用了，script标签跨域调用js代码的能力。把要获取的数据作为参数传入js函数中获取

4.document.domain + iframe
仅限主域相同，子域不同的跨域应用场景。
两个页面都通过js强制设置document.domain为基础主域，就实现了同域。
1.）父窗口：(www.domain.com/a.html)
<iframe id="iframe" src="http://child.domain.com/b.html"></iframe>
<script>
    document.domain = 'domain.com';
    var user = 'admin';
</script>
2.）子窗口：(child.domain.com/b.html)
<script>
    document.domain = 'domain.com';
    // 获取父窗口中变量
    alert('get js data from parent ---> ' + window.parent.user);
</script>

5.window.name + iframe跨域

6.location.hash + iframe

7.websocket
<div>
    user input：<input type="text">
</div>
<script src="./socket.io.js"></script>
<script>
var socket = io('http://www.domain2.com:8080');

// 连接成功处理
socket.on('connect', function() {
    // 监听服务端消息
    socket.on('message', function(msg) {
        console.log('data from server: ---> ' + msg); 
    });

    // 监听服务端关闭
    socket.on('disconnect', function() { 
        console.log('Server socket has closed.'); 
    });
});

document.getElementsByTagName('input')[0].onblur = function() {
    socket.send(this.value);
};
</script>
socket.io.js
上面代码使用的是Socket.io,它很好的封装了websocket接口，提供了更简单灵活的接口，也对不支持websocket的浏览器提供了向下支持
------------------------------------------------------------------------------------------------------------------
hbuilder混合开发
安装91手机助手 运行-手机运行-在设备上运行（真机调试）
语法
document.addEventListener('plusready',function(){
    //console.log('所以plus api都应该在此事件发生后调用，否则会出现plus is undefined');
})
------------------------------------------------------------------------------------------------------------------
js自定义事件  http://www.cnblogs.com/jiangxiaobo/p/6510274.html 
自定义事件到激发这个事件，需要document.createEvent()，event.initEvent()，element.dispatchEvent()这三部，分别是创建事件对象，初始化事件对象，触发事件
<div id="testBox"></div> 
// 1. 创建事件
var evt = document.createEvent('HTMLEvents'); 
// 2. 定义事件类型，事件初始化
evt.initEvent('customEvent', true, true); 
// 3. 在元素上监听事件，绑定监听
var obj = document.getElementById('testBox');
obj.addEventListener('customEvent', function(){
console.log('customEvent 事件触发了'+event.type);
}, false);
console 中输入 obj.dispatchEvent(evt)，可以看到 console 中输出“customEvent 事件触发了”，表示自定义事件成功触发
//自定义如click一样的原生事件
张旭鑫自定义事件 http://www.zhangxinxu.com/wordpress/2012/04/js-dom%E8%87%AA%E5%AE%9A%E4%B9%89%E4%BA%8B%E4%BB%B6/ 
--------------------------------------------------------------------
主页面与iframe子页面互相获取对象。
iframe获取主页面对象：1.利用window.parent或window.top获取父页面和顶层页面的window对象，然后js则.document.getElementsBy系列获取主页面dom，jq则直接.$("xxx")获取主页面dom，因为jq的类和实例是直接赋给window的。
----------------------------
主页面获取iframe对象：（推荐1和3方法）1.获取到主页面iframe对象，利用js方法contentWindow获取iframe文档中的window对象，再.document.getElements系列和.$("xxx")，用js和jq获取iframe里的节点。
----------------------------
2.在主页面获取frames，获取主页面引用iframe的数组集合。通过索引如frames[0]得到想要的iframe的window对象，然后js或jq获取iframe节点。
----------------------------
3.在主页面获取frames，获取主页面引用iframe的数组集合。通过iframe的name属性如frames["aa"]得到想要的iframe的window对象，然后js或jq获取iframe节点。
----------------------------
4.获取到主页面iframe对象，利用jq方法.contents()获取对象中的子节点，文本节点和html元素，得到一个document对象，再.find()去找想要的节点。但是此方法我试验不成功，似乎是iframe未加载完，效果不好，不如js方法。
试下
$('#frameID').load(function () {
    $('#frameID').contents().find('a');//以iframe中找元素a为例
});
5.利用$(html, [ownerDocument]) 的第二个参数
$("#child",window.frames["iframeChild"].document)
文档对ownerDocument的解释是：“创建DOM元素所在的文档”
//当然获取iframe子页面对象时，前提是同源引用。如果是iframe跨域引用，则别说修改，连获取该iframe子页面对象也是获取不到的。
--------------------------------------------------------------------
css里的路径是相对于css的，js里的路径是相对于引用的html文件的（保持疑问）
必要的话，可以用./根路径统一
--------------------------------------------------------------------
js清空数组的三种方式:
1.array.splice(0,array.length);
2.array.length=0;
3.array=[]。
第二种简直是黑科技，不过第三种方式效率更高。
--------------------------------------------------------------------
eval()妙用
数组求和黑科技：var a=[1,3,5,9];var sum=eval(a.join('+'));
--------------------------------------------------------------------
js url转码
encodeURI/decodeURI： 
以UTF-8编码编码字符串，对这些字符：“ ; , / ? : @ & = + $ ”不做编码。
encodeURIComponent/decodeURIComponent： 
以UTF-8编码编码所有字符串。 
--------------------------------------------------------------------
手机和电脑页面上的定时器开启以后，页面进入后台，定时器也是在继续执行着的。
--------------------------------------------------------------------
setInterval和setTimeout方法返回的是个number类型的id，用以放入清空函数中。
--------------------------------------------------------------------
window.top.document.compatMode 可显示浏览器的渲染模式
--------------------------------------------------------------------
标准和ie的兼容写法
var e = e || window.event
获取scrollTop或offsetTop值时
document.documentElement||document.body
window.getComputedStyle(xxx, null) || xxx.currentStyle
var target = e.target || e.srcElement
event.stopPropagation(); || event.cancelBubble = true
--------------------------------------------------------------------
前端开发的优化问题
用innerHTML代替DOM操作，减少DOM操作次数，优化javascript性能
--------------------------------------------------------------------
callee代表函数本身的引用 js中函数自身的递归使用
(function(num){
if(num <= 1) return 1;
return num*arguments.callee(num-1);
})(5)
--------------------------------------------------------------------
setTimeout(Function,0);的延迟性
for(var i=1;i<=3;i++){
  setTimeout(function(){
      console.log(i);    
  },0);  
};
返回3次4
--------------------------------------------------------------------
var fun = function(){

}
fun.prototype = {
    info : {
        name : 'peter',
        age : 25
    }
};
var a = new fun();
var b = new fun();
a.info.name = 'jack';
b.info.name = 'tom';
a.info.name b.info.name都为'tom'
因为之前没有this，所以原型的指针都是一个，即是最后一个赋的值'tom'。
--------------------------------------------------------------------
实例对象与函数调用
function A(name){
    this.name = name
}
var a = A;
var b = A();
var c = new A;
var d = new A('name1');
//a代表A构造函数。b代表A构造函数的调用，返回值。c代表A构造函数的实例对象，不传参。d代表A构造函数的实例对象，并传参。
prototype只有构造函数可以调用，实例没有这个属性，实例有__proto__
A.prototype有 c.prototype没有
prototype可以向构造函数上追加方法，不能改变原构造函数的方法
原构造函数方法又叫函数内方法，适合放之后不会改变的方法
以后可能会改变的方法，适合用prototype属性追加
只有当函数内方法找不到时才会去原型链上查找，函数内方法优先于原型链方法。
题目：
function obj(name){
    if(name){this.name=name};//如果不加这个判断，后面原型追加方法是改不了函数内方法的
    return this 
}
obj.prototype.name = "name2";//原型扩展
var a = obj("name1");//函数调用传值
var b = new obj();//实例化
//a.name = “name1” b.name = “name2”
--------------------------------------------------------------------
window.location.hash修改hash，路径后面的#，不刷新页面
--------------------------------------------------------------------
es6 数据交互
fetch
let fetchUrl = 'http://192.168.0.100:81/api/Pay/payQuery';
let fetchInit = {
    method: 'post',
    //请求头
    headers: {
        'Authorization': `BasicAuth ${JSON.parse(localStorage.getItem('UserInfo')).openid}&${localStorage.getItem('token')}`,
        'Content-Type': 'application/json; charset=utf-8'
    },
    //传后台的参数 obj转string
    body: JSON.stringify(
        {merchantOutOrderNo:merchantOutOrderNo,payType:localStorage.getItem('payType')}
    ),
};
//两个参数 url和init 
fetch(fetchUrl,fetchInit)
//string转obj
.then(res=>res.json())
.then(
//成功时
res=>{
    console.log(res);
},
//拒绝时
res=>{
    console.log(res.desc);
})
.catch(err =>{
    console.error(err);
});
fetch的两个参数 https://developer.mozilla.org/zh-CN/docs/Web/API/WindowOrWorkerGlobalScope/fetch 
fetch的使用方法实例 https://developer.mozilla.org/zh-CN/docs/Web/API/Fetch_API/Using_Fetch 
https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch 
--------------------------------------------------------------------
原生ajax封装
owner.ajax = function(method, uri, options, callback) {
    var xmlhttp;
    if(window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            return callback(xmlhttp.responseText);
        }
    }
    xmlhttp.open(method, uri, true);
    xmlhttp.send(options);
};
--------------------------------------------------------------------
js阻止事件冒泡 兼容写法
var e=e||window.event;
//标准
e.stopPropagation();
//ie 
e.cancelBubble = true;
-------------------------------------------------------------------- 
返回文档中匹配指定 CSS 选择器的一个元素
document.querySelector('img');
返回文档中匹配指定 CSS 选择器的所有的元素
document.querySelectorAll('img');
--------------------------------------------------------------------
js获取图片原始尺寸
法1
var image = new Image();
image.src = img.src;
var naturalWidth = image.width ;
法2
var img = $("img")[0]; // Get my img elem
var naturalWidth = 0;
$("<img/>") // 创建一个新img标签 Make in memory copy of image to avoid css issues
    .attr("src", $(img).attr("src"))
    .load(function() {
        naturalWidth = this.width;   // Note: $(this).width() will not work
    });
法3 h5接口
img.naturalWidth和img.naturalHeight
--------------------------------------------------------------------
写插件时需要操作class时，都用jq的.attr('class','a b')方法。不用addClass('a')和removeClass('b')，因为不便于class的恢复与修改。
-------------------------------------------------------------------- 
阻止事件冒泡之后，恢复事件冒泡的办法
法1
把阻止冒泡的事件解绑，重新绑定个不阻止冒泡的事件
法2
立一个flag
if(flag){
    //阻止冒泡
}
else{
    //不阻止冒泡
}
-------------------------------------------------------------------- 
let largedFlag = false;
$(instance.img).attr('class','zip plus');
//已放大
//*****要同时对具有包含关系的两个dom节点进行操作时
//*****可以把事件绑定到它们的父节点 比如window
//*****对window绑定click事件 再对window里的document和instance.img分别再绑定click事件
$(window).off('click').click(function(){
    //根据largedFlag判断要给谁绑定事件
    if(largedFlag){
        //*****给document绑定缩小事件
        $(document).off('click').click(function(){
            //左右及关闭控件显示
            $(instance.LRC).show();
            //替换class
            $(instance.img).attr('class','zip plus');
            $(instance.pop).attr('class','picPop');
            //*****每次绑定完即清空document事件 清空事件未阻止冒泡还是会进行冒泡到window
            //保证每次无论点击document还是instance.img，都能触发window进行largedFlag变量替换
            //*****这边去掉document上的事件，避免点击instance.img时触发document上的事件，所以document这边必须解绑事件。
            $(document).off('click');
            largedFlag = false;
        })
    }
    //刚进去 未放大
    else{
        //*****给instance.img绑定放大事件
        $(instance.img).off('click').click(function(e){
            //左右及关闭控件隐藏
            $(instance.LRC).hide();
            //替换class
            $(instance.img).attr('class',mode+' reduce');
            $(instance.pop).attr('class','picPop reduce');
            //*****每次绑定完即清空instance.img事件 清空事件未阻止冒泡还是会进行冒泡到window
            //此处清空instance.img事件可省略，因为instance.img事件已经是最底层，上面document已解绑，所以无影响。
            //*****无论是否解绑未阻止冒泡还是会进行冒泡到window
            $(instance.img).off('click');
            largedFlag = true;
        })
    }
})
//*****从属关系 $(window)子级$(document)   和  $('html')子级$('body')
-------------------------------------------------------------------- 
jq的第二个参数
1.jQuery(selector, [context])
这种用法，相当于 $(context).find(selector) 或者 context.find(selector)
2.jQuery(html, [ownerDocument])
文档对ownerDocument的解释是：“创建DOM元素所在的文档”
也就是说，如果你要编写挎document的脚本，比如iframe或者用window.open开一个新窗口，可能会用得着它
3.jQuery(html, props)
这个应该比较常用了，直接贴代码：
$("<input>", { 
    type: "text",
    val: "Test", 
    focusin: function() {
        $(this).addClass("active"); 
    },
    focusout: function() { 
        $(this).removeClass("active");
    } 
}).appendTo("form")
-------------------------------------------------------------------- 
Document
Document 对象使我们可以从脚本中对 HTML 页面中的所有元素进行访问
Document 对象是 Window 对象的一部分，可通过 window.document 属性对其进行访问
-------------------------------------------------------------------- 
iframe
进程相对独立，css跟js都不会影响到外面的元素，iframe的也影响不了外面
不用触发事件冒泡到外层
-------------------------------------------------------------------- 
所有页面上的function函数其实都是挂载到window对象的全局变量
子页面iframe可以调用外层的方法，比如top.topMethod()，可以直接传值进top层的方法。
-------------------------------------------------------------------- 
在iframe里面
$(window)获取的是iframe的window对象
$(top)获取的是top的window对象
$(document)和top.$(document)获取到的都是iframe的document对象
$(top.document)才能获取到top的document对象
$('html')获取的是iframe的html节点
top.$('html')获取的是top的html节点
$('body')获取的是iframe的body节点
top.$('body')获取的是top的body节点
就top.$(document)获取有点问题
-------------------------------------------------------------------- 
写在iframe里的方法和写在top的方法是互相分开的
当鼠标点击iframe里的节点时，当前环境是iframe，此时触发不了绑定在top层的事件
当鼠标点击top层节点的时候，当前环境是top层，此时触发不了绑定在iframe层的事件
如：绑定在$(top.document).keydown()上的键盘事件，我当前点击iframe节点，当前环境还在iframe，是触发不了绑定在$(top.document)上的keydown事件的
-------------------------------------------------------------------- 
自执行匿名闭包函数
(function(){
    function aaa(){};
    var bbb = function aaa(){};
    ccc = {};
    ddd = function(){};
})();
外部是访问不到里面的aaa方法的，除非return返回出去指定内容。起到了一个私有变量的作用。
aaa bbb都是作为内部函数，外部不能访问，外部因为作用域问题无法引用。
但是匿名函数里
ccc和ddd都是能在外部直接访问的，作为属性直接绑定到window上的。
应该是一种简写this.ccc={};this.ddd=function(){}; this指代当前window，直接作为window属性绑定到window上。
所以外部可以访问，匿名闭包函数里的属性。
--------------------------------
匿名闭包函数
(function(){
    ccc = {};
    ddd = function(){};
});
ccc和ddd外部就访问不到
--------------------------------
jq的$(function(){

});
$(function(){
    function aaa(){};
    var bbb = function aaa(){};
    ccc = {};
    ddd = function(){};
})
和自执行匿名闭包函数一样
aaa bbb访问不了，而ccc ddd能够访问。
-------------------------------------------------------------------- 
事件源的兼容写法
标准浏览器用e.target，IE浏览器用e.srcElement
-------------------------------------------------------------------- 
事件委托原理
利用事件冒泡原理
绑定事件到父级，点击子级，冒泡到父级触发事件，判断事件源的e.target.id或者e.target.className，来触发事件，实现委托。
-------------------------------------------------------------------- 
parentNode排序
document=>html=>body=>xxx
-------------------------------------------------------------------- 
iframe和父窗口是完全阻隔的，不触发事件冒泡，相互独立的，iframe的document已经是顶级，不存在parentNode到父级了
-------------------------------------------------------------------- 
前端路由机制
方法一：
利用url的hash,就是常用的锚点（#）操作，类似页面中点击某小图标，返回页面顶部，JS通过hashChange事件来监听url的改变，IE7及以下需要轮询进行实现。一般常用框架的路由机制都是用的这种方法，例如Angualrjs自带的ngRoute和二次开发模块ui-router，react的react-route,vue-route…
方法二：
利用HTML5的History模式，使url看起来类似普通网站，以”/”分割，没有”#”，但页面并没有跳转，不过使用这种模式需要服务器端的支持，服务器在接收到所有的请求后，都指向同一个html文件，通过historyAPI，监听popState事件，用pushState和replaceState来实现。
-------------------------------------------------------------------- 
js 获取焦点方法
jsDom.focus();
失去焦点方法
jsDom.blur();
---------------------------------
从iframe刚到top，焦点还在iframe，触发不了top绑定的事件，所以要让top获得焦点
top.focus();就行了
-------------------------------------------------------------------- 
迷之bug
在iframe的js的事件中获取top.$('.xxx')的时候，第一次执行正常，第二次执行事件中的top就会去缓存中找，然后会找不到，top为undefined，所以要把top的dom节点放到事件外面，避免其读缓存的top，还读不到。
-------------------------------------------------------------------- 
instanceof 运算符用来测试一个对象在其原型链中是否存在一个构造函数的 prototype 属性
instanceof 运算符用来检测 constructor.prototype 是否存在于参数 object 的原型链
xxx instanceof Array为true
xxx一定是数组
xxx instanceof Object为true
法一：
xxx可能是对象也可能是数组
数组有length属性，对象没有
法二：
toString方法
console.log(arr.toString()); //'2,3,4'
console.log(obj.toString()); //[object Object]
法三：
constructor属性
console.log(arr.constructor==Array); //true 
console.log(arr.constructor==Object); //false 
console.log(obj.constructor==Array); //false 
console.log(obj.constructor==Object); //true
法四：
es5的isArray
-------------------------------------------------------------------- 
构造函数就是创造对象的
创造出的对象有自己的属性和公共的方法
匿名闭包函数里的公共变量，只要没有挂载到实例上，
对于通过多个实例化的对象来说，就是同一个变量，引用的是一个指针。
只有把需要的公共变量挂载到实例，它就会变成这个对象的属性，各自独立。
如：
<div class='a'>aaa</div>
<div class='b'>bbb</div>
var a = (function(){
    let i=0;//需要的公共变量
    function A(){};//构造函数
    var _way0 = function(ins){//私有方法0
        ins.d.click(function(){
            i++;
            console.log(i);
        });
    };
    A.prototype.init=function(config){
        this.d = config.dom;
        _way0(this);
    };
    return A;
})(); 
var ins0 = new a();
ins0.init({dom:$('.a')});
var ins1 = new a();
ins1.init({dom:$('.b')});
这里两个实例ins0和ins1用的匿名函数体内的i变量其实是一个变量，互相影响。
//解决方法
把需要跨私有方法，又要独立于各个实例的i变量，挂载到实例属性上，在init方法里加属性this.i = 0;
这样i作为实例自己的属性，实例都有它自己的i变量了。
----------------------------------
这里实例化的优势就体现出来了。
如果用普通函数封装的方法，每次调用都是执行了一遍函数本身，里面的变量每次操作都是同一个，重复调用会相互影响。
而用构造函数，每次调用其实都是生成一个新的对象，对象有它自己的属性，重复调用互不影响。
-------------------------------------------------------------------- 
iframe和window上定义的函数挂载在各自的window对象上，如window和top上，互不干扰
-------------------------------------------------------------------- 
jq与三大框架的思路差别
jq，对dom本身进行操作，来改变dom。
三大框架，用js去渲染dom的存在消失。
-------------------------------------------------------------------- 
在同一dom上进行不同的实例绑定，后面的实例会覆盖掉前一个实例绑定。方法是通过事件入口，每次经过入口事件，传入当前的实例给那个公共dom。进行同一个dom不同实例间的操作切换。
------------------------------
要么在实例里生成不同的dom，分开绑定各自实例操作。
要么通过事件入口，每次经过入口事件，传入当前的实例给那个公共dom。进行同一个dom不同实例间的操作切换。
-------------------------------------------------------------------- 
手机拨打电话<a href="tel:
手机发送短信<a href="sms:
<a href="tel:13666666666">13666666666</a>
<a href="sms:13666666666">13666666666</a>
-------------------------------------------------------------------- 
单独的或者公共的都可以写在实例里，通过判断进行合适操作。
-------------------------------------------------------------------- 
最外层函数里的this指向window。父函数调的子函数中的this，指向父函数。
原型方法里的this都指向实例。
构造函数.prototype指向原型链，也就是通过构造函数.prototype添加的方法。
闭包函数内的this指向window。
类和原型方法里的this可以互相获取
var A = function(){
    this.a=1;
    console.log(this.b);//可以获取原型里的b
};
A.prototype = {
    b:2,
    c:function(){
        console.log(this.a);//可以获取类里的this.a
        this.c = 3;//还可以在当前实例添加属性，但是只影响当前实例，添加不了类属性
    }
}
-------------------------------------------------------------------- 
(function(){})();和(function(){}());效果一样
(function(){})(); 是把函数当作表达式解析，然后执行解析后的函数，比较常见，它是先声明匿名函数，再执行
相当于 var a = function(){}; a(); a得到的是函数
(function(){}()); 是把函数表达式和执行当作语句直接执行，先强制执行表达式。（在js中，圆括号运算符与[]、.运算符具有最高的优先级）
相当于 var a = function(){}(); a得到的是结果
-------------------------------------------------------------------- 
暴露自执行匿名函数里的构造函数的方法
法1：
var Test = (function(){
    //构造函数
    var TestFun = function(){
    
    };
    TestFun.prototype = {
        a:function(){

        },
        b:function(){

        },
    };
    return TestFun;
})();
法2：
(function(){
    //构造函数
    var TestFun = function(){

    };
    TestFun.prototype = {
        a:function(){

        },
        b:function(){

        },
    };
    window.TestFun = TestFun;
})();
法1，法2是一样的。都是在window上挂载全局变量。法1挂载Test，得到TestFun。法2直接挂载TestFun。
我法1用于项目中或者暴露组件库中的内层构造函数。法2用于暴露组件库的最外层构造函数。
-------------------------------------------------------------------- 
arguments内置对象
js把传入函数的全部参数存储在内置对象arguments里
如：
function showargs() {
    console.log( arguments );
}
showargs(1,2,3,4,5); 
显示伪数组
0:1
1:2
2:3
3:4
4:5
callee:ƒ showargs()//当前代码的引用，可以调用自己，形成递归
length:5
Symbol(Symbol.iterator):ƒ values()
__proto__:Object
不用在函数中设置形参，可以直接调用arguments对象获得传参
arguments可以实现函数重载
--------------------------------------------------------------------  
关于类
函数内方法和原型方法
定义在构造函数内部的方法,会在它的每一个实例上都克隆这个方法 / 定义在构造函数的 prototype 属性上的方法会让它的所有示例都共享这个方法,但是不会在每个实例的内部重新定义这个方法 .如果我们的应用需要创建很多新的对象,并且这些对象还有许多的方法,为了节省内存,我们建议把这些方法都定义在构造函数的 prototype 属性上（当然,在某些情况下,我们需要将某些方法定义在构造函数中,这种情况一般是因为我们需要访问构造函数内部的私有变量）。
---------------------------------
不变的我们写在原型里，会变的、要传参的写在函数内方法里。
--------------------------------------------------------------------  
类的继承
父类 人
var Person = function(){

};
子类 工人
var Worker = function(){

};
就算Worker是Person原型上的方法，Worker也不能使用Person类的方法。因为它们都是构造函数Function创造的，只能通过原型链__proto__.constructor.prototype继承Function的原型方法。
如果Worker要使用Person的方法，只能通过call，apply，bind继承人工定义的父类Person。
插件中为了方便实例化，可以把父类的原型直接赋到Init的类上，以避免构造函数自调用的死循环。如：
var A = function(){
    return new A();//避免死循环
}
写成
var A = function(){
    return new A.prototype.Init();//避免死循环
}
A.prototype = {
    Init:function(){return this;}
}
A.prototype.Init.prototype = A.prototype;
此为特例。
--------------------------------------------------------------------  
//类
var A = function(){
}
A.prototype = {
    init:function(){console.log(this);}
} 
//调用
new A().init();//这里的this就是A的实例 因为是new A();这个实例调用的init() //在谷歌中的返回值是 A{__proto__:{init:f(){}}}
A.prototype.init();//这里的this就是A的原型 因为是A.prototype调用的init() //在谷歌中的返回值是 {init:f(){}}
--------------------------------------------------------------------  
面向对象编程 三基本特征：继承、多态、封装。
继承可以使得子类具有父类的属性和方法或者重新定义、追加属性和方法等。 
--------------------------------------------------------------------  
关于面向对象的js的类的继承
一、类继承 在子类型构造函数的内部call，apply调用父类型构造函数 【继承父类的函数内方法】
通过Function.prototype.call();Function.prototype.apply()方法 继承父类的函数内方法
用法：call:ParentClass.call(subClassIns, arg1, arg2, ...)
apply:ParentClass.apply(subClassIns, [argsArray])
子类的实例对象可以通过父类的call，apply方法继承父类的函数内方法
如：
function Product(name, price) {
    this.name = name;
    this.price = price;
}
function Food(name, price) {
    Product.call(this, name, price);//继承父类的name和price属性【核心】//单继承类属性
    A.call(this); 
    B.call(this); //多继承类属性
    this.category = 'food';
}
二、寄生原型继承 object.prototype原型法继承 【继承父类实例】【需要修正constructor指向】
如：
function Product(name, price) {

}
Product.prototype = {
    name : name,
    price : price
}
function Food(name, price) {
    this.category = 'food';
}
//错误：Food.prototype = Product.prototype;//确实只继承了父类原型，但是修改子类原型，会同时作用于父类原型，因为是同一个指针。
//es5
寄生原型继承【核心】
var C = function(){}//创建个没有类属性的类
C.prototype = Product.prototype;//C类只有Product类的原型
Food.prototype = new C();//Food子类原型指向C类实例（只有原型，因为类属性为空），这样就避免掉继承Product类属性，又不会影响父类原型。
//es6
{}和new Object();创建空对象，会继承Object类的原型
Object.create(null);创建空对象，不会继承Object类的原型，完全为空
Food.prototype = Object.create(Product.prototype);【核心】//创建只有父类原型的新对象，子类原型指针指向新对象，单继承原型属性
Object.assign(MyClass.prototype, OtherSuperClass.prototype);//多继承原型属性
Food.prototype.constructor = Food;//constructor指向修正【核心】
三、寄生组合继承（类继承+寄生原型继承）【完整】
一 + 二
--------------------------------
分割线 bind是创造一个新的函数，新函数有原函数的方法，但里面的this是我刚传入的
bind:ParentClass.bind(subClassIns, arg1[, arg2[, ...]]])
--------------------------------------------------------------------  
vue2.0的双向绑定原理与es6的Object.defineProperty();关系
Object.defineProperty();
-------------------------------------------------------------------- 
js模仿jq批量绑定事件
jq的事件都是批量绑定的，js事件只能单独绑定
如$('.a').click();//$('.a')都会绑定
var d = document.getElementsByClassName('a');
a.onclick = function(){};//不可行
js批量绑定事件
var a = function(c){
    var b = function(p,e){console.log(p);console.log(e);};//p参数为bind里的c参数，e参数为click的事件对象
    for(let i=0;i<d.length;i++){       
        d[i].addEventListener('click',b.bind(this,c));//此处this指此处click的事件对象，c为传参     
        //此处用bind不会立即执行。call和apply都会立即执行，不能用在addEventListener里
    }
};
a(9);
-------------------------------------------------------------------- 
js ajax拼接字符串时可以用正则加判断条件
如for循环中：
data[0].cellList[i].commandNum=="01"?equip.eq(i).addClass("sel"):equip.eq(i).removeClass("sel");
或：
'<i class="iconfont icon-hekricon01 equip'+(cell.commandNum=="01"?" sel":"")+'"></i>'
-------------------------------------------------------------------- 
ng1使用双向绑定
vue是单向绑定，就是js能影响html，html不能影响js，除v-model是双向
vue在不同组件间强制使用单向数据流，单向传递，props或emit

js查看代码执行时间
一、console.time(label) 和 console.timeEnd(label)
二、console.profile(label) 和 console.profileEnd(label) 是 time 的升级版
不但测速，直接测性能了，需要到 profile 面板里面才能看到结果
三、performance.now()
performance.now()更加专业，专门测试执行时间，直接
let t0 = performance.now();
//执行代码
console.log(performance.now()- t0);

some() //返回布尔
循环检测数组中的元素是否 有 满足指定条件（函数提供）
[...].some((item)=>{return xxx});

every() //返回布尔
循环检测数组中的元素是否 都 满足指定条件（函数提供）
[...].every((item)=>{return xxx});

js对象键值不能有-号
a.b-c//错
a['b-c']//对

用||和&&读值，赋值 =优先级比||和&&高，所以要加括号
用||判断是否有一个满足条件
从左往右执行
0||1||2 //1
3||1||2 //3
0||''||null //null
0||(a=1) //a=1

用&&判断是否都满足条件
从左往右执行
都为true，返回最右侧值
1&&2&&3 //3
执行中如有一项为false，中断执行，返回那一项值
1&&0&&'' //0
1&&''&&0 //''
a.b&&(a.b.c=1) //a.b.c=1

读取对象内部的某个属性 如message.body.user.firstName
安全写法
const firstName = (message
  && message.body
  && message.body.user
  && message.body.user.firstName) || 'default';

新的提案 ?.
链判断运算符
简化写法
const firstName = message?.body?.user?.firstName || 'default';

func.apply(obj,argv)
a.push.apply(a,[4,5,6]);
等同于：
a.push(4,5,6);

c.push.apply(a,[4,5,6]);也是一样
a调[c.push]这个方法，传入参数[4,5,6]

请求语义化 POST新增 GET查询 PUT更新 DELETE删除

new Array(3);生产一个空的三位数组

fill()
array.fill(value, start, end)
从开始到结束位置填充固定值
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.fill("Runoob", 2, 4);
//Banana,Orange,Runoob,Runoob

这招根据数组长度，自动生成对应长度空数组
this.idx_list = new Array(formList.length).fill(0);

匿名函数async使用方法 //这样写即可
this.$refs.f.form_validate(async(res,msg)=>{
    await this.$http(this.$url.task_re,'PUT',forms); 
})

await是可以用在this前面的
async search(v){        
    this.name=v;    
    await this.getList({}});    
}

异步操作的回调数据在外面是获取不到的。
闭包作用，获取异步操作里的回调数据。

异步函数中的返回值作为参数传入闭包函数中。
外界闭包函数可以把这个值导出外部作用域。

get和delete 参数传递方式相同
post和put 参数传递方式相同

后端只能接收string，所以http请求可以传数组，对象，数字，字符串都行，但是都要JSON.stringify。一些库帮你做过处理了，内部已经JSON.stringify了

数字1 JSON.stringify是 "1"
字符串1 JSON.stringify是 ""1"" 不一样

es6 for of循环
for of可以循环数组，貌似不能循环对象
for of比forEach优势：可以使用break,continue,return
for of只能获取item，不能获取index
for of可以获取map类型的index
for(let i of check){
  if(this[i.v]==''||this[i.v]==0){
    n=i.name;
    console.log(n);
    break;
  };          
}

用for of循环代替forEach循环数组，比较好

document.querySelectorAll("");
和jq的$('')效果一样
document.querySelectorAll("#demo");

js添加class属性
dom.className += 'aaa';
dom.classList.add("aaa");

window事件貌似不能用箭头函数
因为箭头函数不指向window

操作改变数组
forEach
Array.forEach((value,index)=>{
    value=value+'aaa'
});
map 需要return 返回值
newArray = oldArray.map((value,index)=>{
    return value+'aaa'
});

计算机语言中判断时不能连续判断
如if(1<a<5)是不行的，得分开if(1<a&&a<5)

js删除对象中某个属性
delete object.xxx;

''==0 //为true
''===0 //为false