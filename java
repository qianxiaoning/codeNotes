java -version
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

int整型？
String

<link rel="stylesheet" href="order.css"/>

/返回根目录

数据库>数据表=>（表头：字段，表记录）

数据库：
sqlserver(基本淘汰，技术古老),
oracle（收费，维护费）,
mysql（免费，开源）,
db2（主要于银行）,

Nosql(非关系型数据库):
redis（内存数据库）,
mongodb（分布式文件数据库？）

mysql:
登录 mysql -uroot -p
密码 root
对库操作：
创建jt_yh数据库：
create database jt_yh;
查看所有数据库：
show databases;
自带4个不能删，除test
删除数据库：
drop database jt_yh;

\c 退出当前操作

表操作：
创建表tb_door，:
选中数据库
use jt_yh;
建表：
primary key // 主键
auto_increment // 自增长
create table tb_door(id int primary key auto_increment,door_name varchar(200),tel varchar(100));
表中3个字段id,door_name,tel
查看所有表：
show tables;
查看表结构：
desc tb_door;
删除表：
drop table tb_door;
表记录操作：
向表中插入2条记录
insert into tb_door value(null,'yhdw1','666');
insert into tb_door value(null,'yhdw2','777');
查看 tb_door表中所有的记录
select * from tb_door; 
修改表中id为3的记录
update tb_door set tel='991' where id=3;
按某个顺序排序 默认升序
select * from tb_door order by tel;
降序
select * from tb_door order by tel desc;
查看表中所有的数据总数
select count(*) from tb_door;
删除某条指定的记录
delete from tb_door where id=3;

servlet:
1.接收请求，实现页面跳转
2.准备数据
jsp:

用软件操作数据库：
navicat for Mysql
可视化数据库工具
双击库
右键新建数据库
右键删除数据库
选中库，新建表，主键按钮、自动递增勾选，向下箭头新增表记录，字符集utf8
设计表：查看表结构
右键删除记录
验证sql对否：
查询-新建查询select * from tb_door where id=2; 运行
三个timestamp只能有一个根据当前时间戳更新
timestamp, int, double默认值为null

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

alt+/ 自动补全

eclip重置视图
window-perspective-reset perspective

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

doc命令
c: 快速进入c盘
dir 输出目录
mkdir xxx 创建文件夹
rmdir xxx 删除文件夹
cd / 到磁盘根目录
cls 清屏

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
/**文档注释*/

1.编译过程，ide保存时会调用jdk目录下/bin/javac.exe生成xxx.class文件
2.启动java虚拟机
3.虚拟机加载xxx.class字节码文件
4.进入这个类的main方法执行

jdk（开发工具包）> jre(运行类库)>jvm（java虚拟机）

main alt+/ 快捷建main方法

System.out.println(); 输出并换行
System.out.print(); 输出不换行

main方法只有args参数能变

刷题：牛客网？

java核心编程思想（白黄面）

标识符：包名，类名，方法名
关键字：53关键字，其中2个保留字：const,goto。不能用作标识符

数据类型
位Bit 字节byte 1byte=8Bit
基本类型 又叫原生类、内置类型（8种）引用类型（很多）
整数型：            字节空间                                         取值范围
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

eclipse快捷键：
ctrl+d 删除整行
alt+上下 代码上下移
ctrl+alt+上下 复制代码
alt+shit+l，只写右侧，提取变量
ctrl+f11 运行代码快捷键
f11 debug运行
alt+shift+r 改名
shift按住，鼠标悬浮在方法名上 查看调用的方法
ctrl+t 看继承结构
ctrl+o 显示成员大纲
双击大括号 复制方法内部所有代码
ctrl+n 新建文件
alt+shift+s generate construct from filed 生成构造函数
包名上按f2 改包名
ctrl+shift+t 快速打开类

设置代码模板  window->preferences->java->editor->template
nextint
int ${cursor} = new Scanner(System.in).nextInt();${:import(java.util.Scanner)}

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

for循环的执行顺序
for(表达式1;表达式2;表达式3){
	表达式4;
}
1=>2=>4=>3 =>2=>4=>3 =>2=>3

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

java重载
当参数顺序不一样，也是重载

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
次类不能被继承
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

运算符
^ 异或  

把类理解成模板或者图纸

对象是从类创建的具体实例，占独立堆内存空间

引用变量就像是实例对象的遥控器

debug调试
左侧双击加断点，f11debug执行
f5进入源码
f6向下执行
f7返回
f8连续向下执行，直到断点

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

再次使用相同字面值时，直接访问常量池中存在的实例，而不会创建

断点：
a
b
c   ---------------断点

当调试时，代码执行完b，到c前停止

字符串每次加号会创建新实例，所以长了会效率低

this代表本类对象的引用
super代表父类对象的引用

switch中只能判断byte,short,char,int,没有long,enum枚举,string

循环命名？
break outer;

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

父类中方法只要发现不同就调方法？

java和js不一样
java中 类中是成员变量，方法中是局部变量，不同方法的局部变量互不影响
类实例化后的成员变量各方法共享
如：
1.int a=1;
method(a);
syso(a);// 还是1

private void method(int a){
	a = 2;
}
2.但是同一方法中的子代码块不能影响父代码块

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

八种基本类型对应的包装类
Byte Short Integer Long
Float Double 
Character
Bolean 

正则表达式 regex
matches(正则) 是否匹配
split(正则) 用子串来拆分
replaceAll(正则) 替换所有

s.matches(regex)

java转义为 \

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

BigDecimal 精确浮点数运算 不new
IEEE-754规范
BigDecimal a = BigDecimal.valueOf(6);
BigDecimal b = BigDecimal.valueOf(6);
方法：
add(BigDecimal bd)
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

访问控制符
控制一个类，或类中的成员的访问范围
				类		包		子类		任意	  
public			1		1		1		1
protected		1		1		1
[default]		1		1
private			1

尽量使用小范围
public是与其他开发人员公开的，要尽量保持稳定不变
private更便于维护修改，不对其他代码造成影响

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

集合（重点）
用来存储一组数据的数据结构
数组缺点：
1.长度不可变
2.访问方式单一，只能用下标访问
3.在前面增删数据，操作繁琐

三个集合工具：
LinkedList
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

接口 特殊的类
是一个结构设计工具，用来解耦合，隔离实现
我的理解：
	接口和普通父类相比，同样是提取公共的功能。
	优化：
		1.写法更简化
		2.可以让子类多继承
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

异常 封装错误信息的对象
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

异常的继承结构
Throwable
	Error 系统级错误，没法修复
	Exception 可修复错误
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

System.exit(0);// 关闭虚拟机

字符串的+操作符
a = "aaa";
b = "bbb";
s = a+b;// 创建了2个实例对象，s1 = new StringBuilder(s); s1.toString();

s1 = "aaa"+"bbb"+"ccc";
等同于
s1 = "aaabbbccc";

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
4.匿名内部类（常用）
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

方法重写
1.子类重写父类方法 访问范围不能降低，能提高
2.不能比父类抛更多异常

接口方法默认范围
public abstract

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
























