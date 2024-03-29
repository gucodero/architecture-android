plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

object Versions {
    const val gradlePlugin = "7.3.0"
    const val kotlin = "1.7.10"
}

object Plugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(Plugins.gradle)
    implementation(Plugins.kotlin)
}