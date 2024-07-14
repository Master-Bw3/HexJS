package io.github.master_bw3.hexjs


import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.common.lib.HexRegistries
import dev.latvian.mods.kubejs.KubeJSPlugin
import dev.latvian.mods.kubejs.registry.RegistryInfo
import io.github.master_bw3.hexjs.action.ActionBuilder

class HexJsPlugin : KubeJSPlugin() {


    override fun init() {
        ACTION.addType("action", ActionBuilder::class.java, ::ActionBuilder)
    }

    companion object {
        val ACTION: RegistryInfo<ActionRegistryEntry> = RegistryInfo.of(
            HexRegistries.ACTION,
            ActionRegistryEntry::class.java
        )
    }
}