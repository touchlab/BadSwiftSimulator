package co.touchlab.codelab.cases

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.touchlab.sdk.*

@Preview
@Composable
fun FlowsView(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        var showTrafficLight by remember { mutableStateOf(false) }
        val lightUpdateCounter = remember { mutableIntStateOf(0) }

        Button(onClick = { showTrafficLight = !showTrafficLight }) {
            Text(text = "Toggle Traffic Light")
        }

        if (showTrafficLight) {
            TrafficLightView(lightUpdateCounter)
        } else {
            Text(modifier = Modifier.padding(8.dp), text = "Traffic Light Off")
        }

        Text("Updated ${lightUpdateCounter.intValue} times")
    }
}

@Composable
private fun TrafficLightView(lightUpdateCounter: MutableIntState) {
    val intersection = remember { Intersection() }
    var currentState by remember { mutableStateOf("Red") }
    Text(modifier = Modifier.padding(8.dp), text = currentState)

    LaunchedEffect(Unit) {
        val collector = SwiftFlowCollector { newLightState ->
            // UNSAFE: This will crash if the Flow's element type differs from T.
            currentState = newLightState as String
            lightUpdateCounter.intValue += 1
        }
        // UNSAFE: Although you can see the "suspend" icon in IDEA's gutter, the collect won't get cancelled when the LaunchedEffect's scope is.
        intersection.getTrafficLight().collect(collector = collector)
    }
}

class SwiftFlowCollector(
    private val accept: (Any?) -> Unit,
): Kotlinx_coroutines_coreFlowCollector {

    override fun emit(value: Any?, completionHandler: (Throwable?) -> Unit) {
        accept(value)

        completionHandler(null)
    }
}
