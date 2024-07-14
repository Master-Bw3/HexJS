@file:JvmName("HexJsAbstractions")

package io.github.master_bw3.hexjs

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.master_bw3.hexjs.registry.HexJsRegistrar

fun initRegistries(vararg registries: HexJsRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexJsRegistrar<T>) {
    throw AssertionError()
}