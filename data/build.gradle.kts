import utils.*

plugins {
    id("plugins.library")
}

addKotlinCoroutinesDependencies()
addTestDependencies()
addKoinDependencies()
addRetrofitDependencies()
addTimberDependencies()

dependencies {
    api(project(":domain"))
}