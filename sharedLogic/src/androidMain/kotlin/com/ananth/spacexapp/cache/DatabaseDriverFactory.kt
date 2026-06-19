package com.ananth.spacexapp.cache

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.jetbrains.spacetutorial.cache.AppDatabase

class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, "launch.db")
    }
}