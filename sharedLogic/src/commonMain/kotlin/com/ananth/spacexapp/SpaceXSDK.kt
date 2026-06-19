package com.ananth.spacexapp

import com.ananth.spacexapp.cache.Database
import com.ananth.spacexapp.cache.DatabaseDriverFactory
import com.ananth.spacexapp.entity.RocketLaunch
import com.ananth.spacexapp.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory, val api: SpaceXApi) {
    private val database = Database(databaseDriverFactory)


    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearAndCreateLaunches(it)
            }
        }
    }
}