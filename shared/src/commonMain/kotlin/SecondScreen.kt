import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun SecondScsreen(name:String,navigator: Navigator) {
    var greetingText by remember { mutableStateOf("Second Screen") }
    var showImage by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    Column {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { navigator.goBack() }) {
                Text(text = "GO BACK!")
            }
        }
        Button(
            onClick = {
                showImage = showImage.not()
                if (showImage){
                    greetingText = "Image Showing"
                }else{
                    greetingText = "Second Screen"
                }
            }, content = {
                Text(greetingText)
            }
        )
    }
}