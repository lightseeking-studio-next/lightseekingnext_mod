package lsk.lightseekingnext.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import java.util.function.ToIntFunction;
public class silver_magma {

    public static int getLuminance(BlockState currentBlockState) {
        // Get the value of the "activated" property.
       // boolean activated = currentBlockState.get(PrismarineLampBlock.ACTIVATED);

        // Return a light level if activated = true
        return  7;
    }


    private static <T extends Block> T register(String path, T block) {
        Registry.register(Registries.BLOCK,Identifier.of("lightseeking", path), block);
        Registry.register(Registries.ITEM, Identifier.of("lightseeking", path), new BlockItem(block, new Item.Settings()));
        return block;
    }
//方块声明开始
    /*
    public static final Block silver_magma = register("silver_magma",new Block(Block.Settings.create().strength(2.5f).requiresTool().luminance(getLuminance(new ToIntFunction<BlockState>() {
    @Override
    public int applyAsInt(BlockState state) {
        return 7;
    }))));

*/
public static final Block silver_magma = register(
        "silver_magma",
        new Block(
                Block.Settings.create()
                        .strength(2.5f)
                        .requiresTool()
                        .luminance(new ToIntFunction<BlockState>() {
                            @Override
                            public int applyAsInt(BlockState state) {
                                return 7;//定义亮度
                            }
                        })
        )
);

    public static void initialize() {
    }
}
