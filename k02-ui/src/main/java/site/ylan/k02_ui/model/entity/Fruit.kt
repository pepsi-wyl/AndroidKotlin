package site.ylan.k02_ui.model.entity

import site.ylan.k02_ui.R

class Fruit(val name: String, val imageId: Int)

// data集合
public val data = listOf(
    "Apple", "Banana", "Orange", "Watermelon",
    "Pear", "Grape", "Pineapple", "Strawberry",
    "Cherry", "Mango", "Apple", "Banana",
    "Orange", "Watermelon", "Pear", "Grape",
    "Pineapple", "Strawberry", "Cherry", "Mango"
)

// 数据集合
public val fruitList = ArrayList<Fruit>()

public fun initFruits() {
    repeat(10) {
        fruitList.add(Fruit("Apple", R.drawable.apple_pic))
        fruitList.add(Fruit("Banana", R.drawable.banana_pic))
        fruitList.add(Fruit("Orange", R.drawable.orange_pic))
        fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
        fruitList.add(Fruit("Pear", R.drawable.pear_pic))
        fruitList.add(Fruit("Grape", R.drawable.grape_pic))
        fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
        fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
        fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
        fruitList.add(Fruit("Mango", R.drawable.mango_pic))
    }
}

public fun initFruitsWithRandomLengthString() {
    repeat(10) {
        fruitList.add(
            Fruit(
                getRandomLengthString("Apple"),
                R.drawable.apple_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Banana"),
                R.drawable.banana_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Orange"),
                R.drawable.orange_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Watermelon"),
                R.drawable.watermelon_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Pear"),
                R.drawable.pear_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Grape"),
                R.drawable.grape_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Pineapple"),
                R.drawable.pineapple_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Strawberry"),
                R.drawable.strawberry_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Cherry"),
                R.drawable.cherry_pic
            )
        )
        fruitList.add(
            Fruit(
                getRandomLengthString("Mango"),
                R.drawable.mango_pic
            )
        )
    }
}

private fun getRandomLengthString(str: String): String {
    val n = (1..20).random()
    val builder = StringBuilder()
    repeat(n) {
        builder.append(str)
    }
    return builder.toString()
}