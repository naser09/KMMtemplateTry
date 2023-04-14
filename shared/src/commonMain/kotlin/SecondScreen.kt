import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SecondScsreen() {
    var greetingText by remember { mutableStateOf("Second Screen") }
    var showImage by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    Column {
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