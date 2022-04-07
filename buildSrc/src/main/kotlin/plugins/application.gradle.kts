package plugins

import gradle.kotlin.dsl.accessors._ebd9a44e97e230845a4c1d2edcc3667f.api
import utils.addFeatureDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = Config.maxSdk
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.maxSdk
    }
    dataBinding.isEnabled = true
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
}