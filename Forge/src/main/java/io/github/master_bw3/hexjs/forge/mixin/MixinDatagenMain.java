package io.github.master_bw3.hexjs.forge.mixin;

import io.github.master_bw3.hexjs.HexJs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin(net.minecraft.data.Main.class)
public class MixinDatagenMain {
    @Inject(method = "main", at = @At("TAIL"), remap = false)
    private static void hexjs$systemExitAfterDatagenFinishes(String[] strings, CallbackInfo ci) {
        HexJs.LOGGER.info("Terminating datagen.");
        System.exit(0);
    }
}
