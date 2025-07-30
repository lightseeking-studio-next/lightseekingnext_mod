package lsk.lightseekingnext.modtools;

import lsk.lightseekingnext.moditems.ModItems;
import lsk.lightseekingnext.armour.jadearmour;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class jadepickaxe {
    public static <T extends Item> T register(String path, T item) {
        // 对于 1.21 之前的版本，请将 ''Identifier.of'' 替换为 ''new Identifier''
        return Registry.register(Registries.ITEM,Identifier.of("lightseeking", path), item);
    }

    public static class JadeMaterial implements ToolMaterial {
        public static final JadeMaterial INSTANCE = new JadeMaterial();

        @Override
        public int getDurability() {
            return 400;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6.5F;
        }

        @Override
        public float getAttackDamage() {
            return 3.5F;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return BlockTags.INCORRECT_FOR_IRON_TOOL;
        }


        @Override
        public int getEnchantability() {
            return 13;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.Jade);
        }

    }


    public static class White_JadeMaterial implements ToolMaterial {
        public static final White_JadeMaterial INSTANCE = new White_JadeMaterial();

        @Override
        public int getDurability() {
            return 800;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 5.5F;
        }

        @Override
        public float getAttackDamage() {
            return 8.5F;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }


        @Override
        public int getEnchantability() {
            return 13;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.Jade);
        }

    }



    //物品注册开始
  public static final Item JADE_SWORD = register("jade_sword",new SwordItem(JadeMaterial.INSTANCE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,3,-2.4f))));
  public static final Item JADE_PICKAXE = register("jade_pickaxe",new PickaxeItem(JadeMaterial.INSTANCE, new Item.Settings()));
  public static final Item JADE_AXE = register("jade_axe",new AxeItem(JadeMaterial.INSTANCE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON,4.5f,-3.2f))));
  public static final Item JADE_SHOVEL = register("jade_shovel",new ShovelItem(JadeMaterial.INSTANCE, new Item.Settings()));
  public static final Item JADE_HOE = register("jade_hoe",new HoeItem(JadeMaterial.INSTANCE, new Item.Settings()));


  public static final Item WHITE_JADE_SWORD = register("white_jade_sword",new SwordItem(White_JadeMaterial.INSTANCE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND,4,-2.4f))));
  public static final Item WHITE_JADE_PICKAXE = register("white_jade_pickaxe",new PickaxeItem(White_JadeMaterial.INSTANCE, new Item.Settings()));
  public static final Item WHITE_JADE_AXE = register("white_jade_axe",new AxeItem(White_JadeMaterial.INSTANCE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND,5.5F,-3.2f))));
  public static final Item WHITE_JADE_SHOVEL = register("white_jade_shovel",new ShovelItem(White_JadeMaterial.INSTANCE, new Item.Settings()));
  public static final Item WHITE_JADE_HOE = register("white_jade_hoe",new HoeItem(White_JadeMaterial.INSTANCE, new Item.Settings()));


  //盔甲串门注册，找不到地方放了
  public static final Item JADE_HELMET = register("jade_helmet",new ArmorItem(jadearmour.jadearmour, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(180)));
    public static final Item JADE_BOOTS = register("jade_boots",new ArmorItem(jadearmour.jadearmour, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(270)));
    public static final Item JADE_LEGGINGS = register("jade_leggings",new ArmorItem(jadearmour.jadearmour, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(260)));
    public static final Item JADE_CHESTPLATE = register("jade_chestplate",new ArmorItem(jadearmour.jadearmour, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(210)));
    public static void initialize() {
  }

}
