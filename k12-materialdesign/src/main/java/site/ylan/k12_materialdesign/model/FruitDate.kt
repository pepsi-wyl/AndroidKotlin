package site.ylan.k12_materialdesign.model

import site.ylan.k12_materialdesign.R

class FruitDate {

    companion object {
        private val fruitList = ArrayList<Fruit>()
        private val fruits = mutableListOf(
            Fruit("Apple", R.drawable.apple),
            Fruit("Banana", R.drawable.banana),
            Fruit("Orange", R.drawable.orange),
            Fruit("Watermelon", R.drawable.watermelon),
            Fruit("Pear", R.drawable.pear),
            Fruit("Grape", R.drawable.grape),
            Fruit("Pineapple", R.drawable.pineapple),
            Fruit("Strawberry", R.drawable.strawberry),
            Fruit("Cherry", R.drawable.cherry),
            Fruit("Mango", R.drawable.mango)
        )

        private fun initFruitList() {
            fruitList.clear()
            repeat(150) {
                val index = (0 until fruits.size).random()
                fruitList.add(fruits[index])
            }
        }

        fun getFruitList(): ArrayList<Fruit> {
            initFruitList()
            return fruitList
        }
    }
}