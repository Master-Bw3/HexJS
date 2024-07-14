package io.github.master_bw3.hexjs.fabric

import io.github.master_bw3.hexjs.HexJsClient
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType.CLIENT
import net.fabricmc.api.Environment

@Environment(CLIENT)
object FabricHexJsClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexJsClient.init()
    }
}
