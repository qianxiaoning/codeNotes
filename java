java -version
javac Hello.java文件的文件名 将java 源文件编译为 class 字节码文件
java Hello 文件中的类名
-------------------------------
热身：
1.指定目录新建工程java project(day01)
2.在工程/src目录下新建包java package(com.baidu.hello)公司域名倒写
3.在包下新建类java class(HelloWorld)
4.入口方法：
// 单行注释
/*  */ 多行注释
公共的  静态   空返回值
public static void main(String[] args){
	// 输出不换行
	System.out.print("bbbbbbbbb");
	// 输出换行
	System.out.println("helloworld!!!!!!");
	// system  系统指令  out 输出动作 
	// println(); 输出方法
}
5.生成动态web工程Dynamic web project(day01v1.1)
6.在webContent目录下放前端资源
7.导入jar（qr.jar）包，放入webContent/web-inf-lib下 
d盘目录 "d:\\qr.png"
CreateQR.create(width, height, content, path);

<link rel="stylesheet" href="order.css"/>

/返回根目录

字符和字节的关系：
不同编码方式的字符的字节大小是不同的：
ASCII和GBK：
英文1字节
汉字2字节

utf-8：
英文1字节
汉字3字节

unicode：
英文2字节
汉字2字节

servlet:
1.接收请求，实现页面跳转
2.准备数据
jsp:

jdbc:
用一段java代码操作数据库
1.注册数据库驱动
2.获取数据库连接
3.获取传输器
4.执行sql
5.遍历结果集
6.关闭资源（释放资源）

方法三要素：
修饰符，返回值，参数

定义变量：
变量类型 变量名 = 变量的值;

在eclipse添加apache tomcat服务器
window-preferences-server-runtime environments-add

src-servlet
day04右键偏好-targeted runtimes-打钩-apply,ok

pojo 实体类
简单的java对象

jsp变量
${xx.xxx}

java se标准版 普通桌面、商务应用
java me小型版 移动，嵌入设备
java ee企业版 针对web应用程序开发

跨平台，原理：会先安装一个java虚拟机，jvm负责java程序的运行

jdk是java开发工具包，是java核心
java开发工具 jdk\bin
基础开发库 jdk\jre\lib\rt.jar
基础开发库的源码 jdk\src.zip

下载从oracle官网

bin 可执行文件
jre java运行环境
lib 第三方jar包

注释
// 单行
/*多行注释*/
/**文档注释*/ 写在类和方法的定义处，可以用于自动创建文档

1.编译过程，ide保存时会调用jdk目录下/bin/javac.exe生成xxx.class文件
2.启动java虚拟机
3.虚拟机加载xxx.class字节码文件
4.进入这个类的main方法执行

jdk（开发工具包）> jre(运行类库)>jvm（java虚拟机）

System.out.println(); 输出并换行
System.out.print(); 输出不换行

main方法只有args参数能变

刷题：牛客网？

java核心编程思想（白黄面）

标识符：包名，类名，方法名
关键字：53关键字，其中2个保留字：const,goto。不能用作标识符
-------------------------------
数据类型：
位Bit 字节byte 1byte=8Bit
基本类型 又叫原生类、内置类型（8种）引用类型（很多）
整数型：	字节空间			取值范围
byte        1               -2^7 2^7-1 = -128 127
short       2               -2^15 2^15-1
int         4               -2^31 2^31-1
long        8               -2^63 2^63-1

浮点型：
float       4               单精度，小数部分精度要求不高
double      8               双精度，小数部分精度高并操作值大

字符：
char        2               0 65535(ASCII码，没有输出?)

布尔：
boolean     1               true/false

引用类似：
类，接口，数组，...

基本类型存值，引用类型存地址值

基本类型的字面规律:
1.整数（byte,short,int,long）字面值是int类型
2.byte，short，char三种比int小的整数可以用范围内的值直接赋值
3.浮点数（float,double）的字面值是double类型
4.字面值后缀l f d
如：
long a = 9999999999l;
float a1 = 3.14f;
double a2 = 3d;
5.进制前缀
0b   -2进制
0    -8进制
0x   -16进制
\u   -char类型，16进制

隐式转换
按字节 由小转大 直接转
如：
byte a = 120;
int b = a; // 直接转
long => float 特殊（由大转小）

显示转换
按字节 从大转小
如：
int b1 = 265;
byte b2 = (byte)b1; // 强制转换
int b3 = 456;
byte b4 = (byte)(b1+b3);
注意：小数转成整数，小数直接舍弃

运算规则：
1.计算结果的数据类型，与字节最大类型一致
3/2 为1
3d/2 声明浮点数
2.整型字面义为int
byte d1 = 3;
byte d2 = 3;
byte d3 = d1+d2; // 报错
int d3 = d1+d2;
3.整数运算溢出
计算：光速运行一年的长度是多少米
System.out.println(300000000*60*60*24*365); // 溢出转回到最小开始
System.out.println(300000000l*60*60*24*365); // 正确
4.浮点数运算不精确
如：
System.out.println(1-0.8);
System.out.println(4.35*100);
5.浮点数的特殊值
System.out.println(3.14/0); // Infinity
System.out.println(3.14/0.0); // Infinity
System.out.println(3/0); // 报错
System.out.println(0/0.0); // NaN
-------------------------------
运算符：
1.算数运算符
+ - * / % ++ --
2.比较运算符
== !=
3.逻辑运算符
&&逻辑与+短路与（短路与：前为true，后才执行）
&逻辑与 同true为true
||逻辑或+短路或（短路或：前为false，后才执行）
|逻辑或 一true为true
+ 字符串连接
! 非
4.三元运算符
?:
5.赋值运算符
= 赋值运算
+= -= *= /= 复合的赋值运算    自动转型，不能强转

byte a=2;
byte b+=2;

a++和++a:
int a = 2;   
int b = a++; // b=a;a+=1;
int c = ++a; // a+=1;c=a;
// syso a=>4,b=>2,c=>4
-------------------------------
for循环的执行顺序
for(表达式1;表达式2;表达式3){
	表达式4;
}
1=>2=>4=>3 =>2=>4=>3 =>2=>3
-------------------------------
定义数组
1.动态：
int[] a = new int[4];
2.静态
int[] a = {1,2,3,4};
此外int a[] 这样写也行
二维数组：
1.动态：
int[][] a = new int[2][3];
2.静态
int[][] a = {{1,2,3},{4,5,6}};
二维数组赋值：
int[][] a = new int[2][2];
a[0] = new int[]{1,2};
a[0][1] = 2;

获取length长度
1.字符串
s.length()
2.数组
a.length

java数组必须存相同类型的数据
-------------------------------
一个java文件能有多个class类
但是只有一个类能是public，且此class为文件同名

1.对象和数组 存放于 堆中（都有地址值）
2.变量 存放于 栈中

栈：                                                                                             堆：
变量Person p                       对象new Person()
Person p = new Person();
p.name = "哈哈";
p.age = 20;

单一对象内存图：
1.在栈内存中开辟空间存放局部变量p1、p2，压入栈底（先进后出）。
2.在堆内存中开辟空间存放（一个或多个）Person对象。
3.初始化（一个或多个）Person对象的属性和方法，并把属性设为默认值。
4.给堆内存的（一个或多个）元素分配内存空间，产生唯一的地址值。
5.把对象的地址值分别交给引用类型变量p1、p2来保存。
6.根据p1、p2找到堆内存中的对象，并把指定属性的默认值改为需要的值。 

private关键字
是一个权限修饰符
用于修饰成员变量和成员函数/方法
被私有化的成员只能在本类中访问。

字符char得用单引号' '

int a = 2;
int b = a+++9; b=a(a=a+1)+9;
System.out.println(b); // 11
-------------------------------
oop面向对象编程

面向过程：
一步步实现
面向对象：
通过把面向过程抽象成类，方便我们调用类的方法就行
从执行者变成指挥者

面向对象的三大特性：
封装  数据封装成类 
继承  子承父属性和方法
多态  增强软件的灵活性和重用性

面向对象更符合人类的思维，面向过程则是机器的思想

匿名对象调用
new Bird().fly(); // 直接调用

final
1.修饰类
子类不能被继承
2.修饰方法
该方法不能被重写
3.修饰变量
表示常量，只能被赋值一次，赋值后值不再改变。
变量不会自动提升
final byte a=1,b=2;
byte c=a+b; // 正确

隐式类型转换规则是：
byte→short(char)→int→long→float→double

定义变量类型的时候要特别注意，强转和隐转
byte a=1,b=2; // 此句没错
byte c=a+b; // 此句就不行，c=1+2;是强转了，
得写成：
byte c=(byte)(a+b);

"=="两边的类型不匹配，无法比较
String a="a";  
int b=1;
if(x==y)  { } // 错

把类理解成模板或者图纸

对象是从类创建的具体实例，占独立堆内存空间

引用变量就像是实例对象的遥控器

构造方法 新建实例时，执行的一个特殊方法
java的类中，必须有构造方法
如果未定义构造方法，编译器会加默认的构造方法:
public class A{
	public A(){

	}
}
和类同名，没有返回类型
例子：
public class A{
	int a = 0;
	public A(int a){
		//此处this不能省
		this.a = a;	
	}
}
new A(30);//此30是给构造函数里的a传值的
构造方法作用：
1.new构造一个实例之后，立即执行的一个特殊方法
构造方法中的代码，可以任意编写，完成任意功能，执行任意运算

String a  "abcd";
实际是:
char[] a = {'a','b','c','d'};
String a = new String(a);

字符串常量池
第一次使用一个字符串的字面值，在"字符串常量池"中新建实例

String 为引用数据类型，引用类型数据成员的默认值为 null

再次使用相同字面值时，直接访问常量池中存在的实例，而不会创建

String foo = "blue";
String bar = foo; 
foo = "green"; 
System.out.println(bar);
// 输出结果为"blue" 
采用 String foo = "blue"定义方式定义的字符串放在字符串池中，通过 String bar = foo;他们指向了同一地址空间，就是同一个池子，当执行 foo = "green"; foo 指向新的地址空间，bar仍指向原来的地址空间"blue"

字符串每次加号会创建新实例，所以长了会效率低

断点：
a
b
c   ---------------断点

当调试时，代码执行完b，到c前停止

this代表本类对象的引用
super代表父类对象的引用

Java SE 7之前，switch中的变量类型只能是byte,short,char,int,没有long,enum枚举,string
java12后
switch简写 不用写break了，可以直接返回值
switch(xx){
	case x -> xx;
	case x -> {

	}
	default -> {

	}
}

给外层for循环命名，可以跳出外层循环
break outer;
continue outer;

//构造方法中调用另一个重载的构造方法
// 必须是首行
this(id,name,null);//没有传默认值
this(id,name,gender,0);//没有传默认值

java只能单继承，只能继承一个直接父类
不继承：
1.构造方法
2.private 私有成员（隐藏的）

extends继承
public class Student extends Person{

}
创子类实例时，先创建父类实例，也先执行父类的构造函数，默认执行父类的无参构造，也可以手动调有参构造super(xx,xx,xx);
找属性、方法时先找子类再找父类

重写时：
super.xxx()

this();和super();必须是首行

父类中方法只要发现不同就建立方法？

js和java一样，是值传递，字面值和地址值

java中 类中是成员变量，方法中是局部变量，区别：
1.成员变量各方法内都能用
2.局部变量只有本方法内能用

java中的参数传递 与 基本类型和引用类型的赋值：
1.参数传递可以看做实参对形参的赋值
2.基本类型，字面值直接复制，形参变和实参无关
3.引用类型，地址值传递，形参变，实参也变。除非形参指向了另一个地址值，那就和实参无关了。
4.在java中String引用类型比较特殊，形参变，相当于指向了另一个地址值（新建了一个String），所以也影响不了实参。
5.另外几种基本类型(boolean,byte→short(char)→int→long→float→double)的封装类，虽然是引用类型，但是估计内部创建的还是基本类型，字面值直接复制，形参变和实参无关
-------------------------------
api:
String api
equals 比较字符串内容
charAt(i) 访问指定位置的字符
length() 字符长度
indexOf(子串) 查找子串起始位置的下标值，找不到返回-1
indexOf(子串,start) 从指定位置向后找
lastIndexOf 从后向前找
trim() 去除两端的空白字符，新建一个
substring(start)/substring(start,end) 截取子串
String.valueOf() 转成字符串

StringBuilder(jdk1.5)
和String区别：可变的字符序列，有对内部字符修改的方法
常用于：代替字符串做高效的字符串连接运算
内部数组默认初始容量16
存满翻倍+2
append() 在内部数组中追加新的字符
例：
StringBuilder sb = new StringBuilder("xxx");
sb.append("xxxxx");
setCharAt(2,xx) 设置下标位置的值
delete(5,26) 删除下标区间
toString() 转成String对象

StringBuffer
旧版本的类，jdk1.0(1995年线程安全的java)

Integer int整数的包装类
把基本类型当做引用类型来使用
new Integer(6); // 新建实例
Integer.valueOf(6); // 直接访问6的缓存，超出范围就是新建
在Integer类中，有256个缓存的Integer实例 -128~127

Integer方法
byteValue() 取值并转型
shortValue() 取值并转型
intValue() 取值并转型
longValue() 取值并转型
floatValue() 取值并转型
doubleValue() 取值并转型

Integer.parseInt("255") 字符串解析成int类型
Integer.parseInt("11111",2) 字符串解析成int类型
Integer.parseInt("ff",16) 字符串解析成int类型

数字转 不同进制字符串
Integer.toBinaryString(255) 转成2进制字符串 "11111111"
Integer.toHexString(255) "ff"

自动装箱和自动拆箱（编译器转）
自动装箱
Integer a = 6;
自动拆箱 // 要当心null值，null.xxx空指针报错
int b = a;

正则表达式 regex
matches(正则) 是否匹配
split(正则) 用子串来拆分
replaceAll(正则) 替换所有

s.matches(regex)

BigDecimal 精确浮点数运算 不new
IEEE-754规范
BigDecimal a = BigDecimal.valueOf(6);
BigDecimal b = BigDecimal.valueOf(6);
方法：
add(BigDecimal bd) 加
subtract(BigDecimal bd) 减
multiply(BigDecimal bd) 乘
divide(BigDecimal bd) 除（不允许无理数）
divide(BigDecimal bd,位数,舍入方式) 除（重载） BigDecimal.常量
setScale(位数,舍入方式) 舍入运算

double ds = s.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

BigDecimal c = a.subtract(b);
c.doubleValue(); // 取值
c.toString(); // 取值

BigInteger 超大整数运算，超出long时

Date封装一个毫秒值，表示一个精确的时间点
getTime();
setTime(long t);
compareTo(Date d); // 当前实例和参数实例比较大小，大正小负同0

SimpleDateFormat 日期格式工具，可以把Date实例，格式化成字符串
也可以把字符串解析成Date实例

new SimpleDateFormat(格式)
格式：yyyy-MM-dd hh:mm:ss 12小时制
格式：yyyy-MM-dd HH:mm:ss 24
yy-M-d H:m
M月d日

方法：
format(Date实例)  // 得到日期字符串
parse(日期字符串)  // 得到Date实例

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date d = sdf.parse("1991-04-12");

Arrays.copyOf() 返回新数组
int[] arr1 = {1, 2, 3, 4, 5}; 
int[] arr2 = Arrays.copyOf(arr1, 5);
int[] arr3 = Arrays.copyOf(arr1, 10);
arr2// 1 2 3 4 5 
arr3// 1 2 3 4 5 0 0 0 0 0

System.arraycopy(Object src,int srcPos,Object dest,int destPos,int length);
//src源数组，srcPos要复制的起始位置，
//dest目的数组，目的数组放置的起始位置，length复制的长度
String src[] = new String[] {"1", "2", "3", "4"};
String dest[] = new String[]{null, null, null, null, null};
System.arraycopy(src, 0, dest, 0, 4);
// dest { "1", "2", "3", null }
System.arraycopy(src, 0, src, 1, 3);
// src { "1", "1", "2", "3" }

// 判断xx是否是Collection类
Collection.class.iSAssignableFrom(xx);
-------------------------------
八种基本类型对应的包装类
Byte Short Integer Long
Float Double 
Character
Boolean 
-------------------------------
java转义为 \
-------------------------------
多态：
多态的作用
一致的类型
所有子类型实例，都可以被当做一致的父类型来处理
cat可以当做pet类型来处理

1.向上转型
void f(Pet pet) // cat, dog,...都能传入了

Pet pet = null;
pet = new Cat();

判断运行期实例类型 instanceof 
shape instanceof Line
真实类型和父类型 得到true

2.向下转型 必须强转
Line l = (Line)shape;
l.length();

转的引用变量，内在实例不变

类型转换
1.向上转型
子类实例可以转型成父类型

2.向下转型
转成父类型的子类实例，再转回成子类型

java中，在同一个类里面，方法不能嵌套定义，但是可以相互调用
-------------------------------
抽象类
半成品类，一个没有完成的类

抽象方法
只有方法的定义，没有方法代码块
public abstract class A(){
	public abstract String aaa();
}

abstract关键字

在抽象类中才能定义抽象方法

作用：
1.简化代码，相比在父类中定义的通用方法
2.要求子类必须实现该方法
3.方便子类向上转型时可以调父类方法

抽象类不能实例化，只能给子类来继承
-------------------------------
final
1.常量 值锁定，不可变 
final int a = 6;
a = 7;// 错

final Student s = new Student("张三");
s.name = "李四";// 可变
s本身不可变

2.方法
不能被子类重写

3.类
不能被继承
如：System,String,Integer
-------------------------------
静态：
static 静态属于类，而不属于实例
非静态属于实例，要用实例调用
class Soldier{
	int id;
	int blood;
	static int soldierCounts;// 记录生成了多少个士兵了，属于类本身
}
Soldier.soldierCounts // 这样来调用

静态方法中不能直接调用非静态成员
解决办法：
1.都改成static
2.A a = new A();// 用实例调用
a.wayA();

jvm java虚拟机
1.方法区 保存加载的类（静态变量）
2.栈 局部变量
3.堆 创建的实例，包含实例的所有数据（成员变量）

什么使用静态：
使用原则：
1.能不用就不用，是非面向对象的语法
2.用在共享的数据上，如士兵的counts
3.放工具方法，如：Math.sqrt

静态初始化块
class A(){
	static{
		// 类加载时，只执行一次
	}
}
-------------------------------
常量
用static final两个关键字定义
final int A = 6;
static 内存中只有一份

命名习惯，全大写，单词间下划线连接
static final int MAX_VALUE = 100;

Object 所有类的顶层父类
Object的方法：
1.toString() // 获得实例的字符串表示 "类型@地址"
2.equals(Object obj) // 当前实例和参数实例obj比较内存地址是否相等

Object中默认是比较内存地址
this == obj
== 等号默认比较地址值，貌似

相比数据可以重写

访问控制符
控制一个类，或类中的成员的访问范围
				类		同包	子类	任意	  
public			1		1		1		1
protected		1		1		1
[default]		1		1
private			1

protected 同包可见，包外有继承关系的子类可见
default 同包可见

尽量使用小范围
public是与其他开发人员公开的，要尽量保持稳定不变
private更便于维护修改，不对其他代码造成影响
-------------------------------
类中 成员变量习惯定义成private

对象创建过程：
大体：
1.静态分内存
2.静态赋值和静态执行
// 第二次开始只
3.实例分内存
4.实例赋值和实例构造执行

详细：
加载类：
1.加载父类，为父类的静态变量分配内存
2.加载子类，为子类的静态变量分配内存
3.执行父类静态变量赋值，和静态代码块初始化（无先后顺序）
4.执行子类静态变量赋值，和静态代码块初始化（无先后顺序）
创建实例：
5.创建父类实例，为父类的实例变量分配内存
6.创建子类实例，为子类的实例变量分配内存
7.执行父类的实例变量的赋值运算，和父类的构造方法
8.执行子类的实例变量的赋值运算，和子类的构造方法
-------------------------------
集合（重点）:
用来存储一组数据的数据结构
数组缺点：
1.长度不可变
2.访问方式单一，只能用下标访问
3.在前面增删数据，操作繁琐

三个集合工具：
LinkedList// 先进先出，栈结构
ArrayList
HashMap

LinkedList 双向链表
两端效率高
方法：
add(数据)
在尾部添加数据
getFirst()
get(i)
访问指定位置的数据
removeFirst()
remove(i)
删除指定位置的数据，返回被删除的数据
remove(数据)
找到第一个相等的数据删除，返回true找到并删除，返回false没有找到
size()
数据的数量

iterator // 辅助创建迭代器实例的方法
it = list.iterator()
it.hasNext() // 还有没有下一项
it.next() // 下一项
remove()// 移出刚刚取出的数据，it.remove();

ArrayList
内部用数组存放数据，简化了数组的繁琐操作
1.内部数组默认的初始容量 10
2.放慢之后容量1.5倍增长

效率表现：
1.访问任意位置效率高
2.增删数据效率可能降低

创建实例：
new ArrayList() // 默认容量10
new ArrayList(1000) // 指定容量

list.size() 为0，没添加的话

方法：
1.与LinkedList相同
2.但没有两端操作数据的方法

ArrayList LinkedList
如果仅在两端操作数据，用LinkedList
数据量小时（100以内），频繁的增删数据用LinkList

ArrayList用途更广

HashMap 哈希表，散列表（重点）
存放键值对数据
9527    唐伯虎
9528    祝枝山

哈希表作用：快速查找数据

键：
不重复，无序

哈希运算过程（重点）
1.使用Entry[]存放数据
2.数组的默认初始容量是16
3.容量是翻倍增长
4.内部运算过程，由键来运算
5.key.hashCode()获得键的哈希值
6.用哈希值和数组长度来计算下标值i
7.把键值对封装成Entry实例，放入i位置
	空位置，直接放入
	有数据，依次用equals比较是否相等
		找到相等的，覆盖值
		没有相等的，链表连接在一起
	覆盖率，加载因子到0.75
		新建翻倍容量的新数组
		所有数据重新执行哈希运算，放入新数组
	jdk1.8后
		链表长度到8，转成一个红黑树结构
		数据减少到6，转回成链表

哈希运算过程（简约版）
1.使用Entry数组（默认长度16，容量翻倍增长）存放
2.key.hashCode取得键的哈希值和数组长度计算下标
3.将键值对封装为Entry实例放入位置
特性：
1.空直接放入，有数据equals等覆盖，有数据equals不等链表。
2.覆盖率到0.75，翻倍数组，重新哈希计算放入新数组
3.jdk1.8后，链表长度>8转成红黑树，减少到<6，转回链表

HashMap放值时，会对键进行hashCode和equals的比较：
1.HashMap调用put(key,value)方法放入键值对时，会调用当前key的hashCode和equals方法去比对，hashCode值决定位置，equals值决定覆盖与否。
2.不同key类型，默认的hashCode和equals方法可能会不一样（有的比较内容，有的比较地址值）。
3.当默认方法不满足需要时，需要改写hashCode和equals方法，使hashCode和equals方法比较键的内容而不是地址值，使得hashCode和equals都返回true，达到key内容相同即覆盖值的效果。

方法：
put(key,value);// 放入键值对数据，重复的键覆盖旧值
get(key);// 获取键对应的值，键不存在返回null值
remove(key);// 删除键值对数据，返回被删除的值
size();// 键值对的数量

hashCode()方法
object的方法，object中默认是用内存地址值作为哈希值
例子：
HashMap<Point, String> map = new HashMap<Point, String>();
map.put(new Point(1, 3), "3.1亿");
new Point(1, 3).hashCode()// 求hash值

String的hashCode不是比地址值，是比里面的值

集合的继承结构
Collection 接口
	List 接口
		ArrayList
		LinkedList
	Set接口
		HashSet
		TreeSet
Map接口
	HashMap
	TreeMap
iterator 接口
Collections工具类

Collections工具类：
addAll(集合,值1,值2,值3,值4,...);// 一次添加多个数据
sort(List); // 排序，基本类型快速，引用类型合并
binarySearch(List,目标值);// 二分法查找。如果找不到返回-(插入点+1)。缺点：必须有序。返回下标值
swap(List,i,j);// 交换位置
shuffle(List);// 随机打乱

Comparator比较器
Comparator<String> comp = new Comparator<String>() {
	/*
		* 比较o1和o2大小
		* o1大，返回正数
		* o1小，返回负数
		* 相同，返回0
		* */
	@Override
	public int compare(String o1, String o2) {
		int a = Integer.parseInt(o1);
		int b = Integer.parseInt(o2);
		return a-b;
	}
};
// 按数字顺序排序                // Comparator比较器
// 把比较器交给sort()方法使用，sort()方法内部会调用comp.compare()来比较数据大小
Collections.sort(list,comp);// 排序

new ArrayList().add()
ArrayList<Integer> list = new ArrayList<Integer>();
Collections.addAll(list, 5, 23, 76, 8, 4, 3, 43);
list.add(i,8);// 在这个位置插入数字8
-------------------------------
用父类/接口 接收子类实例
如：
List<?> list = new ArrayList<>();
Map<String, String> map = new HashMap<String, String>();
优点：
实现api的解耦，日后改变子类类型时只需改一行，以及尽量使用父类的方法，方便日后维护重构。
java提倡面向接口编程，不面向实现，利用多态实现对象的解耦
-------------------------------
接口 特殊的类:
是一个结构设计工具，用来解耦合，隔离实现
我的理解：
	接口和普通父类相比，同样是提取公共的功能。
	优化：
		1.写法更简化
		2.可以让子类多实现
语法：
1.interface代替class关键字
2.implements代替extends关键字
3.接口中只能定义：
	公开的常量
	公开的抽象方法
	公开的内部类，内部接口
4.接口没有构造方法
5.类可以同时实现多个接口
class A implements X,Y,Z{

}
class A extends B implements X,Y,Z{
	
}
x,y,z=>B=>A 多个父类
6.接口之间继承 用extends 因为都是接口没有实现，不用implements
interface A extends X,Y,Z{

}
jdk8后
7.可以放入default实现方法
8.可以放入static静态方法
		
例子：
机器人有个武器接口，接口能接刀，剑，枪

机器人类：
	变量：武器类
	方法：设置武器，进攻

武器类（是个接口）：
	常量：武器常量冷热核012
	抽象方法：武器进攻，获取武器名字，获取武器类型

AK47类（继承自武器类）：
	方法（子类实现抽象）：武器进攻，获取武器名字，获取武器类型

Sword类（继承自武器类）：
	方法（子类实现抽象）：武器进攻，获取武器名字，获取武器类型

Test1类：
	1.实例化机器人类
	2.实例设置武器类
	3.实例进攻
-------------------------------
for-each循环（获取不到下标）
数组遍历和集合迭代遍历的语法简化
1.数组：
for(int i=0;i<a.length;i++){
	String s = a[i];
	// todo
}
简化为：
for(String s:a){
	// todo
}

集合 的迭代器遍历
for(Iterator<String> it = list.iterator();it.hasNext();){
	String s = it.next();
	// tode
}
简化为：
for(String s:list){
	// tode
}
-------------------------------
异常 封装错误信息的对象：
错误信息：
1.类型 如NullPointerException
2.消息
3.行号
例子：
// 1.类型：java.lang.NumberFormatException
// 2.消息：: For input string: "qwqw"
// 3.行号：at day1403_异常.Test1.f(Test1.java:20)
Exception in thread "main" java.lang.NumberFormatException: For input string: "qwqw"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at day1403_异常.Test1.f(Test1.java:20)
	at day1403_异常.Test1.main(Test1.java:7)

Exception异常的继承结构
Throwable
	Error 系统级错误，没法修复
	Exception（异常） 可修复错误
		RuntimeException
			NullPointerException
			ArrayIndexOutOfBoundException
			ArithmeticException
			NumberFormatException
			ClassNotFoundException
		其它Exception

异常捕获 
作用：
1.资源清理

try{
	// 捕获A,B异常赋值到e
	return;// finally也会执行
}catch(AException e){

}catch(BException e){

}catch(父类型Exception e){

}finally{
	// 不管出不出错都执行
}

try{

}finally{
	// 资源清理
}

例子：
while(true) {
	try {
		f();
		break;
	}catch (ArrayIndexOutOfBoundsException e) {// ArrayIndexOutOfBounds
		System.out.println("输入两个，不是一个");
	}catch (ArithmeticException e) {// Arithmetic
		System.out.println("不能除0");
	}catch (Exception e) {// 父异常
		System.out.println("程序出错，请重新尝试");
	}finally {
		System.out.println("--------");
	}
}

e.printStackTrace();// 错误打印

异常处理方式：
1.catch捕获异常
2.throws添加管道 往前面方法继续抛出异常

方法有默认异常管道，RuntimeException和它的子类型

手动插管道
throws 在方法上设置异常的抛出管道

void f() throws AException,BException{

}

catch和throws
java语法的设计者，强制开发人员事先考虑如何处理异常，必须二选一

1.catch和throws首选throws
2.底层异常向前抛给上层处理
3.在调用路径中，可以选择一个合适的位置catch，修复异常
4.经验不足的情况下，不知道应该在哪捕获，一路向前throws到最前面

throw 手动抛出异常，执行异常的抛出动作
如果不自动出错，通过判断检查到程序中的逻辑错误，可以手动创建异常实例，并抛出
3.14/0 Infinity
if(逻辑错误){
	AException e = new AException("提示消息");
	throw e;
}

异常包装
捕获的异常实例，包装成另一种类型再抛出
try{

}catch(AException e){
	BException x = new BException(e);
	throw x;
}
使用场景：
1.不能抛出的异常，包装成能抛出的类型再抛
2.异常简化，多种异常类型，简化成一种类型

自定义异常
现有的异常类型，不能表示所有的业务中的错误情况，需要自定义新的异常类型来表示具体业务中的错误
如：转账失败，用户名错误，密码错误

步骤：
1.起一个合适的类名
2.选一个合适的父类
3.添加合适的构造方法

Exception 和 RuntimeException
1.RuntimeException有默认的异常管道
void f() throws RuntimeException{}
RuntimeException 非检查异常，编译器不会检查这种异常是否添加了处理代码，不强制处理

2.Exception 检查异常，必须编写处理代码throws或者catche，强制处理
-------------------------------
System.exit(0);// 关闭虚拟机
System.gc();// 提醒虚拟机，程序员希望垃圾回收

字符串的+操作符
a = "aaa";
b = "bbb";
s = a+b;// 创建了2个实例对象，s1 = new StringBuilder(s); s1.toString();

s1 = "aaa"+"bbb"+"ccc";
等同于
s1 = "aaabbbccc";
-------------------------------
内部类：
1.非静态内部类
作用：
辅助外部实例进行运算，来封装局部的数据，或局部的运算逻辑
class A{
	class Inner{// 不能独立创建内部类实例，依赖于外部实例存在，属于A实例

	}
}
A a = new A();
Inner i = a.new Inner();// 也要导包
2.静态内部类
作用：
与普通类没有区别，嵌套定义，或者独立定义都可以，只是一个设计选项

两个类如果关系紧密，可以选择嵌套定义
例子：两个类Robot Arm
class A{
	static class Inner{

	}
}
A.Inner i = new A.Inner();// 可以独立调用
Inner i = new Inner();// 可以独立调用，导包写法
3.局部内部类
只能在局部使用，f()中用，可以把实例的内存地址return出去
Inner类不能在外部用，在外只能转为父类型使用
class A{
	Object/Weapon f(){
		class Inner implements Weapon{

		}
		Inner i = new Inner();
		return i;
	}
}
A a = new A();
Weapon w = a.f();// 真实类型是子类实例
4.匿名内部类（常用）// 匿名类是子类
class A{
	void f(){
		// 匿名内部类  是赋值所以要有;号
		父类 xx = new 父类(){  // new 父类()=>super()执行object的构造

		};
	}
}
例子：
class A implements Weapon{
	public A(){
		super();
	}
}
实例化
Weapon w = new Weapon();

缩写成：
Weapon w = new A(){

};
例子：
interface IE{
	void show();
}
public static void main(String[] args) {
	new IE() {
		@Override
		public void show() {
			System.out.println("show-01");
		}
	}.show();
}
// 下面就是个IE的子类实现类 的缩写
IE(){
	@Override
	public void show() {}
}
-------------------------------
方法重写：
1.子类重写父类方法 访问范围不能降低，能提高
2.不能比父类抛更多异常
3.返回值类型是基本类型的话，要求相同

方法重载：
1.访问范围可以降低，没要求
2.方法名相同且参数列表不同，与返回值类型无关

java重载
当参数顺序不一样，也是重载，返回值可以不同

重写与重载之间的区别
区别点：	重载方法：	重写方法：
参数列表	必须修改	一定不能修改
返回类型	可以修改	一定不能修改
异常	可以修改	可以减少或删除，一定不能抛出新的或者更广的异常
访问	可以修改	一定不能做更严格的限制（可以降低限制）

重写要求高一点
-------------------------------
错题整理：
在类方法中绝对不能调用实例方法 ：错误
在类方法中可以通过实例化对象调用实例方法。

类中的普通属性是类的实例变量 ：正确

方法中定义的是局部变量，不能用类成员变量修饰符 private

接口中的属性都是常量，默认由public static final同时修饰，可以省略

abstract可以修饰方法和类，不能修饰属性和变量

抽象方法可以在接口中和抽象类中定义

接口是一种只含有抽象方法或常量的一种特殊的抽象类，因为接口不包括任何实现，所以与存储空间没有任何关系。

java8以前，接口只能被类实现，类不能继承接口，遵循单继承多实现原则。java8以后，接口中可以包含静态方法和默认方法。

修饰接口只能是public和默认

顶层类修饰符：
对于顶层类(外部类)来说，只有两种修饰符：public和默认(default)。 因为外部类的上一单元是包，所以外部类只有两个作用域：同包，任何位置。 因此，只需要两种控制权限：包控制权限和公开访问权限，也就对应两种控制修饰符：public和默认(default)。 

创建对象时：
声明对象，为对象分配内存空间，对对象初始化，使用对象 

String 类是 final 的，在 java 中 final 修饰类的不能被继承
String对象在调用toUpperCase()和trim()方法时都会返回新的字符串对象，原对象不变

Map与Collection是两个不同的接口，没有继承关系。

LinkedHashSet 元素唯一，且按照存放顺序读取

不是Collection接口所定义 compareTo

Vector是线程安全的 

ArrayList不是线程安全的

java.util.Queue 是链式存储并快速顺序(不需要随机访问)访问的集合类型

Map没有继承Collection接口

java不支持goto语句。

目录在Java中作为一种特殊文件，即文件名的列表

Java中的RandomAccessFile类提供了随意访问文件的功能

计算机中的流是 流动的数据缓冲区 

FilterOutputStream构造函数的参数类型（ ）OutputStream 

InputStreamReader  面向字符的输入流

ByteArrayInputStream,FileInputStream,ObjectInputStream 是字节流

FileNotFoundException  编写程序时申明异常

ClassCastException 运行时异常

Java异常的基类为java.lang.Throwable。java.lang.Error和java.lang.Exception继承 Throwable，RuntimeException和其它的Exception等继承Exception。

finally是关键字不是方法

finally在异常处理的时候使用，提供finally块来执行任何清除操作 （指的是清楚内存吧）？

sleep 是线程类（Thread）的方法，wait 是 Object 类的方法 

wait 后进入等待此对象的等待锁定池，只有针对此对象发出 notify 方法（或 notifyAll）后本线程才进入对象锁定池准备获得对 象锁进入运行状态。

Java 提供对多线程同步提供语言级的支持 

线程生命周期：新建状态、可运行状态（就绪状态）、运行状态、阻塞状态和终止状态

当一个线程因为抢先机制而停止运行，只能在轮换队列中排队而不能排在前面。

能让线程停止执行的有stop：这个方法将终止所有未结束的方法，包括 run 方法

Schema与DTD的相同之处有 对XML文档结构进行验证

java 解析 xml 文件四种方式：SAX、DOM、JDOM、DOM4J

xml文档中实体符号是用&作为开头的

前后问号 <?xml-stylesheet type="txt/css" href="abc.css"?> 

预定义实体 < 和 >

SAX解析文档需要按照顺序 DOM可以随意

位运算符
按位与（&）、按位或（|）、按位异或（^）、按位取反（~）、按位左移（<<）、按位右移（>>）、按位右移补零（>>>）

^属于二进制位运算符 代表异或的意思（同0异1）
运算时两个二进制数对应位的数不同时结果为1  否则为0
所以1100^1010的结果应该是0110

~属于二进制位运算符 代表非的意思~0为1

&运算的规则是数位都为1则是1，只要有一个数的当前数位是0则结果为0，所以 2&3 == 10 & 11 ，则对应的结果为10，转换成十进制就是数字2

二进制取反~：取反加一

final关键字可以修饰：方法，常量，类  不能修饰变量

反射机制的作用是 A,B,C,D
A.在运行时判断任意一个对象所属的类。
B.在运行时构造任意一个类的对象。
C.在运行时判断任意一个类所具有的成员变量和方法。
D.在运行时调用任意一个对象的方法

运行一个Java程序，只需要JDK中的JRE

JRE是Java Runtime Environment的缩写，顾名思义是java运行时环境，包含了java虚拟机，java基础类库。

Jdk是Java Development Kit的缩写，顾名思义是java开发工具包，是程序员使用java语言编写java程序所需的开发工具包，是提供给程序员使用的。

下列各项可以用作标识符的是？( ) A,B,C,D
A. String  
B. Int 
C. finalize  
D. $T$  

抽象类可以有构造方法，接口没有构造方法
一个类最多可以继承一个抽象类，但是可以实现多个接口
抽象类可以有非抽象方法，接口中都是抽象方法
抽象类和接口都不能创建对象

二进制左移和右移
y<<x	 乘以2的x次方
y>>x	 除以2的x次方

众多大小异常的基类为 Exception，所有异常都必须直接或者间接继承它 
但是java.lang.Exception这个类的基类是Throwable

web应用中的类，位于包中，那么这个类的.class文件的存放路径应该是什么？
答：web应用名/WEB-INF/classes/包名/类名.class

HttpServlet类中处理客户请求和响应时所使用的两个接口是：HttpServletRequest和HttpServletResponse

在Servlet生命周期方法中，每当有请求访问Servlet时，web容器会调用（service）方法处理请求

以下错误：
Servlet的生命周期由Servlet实例控制  
init()方法在创建完Servlet实例后, Servlet会调用该方法进行初始化。

request域的生命周期为：在服务器针对一次请求创建出request对象后生命周期开始，在响应结束后request对象销毁，生命周期结束

response.sendRedirect("xxx");重定向是无法传数据的

post乱码解决办法：request.setCharcterEncoding("GBK");

HTTP协议只规定了浏览器和服务器之间如何通信，而request和response对象是由javaee规范规定的、由javaweb容器负责创建的

response对象不能作为域对象实现资源共享，request可以

JSP只有在第一次被访问时(或者JSP被修改后)，才会被翻译为一个Servlet。

<%-- 这是一个注释 --%> 没有参与JSP的翻译过程

<!-- 这是一个注释 --> 参与了JSP的翻译过程

以下哪些属于JSP的指令：page，taglib，include

oracle
删除表 DELETE FROM Student 
修改表结构 ALTER TABLE 
truncate 在提交 commit 之前不可回滚
truncate 不可删除表结构 

DML：data manipulation language 数据操作语言：
      insert、delete、update、merge
DDL：data definition language 数据定义语言：
      create、alter、drop、truncate
DCL：data control	language 数据控制语言：
      grant、revoke

Oracle数据库连接URI正确格式：
jdbc:oracle:thin:@hostname:1521:orcl 

execute方法的返回的是bollean类型

JDBC可以执行的语句：DDL DML DQL 

连接池可以限制客户端的连接数量 
连接池可以提高系统性能，于查询语句没有关系，不能提高查询语句的执行效率。

查询海量数据的时，Oracle默认每次拿指定数量的结果，将指定数量的结果遍历完后，再拿下一个指定数量的结果

Statement对象close后，由其创建的ResultSet对象将自动的close 

getColumnCount() 返回此 ResultSet 对象中的列数

PreparedStatement和Statement都可以进行批处理操作

PreparedStatement可以存储预编译的Statement，从而提升执行效率 

得到结果集中的第一列数据的代码：rs.getString(1); 

java.sql.SQLException: No suitable driver（URL拼写错误） 

oracle分页不用limit，通过rownum分页先在子查询中查询小于满足条件的最后一条数据的所有记录，当子查询结果集确定后，再过滤出大于满足条件的起始第一条数据的所有记录。

事务四大特性：原子性、隔离性、一致性、持久性

getGeneratedKeys()方法获取刚刚插入数据库的记录的自增主键值，
返回的结果是ResultSet类型的结果集

MVC包括，视图层，模型层，控制层

<context:component-scan base-package="com.tarena"/>
容器会扫描com.tarena包及其子包下面的类

Spring的事务支持并不依赖于Java EE环境

IOC是控制反转，是将代码中的操控权转到容器里去控制，不是由程序代码直接操控

bean的生命周期：
销毁方法只适用于singleton模式的bean
不是每个bean都必须提供相应的生命周期方法

<bean id="bar1" class="ioc.autowire.Bar" autowire="byName"/>
容器会采取自动装配的方式来建立依赖关系
byName指定的是查找与属性名称一致的bean，调用set方法来完成注入
autowire的值还可以是byType和constructor
因为本题中bar1是bean的id，所以是唯一的，所以不可能找到多个符合要求的bean。

在Spring中，任何的Java类和JavaBean都可以被当成Bean处理，这些Bean通过容器管理和使用
Spring容器有BeanFactory和ApplicationContext等类型。

IOC 对象只是被动的接收依赖对象

<property set注入
<constructor-arg 构造注入

spring表达式语法非常类似el表达式。

数据库系统DBS包含 数据库DB，和数据库管理系统DBMS

删除一列
alter table tableName drop columnName; 

属于DML的是insert 支持事务

DDL 数据定义语言: create drop alter truncate 不支持事务
DML 数据操作语言: insert update delete 支持事务
DQL 数据查询语言: select 不支持事务 
TCL 事务控制语言: commit rollback 等 
DCL 数据控制语言: 分配用户权限

索引是用来提高查询速度的技术,类似一个目录
索引会占用磁盘空间,所以创建时需谨慎,根据查询需求和表结构来决定创建什么索引
索引需要建立在大量数据的表中,如果数据量不够大,有可能会降低查询效率

视图：
表和视图都是数据库中的对象 
原表的数据改变时，视图中的数据也会随之改变 
视图: 数据库中存在多种对象，表和视图都是数据库中的对象,创建视图时名称不能和表名重名,视图实际上是一段sql查询语句的映射,可以理解成视图是一张虚拟的表,表中的数据会随着原表的改变而改变

select语句中的条件，年龄between 22 and 26
包括22岁和26岁 

select * from person where age in(25,28,30,22); 

默认升序, 指定升序是:asc

判断null
update emp set bonus=ifnull(bonus,0); 
update emp set bonus=0 where bonus is null; // null用is判断

Web应用的目录结构。根目录中可以存放html,jsp,css文件，js文件等等

ServletConfig接口默认实现GenericServlet 

web.xml 片断正确地声明 servlet
初始化参数<init-param>只对应一个Servlet。
<context-param>对应整个web应用

动态网站技术 CGI  PHP  ASP 

J2EE 现在更多使用的名字是 Java EE 
JSP 是 JavaEE 设计模式 MVC 中的显示部分，
Servlet 是控制部分，
WebService 是 JavaEE 的服务器

request读取路径信息，不是response

配置一个Servlet需要
<servlet></servlet>和<servlet-mapping></servlet-mapping>标签

<servlet>标签包含servlet-name，servlet-class，init-param
<servlet-mapping>标签包含servlet-name，url-pattern

Servlet 的生命周期
service()方法响应客户端发出的请求
Serlvet 生命周期的三个方法:init()-->service()-->destroy()。 
Servlet生命周期是由Servlet容器管理的
调用初始化init()方法时需要传入实现了ServletConfig接口的实例

可以在一个页面中使用多个<%@ page %>指令。 

<jsp:javabean>不属于jsp标签

运行 jsp 需要安装tomcat 和WebLogic  服务器
Apache 是 PHP 程序运行的服务器

response是用来网页传回用户端的回应

Application 存储 每一个网站访问用户都要访问的变量

Application实现跨机共享数据的JSP对象

JSP 有九个隐藏对象
request  response  out session  application  pageContext paget  exception  config 对象

隐式对象是 WEB 容器加载的一组类的实例，可以直接在 JSP 页面使用 

session 使user对象中一直存在于会话中，直至其终止或被删除为止

cookie 不能在不同用户之间共享数据，ServletContext可以

HttpSession接口位于javax.servlet.http包中

DHTML不属于AJAX范畴

abort不属于XMLHttpRequest 对象的属性
responseText 属于

jQuery 	contains()： 匹配包含给定文本的元素。 它所传入的参数是一个用以查找的字符串。

<title>是head标签部分里必不可少的元素

css中clear
指明该元素周围不可出现浮动元素

以下哪一条Javascript语句会产生运行错误？
var obj=(); 

undefined值是通过null派生出来的，==时它会自动转化为null，所以返回true

js五种基本类型（原始类型）：String Boolean Number null undefined

js中 同名函数， 后面的函数会覆盖前面定义的函数

setTimeout(A,1000);
setTimeout({A();},1000);

prepareStatement()方法来构建一个PreparedStatement接口	

每个对象都有唯一的对象锁，而不是多个

Synchronized声明不会被继承，如果一个用synchronized修饰的方法被子类覆盖，那么子类中这个方法不在保持同步，除非用synchronized修饰。

当一个线程开始执行同步代码块时，并不意味着必须以不间断的方式运行，进入同步代码块的线程可以执行Thread.sleep()或执行Thread.yield()方法，此时它并不释放对象锁，只是把运行的机会让给其他的线程。 

FileNotFoundException（文件拒绝访问）  是检查型异常
ClassCastException（java强制类型转换异常） 是运行型异常 

属于InetAddress类的方法的是
获取主机对象：getLocalHost()
主机名：getHostName()
主机Ip地址：getHostAddress()
没有getName() 

HTTP协议只规定了浏览器和服务器之间如何通信，而request和response对象是由javaee规范规定的、由javaweb容器负责创建的。 

一个Servlet中不能转发两次

请求转发的过程中转发前写入response中的实体内容数据会丢失掉，最终输出的将是请求转发过程中的最后一个节点资源的数据输出。 

request对象的getSession(false)方法用于获取一个已存在的session, 如果没有session, 将会返回null 

对于get方式提交的请求参数，我们需要自己手动的经过将乱码先编码再解码的过程解决乱码。 

线程run()方法可以产生必须退出的标志来停止一个线程。

request的功能有 获取Session对象 
-------------------------------
io:
io Input/Output 输入/输出
相对于内存 到 磁盘文件
把磁盘文件读入内存

java.io包
	File	
	FileInputStream,FileOutputStream
	ObjectInputStream,ObjectOutputStream
	InputStreamReader,OutputStreamWriter

1.File 两斜杠都支持 封装一个磁盘路径的字符串，提供了文件属性，文件的创建删除，目录列表等操作方法
可以封装：
	文件
	文件夹
	不存在的路径
例子：
"d:/abc"

文件或文件夹属性：
length() 文件的字节量 213123131 约等于213M，对文件夹无效
isFile() 是否是文件
isDirectory() 是否是文件夹
exists() 封装的路径是否存在 false
getName() 获得文件名 
getParent() 获得父目录
getAbsolutePath() 绝对路径
创建/删除文件或文件件：
createNewFile() 创建文件，已经存在不会新建，返回false。路径前面文件夹不存在
mkdirs() 只建一层
mkdirs() 新建多层目录，逐层创建 指定多层路径"d:/a/a/a/"
delete() 删除文件，或空文件夹
文件夹列表：
list() 获得String[]数组，只包含文件或文件夹的名称字符串。例子：["aa","bb","c.png"]
listFiles() 获得File[]数组，包含每个文件和文件夹的封装的File实例。[{...},{},{}]

文件夹列表 可能得到null值
1.对文件列表
2.对不存在的路径
3.无权进入的文件夹

流 stream 把字节数据的读写，抽象成数据在管道中流动
1.只能单向流动
	输入流，只能读取数据
	输出流，只能把内存数据向外输出
2.只能从头到尾流动一次，不能反复流动

FileInputStream,FileOutputStream 直接插在文件上，读写文件数据
创建对象：
new FileOutputStream(文件)
不管文件是否存在，都会新建一个空文件，会删除旧文件。

new FileInputStream(文件,true)
如果文件已经存在，追加数据
如果文件夹不存在，会出现异常

方法：
write(int b) 输出int 4个字节中末尾的一个字节值
[1],[2],[3],[4]   ---->   [4]
一般给255范围内，一个字节内

write(byte[],start,length)
例子：
write(byte[],3,3);
输出数组中，从start开始的length个字节值

read()
读取一个字节值，补三个0字节，转成int类型
[4]  -->   [0][0][0][4]  第一位是0正数

read(byte[] buff)
按数组的长度，读取一批数据放入数组，并返回这一批的字节数量

读取结束再读取，返回-1，表示结束
例子：
FileInputStream in = new FileInputStream(from);
byte[] buff = new byte[8192];
int n;// 存每一批的数量
while ((n=in.read(buff))!=-1) {
	// 最后一批没有8192个，而是只有n个
	// 只能输出数组的前n个字节值
	out.write(buff,0,n);
}

while嵌套写法：
while ((b=in.read())!=-1) {
	System.out.println(b);
}

java序列化 
对象 => 文件中的字节序列
ObjectInputStream,ObjectOutputStream
对象的序列化和反序列化
序列化：把一个实例的信息，按固定格式转成一串字节序列输出
类名，变量，变量值
作用：传java实例
方法：
writeObject(Object obj) 把对象转成一串字节值输出
readObject 读取序列化数据，重新恢复对象

被序列化的对象，必须实现Serializable接口
Serializable接口是一个空接口，称为标识接口，用来标识一个类，允许被序列化

序列化是序列化实例

不序列化的成员：
static 静态属于类，而不属于实例，不会随实例被序列化输出
transient 临时，只在程序运行期间，在内存中存在，不会随实例序列化持久保存
即不会随类一起序列化到本地，所以当还原后，这个关键字定义的变量也就不再存在

序列化版本id
用来控制旧的数据，不允许恢复成新的版本的类型
实例变成实例2了，序列化1就恢复不了了
如果不定义，编译器会自动添加版本id，会根据类的定义信息来计算产生一个id值
private static final long serialVersionUID = 1L;

为了避免对象结构变化使无法反序列化，人为增加序列化id

序列化的粒度：
1.transient
private transient int id;
2.po/vo类实现Externalizable接口
id,title,content
只序列化title,content
//序列化时
writeExternal(xx out){
	out.writeUTF(title);
	out.writeUTF(content);
}
//反序列化时
readExternal(xx in){
	title = in.readUTF();//按写的顺序读
	content=in.readUTF();
}

kryo序列化框架（快，不跨语言）
1.pom依赖
2.kryo.writeClassAndObject(output, obj);
Object obj=kryo.readClassAndObject(input);
3.一个线程一份，放入ThreadLocal

文件流按字节读

InputStreamReader,OutputStreamWriter
编码转换流（只能读取文本，按字符读）
1.java的char类型使用Unicode码（双字节的）
2.Unicode保存或传输，应该转换成其他编码
3.转成utf-8
	utf-8，英文单字节，中文三字节，其他字符两字节或四字节
4.转成GBK
	国标码
	英文单字节
	中文双字节

OutputStreamWriter
	把Unicode转成其他编码输出
InputStreamReader
	读取其他编码的字符，转成Unicode
-------------------------------
枚举：
enum Gender{//Gender.class
	MALE,FEMALE,NONE;//对象实例(类加载时创建)
	private Gender() {//必须私有
		System.out.println("Gender()");
	}
}
/**产品对象*/
class Product{
	/**性别要求*/
	Gender gender=Gender.NONE;
}

enum Sex{//默认继承Enum
	MALE("男"),FEMALE("女");
	private String name;
	private Sex(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
class Member{//默认继承Object
	 Sex sex=Sex.MALE;
}
//基于枚举实现单例设计
enum Singleton{
	INSTANCE;//饿汉单例
}
public class TestEnum02 {
   public static void main(String[] args) {
	   Member m=new Member();
	   System.out.println(m.sex.getName());
	   String sexStr="MALE";
	   //将字符串转换为枚举(字符串名字必须和枚举对象名相同)
	   m.sex=Sex.valueOf(sexStr);
	   m.sex=Enum.valueOf(Sex.class, sexStr);
	   System.out.println(Sex.MALE instanceof Enum);
   }
}
-------------------------------
注解（Annotation）
元数据
@interface
@Target(ElementType.FIELD属性)//修饰对象，默认任何对象
//@Target({ElementType.TYPE类，接口,ElementType.METHOD方法,ElementType.FIELD属性})
@Retention(RetentionPolicy.RUNTIME运行时生效)//何阶段生效，默认编译时生效
//@Retention(RetentionPolicy.SOURCE编译时生效)
@interface Xxx{
	String value() default "";
	boolean isOpen() default false;
}

@Xxx
...

获取类上的注解：
//1.获取类字节码对象
Class<?> clz=Xxx.class;
//2.获取类上注解
Entity xxx=clz.getDeclaredAnnotation(Xxx.class);

获取属性上的注解：
//3.获取属性id上的ID注解
Field f=clz.getDeclaredField("Xxx");
ID xxx=f.getDeclaredAnnotation(Xxx.class);

@Xxx("aaa")//默认给value赋值
@Xxx(value="aaa",isOpen=true)
...

获取类上注解及注解中属性的值：
接上：
xxx.value();
xxx.isOpen();

注解也能描述注解

包扫描注解：
没指定值，则扫描当前包下所有类（如要子类，需要递归）
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ComponentScan {// spring框架也有
	String value() default "";
}

@ComponentScan("com.company.java.cache")
//@ComponentScan("")
class AppConfig {
}// 配置类

public class TestAnnotation03 {
	public static void main(String[] args) {
		// 1.获取AppConfig类的字节码对象
		Class<?> cls = AppConfig.class;
		// 2.获取AppConfig类上的@ComponentScan注解
		ComponentScan componentScan = cls.getDeclaredAnnotation(ComponentScan.class);
		// 3.获取@ComponentScan注解中value属性的值
		if (componentScan == null) {
			return;
		}
		String pkg = componentScan.value();
		if ("".equals(pkg)) {
			// 没有指定包时，获取cls对应的包名
			pkg = cls.getPackage().getName();
		}
		// 4.输出@ComponentScan注解对应value属性指定的包中所有类
		// 4.1将包结构中的"."替换为"/"
		String path = pkg.replace(".", "/");
		// 4.2基于ClassLoader对象获取指定目录对应的绝对路径
		URL url = ClassLoader.getSystemResource(path);
		// 4.3基于File对象获取绝对路径中的Class文件
		System.out.println(url.getPath());
		File file = new File(url.getPath());
		File[] classes = file.listFiles();
		for (File f: classes) {
			System.out.println(f.getName());
		}
	}
}
-------------------------------
线程（重点）:
进程：在操作系统里并行执行的任务
cpu同一时间只能处理一项任务，时间被切分成小的时间片，所有任务在时间片上轮换执行

线程：在进程内部并行执行的多项任务（也是时间片随机执行）

包含关系：操作系统>进程>线程

在jvm进程中创建线程
创建线程（两种方式）：
1.继承Thread
继承Thread，写一个Thread子类，子类里重写run(){}
调t1.start()启动线程后，会自动执行其中的run方法，不用t1.run()手动调，自动执行
例子：
static class T1 extends Thread{
	public void run() {}
}
new T1().start();
例子2（匿名内部类）：
new Thread() {
	public void run() {}
}.start();

jvm启动main线程，执行main方法，t1.start()启动新线程和main线程并行，等待争夺时间片。

2.实现Runnable
Runnable不是线程，是用来封装可以在线程中执行的代码
写一个Runnable接口的子类，写run方法
1.实现Runnable接口
2.实现run()方法
3.新建线程实例时，把Runnable对象放入线程
4.线程启动后,执行Runnable对象的run()方法
例子：
static class R1 implements Runnable{
	public void run(){}
}
Thread t1 = new Thread(new R1());
t1.start();

线程状态：
新生    =>   start()  => 
可执行
执行   =>   run方法结束  /  暂停下来
消亡 /  阻塞  =>  可执行状态
除了新生和消亡都是活动线程
消亡的线程不能重新启动，只能重新创建线程实例

线程的方法：
Thread.currentThread()// 静态，获得正在执行这行代码的当前线程实例
Thread.sleep(毫秒值)// 阻塞暂停当前线程指定的毫秒时长
getName(),setName()
start()
interrupt() 打断一个线程的暂停状态，把另一个线程敲醒
由b执行a.interrupt()，被打断的线程a会出现InterruptedException异常
setDaemon(true) 后台线程，守护线程，只能在启动之前设置
jvm中多个线程，等所有前台线程结束，jvm会关闭
jvm不会等后台线程死活
例子：
Thread t2 = new Thread() {
	public void run() {}
}
t2.setDaemon(true);// 在start前设置为后台进程
t2.start();
setPriority() 线程优先级，1~10级，默认是5
join() 当前线程暂停，等待被调用的线程结束
a线程
b线程 等待a的计算结果 再继续运行
在b中执行a.join()

多线程数据访问冲突（线程安全问题）
多个线程共享数据，一个线程修改，一个线程同时访问，可能会访问到修改了一半的数据

数据访问冲突
线程 同步机制 synchronized
synchronized声明的方法同一时间只能被一个线程访问
让多个线程步调一致的执行
1.线程同步锁
java中任何实例都有一个同步锁，如果一个线程抢到同步锁，其他线程等待，直到能抢到锁才能执行
抢同一把锁，使步调一致，加两处synchronized
synchronized(对象){// 抢指定对象的锁，锁定代码越少越好
	数据修改或数据访问的代码
}
synchronized(this/A.class){}
不同的写法：
1.synchronized void f(){// 抢当前实例this的锁

}
a.f() // 同是a抢锁

2.static synchronized void f(){// 抢类的锁

}
a.f()// 抢的是类的锁
b.f()

实例允许调用类的方法

生产者，消费者
线程间的通信模型
中间放一个数据容器 来解耦
1.生产者产生数据，存入一个数据容器
2.消费者从数据容器获取数据进行处理
3.生产者和消费者之间，用中间的容器解耦// 容器栈结构，后进先出，一个出口

等待和通知
Object的方法
wait()
notify() // 无法指定参数
notifyAll()

stack.wait() 停止synchronized，解锁
stack.notifyAll() 在synchronized同步监视器中发出通知，唤醒wait实例
1.只能在synchronized内调用
2.等待和通知的对象必须是加锁的对象
3.wait的外面总应该是一个循环条件判断，notify后，即从wait处醒来，往下执行

先轮时间片再轮synchronized锁

wait的对象等待stack.notifyAll通知，加入竞争队列

同步监视器模型
执行到synchronized，会在加锁的对象上，关联一个同步监视器
入口区  同步区  等待区（wait后，等待notify）

死锁：
线1
synchronized(a){
	synchronized(b){

	}
}
线2
synchronized(b){
	synchronized(a){

	}
}
线1等b，线2等a，死锁
同一顺序解决问题

volatile 修饰符
volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。
这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
-------------------------------
Socket网络通信（套接字）:
主机之间可以通过ip地址找到对方，两台主机各选择一个端口（0~65535？），各插一个插头

关闭防火墙
ping 192.168.14.xxx 对方关闭防火墙

回环ip 127.0.0.1

ServerSocket 在服务器端选择一个端口号，等待客户端发起连接
端口号：
http 80
https 443?
ftp 21
0~1024 常见服务的默认端口
50000~65535 系统保留端口
ServerSocket ss = new ServerSocket(端口号);
ss.accept();// 暂停，等客户端发起连接，并建立连接通道，返回服务器端的插头对象
服务器端 socket实例有一个输入流一个输出流

客户端
客户端主动创建Socket插头对象，与指定服务器的ip地址和端口建立连接
Socket s = new Socket(ip,port);
网络输入输出流
InputStream in = s.getInputStream();
OutputStream out = s.getOutputStream();

阻塞操作：
1.ss.accept();// 暂停，等待客户端发起连接
2.in.read();// 暂停，等待接收客户端的数据
如果要同时执行这两个阻塞操作，要启动两个线程并行执行：
1.同时等待客户端连接
2.同时等待接收客户端数据

服务器端线程模型：
类型10086 accept等待客户
多客户多客服
1.总机等下一个客户
2.和在线客户一起对话

首先启动服务线程：
服务线程（总机）：main方法，启动ss服务，循环执行accept()，等待下一个客户端连接
通信线程：不断和新接入的客户，建立新的通信线程

服务端：
1.主线程创建ServerSocket对象，循环等待接入并返回Socket对象，一个客户端成功发起一个Socket连接，此Socket对象就会被传入一个新建的通信线程。
2.这个通信线程会取得此Socket对象的网络输入和输出流，加以处理转为接入和发送方法，赋值在此通信线程实例上，然后此通信线程实例就可给此Socket收发信息。所以要一个通信线程一对接入和发送方法。
3.通信线程的群发方法，在外部类的成员变量中拿到所有通信线程实例的数组集合，循环执行每个通信线程实例的send方法，send方法会用每个实例自己的发送方法对象给自己的Socket对象发送消息。
客户端：
一个实例，包含一个接收线程，一个输入线程
总的关系：
服务器一个总线程下多个通信线程，每个通信线程和一个客户端的Socket实例对应。

BufferedReader in;
PrintWriter out;
in.readLine();
out.println();// 只有输出的时候需要刷缓存
out.flush();
-------------------------------
Class代表类的类
反射 Reflect（透视）:
反射的起点：字节码对象
配置文件：里面都是字符串 new "字符串" 传统方式不行
config.txt

day1901.A;a
day1901.B;b
day1901.C;c
使用加载到虚拟机中的类对象的反射操作，可以新建实例，调用成员
用反射操作可以：
1.获取类的定义信息：

获取类对象：（重点）   在方法区找到
Class c = A.class 访问方法区的这个类 /Class<A> A类的类对象
Class c = Class.forName("day1901.A")// 全类名
Class c = a1.getClass() 得到实例的类对象
已加载直接访问，访问时没找到会先去加载

获取包名类名：
// 包名
c.getPackage().getName()
// 完整类名
c.getName() 包名加类名
// 简写类名（不含包名）
c.getSimpleName()

获取成员变量的定义信息:
getFields() 获取所有public的字段，包含父类
getDeclaredFields() 获得所有声明的字段，包括public、private、proteced，不包含父类
getField(变量名) 获得指定的一个变量
getDeclaredField(变量名)

获取构造方法的定义信息:
getConstructors() 获取所有可见的构造方法，不含父构造，构造是不继承的
getDeclaredConstructors() 获取所有可见的构造方法，包含私有
getConstructor(参数类型列表) 指定一个
getDeclaredConstructor(int.class,String.class) 通过参数类型来区分
类对象，int这个类的class？

获取方法的定义信息:
getMethods() 获得所有方法，包含继承
getDeclaredMethods() 获得所有本类定义的方法，包含私有，不含继承
getMethod(方法名，参数类型列表) 
getDeclaredMethod(方法名，int.class,String.class)

2.新建实例：
1.执行无参构造 Object obj = c.newInstance();
2.执行有参构造:
// 获得构造方法
Constructor t = c.getConstructor(int.class,String.class)
// 新建实例并执行该方法
Object obj = t.newInstance(6,"abc");

3.调用成员变量，成员方法
// 获取变量
Field f = c.getDeclaredField(变量名);
// 使私有变量允许被访问
f.setAccessible(true);
// 变量的反射操作，为指定实例的变量赋值
// 如果是静态变量，第一个参数给null值
f.set(实例,值);
// 变量的反射操作，来访问指定实例变量的值
// 如果是静态变量，参数给null值
Object v = f.get(实例);

调用成员方法:
// 获取方法
Method t = c.getDeclaredMethod(方法名，参数类型列表)
// 使私有方法允许被调用
t.setAccessible(true);
// 方法的反射操作，并执行这个方法
// 如果是静态方法，第一个参数给null
// 如果方法是void，得到的返回结果也是null
Object r = t.invoke(实例,6,"abc");

反射的作用：
动态编程，程序不是固化的静态代码，而是通过配置文件可以配置程序的执行流程

框架（ssm）底层就是用反射实现，根据配置来执行

注解:
为其它的开发工具和java程序提供代码的额外信息
@Override 重写 // 提示编译器，让编译器检查重写的语法

自定义一个注解
自定义的注解，需要自己编写处理程序
有@Test注释就运行

注释文件Test:
@Target(ElementType.METHOD)
//@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	// 如果不指定默认值，使用时必须赋值
	int id() default 0;
	String title() default "";
	/*
	 * 特殊的属性名value，这个属性名有特殊待遇
	 * 在单独赋值时，可以省略属性名
	 * @Test("测试1")
	 * @Test(title="测试1")
	 * */
	// 把特殊属性名value当做是title的一个别名
	String value() default "";
}
运行器文件Runner（反射的方式）:
public class Runner {
	public static void launch(Class<?> c) throws Exception {
		// 新建实例
		Object obj = c.newInstance();
		// 获得所有的方法
		Method[] a = c.getMethods();
		for (Method t : a) {
			//判断方法上是否有@Test注解存在
	        if(t.isAnnotationPresent(Test.class)) {
	           run(obj, t);//执行这个有@Test注解的方法
	        }
		}
	}
	private static void run(Object obj, Method t) throws Exception{
		System.out.println("---------");
		// 从方法获取注解实例
		Test test = t.getAnnotation(Test.class);
		System.out.println("id="+test.id());
		String title = test.title();//取title
		if(title.equals("")) {// 没有title
			title = test.value();//那么把value当做title
		}
		System.out.println("title="+title);
		t.invoke(obj);//发射操作执行该方法
	}
	public static void main(String[] args) throws Exception {
		Runner.launch(Test1.class);// Test1的类对象，反射
	}
}
日常代码文件Test1：
public class Test1 {
	@Test(id=3525,title="测试1")
	public void a() {
		System.out.println("Test1.a()");
	}
	@Test
	public void b() {
		System.out.println("Test1.b()");
	}
	public void c() {
		System.out.println("Test1.c()");
	}
	@Test("测试3")
	public void d() {
		System.out.println("Test1.d()");
	}
}

上层api，上层框架：
一些底层基础api，使用繁琐，有更方便使用的上层api，封装了繁琐操作，使用上层api，只简单调用一个方法就行

JUnit 测试框架 开源单元测试框架
已经成为单元测试的事实标准
eclipse集成了JUnit，直接支持JUnit框架
引入JUnit开发包：
右键点击项目--Build Path--Add library--JUnit--JUnit4
右键点击项目--项目属性--左侧Build Path--标签libraries--add library

导jar包：
1.jar包放入lib文件夹
2.在jar包上右键点击--Build Path--Add to build path
3.jar解压到Referenced Librarries中
4.导jar包完成

引入JUnit，加了注释，ctrl+f11
-------------------------------
爬虫：
从互联网页面上自动爬取数据
1.和服务器建立Socket连接
2.用流，向服务器发送http协议数据（请求信息）
3.接收服务器返回的http协议数据（包含页面数据）
4.解析页面数据，提取需要的内容

Jsoup 开源的http请求的api，也可以方便的从页面代码从提取内容

需要下载Jsoup的jar包，导入项目
导入外部jar包，build path--add external archives--lib下所有jar包选中加入

Jsoup:
// 爬body全文
@Test
public void test2() throws Exception {
	String s = Jsoup.connect("https://item.jd.com/100002795959.html")
			.execute()
			.body();
	System.out.println(s);
}
// 爬对应class文本
@Test
public void test3() throws Exception {
	String title = Jsoup.connect("https://item.jd.com/100002795959.html")
			.get()
			.select("div.sku-name")
			.text();
	System.out.println(title);
}

抽象子类 继承 接口 与方法实现
public interface A {
	void a();
	void b();
	void c();
}
public abstract class B implements A{
	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println(11);
	}
	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}
}
public class C extends B{
	@Override
	public void c() {
		// TODO Auto-generated method stub
		System.out.println(222);
	}
}
public class Test1 {
	public static void main(String[] args) {
		new C().a();// 11
		new C().c();// 222
	}	
}
-------------------------------
A接口(a,b,c方法)=>B抽象类(a,b)=>C子类(c)=>new C().a();new C().c();没毛病
抽象类B可以缺省需要实现的方法c，但是抽象类B不能被实例化，所以要直到非抽象类C实现完了还没实现的方法c，该非抽象类C才能被实例化

int范围：正负21.47亿左右

OutputStream out = s.getOutputStream();
// getBytes()把字符转成字节值
out.write("world".getBytes());
-------------------------------
jdbc
java database connectivity java数据库连接，用java语言连接并访问数据库的技术
在企业开发中，通过程序连接并访问数据库。如果java程序访问数据库，就必须使用jdbc技术。

Mybatis
Hibernate两框架封装了jdbc

导jar包，ctrl+c新建folder，选中ctrl+v，选中jer包右键，build path，add to...

例子：
public class JdbcDemo1 {
	public static void main(String[] args) throws Exception {
		/*通过java程序查询jt_db.account表中的所有记录
		 * 将查询到的结果输出到控制台上
		 * */
		/*
		 * 1.注册数据库驱动
		 * 2.获取数据库连接
		 * 3.获取传输器
		 * 4.发送sql到数据库执行，并返回执行结果
		 * 5.处理结果
		 * 6.释放资源
		 * */
		// 1.注册数据库驱动
		//com.mysql.jdbc包路径，Driver类名
		// 改成大的异常，后面不用再抛了
		// 根据传入类的路径（包名+类名），加载一个类到内存中，在Driver类中的静态代码块包含注册驱动的代码
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取数据库连接
		// 协议名+主机名+库名
		// jdbc:mysql://localhost:3306/jt_db
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db", "root", "root");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jt_db", "root", "root");
//		Connection conn = DriverManager.getConnection("jdbc:mysql:///jt_db", "root", "root");
		// characterEncoding=utf-8避免get和set数据库乱码
		Connection conn = DriverManager.getConnection("jdbc:mysql:///jt_db?characterEncoding=utf-8", "root", "root");
		// 3.获取传输器 
		Statement stat = conn.createStatement();
		// 4.发送sql到数据库执行，并返回执行结果
		String sql = "select * from account";
		// executeUpdate增删改 
		// executeQuery查询 查询结果是一个ResultSet对象
		// 返回结果集
		ResultSet rs = stat.executeQuery(sql);
		// 5.处理结果 循环
		// rs指向表头，rs.next()下移一行，指向第一行
		// 不知道什么类型，rs.getObject()
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double money = rs.getDouble("money");
			System.out.println(id+","+name+","+money);
		}
		// 6.释放资源
		// 释放时，从后往前释放
		rs.close();
		stat.close();
		conn.close();
		System.out.println("JdbcDemo1.main()");
	}	
}

连接池：
dataSource，因此连接池也叫数据源，
连接池，常量池，线程池，所谓池就是在内存中开辟的空间，是一个容器
连接池就是将连接放在一个容器中，目的是为了减少连接的创建和关闭，实现连接的复用，从而提高程序执行的效率！

为什么要使用数据库连接池
1.在传统方式中不使用连接池：
创建和关闭连接很耗时间、资源，因此这种方式效率不高
2.使用连接池
可以在程序一启动时，就初始化一批连接放在容器（池）中，供整个程序共享，不用再创建和关闭步骤，实现了连接的复用，提高效率。

如何使用连接池：
三种方式见项目
properties
xml

c3p0连接池开发步骤：
引入jar包
public void findByName() {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// 创建一个连接池对象ComboPooledDataSource
	ComboPooledDataSource pool = new ComboPooledDataSource();
	try {
		// 从连接池中获取一个连接对象
		// 借
		conn = pool.getConnection();
		// 获取传输器并执行sql语句
		// ?占位符不能代替表名，列名
		String sql = "select * from account where name like ?";
		// prepareStatement子类传输器
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%张%");
		rs = ps.executeQuery();
		while (rs.next()) {				
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double money = rs.getDouble("money");
			System.out.println(id+","+name+","+money);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		// 释放资源
		xxx.close();
	}
}
-------------------------------
tomcat
改服务器端口为80:
/conf/server.xml - <Connector port="80" protocol="HTTP/1.1"

/logs/ 错误日志
异常会有缩进

目录结构：
/bin/ .bat windows批处理文件 .s# linux下的批处理文件 的存放目录
/conf/ 配置文件的存放目录 server.xml是核心配置文件
/logs/ 运行期间产生的日志文件存放目录
/temp/ 临时文件存放位置
/work/ 运行时工作文件的存放目录
/webapps/ localhost虚拟主机默认管理目录，放在该目录下的web应用程序可以通过localhost主机进行访问

虚拟主机：
<Host name="localhost"  appBase="webapps"
	unpackWARs="true" autoDeploy="true">
</Host>
在tomcat服务器中可以配置多个站点，每一个站点都是一台虚拟主机

web应用：
简单说，就是一个目录，该目录包含了很多web资源（html,css,js,img,jsp,servlet等），组织起来的一个web应用。

虚拟主机包含web应用，web资源文件放在web应用中，不能直接在虚拟主机中放web资源文件

web应用目录结构：
web应用根目录/
	WEB-INF目录（受保护的目录，在该目录下的资源文件，不能被浏览器直接访问）/
		classes（存放java编译后的class文件）/
		lib（存放当前应用所需要的jar包）/
		web.xml（当前web应用的核心配置文件）
	除WEB-INF以外的其它目录（可以被浏览器直接访问）/

部署web应用到虚拟主机中：
将web应用的目录放在webapps下即可

未配置默认web应用之前：
访问xxx应用下的xxx.html路径为localhost/xxx/xxx.html

配置默认的web应用：
将web应用的名字改为ROOT
访问路径 localhost/xxx.html

配置web应用的主页：
没有配置主页前 访问路径 localhost/xxx.html
配置主页：
在web应用里/WEB-INF/web.xml文件中加上：
<welcome-file-list>
	<welcome-file>hello.html</welcome-file>// 会去根目录下找hello.html
</welcome-file-list>
可以设置多个备用主页

打war包：
将一个web应用中所有资源打成war包的好处：
1.便于传输，体积小
2.将war包传输到远程服务器上，服务器能够识别war格式，会自动解压发布
如何打war包：
进入web应用的根目录，选中所有文件，将所有文件打成zip包，再将后缀名改成war即可
-------------------------------
http协议：
规定浏览器和服务器通信的方式/规则
主要规定两个内容：
1.规定了浏览器如何给服务器发送请求信息（请求信息格式）
2.服务器如何给浏览器发送响应信息（响应信息格式）

遵循的基本原则：
1.一次请求对应一次响应
2.请求只能是浏览器发起，服务器只能等待请求做出回应

http请求：
1.请求行 GET /news/hello.html HTTP/1.1
2.若干请求（报）头
Host: localhost   -- 表示浏览器所请求的主机
Accept-Language: zh-CN   -- 通知服务器浏览器能接收的语言环境
3.请求实体内容
如果请求方式是GET提交, 请求实体一定没有内容, 是空的
如果请求方式是POST提交,并且请求中携带了数据给服务器, 请求实体才会有内容

http响应：
1.状态行 HTTP/1.1 200 OK
HTTP/1.1 响应信息所遵循的协议和版本
2.若干响应（报）头
Content-Type:text/html
Refresh:5;url=xxx/index.html 通知浏览器在多少秒之后跳转到指定的地址
3.响应实体内容
-------------------------------
servlet
sun公司提供的一门动态web资源开发技术
本质上是一段java程序
和普通的java程序不同的是：
servlet不能独立运行，必须放在服务器中，由服务器调用才可以执行

servlet作用：
1.浏览器向服务器发送请求，服务器负责接收请求
2.服务器将请求交给其中的某一个servlet，由servlet负责处理请求
3.在处理请求的过程中，servlet也负责连接并访问数据，并实现数据增删改查等操作
4.将请求处理的结果转发给jsp，由jsp负责展示给用户（响应给浏览器）

开发servlet程序的步骤：
1.写一个类，实现一个servlet接口（直接实现或间接实现）
2.在web应用的web.xml文件中添加Servlet相关的配置信息，将web应用发布到服务器中运行

运行Servlet程序、访问测试 一键访问
在运行的Servlet上点击右键 ---> "Run As" ---> "1 Run on Server"

通过Eclipse发布项目到tomcat，会把web项目发布到工作空间下\.metadata\...
F:\study\teduStudy\workspace2_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\day09

修改Eclipse默认发布项目位置，在tomcat服务器上双击，修改配置。修改前remove项目，clean服务器

Servlet继承关系
Servlet接口 Servlet接口定义了一个Servlet应该具备哪些功能
	GenericServlet类 实现了Servlet接口，并实现了接口中大部分方法，但其中service方法没实现，这个方法由开发人员实现
		HttpServlet抽象类（doGet和doPost不是抽象方法） 实现了service方法，在service中判断请求方式，如果是get则调doGet方法，如果是post请求则调doPost方法
			HelloServlet类 重写了doGet和doPost方法，分别处理get和post请求

以后只要继承HttpServlet类写servlet即可

servlet调用过程：
1.浏览器向服务器发送http请求
2.服务器中：
	根据请求中的Host头，获知浏览器访问的是哪一个虚拟主机
	根据请求行中的资源路径获知浏览器访问的是哪一个web应用及下具体资源
	根据获取到的资源路径到web.xml中匹配真实路径
	创建代表请求的Request对象和代表响应的Response对象，传入Servlet实例
3.服务器中的Servlet实例：
	通过request对象获取请求相关的信息
	Servlet实例通过请求的信息，经过处理按照http协议规定的方式组织成想要信息，再发送给浏览器

request和response简介
Request是表示Http请求信息的对象
Response是表示Http响应信息的对象

在服务器接收到浏览器的请求之后, 调用某一个Servlet的service方法之前, 服务器会创建代表请求的Request对象和代表响应的Response对象。将这两个对象传递给service方法，执行service来处理请求。

通过request对象可以获取请求相关的信息
通过response对象可以将响应数据发送给浏览器

获取请求参数：
浏览器向服务器发送的请求参数
请求参数是key-value结构

request提供的请求参数的方法：
String = request.getParameter(String name);
通过请求参数的名字，获取对应的参数值
String[] = request.getParameterValues(String name);
通过请求参数的名字，获取对应的所有参数值组成的数组

代码示例：获取请求中的用户名和爱好对应的参数值

请求参数乱码问题：
1.如果当前是tomcat8.0及以后版本，get提交的中文参数是没有乱码问题的，底层已经做了处理。如果8.0之前的版本，get也有乱码问题
解决办法：
在tomcat服务器安装目录下/conf/server.xml，在修改端口的Connector上加属性URIEncoding="utf-8"
2.post一直有乱码问题：
request.setCharacterEncoding("utf-8");

实现请求转发：
请求转发就是服务器内部资源跳转的一种方式
当浏览器发送请求访问服务器中的某一个资源A时，A没有对请求做出响应，而是将请求转交给了服务器内部的另一个资源B，由B对请求做出响应。
从资源A将请求转交给资源B，由资源B来做响应的过程就叫做请求转发。
实现请求转发：
request.getRequestDispatcher("/资源路径.jsp").forward(request,response)

请求转发特点：
1.转发前后地址栏地址没有发生变化
2.转发前后是一次请求，一次响应
3.转发前后的request对象是同一个，因此转发前后可以通过request域对象带数据到目的地。
4.转发前后的两个资源只能是同一个web应用中的资源，否则将无法实现跳转

作为域对象使用：
如果一个对象具有一个可以被访问的范围，利用该对象上提供的map集合，在这个范围内就可以实现资源的共享。
Request提供了存取数据的方法：
往request域中添加一个域属性
request.setAttribute(String attrName,Object attrValue);
通过属性名获取指定的属性值
request.getAttribute(String attrName);

request.getAttribute()获取的是一个Object，所以要向下强转

Request具备的三大特征：
1.生命周期：
一次请求开始时服务器创建Request对象，一次请求结束时服务器销毁Request对象
2.作用范围
一次请求范围内
3.主要功能
一次请求范围内实现数据的共享（通过转发将数据带往目的地）

1.通过jdbc查询数据库，返回数据
2.把数据存入request对象的map中
request.setAttribute("name",name);
3.通过转发将request对象（及map）带到jsp进行显示
request.getRequestDispatcher("/xx.jsp").forward(request,response)
转发的同时会将Servlet中的request对象（域对象）传递给jsp
4.jsp通过request.getAttribute("name")取数据

response对象：
1.向客户端发送数据
PrintWriter out = response.getWriter();
out.write("你好");
2.实现重定向
重定向和请求转发都可以实现资源的跳转
只不过转发只能是服务器内部同一个web应用内的资源之间的的跳转
而重定向没有该限制
实现请求重定向：
response.sendRedirect("资源的地址");
重定向的特点：
1.重定向前后两次请求，两次响应
2.重定向前后地址栏会发生变化
3.重定向前后的request对象不是同一个对象，因此就不能在重定向前后通过request域对象带数据到目的地
4.重定向前后的两个资源可以不是同一个web应用内部的资源
-------------------------------
jsp
jsp和servlet都是sun公司提供的动态web资源开发技术
jsp本质上是一个servlet，jsp第一次被访问时，会被翻译为一个servlet程序
为什么要有jsp：
既解决了servlet不适合向外输出一个完整的html网页，也解决了html无法展示动态数据的问题。

<% %> 语句
<%= %> 变量，会输出

html的执行过程：
当浏览器的地址栏中输入：xxx.com时，服务器会根据请求的路径去到xxx项目中寻找index.html，找到后直接将index.html文件内容响应给浏览器，由浏览器去解析并显示
html文件是不需要在服务器端执行
在tomcat服务器中提供了一个默认的servlet，当浏览器向服务器请求一个静态资源文件时，就会由这个默认的servlet处理。

jsp的执行过程：
当浏览器请求服务器中的xxx.jsp时，服务器会根据请求的路径去寻找xxx.jsp文件，如果找到就将这个jsp翻译为一个servlet程序，servlet程序再执行，返回一个html网页
访问JSP后看到的html网页，就是JSP翻译后的Servlet在向外输出

jsp语法：
模板元素：
java元素

jsp表达式：
格式:
<%= 表达式/变量/常量 %>

jsp脚本片段：
格式：
<% String name = "张三"; %>
<%= name %>
<% 
	for(int i=0;i<5;i++){
		out.write(i+"<br/>");
	}
%>
或：
<% for(int i=0;i<5;i++){ %>
		out.write("<br/>");
<% } %>

jsp注释：
<%-- 注释 --%>

jsp指令：
作用：不产生输出，用于指挥jsp解析引擎，如何翻译一个jsp
1.page指令
<%@ page 若干属性...%>
作用声明jsp页面的基本属性信息，比如jsp页面使用的编码，jsp页面使用的开发语言等

2.taglib指令
<%@ taglib 若干属性...%>
作用引入jsp标签库，比如在使用jstl标签库之前，需要在jsp文件中通过taglib指令引入jstl标签库

jsp的标签技术：
用来代替java代码，方便维护
el  ${}
jstl  标签库

el表达式
格式：
${常量，表达式，变量} 变量必须得事先存入域中
作用：主要作用是从域中获取数据并输出
1.用来获取常量，表达式，变量的值（变量必须先存入域中）
在EL中书写变量，会通过变量名依次到四个域（从小到大：pageContext,request,session,application）中去寻找指定名称属性值
${xxx} 代替 <%= request.getAttribute(xxx) %>
2.获取域中的数组或集合中的数据
String names[] = {"a","a","a"};
request.setAttribute("names",names);
${names}
3.获取域中的map集合中的数据
Map map = new HashMap();
map.put("name","aaa");
map.put("age",18);
request.setAttribute("map",map);
${map.name}
4.获取域中的JavaBean/Pojo中的数据
<%
	// 创建一个Account对象，并存入域中
	Account acc = new Account(1,"john",3000.0);
	request.setAttribute("account", acc);		
%>
${account.name}调的是getName()方法，和name属性名无关
${account.getName()}

jstl标签库：
在使用JSTL标签库前：
1.在项目中导入jstl的jar包
2.在使用jstl标签库的jsp中引入jstl标签库，通过taglib指令

JSTL标签库是为JavaWeb开发人员提供的一套标准通用的标签库；
JSTL标签库和EL配合使用取代JSP中大部分的Java代码；
常用标签：
1、<c:set></c:set> -- 往四大作用域中添加域属性，或者修改四大作用域中已有的属性
<c:set var="name" value='张三' scope='request'/>
${name}
<c:set var="name" value='张三丰' scope='request'/>
${name}
2、<c:if></c:if> -- 构造if…else…语句
<c:set var="score" value='79' scope='request'/>
<c:if test="${score>=80}">
	优秀
</c:if>
<c:if test="${score>=60 and score<80}">
	中等
</c:if>
<c:if test="${score<60}">
	不及格
</c:if>
3、<c:forEach></c:forEach> -- 对集合或数组等中元素进行循环遍历或者是执行指定次数的循环
数组、集合:
<%
	String names[] = {"a","a","a"};
	request.setAttribute("ns",names);
%>
<c:forEach items="${ns}" var='name'>
	${name}<br/>
</c:forEach>
map集合（map是无序的）：
<%
	Map map = new HashMap();
	map.put("name","aaa");
	map.put("age",18);
	map.put("addr","aaa");
	request.setAttribute("map",map);
%>
<c:forEach items="${map}" var='entry'>
	${entry}<br/>
	${entry.getKey()}:${entry.getValue()}<br/>
	${entry.key}:${entry.value}<br/>
</c:forEach>
遍历数值：
<c:forEach begin="0" end="100"
	var='i' step="1" varStatus='status'>
	<c:if test="${i%7==0}">
		${status.first?'':','}
		${i}
	</c:if>
</c:forEach>
-------------------------------
Maven
介绍
公共包管理工具，类似npm install -g：
一个项目管理工具，jar包管理，简化配置，统一项目结构

Maven坐标主要组成(GAV) -确定一个jar在互联网位置：
groupId：定义当前Maven组织名称
artifactId：定义实际项目名称
version：定义当前项目的当前版本

下载maven
配置maven
maven\apache-maven-3.5.3\conf\settings.xml
本地仓库位置：
<localRepository>F:/software/maven/repository</localRepository>
nexus私服
central中央服务器
下载镜像服务器位置（阿里云不能使用手机热点）：
<mirrors>
	<mirror>
		<id>aliyun</id>
		<name>aliyun Maven</name>
		<mirrorOf>*</mirrorOf>
		<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	</mirror>
</mirrors>
指定jdk版本：
<profile>
	<id>jdk-1.8</id>
	<activation>
	<activeByDefault>true</activeByDefault>
	<jdk>1.8</jdk>
	</activation>
	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
		<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
	</properties>
</profile>

Maven在Eclipse的配置：
window右键--> Preferences->maven->勾选Download Artifact Sources下源码->
installations=>add=>将自己安装的maven目录选中=>勾选上
user settings=>全局设置和用户设置选maven中的settings.xml=>
本地仓库位置选F:\software\maven\repository

Maven项目构建：
new Maven->Create a simple project->packaging:jar(java项目)/war(web项目)->
group id组织名称（com.xxx）->Artifact id项目名称->补充web.xml文件

导入已有maven项目：
1.复制src文件夹覆盖
2.在pom.xml文件中复制
properties版本号
dependencies依赖坐标
保存自动下载，不行就项目右击Update Project

在pom.xml中导入依赖：
1.右键maven->add dependency->搜索已有依赖
如搜索不到，打开maven视图，右键local repository,rebuild index。索引会被重建

2.在http://mvnrepository.com 或者公司镜像仓库搜索依赖坐标
-------------------------------
会话技术 客户端与服务端之间的交互，就是会话
概念：
浏览器和服务器之间产生的多次请求和响应，称为浏览器和服务器的会话。
从浏览器访问服务器开始，一直到浏览器关闭，访问服务器结束为止，这期间多次请求和响应组合在一起就是一次会话。
cookie，session本地存储

Cookie
1.在cookie中通过Set-Cookie响应头负责将数据从服务器发送给浏览器，让浏览器以cookie形式保存到内部
2.在cookie中，通过cookie请求头负责将cookie信息从浏览器带回服务器，给服务器使用
3.在cookie中是将会话产生的数据保存在客户端，是客户端技术

cookie的api
1.创建Cookie对象 指定cookie的名字和要保存的值
Cookie cookie = new Cookie(String name,String value);
2.将Cookie添加到response响应中
发送给浏览器，让浏览器保存到内部，可以调用多次addCookie方法，可以将多个cookie发送给浏览器
response.addCookie(Cookie cookie);
3.获取请求中的所有cookie对象组成的数组
如果请求中未携带cookie，返回null
Cookie[] cs = request.getCookies();
4.删除cookie
cookie的api中没有直接删除方法
创建一个同名cookie，并设置存活时间为0，发送cookie给浏览器
5.cookie的常用方法
cookie.getName() -- 获取cookie的名字
cookie.getValue() -- 获取cookie的值
cookie.setValue() -- 设置cookie的值
没有cookie.setName()
6.setMaxAge方法
cookie.setMaxAge() -- 设置cookie最大生成年龄 默认cookie在一次会话结束后立即销毁
cookie会以文件的形式保存在浏览器的临时文件夹中（硬盘上）

tomcat8.5之前 cookie中保存中文问题
在http协议中规定了，浏览器和服务器的交互数据，不能发送中文，要进行url编码

session 是服务器端临时本地存储 技术，浏览器没有
一次会话范围内，一个session对象  开关浏览器
1.session是一个域对象，可以通过session.setAttribute方法往session域中添加一个域属性 session.setAttribute("prod","小米手机");
2.String prod = (String)session.getAttribute("prod");
3.session是服务器端的一个对象，session是将数据保存在服务器端中，是服务器端技术

session是一个域对象
session.setAttribute(String name,Object value);
session.getAttribute(String name);

session具备的三大特征
1.生命周期：
创建session：
第一次调用request.getSession方法时
request.getSession();同request.getSession(true);// 有则返回已有的，无则建
request.getSession(false);// 有则返回已有的，无则返回null
销毁session：
a.超时销毁：30分钟未被访问销毁
b.自杀：当调用session的invalidate时，会立即销毁session
c.意外身亡：服务器非正常关闭，session销毁
反之，服务器正常关闭，session不会销毁，session对象会以文件形式保存到硬盘上，服务器work目录下，这个过程叫做session的系列化（钝化），当服务器再次启动时，session对象会再次恢复到服务器中，叫做session的反序列化（活化）。
2.作用范围：
整个会话范围内
3.主要功能：
整个会话范围内，实现数据的共享

总结：
cookie和session区别：
Cookie的特点：
保存在客户端，客户端技术
适合安全性要求不高, 但是需要长时间保存的数据。
Session的特点：
保存在服务器端，是服务器端技术
安全，短期的保存

java中添加cookie，
Cookie cookie = new Cookie("prod",prod);
一个cookie只能加入一个键值
response.addCookie(cookie);
依次添加入response中
取出cookies数组
Cookie[] cs = request.getCookies();遍历

java中添加session，
session域中添加属性
session.setAttribute("prod", prod);
放入session域中
取出session，按key取值
session.getAttribute("prod");
-------------------------------
int和Integer的区别：
Integer提供方法实现类型间转化

进程和线程：
进程：
计算机中的程序关于某数据集合上的一次运行活动，是系统进行资源分配和调度的基本单位，是操作系统结构的基础。
线程：
是操作系统能够进行运算调度的最小单位。它被包含在进程之中，是进程中的实际运作单位。一条线程指的是进程中一个单一顺序的控制流，一个进程中可以并发多个线程，每条线程并行执行不同的任务。

同一进程中的多条线程将共享该进程中的全部系统资源，如虚拟地址空间，文件描述符和信号处理等等。但同一进程中的多个线程有各自的调用栈（call stack），自己的寄存器环境（register context），自己的线程本地存储（thread-local storage）。

hashcode()和equals()的重要性：
Java中HashMap使用hashcode()和equals()来确定键值对的索引，当根据键获取值的时候也会用到这两个方法。如果没有正确使用这两个方法，两个不同的键可能会有相同的hash值，因此，可能会被集合认定为是相等的。而且，这两个方法也会用来发现重复元素。所以，这两个的实现对HashMap的精确性和正确性是至关重要的。

值传递和引用传递：
值传递：
做参数时会被复制，创建副本，函数中无法改变原始对象
引用传递：
做参数时不会被复制，不会创建副本，函数中可以改变原始对象
-------------------------------
.bin.tar.gz linux版本
.bin.zip windows版本

这种由编译器特别支持的包装称为装箱，所以当内置数据类型被当作对象使用的时候，编译器会把内置类型装箱为包装类。相似的，编译器也可以把一个对象拆箱为内置类型。Number 类属于 java.lang 包

jvm报错看 Caused by: 这一行

Class对象 为 字节码对象
-------------------------------
java方法的补充：
方法的可变参数 必须是最后一个参数
public class C {
	// 参数类型... 参数名
	private static void q(String... p) {// 同String[] p = {};
		// 传入的参数会组成一个数组p
		System.out.println(p);
		System.out.println(Arrays.toString(p));
	}
	public static void main(String[] args) {
		q("aqwa","aegra","ayjja","cvaa");
		q(new String[]{"scc","ayj","awd"});
	}
}
-------------------------------
垃圾回收机制：
1.System.gc();
2.jvm内存快不足时
gc会扫描磁盘对不可达（不被指向时）对象一一标记后，一次性回收
gc比较耗时，且会使系统中断？
回收时触发finalize() 方法

finalize() 方法 在实例对象被垃圾回收前调用，类似钩子
public class E {
	public static void main(String[] args) {		
		Z z1 = new Z(1);
		Z z2 = new Z(2);
		z1=z2=null;
		System.gc();// 建议垃圾回收
	}
}
class Z{
	private int id;
	public Z(int id) {
		this.id = id;
		System.out.println("实例"+id);
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		// 回收前调用，类似钩子
		System.out.println("实例"+id+"被回收");
	}
}
-------------------------------
Java 泛型
泛型方法 该方法在调用时可以接收不同类型的参数
// 泛型方法 printArray
public static <E> void printArray(E[] inputArray) {
	// 输出数组元素
	for (E element : inputArray) {
		System.out.printf("%s ", element);
	}
	System.out.println();
}
public static void main(String args[]) {
	// 创建不同类型数组： Integer, Double 和 Character
	Integer[] intArray = { 1, 2, 3, 4, 5 };
	Double[]有界doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
	
	System.out.println("整型数组元素为:");
	printArray(intArray); // 传递一个整型数组
	System.out.println("\n双精度型数组元素为:");
	printArray(doubleArray); // 传递一个双精度型数组
	System.out.println("\n字符型数组元素为:");
	printArray(charArray); // 传递一个字符型数组
}

泛型类
public class Box<T> {
	private T t;
	public void add(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		integerBox.add(new Integer(10));
		stringBox.add(new String("啊啊啊"));
		System.out.printf("整型值为 :%d\n\n", integerBox.get());
		System.out.printf("字符串为 :%s\n", stringBox.get());
	}
}

类型通配符
List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类

规定参数泛型上限
List<? extends Number> data 限定了参数泛型上限为Number
此List里只能接受Number及其下层子类类型

类型通配符下限
通过形如 List<? super Number>来定义，表示类型只能接受Number及其三层父类类型，如 Object 类型的实例

泛型作用：
1.灵活传参
2.后续不用强转

泛型接口
interface Container<T>{
	void add(T t);
	T get(int indexs);
}
类继承泛型接口时：两种写法
1.给接口传参，类不用泛型了
class AbsContainer implements Container<String>{
	void add(String t);// t是String类型
	String get(int indexs);
}
2.不给接口传参，类后面也得写泛型<T>
class AbsContainer<T> implements Container<T>{
	void add(T t);
	T get(int indexs);
}
另：此时String会被看做泛型，而不是类型
class AbsContainer<String> implements Container<String>{
	void add(String t);// t不是String类型
	String get(int indexs);
}

应用举例：
1.String类型的map对象
class StringMap extends HashMap<String,String>{}
2.key是String，值不确定，此时可以用泛型
class StringMap<V> extends HashMap<String,V>{}

单泛型
interface Container<T>{
	void add(T t);
	T get(int indexs);
}
多泛型，有两个泛型参数
interface Task<Param,Result>{
	Result execute(Param arg1);
}

泛型常用方式三种：
1.泛型类
class A<T,...>{}
2.泛型接口
interface A<T,...>{}
3.泛型方法
访问修饰符 <T> 返回值类型 A(参数,...){}

类泛型仅作用于实例，不作用于静态方法

泛型方法：
class MybatisSession{
	// 方法返回值有泛型
	public <T> T newInstance(Class<T> cls){}
	<T> T selectList(String sql){}
	public static <T> void sort(List<T> List){}
}

泛型方法避免强转示例：
// 未用泛型
class ObjectFactory{
	public Object newInstance(Class<?> cls)
}
public class Test{
	...main(){
		ObjectFactory of = new ObjectFactory();
		Date obj=(Date)of.newInstance(Date.class);//需要强转
	}
}
// 用了泛型
class ObjectFactory{
	public <T> T newInstance(Class<T> cls)
}
public class Test{
	...main(){
		ObjectFactory of = new ObjectFactory();
		Date obj=of.newInstance(Date.class);//不需要强转
	}
}

泛型通配符?
代表一种任意的参数类型（实参类型）

上边界 -String- CharSequence
传入必须是CharSequence的子类
List<? extends CharSequence> list = new ArrayList<String>();

下边界 Integer -Number-
传入必须是Integer的父类
List<? super Integer> list = new ArrayList<Number>();

List<Object> list = new ArrayList<String>(); 错
String或者Class等等是放不入Object泛型中的
问号?可以
List<?> list = new ArrayList<String>(); 对
或者指定上界
List<? extends Object> list = new ArrayList<String>(); 对

泛型是编译类型，运行时无效，运行时都会变成Object
泛型擦除（规避泛型）
例子：
1.List<String> 放入100
List<String> list = ArrayList<>();
list.add(100);// 加不了
思路用反射，因为反射在运行时执行，绕过泛型的编译检查
Class<?> cls = list.getClass();
Method method = cls.getDeclaredMethod("add",Object.class);
method.invoke(list,100);
// 这就将100放入了list

2.List<String> 100放在第一个位置
...
Method method = cls.getDeclaredMethod("add",int.class,Object.class);
method.invoke(list,0,100);

泛型警告擦除
定义时有泛型，应该写Class<?>
省略<?>会有警告，写@SuppressWarnings("rawtypes/unchecked");忽略警告
Class cls = List.getClass();

数组不支持泛型
Object[] array = new Object[]{1,2}; //对
T[] array = new T[]{1,2}; //错，不能这么写
-------------------------------
mvc设计模式
通用软件编程思想：
c 控制程序流转的控制器 SpringMVC
m 封装数据处理数据的模型 Spring(service),MyBatis(Dao)
v 数据展示的视图 
mvc设计思想：相互独立，互不干扰
好处：结构清晰，可读性强，利于扩展、维护和代码复用

老模式：
JavaBean:符号规范的java类
实体Bean：pojo，用于封装数据
业务Bean：处理业务逻辑

Servlet（Controller）：负责获取请求中携带的数据（如果有），调用JavaBean的方法来处理请求，调用jsp展示结果
JavaBean（Model）:封装数据以及处理业务逻辑（请求），连接并访问数据库
Jsp（View）:负责响应结果

ssh(Struts2有漏洞,Spring,Hibernate自动生成sql语句不够灵活)
ssm(SpringMVC,Spring,MyBatis)

Spring MVC设计模式
对servlet进行了封装
Springmvc是spring框架的一个模块
spring和springmvc无需中间整合层整合
-------------------------------
mybatis框架
本是apache的一个开源项目iBatis
Mybatis对JDBC访问数据库的过程进行了封装，简化了JDBC代码，解决JDBC将结果集封装为Java对象的麻烦

MyBatis是一个优秀的持久层框架，它对jdbc的操作数据库的过程进行封装，
使开发者只需要关注 SQL 本身，
而不需要花费精力去处理例如注册驱动、创建connection、创建statement、手动设置参数、结果集检索等jdbc繁杂的过程代码。
-------------------------------
Spring 框架
1.方便解耦
2.aop面向切面编程的支持
3.声明式事务的支持
4.方便集成各种优秀框架
5.降低Java EE API的使用难度，如对JDBC，JavaMail，远程调用等提供了简便封装
Spring的本质是管理软件中的对象，即创建对象和维护对象之间的关系

ioc 控制反转
不用自己new对象，交给bean创建

Spring DI依赖注入
在创建对象的同时，给对象赋值

Spring的本质是管理软件中的对象，即创建对象和维护对象之间的关系

类不交给spring管理
A.java
public class A{
	...
}
B.java b方法中用A对象
public class B{
	b(){
		...
		xxx(new A());
		...
	}
}

类交给spring管理
A.java
@Component
public class A{
	...
}
B.java b方法中用A对象
public class B{
	@Autowired
	private A a;
	b(){
		...
		xxx(a);//即可
		...
	}
}
-------------------------------
mybatis
1.src/main/resources/mybatis-config.xml(mybatis配置文件，可引用jdbc.properties变量)
<environments>配置开发环境，
<transactionManager>配置事务管理方式，
<dataSource>配置数据源
<mappers>sql语句映射，指向XxxMapper.xml

2.src/main/java/com.tedu.mybatis/MyBatis.java
// 读取配置文件
InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
// 通过配置信息获取SqlSessionFactory工厂对象
SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
// 通过工厂获取SqlSession对象
session = fac.openSession();
@Test
public void testFindById() {
	// SqlSession对象接收XxxMapper接口类，反射生成实例
	EmpMapper mapper = session.getMapper(XxxMapper.class);	
	// 调实例方法，到XxxMapper接口中添加一个对应的方法	
	Emp emp = mapper.findById(4);
	// 改的话session.commit();
}

3.src/main/java/com.tedu.dao/XxxMapper.java
public interface XxxMapper {		
	// findById方法，注意参数和返回值
	public Emp findById(Integer id);
}

// 到XxxMapper.xml中添加一条sql语句
// <select>或<update>
<select resultType="com.tedu.pojo.Xxx" id="wayA">查询
<update id="wayB">增删改
4.src/main/resources/XxxMapper.xml
占位符 #{}有引号变量类似? ${}无引号变量
// id为接口方法名
<select id="findById" resultType="com.tedu.pojo.Xxx">
	select * from emp where id=#{id}
</select>

// pojo基本类
5.src/main/java/com.tedu.pojo/Xxx.java

6.加入log4j.properties日志框架
mybatis日志输出工具
配置好了，会自动加载使用
-------------------------------
spring
// 创建实体类
1.src/main/java/com.tedu.pojo/User.java
src/main/java/com.tedu.pojo/UserInfo.java

// spring配置文件
2.src/main/resources/applicationContext.xml
<beans>
	// 此处为spring容器，由容器创建实例
	// 默认单实例singleton，scope="prototype"多实例
	// 当对象有会改变的状态时，使用多实例，否则单实例
	// <bean id="User" class="com.tedu.pojo.User" scope="prototype">
	<bean id="User" class="com.tedu.pojo.User">
		<!-- 依赖注入2种方式 -->
		<!-- set方法注入 -->
		<property name="name" value="哈罗"></property>
		<property name="info" ref="userInfo"></property>
		<!-- 构造方法注入，spring大部分 -->
		<constructor-arg name="name" value="马云"></constructor-arg>
		<constructor-arg name="info" ref="userInfo"></constructor-arg>
	</bean>
	<bean id="userInfo" class="com.tedu.pojo.UserInfo"></bean>
</beans>

3.src/main/java/com.tedu.test/TestSpring.java
@Test
public void testIOC() {
	// 1.读取Spring的核心配置文件
	ClassPathXmlApplicationContext ac = 
	new ClassPathXmlApplicationContext("applicationContext.xml");
	// 2.通过Spring容器获取User类的实例
	User u = (User)ac.getBean("user");
	System.out.println(u);// 实例已有值
}
-------------------------------
springmvc
Springmvc是spring框架的一个模块，spring和springmvc无需中间整合层整合
Springmvc是一个基于mvc的web框架

c控制器：接收请求，调用业务类，派发页面
m模型：service，dao，pojo，返回处理结果
v视图：视图渲染

1.在web.xml中配置springmvc
<!-- 配置springmvc前端控制器, 将所有请求交给springmvc来处理 -->
<servlet>
	<servlet-name>springmvc</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>	
	<!-- 配置springmvc核心配置文件的位置，默认Springmvc的配置文件是在WEB-INF目录下，默认的名字为springmvc-servlet.xml，如果要放在其他目录，则需要指定如下配置：
	-->
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:springmvc-config.xml</param-value>
	</init-param>		
</servlet>
<!-- 其中的斜杠（/）表示拦截所有请求（除JSP以外）, 所有请求都要经过springmvc前端控制器 -->
<servlet-mapping>
	<servlet-name>springmvc</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
<!-- 处理post提交的中文参数乱码问题 -->
<filter>
	<filter-name>encodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF8</param-value>
	</init-param>
</filter>
<filter-mapping>
	<filter-name>encodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>

// springmvc 配置文件
2.src/main/resources/springmvc-config.xml
<beans>
	<!-- 1.配置前端控制器放行静态资源(html/css/js等，否则静态资源将无法访问) -->
	<mvc:default-servlet-handler />
	<!-- 2.配置注解驱动，用于识别注解（比如@Controller） -->
	<mvc:annotation-driven></mvc:annotation-driven>
	<!-- 3.配置需要扫描的包：spring自动去扫描 base-package 下的类， 如果扫描到的类上有 @Controller、@Service、@Component等注解，将会自动将类注册为bean，
	将对象的创建交给Spring容器 -->
	<context:component-scan
		base-package="com.tedu.controller">
	</context:component-scan>
	<!-- 4.配置内部资源视图解析器 prefix:配置路径前缀 suffix:配置文件后缀 -->
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/pages/" />
		<property name="suffix" value=".jsp" />
	</bean>
</beans>

3.src/main/java/com.tedu.controller/HelloController.java
/**
 * @Controller的作用：表示当前类属于Controller层，Controller方法用于处理请求
 */
@Controller
public class HelloController {
	/*
	 *@RequestMapping("/hello")作用：映射路径和当前方法的对应关系
	 *访问 主机名/项目名/hello 时，执行该方法
	 */
	@RequestMapping("/hello")
	public String testHello(User user,Model model) {// 自动获取请求参数
		System.out.println(user);
		model.addAttribute("user",user);// model，Controller层和jsp的共享域
		return "home";// 访问home路径，如果匹配到方法执行，匹配到jsp跳转
		return "forward:/hello";// 请求转发（一个来回）
		return "redirect:/hello";// 重定向（两个来回）
	}
	/**
	 * 向浏览器响应json数据
	 * */
	@RequestMapping("/testJson")
	@ResponseBody
	public List<User> testJson() {
		List<User> list = new ArrayList();
		User u1 = new User("张飞",20,"北京");
		User u2 = new User("刘备",22,"河北");
		list.add(u1);
		list.add(u2);
		// 将User对象的集合以json格式响应给浏览器
		return list;
	}
	/* 自定义日期转换格式 */
	@InitBinder // 用于指定自定义的日期转换格式
	public void InitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
-------------------------------
spring+mybatis+springmvc 框架整合 ssm

spring
// 创建实体类
1.src/main/java/com.tedu.pojo/User.java
src/main/java/com.tedu.pojo/UserInfo.java

// spring配置文件
2.src/main/resources/spring/applicationContext.xml
// jdbc properties文件
src/main/resources/jdbc.properties
<!-- 1.加载jdbc.properties文件的位置 -->
<context:property-placeholder location="classpath:jdbc.properties" />
<!-- 2.配置druid连接池 ，id是固定值，class是druid连接池类的全路径 -->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
	<!-- 配置连接数据库的基本信息 -->
	<property name="driverClassName" value="${db.driverClassName}"></property>
	<property name="url" value="${db.url}"></property>
	<property name="username" value="${db.username}"></property>
	<property name="password" value="${db.password}"></property>
</bean>
<!-- 3.整合spring和mybatis框架 将SqlSession等对象的创建交给Spring容器 id值(sqlSessionFactory)是固定值 -->
<bean id="sqlSessionFactory"
	class="org.mybatis.spring.SqlSessionFactoryBean">
	<!-- 3.1.指定mybatis核心配置文件的位置 -->
	<property name="configLocation" value="classpath:mybatis/mybatis-config.xml"></property>
	<!-- 3.2.配置连接池(数据源) ref指向连接池bean对象的id值 -->
	<property name="dataSource" ref="dataSource"></property>
	<!-- 3.3、扫描所有的 XxxMapper.xml映射文件，读取其中配置的SQL语句 -->
	<property name="mapperLocations" value="classpath:mybatis/mapper/*.xml" />
</bean>
<!-- 4、定义mapper接口扫描器
	配置所有mapper接口所在的包路径，将来由spring+mybatis框架来为接口提供实现类，
	以及实现类的实例也由spring框架来创建 -->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	<!-- 扫描所有XxxMapper接口，将接口实例的创建交给spring容器 -->
	<property name="basePackage" value="com.tedu.dao" />
</bean>
<!-- 5.配置需要扫描的包(service层)：spring自动去扫描 base-package下的类， 如果扫描到的类上有 @Controller、@Service、@Component等注解，将会自动将类注册为bean（即由spring创建实例） -->
<context:component-scan base-package="com.tedu.service"></context:component-scan>

// mybatis核心配置文件
3.src/main/resources/mybatis/mybatis-config.xml
<configuration>
	<!-- 已在spring的配置文件中配置 -->
</configuration>

// 写mybatis的接口类
4.src/main/java/com.tedu.dao/XxxMapper.java
public interface XxxMapper {		
	// findById方法，注意参数和返回值
	public Emp findById(Integer id);
}

// 扫描mybatis的XxxMapper.xml映射文件，读取其中配置的SQL语句
5.src/main/resources/mybatis/mapper/XxxMapper.xml
// 到XxxMapper.xml中添加一条sql语句
// <select>或<update>
<select resultType="com.tedu.pojo.Xxx" id="wayA">查询
<update id="wayB">增删改
占位符 #{}有引号变量类似? ${}无引号变量
// id为接口方法名
<select id="findById" resultType="com.tedu.pojo.Xxx">
	select * from emp where id=#{id}
</select>

// 加入log4j.properties日志框架
6.src/main/resources/log4j.properties
mybatis日志输出工具
配置好了，会自动加载使用

7.在WEB-INF/web.xml中配置springmvc
<!-- 配置springmvc, 将所有请求交给springmvc来处理 -->
<servlet>
	<servlet-name>springmvc</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<!-- 配置springmvc核心配置文件的位置，默认Springmvc的配置文件是在WEB-INF目录下，默认的名字为springmvc-servlet.xml，如果要放在其他目录，则需要指定如下配置： -->
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:spring/*.xml</param-value>
	</init-param>
</servlet>
<!-- 其中的斜杠（/）表示拦截所有请求（除JSP以外）, 所有请求都要经过springmvc前端控制器 -->
<servlet-mapping>
	<servlet-name>springmvc</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
<!-- 乱码处理过滤器，处理post提交的中文参数乱码问题 -->
<filter>
	<filter-name>encodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<!-- 指定编码集 -->
	<init-param>
		<param-name>encoding</param-name>
		<param-value>utf-8</param-value>
	</init-param>
</filter>
<filter-mapping>
	<filter-name>encodingFilter</filter-name>
	<!-- 指定拦截方式为拦截所有请求 -->
	<url-pattern>/*</url-pattern>
</filter-mapping>

// springmvc 配置文件
8.src/main/resources/spring/springmvc-config.xml
<beans>
	<!-- 1.配置前端控制器放行静态资源(html/css/js等，否则静态资源将无法访问) -->
	<mvc:default-servlet-handler />
	<!-- 2.配置注解驱动，用于识别注解（比如@Controller） -->
	<mvc:annotation-driven></mvc:annotation-driven>
	<!-- 3.配置需要扫描的包：spring自动去扫描 base-package 下的类， 如果扫描到的类上有 @Controller、@Service、@Component等注解，将会自动将类注册为bean，
	将对象的创建交给Spring容器 -->
	<context:component-scan
		base-package="com.tedu.controller">
	</context:component-scan>
	<!-- 4.配置内部资源视图解析器 prefix:配置路径前缀 suffix:配置文件后缀 -->
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/pages/" />
		<property name="suffix" value=".jsp" />
	</bean>
</beans>

// service层文件接口
9.src/main/java/com.tedu.service/DoorService.java 
public interface DoorService {
	/**
	 * 根据id查询门店信息
	 */
	public Door findById(Integer id);
}

// service层文件实现类
10.src/main/java/com.tedu.service/DoorServiceImpl.java
/**
 * @Service的作用：表示当前类属于Service层，Service层对数据操作，增删改查，事务控制
 */
 /* spring会扫描service包下的所有类
 * 将类上带有@Service注解的类, 自动注册到spring容器中, 即由spring创建该类的实例*/
@Service 
public class DoorServiceImpl implements DoorService {
	/*
	 * @Autowired（自动装配）将当前对象的创建交给spring容器，
	 * 反射创建DoorMapper实例对象，赋给doorMapper变量
	 * */
	@Autowired
	DoorMapper doorMapper;
	@Override
	public Door findById(Integer id) {
		Door door = doorMapper.findById(id);
		return door;
	}
}

// controller层文件
11.src/main/java/com.tedu.controller/DoorController.java
/**
 * @Controller的作用：表示当前类属于Controller层，Controller层用于处理请求，获取* 前端参数，处理前端参数，返回service处理后的数据
 */
@Controller
public class DoorController {
	/*
	 * @Autowired（自动装配）将当前对象的创建交给spring容器，
	 * 反射创建DoorService实例对象，赋给doorService变量
	 * */
	@Autowired
	private DoorService doorService;
	 /*
	 *@RequestMapping("/doorInfo")作用：映射路径和当前方法的对应关系
	 *访问 主机名/项目名/doorInfo 时，执行该方法
	 */
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id,Model model) {// 自动获取请求参数
		// 根据id查询门店信息
		Door door = doorService.findById(id);
		// 将门店对象存入model中
		model.addAttribute("door",door);// model，Controller层和jsp的共享域
		// 转发到门店页面进行数据回显
		return "door_update";// 路径是doorInfo，jsp文件名就是door_info
		// "forward:/xxx";// 请求转发（一个来回）
		// "redirect:/xxx";// 重定向（两个来回）
	}	
}
src/main/java/com.tedu.controller/PageController.java
@Controller
public class DoorController {
	/**
	 * 通用的页面跳转方法 优先级低
	 * /{pageName}会接收浏览器/后面的值
	 * @PathVariable 会将/{pageName}值赋值给形参pageName再返回
	 * */
	// 作用：由于优先级低，/xxx会在Controller中没有同名方法时，自动跳转/xxx的jsp页面
	@RequestMapping("/{page}")
	public String page(@PathVariable String page) {
		return page;
	}
}

除了pojo和interface不用@Xxx注释，
Controller类和ServiceImpl类开头都要加@Xxx注释

mvc流程：
Door(pojo实体类) =>
DoorController(匹配请求，接收处理前端参数，返回service结果) =>
DoorService(service接口) =>
DoorServiceImpl(service实现类，对数据操作，增删改查，事务控制) =>
DoorMapper(DoorMapper接口) =>
DoorMapper.xml(对应Mapper接口的sql语句)
door_update.jsp(数据显示页面)
-------------------------------
双亲委派机制
先去最顶层看有没有此类，有就最顶层加载，没有往下，直到AppClassLoader自己加载

AppClassLoader 和 ExtClassLoader extends ClassLoader(abstract)

BootStrapClassLoader没继承ClassLoader，自己c++写的

AppClassLoader.classLoader = ExtClassLoader;

AppClassLoader 和 ExtClassLoader组合关系

自定义加载器
XxxClassLoader extends ClassLoader(abstract)

作用：
1.保证基类安全性，基类只由基类加载器加载
2.不会重复加载

缺点：
1.效率影响

打破双亲委派机制：
重写loadClass方法

打破双亲委派必要性：
1.
BootStrapClassLoader加载jdbc的Connection类
Connection的实现类由AppClassLoader加载
所以父类得委托子类加载

2.
加密

3.
热替换
-------------------------------
延迟加载，懒加载
方法：
1.通过静态内部类
访问类的静态方法时，静态内部类不加载

针对：
大对象
-------------------------------
类加载：
1.使用类加载器直接加载
2.构建本类或这个类的子类对象时
3.访问类中成员时(包含属性和方法)，但也有特殊情况，static final 修饰的（基本数据和String）成员变量

静态代码块的执行：
class ClassC{
	static {
		System.out.println("ClassC");
	}
}
class ClassCC extends ClassC{
	static {
		System.out.println("ClassCC");
	}
}
//-XX:+TraceClassLoading
public class TestClassObject06 {
    public static void main(String[] args) {
		int a=ClassCC.c;
	}
}
// 输入ClassC
父类ClassC是主动执行，执行静态代码块
子类ClassCC是被动执行，不执行静态代码块
-------------------------------
{} 实例代码块
每次创建对象前会执行，在构造函数前
-------------------------------
jvm参数
最大堆:-Xmx10m
最小堆:-Xms10m 
对象逃逸分析:-XX:+DoEscapeAnalysis 
输出GC信息:-XX:+PrintGC
-Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
-------------------------------
Java中对象的引用方式
1)强引用
Object o1=new Object();

2)弱引用(WeakReference<T>) 只要有GC时,弱引用引用的对象就会被回收。
WeakReference<ClassB> wr = new WeakReference<ClassB>(new ClassB());
wr.get();// 取对象

3)软引用(SoftReference<T>) 内存不足时（full gc）,软引用引用的对象自动被回收。
SoftReference<ClassB> sr = new SoftReference<ClassB>(new ClassB());
wr.get();// 取对象

4)虚引用(PhantomReference<T>) 当对象被回收时,可以得到通知。
-------------------------------
ThreadLocal 对象 线程内部单例
 * 此对象提供了一种线程绑定机制
 * 将某个对象绑定到当前线程，也可以从当前线程获取某个对象。
 * 借助此对象可以实现线程内部单例。
 * 一个线程共用一个对象
 * 实现未加锁、未每次方法生成一个对象，实现线程安全且占较少内存方法
例子：
private static ThreadLocal<SimpleDateFormat> td=
new ThreadLocal<SimpleDateFormat>() {
	//当从当前线程获取SimpleDateFormat对象时
	//假如当前没有此对象，则调用initialValue方法
	//创建对象，并将对象绑定到当前线程。
	@Override
	protected SimpleDateFormat initialValue() {
		System.out.println("initialValue()");
		return new SimpleDateFormat("yyyy-MM-dd");
	}
};
public static String format(Date date) {
	//从当前线程获取SimpleDateFormat 
	SimpleDateFormat sdf=td.get();
	return sdf.format(date);
}
-------------------------------
LinkedHashMap的removeEldestEntry方法
重写removeEldestEntry，返回true时，当put进新的值会移除该map中最老的键和值。

LinkedHashMap<Object, Object>(size, .75F, true);
第三个参数false，基于插入删除，true基于访问删除

每次keyMap.put(key, key);时触发内部removeEldestEntry方法，参数为新增的键值对
-------------------------------
mybatis进阶
1.依赖：
mysql-connector-java 8.0.17
mybatis 3.5.2
junit 4.12

2.mybatis核心配置 xml方式配置
src/main/resources/mybatis-configs.xml
头...
<configuration>
	<!-- 开发环境 -->
	<environments default="development">
		<environment id="development">
			<!-- 事务处理JDBC -->
			<transactionManager type="JDBC" />
			<!-- 数据源：mybatis自带连接池，PooledDataSource -->
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.cj.jdbc.Driver" />
				<property name="url"
					value="jdbc:mysql:///database?serverTimezone=GMT%2B8" />
				<property name="username" value="root" />
				<property name="password" value="root" />
			</dataSource>
		</environment>
	</environments>
	<mappers>
		<mapper resource="mapper/GoodsMapper.xml"></mapper>
	</mappers>
</configuration>

3.测试类 用xml构建SqlSessionFactory
src/test/java/包/TestBaseWithXml.java
public class TestBaseWithXml {	
	//此对象创建SqlSession(通过此对象 实现与数据库之间的会话)
	protected SqlSessionFactory sqlSessionFactory;	
	@Before//此方法在@Test注解修饰的方法之前执行, 通常用于做一些初始化操作
	public void init() throws IOException {
		//mybatis中对象Resources
		//InputStream流对象
		InputStream in = Resources.getResourceAsStream("mybatis-configs.xml");
		//SqlSessionFactory对象
		//接口：SqlSessionFactory
		//接口实现类：DefaultSqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		System.out.println(sqlSessionFactory);
	}
	@Test
	public void testSqlSessionConnection() {
		SqlSession session = sqlSessionFactory.openSession();
		//接口：SqlSession
		//接口实现类：sqlSessionFactory.openSession();
		//如何看接口的实现类：DefaultSqlSession
		//1.session.getClass()
		//2.在那行打断点 Debug As 鼠标移到session上
		//DefaultSqlSession默认autoCommit=false，需要手动提交事务
		Connection conn = session.getConnection();
		System.out.println(conn);
	}
}
参照SqlSessionFactory和SqlSession对外提供接口，对内自己写实现

4.pojo类
src/main/java/pojo包/Goods.java
public class Goods implements Serializable{
	private static final long serialVersionUID = -6842819582290804587L;
	private Long id;
	private String name;
	private String remark;
	private Date createdTime;
	setter/getter/toString...
}

5.映射文件mapper.xml
src/main/resources/mapper/GoodsMapper.xml
头...
<mapper namespace="com.cy.pj.goods.dao.GoodsDao">
	<select id="findPageObjects" resultType="com.cy.pj.goods.pojo.Goods">
		select *
		from tb_goods
		limit #{startIndex},#{pageSize}
	</select>	
	<!--系统底层会将每个元素封装为一个 MappedStatement对象(映射语句对象) -->
	<insert id="insertObject">
		insert into tb_goods
		(id,name,remark,createdTime)
		values
		(#{id},#{name},#{remark},now())
	</insert>
</mapper>

6.测试类 
src/test/java/包/TestGoodsDao01.java
public class TestGoodsDao01 extends TestBaseWithXml {
	//直接通过xml，session.selectList(statement,map);
	@Test// 单元测试方法不能有参数、返回值、private修饰，否则No tests异常
	public void testFindPageObjects01() { 
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();//openSession没有创建连接
		//2.执行删除操作
		String statement="com.cy.pj.goods.dao.GoodsDao.findPageObjects";
		try {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("startIndex", 0);
			map.put("pageSize", 3);
			//List<Goods> list=session.selectList(statement,new Object[]{0,3}); 
			//sql中limit #{array[0]},#{array[1]}
			List<Goods> list=session.selectList(statement,map);//业务方法时才创建的连接
			//sql中limit #{startIndex},#{pageSize}。map中的kay，或者pojo中的getXxx()
			System.out.println(list);
			//3.提交事务
			session.commit();//connection.commint，真正commit的是connection对象
			//4.释放资源
		}finally {
			session.close();//把连接放入连接池
		}
	}
	//通过接口，session.getMapper(GoodsDao.class);
	@Test
	public void testFindPageObjects02() { 
		//1.获取session对象
		SqlSession session = 
		sqlSessionFactory.openSession();
		try {
			//2.执行删除操作
			//有了接口的方法，1.不用手动提供全路径，2.创建map对象
			GoodsDao gDao=session.getMapper(GoodsDao.class);
			List<Goods> list=gDao.findPageObjects(0, 3);
			System.out.println(list);
			//3.提交事务
			session.commit();//connection.commint
			//4.释放资源
		}finally {
			session.close();
		}
	}	
}

7.dao接口
src/main/java/包/GoodsDao.java
public interface GoodsDao {//接口的包+接口名要=mapper.xml中的namespace
	//简单sql，不用mapper映射文件，接口中用注解也行
	@Select("select count(*) from tb_goods")
	int getRowCount();

	//List<Goods> findPageObjects(
	//	@Param("startIndex") int startIndex,
	//	@Param("pageSize") int pageSize
	//);
	//对应的xml：list #{arg0},#{arg1}
	List<Goods> findPageObjects(
		@Param("startIndex") int startIndex,
		@Param("pageSize") int pageSize
	);
	//对应的xml：limit #{startIndex},#{pageSize}
}

dao接收从service的参数：
1.如果只有一个参数，不用写@Param()
2.如果有多个参数，得写@Param("xxx")
使得mapper.xml中可以使用#{xxx}名字调用，不然只能用#{arg1}调用

8.测试类 不用xml构建SqlSessionFactory，用java构建SqlSessionFactory
src/test/java/包/TestBaseWithJava.java
public class TestBaseWithJava {
    protected SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() {
		//1.构建数据源对象
		PooledDataSource dataSource=new PooledDataSource();
		dataSource.setDriver("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///dbgoods?serverTimezone=GMT&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//2.创建事务管理工厂
		JdbcTransactionFactory transactionFactory=new JdbcTransactionFactory();
		//3.创建一个环境对象
		Environment env=new Environment("development",transactionFactory, dataSource);
		//4.创建配置对象
		Configuration config=new Configuration(env);
		//注册Dao
		config.addMapper(GoodsDao.class);
		//5.创建sqlSessionFactory对象
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(config);
	}
	@Test
	public void testConnection(){
		Connection conn=sqlSessionFactory.openSession().getConnection();
		System.out.println(conn);
	}
}
-------------------------------
spring原理
IOC控制反转
.class->BeanFactory->Bean
资源整合源于IOC模块，IOC要实现对象生命周期的管理
创建对象，销毁对象

xml配置
ClassPathXmlApplicationContext读spring-config.xml
<bean class="">
注解配置
AnnotationConfigApplicationContext读SpringConfig.java
@ComponentScan("com.spring")

spring IOC应用原理分析
控制反转，谁控制谁，控制权的变化
解耦方式：
1.耦合于接口
2.耦合于工厂
spring中耦合于工厂BeanFactory
对象与对象之间耦合于接口

spring Bean工厂的初始化
1.基于xml方式
2.基于注解方式

spring中两大map对象
1.一个用来存储Bean的配置信息
2.一个用来存储Bean的实例信息

Bean对象的创建
1.未实现FactoryBean接口（直接构造方法）
2.实现FactoryBean接口（调用FactoryBean对象的getObject方法），如myBatis的SqlSessionFactoryBean

两大bean对象的描述方式
1.xml <bean id="xx" class="xx.xx">
2.注解@Xxxx
@Component:
	@Bean描述方法，第三方资源
	@Controller修饰控制层
	@Respository修饰数据层
	@Service修饰业务层
	@Configuration:

spring中Bean对象的依赖注入DI
通过set方法、构造方法为对象属性赋值的过程
1.手动方式
2.反射方式，自动依赖注入

主线程（producer生产者）分配任务到容器队列中
工作线程（consumer消费者）从容器中取

比如：
service耦合于dao层的接口，但是注入的是dao层的实现
接口是稳定的

bean对象依赖注入实践
@Autowired原理：

1.Cache接口
src/main/java/com.cy.spring.beans/Cache.java
public interface Cache {

}

2.让DefaultCache继承Cache接口
src/main/java/com.cy.spring.beans/DefaultCache
@Lazy
@Component
public class DefaultCache implements Cache{
	 public DefaultCache() {
		 System.out.println("DefaultCache()");
	 }
	 //生命周期方法
	 @PostConstruct //告诉spring 此对象初始化后执行init方法
	 public void init() {
		 System.out.println("init()");
	 }
	 @PreDestroy//告诉spring 此对象容器销毁时执行close方法
	 public void close() {
		 System.out.println("close()");
	 }
}

3.DefaultSearchService类
src/main/java/com.cy.spring.beans/DefaultSearchService
@Service
public class DefaultSearchService implements SearchService {	
	/**@Autowired 可以修饰属性，set方法，构造方法等
	* 默认按照属性类型，方法参数类型为对象属性注入值,
	* 假如相同类型的对象有多个，还会按属性名或方法参数名等进行查找。
	* @Qualifier 配合@Autowired，用于指定要注入的对象的名字。
	*/
	//@Autowired
	//@Qualifier("defaultCache")//引入defaultCache实现类
	//private Cache cache;
	private Cache defaultCache;//引入defaultCache实现类，两种方式
	//@Autowired//修饰set方法
	//public void setCache(Cache cache){
	//	this.cache=cache;
	//}
	@Override
	public  String toString() {
		return "DefaultSearchService [cache=" + cache + "]";
	}
}

4.测试SearchService
src/main/java/com.cy.spring.beans/TestSearchService
public class TestSearchService extends TestSearchService{
	@Test
	public void testSearchService(){
		DefaultSearchService ds = ctx.getBean("defaultSearchService",DefaultSearchService.class);
		syso(ds);
	}
}

5.线程安全的Cache对象
src/main/java/com.cy.spring.beans/SynchronizedCache
@Component
public class SynchronizedCache implements Cache {

}

6.此时运行src/main/java/com.cy.spring.beans/TestSearchService会出错
因为Cache接口的实现类有两个了，DefaultCache和SynchronizedCache，
@Autowire不知道该注入哪一个了

7.给SynchronizedCache加名字
@Component("cache")//作用本来名字是synchronizedCache，现在为cache
public class SynchronizedCache implements Cache {

}
再运行就成功了

@Autowired
private Cache cache;	
/**@Autowired 可以修饰属性，set方法，构造方法等
* 默认按照属性类型，方法参数类型为对象属性注入值,
* 假如相同类型的对象有多个，还会按属性名或方法参数名等进行查找。
* @Qualifier 配合@Autowired，用于指定要注入的对象的名字。
*/

@Autowired实现DI功能，自动依赖注入
-------------------------------
spring进阶：
1.pom依赖
spring-context 5.1.9.RELEASE
junit 4.12

2.java配置类
src/main/java/com.cy.spring.config/SpringConfig.java //代替spring-configs.xml
//@ComponentScan 告诉spring容器从指定包及子包进行bean的扫描
//这里面仅做包扫描和启动配置
@ComponentScan("com.cy.spring.beans")
public class SpringConfig {

}

3.测试基类
src/test/java/包/TestBase
public class TestBase {
	protected AnnotationConfigApplicationContext ctx;
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
	}
	@After
	public void close() {
		ctx.close();
	}
	@Test
	public void testCtx() {
		System.out.println(ctx);
	}
}

4.创建自己写的DefaultCache对象交给Spring容器管理
src/main/java/com.cy.spring.beans/DefaultCache
@Lazy //延迟加载，不在启动时创建
@Scope("singleton") //bean的作用域:1)singleton (单例作用域-默认,会存储到池中)2)prototype (多例作用域,每次获取都创建新对象)
@Component //此类由spring管理，@Controller,@Service,...
public class DefaultCache {
	 public DefaultCache() {
		 System.out.println("DefaultCache()");
	 }
	 //生命周期方法
	 @PostConstruct //告诉spring 此对象初始化后执行init方法
	 public void init() {
		 System.out.println("init()");
	 }
	 @PreDestroy//告诉spring 此对象容器销毁时执行close方法
	 public void close() {
		 System.out.println("close()");
	 }
}

5.测试类 测试DefaultCache
src/test/java/包/TestDefaultCache
public class TestDefaultCache extends TestBase {
	@Test
	public void testDefaultCahce() {		
		//getBean("类名")返回Object，需要强转
		//getBean("类名",类型)返回泛型T，不用强转
		DefaultCache cache01=ctx.getBean("defaultCache",DefaultCache.class);
		System.out.println(cache01);
		//junit中的一个类Assert断言，为null异常，为true继续执行
	    Assert.assertNotEquals(null, cache01);
	    DefaultCache cache02=ctx.getBean("defaultCache",DefaultCache.class);
	    Assert.assertNotEquals(null, cache02);
	    System.out.println(cache01==cache02);//单例true
	}
}

创建第三方资源对象：
spring+DRUID连接池：
spring+HikariCP连接池：
6.pom依赖
mysql-connection-java 8.0.17
druid 1.1.19
HikariCP 3.3.1

7.数据源配置类
src/main/java/com.cy.spring.beans/DataSourceConfig.java
@Configuration//第三方资源给spring管理方式。自己写的用@Component
public class DataSourceConfig {    
	@Scope("singleton")
	//@Bean用于描述第三方资源对象，描述的方法的返回值可以存储到Spring容器
	//@Bean可以指定生命周期方法，对象的初始化，资源的销毁操作
	@Bean(value="druid",initMethod="init",destroyMethod="close")
	public DataSource newDruid() {
		DruidDataSource ds=new DruidDataSource();
		ds.setUrl("jdbc:mysql:///dbgoods?serverTimezone=GMT");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxWait(3000);
		return ds;
	}
	@Lazy(value=false)//实时加载
	@Bean(value="hikari",destroyMethod="close")
	public DataSource newHiKariCP() {
		HikariDataSource hds= new HikariDataSource();
		hds.setJdbcUrl("jdbc:mysql:///test?serverTimezone=GMT");
		hds.setUsername("root");
		hds.setPassword("root");
	    return hds;
	}
}

8.测试上面的DataSource
src/test/java/包/TestDataSource
public class TestDataSource extends TestBase {
	@Test
	public void testDruid() throws Exception {
		//DataSource ds = ctx.getBean(DataSource.class);
		//getBean时还可以指定名字，默认名字是方法名"newDruid"
		//也可以用@Bean(value="xxx")中的value值，如"druid"
		DataSource ds = ctx.getBean("druid", DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	public void testHiKariCP() throws Exception {
		//有两个DataSource时，必须指定名字"hikari"
		DataSource ds = ctx.getBean("hikari", DataSource.class);
		System.out.println(ds.getConnection());
	}
}
-------------------------------
1.前端请求Content-Type: application/x-www-form-urlencoded;
参数以form data形式提交，name=sss&age=16
springmvc controller层可以直接获取参数
request.getParameter(name);

2.前端请求content-type: application/json;
参数以request payload形式提交，{name:'sss',age:16}
springmvc controller层通过 加 @RequestBody 来获取json对象
底层request.getReader();从流中取

public JsonResult doInsertObject(@RequestBody Person entity) {
	RoleService.insertObject(entity);
	return new JsonResult("post ok");
}
-------------------------------
springMVC原理：
MVC是一种分层架构思想，按职责各司其职
-------------------------------
springMVC初步：
xml方式：
1.maven war包
Generate Deployment Descriptor Stub
加上tomcat

2.项目依赖
spring-webmvc 5.1.9.RELEASE
jackson-databind 2.9.9.3

3.添加springMVC配置文件
src/main/resource/spring-configs.xml
头...
<beans xmlns="...">
     <!-- 配置Bean对象的扫描 -->
     <context:component-scan base-package="com.cy"/>
     <!-- 配置默认静态资源的处理 (images/css/js/html)-->
     <mvc:default-servlet-handler/>
     <!-- 注册默认的一些mvc bean对象 -->
     <mvc:annotation-driven/>
     <!-- 配置视图解析器 -->
     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
          <!-- set注入 -->
          <property name="Prefix" value="/WEB-INF/pages/"/>
          <property name="Suffix" value=".html"/>
     </bean>
     <!-- ..... 拦截器-->
</beans>

4.在web.xml中配置springMVC前端控制器DispatcherServlet
<web-app 头...>
  <display-name>CGB-SPRINGMVC-01</display-name>
  <!-- 配置spring mvc 前端控制器 -->
  <servlet>
     <servlet-name>frontController</servlet-name>
     <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     <init-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:spring-configs.xml</param-value>
     </init-param>
     <!-- 配置tomcat启动初始化(数字越小优先级越高) -->
     <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
     <servlet-name>frontController</servlet-name>
     <url-pattern>/</url-pattern>
  </servlet-mapping>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>
</web-app>

5.定义controller类
@Controller
@RequestMapping("/search/")
public class SearchController {
	@RequestMapping("doSearchUI")
	public String doSearchUI() {
			return "search";//返回jsp或html
	}
	@RequestMapping("doSearch")
	@ResponseBody//返回json格式
	public Object doSearch(String key) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("state", 1);
		map.put("message","hello everyone");
		return map;//{"state":1,"message":"hello everyone"}
	}
}

注解方式：
1.配置maven war包插件 省略web.xml
pom.xml中选择Insert plugin-搜索"war"-添加failOnMissingWebXml:false
<project xmlns="头">
	头...
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<dependencies></dependencies>
</project>

2.添加tomcat

3.添加依赖
spring-webmvc 5.1.9.RELEASE
jackson-databind 2.9.9.3//对象到json串的转换

4.SpringWebConfig类
src/main/java/com.cy.pj.common.config/SpringWebConfig.java
@ComponentScan("com.cy.pj.search.controller")//包的扫描
@EnableWebMvc//注册默认的mvc bean对象
public class SpringWebConfig implements WebMvcConfigurer{
	//实现WebMvcConfigurer接口，并重写configureDefaultServletHandling，使configurer.enable()，完成对静态资源的处理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//重写configureViewResolvers配置视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/",".html");
	}
}

5.WebInitializer类配置springmvc前端控制器
src/main/java/com.cy.pj.common.config/WebInitializer.java
// tomcat启动时会加载此类
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	//默认执行onStartup方法创建DispatcherServlet
	// 加载service,dao配置，这边没有没配
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	// 加载spring mvc配置
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringWebConfig.class};
	}
	// 指定DispatcherServlet对象的请求映射路径
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}

6.定义controller类
@Controller
@RequestMapping("/search/")
public class SearchController {	
	//返回jsp或html
	@RequestMapping(value={"doHandleUrl","doWelcomeUrl"})
	public String doHandleUrl() {
		return "welcome";
	}
	//返回json格式
	@RequestMapping("doSearch")
	@ResponseBody
	public Object doSearch(String key) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("state", 1);
		map.put("message","hello everyone");
		return map;//{"state":1,"message":"hello everyone"}
	}
	// Rest风格的url，其格式为{a}/{b}/{c}
	// 假如希望方法参数获取url中{}值@PathVariable 
	@RequestMapping("{module}/{page}")
	public String doMoudleUI(@PathVariable String page
			,@PathVariable String module) {
		return module+"/"+page;
	}
	//post方法
	//	@RequestMapping(value="type",method=RequestMethod.POST)
	@GetMapping("type")
	//	@PostMapping("type")
	@ResponseBody
	public String doRequestMethodType() {
		return "request type POST";
	}
	// 请求参数处理
	@GetMapping("param")//xxx/param?msg=11&data=2019/01/01&id=1&name=xx
	@ResponseBody
	public String doRequestParam(
			RequestWrapper rw, //id,name
			@RequestParam(required=true) String msg,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date data) {
		return rw+" / "+msg+" / "+data;
	}
	//配置类中写了@EnableWebMvc直接return 对象就能返回json
	//未配置@EnableWebMvc，写下面api
	//借助jackson中的API将对象转换json格式的字符串
	//ObjectMapper.writeValueAsString，object->json
	@RequestMapping("doDataConvert")
	@ResponseBody
	public String doDataConvert()throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 100);
		map.put("msg", "hello jackson");
		ObjectMapper om=new ObjectMapper();
		return om.writeValueAsString(map);
	}
}
-------------------------------
springMVC进阶：
注解方式：
spring+mybatis
1.war包插件+依赖:
mysql-connection-java 8.0.16
druid 1.1.19
mybatis 3.5.2
mybatis-spring 2.0.2
spring-jdbc 5.1.9.RELEASE
spring-webmvc 5.1.9.RELEASE
jackson-databind 2.9.9
log4j 1.2.17
junit 4.12

2.dao层配置类
src/main/java/com.cy.pj.common.config/SpringRepositoryConfig.java
@Configuration
@MapperScan("com.cy.pj.goods.dao") // 扫描dao
public class SpringRepositoryConfig {
	@Bean(value = "druid", initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl("jdbc:mysql:///dbgoods?serverTimezone=GMT%2B8");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactory newSqlSessionFactory(DataSource dataSource) throws Exception {
		// 构建SqlSessionFactoryBean对象
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		// 调用FactoryBean的getObject方法创建SqlSessionFactory
		// 底层会使用SqlSessionFactoryBuilder创建
		return factoryBean.getObject();
	}
}

3.service层配置类
src/main/java/com.cy.pj.common.config/SpringServiceConfig.java
@Configuration
@ComponentScan("com.cy.pj.goods.service")
public class SpringServiceConfig {
	//.....
}

4.controller层配置类
src/main/java/com.cy.pj.common.config/SpringWebConfig.java
@ComponentScan("com.cy.pj.goods.controller")
@EnableWebMvc
@Configuration
public class SpringWebConfig implements WebMvcConfigurer {
	// <mvc:default-servlet-handler/>
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/", ".html");
	}
}

5.WebInitializer启动配置类
src/main/java/com.cy.pj.common.config/WebInitializer.java
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// Service,Repository
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringRepositoryConfig.class, SpringServiceConfig.class };
	}
	// View,Controller
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}

书写顺序:
dao->service->controller

把查的数据封装到pojo对象中
6.建pojo对象
src/main/java/com.cy.pj.goods.pojo/Goods.java
public class Goods implements Serializable{
	private static final long serialVersionUID = 690138036951052829L;
	private Long id;
	private String name;
	private String remark;
	private Date createdTime;
	setter/getter/toString();
}

7.GoodsDao接口
public interface GoodsDao { 
	@Select("select * from tb_goods")
	List<Goods> findGoods();
}

8.GoodsService接口
src/main/java/com.cy.pj.goods.service/GoodsService.java
public interface GoodsService {
	 List<Goods> findGoods();
}

9.Service实现类
src/main/java/com.cy.pj.goods.service.impl/GoodsServiceImpl.java
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	@Override
	public List<Goods> findGoods() {
		List<Goods> list=goodsDao.findGoods();
		return list;
	}
}

10.controller层
src/main/java/com.cy.pj.goods.controller/GoodsController.java
@Controller
@RequestMapping("/goods/")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
    @RequestMapping("doFindGoods")
    @ResponseBody
	public List<Goods> doFindGoods(){
		return goodsService.findGoods();
	}//json 串:spring mvc 启动API将对象转换为JSON串
}
-------------------------------
spring boot入门案例：
核心特征：
自动配置，起步依赖，健康检查

启动类作用：
1.基于注解描述实现自动化配置
	1.一个项目只能有一个启动类
	2.启动类用@SpringBootApplication描述
2.读取classpath中的配置文件，application.properties/yml

1.ctrl+n->spring starter project->packaging:jar

2.spring boot启动类
src/main/java/com.cy/XxxApplication.java
@SpringBootApplication
public class CgbSboot01Application {
	public static void main(String[] args) {
		SpringApplication.run(CgbSboot01Application.class, args);
		//args没有指定，扫描com.cy包及子包中的类
	}
}

3.测试类
src/test/java/com.cy/XxxApplicationTests.java
//@RunWith指定由谁调用测试类的方法进行单元测试
//SpringRunner调用CgbSboot01ApplicationTests的方法
//@RunWith可以指定自己的类来运行此对象中的方法
@RunWith(SpringRunner.class)
//@SpringBootTest描述的对象交给spring管理，方便spring为此类注入一些对象
@SpringBootTest
public class CgbSboot01ApplicationTests {
	@Autowired
	private ApplicationContext ctx;
	@Test
	public void textCtx() {
		syso(ctx);
	}
}

4.建一个Cache对象
src/main/java/com.cy.pj.common.cache/DefaultCache.java
@Component
public class DefaultCache {
	public DefaultCache() {
	   System.out.println("cache()");
	}	
}

5.DefaultCache测试类
src/test/java/com.cy/DefaultCacheTests.java
@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultCacheTests {
	@Autowired
	private DefaultCache defaultCache;
	@Test
	public void testCache() {
		System.out.println(defaultCache);
	}
}
-------------------------------
spring boot整合数据源：
默认使用HikariCP（世界上最快的连接池）

1.添加依赖MySQL Driver,JDBC API
pom.xml右击spring->Edit Starters->搜索依赖
不需要写版本，默认下载最新的

2.配置连接池
src/main/resources/application.properties
#spring datasource (HikariCP)
spring.datasource.url=jdbc:mysql:///dbgoods?serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=root

3.测试
src/test/java/com.cy/DataSourceTests.java
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	@Test
	public void testDataSource() throws Exception {
		System.out.println(dataSource);//HikariDataSource
		System.out.println(dataSource.getClass());
		System.out.println(dataSource.getConnection());
	}
}

整合druid
1.添加依赖druid-spring-boot-starter 1.1.20
spring->Edit Starters不支持
直接在pom.xml中写入
-------------------------------
spring boot整合mybatis
1.添加mybatis启动依赖
pom-Edit Starters-mybatis framework-加<version>2.1.0</version>

2.mybatis配置
application.properties
#mybatis
mybatis.configuration.default-statement-timeout=30
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.mapper-locations=classpath:/mapper/*.xml
#Log
logging.level.com.cy=DEBUG

3.dao接口
com.cy子包下的dao包
//@Mapper是Mybatis中新的注解，当spring boot看见这个注解，会自动创建这个接口的实现类
//没有@Mapper注解，需要定义一个扫描，在spring boot启动类上加一个@MapperScan扫描指定的dao包
@Mapper
public interface GoodsDao {
	@Delete("delete from tb_goods where id=#{id}")
	int deleteObject(Integer id);
	int deleteObjects(@Param("ids") Integer... ids);
}

4.测试mybatis
测试包下
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsDaoTests {
	@Autowired
	private GoodsDao goodsDao;
	@Test
	public void testGoodsDao() {
		int rows = goodsDao.deleteObject(10);
		System.out.println("rows=" + rows);
	}
	@Test
	public void testDeleteObjects() {
		int rows = goodsDao.deleteObjects(17, 18);
		System.out.println(rows);
	}
}

5.写deleteObjects方法的mapper
resources/mapper/GoodsMapper.xml
头...
<mapper namespace="com.cy.pj.goods.dao.GoodsDao">
   <delete id="deleteObjects">
       delete from tb_goods
       where id in <!-- (1,2,3,4,5) -->
       <foreach collection="ids"
                open="("
                close=")"
                separator=","
                item="id">
               #{id}
       </foreach>
   </delete>
</mapper>

6.指定映射文件的路径，在application.properties中
mybatis.mapper-locations=classpath:/mapper/*.xml

7.在GoodsDaoTests文件测试
-------------------------------
spring boot整合web应用
内嵌tomcat，添加org.apache.tomcat.embed依赖

1.pom.xml添加依赖Edit Starters
Thymeleaf,Spring Web Starter

2.spring web简易配置，添加视图解析器
application.properties：
#spring mvc
spring.thymeleaf.prefix=classpath:/templates/pages/
spring.thymeleaf.suffix=.html

页面存在resources/下

3.添加页面及目录
resources/templates/pages/goods.html

4.controller
GoodsController.java
@Controller
@RequestMapping("/goods/")
public class GoodsController {
	@RequestMapping("doDeleteGoods")
	@ResponseBody
	public String doDeleteGoods(Integer... ids) {
		return "delete objects ids "+Arrays.toString(ids);
	}
	@RequestMapping("doGoodsUI")
	public String doGoodsUI() {
		return "goods";
	}
}

5.服务端的简易配置，比如端口号
application.properties：
#server
server.port=80
server.tomcat.max-threads=1000
server.servlet.context-path=/
-------------------------------
spring boot项目应用扩展
一、健康检查配置及测试
看是否有问题
1.添加依赖
Spring Boot Actuator

2.在浏览器输入路径
http://localhost/actuator/health
输出{"status":"UP"}表明正常

3.查看更多actuator选项
application.properties：
management.endpoints.web.exposure.include=*

4.浏览器输入
http://localhost/actuator/beans
查看spring容器中所有bean的信息

二、热部署配置
1.添加依赖
Spring Boot DevTools

2.配置
application.properties：
spring.devtools.restart.enabled=true
//重启目录
spring.devtools.restart.additional-paths=src/main/java
//排除热部署，静态资源。两个**该目录及子目录资源
spring.devtools.restart.exclude=templates/pages/**

三、Lombok插件
1.下载依赖lombok
复制maven全路径，进入文件夹位置，启动cmd，输入命令java -jar lom...，选中sts4.exe，勾上并install安装，quit完成

2.在java文件中
@Data=@Setter+@Getter+@ToString
@AllArgsConstructor全参构造
@NoArgsConstructor无参构造

@Accessors(chain=true)//链式调用
如：
new Goods().setId(10L).setName("aa");

@EqualsAndHashCode

@RequiredArgsConstructor指定构造

@Slf4j//日志
生成log常量，代替
private static final Logger log = LoggerFactory.getLogger(类名.class);

log.info("xxx");

四、Mybatis-Plus插件
Mybatis增强工具
-------------------------------
第四阶段
分布式：
将项目拆分，实现了软件架构的松耦合

项目的垂直拆分：
根据功能模块（业务决定的），将项目拆分到不同服务器中

项目的水平拆分：
根据代码层级进行项目的拆分，web，vo，controller，接口

先有垂直后有水平

单台tomcat服务器并发量180~240之间，实际150/秒

集群：
由于高并发需求，搭建服务器集群抗击高并发

高可用（HA）：当服务器故障，能够实现自动化故障迁移
主机 从机 心跳检测机制

海量数据处理：
大数据

分布式：
3.xx系统 jar/war看业务
1.继承自 parent 管理jar包(pom聚合项目)
2.依赖自 common工具类jar包(继承自parent)
---------------------------
redis缓存
编译
make
安装
make install
启动
redis-server redis.conf
进入客户端
redis-cli -p 6379
端口号为6379时，快捷进入客户端
redis-cli
存数据
set 
取数据
get
退出
exit
关闭redis
redis-cli -p 6379 shutdown
redis-cli shutdown
结束redis进程
ps -ef | grep redis
kill -9 pid1 pid2

String类型：
获取value的长度
strlen key
key是否存在
exists key
删除
del key
查询
keys *
查询a开头的
keys a*
查询a开头的，两个字符
keys a?
多个赋值
mset a aa b bb
多个取值
mget a b
在key后追加
append key bbcc
append key " bbcc"
检查key类型
type key
切换数据库 redis中有16个数据库，默认操作第1个
select 15
清空当下数据库
flushdb
清空所有数据库
flushall
减/加数1
de/incr num
减/加数至
de/incrby num 1221
数据存活时间s
expire key seconds
数据存活时间ms
pexpire key ms
查询存活时间
ttl key
取消超时时间
persist key

Hash类型：
User {id:2,name:"小米"}
hset user id 2
hset user name "小米"

hget user name

hexists

hdel user id

hgetall user

hkeys user

hvals user

hmset

hsetnx

hstrlen

List类型(中间件)：
lpsuh
lpsuh list 1 2 3 4

rpop
rpop list//队列1 2 3 4

lpop list//栈4 3 2 1

rpush

事务：
开启事务
multi
提交
exec
回滚
discard

redis持久化

rdb模式 默认 rdb文件
rdb能定期实现数据的持久化（可能会丢失数据）
默认的持久化文件名称dump.rdb
rdb持久化只做内存数据的快照，占用空间较小，效率高
save 立即持久化 同步（默认）
bgsave 后台启动持久化 异步

aof模式
异步，实时
记录用户操作过程，持久化文件较大
效率低
--------------------------
内存优化策略：
lru 最近最少使用淘汰
记录上次访问以来的时间t，淘汰t最大的

lfu 最不经常使用页置换法 置换引用计数最小的页

volatile-lru 设定超时时间中使用lru
allkeys-lru 所有数据使用lru
volatile-lfu 设定超时时间中使用lfu
allkeys-lfu 所有数据使用lfu
volatile-random 设定超时时间中数据随机删除
allkeys-random 所有数据随机删除
volatile-ttl 根据剩余时间多少删除数据（先删除少的）
noeviction 不自动删除数据，内存溢出时报错返回

redis分片机制
内存占用大时，一台redis效率低，搭建redis分片实现内存扩容

hash一致性算法
顺时针节点存取

hash一致性的特点
均衡性 创建虚拟节点
单调性 当节点新增时，数据可以实现自动迁移 节点只能新增不能减少（减少得重新划分分片）
分散性 一key多位置
负载 多key一位置
--------------------------
redis哨兵
用了redis分片，一台宕机服务器就会报错
增加备用机：一主二从
哨兵重新选主，使其余当从

不能向从机set数据

1.实现redis高可用，先配置主从结构
2.哨兵通过心跳检测机制实时向主机发出心跳检测机制，ping-pong，如果连续3次主机没有回应，重新推选
3.哨兵连接主机后，知道主机信息，哨兵重新选主，使其余当从

检测redis节点的状态
info replication
role:主机

slaveof ip port做从机

sentinel monitor mymaster 192.168.72.130 6379 1
1当前哨兵选举的票数，只有一个哨兵，一票生效
哨兵奇数，哨兵数-1生效

启动哨兵
redis-sentinel sentinel.conf

redis集群
redis集群设计时主机实现分片功能，每台主机之后都有对应从机，并且在内部实现高可用（不需要依赖第三方监控）

通用概念（不适用redis集群）
通常集群数量奇数台（包含主从）

集群正常工作条件：
n是总数
存活的服务器的数量>n/2
1台，2台不能搭建集群
3台可以，最多允许宕1台
4台可以，最多允许宕1台
所以通常集群是奇数

redis集群内存不能少机器，得有替补

redis集群搭建计划
3台主机 3台从机 共6台 端口划分7000~7005

redis集群原理（分区）
集群信息都在nodes.conf中

redis集群宕机条件
最少超半数
最多可以 主机数-1

redis集群 用的hash槽存储数据原理 主机最多16384
均分三槽，数字可以重复

分片效率高：运算发生在服务器，redis只负责存取
集群：运算发生在redis内部，效率稍低

脑裂现象
连续三次投票没有结果，选举失败，出现脑裂现象，都做主机
如何降低脑裂现象：增加主机数量
-------------------------
伪静态：
保证搜索引擎收录，又不真实书写html页面，以html形式动态展现页面

伪静态业务实现：
springmvc要拦截html结尾的请求
让xxx/index.html 跳转 index.jsp

serviceImpl中httpClient调用另一controller

同源：协议名称，域名，端口号

httpClient较繁琐，ajax发起远程数据请求

jsonp标签跨域：
1.src地址
2.定义回调函数xxx?callback=xxx
3.返回值封装xxx(json)

jq:
$.ajax({
	url:"xxx/testJSONP",
	type:"get",				//jsonp只能get
	dataType:"jsonp",       //返回值类型
	jsonp: "callback",    //指定参数名称?callback=hello
	jsonpCallback: "hello",  //指定回调函数名称
	success:function (data){   //data返回是json字符串
		alert(data.id);
		alert(data.name);
		//转化为对象使用
		//var obj = eval("("+data+")");
		//alert(obj.name);
	}	
});

单点登录系统用户信息校验
sso系统连数据库
web jsonp连sso
-----------------------------
httpClient和jsonp总结：
httpClient:
1.httpClient可以发起任意类型请求
2.调用层级较多

jsonp:
1.安全性低，一般做简单查询用
-----------------------------
Dubbo框架：
soa思想(微服务)模型：
1.
jt-web:服务生产者
浏览器->controller 

2.
接口：
XXXService

3.
jt-manage:服务提供者
ServiceImpl->Mapper

rpc协议：
1.rpc4层，http7层
2.rpc可以直接调用中立接口，http不行
3.rpc是长链接，在一个连接上可以连续发送多个数据包
4.rpc是加密传输，http需要大量请求头信息
5.rpc一般都有注册中心

dubbo:
1.当服务生产者启动时，会将自己的服务名称/ip/端口号写入注册中心
2.注册中心接受服务器请求时，会将服务信息写入自己维护的服务列表中
3.当服务消费者启动时，首先会链接注册中心，获取服务列表数据，并且保存到本地内存中
4.当用户发起请求时，这时消费者根据用户的需求查询服务列表信息，基于负载均衡策略，查找正确的ip、端口之后发起rpc请求
5.服务提供者接收用户的请求，之后开始完成业务处理，并且将数据返回
6.当后台服务器宕机时，注册中心基于心跳检测机制，发现服务器宕机，同步更新自己的服务器列表的数据，同时全网广播。消费者接口接口注册中心的信息之后，也同步更新自己的本地数据，方便下次调用。

注意事项：对象必须实现序列化接口

zookeeper
一个自动化服务的调度器

zookeeper宕机后，现有服务器不会受影响
------------------------------
单点登录sso：
1.0版本：
第一次登录：
用户电脑login(username,password)后->nginx中转->web服务器->sso服务器（校验，用u/p查询数据，正确的话将用户对象转至json串，并生成uuid存至redis）->redis服务器<k,v>uuid ticket,用户信息json

返回->jt-web 将ticket至用户cookie中，并实现cookie共享

第二次登录：
用户电脑进入网页（cookie）->nginx->web服务器->redis服务器 返回至用户电脑
用户信息存在直接进入

单点登录 另一服务器 得做cookie数据共享

重复登录问题：
-------------------------
拦截器和aop的适用场景：
处理页面相关，用拦截器
处理业务相关（事务，缓存），用aop
-------------------------
springMVC参数接收：
1.简单参数接收
@RequestMapping("/check")
checkUser(String callback) {}

2.使用对象接收（对象方式）
@RequestMapping("/update/num/{itemId}/{num}")
updateCartNum(Cart cart)
@RequestMapping("/update/num")
updateCartNum(Cart cart) ？

3.restful风格 微服务常用参数提交方式
@RequestMapping("/check/{param}")
checkUser(@PathVariable String param) {}
或
checkUser(Cart cart) {}

4.springMVC为对象的引用赋值
User{
	...
	Dog dog;//对象的引用
}
Dog{
	...
}
<input name="dog.dogName" />
--------------------------
订单超时：
now() - created > 30 && status=1
Quartz定时任务

1.调度器：负责统一的管理任务
2.触发器：负责任务执行，同时设定执行的周期
3.job：自定义的任务
4.jobDetail：负责封装job的api

job注册到调度器，调度器调度触发器，触发器触发jobDetail

项目中，每1分钟把数据库中所有now() - created > 30 && status=1的订单status改为6，更新时间更改
--------------------------
防止同主机重复登录、开启另一设备登录验证：
注册时：
1.输入用户名，密码，其余等
2.密码经过md5加密，用户数据存入数据库

登录时：
1.通过IPUtil获取nginx代理的ip地址
2.把登录输入的用户信息（用户名，密码）和ip地址传入serviceImpl中
3.将密码md5转码，将用户信息传入QueryWrapper，搜索数据库中用户信息。
如果无此用户，返回ticket为null，控制层接口返回"用户名或密码错误"
如果有此用户，生成ticket(uuid的MD5转码)，将查到的用户信息密码替换（脱敏），然后将用户信息转为JSON（userJSON）。生成HashMap<String,String>，放入三对k,v
{
	"JT_IP":ip(控制层传入的ip),
	"JT_TICKET":ticket(生成的uuid md5),
	"JT_USERJSON":userJSON
}
批量存入redis中的Hash类型中，Hash对象名为 用户信息中的用户名
设定redis的超时时间7天
返回ticket
4.控制层中给浏览器存入两对cookie
{
	"JT_TICKET":ticket,
	"JT_USERNAME":用户信息中的用户名
}
控制层接口返回成功

首页加载时：
1.从cookie中获取"JT_TICKET" uuid,"JT_USERNAME" 用户名
2.两者都不为空，则调用查询登录信息接口传入ticket和username
3.控制层中，取redis中ticket的值，和传入的ticket比较
如果不等，返回失败接口信息
如果相等，继续使用IPUtil和request域获取请求主机的ip，和redis中的ip比较
ip如果相等，取出redis中的userJSON(用户信息json)，放入成功接口中返回

ip如果不等，增加第三重验证，如短信验证、人脸识别验证...

如果未通过，返回失败接口信息
如果通过，取出redis中的userJSON(用户信息json)，放入成功接口中返回
--------------------------------
普通锁：synchronized,ThreadLocal
多台服务器普通锁不能保证锁控制，得用分布式锁
分布式锁：lock锁
Lock lock = new ReentrantLock();
lock.lock();
lock.unlock();
lock.trylock();
思想：将锁交给第三方管理：
只允许一个线程和数据库交互
1.交给数据库，通过管理id:1（主键），插入，删除id，保证唯一
2.交给redis，通过管理key:uuid，设置不能覆盖值且有失效时间，插入，删除，保证唯一
3.交给zookeeper（主流），通过增加临时节点管理，插入，删除，保证唯一（好了可以通知，不用一直等）

redis分布式锁：
setnx成功失败看加锁与否
setnx每个服务器随机数key，并设失效时间，两者得是原子性：
set(key,value,nx,px,毫秒数);

解锁：删除key

查询没有原子性

获取数据/判断一致/删除数据，3个操作通过lua保证原子性

线程内不同方法数据共享ThreadLocal
-----------------------------
数据库备份
冷备份：手动导入导出，不实时
热备份：实时备份

主从复制
修改操作：
主机->二进制日志(binary log)
从机读二进制日志->中继日志(relay log)
从机读中继日志->写入数据

数据库读写分离
写：主机
读：主机，从机
通过访问代理服务器，映射到主从数据库
-----------------------------
Amoeba实现读写分离/负载均衡

双机热备（互为主从）

Mycat数据库分库分表中间件
数据库垂直拆分：按业务分
数据库水平拆分：按一表数据分到多张表中

用户操作的是逻辑库（虚拟的）
-----------------------------
spring cloud
微服务整体解决方案
框架集，集成了一整套框架

springboot简化spring配置，开箱即用

eureka注册中心
与zookeeper区别
1.eureka有保护模式

eureka：
ap 可用性，分区容错性
集群：对等结构
zookeeper：
cp 一致性，分区容错性
集群：主从结构

restTemplate
更上层的远程调用

ribbon服务消费者
提供了负载均衡和重试功能
负载均衡：
@LoadBalanced
http://service-id/xxx
重试：
spring-retry依赖
参数MaxAutoRetries...

hystrix断路器
降级：请求失败，向客户端直接返回处理响应

熔断：大量失败降级，通路直接断开，不调用后台服务直接降级
默认10秒20次请求的情况下，50%失败降级触发熔断，断路器打开
5秒后进入半开状态，会尝试向后台服务请求，如果成功会关闭断路器。如果仍然失败，继续保持打开状态

hystrix超时时间应该大于ribbon重试的最长时间

hystrix dashboard仪表盘 监控

feign
声明式客户端
只需要声明一个接口，可以调用远程服务
微服务间调用
feign+ribbon
feign+hystrix

turbine 集群聚合监控
turbine聚合了feign服务和order-service服务集群的hystrix监控信息

zuul API网关
部署在最前面
转发调用
统一权限校验
zuul集成ribbon和hystrix

config配置中心
config client
客户端不用关机微服务，动态刷新配置数据
基础配置刷新不了，app-name,port,eureka
只能刷新自定义属性
ServiceImpl中加@RefreshScope 
post请求刷新

服务必须按顺序启动：
eureka-config-其它

bus
config bus + rabbitmq 消息总线配置刷新
rabbitmq群发

消息中间件
rabbitmq
activemq

rabbitmq

sleuth 链路跟踪

sleuth + zipkin 链路分析
--------------------------
Lucene Solr 倒排索引 中文分词ik
全文检索
Lucene Solr官方开发
electic search个人开发，也是基于lucene

core
对一类文档生成的索引
核心对应一张数据库的表
--------------------------
rabbitmq

常用订单：流量削峰

redis,rabbitmq是项目中必须要用的

降低耦合都可以通过中间加一个东西来解决，经典的生产者消费者模型

1.服务解耦
2.订单、流量削峰
3.异步调用

六种模式：
1.简单模式
2.工作队列模式（多个消费者，负载均衡，轮询。合理分发-手动确认qos(1)，数据的持久化-队列持久化，消息持久化）
3.发布订阅模式（fanout交换机）
4.路由模式（direct交换机，路由键和绑定建匹配）
5.主题模式（更复杂的路由模式，topic交换机，键的形式aaa.bbb.ccc,*.*.ccc,aa.#）*匹配一个单词，#匹配多个单词
6.rpc异步调用（两个队列，一个关联键）
多个客户端公用一个发送队列，
多个客户端有自己的返回队列

消息携带两个数据：返回队列名，每次消息的关联id

订单存储的解耦：
流量削峰，先把订单放到rabbitmq队列中
并同步到redis缓存中，方便用户查询

rabbitmq之前是：
1.客户端controller-service-dao入数据库

rabbitmq之后是：
1.客户端(订单生产者)
通过amqpTemplate.convertAndSend("orderQueue", pdOrder);
controller-orderId放入rabbitmq队列

2.新建消费者项目(订单消费者)
通过@RabbitListener(queues="orderQueue")
从队列取出订单
再调serive存入数据库

3.yml改成手动确认
acknowledge-mode: manual
OrderConsumer save中
channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
--------------------------
docker
轻量的虚拟机

vmware需要虚拟硬件，操作系统

docker不虚拟硬件，系统资源直接使用宿主资源

docker虚拟机称为容器

docker开发运维一体化（DevOps）核心工具

docker镜像：静态文件
docker容器：从镜像实例化出来的

镜像仓库：https://hub.docker.com/

下载镜像
docker pull xxx:yyy
yyy:标签版本号

docker中存在的镜像
docker images
docker image ls

运行进入镜像
docker run hello-world
后台运行，不进镜像
docker run -d xxx
-d后台
-i交互
-t终端

查看容器列表
docker ps
查看全部容器
docker ps -a

退出镜像
exit

删除镜像
docker image rm 镜像名/id前三位
有容器删不了则
docker image rm -f 镜像名/id前三位

导出
docker save xxx yyy | gzip > app.tar.gz  

导入xxx到docker
docker load -i xxx
docker load < xxx

进入容器
docker exec -it 77a bash

启动容器
docker start 77a

停止容器
docker stop 77a

删除容器
docker container rm 77a 88a
删除正在运行的容器
docker container rm -f 77a

\折行写命令

清理所有终止状态容器
docker container prune

容器的数据管理：
数据存到宿主机磁盘上
宿主机（linux服务器）路径/usr/app
容器路径/opt/app

启动挂载数据卷的容器
--name 给容器起名
-v指定挂载的目录
docker run -dit --name centos7 -v /usr/app:/opt/app centos:7

创建文件，EOF结束符，向f1输出
cat <<EOF > f1
查看文件
cat f1

数据卷：
docker在宿主机上创建，不用关心路径
docker volume create my-vol
查看所有数据卷
docker volume ls
查看指定 数据卷 的信息（挂载目录）
docker volume inspect my-vol
启动挂载数据卷的容器
docker run -dit --name centos7-v2 -v my-vol:/opt/app centos:7
删除数据卷（如果数据卷被容器使用则无法删除）
docker volume rm my-vol
清理无主数据卷
docker volume prune

端口映射
宿主机80->容器端口8080
docker run -dit --name tomcat -p 80:8080 tomcat

浏览器访问80端口

容器互联:
新建网络
docker network create -d bridge my-net
启动两个容器连接到网络
docker run -dit --name centos7-1 --network my-net centos:7
docker run -dit --name centos7-2 --network my-net centos:7
进入一个容器ping另一个容器
宿主机也能连接

自己制作镜像
镜像中每一个操作会加一层，层数越少越好
mkdir dockerfile
mv jdk-8u212-linux-x64.tar.gz dockerfile/
mv apache-tomcat-8.5.42.tar.gz dockerfile/
cd dockerfile

cat <<EOF > Dockerfile
#以centos7为基础
FROM centos:7
#ADD命令将压缩包传入镜像中的指定目录,并同时解压缩
ADD jdk-8u212-linux-x64.tar.gz /opt/
ADD apache-tomcat-8.5.42.tar.gz /usr/
#为了方便,把文件夹名称改得简单一点
RUN mv /usr/apache-tomcat-8.5.42 /usr/tomcat
#设置环境变量
ENV JAVA_HOME=/opt/jdk1.8.0_212 \
    CATALINA_HOME=/usr/tomcat \
    PATH=$PATH:/opt/jdk1.8.0_212/bin:/usr/tomcat/bin
#暴露容器的8080端口
EXPOSE 8080
#设置启动容器时自动运行tomcat
ENTRYPOINT /usr/tomcat/bin/startup.sh && tail -F /usr/tomcat/logs/catalina.out
EOF

构建镜像
docker build -t tomcat:7 .

Docker案例：
1.加载redis镜像
2.启动容器
3.进入容器并启动redis工具
cd ~
docker exec -it redis7000 redis-cli

启动多个 redis 容器

容器互联
1.创建docker虚拟网络
2.mysql
创建数据卷
3.tomcat
启动 tomcat 容器
--------------------------
k8s 自动化容器部署工具

安装kubernetes集群

<<Kubernetes in action>>

k8s 容器集群管理系统
为容器化的应用提供
部署运行、资源调度、服务发现和动态伸缩等一系列完整功能，
提高了大规模容器集群管理的便捷性

Kubernetes中，Service是分布式集群架构的核心，Service对象特征：
一个唯一的名字
一个虚拟IP（Cluster IP、Service IP、或VIP）和端口号
能够体统某种远程服务能力
被映射到了提供这种服务能力的一组容器应用上
--------------------------
大数据
hadoop
分布式海量数据离线存储、处理系统
HDFS存储
MapReduce离线处理
Yarn资源调度

hadoop:
1.单机模式
2.伪分布式模式
3.完全分布式模式

HDFS：
Namenode保存元数据
Datanode保存文件块

flume
分布式日志收集工具，流式数据处理

avro
多节点数据联动，序列化技术

hive
基于hadoop的数据仓库工具，使用类sql，海量数据的离线分析
--------------
从头开始配环境
1.java环境
下载java1.8，安装
如：jdk1.8.0_45.zip
配置环境变量-系统变量-path
JAVA_HOME

2.安装编辑器
如eclipse
建立并选择工作空间
导入eclipse习惯设置文件

3.安装数据库环境
如mysql
配置环境变量-系统变量-path

4.安装数据库工具
连接数据库

5.服务器
tomcat服务器
下载解压
bin/startup.bat启动

conf/logging.properties
java.util.logging.ConsoleHandler.encoding = GBK
解决命令行乱码问题

conf/server.xml 69行改端口
logs/日志
webapps/管理目录

eclipse添加tomcat
eclipse-windows-preferences-server-runtime environment-添加tomcat
修改tomcat文件目录

servers-add and remove添加去除项目

6.maven公共包管理工具
类似npm install -g
下载

配置本地仓库位置
conf-settings.xml
书写<localRepository>

配置镜像服务器
conf-settings.xml
书写<mirror>

配置jdk版本
conf-settings.xml
书写<profiles>

maven配置到eclipse中
windows-preferences-maven
-installations-选择maven文件位置
-user settings-选择maven配置文件位置

添加jar包
pom.xml右键maven-add dependency-search results

pom.xml点下方dependencies-add，剩下同上

1.安装eclipse_sts
2.工作区编码utf-8
3.maven安装，设置
4.lombok插件
添加依赖lombok
复制全路径找到lombok-xxx.jar所在目录
执行java -jar lombok-xxx.jar
找到sts目录，选中sts.exe文件，install
安装后，sts.exe目录会有一个lombok.jar文件
sts.ini最后一行是lombok的安装目录
pojo对象即可使用lombok注解
-------------------------------
单表查询结果映射：
resultType=基本类型封装类，po

多表查询结果映射：
resultType=map，vo
-------------------------------
java数据库功能开发顺序
查-增-改-删
-------------------------------
springmvc控制层接收请求体中多个对象时
前端传递json:
{
	roles:{name:"aa",age:12},
	menusIds:[1,2,3]
}
比如后台想接收Roles entity,Integer[] menusIds
@RequestBody只用写一次，因为一次请求就能拿到请求体中所有数据
1.用Map<String,Object>接收
public JsonResult doInsertObject(@RequestBody Map<String, Object> rolesMenus) {
	System.out.println(rolesMenus);
	//rolesMenus为{roles:{name:"aa",age:12},menusIds:[1,2,3]}
	//缺点代码可读性差
}
2.用vo类接收
public class RolesMenus implements Serializable{	
	private static final long serialVersionUID = -8042095643912018424L;
	private Roles roles;
	private Integer[] menusIds; 
}
public JsonResult doInsertObject(@RequestBody RolesMenus rolesMenus) {
	System.out.println(rolesMenus.getRoles());//Roles对象
	System.out.println(rolesMenus.getMenusIds());//Integer数组
}
-------------------------------
mybatis鉴别器

resultMap内容：
必须按顺序写
(constructor?,id*,result*,association*,collection*,discriminator?)

javaType定义po类型
ofType定义集合中类型

id是id专用映射

result是自定义映射

association是对一
用一个参数查询一个对象，赋值到vo的一个属性上，如把deptId查询Dept赋值到vo.dept属性上
autoMapping="true"，自动映射对应字段

collection是对多
通过一个参数查询一个集合，赋值到vo的一个属性上，如把userId查询users_roles中间表得到roleIds，把roleIds赋值到vo.roleIds属性上

association*,collection*后property值会被用掉
得用id*,result*重新给property赋值

insert和update时
useGeneratedKeys="true"使用自动生成的主键值
keyProperty="id" 将获取的主键值赋值给po类中的xx属性，通过setXx方法
-------------------------------
阿里分层领域模型规约：
do(data object) 与表对应，通过dao层向上传递的数据对象
dto(data transfer object) 数据传输对象，service向外传输的对象
bo(business object) 业务对象，由service输出的封装业务逻辑的对象
ao(application object) 应用对象
vo(view object) 显示层对象，web向模板渲染引擎层传输的对象
-------------------------------
shiro安全框架，完成认证授权
1.用shiro给密码加密，
1.1 UUID方法生成盐值 String salt = UUID.randomUUID().toString();
1.2 用shiro的SimpleHash进行md5加密，把原密码和盐值一起加密存入数据库。MD5只能加密不能解密，相同信息加密结果一致
SimpleHash sh = new SimpleHash(
	"md5", //algorithmName算法名称
	sourcePassword, //source原密码
	salt, //salt盐值
	1//iterations加密此数，可以对加密结果进行再加密
);
1.3 把加密过的密码和盐值存入vo中存入数据库
userDeptRoleIds.setSalt(salt);
userDeptRoleIds.setPassword(sh.toHex());
-------------------------------
java自定义工具类
其它类调用时：工具类名.方法
-------------------------------
判断实例对象，是否是指定类的对象
Class clz = object.getClass();
if(clz==Users.class) {
	...
}
-------------------------------
从自身继承的接口中，找需要的方法.parameterTypes()
Signature s = jp.getSignature();
1.打断点，s指向内部类MethodSignatureImpl
2.ctrl+shift+t 打开所有仓库类
3.输入MethodSignatureImpl，打开这个类看一下
4.MethodSignatureImpl实现了MethodSignature接口
MethodSignature继承了CodeSignature
CodeSignature继承了MemberSignature
MemberSignature继承了Signature
用接口接收，
MethodSignature ms = (MethodSignature)jp.getSignature();
有ms.getParameterTypes()，就是我们需要的parameterTypes()方法
-------------------------------
反射获取注解值
反射的起点字节码对象Class<?>
通过字节码对象
Class<?>.getDeclaredMethod(name,parameterTypes)，获取某一个方法对象
name方法名，parameterTypes方法参数
-------------------------------
springboot全局cors跨域
前端域名localhost:8080
服务器端口localhost:84

前端请求地址localhost:84
后台springboot中：
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	//设置全局跨域
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")		
		.allowedOrigins("http://localhost:8080")
        .allowedMethods("GET","POST","PUT","DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
	}
}
-------------------------------
springboot项目名不能有数字，括号
groupId' with value '1212()' does not match a valid id pattern
意思是groupId名称无效
-------------------------------
shiro的setLoginUrl导致的cors跨域、前端proxy跨域失效
ShiroFilterFactoryBean fBean = new ShiroFilterFactoryBean();
/*设置登录url，setLoginUrl是redirect操作，基于安全考虑，Response Header的信息会被清除，导致cors跨域、前端proxy跨域失效。nginx反向代理有效
*/
fBean.setLoginUrl("/doLogin");
-------------------------------
ssm中bean对象的创建
applicationContext.xml中
<bean class="org.springframework.xxx.xxx.xxx.Aaabbbccc">
	...
</bean>

springboot中bean对象的创建
java类中
@Bean
public Aaabbbccc aaabbbccc(){
	return new Aaabbbccc();
}

两者是一样的
-------------------------------
dao中，一个参数是数组时也要加@Param("xxx")
List<String> findPermissionsByMenuIds(
			@Param("menuIds")Integer[] menuIds);
-------------------------------
XxxMapper.xml中

第一种不需要separator=","，直接foreach，相当于执行多次select
<select id="findPermissionsByMenuIds" resultType="string">
	select permission from menus
	<where>
		<foreach collection="menuIds" 
		item="menuId">
			or id=#{menuId}
		</foreach>
	</where>
</select>

第二种需要open,close,separator，因为in的格式要求in(1,2,3)，一次select
<select id="findPermissions"
		resultType="string">
		select permission
		from sys_menus
		where id in
		<foreach collection="menuIds"
				open="("
				close=")"
				separator=","
				item="menuId">
			#{menuId}
		</foreach>
</select>
-------------------------------
cookie会存在请求的域名下

cookie map结构
每个键值对有 过期时间、域、路径、脚本可否访问等描述信息；描述信息存储在客户端，客户端请求时，默认会带上cookie的名称和值，不会带描述信息

cookie的属性：
Max-Age 过期时间
Expires 过期日期
domain 域名
path 路径
secure 是否安全传输，安全协议（如https、ssl）浏览器才会传输cookie
httponly 是否只能请求，脚本不能获取，默认为true

cookie区分域，不区分端口。自然添加cookie时，无法指定端口

cookie可以跨端口跨域，不可跨域名

cookie和sessionId
服务器无法知道是哪个浏览器发起的请求，所以当浏览器发起第一次请求时，服务器会创建sessionId存入浏览器的cookie中，以后浏览器发起请求都会带上sessionId，服务器得以区分是哪个浏览器发起的请求

cookie存储在客户端，session存储在服务器端

session是跟单次浏览器标签绑定的（可以通过persistent cookie 实现跨窗口使用，但是也是对应的同一域名）
-------------------------------
springboot.application.yml中
如果
spring:
	aop:
		proxy-target-class: true
也就是用cglib代理aop		
项目debug模式，调试断点，可能出现missing line number attributes错误
改为proxy-target-class: false，用jdk代理aop即可
-------------------------------
shiro和JSESSIONID

1.shiro的登录操作

shiro登录成功后，会把请求的用户信息（Subject对象）放入session中，session默认时效30分钟（不进行任何请求30分钟），到期后清除

2.java服务器JSESSIONID

为了识别唯一客户端（浏览器），客户端第一次请求时，服务器会生成一串字符串，Set-Cookie到浏览器cookie中，
下次再访问服务器，浏览器会带上JSESSIONID，服务器会比对自己内存中的sessionId来标识客户端

3.什么情况会产生JSESSIONID

	1.访问jsp，默认第一次产生jsessionId，客户端没有，服务端会重新set，因为session是jsp九大内置对象之一，jsp先是转换成Servlet，就已经创建了session对象。

	2.访问html或者ajax，默认不产生jsessionId，得用安全框架（如shiro）后产生

4.set-Cookie的Expires属性：

服务器set-Cookie.Expires默认是expires:session，关闭浏览器，浏览器与服务器断开连接，cookie消失，关闭选项卡cookie不会消失，
如果expires为过去时间，这个cookie不会再发送到服务器，随后浏览器会删除此cookie

未设置cookie过期时间，cookie保存在浏览器内存中
设置了cookie过期时间，cookie在过期前保存在客户端硬盘中

5.jsessionId的作用

	不用shiro，jesessionId是标识，但消失不会回到登录页

	用了shiro，每次请求都会比对jsessionId，不一致时返回登录页面

6.shiro和jsessionId的关系

第一次请求服务器，shiro会调用tomcat方法生成jsessionId给客户端，之后请求客户端都会带上jsessionId
如果客户端jsessiomnId消失，shiro发现后会调用tomcat方法生成一个新的jsessionId拼在returnToLogin路由后面，shiro发现和服务器的jsesseionId不匹配，会调setLoginUrl方法，触发tomcatURL重写机制，到登录页

shiro中可以自定义jsessionId这个cookie的名字和过期时间
DefaultWebSessionManager sManager = new DefaultWebSessionManager();
SimpleCookie sC = new SimpleCookie();
sC.setName("myJSESSIONID");
sC.setMaxAge(24*60*60);//24h
sManager.setSessionIdCookie(sC);

7.shiro的rememberMe

shiro通过UsernamePasswordToken.setRememberMe(true)，开启rememberMe后，会向浏览器set一个cookie（如"rememberMe"），值为用户对象的加密（subject对象）

下次登录，服务器发现有这个cookie，就不会触发subject.login方法，不用比对jsessionId，，通过("/**", "user")user拦截器，访问所有user控制的路径，并在第一次请求时，set新的jsessionId，访问authc需再次登录

需要用户信息时，从rememberMe值中解析出用户信息

shiro的logout方法会消除rememberMe的值


8.web浏览器的会话恢复功能
现在很多浏览器有会话恢复功能，关闭浏览器，会保留所有的tab标签，把cookie存在硬盘上，重新打开浏览器的时候cookie也会恢复，jsessionId一直在，就像没关闭过浏览器，会话一直没有断开

浏览器的会话恢复功能估计也是有时限的，可能为10分钟~48小时

出于安全考虑，在shiro的setSessionManager中设置session的过期时间，保证安全性。
-------------------------------
自己对shiro登录认证 加rememberMe功能 流程的猜想：

1.shiro配置类，生成SecurityManager（DefaultWebSecurityManager）认证管理器，
将realm的AuthenticationInfo认证方法，注入SecurityManager

2.shiro配置类中ShiroFilterFactoryBean过滤器，
ShiroFilterFactoryBean过滤器注入SecurityManager（realm的AuthenticationInfo认证方法）
ShiroFilterFactoryBean过滤器，.setFilterChainDefinitionMap，设置FilterChainDefinitionMap过滤规则和过滤失败后登录路由

3.用户登录请求login时，controller接收到的loginVo，封装入UsernamePasswordToken（token）中，借助subject对象，将UsernamePasswordToken传入subject
通过subject传入SecurityManager

4.shiro的AuthenticationInfo基于token中的username查询数据库user对象，数据库user封装成数据库认证信息SimpleAuthenticationInfo，交给SecurityManager

5.SecurityManager负责比对subject（传入的用户信息）和SimpleAuthenticationInfo（基于传入token中的用户名查询数据库的SimpleAuthenticationInfo用户信息）

6.如果不通过SecurityManager会调用ShiroFilterFactoryBean的过滤失败后返回登录路由

7.以后每次请求都会对比jsessionId是否一致，不一致会返回登录路由。关闭浏览器jsessionId失效

8.配置记住我功能，将shiro.CookieRememberMeManager记住我功能对象，注入SecurityManager

9.将authc过滤器改为user

10.前端选择记住我登录，后台token.setRememberMe(true);，向浏览器中set-cookie(rememberMe)，下次打开浏览器访问页面，有rememberMe这个cookie，就跳过jsessionId对比，能直接访问user权限的路径，再重新向浏览器set jsessionId
-------------------------------
CompletableFuture处理异步

LogsServiceImpl.java
@Service
public Future<Integer> insertLog(Logs entity) {
	//CompletableFuture.supplyAsync进入默认线程池
	CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
		@Override
		public Integer get() {
			try {
				//耗时操作
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//耗时操作结束后，才能拿到赋值
			int rows = logsDao.insertLog(entity);
			return rows;
		}
	});
	//不阻塞，直接返回
	return future;
}	

调用处：
@Autowired
private LogsService logsService;
//不用等上面的耗时操作，直接拿到future
Future<Integer> future = logsService.insertLog(new Logs());
//此处代码不会被阻塞
...
//在future取值的地方，才会被阻塞
Integer rows = future.get();
-------------------------------
Lambda表达式（类似js中的箭头函数）

public Future<Integer> insertLog(Logs entity) {
	//CompletableFuture.supplyAsync进入默认线程池
	CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
		@Override
		public Integer get() {
			try {
				//耗时操作
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//耗时操作结束后，才能拿到赋值
			int rows = logsDao.insertLog(entity);
			return rows;
		}
	});
	//不阻塞，直接返回
	return future;
}

用Lambda可以简写成：
public Future<Integer> insertLog(Logs entity){
	CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> logsDao.insertLog(entity));
	return future;
}
会自动return logsDao.insertLog(entity)的值
-------------------------------
maven中的SNAPSHOT和RELEASE
SNAPSHOT，开发版本（快照版本）：
<version>1.0-SNAPSHOT</version>
版本号不用变，每次会自动加上时间戳，引用的jar包会自动更新

RELEASE，正式版本
<version>1.0</version>
会锁定jar，不使用更新

<version>1.0-SNAPSHOT</version>，
<version>0.0.1-SNAPSHOT</version>区别：
<version>1.0</version>
<version>0.0.1</version>
起始版本约定不一样
-------------------------------
maven.exclusion
子项目不需要，父项目的某个依赖时添加
-------------------------------
服务器的数据存储：
1.文本数据
以文本形式，存储在服务器数据库
2.图片数据
以图片形式，存储在服务器图片目录下
-------------------------------
idea断点
断点打在要测试的开头，然后f6步进，往下执行
-------------------------------
遍历map
Map<String,String> params = new HashMap<String,String>();
for (Map.Entry<String, String> entry : params.entrySet()) {
	System.out.println(entry.getKey());
	System.out.println(entry.getValue());
}
-------------------------------
java用map实现枚举功能

Map<Integer, String> map = new HashMap<Integer, String>();
//输入规则
map.put(1,"username");
map.put(2,"phone");
map.put(3,"email");
//type是传入参数，值为1~3，利用map得到type对应的值
String column = map.get(type);
-------------------------------
restful风格传参时，put、post传参无需@RequestBody接收
controller可用po对象或@PathVariable注解直接接收
-------------------------------
tomcat=>消息中间件（解决海量数据同步处理问题）=>数据库
-------------------------------
(@RequestParam String name)，post请求传递单个参数
---------------------
在静态方法中获取yml配置文件的值
public static Object getYmlValue(Object key){
	Resource resource = new ClassPathResource("application-dev.yml");
	Properties properties = null;
	try {
		YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
		yamlFactory.setResources(resource);
		properties =  yamlFactory.getObject();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	return properties.get(key);
}
public static void main(String[] args) {
	System.out.println(getYmlValue("server.port"));//9011
}
---------------------
sha512算法配置文件密码加密
1.java1.8\jre\lib\security下
加入US_export_policy.jar，local_policy.jar两个jar包
2.pom依赖
<dependency>
	<groupId>com.github.ulisesbocchio</groupId>
	<artifactId>jasypt-spring-boot-starter</artifactId>
	<version>3.0.3</version>
</dependency>
3.配置文件
...
	username: ENC(...)
	password: ENC(...)
jasypt:
  encryptor:
    algorithm: PBEWITHHMACSHA512ANDAES_256
4.java指令添加参数，jasypt盐值
java -jar -Djasypt.encryptor.password=salt xxx.jar	

sha512算法加解密
public class JasypUtil {

    private static final String PBEWITHHMACSHA512ANDAES_256 = "PBEWITHHMACSHA512ANDAES_256";
    public static String encryptWithSHA512(String plainText, String factor) {
        // 1. 创建加解密工具实例
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        // 2. 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(factor);
        config.setAlgorithm(PBEWITHHMACSHA512ANDAES_256);
        // 为减少配置文件的书写，以下都是 Jasyp 3.x 版本，配置文件默认配置
        config.setKeyObtentionIterations( "1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        // 3. 加密
        return encryptor.encrypt(plainText);
    }

    public static String decryptWithSHA512(String encryptedText, String factor) {
        // 1. 创建加解密工具实例
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        // 2. 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(factor);
        config.setAlgorithm(PBEWITHHMACSHA512ANDAES_256);
        // 为减少配置文件的书写，以下都是 Jasyp 3.x 版本，配置文件默认配置
        config.setKeyObtentionIterations( "1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        // 3. 解密
        return encryptor.decrypt(encryptedText);
    }
    public static void main(String[] args) {
        //盐值
        String factor = "input_salt";
        //需要加密的明文
        String plainText = "123456";
        String encryptWithSHA512Str = encryptWithSHA512(plainText, factor);
        String decryptWithSHA512Str = decryptWithSHA512(encryptWithSHA512Str, factor);
        System.out.println();
        System.out.println("采用SHA512加密前原文密文：" + encryptWithSHA512Str);
        System.out.println("采用SHA512解密后密文原文:" + decryptWithSHA512Str);
    }
}
---------------------
工具类中静态方法赋值
将@Value("${qxn.jasypt.factor}")赋在静态属性的set方法上，因为set方法不是静态的，等spring容器启动，静态属性会赋上值
eg:
@Component
public class JasypUtil {
	private static String factor;
	@Value("${qxn.jasypt.factor}")
	public void setFactor(String factor){
		this.factor = factor;
	}
	public static void main() {
		System.out.println(factor);
	}
}
容器启动后，调方法时能获取到配置文件的值：
JasypUtil.main();
---------------------
子类实例用接口接收的原因
List list = new ArrayList();
Map map = new HashMap();
方便日后重构，如果哪天ArrayList需要换成LinkedList或者Vector，
只需改List list = new LinkedList();这一行代码即可。
如果用ArrayList list = new ArrayList();接收，后面每行都得改。
这就是面向接口编程。方便代码重构。