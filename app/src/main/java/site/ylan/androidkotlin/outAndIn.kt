package site.ylan.androidkotlin

class outAndIn

open class Animal {
    fun feed() {
        println("Feeding an animal")
    }
}

class Dog : Animal() {
    fun bark() {
        println("Dog is barking")
    }
}

interface Producer<out T> {
    fun produce(): T
}

interface Consumer<in T> {
    fun consume(item: T)
}

class DogProducer : Producer<Dog> {
    override fun produce(): Dog {
        return Dog()
    }
}

class AnimalConsumer : Consumer<Animal> {
    override fun consume(item: Animal) {
        item.feed()
    }
}

fun feedAnimals(animalProducer: Producer<Animal>) {
    val animal = animalProducer.produce()
    animal.feed()
}

fun feedDogs(dogConsumer: Consumer<Dog>) {
    val dog = Dog()
    dogConsumer.consume(dog)
}

fun main() {
    val dogProducer: Producer<Dog> = DogProducer()
    feedAnimals(dogProducer)  // 这是安全的，因为 Producer 是协变的

    val animalConsumer: Consumer<Animal> = AnimalConsumer()
    feedDogs(animalConsumer)  // 这是安全的，因为 Consumer 是逆变的
}