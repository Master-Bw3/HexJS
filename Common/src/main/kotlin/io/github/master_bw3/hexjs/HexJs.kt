package io.github.master_bw3.hexjs

import net.minecraft.util.Identifier

public object HexJs {
    const val MODID = "hexjs"

    @JvmStatic
    fun id(path: String) = Identifier(MODID, path)

    fun init() {

    }
}