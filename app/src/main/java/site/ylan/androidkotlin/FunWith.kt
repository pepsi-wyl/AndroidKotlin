package site.ylan.androidkotlin

class FunWith

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) append(fruit).append("\n")
        append("Ate all fruits.")
        toString()
    }
    println(result)
}