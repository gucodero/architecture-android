buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.gradle)
        classpath(Plugins.kotlin)
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}