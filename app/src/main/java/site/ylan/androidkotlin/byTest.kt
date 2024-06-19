package site.ylan.androidkotlin

import kotlin.reflect.KProperty

class byTest

//===================== 属性委托 =====================//
class MyClass {
    var p by Delegate()
}

class Delegate {

    // 属性
    private var propValue: Any? = null

    // operator关键字 读取属性
    operator fun getValue(clazz: MyClass, prop: KProperty<*>): Any? {
        return propValue
    }

    // operator关键字 写入属性
    operator fun setValue(clazz: MyClass, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}


// 延迟属性顶层函数
fun <T> later(block: () -> T) = Later(block)

// 延迟属性类
@Suppress("UNCHECKED_CAST")
class Later<T>(val block: () -> T) {

    // 属性
    private var value: Any? = null

    // operator关键字 读取属性
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) value = block()
        return value as T
    }
}

fun main() {
    val p by later {
        println("run codes inside later block")
        "test later"
    }
    println(p)
    println(p)
    println(p)
}