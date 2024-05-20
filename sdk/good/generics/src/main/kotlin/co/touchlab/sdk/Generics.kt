package co.touchlab.sdk

class GenericsShowcase<T>(
    val value: T,
) {

    fun thisKeepsGenerics(): T {
        return value
    }

    fun <U> thisMapAlsoLosesGenerics(map: (T) -> U): U {
        return map(value)
    }
}

fun <T> GenericsShowcase<T>.thisLosesGenerics(): T {
    return value
}
