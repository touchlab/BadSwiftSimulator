package co.touchlab.sdk

object EnumsKt {
    fun getFavoriteFruit(): Fruit {
        return Fruit.Apple
    }
}

class Fruit(val ordinal: Int) {
    companion object {
        val Apple = Fruit(0)
        val Orange = Fruit(1)
        val Pear = Fruit(2)
    }
}
