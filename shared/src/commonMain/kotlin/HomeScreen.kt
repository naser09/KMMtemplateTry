import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.livedata.LiveData
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.ui.observeAsState
import moe.tlaster.precompose.ui.viewModel
import moe.tlaster.precompose.viewmodel.ViewModel

@Composable
fun HomeScreen(navigator: Navigator) {
    val viewModel = viewModel {
        HomeViewModel()
    }
    val name by viewModel.name.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Greet Me!",
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = name,
            maxLines = 1,
            label = { Text(text = "Enter your name") },
            onValueChange = {
                viewModel.setName(it)
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navigator.navigate(route = "/greeting/$name")
            }
        ) {
            Text(text = "GO!")
        }
    }
}
class HomeViewModel : ViewModel() {
    val name = LiveData("")
    fun setName(value: String) {
        name.value = value
    }
}