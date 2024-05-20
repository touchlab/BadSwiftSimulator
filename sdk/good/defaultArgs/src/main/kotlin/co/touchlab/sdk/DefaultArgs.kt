package co.touchlab.sdk

class FavoriteNumberGenerator(val offset: Int = 0) {
    fun getFavoriteNumbers(multiplier: Int = 1): List<Int> {
        return listOf(1, 2, 3, 5, 8, 13).map { offset + it * multiplier }
    }
}
