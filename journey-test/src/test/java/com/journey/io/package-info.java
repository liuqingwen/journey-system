package com.journey.io;

// Linux IO
// 1. 阻塞IO
// 2. 非阻塞IO
// 3. IO复用
// 4. 信号驱动IO
// 5. 异步IO

// Linux 1-4 都是同步 5 是异步

// Java IO






// Linux 将内存划分为 内核区 和用户区。内核区管理所有硬件资源，应用程序通过系统调用与内核交互，达到使用硬件资源的目的。
// io read(一个阻塞函数): 应用程序通过系统调用 read 发起一个读请求，这个时候内核创建一个文件描述符(File Descriptor)，并通过驱动程序向硬件发送读指令，并将读到的数据放到这个描述符对应的结构体的内存缓冲区，然后在把这个数据读到用户进程空间中，这样才完成一次读操作。


// 一个基本的 io，在调用的时候会涉及两个对象：一个是调用这个 io 的进程对象，另一个是系统内核(Kernel)。当一个 read 发生时，它会经历两个阶段：
// 1. 通过 read 系统调用向内核(Kernel)发起一个读请求。
// 2. 内核向硬件发送读指令，并等待读就绪。
// 3. 内核把将要读取的数据复制到文件描述符指定的的内核缓冲区中。
// 4. 将数据从内核缓冲区复制到用户进程空间。


// IO 复用的使用场景
// 1. 客户端程序需要同时处理交互式的输入和服务器之间的网络连接。
// 2. 客户端需要对多个网络连接做出反应。
// 3. 服务器需要同时处理多个处于监听状态和多个连接状态的套接字。
// 4. 服务器需要处理多个网络协议的套接字。

// 目前支持 IO 复用的系统调用 select、pselect、poll、epoll。
// select 循环处理 ，支持的描述符默认 1024; epoll callback 回调
// epoll 在有大量非活跃连接的时候 比 select 高效
// epoll 在很少非活跃连接的时候 比 select 低效