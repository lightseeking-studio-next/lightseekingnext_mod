package lsk.lightseekingnext.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class jadeblocks {

    private static <T extends Block> T register(String path, T block) {
        Registry.register(Registries.BLOCK,new Identifier("lightseeking", path), block);
        Registry.register(Registries.ITEM, new Identifier("lightseeking", path), new BlockItem(block, new Item.Settings()));
        return block;
    }
//方块声明开始
    public static final Block jade_block_mineral = register("jade_block_mineral",new Block(Block.Settings.create().strength(2.5f).requiresTool()));
    public static final Block white_jade_block_mineral = register("white_jade_block_mineral",new Block(Block.Settings.create().strength(2.5f).requiresTool()));



    public static void initialize() {
        //Registry.register(Registries.ITEM, new Identifier("lightseeking", "jade_block_mineral"), new BlockItem(jade_block_mineral, new FabricItemSettings()));
    }
}
