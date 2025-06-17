package gay.cass.hexclone.forge

import dev.architectury.platform.forge.EventBuses
import gay.cass.hexclone.HexClone
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(HexClone.MODID)
class HexCloneForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HexClone.MODID, this)
            addListener(ForgeHexCloneClient::init)
            addListener(::gatherData)
        }
        HexClone.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
