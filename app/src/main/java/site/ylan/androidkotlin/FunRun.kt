package site.ylan.androidkotlin

class FunRun

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuffer().run {
        append("Start eating fruits.\n")
        for (fruit in list) append(fruit).append("\n")
        append("Ate all fruits.")
        toString()
    }
    println(result)
}