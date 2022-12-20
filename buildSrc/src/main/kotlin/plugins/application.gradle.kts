package plugins

import utils.addFeatureDependencies

plugins {
    id("com.android.application")
    id("plugins.common")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = Config.maxSdk
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.maxSdk
        multiDexEnabled = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

addFeatureDependencies()

dependencies {
    implementation(project(":ui"))
    api(project(path = ":data"))
    implementation("androidx.multidex:multidex:2.0.1")
}