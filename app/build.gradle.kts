plugins {
    id("plugins.application")
    id("androidx.navigation.safeargs.kotlin")
}
android {
    defaultConfig {
        applicationId = Config.applicationId
        versionCode = Config.versionCode
        versionName = Config.versionName
    }
    dynamicFeatures.add(
        ":features:test_feature"
    )
    dynamicFeatures += setOf(":features:auth")
}
