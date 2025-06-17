package gay.cass.hexclone

import gay.cass.hexclone.config.HexCloneConfig
import gay.cass.hexclone.config.HexCloneConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexCloneClient {
    fun init() {
        HexCloneConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
