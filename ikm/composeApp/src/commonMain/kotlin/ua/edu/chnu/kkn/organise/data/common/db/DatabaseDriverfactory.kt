package ua.edu.chnu.kkn.organise.data.common.db

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun create(): SqlDriver
}