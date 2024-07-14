package io.github.master_bw3.hexjs.fabric

import io.github.master_bw3.hexjs.HexJs
import net.fabricmc.api.ModInitializer

object FabricHexJs : ModInitializer {
    override fun onInitialize() {
        HexJs.init()
    }
}
