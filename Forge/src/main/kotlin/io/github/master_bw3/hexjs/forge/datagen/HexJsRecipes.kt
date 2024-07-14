package io.github.master_bw3.hexjs.forge.datagen

import at.petrak.hexcasting.api.mod.HexTags
import at.petrak.paucal.api.datagen.PaucalRecipeProvider
import io.github.master_bw3.hexjs.HexJs
import io.github.master_bw3.hexjs.registry.HexJsItems
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.world.item.Items
import java.util.function.Consumer

// we use Paucal's recipe provider as a base because it has a bunch of helpful stuff
class HexJsRecipes(output: PackOutput) : PaucalRecipeProvider(output, HexJs.MODID) {
    override fun buildRecipes(writer: Consumer<FinishedRecipe>) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HexJsItems.DUMMY_ITEM.value)
            .define('S', Items.STICK)
            .define('A', Blocks.AMETHYST_BLOCK)
            .pattern("  A")
            .pattern(" S ")
            .pattern("S  ")
            .unlockedBy("has_item", hasItem(HexTags.Items.STAVES))
            .save(writer)
    }
}
