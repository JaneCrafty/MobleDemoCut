package com.example.broker.common.featureflags

import com.example.broker.BuildConfig
import com.example.broker.models.remoteconfig.RemoteConfigLoader
import com.example.broker.utils.application.ManifestUtils

object SystemSettings {
    @JvmField
    val SOCKETS_CONNECTION = FeatureFlag("Connect to sockets", false)
    @JvmField
    val CACHING_NETWORK_TRAFFIC = FeatureFlag("Caching network traffic", true)
    @JvmField
    val APPSFLYER_LOG = FeatureFlag("AppsFlyer log", false)
    @JvmField
    val HTTP_LOG = FeatureFlag("HTTP log", false)
    @JvmField
    val SOCKETS_LOG = FeatureFlag("Sockets log", false)
    @JvmField
    val MOBILE_STATIC_REMOTE_CONFIG_LOADER = FeatureFlag("Load remote config from mobile static", false)
    @JvmField
    val VERIFICATION_STUB = FeatureFlag("Verification stub", false)
    @JvmField
    val CHAMPIONSHIP_STUB = FeatureFlag("Championship stub", false)
    @JvmField
    @Suppress("MaxLineLength")
    val FIREBASE_CASH_FEATURE = FeatureFlag(
            "Sets the ${RemoteConfigLoader.RELEASE_MIN_FETCHED_TIME} seconds interval between last fetch from the Firebase",
            !BuildConfig.DEBUG,
    )
    @JvmField
    val CASHIER_CONTENT_DEBUGGING = FeatureFlag("Cashier content debugging", ManifestUtils.isBeta)
    @JvmField
    val STORAGES_CACHE_DISABLED = FeatureFlag("Do not cache data in Storages", false)
}
