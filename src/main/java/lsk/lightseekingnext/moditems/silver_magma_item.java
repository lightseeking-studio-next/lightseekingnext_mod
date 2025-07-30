package lsk.lightseekingnext.moditems;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class silver_magma_item {


    public static <T extends Item> T register(String path, T item) {
        return Registry.register(Registries.ITEM,Identifier.of("lightseeking", path), item);
    }

    //物品注册开始
    public static final Item silver_magma_item = register("silver_magma_item", new Item(new Item.Settings()));
    public static void initialize() {
    }
}
