package ua.edu.chnu.kkn.organise.data.common.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ua.edu.chnu.kkn.organise.Organise

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(Organise.Schema, context, "organise.db")
    }
}