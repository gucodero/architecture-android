plugins {
    id("plugins.feature")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(project(path = ":app"))
}