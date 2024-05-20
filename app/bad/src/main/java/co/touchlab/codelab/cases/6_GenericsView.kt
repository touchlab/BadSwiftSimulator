package co.touchlab.codelab.cases

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.sdk.*

@Preview
@Composable
fun GenericsView(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // We can provide `null` for `value`
        val showcase: GenericsShowcase<Int> = GenericsShowcase(value = 1)

        // Note that we have no control over nullability from this side
        val value: Int = showcase.value ?: -1
        val thisKeepsGenerics: Int = showcase.thisKeepsGenerics() ?: -2

        // UNSAFE: `thisLosesGenerics` returns `Any?`
        val thisLosesGenerics: Int = showcase.thisLosesGenerics() as Int

        // UNSAFE: `thisMapAlsoLosesGenerics` also returns `Any?`
        val thisMapAlsoLosesGenerics: String = showcase.thisMapAlsoLosesGenerics { it.toString() } as String

        val text = """
            - $value
            - $thisKeepsGenerics
            - $thisLosesGenerics
            - $thisMapAlsoLosesGenerics
        """.trimIndent()

        Text(text = text)
    }
}
