package ua.edu.chnu.kkn.organise

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ua.edu.chnu.kkn.organise.ui.root.AppScaffold

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Organise",
    ) {
        AppScaffold()
    }
}
