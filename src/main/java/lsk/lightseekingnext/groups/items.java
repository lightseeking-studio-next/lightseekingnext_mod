package lsk.lightseekingnext.groups;

import lsk.lightseekingnext.Lightseekingnext;
import lsk.lightseekingnext.blocks.jadeblocks;
import lsk.lightseekingnext.moditems.ModItems;
import lsk.lightseekingnext.modtools.jadepickaxe;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import lsk.lightseekingnext.blocks.silver_magma;

import static lsk.lightseekingnext.moditems.silver_magma_item.silver_magma_item;

public class items {

    public static final RegistryKey<ItemGroup> Lsk_Items_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Lightseekingnext.MOD_ID, "item_group"));
    public static final ItemGroup LskItems = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.Jade))
            .displayName(Text.translatable("lightseeking.items"))
            .entries((context, entries) -> {
                entries.add(ModItems.Jade);
                entries.add(jadeblocks.jade_block_mineral);
                entries.add(jadepickaxe.JADE_SWORD);
                entries.add(jadepickaxe.JADE_AXE);
                entries.add(jadepickaxe.JADE_PICKAXE);
                entries.add(jadepickaxe.JADE_HOE);
                entries.add(jadepickaxe.JADE_SHOVEL);
                entries.add(ModItems.White_Jade);
                entries.add(jadeblocks.white_jade_block_mineral);
                entries.add(jadepickaxe.WHITE_JADE_SWORD);
                entries.add(jadepickaxe.WHITE_JADE_AXE);
                entries.add(jadepickaxe.WHITE_JADE_PICKAXE);
                entries.add(jadepickaxe.WHITE_JADE_HOE);
                entries.add(jadepickaxe.WHITE_JADE_SHOVEL);
                entries.add(jadepickaxe.JADE_HELMET);
                entries.add(jadepickaxe.JADE_CHESTPLATE);
                entries.add(jadepickaxe.JADE_LEGGINGS);
                entries.add(jadepickaxe.JADE_BOOTS);
                entries.add(silver_magma.silver_magma);
                entries.add(silver_magma_item);
            })
            .build();




    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, Lsk_Items_KEY, LskItems);
    }


}
