@file:JvmName("HexCloneAbstractionsImpl")

package gay.cass.hexclone.fabric

import gay.cass.hexclone.registry.HexCloneRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexCloneRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
