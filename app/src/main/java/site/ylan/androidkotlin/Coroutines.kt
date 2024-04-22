package site.ylan.androidkotlin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Coroutines

fun main() {

    GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)                            // 让当前协程延迟指定时间
        println("codes run in coroutine scope finished")
    }
    Thread.sleep(1000)

    // 测试环境使用，生产环境有性能问题
    runBlocking {
        println("codes run in coroutine scope")
        delay(1500)                            // 让当前协程延迟指定时间
        println("codes run in coroutine scope finished")
    }

    // 创建多个协程
    runBlocking {
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
    }

    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            launch {
                println(".")
            }
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)

    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10) {
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope finished")
    }
    println("runBlocking finished")


    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        // 处理具体的逻辑
    }
    scope.cancel()

//    runBlocking {
//        val result = async {
//            5 + 5
//        }.await()
//        println(result)
//    }

//    runBlocking {
//        val start = System.currentTimeMillis()
//        val result1 = async {
//            delay(1000)
//            5 + 5
//        }.await()
//        val result2 = async {
//            delay(1000)
//            4 + 6
//        }.await()
//        println("result is ${result1 + result2}.")
//        val end = System.currentTimeMillis()
//        println("cost ${end - start} ms.")
//    }

    runBlocking {
        val start = System.currentTimeMillis()
        val result1 = async {
            delay(1000)
            5 + 5
        }
        val result2 = async {
            delay(1000)
            4 + 6
        }
        println("result is ${result1.await() + result2.await()}.")
        val end = System.currentTimeMillis()
        println("cost ${end - start} ms.")
    }



}

// 挂起函数，无法提供协程作用域
//suspend fun printDot() {
//    println(".")
//    delay(1000)
//}
suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}