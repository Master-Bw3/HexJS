package io.github.master_bw3.hexjs.registry

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import at.petrak.hexcasting.common.lib.hex.HexActions
import io.github.master_bw3.hexjs.casting.actions.OpHello

object HexJsActions : HexJsRegistrar<ActionRegistryEntry>(HexRegistries.ACTION, { HexActions.REGISTRY }) {
    val IS_DEBUGGING = make("const/debugging", HexDir.EAST, "qqqqqewaa", OpHello)

    private fun make(name: String, startDir: HexDir, signature: String, action: Action) =
        make(name, startDir, signature) { action }

    private fun make(name: String, startDir: HexDir, signature: String, getAction: () -> Action) = register(name) {
        ActionRegistryEntry(HexPattern.fromAngles(signature, startDir), getAction())
    }
}