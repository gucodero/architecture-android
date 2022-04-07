package plugins

import utils.addFeatureDependencies
import org.gradle.kotlin.dsl.project

plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    id("plugins.common")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = Config.maxSdk
    defaultConfig {
        minSdk = Config.minSdk
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
    implementation(project(path = ":ui"))
    api(project(path = ":data"))
}