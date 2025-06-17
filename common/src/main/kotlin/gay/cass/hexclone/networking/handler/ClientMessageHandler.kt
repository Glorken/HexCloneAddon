package gay.cass.hexclone.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import gay.cass.hexclone.config.HexCloneConfig
import gay.cass.hexclone.networking.msg.*

fun HexCloneMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexCloneConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
