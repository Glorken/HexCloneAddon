package gay.cass.hexclone.fabric

import gay.cass.hexclone.HexCloneClient
import net.fabricmc.api.ClientModInitializer

object FabricHexCloneClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexCloneClient.init()
    }
}
