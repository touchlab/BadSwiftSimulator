package co.touchlab.codelab.cases

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.touchlab.codelab.util.withOnCompletion
import co.touchlab.sdk.*
import kotlinx.coroutines.*

@Preview
@Composable
fun SuspendsView(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val fortuneTeller = remember { FortuneTeller() }
        var getFortuneJob by remember { mutableStateOf<Job?>(null) }
        var fortuneState by remember { mutableStateOf("...") }
        val coroutineScope = rememberCoroutineScope()

        getFortuneJob?.let {
            Button(onClick = {
                getFortuneJob?.cancel()
            }) {
                Text("Cancel")
            }
        } ?: run {
            Button(onClick = {
                getFortuneJob = coroutineScope.launch {
                    val fortune = fortuneTeller.getFortune()
                    fortuneState = if (isActive) {
                        fortune
                    } else {
                        "Fortune still delivered after canceled: $fortune"
                    }
                }.withOnCompletion {
                    getFortuneJob = null
                }
            }) {
                Text(text = "Get Fortune")
            }
        }

        if (getFortuneJob != null) {
            CircularProgressIndicator()
        } else {
            Text(modifier = Modifier.padding(8.dp), text = fortuneState)
        }
    }
}
