package io.github.master_bw3.hexjs.forge

import io.github.master_bw3.hexjs.HexJsClient
import io.github.master_bw3.hexjs.config.HexJsConfig
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHexJsClient {
    fun init(event: FMLClientSetupEvent) {
        HexJsClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HexJsConfig.getConfigScreen(parent) }
        }
    }
}
