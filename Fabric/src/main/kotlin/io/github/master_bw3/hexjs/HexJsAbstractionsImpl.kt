@file:JvmName("HexJsAbstractionsImpl")

package io.github.master_bw3.hexjs.fabric

import io.github.master_bw3.hexjs.registry.HexDebugRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexDebugRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
