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

ctrl+f11 运行代码快捷键

main alt+/ 快捷建main方法

System.out.println(); 输出并换行
System.out.print(); 输出不换行

main方法只有args参数能变

刷题：牛客网？

java核心编程思想（白黄面）

标识符：包名，类名，方法名
关键字：53关键字，其中2个保留字：const,goto。不能用作标识符

数据类型
位Bit 字节byte 1Bit=8byte
基本类型（8种）引用类型（很多）
整数型：            字节空间                                         取值范围
byte        1               -2^7 2^7-1
short       2               -2^15 2^15-1
int         4               -2^31 2^31-1
long        8               -2^63 2^63-1

浮点型：
float       4               单精度，小数部分精度要求不高
double      8               双精度，小数部分精度高并操作值大

字符：
char        2               0 65535

布尔：
boolean     1               true/false

引用类似：
类，接口，数组，...

eclipse快捷键
ctrl+d 删除整行

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
0x   -16进制
0    -8进制
\u   -char类型，16进制

隐式转换
按字节 由小转大 直接转
如：
Byte a = 120;
Int b = a; // 直接转
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
1.计算结果的数据类型，与最大类型一致
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
&&逻辑与+短路与（短路与：前为false，后不执行）
&逻辑与 同true为true
||逻辑或+短路或（短路或：前为true，后不执行）
|逻辑或 一true为true
+ 字符串连接
! 非
4.三元运算符
?:
5.赋值运算符
= 赋值运算
+= -= *= /= 复合的赋值运算 


















