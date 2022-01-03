# jvm学习笔记

### 一、java概念理解：

java是一种面向对象、静态类型、编译执行、有VM/GC和运行时、跨平台的高级语言。

### 二、字节码、类加载器、虚拟机内存

#### 2.1字节码

   java bytecode 由单字节的指令组成，理论上最多支持256个操作码，实际上java只使用了200左右的操作码，还有一些操作码留给调试操作。

#####  2.1.1分类

（1）栈操作指令，包括与局部变量交互的指令

（2）程序流程控制指令

（3）对象操作指令，包括方法调用指令

（4）算数运算及类型转换指令

*将java编译为字节码文件指令：javac hello.java,查看程序执行时jvm内部执行过程指令：javap -c

##### 2.1.2 字节码演示

```java
complied from "helloByteCode.java"
public class demo.jvm0104.HelloByteCode();
   code:
       0:aload_0   //表示将局部方案表里面第0个位置的值加载到栈上，a:表示引用变量load:栈操作指令
       1：invokespecial #1 //引用了当前类的父类Object #1：常量池中的常量
       4：return
public static void main(java.lang.String);
    code:
       0:new #2 //在常量池中拿到标号2这个对象，new出来
       3： dup //压栈
       4：invokespecial #3 //调用初始化的方法
       7：astore_1 //将标号1返回到局部方案表里面
       8：return
           
```

| 虚拟机jvm执行一段代码时会把本地的变量存在“局部方案表”（localvariable）里面，在栈上做计算时，如果使用到了表里面的变量，就会通过load指令把他们加载到栈上面，在栈上计算完成后需要将值存回到变量表里面，用store指令。 |
| ------------------------------------------------------------ |

#### 2.2字节码的运行时结构

```java
```

##### 2.2.1字节码的运行时结构

JVM是一台基于栈的计算机器，每个线程都有一个独属于自己的线程栈，用于存贮栈正，

每一次方法调用，JVM都会自动创建一个栈zheng栈zheng由操作数栈、局部变量数组以及一个class引用组成，class引用指向当前方法在运行时常量池中对应的class.![310350886779720230](C:\Users\86157\AppData\Local\Temp\WeChat Files\310350886779720230.jpg)



##### 2.2.2 算数操作与类型转换

对应表如图：

![3388246432744553](C:\Users\86157\AppData\Local\Temp\WeChat Files\3388246432744553.jpg)

#### 2.3流程控制的字节码：

if_icmpge ----对应if条件（cmp表示比较，ge 大于等于）

goto-----循环的结束

一个完整的循环控制：

![241032731160776921](C:\Users\86157\AppData\Local\Temp\WeChat Files\241032731160776921.jpg)

#### 2.4方法调用的指令

Invokestatic:用于调用某个类的静态方法，这是方法调用指令中最快的一个。

invokespecial:用来调用构造函数，但也可以调用同一个类中的private方法，以及可见的超类方法。

invokevirtual:如果是具体类型的目标对象，invokevirtual用于调用公共、受保护和package级的私有方法。

invokeinterface:当通过接口引用来调用方法时，将会编译为invokeinterface指令。

invokedynamic:JDK7新增的指令，是实现“动态类型语言”支持而升级的改进，同时也是JDK8以后支持lambda表达式的实现基础。

### 三、JVM类加载

#### 3.1类的生命周期

grap LR;

   加载-->校验 

  校验[方形]-->准备[方向]
   准备-->解析[方形]
   解析-->初始化[方形]
   初始化-->使用[方形]
   使用-->卸载[方形]

   



（1）加载：找class文件

（2）验证：验证格式，依赖

（3）准备：加载静态字段、方法表

（4）解析：将符号解析为引用

（5）初始化:初始化构造器、静态变量赋值、初始化静态方法块

（6）使用

（7）卸载

#### 3.2类的加载时机

1、当虚拟机运行时，初始化用户指定的主类，就是启动执行的main方法所在的类。

2、当遇到用于新建目标类实例的new指令时，初始化new指令的目标类，就是new一个类的时候需要初始化

3、当遇到调用静态方法的指令时，初始化该静态方法所在的类。

4、当遇到静态方法字段的指令时，初始化该静态字段所在的类。

5、子类的初始化会触发父类的初始化

6、如果一个接口定义了default方法，那么直接实现或者间接实现该接口的初始化，会触发该接口的初始化

7、使用反射API对某个类进行反射调用时，初始化这个类，其实跟之前一样，反射调用要么是已经有实例了，要么是静态方法，都需要初始化。

8、当初次调用MethodHandle实例时，初始化该methodThandle指向的方法所在的类。

#### 3.3不会初始化（可能会加载）

1、通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化，

2、定义对象数组，不会触发该类的初始化

3、常量在编译期间会存入调用类的常量池中，本质并没有直接引用定义常量的类，不会触发定义常量所在的类。

4、通过类名获取class对象，不会触发类的初始化，如hello.class不会让hello类初始化

5、通过classforname加载指定类时，如果指定参数initialize为false时，也不会触发类初始化，其实这个参数是告诉虚拟机，是否要对类进行初始化。

6、通过ClassLoader默认的loadclass方法，也不会触发初始化动作，（加载了，但不会初始化）

#### 3.4三类加载

1.启动类加载器（BootstrapClassLoader）：加载jvm最核心的jar包

2、扩展类加载器（ExlClassLoader）：加载一些额外的类(在lib迷路下面加载的一些jar包)

3、应用类加载器（AppClassLoader）：加载编写的类和他们依赖的指定的classpath

<img src="D:\java进阶训练营\捕获1.PNG" style="zoom:50%;" />



##### 3.4.1加载器的特点

（1）双亲委托:如上图上面的加载器一般是底层加载器的父类，当加载一个类时，如应用类加载器想去加载一个类，先不自己加载，先去委托应用类加载器，应用类加载器如果没有，则委托他的父类启动类加载器加载，如果哪个层级加载了这个类，就会返回这个引用给自己的子类加载器，避免重复加载。

（2）负责依赖：如果hello.class依赖了另外的类型，则加载的时候也需要将依赖的类型也加载。

（3）缓存加载：默认情况下，任何一个类只会被加载一次，当它被加载万就会被缓存在内存里面。

打印各个加载器下的包详情实例：

```java
import sun.security.provider.Sun;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class JvmClassLoderPrintPath {
    public static void main(String[] args) {
        //启动类加载器
        URL[] urls= sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器 ");
        for (URL url: urls) {
            System.out.println("======>"+url.toExternalForm());
        }
        printClassLoader("扩展类加载器",JvmClassLoderPrintPath.class.getClassLoader().getParent());
        printClassLoader("应用类加载器",JvmClassLoderPrintPath.class.getClassLoader());

    }
    private static void printClassLoader(String name,ClassLoader  classLoader){
        System.out.println();
        if(null !=classLoader){
            System.out.println(name+"Classloader ->"+classLoader.toString());
            printURLForClassloader(classLoader);
        }else{
            System.out.println(name+"classloader -> null");
        }

    }
    private static void printURLForClassloader(ClassLoader classLoader){
        Object cup=insightField(classLoader,"ucp");
        Object path=insightField(cup,"path");
        List paths=(List) path;
        for (Object p: paths) {
            System.out.println("====>" +p.toString());

        }

    }
    private static Object insightField(Object obj,String fName){
        Field f=null;
        try {
            if(obj instanceof URLClassLoader){
                f=URLClassLoader.class.getDeclaredField(fName);
            }else{
                f=obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

```



#### 四、添加引用类的集中方式

1、放到JDK的lib/ext下面，或者Djava.ext.dirs

2、java-cp/classpath 或者class文件放到当前路劲

3、自定义classLoader加载

4、拿到当前执行类的ClassLoader，反射调用addUrl方法去添加Jar或路劲（JDK9无效）

#### 五、JVM内存结构

<img src="D:\java进阶训练营\捕获3.PNG" style="zoom:50%;" />



每个线程栈都只能访问自己的线程栈。

每个 线程都不能访问（看不见）其他线程的局部变量。

所有原生类型的局部变量都存储在线程栈中，因此对其他线程是不可见的。

线程可以将一个原生变量值的副本传给另一个线程，但是不能共享原生局部变量本省。

堆内存中包括了java中创建的所有对象，不管是哪个线程创建的，其中包括了包装类型。

不管是创建一个对象并将其赋值给局部变量还是赋值给成员变量，创建的对象都会保存在堆内存中。

<img src="D:\java进阶训练营\文档\微信图片_20220102231735.jpg" style="zoom:50%;" />

总结：

方法中使用的原生数据类型和对象引用地址在栈上存储；对象、对象成员与类定义、静态变量在堆上。

堆内存又称为“共享堆”，堆中所有对象，可以被所有线程访问，只要他们能拿到对象的引用地址。

如果一个线程可以访问某个对象时，也就可以访问该对象的成员变量。

如果两个 线程同时调用某个对象的同一方法，则他们都可以访问到这个对象的成员变量，但是每个线程的局部变量副本时独立的。

#### 六、JVM堆内存结构

![](D:\java进阶训练营\4.PNG)



每启动一个线程，JVM就会在栈空间栈分配对应的线程栈

线程栈也叫java方法栈，如果使用了JNI方法，则会分配一个单独的本地方法栈。

线程执行过程中，一般会有多个方法组成调用栈，

![](D:\java进阶训练营\5.PNG)

堆内存是所有线程共用的内存空间，JVM将Heap内存分为年轻代、老年代两个部分。

年轻代划分为三个内存池，新生代（Eden space）、存活区（Survivor space），在大部分GC算法中有两个存活区（S0,S1），在我们可以观察到的任何时刻，S0和S1总有一个是空的，但一般较小，不浪费多少空间。

No-Heap本质还是Heap,只是一般不归GC管理，里面划分为3个内存池，

Metaspace 以前叫持久代，存放class信息的

code Cache 存放JIT编译器编译后的本地机器代码。

#### 七、JVM启动参数

<img src="D:\java进阶训练营\7.PNG" style="zoom:50%;" />

以-开头为标准参数，所有的JVM都要实现这些参数，并且向后兼容。

-D 设置系统属性

以-X开头为非标准参数，基本都是传给JVM的，默认JVM实现这些参数的功能，但是并不不保证所有JVM实现都满足，且不保证向后兼容，可使用java -X查看当前JVM支持的非标准参数。

以-XX：开头为非稳定参数，专门用于控制JVM的行为，跟具体的JVM实现有关，随时可能在下个版本取消。

-XX：+-Flags +-是对布尔值进行开关。

-XX：key=value 指定某个选项的值。

##### 7.1JVM启动参数--系统属性参数

<img src="D:\java进阶训练营\文档\微信图片_20220103000212.jpg" style="zoom:80%;" />





##### 7.2JVM启动参数--运行模式

（1）-server:设置JVM使用server模式，特点是启动速度比较慢，但运行时性能和内存管理效率很高，适用于生产环境，在具有64位能力的JDK环境下默认启动该模式。而忽略-client参数

（2）-client： JDK1.7之前在32位的x86机器上默认值是-client 设置JVM使用-client模式，特点是启动速度比较快，但是运行时性能和内存管理效率不高

（3）-Xint : 在解释模式下运行，-Xint 标记会强制JVM解释执行所有的字节，会降低运行速度,通常会降低10倍。

（4）-Xcomp:与-Xint正好相反，JVM第一次使用时会把所有的字节码编译成本地代码，从而带来最大程度的优化。

（5）-Xmixed:混合模式

#### 7.3JVM启动参数--堆内存

![](D:\java进阶训练营\文档\微信图片_20220103001442.jpg)

-Xmx:指定最大堆内存。如-Xmx4g 只是限制了Heap部分的最大值为4g.这只是限制了Heap部分的最大值为4G，这个内存不包括栈内存，也不包括堆外使用的内存。

-Xms :指定堆内存空间的初始大小，如-Xms4g。指定的是内存大小，并不是操作系统实际分配的初始值，而是GC先规划好，用到才分配，专用服务器上需要保持-Xms和-Xmx一致，否则刚启动可能就有好几个fullGC。当两者配置不一致时，内存扩容可能导致性能抖动。

-Xmn:等价于-XX：NewSize,使用G1垃圾收集器，不应该设置该选项，在其他的某些业务场景下可以设置，官方建议设置为-Xmx的1/2-1/4.（young区的大小）

-XX：MaxMetaSpaceSize,这是JDK1.7之前使用的JAVA8默认容许法人空间无限大，此参数无效。（原始数据区、持久代大小）

-XX:MaxDriectMemorySize=size,系统可以使用的最大堆外内存，这个参数跟-Dsun,nio.MaxDriectMemorySize效果相同。（堆外内存）

-Xss:设置每个线程栈的字节数，影响栈的深度。

关系：Xmx>Xms>Xmn>

![](D:\java进阶训练营\捕获8.PNG)

注意：

Xms 设置堆内存的初始值

Xmx 设置堆内存的最大值

Xmn 设置堆内存中的年轻代的最大值

Meta 区不属于堆内存, 归属为非堆

DirectMemory 直接内存, 属于 JVM 内存中开辟出来的本地内存空间。

Xss设置的是单个线程栈的最大空间

JVM进程空间中的内存一般来说包括以下这些部分:

- 堆内存(Xms ~ Xmx) = 年轻代(~Xmn) + 老年代
- 非堆 = Meta + CodeCache + ...
- Native内存 = 直接内存 + Native + ...
- 栈内存 = n * Xss

另外，注意区分规范与实现的区别, 需要根据具体实现以及版本, 才能确定。 一般来说，我们的目的是为了排查故障和诊断问题，大致弄清楚这些参数和空间的关系即可。 具体设置时还需要留一些冗余量。

