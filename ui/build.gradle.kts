import utils.*

plugins {
    id("plugins.library")
}

android {
    dataBinding.isEnabled = true
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    buildFeatures {
        compose = true
    }
}

addAndroidDependencies()
addTestDependencies()
addAndroidTestDependencies()
addKotlinCoroutinesDependencies()
addKoinDependencies()
addTimberDependencies()
addComposeDependencies()
addNavigationFragmentDependencies()
addLottieDependencies()

dependencies {
    implementation(project(":domain"))
}