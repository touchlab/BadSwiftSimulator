package co.touchlab.sdk

class FavoriteNumberGenerator(val offset: Int) {
    // We're returning `List` of `Number` instead of `Int` to simulate `KotlinInt` on Swift's side.
    fun getFavoriteNumbers(multiplier: Int): List<Number> {
        return listOf(1, 2, 3, 5, 8, 13).map { offset + it * multiplier }
    }
}
