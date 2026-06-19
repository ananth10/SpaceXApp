package com.ananth.spacexapp

import com.ananth.spacexapp.cache.AndroidDatabaseDriverFactory
import com.ananth.spacexapp.network.SpaceXApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val appModule = module {
    single<SpaceXApi> { SpaceXApi() }
    single<SpaceXSDK> {
        SpaceXSDK(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
                androidContext()
            ), api = get()
        )
    }
    viewModel { RocketLaunchViewModel(sdk = get()) }
}