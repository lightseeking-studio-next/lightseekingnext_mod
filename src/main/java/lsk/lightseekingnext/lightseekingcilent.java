package lsk.lightseekingnext;

import lsk.lightseekingnext.cilent.renderer.survivorrenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class lightseekingcilent implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Lightseekingnext.SURVIVOR, (dispatcher) -> {
            return new survivorrenderer(dispatcher);
        });
    }
}

