package gay.cass.hexclone

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import gay.cass.hexclone.config.HexCloneConfig
import gay.cass.hexclone.networking.HexCloneNetworking
import gay.cass.hexclone.registry.HexCloneActions

object HexClone {
    const val MODID = "hexclone"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexCloneConfig.init()
        initRegistries(
            HexCloneActions,
        )
        HexCloneNetworking.init()
    }
}
