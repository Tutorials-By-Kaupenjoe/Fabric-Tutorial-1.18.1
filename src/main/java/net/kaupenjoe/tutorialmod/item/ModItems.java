package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.fluid.ModFluids;
import net.kaupenjoe.tutorialmod.item.custom.*;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));


    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(16)));

    public static final Item LILAC_FLOWER_BULB = registerItem("lilac_flower_bulb",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item GRAPE = registerItem("grape",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE)));

    public static final Item MYTHRIL_SWORD = registerItem("mythril_sword",
            new ModSlownessSwordItem(ModToolMaterials.MYTHRIL, 1, 2f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_AXE = registerItem("mythril_axe",
            new ModAxeItem(ModToolMaterials.MYTHRIL, 3, 1f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_HOE = registerItem("mythril_hoe",
            new ModHoeItem(ModToolMaterials.MYTHRIL, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_SHOVEL = registerItem("mythril_shovel",
            new ShovelItem(ModToolMaterials.MYTHRIL, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_PICKAXE = registerItem("mythril_pickaxe",
            new ModPickaxeItem(ModToolMaterials.MYTHRIL, 1, 0f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MYTHRIL_HELMET = registerItem("mythril_helmet",
            new ModArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_CHESTPLATE = registerItem("mythril_chestplate",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_LEGGINGS = registerItem("mythril_leggings",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_BOOTS = registerItem("mythril_boots",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item MAGIC_MYTHRIL_DUST = registerItem("magic_mythril_dust",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static final Item DATA_TABLET = registerItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));

    public static final Item GRAPE_SEEDS = registerItem("grape_seeds",
            new AliasedBlockItem(ModBlocks.GRAPE_VINE, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));


    public static final Item KAUPENBOW = registerItem("kaupenbow",
            new BowItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(640)));

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new ModMusicDiscItem(7, ModSounds.BAR_BRAWL,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));


    public static final Item MYTHRIL_STAFF = registerItem("mythril_staff",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));

    public static final Item JACARANDA_SIGN = registerItem("jacaranda_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(16),
                    ModBlocks.JACARANDA_SIGN_BLOCK, ModBlocks.JACARANDA_WALL_SIGN_BLOCK));

    public static final Item HONEY_BUCKET = registerItem("honey_bucket",
            new BucketItem(ModFluids.HONEY_STILL, new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));


    public static final Item RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg",
            new SpawnEggItem(ModEntities.RACCOON,0x948e8d, 0x3b3635,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
