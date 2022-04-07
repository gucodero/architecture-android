import utils.*

plugins {
    id("plugins.library")
}

addKotlinCoroutinesDependencies()
addTestDependencies()
addKoinDependencies()
addTimberDependencies()