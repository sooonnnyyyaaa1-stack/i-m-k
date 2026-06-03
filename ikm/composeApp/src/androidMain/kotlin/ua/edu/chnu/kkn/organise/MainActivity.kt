package ua.edu.chnu.kkn.organise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ua.edu.chnu.kkn.organise.ui.root.AppScaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            AppScaffold()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AppScaffold()
}