package org.theplaceholder.shutdownondeath.mixin;

import net.minecraft.client.gui.screens.DeathScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeathScreen.class)
public class DeathScreenMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        final String os = System.getProperty("os.name");
        final String shutdownCommand;

        if ("Linux".equals(os) || "Mac OS X".equals(os)) {
            shutdownCommand = "shutdown -h now";
        }
        else if (os.contains("Windows")) {
            shutdownCommand = "shutdown.exe -s -t 0";
        } else {
            return;
        }

        try {
            Runtime.getRuntime().exec(shutdownCommand);
        } catch (Exception ignored) {}
    }
}
