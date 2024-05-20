package co.touchlab.sdk

class GenericsShowcase<T: Any>(
    val value: T?,
) {

    fun thisKeepsGenerics(): T? {
        return value
    }

    fun thisMapAlsoLosesGenerics(map: (T?) -> Any?): Any? {
        return map(value)
    }
}

fun GenericsShowcase<*>.thisLosesGenerics(): Any? {
    return value
}
