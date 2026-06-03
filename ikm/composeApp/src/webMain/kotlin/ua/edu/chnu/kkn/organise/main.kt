package ua.edu.chnu.kkn.organise

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ua.edu.chnu.kkn.organise.ui.root.AppScaffold
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        AppScaffold()
    }
}