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
fun DefaultArgsView(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val text = FavoriteNumberGenerator(offset = 1).getFavoriteNumbers(multiplier = 3).joinToString()
        Text(text = text)
    }
}
