package ua.edu.chnu.kkn.organise.ui.about

internal data class AboutState(
    val platformInfo: List<Pair<String, String>> = emptyList(),
    val visitedCount: Int = 0
)