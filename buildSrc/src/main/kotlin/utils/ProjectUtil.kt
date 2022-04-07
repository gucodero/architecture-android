package utils

import org.gradle.api.Action
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.get

inline fun <reified T> ExtensionAware.extension(name: String, scope: T.() -> Unit) {
    val result = this.extensions[name]
    if(result is T) result.scope()
}

inline fun <reified T> Any.configure(name: String, action: Action<in T>) {
    if(this is ExtensionAware){
        extensions.configure(name, action)
    }
}

fun MutableSet<String>.add(vararg featureName: String){
    featureName.forEach {
        this.add(it)
    }
}