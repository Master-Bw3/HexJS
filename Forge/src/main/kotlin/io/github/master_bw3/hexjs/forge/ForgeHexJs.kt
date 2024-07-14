package io.github.master_bw3.hexjs.forge

import dev.architectury.platform.forge.EventBuses
import io.github.master_bw3.hexjs.HexJs
import io.github.master_bw3.hexjs.forge.datagen.HexJsModels
import io.github.master_bw3.hexjs.forge.datagen.HexJsRecipes
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(HexJs.MODID)
class HexJsForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HexJs.MODID, this)
            addListener(ForgeHexJsClient::init)
            addListener(::gatherData)
        }
        HexJs.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            val efh = existingFileHelper
            addProvider(includeClient()) { HexJsModels(it, efh) }
            addProvider(includeServer()) { HexJsRecipes(it) }
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
