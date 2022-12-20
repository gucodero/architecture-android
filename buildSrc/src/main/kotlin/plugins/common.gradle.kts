package plugins

import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import utils.extension
import utils.configure

plugins.apply {
    apply("kotlin-android")
    apply("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
extension<BaseExtension>("android") {

    configure<KotlinJvmOptions>("kotlinOptions") {
        jvmTarget = Config.javaVersion.toString()
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }

    //create env

    buildTypes {
        getByName("release"){
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
        }
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }

}

configure<KaptExtension>("kapt") {
    correctErrorTypes = true
}