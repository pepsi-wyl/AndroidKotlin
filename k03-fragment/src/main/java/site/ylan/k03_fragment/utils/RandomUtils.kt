package site.ylan.k03_fragment.utils

object RandomUtils {
    fun getRandomLengthString(str: String): String {
        return StringBuilder().apply {
            repeat((1..20).random()) {
                append(str)
            }
        }.toString()
    }
}