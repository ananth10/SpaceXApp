package com.ananth.spacexapp

import com.ananth.spacexapp.cache.IOSDatabaseDriverFactory
import com.ananth.spacexapp.entity.RocketLaunch
import com.ananth.spacexapp.network.SpaceXApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import org.koin.core.context.startKoin


class KoinHelper : KoinComponent {
    private val sdk: SpaceXSDK by inject<SpaceXSDK>()

    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        return sdk.getLaunches(forceReload = forceReload)
    }
}

fun initKoin() {
    startKoin {
        modules(module {
            single<SpaceXApi> { SpaceXApi() }
            single<SpaceXSDK> {
                SpaceXSDK(
                    databaseDriverFactory = IOSDatabaseDriverFactory(), api = get()
                )
            }
        })
    }
}