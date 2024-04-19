package site.ylan.k03_fragment.model.entity

import site.ylan.k03_fragment.utils.RandomUtils

class News(val title: String, val context: String){
    // 数据
    companion object{
        fun getNews(): List<News> {
            val newsList = ArrayList<News>()
            for (i in 1..50) {
                newsList.add(News("This is news title $i", RandomUtils.getRandomLengthString("This is news content $i. ")))
            }
            return newsList
        }
    }
}