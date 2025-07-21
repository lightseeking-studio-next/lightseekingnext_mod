package lsk.lightseekingnext;
import lsk.lightseekingnext.blocks.jadeblocks;
import lsk.lightseekingnext.groups.items;
import lsk.lightseekingnext.moditems.ModItems;
import lsk.lightseekingnext.moditems.silver_magma_item;
import lsk.lightseekingnext.modtools.jadepickaxe;
import lsk.lightseekingnext.blocks.silver_magma;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lightseekingnext implements ModInitializer {
    public static final String MOD_ID = "lightseeking";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final RegistryKey<PlacedFeature> JADE_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("lightseeking","jade"));//矿物注册
    public static final RegistryKey<PlacedFeature> SILVER_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("lightseeking","silver_magma"));//矿物注册

    @Override
    public void onInitialize() {
        LOGGER.info("寻光模组测试");
        ModItems.initialize();
        items.initialize();
        jadepickaxe.initialize();
        jadeblocks.initialize();
      //jade
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, JADE_KEY);
        silver_magma.initialize();
        //silver
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SILVER_KEY);
        silver_magma_item.initialize();

        silver_magma_item.initialize();
    }
}
