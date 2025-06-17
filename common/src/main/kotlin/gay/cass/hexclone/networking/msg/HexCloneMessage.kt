package gay.cass.hexclone.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import gay.cass.hexclone.HexClone
import gay.cass.hexclone.networking.HexCloneNetworking
import gay.cass.hexclone.networking.handler.applyOnClient
import gay.cass.hexclone.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexCloneMessage

sealed interface HexCloneMessageC2S : HexCloneMessage {
    fun sendToServer() {
        HexCloneNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexCloneMessageS2C : HexCloneMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexCloneNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexCloneNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexCloneMessageCompanion<T : HexCloneMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                HexClone.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexCloneMessageC2S -> msg.applyOnServer(ctx)
                    else -> HexClone.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                HexClone.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexCloneMessageS2C -> msg.applyOnClient(ctx)
                    else -> HexClone.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
