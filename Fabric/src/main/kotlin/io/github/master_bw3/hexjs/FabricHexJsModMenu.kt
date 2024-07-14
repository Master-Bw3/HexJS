package io.github.master_bw3.hexjs.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.master_bw3.hexjs.config.HexJsConfig
import net.fabricmc.api.EnvType.CLIENT
import net.fabricmc.api.Environment

@Environment(CLIENT)
object FabricHexJsModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexJsConfig::getConfigScreen)
}
