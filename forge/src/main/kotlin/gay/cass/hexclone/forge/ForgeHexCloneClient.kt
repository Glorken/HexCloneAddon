package gay.cass.hexclone.forge

import gay.cass.hexclone.HexCloneClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHexCloneClient {
    fun init(event: FMLClientSetupEvent) {
        HexCloneClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HexCloneClient.getConfigScreen(parent) }
        }
    }
}
