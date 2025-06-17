@file:JvmName("HexCloneAbstractions")

package gay.cass.hexclone

import dev.architectury.injectables.annotations.ExpectPlatform
import gay.cass.hexclone.registry.HexCloneRegistrar

fun initRegistries(vararg registries: HexCloneRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexCloneRegistrar<T>) {
    throw AssertionError()
}
