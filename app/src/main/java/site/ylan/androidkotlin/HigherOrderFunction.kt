package site.ylan.androidkotlin

import java.util.function.BinaryOperator

class HigherOrderFunction

inline fun num1AndNum2(num1: Int, num2: Int, operator: (Int, Int) -> Int): Int {
    return operator(num1, num2)
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

fun StringBuilder.build(block:StringBuilder.() -> Unit):StringBuilder{
    block()
    return this
}

//fun main() {
//
//    println(num1AndNum2(1, 2, ::plus))
//    println(num1AndNum2(1, 2, ::minus))
//    num1AndNum2(1, 2) { n1, n2 ->
//        n1 * n2
//    }
//
//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    val result = StringBuilder().build {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//    }
//    println(result.toString())
//}

fun printString1(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

inline fun printString2(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

//fun main() {
//    println("main start")
//    val str = ""
//    printString1(str) { s ->
//        println("lambda start")
//        if (s.isEmpty()) return@printString1
//        println(s)
//        println("lambda end")
//    }
//    println("main end")
//}

//fun main() {
//    println("main start")
//    val str = ""
//    printString2(str) { s ->
//        println("lambda start")
//        if (s.isEmpty()) return
//        println(s)
//        println("lambda end")
//    }
//    println("main end")
//}

inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}