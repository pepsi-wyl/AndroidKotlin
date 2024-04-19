package site.ylan.k10_service.myThread

import kotlin.concurrent.thread

class MyThread1 : Thread(){
    override fun run() {
        println("子线程开始执行！！！")
    }
}

class MyThread2 : Runnable{
    override fun run() {
        println("子线程开始执行！！！")
    }
}

// Main函数
fun main() {
    // 开启线程方式一
    MyThread1().start()
    // 开启线程方式二
    Thread(MyThread2()).start()
    // 开启线程方式三
    Thread{
        println("子线程开始执行！！！")
    }.start()
    // 开启线程方式四
    thread {
        println("子线程开始执行！！！")
    }
}