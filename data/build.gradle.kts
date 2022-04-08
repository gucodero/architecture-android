import utils.*

plugins {
    id("plugins.library")
}

addKotlinCoroutinesDependencies()
addTestDependencies()
addKoinDependencies()
addRetrofitDependencies()
addTimberDependencies()
addDataStorage()

dependencies {
    api(project(":domain"))
}