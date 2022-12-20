plugins {
    id("plugins.application")
    id("androidx.navigation.safeargs.kotlin")
}
android {
    defaultConfig {
        applicationId = Config.applicationId
        versionCode = Config.versionCode
        versionName = Config.versionName
        multiDexEnabled = true
    }
    dynamicFeatures.add(
        ":features:test_feature"
    )
    dynamicFeatures += setOf(":features:auth")
}

dependencies {
    implementation("androidx.multidex:multidex:2.0.1")
}