@file:JvmName("HexJsAbstractionsImpl")

package io.github.master_bw3.hexjs.forge

import io.github.master_bw3.hexjs.registry.HexJsRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexJsRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
