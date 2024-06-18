package site.ylan.androidkotlin

import android.content.Context
import android.content.Intent

/**
 * 范型工具类
 */
object GenericUtil {

    /**
     * 泛型实化,获取范型类型
     * 内联函数inline关键字 + reified关键字
     */
    inline fun <reified T> getGenericType() = T::class.java

    inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
        val intent = Intent(context, T::class.java)
        intent.block()
        context.startActivity(intent)
    }
}

fun main() {
    val result1 = GenericUtil.getGenericType<String>()
    val result2 = GenericUtil.getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}