package site.ylan.androidkotlin

// String拓展函数
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

fun main() {
    val count = "ABC123xyz!@#".lettersCount()
    println(count)
}