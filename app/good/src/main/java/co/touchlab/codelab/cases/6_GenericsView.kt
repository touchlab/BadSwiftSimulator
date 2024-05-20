package co.touchlab.codelab.cases

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.sdk.*

@Preview
@Composable
fun GenericsView(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val showcase: GenericsShowcase<Int> = remember {
            GenericsShowcase(value = 1)
        }

        val value: Int = showcase.value
        val thisKeepsGenerics: Int = showcase.thisKeepsGenerics()
        val thisLosesGenerics: Int = showcase.thisLosesGenerics()
        val thisMapAlsoLosesGenerics: String = showcase.thisMapAlsoLosesGenerics { it.toString() }

        val text = """
            - $value
            - $thisKeepsGenerics
            - $thisLosesGenerics
            - $thisMapAlsoLosesGenerics
        """.trimIndent()

        Text(text = text)
    }
}
