@file:OptIn(ExperimentalObjCRefinement::class)

package co.touchlab.sdk

import co.touchlab.skie.configuration.annotations.DefaultArgumentInterop
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.ShouldRefineInSwift

class FavoriteNumberGenerator @DefaultArgumentInterop.Enabled constructor(val offset: Int = 0) {

    @DefaultArgumentInterop.Enabled
    fun getFavoriteNumbers(multiplier: Int = 1): List<Int> {
        return listOf(1, 2, 3, 5, 8, 13).map { offset + it * multiplier }
    }
}
