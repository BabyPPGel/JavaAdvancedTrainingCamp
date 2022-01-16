作业：

2根据上述自己对1和2的演示，写一段对于不同GC和堆内存的总结，

在不同的GC策略，不同的各种参数配置下GC的表现，GC的特点，GC在使用时适用的场景，

(1) 串行垃圾收集器

```shell
 -XX:+UseSerialGC
 在配置了-XX:+PrintGCDetails时，能打印出GC的详细信息
 -XX:+PrintGCDateStamps时打印出时间戳，
 GC日志里面记录了执行GC的次数，每次GC年轻代或者老年代内存的变化，GC暂停的时间，有多少内存的对象由年轻代进入老年代，
 
```

特点及适用场景：

串行GC对年轻代使用mark-copy（标记-复制）算法，对老年代使用mark-sweep-compact(标记-清除-整理)算法。
两者都是单线程的垃圾回收器，不能进行并行处理，所以都会触发全栈暂停（STW）,停止所有的应用线程。
因此这种GC不能充分利用多核CPU，不管有多少CPU内核，JVM进行垃圾收集时都只能使用单核,CPU利用率高，暂停时间长，简单粗暴。

(2)并行垃圾收集器： 

```shell
-XX:+UseParallelGC
在配置了-XX:+PrintGCDetails时，能打印出GC的详细信息
 -XX:+PrintGCDateStamps时打印出时间戳，
 GC日志里面记录了执行GC的次数，每次GC年轻代或者老年代内存的变化，GC暂停的时间，有多少内存的对象由年轻代进入老年代，

```

特点及适用场景：

1、并行垃圾收集器对年轻代使用 标记-复制(mark-copy) 算法，对老年代使用 标记-清除-整理(mark

sweep-compact) 算法。

2、年轻代和老年代的垃圾回收时都会触发STW事件，暂停所有的应用线程，再来执行垃圾收集。

3、在GC期间，所有CPU内核都在并行处理垃圾，所以总暂停时间短。

4、在两次GC周期的间隔期，没有GC线程在运行，不会消耗任何系统资源。

5、因为并行GC的所有阶段都不能中断，所以并行GC很可能会出现长时间的卡顿。所以不适用于对系统延迟有较高要求的垃圾回收。

6、并行GC适用于多核服务器，主要目标是增加吞吐量，因为堆系统资源的 有效使用能达到更高的吞吐量。

(3)CMS垃圾收集器：

阶段 1：Initial Mark(初始标记) 

阶段 2：Concurrent Mark(并发标记) 

阶段 3：Concurrent Preclean(并发预清理) 

阶段 4：Concurrent Abortable Preclean(可取消的并发预清理) 

阶段 5： Final Remark(最终标记) 

阶段 6： Concurrent Sweep(并发清除) 

阶段 7： Concurrent Reset(并发重置) 

```shell
-XX:+UseConcMarkSweepGC /-XX:+UseParNewGC/ -XX:+UseConcMarkSweepGC
在配置了-XX:+PrintGCDetails时，能打印出GC的详细信息
 -XX:+PrintGCDateStamps时打印出时间戳，
与串行GC和并行GC相比
```

其设计目标是避免在老年代GC时出现长时间的卡顿。默认情况下，CMS 使用的并发线程数等于CPU内核数的 1/4 

特点

对年轻代采用并行SWT的标记--复制（mark--copy）算法，对老年代主要使用并发标记--清除（mark--sweep）算法。

CMS GC的设计目标是避免在老年代垃圾收集时出现长时间的卡顿，主要通过以下方式：

- 不对老年代进行整理，而是使用空闲列表来管理内存空间的回收。

- 在标记--清除阶段大部分工作和线程一起并发运行

  在这些阶段并没有明显的应用线程暂停，但是它会跟应用线程争抢CPU，默认情况下CMS使用的并发线程数为CPU核心数的1/4.

- 如果服务器是多核CPU，并且调优目标是降低GC停顿导致的系统延迟，使用CMS时明智的选择。进行老年代的回收时，可能会伴随多次年轻代的minor GC（young区的GC进行的过程）。

- CMS垃圾收集器在减少停顿时间上做了许多复杂而有用的工作，用于垃圾回收的并发线程执行的同时并不需要暂停应用线程

（4）G1 GC

```shell
##配置命令/启动参数
-XX:+UseG1GC -XX:MaxGCPauseMilis=50
G1GC的日志比前面的日志都要复杂，详细的打印了年轻代，GC前后整个堆、存活区（Survivors）、Eden 区的使用量以及总量，还有详细描述了Worker 线程的行为等。
```

特点

- 全称为Garbage-Frist 意为垃圾优先，那一块垃圾多就优先清理哪一块。
- 设计目标：将SWT停顿的时间和分布，变成预期而且可以配置的。
- G1 GC堆不再分为年轻代和老年代，而是划分为多个（通常2048个）小块，Region
- 每个小块可能一会被定义为Eden区，一会被指定为Survivor区或者Old区。

这样划分之后，使得G1不必每次都去收集整个堆空间，而是以增量的方式进行处理，每次只是处理一小块内存块。

每次GC暂停都会收集所有年轻代的内存块，但一般只包含部分老年代内存块。

(5)ZGC

```shell
##配置参数
-XX：UnlockExperimentalVMOptions -XX:+UseZGC -Xmx 16g
```



**ZGC的特点**：

1. GC最大停顿时间不超过10ms
2. 堆内存支持范围广，小至几百MB的堆空间，大至4TB的超大堆内存空间，（JDK13升至16TB）
3. 与G1相比应用吞吐量下降不超过15%
4. 当前只支持linux/x64位平台，JDK15后支持MAC和windows

