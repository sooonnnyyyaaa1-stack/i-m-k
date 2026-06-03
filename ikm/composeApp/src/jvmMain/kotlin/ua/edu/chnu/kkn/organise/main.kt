package ua.edu.chnu.kkn.organise

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ua.edu.chnu.kkn.organise.di.initKoin
import ua.edu.chnu.kkn.organise.ui.root.AppScaffold

fun main() = application {
    initKoin { printLogger() }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Organise",
    ) {
        AppScaffold()
    }
}
