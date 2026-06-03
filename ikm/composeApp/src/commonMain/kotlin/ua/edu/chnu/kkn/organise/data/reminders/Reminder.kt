package ua.edu.chnu.kkn.organise.data.reminders

import ua.edu.chnu.kkn.organise.Task
internal data class Reminder (
    val id: Long,
    val title: String,
    val isCompleted: Boolean = false,
)

internal fun Task.map(): Reminder {
    return Reminder(
        id = id,
        title = task_desc,
        isCompleted = is_completed == 1L
    )
}