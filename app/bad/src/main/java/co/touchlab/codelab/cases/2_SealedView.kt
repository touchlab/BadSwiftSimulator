package co.touchlab.codelab.cases

import androidx.compose.foundation.layout.Box
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
        val text = when (val condition = reactor.condition) {
            ReactorConditionShutdown -> "Ready to start reactor"
            is ReactorConditionSubCritical -> "Reactor is warming up - ${condition.temperature} C"
            is ReactorConditionCritical -> "Reactor is running - ${condition.outputPower} W"
            else -> "Unknown reactor condition"
        }
        Text(text = text)

        Text(SealedKt.humanReadableDescription(reactor.condition))
    }
}
