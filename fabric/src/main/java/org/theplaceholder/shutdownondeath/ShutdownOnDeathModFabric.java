package org.theplaceholder.shutdownondeath;

import net.fabricmc.api.ModInitializer;

public class ShutdownOnDeathModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        new ShutDownOnDeathMod();
    }
}
