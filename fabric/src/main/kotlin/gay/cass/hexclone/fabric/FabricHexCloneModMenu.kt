package gay.cass.hexclone.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import gay.cass.hexclone.HexCloneClient

object FabricHexCloneModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexCloneClient::getConfigScreen)
}
