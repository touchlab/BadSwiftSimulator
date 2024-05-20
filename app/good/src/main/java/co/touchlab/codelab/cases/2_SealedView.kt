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
fun SealedClassesView(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val reactor = remember { Reactor() }
        val text = when (reactor.condition) {
            Reactor.Condition.Shutdown -> "Ready to start reactor"
            is Reactor.Condition.SubCritical -> "Reactor is warming up"
            is Reactor.Condition.Critical -> "Reactor is running"
        }
        Text(text = text)

        Text(reactor.condition.humanReadableDescription())
    }
}
