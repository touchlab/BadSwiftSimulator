@file:OptIn(ExperimentalObjCName::class)

package co.touchlab.sdk

import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.ObjCName
import kotlin.native.ShouldRefineInSwift

@ObjCName("__GenericsShowcase")
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
