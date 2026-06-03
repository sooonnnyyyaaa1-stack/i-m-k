package ua.edu.chnu.kkn.organise.data.common.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import ua.edu.chnu.kkn.organise.Organise

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(Organise.Schema, "organise.db")
    }
}