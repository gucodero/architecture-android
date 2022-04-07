package plugins

plugins {
    id("com.android.library")
    id("plugins.common")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = Config.maxSdk
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.maxSdk
    }
    buildFeatures {
        buildConfig = true
    }
}