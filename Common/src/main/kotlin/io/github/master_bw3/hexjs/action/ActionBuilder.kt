package io.github.master_bw3.hexjs.action

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern

import dev.latvian.mods.kubejs.registry.BuilderBase
import dev.latvian.mods.kubejs.registry.RegistryInfo
import io.github.master_bw3.hexjs.HexJsPlugin
import net.minecraft.util.Identifier

class ActionBuilder(identifier: Identifier) : BuilderBase<ActionRegistryEntry>(identifier) {

    @Transient
    private var pattern : HexPattern? = null;

    @Transient
    private var action : Action? = null;

    fun pattern(pattern: String): ActionBuilder {
        this.pattern = HexPattern.fromAngles(pattern, HexDir.EAST);
        return this;
    }

    fun action(action: Action): ActionBuilder {
        this.action = action;
        return this;
    }

    override fun getRegistryType(): RegistryInfo<*> = HexJsPlugin.ACTION

    override fun createObject(): ActionRegistryEntry = ActionRegistryEntry(pattern, action)

}