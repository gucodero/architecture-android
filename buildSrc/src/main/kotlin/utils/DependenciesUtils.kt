package utils

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

private fun Project.addDependencies(configurationName: String, vararg dependencyName: String){
    dependencies {
        dependencyName.forEach {
            add(
                configurationName = configurationName,
                dependencyNotation = it
            )
        }
    }
}


private fun Project.implementation(vararg dependencyName: String){
    addDependencies(
        configurationName = "implementation",
        dependencyName = dependencyName
    )
}

private fun Project.testImplementation(vararg dependencyName: String){
    addDependencies(
        configurationName = "testImplementation",
        dependencyName = dependencyName
    )
}

private fun Project.androidTestImplementation(vararg dependencyName: String){
    addDependencies(
        configurationName = "androidTestImplementation",
        dependencyName = dependencyName
    )
}

private fun Project.debugImplementation(vararg dependencyName: String){
    addDependencies(
        configurationName = "debugImplementation",
        dependencyName = dependencyName
    )
}

fun Project.addFeatureDependencies(){
    addAndroidDependencies()
    addComposeDependencies()
    addTestDependencies()
    addAndroidTestDependencies()
    addKotlinCoroutinesDependencies()
    addKoinDependencies()
    addRetrofitDependencies()
    addTimberDependencies()
    addNavigationFragmentDependencies()
    addLottieDependencies()
}

fun Project.addAndroidDependencies() {
    implementation(
        Dependencies.androidCore,
        Dependencies.activityCompose,
        Dependencies.lifecycleRuntime
    )
}

fun Project.addComposeDependencies() {
    implementation(
        Dependencies.compose,
        Dependencies.composeMaterial,
        Dependencies.composePreview
    )
}

fun Project.addTestDependencies(){
    testImplementation(
        Dependencies.jUnit
    )
}

fun Project.addAndroidTestDependencies(){
    testImplementation(Dependencies.androidJUnit)
    androidTestImplementation(
        Dependencies.espresso,
        Dependencies.composeUiTest
    )
    debugImplementation(
        Dependencies.composeUiTooling
    )
}

fun Project.addKotlinCoroutinesDependencies(){
    implementation(
        Dependencies.kotlinCoroutinesCore,
        Dependencies.kotlinCoroutinesAndroid
    )
}


fun Project.addKoinDependencies(){
    implementation(
        Dependencies.koinCore,
        Dependencies.koinAndroid
    )
}

fun Project.addRetrofitDependencies(){
    implementation(
        Dependencies.retrofit,
        Dependencies.retrofitLog,
        Dependencies.converterGson,
        Dependencies.okhttp,
        Dependencies.okhttpLogging
    )
}

fun Project.addTimberDependencies(){
    implementation(
        Dependencies.timber
    )
}

fun Project.addNavigationFragmentDependencies(){
    implementation(
        Dependencies.navigationFragment,
        Dependencies.navigationUI,
        Dependencies.navigationDynamicFeature
    )
}

fun Project.addLottieDependencies(){
    implementation(
        Dependencies.lottie,
        Dependencies.lottieCompose
    )
}