package io.github.master_bw3.hexjs

import io.github.master_bw3.hexjs.registry.HexJsActions
import net.minecraft.util.Identifier

object HexJs {
    const val MODID = "hexjs"

    @JvmStatic
    fun id(path: String) = Identifier(MODID, path)

    fun init() {
        initRegistries(
            HexJsActions
        )
    }
}