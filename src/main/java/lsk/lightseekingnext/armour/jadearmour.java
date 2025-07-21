package lsk.lightseekingnext.armour;

import lsk.lightseekingnext.Lightseekingnext;
import lsk.lightseekingnext.moditems.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class jadearmour implements ArmorMaterial{
    public static final jadearmour INSTANCE = new jadearmour();
    @Override
    public int getDurability(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS -> 160;
            case LEGGINGS -> 300;
            case CHESTPLATE -> 380;
            case HELMET -> 180;
            default -> 0;
        };
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS, HELMET -> 3;
            case LEGGINGS -> 6;
            case CHESTPLATE -> 8;
            default -> 0;
        };
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.White_Jade);
    }

    @Override
    public String getName() {
        return "jade";
    }

    @Override
    public float getToughness() {
        return 1.5F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
