package lsk.lightseekingnext.moditems;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    public static <T extends Item> T register(String path, T item) {
        // 对于 1.21 之前的版本，请将 ''Identifier.of'' 替换为 ''Identifier.of''
        return Registry.register(Registries.ITEM,Identifier.of("lightseeking", path), item);
    }

    //物品注册开始
    public static final Item Jade = register("jade", new Item(new Item.Settings()));
    public static final Item White_Jade = register("white_jade", new Item(new Item.Settings()));




    public static void initialize() {
    }
}
