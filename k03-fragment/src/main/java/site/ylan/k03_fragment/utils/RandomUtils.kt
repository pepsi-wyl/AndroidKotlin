package site.ylan.k03_fragment.utils

import site.ylan.k03_fragment.common.times

object RandomUtils {
//    fun getRandomLengthString(str: String): String {
//        return StringBuilder().apply {
//            repeat((1..20).random()) {
//                append(str)
//            }
//        }.toString()
//    }
    fun getRandomLengthString(str: String): String =  str * (1..20).random()
}