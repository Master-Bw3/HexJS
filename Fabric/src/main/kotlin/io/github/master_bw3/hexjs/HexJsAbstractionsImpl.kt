@file:JvmName("HexJsAbstractionsImpl")

package io.github.master_bw3.hexjs.fabric

import net.minecraft.registry.Registry
import io.github.master_bw3.hexjs.registry.HexJsRegistrar

fun <T : Any> initRegistry(registrar: HexJsRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
