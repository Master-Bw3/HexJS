package io.github.master_bw3.hexjs

import io.github.master_bw3.hexjs.registry.HexJsActions
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object HexJs {
    const val MODID = "hexjs"

    val LOGGER = LoggerFactory.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = Identifier(MODID, path)

    fun init() {
        initRegistries(
            HexJsActions
        )
    }
}