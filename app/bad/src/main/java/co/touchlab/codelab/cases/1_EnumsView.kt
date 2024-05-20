package co.touchlab.codelab.cases

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.sdk.*

@Preview
@Composable
fun EnumsView(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val text = when (EnumsKt.getFavoriteFruit()) {
            Fruit.Apple -> "I love Apples"
            Fruit.Orange -> "I love Oranges"
            else -> "Unknown fruit type"
        }
        Text(text = text)
    }
}
