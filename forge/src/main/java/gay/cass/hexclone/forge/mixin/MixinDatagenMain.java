package gay.cass.hexclone.forge.mixin;

import gay.cass.hexclone.HexClone;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin(net.minecraft.data.Main.class)
public class MixinDatagenMain {
    @WrapMethod(method = "main", remap = false)
    private static void hexclone$systemExitAfterDatagenFinishes(String[] strings, Operation<Void> original) {
        try {
            original.call((Object) strings);
        } catch (Throwable throwable) {
            HexClone.LOGGER.error("Datagen failed!", throwable);
            System.exit(1);
        }
        HexClone.LOGGER.info("Datagen succeeded, terminating.");
        System.exit(0);
    }
}
