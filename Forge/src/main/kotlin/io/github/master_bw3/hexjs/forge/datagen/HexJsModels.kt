@file:OptIn(ExperimentalStdlibApi::class)

package io.github.master_bw3.hexjs.forge.datagen

import io.github.master_bw3.hexjs.HexJs
import io.github.master_bw3.hexjs.items.ItemDebugger
import io.github.master_bw3.hexjs.items.ItemDebugger.DebugState
import io.github.master_bw3.hexjs.items.ItemDebugger.StepMode
import io.github.master_bw3.hexjs.items.ItemEvaluator
import io.github.master_bw3.hexjs.items.ItemEvaluator.EvalState
import io.github.master_bw3.hexjs.registry.HexJsItems
import io.github.master_bw3.hexjs.utils.itemPredicate
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelBuilder
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.common.data.ExistingFileHelper

class HexJsModels(output: PackOutput, efh: ExistingFileHelper) : ItemModelProvider(output, HexJs.MODID, efh) {
    override fun registerModels() {
        basicItem(HexJsItems.DUMMY_ITEM.id)
            .parent(ModelFile.UncheckedModelFile("item/handheld_rod"))
    }
}

// utility function for adding multiple possibly missing layers to a generated item model
fun <T : ModelBuilder<T>> T.layers(start: Int, vararg layers: String?): T {
    var index = start
    for (layer in layers) {
        if (layer != null) {
            texture("layer$index", layer)
            index += 1
        }
    }
    return this
}
