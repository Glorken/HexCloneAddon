package gay.cass.hexclone.networking

import dev.architectury.networking.NetworkChannel
import gay.cass.hexclone.HexClone
import gay.cass.hexclone.networking.msg.HexCloneMessageCompanion

object HexCloneNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(HexClone.id("networking_channel"))

    fun init() {
        for (subclass in HexCloneMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
