package lsk.lightseekingnext.door;


import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class syo_door {
    public static void initialize(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.DIAMOND_BLOCK)
                .lightWithItem(Items.ENDER_EYE)
                .destDimID(Identifier.of("lightseeking","skyopening"))
                .tintColor(45,65,101)
                .registerPortal();
    }
}
