buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.gradle)
        classpath(Plugins.kotlin)
        classpath(Plugins.safeArgs)
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}