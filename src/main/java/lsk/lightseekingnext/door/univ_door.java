package lsk.lightseekingnext.door;


import lsk.lightseekingnext.moditems.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import lsk.lightseekingnext.blocks.silver_magma;
public class univ_door {
    public static void initialize(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(silver_magma.silver_magma)
                .lightWithItem(Items.ENDER_EYE)
                .destDimID(Identifier.of("lightseeking","univ"))
                .tintColor(45,65,101)
                .registerPortal();
    }
}
