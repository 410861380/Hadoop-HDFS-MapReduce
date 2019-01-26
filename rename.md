1.yarn的服务进程：resource manager和node manager 
2.nodemanager里面的maptask 真真的去运行MapReduce程序
3.一般情况下最好就是把resource manager 放在namenode节点上，把nodemanager 结点放在datanode节点上。
4.一个job 任务map阶段并行度由客户端提交的任务所决定。每一个split分配一个maptask并行处理。默认情况下，split大小=blocksize。

1.mapreduer的流程：+maptask +环形缓冲区+磁盘+归并排序+reducer task
2.writable类和writablecomparable类以及其他实现类
3.context中的参数和mapperl类和reducer类是对应的，对传进去的参数进行传输。
4.pantitioner自定义分区类
5.combiner对map阶段传进的数据进行小量的reducer，再汇总。
