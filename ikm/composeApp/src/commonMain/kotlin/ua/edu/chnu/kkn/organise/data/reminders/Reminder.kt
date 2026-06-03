package ua.edu.chnu.kkn.organise.data.reminders

internal data class Reminder (
    val id: String,
    val title: String,
    val isCompleted: Boolean = false,
)