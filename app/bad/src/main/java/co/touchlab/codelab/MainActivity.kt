package co.touchlab.codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.touchlab.codelab.cases.DefaultArgsView
import co.touchlab.codelab.cases.EnumsView
import co.touchlab.codelab.cases.FlowsView
import co.touchlab.codelab.cases.GenericsView
import co.touchlab.codelab.cases.SealedClassesView
import co.touchlab.codelab.cases.SuspendsView
import co.touchlab.codelab.ui.theme.CodelabSKIETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelabSKIETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        CaseCard("Enums") {
            EnumsView(Modifier.fillMaxSize())
        }
        CaseCard("Sealed Hierarchy") {
            SealedClassesView(Modifier.fillMaxSize())
        }
        CaseCard("Flows") {
            FlowsView(Modifier.fillMaxSize())
        }
        CaseCard( "Suspends") {
            SuspendsView(Modifier.fillMaxSize())
        }
        CaseCard("Default Arguments") {
            DefaultArgsView(Modifier.fillMaxSize())
        }
        CaseCard("Generics") {
            GenericsView(Modifier.fillMaxSize())
        }
    }
}

@Composable
fun CaseCard(text: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = text, style = MaterialTheme.typography.titleLarge
            )
            content()
        }
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_7, showSystemUi = true)
@Composable
fun MainPreview() {
    CodelabSKIETheme {
        MainContent()
    }
}
