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

main方法中的语句"System.out.println(s);"无法调用在main方法外声明的变量
private 静态的可以？

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
2.但是同一方法中的子代码块可以影响父代码块

String api
equals 比较字符串内容
charAt(i) 访问指定位置的字符
length() 字符长度
indexOf(子串) 查找子串起始位置的下标值，找不到返回-1
indexOf(子串,start) 从指定位置向后找
lastIndexOf 从后向前找
trim() 去除两端的空白字符，新建一个
substring(start)/substring(start,end) 截取子串

StringBuilder(jdk1.5)
和String区别：可变的字符序列，有对内部字符修改的方法
常用于：代替字符串做高效的字符串连接运算
内部数组默认初始容量16
存满翻倍+2
append() 在内部数组中追加新的字符
例：
StringBuilder sb = new StringBuilder();
sb.append("xxxxx");

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









