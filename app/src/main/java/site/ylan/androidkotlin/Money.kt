package site.ylan.androidkotlin

class Money(val value: Double){
    operator fun plus(money: Money): Money {
        return Money(this.value + money.value)
    }

    operator fun plus(newValue: Double): Money {
        return Money(this.value + newValue)
    }

    override fun toString(): String {
        return "Money(value=$value)"
    }

}

fun main() {
    val money1 = Money(5.0)
    val money2 = Money(10.0)
    val money3 = money1 + money2
    println(money3.value)
    val money4 = money3 + 10.5
    println(money4)
    val money5 = 10.5 + money4
    println(money5)
}

private operator fun Double.plus(money: Money): Money {
    return Money(this + money.value)
}