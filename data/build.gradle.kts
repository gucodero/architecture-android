import utils.*

plugins {
    id("plugins.library")
}

addKotlinCoroutinesDependencies()
addTestDependencies()
addKoinDependencies()
addRetrofitDependencies()
addTimberDependencies()
addDataStorageDependencies()
addRoomDependencies()

dependencies {
    api(project(":domain"))
}