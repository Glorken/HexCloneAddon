package gay.cass.hexclone.fabric

import gay.cass.hexclone.HexClone
import net.fabricmc.api.ModInitializer

object FabricHexClone : ModInitializer {
    override fun onInitialize() {
        HexClone.init()
    }
}
